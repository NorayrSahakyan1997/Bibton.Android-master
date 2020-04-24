package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import am.spaysapps.bibton.shared.utils.ChangeFragments;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.airbnb.lottie.LottieAnimationView;
import am.spaysapps.bibton.R;


public class ModernUserFragment extends Fragment implements View.OnClickListener {
    private View mainVew;
    private ImageButton goToSuperSystemFragment;
    private Context context;
    private ChangeFragments changeFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainVew = inflater.inflate(R.layout.modern_user_fragment, container, false);
        init();
        setAnimation();
        goToSuperSystemFragment();
        return mainVew;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void init() {

        goToSuperSystemFragment = mainVew.findViewById(R.id.goToSuperSystemFragment);
        changeFragments = new ChangeFragments(context, mainVew, this);
    }

    private void goToSuperSystemFragment() {
        goToSuperSystemFragment.setOnClickListener(v -> changeFragments.replaceFragment(new SuperSystemFragment(), false));
    }

    private void setAnimation() {
        LottieAnimationView lottieAnimationView = mainVew.findViewById(R.id.lottie_animation_modern_user);
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
