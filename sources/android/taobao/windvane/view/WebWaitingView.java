package android.taobao.windvane.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.taobao.windvane.util.EnvUtil;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.a;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WebWaitingView extends RelativeLayout {
    private static final int LOADING_BG_ID = 101;
    private static final int LOADING_PGBAR_ID = 102;

    public WebWaitingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(16)
    private void init(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = 20.0f * f;
        View view = new View(context);
        view.setId(101);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setAlpha(150);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(gradientDrawable);
        } else {
            view.setBackgroundDrawable(gradientDrawable);
        }
        int i = (int) (f * 120.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13);
        addView(view, layoutParams);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setId(102);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(6, 101);
        layoutParams2.topMargin = ((int) f2) + 10;
        addView(progressBar, layoutParams2);
        TextView textView = new TextView(context);
        textView.setText(EnvUtil.isCN() ? a.i : "Loading");
        textView.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 102);
        addView(textView, layoutParams3);
    }

    public WebWaitingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WebWaitingView(Context context) {
        super(context);
        init(context);
    }
}
