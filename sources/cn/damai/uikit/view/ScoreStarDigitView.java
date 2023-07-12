package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScoreStarDigitView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDigitTextView mDigitTextView;
    private ScoreStarViewV2 mScoreStarView;

    public ScoreStarDigitView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1398187440")) {
            ipChange.ipc$dispatch("1398187440", new Object[]{this});
            return;
        }
        setOrientation(1);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layoutl_score_star_digit, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.score_text);
        this.mScoreStarView = (ScoreStarViewV2) inflate.findViewById(R$id.score_icon);
        addView(inflate, layoutParams);
    }

    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826591047")) {
            ipChange.ipc$dispatch("826591047", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        this.mScoreStarView.updateView(d);
    }

    public ScoreStarDigitView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void updateView(double d, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145451876")) {
            ipChange.ipc$dispatch("-145451876", new Object[]{this, Double.valueOf(d), Integer.valueOf(i)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        if (i <= 0) {
            i = 12;
        }
        this.mDigitTextView.setTextSize(1, i);
        this.mScoreStarView.updateView(d);
    }

    public void updateView(double d, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213995080")) {
            ipChange.ipc$dispatch("-213995080", new Object[]{this, Double.valueOf(d), Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        if (i <= 0) {
            i = 12;
        }
        this.mDigitTextView.setTextSize(1, i);
        this.mScoreStarView.updateView(d);
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mScoreStarView.getLayoutParams();
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = l62.a(getContext(), 1.0f);
            this.mScoreStarView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mDigitTextView.getLayoutParams();
            layoutParams2.bottomMargin = l62.a(getContext(), -2.0f);
            layoutParams.gravity = 80;
            this.mDigitTextView.setLayoutParams(layoutParams2);
        }
    }
}
