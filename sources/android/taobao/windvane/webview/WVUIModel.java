package android.taobao.windvane.webview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVContextUtil;
import android.taobao.windvane.view.AbstractNaviBar;
import android.taobao.windvane.view.WebErrorView;
import android.taobao.windvane.view.WebWaitingView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVUIModel {
    private static final String TAG = "WVUIModel";
    private LinearLayout errorLayout;
    private Context mContext;
    private View mView;
    private View loadingView = null;
    private View errorView = null;
    private AbstractNaviBar naviBar = null;
    private TextView mWarningView = null;
    private boolean showLoading = false;
    private boolean cancelNoti = true;
    private AtomicBoolean isError = new AtomicBoolean(false);
    private boolean errorShow = false;

    public WVUIModel(Context context, View view) {
        this.mContext = context;
        this.mView = view;
        this.errorLayout = new LinearLayout(context);
    }

    private void setNotiView(Drawable drawable, String str, int i) {
        if (WVContextUtil.getRealContext(this.mContext) instanceof Activity) {
            TextView textView = new TextView(this.mContext);
            this.mWarningView = textView;
            textView.setTextColor(Color.parseColor("#666666"));
            this.mWarningView.setBackgroundColor(Color.parseColor("#ffe7b3"));
            this.mWarningView.setText(str);
            this.mWarningView.setTextAlignment(4);
            this.mWarningView.setGravity(16);
            ViewParent parent = this.mWarningView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.mWarningView);
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mWarningView.setCompoundDrawables(drawable, null, null, null);
                int i2 = i / 10;
                this.mWarningView.setCompoundDrawablePadding(i2);
                this.mWarningView.setPadding(i2, 0, 0, 0);
            }
            try {
                this.mWarningView.setElevation(2.0f);
            } catch (Throwable unused) {
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, i);
            ViewParent parent2 = this.mView.getParent();
            if (parent2 != null) {
                try {
                    ((ViewGroup) parent2).addView(this.mWarningView, layoutParams);
                    return;
                } catch (Exception unused2) {
                    ViewParent parent3 = parent2.getParent();
                    if (parent3 != null) {
                        ((ViewGroup) parent3).addView(this.mWarningView, layoutParams);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        throw new RuntimeException("context can not be application");
    }

    public void disableShowLoading() {
        this.showLoading = false;
    }

    public void enableShowLoading() {
        this.showLoading = true;
    }

    public View getErrorView() {
        if (WVContextUtil.getRealContext(this.mContext) instanceof Activity) {
            if (this.errorView == null) {
                setErrorView(new WebErrorView(this.mContext));
            }
            return this.errorView;
        }
        throw new RuntimeException("context can not be application");
    }

    public void hideErrorPage() {
        LinearLayout linearLayout = this.errorLayout;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.errorLayout.setVisibility(8);
        this.errorShow = false;
    }

    public void hideLoadingView() {
        View view = this.loadingView;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.loadingView.setVisibility(8);
    }

    public void hideNaviBar() {
        AbstractNaviBar abstractNaviBar = this.naviBar;
        if (abstractNaviBar == null || abstractNaviBar.getVisibility() == 8) {
            return;
        }
        this.naviBar.setVisibility(8);
    }

    public boolean isErrorShow() {
        return this.errorShow;
    }

    public boolean isShowLoading() {
        return this.showLoading;
    }

    public void loadErrorPage() {
        if (!(this.mContext instanceof Activity)) {
            TaoLog.e(TAG, "context can not be application");
            return;
        }
        if (this.errorView == null) {
            WebErrorView webErrorView = new WebErrorView(this.mContext);
            this.errorView = webErrorView;
            setErrorView(webErrorView);
        }
        this.errorLayout.bringToFront();
        if (this.errorLayout.getVisibility() != 0) {
            this.errorLayout.setVisibility(0);
            this.errorShow = true;
        }
    }

    public void resetNaviBar() {
        AbstractNaviBar abstractNaviBar = this.naviBar;
        if (abstractNaviBar != null) {
            abstractNaviBar.resetState();
        }
    }

    public void setErrorView(View view) {
        if (view == null || !this.isError.compareAndSet(false, true)) {
            return;
        }
        this.errorView = view;
        this.errorLayout.setVisibility(8);
        ViewParent parent = this.errorView.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.errorView);
        }
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(14, 1);
        }
        this.errorLayout.addView(this.errorView, layoutParams);
        this.errorLayout.setBackgroundColor(-1);
        this.errorLayout.setAlpha(1.0f);
        ViewParent parent2 = this.mView.getParent();
        if (parent2 != null) {
            try {
                if (this.errorLayout.getParent() == null) {
                    ((ViewGroup) parent2).addView(this.errorLayout, layoutParams);
                }
                this.isError.set(false);
            } catch (Exception unused) {
                ViewParent parent3 = parent2.getParent();
                if (parent3 != null && this.errorLayout.getParent() == null) {
                    ((ViewGroup) parent3).addView(this.errorLayout, layoutParams);
                }
                this.isError.set(false);
            }
        }
    }

    public void setLoadingView(View view) {
        if (view != null) {
            this.loadingView = view;
            view.setVisibility(8);
            ViewParent parent = this.loadingView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.loadingView);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent2 = this.mView.getParent();
            if (parent2 != null) {
                try {
                    ((ViewGroup) parent2).addView(this.loadingView, layoutParams);
                } catch (Exception unused) {
                    ViewParent parent3 = parent2.getParent();
                    if (parent3 != null) {
                        ((ViewGroup) parent3).addView(this.loadingView, layoutParams);
                    }
                }
            }
        }
    }

    public void setNaviBar(AbstractNaviBar abstractNaviBar) {
        AbstractNaviBar abstractNaviBar2 = this.naviBar;
        if (abstractNaviBar2 != null) {
            abstractNaviBar2.setVisibility(8);
            this.naviBar = null;
        }
        if (abstractNaviBar != null) {
            this.naviBar = abstractNaviBar;
        }
    }

    public void showLoadingView() {
        if (!(this.mContext instanceof Activity)) {
            TaoLog.e(TAG, "context can not be application");
            return;
        }
        if (this.loadingView == null) {
            WebWaitingView webWaitingView = new WebWaitingView(this.mContext);
            this.loadingView = webWaitingView;
            setLoadingView(webWaitingView);
        }
        this.loadingView.bringToFront();
        if (this.loadingView.getVisibility() != 0) {
            this.loadingView.setVisibility(0);
        }
    }

    public void showNotiView(Drawable drawable, String str, int i) {
        TextView textView = this.mWarningView;
        if (textView == null || (str != null && !str.equals(textView.getText()))) {
            setNotiView(drawable, str, i);
        }
        this.mWarningView.bringToFront();
        this.mWarningView.setTranslationY(0.0f);
        float f = -i;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mWarningView, "translationY", f, 0.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(1000L);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mWarningView, "translationY", 0.0f, f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2).after(6000L);
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: android.taobao.windvane.webview.WVUIModel.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (WVUIModel.this.mWarningView != null) {
                    ViewParent parent = WVUIModel.this.mWarningView.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(WVUIModel.this.mWarningView);
                    }
                    WVUIModel.this.mWarningView = null;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (WVUIModel.this.mWarningView != null) {
                    ViewParent parent = WVUIModel.this.mWarningView.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(WVUIModel.this.mWarningView);
                    }
                    WVUIModel.this.mWarningView = null;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
        this.mWarningView.setOnClickListener(new View.OnClickListener() { // from class: android.taobao.windvane.webview.WVUIModel.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUIModel.this.cancelNoti) {
                    animatorSet.cancel();
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.play(ofFloat2);
                    animatorSet2.start();
                    WVUIModel.this.cancelNoti = false;
                }
            }
        });
    }

    public void switchNaviBar(int i) {
        AbstractNaviBar abstractNaviBar = this.naviBar;
        if (abstractNaviBar == null || i != 1) {
            return;
        }
        abstractNaviBar.startLoading();
    }
}
