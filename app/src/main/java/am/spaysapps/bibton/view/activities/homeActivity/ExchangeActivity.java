package am.spaysapps.bibton.view.activities.homeActivity;

import am.spaysapps.bibton.R;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;

public class ExchangeActivity extends AppCompatActivity {
    private EditText convert_first_value;
    private EditText conver_second_valuel;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        pendingTransaction();
        init();
        setFocusibilityEditTexts();
        hideSoftKeyboard();
    }

    private void init() {
        convert_first_value = findViewById(R.id.convert_first_value);
        conver_second_valuel = findViewById(R.id.convert_second_value);
        scrollView=findViewById(R.id.scroll_view_exchange);
    }

    private void setFocusibilityEditTexts() {
        convert_first_value.setFocusable(true);
        conver_second_valuel.setFocusable(true);
    }

    private void pendingTransaction() {
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
    }
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
    public void close_exchange_activity(View view){
        Intent closeExchangeActivity = new Intent(this,HomeActivity.class);
        startActivity(closeExchangeActivity);
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left);

    }
    public void scroll_activity(View view){
        scrollView.scrollTo(20, 40);    }


}
