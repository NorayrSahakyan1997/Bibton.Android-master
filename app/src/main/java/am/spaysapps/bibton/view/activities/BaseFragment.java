package am.spaysapps.bibton.view.activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment implements IBaseView {

    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        }
    }

    protected void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            if (!(view instanceof AdapterView))
                ((ViewGroup) view).removeAllViews();
        }
    }

    @Override
    public void onError(String errorMessage) {
        if (mActivity != null) {
            mActivity.onError(errorMessage);
        }
    }

    @Override
    public void showServerError() {
        if (mActivity != null) {
            mActivity.showServerError();
        }
    }

    @Override
    public void showNetworkError() {
        if (mActivity != null) {
            mActivity.showNetworkError();
        }
    }
}