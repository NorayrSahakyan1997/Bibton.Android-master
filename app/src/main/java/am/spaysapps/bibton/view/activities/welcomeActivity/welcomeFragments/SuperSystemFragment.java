package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.airbnb.lottie.LottieAnimationView;
import am.spaysapps.bibton.R;
import am.spaysapps.bibton.shared.utils.ChangeFragments;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment.PhoneNumberFragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SuperSystemFragment extends Fragment implements View.OnClickListener {
    private View mainView;
    private Context context;
    private ImageButton goToPhoneNumberFragment;
    private ChangeFragments changeFragments;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.super_system_fragment, container, false);
        init();
        setAnimation();
        goToPhoneNumberFragment();
        return mainView;
    }

    private void init() {
        goToPhoneNumberFragment = mainView.findViewById(R.id.goToPhoneNumberFragment);
        changeFragments = new ChangeFragments(context, mainView, this);
    }

    private void goToPhoneNumberFragment() {
        goToPhoneNumberFragment.setOnClickListener(v -> changeFragments.replaceFragment(new PhoneNumberFragment(), false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void setAnimation() {
        LottieAnimationView lottieAnimationView = mainView.findViewById(R.id.lottie_animation_super_system);
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

    @Override
    public void onClick(View v) {

    }
}
