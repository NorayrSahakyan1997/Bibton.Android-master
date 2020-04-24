package am.spaysapps.bibton.shared.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.media.Image;
import android.widget.ImageView;

import am.spaysapps.bibton.R;

public class ChangeColorsTabBar {


    public static void changeColorsOfTabs(Context context, ImageView homeIcon, ImageView alaytics_icon, ImageView transfers_icon, ImageView cardsICon, ImageView moreIcon, int id) {
        if (id == 0) {
            homeIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.pass_code_active), PorterDuff.Mode.SRC_ATOP);
            alaytics_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            transfers_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            cardsICon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            moreIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
        }
        if (id == 1) {
            homeIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            alaytics_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.pass_code_active), PorterDuff.Mode.SRC_ATOP);
            transfers_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            cardsICon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            moreIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
        }
        if (id == 2) {
            homeIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            alaytics_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            transfers_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.pass_code_active), PorterDuff.Mode.SRC_ATOP);
            cardsICon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            moreIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
        }
        if (id == 3) {
            homeIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            alaytics_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            transfers_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            cardsICon.getDrawable().setColorFilter(context.getResources().getColor(R.color.pass_code_active), PorterDuff.Mode.SRC_ATOP);
            moreIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
        }
        if (id == 4) {
            homeIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            alaytics_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            transfers_icon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            cardsICon.getDrawable().setColorFilter(context.getResources().getColor(R.color.inactive_text_color_tab), PorterDuff.Mode.SRC_ATOP);
            moreIcon.getDrawable().setColorFilter(context.getResources().getColor(R.color.pass_code_active), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
