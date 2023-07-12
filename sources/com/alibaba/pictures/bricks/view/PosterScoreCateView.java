package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PosterScoreCateView extends ScoreStarPosterView {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mCateView;
    private DMDigitTextView mDigitTextView;
    private View mDigitTextViewTitle;
    private View mDivView;
    private LinearLayout mScoreLayout;

    public PosterScoreCateView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314240435")) {
            ipChange.ipc$dispatch("314240435", new Object[]{this});
            return;
        }
        setOrientation(1);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_layoutl_score_cate_poster, (ViewGroup) null, false);
        s60.INSTANCE.b(getContext(), 25);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mScoreLayout = (LinearLayout) inflate.findViewById(R$id.ll_score);
        this.mDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.score_text);
        this.mDigitTextViewTitle = inflate.findViewById(R$id.score_text_title);
        this.mCateView = (TextView) inflate.findViewById(R$id.cate_text_tv);
        this.mDivView = inflate.findViewById(R$id.cate_text_div);
        addView(inflate, layoutParams);
    }

    @Override // com.alibaba.pictures.bricks.view.ScoreStarPosterView
    public void setScoreStarMargin(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921376296")) {
            ipChange.ipc$dispatch("-1921376296", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
    }

    @Override // com.alibaba.pictures.bricks.view.ScoreStarPosterView
    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474503580")) {
            ipChange.ipc$dispatch("-1474503580", new Object[]{this, Double.valueOf(d)});
        }
    }

    public void updateView(double d, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636747986")) {
            ipChange.ipc$dispatch("-1636747986", new Object[]{this, Double.valueOf(d), str});
        } else if (d <= 0.0d && TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.mCateView.setVisibility(0);
                this.mCateView.setText(str);
            } else {
                this.mCateView.setVisibility(8);
            }
            if (d > 0.0d) {
                this.mDigitTextView.setVisibility(0);
                this.mDigitTextViewTitle.setVisibility(0);
                this.mDivView.setVisibility(0);
                this.mDigitTextView.setText(String.valueOf(d));
                return;
            }
            this.mDigitTextView.setVisibility(8);
            this.mDigitTextViewTitle.setVisibility(8);
            this.mDivView.setVisibility(8);
        }
    }

    @Override // com.alibaba.pictures.bricks.view.ScoreStarPosterView
    public void updateView(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535075056")) {
            ipChange.ipc$dispatch("1535075056", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
        }
    }

    public PosterScoreCateView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
