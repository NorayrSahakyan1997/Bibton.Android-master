package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments;

import android.animation.Animator;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import am.spaysapps.bibton.R;

public class BibtonSignFragment extends Fragment {
    private View main_view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        main_view = inflater.inflate(R.layout.bibton_sign_fragment, container, false);
        setAnimation();
        return main_view;

    }
    private void setAnimation() {
        LottieAnimationView lottieAnimationView = main_view.findViewById(R.id.lottie_animation_splash);
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
}
