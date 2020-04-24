package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.forgetPassCodeFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import javax.inject.Inject;

import am.spaysapps.bibton.Bibton;
import am.spaysapps.bibton.R;
import am.spaysapps.bibton.presenter.ForgetPassCodePresenter;
import am.spaysapps.bibton.shared.utils.ChangeFragments;
import am.spaysapps.bibton.shared.utils.CheckActivenessOvalIcons;
import am.spaysapps.bibton.shared.utils.Constants;
import am.spaysapps.bibton.view.activities.homeActivity.HomeActivity;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.createPassCodeFragment.CreatePassCodeFragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ForgetPassCodeFragment extends Fragment implements View.OnClickListener, IForgetPassCodeFragment {
    private View mainView;
    private CheckActivenessOvalIcons checkActivenessOvalButtons;
    private Context context;
    private ImageView backToCreatePassCodeFragment;
    private ChangeFragments changeFragments;
    @Inject
    ForgetPassCodePresenter forgetPassCodePresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.forget_pass_code_layout, container, false);
        Bibton.getInstance().getAuthorizationComponent().inject(this);
        forgetPassCodePresenter.onViewCreated(this);

        init();
        goToCreatePassCodeFragment();

        return mainView;
    }

    private void init() {
        mainView.findViewById(R.id.t9_key_1).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_2).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_3).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_4).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_5).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_6).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_7).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_8).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_9).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_0).setOnClickListener(this);
        mainView.findViewById(R.id.t9_key_backspace).setOnClickListener(this);
        backToCreatePassCodeFragment = mainView.findViewById(R.id.backToCreatePassCodeFragment);
        checkActivenessOvalButtons = new CheckActivenessOvalIcons(context, mainView);
        changeFragments = new ChangeFragments(context, mainView, this);
    }

    @Override
    public void onDestroy() {
        forgetPassCodePresenter.stopSubscriptions();
        super.onDestroy();
    }

    private int char_count = 0;

    private void goToYouAreDoneFragment(int passCodeCount) {
        if (passCodeCount == 6) {
            forgetPassCodePresenter.forgetPassCodeResponse(Constants.UNIQUE_ID, "123456");


        }

    }

    private void goToCreatePassCodeFragment() {
        backToCreatePassCodeFragment.setOnClickListener(v -> {
            changeFragments.replaceFragment(new CreatePassCodeFragment(), true);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        v.getId();
        if (v.getTag() != null && "number_button".equals(v.getTag()) && char_count != 6) {
            char_count++;
            goToYouAreDoneFragment(char_count);
            checkActivenessOvalButtons.checkActivenessOvalButtons(char_count);
            return;

        }
        switch (v.getId()) {
            case R.id.t9_key_backspace: {
                if (char_count != 0) {
                    char_count--;
                    checkActivenessOvalButtons.checkActivenessOvalButtons(char_count);
                }
            }
            break;
        }
    }

    private String user_token;

    @Override
    public void getToken(String token) {
        user_token = token;
        Constants.TOKEN = user_token;
        if (user_token != null) {
            Toast.makeText(context, "Password have changed successfully", Toast.LENGTH_SHORT).show();
            Intent goToHomeActivityIntent = new Intent(context, HomeActivity.class);
            context.startActivity(goToHomeActivityIntent);
        }
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
}
