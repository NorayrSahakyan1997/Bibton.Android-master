package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import am.spaysapps.bibton.R;
import am.spaysapps.bibton.view.activities.homeActivity.HomeActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class YouAreDoneFragment extends Fragment {
    private View mainView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.you_are_done_fragment, container, false);
        setAnimation();
        return mainView;
    }

    private void setAnimation() {
        LottieAnimationView lottieAnimationView = mainView.findViewById(R.id.lottie_animation_splash);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(getContext(), HomeActivity.class);

                startActivity(intent);
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
