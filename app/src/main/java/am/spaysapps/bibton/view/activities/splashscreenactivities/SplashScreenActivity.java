package am.spaysapps.bibton.view.activities.splashscreenactivities;

import android.content.Intent;
import android.os.Bundle;

import am.spaysapps.bibton.view.activities.welcomeActivity.WelcomeActivity;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
