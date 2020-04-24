package am.spaysapps.bibton.shared.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import am.spaysapps.bibton.R;

public class CheckActivenessOvalIcons {
    private Context context;
    private View mainView;
    private ImageView code_oval_1;
    private ImageView code_oval_2;
    private ImageView code_oval_3;
    private ImageView code_oval_4;
    private ImageView code_oval_5;
    private ImageView code_oval_6;

    public CheckActivenessOvalIcons(Context context, View mainView) {
        this.context = context;
        this.mainView = mainView;
        initViews();
    }
    private void initViews(){
        code_oval_1=mainView.findViewById(R.id.code_oval_1);
        code_oval_2=mainView.findViewById(R.id.code_oval_2);
        code_oval_3=mainView.findViewById(R.id.code_oval_3);
        code_oval_4=mainView.findViewById(R.id.code_oval_4);
        code_oval_5=mainView.findViewById(R.id.code_oval_5);
        code_oval_6=mainView.findViewById(R.id.code_oval_6);
    }

    public void checkActivenessOvalButtons(int ovalId) {
        if (ovalId == 0) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 1) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 2) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 3) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 4) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 5) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_inactive));
        }
        if (ovalId == 6) {
            code_oval_1.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_2.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_3.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_4.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_5.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
            code_oval_6.setBackground(context.getDrawable(R.drawable.shape_pass_code_oval_active));
        }

    }
}
