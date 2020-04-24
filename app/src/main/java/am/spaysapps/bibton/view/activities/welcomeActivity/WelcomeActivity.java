package am.spaysapps.bibton.view.activities.welcomeActivity;


import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import am.spaysapps.bibton.view.activities.homeActivity.HomeActivity;
import am.spaysapps.bibton.view.activities.homeActivity.homeFragments.homeFragment.HomeFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.FlexibleTransferringFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment.PhoneNumberFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.airbnb.lottie.LottieAnimationView;
import am.spaysapps.bibton.R;

public class WelcomeActivity extends AppCompatActivity {

    private Handler handler;
    private int waitTime = 2000;
    private FrameLayout frameLayout_welcome;
    private Fragment currentFragment = null;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private int current_fragment_number;
    private FrameLayout frameLayout;
    private ImageButton skip_button;
    private PhoneNumberFragment phoneNumberFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //loteAnimation();
        //init();
        enterHomeActivity();

        //setFragments();

    }

    public void init() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayoutWelcome);
        phoneNumberFragment = new PhoneNumberFragment();
        handler = new Handler();
    }


    public void setFragments() {
        fragmentManager = getSupportFragmentManager();
        //currentFragment = new BibtonSignFragment();
        currentFragment = new PhoneNumberFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayoutWelcome, currentFragment);
        fragmentTransaction.commit();
    }


    private FragmentTransaction transaction;

    public void replaceFragment(Fragment fragment, boolean backAnim) {
        transaction = getSupportFragmentManager().beginTransaction();

        if (backAnim) {
            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        } else {
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }
        transaction.remove(currentFragment);
        currentFragment = fragment;
        transaction.replace(R.id.frameLayoutWelcome, currentFragment);
        transaction.commit();
    }

    public void enterHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }

    public void loteAnimation() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie_animation_splash);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                lottieAnimationView.setVisibility(View.INVISIBLE);
                replaceFragment(new FlexibleTransferringFragment(), false);
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
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }
}
