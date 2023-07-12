package com.taobao.weex.ui.view.refresh.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRefreshView extends FrameLayout {
    private CircleProgressBar circleProgressBar;
    private LinearLayout linearLayout;

    public WXRefreshView(Context context) {
        super(context);
        setupViews();
    }

    private void setupViews() {
        this.linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.linearLayout.setOrientation(1);
        this.linearLayout.setGravity(17);
        addView(this.linearLayout, layoutParams);
    }

    public void setContentGravity(int i) {
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            linearLayout.setGravity(i);
        }
    }

    public void setProgressBgColor(int i) {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setBackgroundColor(i);
        }
    }

    public void setProgressColor(int i) {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setColorSchemeColors(i);
        }
    }

    public void setProgressRotation(float f) {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setProgressRotation(f);
        }
    }

    public void setRefreshView(final View view) {
        if (view == null) {
            return;
        }
        post(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.view.refresh.core.WXRefreshView.1
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i >= viewGroup.getChildCount()) {
                        WXRefreshView.this.linearLayout.addView(view2);
                        return;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof CircleProgressBar) {
                        WXRefreshView.this.circleProgressBar = (CircleProgressBar) childAt;
                    }
                    i++;
                }
            }
        }));
    }

    public void setStartEndTrim(float f, float f2) {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.setStartEndTrim(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAnimation() {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopAnimation() {
        CircleProgressBar circleProgressBar = this.circleProgressBar;
        if (circleProgressBar != null) {
            circleProgressBar.stop();
        }
    }

    public WXRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews();
    }

    public WXRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupViews();
    }
}
