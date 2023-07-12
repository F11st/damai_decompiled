package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taobao.android.dinamic.R$id;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class RefreshHeadView extends LinearLayout {
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_FOOTER_HORIZONTAL = 4;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_HEADER_HORIZONTAL = 3;
    private static Typeface sIconfont;
    private static int sReference;
    private TextView mArrow;
    private CustomProgressBar mProgressbar;
    private TextView mRefreshState;

    public RefreshHeadView(Context context, int i, View view, boolean z) {
        super(context);
        init(context, i, view, z);
    }

    private void init(Context context, int i, View view, boolean z) {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        if (view != null && z) {
            addView(view, layoutParams);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(0);
        linearLayout.setId(R$id.uik_refresh_header_view);
        linearLayout.setPadding(0, (int) (32.0f * f), 0, (int) (24.0f * f));
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        frameLayout.addView(textView, layoutParams2);
        this.mArrow = textView;
        textView.setIncludeFontPadding(false);
        this.mArrow.setTextColor(-6710887);
        this.mArrow.setText(i == 0 ? "" : getContext().getResources().getString(i));
        CustomProgressBar customProgressBar = new CustomProgressBar(context);
        int i2 = (int) (28.0f * f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, i2);
        layoutParams3.gravity = 16;
        frameLayout.addView(customProgressBar, layoutParams3);
        this.mProgressbar = customProgressBar;
        TextView textView2 = new TextView(context);
        textView2.setText("下拉刷新");
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-6710887);
        textView2.setMaxLines(3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((int) (100.0f * f), -2);
        layoutParams4.leftMargin = (int) (f * 10.0f);
        linearLayout.addView(textView2, layoutParams4);
        this.mRefreshState = textView2;
        if (view == null || z) {
            return;
        }
        addView(view, layoutParams);
    }

    public TextView getArrow() {
        return this.mArrow;
    }

    public CustomProgressBar getProgressbar() {
        return this.mProgressbar;
    }

    public TextView getRefreshStateText() {
        return this.mRefreshState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (sIconfont == null) {
            try {
                sIconfont = Typeface.createFromAsset(getContext().getAssets(), "uik_core_iconfont.ttf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mArrow.setTypeface(sIconfont);
        sReference++;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mArrow.setTypeface(null);
        int i = sReference - 1;
        sReference = i;
        if (i == 0) {
            sIconfont = null;
        }
        super.onDetachedFromWindow();
    }

    public void setProgressBarColor(int i) {
        CustomProgressBar customProgressBar = this.mProgressbar;
        if (customProgressBar != null) {
            customProgressBar.setPaintColor(i);
        }
    }

    public void setProgressBarInitState(boolean z) {
        this.mProgressbar.isInitShow(z);
    }

    public void setPullDownDistance(int i) {
        this.mProgressbar.setPullDownDistance(i);
    }

    public void setRefreshViewColor(int i) {
        CustomProgressBar customProgressBar = this.mProgressbar;
        if (customProgressBar != null) {
            customProgressBar.setPaintColor(i);
        }
        TextView textView = this.mRefreshState;
        if (textView != null) {
            textView.setTextColor(i);
        }
        TextView textView2 = this.mArrow;
        if (textView2 != null) {
            textView2.setTextColor(i);
        }
    }
}
