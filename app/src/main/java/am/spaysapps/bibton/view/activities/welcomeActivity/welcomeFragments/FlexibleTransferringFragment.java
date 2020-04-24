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

public class FlexibleTransferringFragment extends Fragment implements View.OnClickListener {

    private View main_view;
    private ImageButton gotToProfitableExchangeFragment;
    private ChangeFragments changeFragments;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main_view = inflater.inflate(R.layout.flexible_transfer_fragment, container, false);
        init();
        setAnimation();
        gotToProfitableExchangeFragment();
        return main_view;
    }


    private void init() {

        gotToProfitableExchangeFragment = main_view.findViewById(R.id.gotToProfitableExchangeFragment);
        changeFragments = new ChangeFragments(context, main_view, this);
    }

    private void gotToProfitableExchangeFragment() {
        gotToProfitableExchangeFragment.setOnClickListener(v -> changeFragments.replaceFragment(new ProfitableExchangeFragment(), false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void setAnimation() {
        LottieAnimationView lottieAnimationView = main_view.findViewById(R.id.lottie_animation_flexible);
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
