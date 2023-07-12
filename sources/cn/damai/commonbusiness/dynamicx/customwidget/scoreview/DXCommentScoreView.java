package cn.damai.commonbusiness.dynamicx.customwidget.scoreview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.ScoreStarViewV2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DXCommentScoreView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDigitTextView mDigitTextView;
    private ScoreStarViewV2 mScoreStarView;

    public DXCommentScoreView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633134513")) {
            ipChange.ipc$dispatch("633134513", new Object[]{this});
            return;
        }
        setOrientation(0);
        setGravity(80);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.common_score_star_dx, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l62.a(getContext(), 80.0f));
        this.mDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.score_text);
        this.mScoreStarView = (ScoreStarViewV2) inflate.findViewById(R$id.score_icon);
        addView(inflate, layoutParams);
    }

    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1768684634")) {
            ipChange.ipc$dispatch("-1768684634", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.mDigitTextView.setText(String.valueOf(d));
        this.mScoreStarView.updateView(d);
    }

    public DXCommentScoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
