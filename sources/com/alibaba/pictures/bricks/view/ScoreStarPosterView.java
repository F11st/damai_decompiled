package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScoreStarPosterView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDigitTextView mDigitTextView;
    private LinearLayout mScoreLayout;
    private ScoreStarViewV2 mScoreStarView;

    public ScoreStarPosterView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223858864")) {
            ipChange.ipc$dispatch("223858864", new Object[]{this});
            return;
        }
        setOrientation(1);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_layoutl_score_star_poster, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, s60.INSTANCE.b(getContext(), 80));
        this.mScoreLayout = (LinearLayout) inflate.findViewById(R$id.ll_score);
        this.mDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.score_text);
        this.mScoreStarView = (ScoreStarViewV2) inflate.findViewById(R$id.score_icon);
        addView(inflate, layoutParams);
    }

    public void setScoreStarMargin(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514756779")) {
            ipChange.ipc$dispatch("-514756779", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        Context context = getContext();
        if (this.mScoreLayout == null || context == null) {
            return;
        }
        s60 s60Var = s60.INSTANCE;
        this.mScoreLayout.setPadding(s60Var.a(context, f2), 0, 0, s60Var.a(context, f));
    }

    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087390649")) {
            ipChange.ipc$dispatch("-1087390649", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        this.mScoreStarView.updateView(d);
        this.mScoreLayout.setBackgroundResource(R$drawable.bricks_bg_score_star);
    }

    public ScoreStarPosterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void updateView(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650674029")) {
            ipChange.ipc$dispatch("650674029", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        this.mScoreStarView.updateView(d);
        this.mScoreLayout.setBackgroundResource(z ? R$drawable.bricks_bg_score_star_radio : R$drawable.bricks_bg_score_star);
    }
}
