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

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScoreDigitStarView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDigitTextView mDigitTextView;
    private ScoreStarViewV2 mScoreStarView;

    public ScoreDigitStarView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166250964")) {
            ipChange.ipc$dispatch("1166250964", new Object[]{this});
            return;
        }
        setOrientation(1);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layoutl_score_digit_star, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.score_text);
        this.mScoreStarView = (ScoreStarViewV2) inflate.findViewById(R$id.score_icon);
        addView(inflate, layoutParams);
    }

    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809413795")) {
            ipChange.ipc$dispatch("1809413795", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        this.mScoreStarView.updateView(d);
    }

    public ScoreDigitStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
