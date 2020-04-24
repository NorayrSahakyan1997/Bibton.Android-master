package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

import javax.inject.Inject;

import am.spaysapps.bibton.Bibton;
import am.spaysapps.bibton.R;
import am.spaysapps.bibton.presenter.PhoneNumberPresenter;
import am.spaysapps.bibton.shared.utils.ChangeFragments;
import am.spaysapps.bibton.shared.utils.CloseKeyBoard;
import am.spaysapps.bibton.shared.utils.Constants;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.countrySearchFragment.CountrySearchFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.inputCodeFragment.InputPhoneCodeFragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PhoneNumberFragment extends Fragment implements IPhoneNumberFragment, View.OnClickListener {


    @Inject
    PhoneNumberPresenter mPresenter;
    private View mainView;
    private TextView country_code_text_view;
    private ImageButton goToInputCode;
    private ChangeFragments changeFragments;
    private Context context;
    private EditText edit_text_phone_number;
    private String country_selected_code;
    //private String uniqueId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.phone_number_fragment, container, false);
        Bibton.getInstance().getAuthorizationComponent().inject(this);
        CloseKeyBoard.hideKeyboard(Objects.requireNonNull(getActivity()));
        init();
        goToInputCodeFragment();
        goToCountrySearchFragment();
        getCountrySelectedCode();

        return mainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setAnimation();

        super.onActivityCreated(savedInstanceState);
    }

    private void setAnimation() {
        LottieAnimationView lottieAnimationView = mainView.findViewById(R.id.lottie_animation_splash);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        lottieAnimationView.playAnimation();
    }

    private void init() {
        mPresenter.onViewCreated(this);
        mPresenter.getCountryCode();
        country_code_text_view = mainView.findViewById(R.id.country_code_text_view);
        goToInputCode = mainView.findViewById(R.id.goToInputCode);
        changeFragments = new ChangeFragments(context, mainView, this);
        goToInputCode.setOnClickListener(this);
        edit_text_phone_number = mainView.findViewById(R.id.edit_text_phone_number);

    }

    private void getCountrySelectedCode() {
        country_selected_code = Constants.COUNTRY_CODE;
        // country_selected_short_name = Constants.COUNTRY_SHORT_NAME;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void goToCountrySearchFragment() {
        country_code_text_view.setOnClickListener(v -> changeFragments.replaceFragment(new CountrySearchFragment(), false));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Bibton.getInstance().releaseAuthorizationComponent();
        mPresenter.stopSubscriptions();
    }

    private String phone_Number;

    private void goToInputCodeFragment() {
        goToInputCode.setOnClickListener(v -> {

            phone_Number = edit_text_phone_number.getText().toString();
            mPresenter.responseValidationPhoneNumber(Constants.COUNTRY_SHORT_NAME, phone_Number);

        });
    }

    @Override
    public void showCountryCode(String countryCode) {
        if (country_selected_code != null) {
            country_code_text_view.setText(country_selected_code);
        } else {
            country_code_text_view.setText(countryCode);
        }
    }

    @Override
    public void checkPhoneNumberValidation(Boolean message) {
        //private String country_selected_short_name;
        boolean phoneValid = message;
        if (phoneValid) {
            changeFragments.replaceFragment(new InputPhoneCodeFragment(), false);
        } else {
            Toast.makeText(context, "Check phone number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showUniqueID(String uniqueId) {
        Constants.UNIQUE_ID = uniqueId;

    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void showServerError() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void onClick(View v) {

    }
}
