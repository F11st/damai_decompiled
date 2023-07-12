package cn.damai.evaluate.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.comment.R$drawable;
import cn.damai.comment.bean.CommentStatScoreBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateGradeBlockView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;

    public DMEvaluateGradeBlockView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687110193")) {
            ipChange.ipc$dispatch("-1687110193", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        setPadding(0, t60.a(context, 9.0f), 0, 0);
        setOrientation(1);
    }

    public void setData(List<CommentStatScoreBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825260422")) {
            ipChange.ipc$dispatch("1825260422", new Object[]{this, list});
            return;
        }
        removeAllViews();
        setBackground(getResources().getDrawable(R$drawable.gray_dbdbdb));
        if (wh2.e(list) > 0) {
            for (int i = 0; i < list.size(); i++) {
                DMEvaluateGradeCardView dMEvaluateGradeCardView = new DMEvaluateGradeCardView(this.mContext);
                float floatValue = TextUtils.isEmpty(list.get(i).getScoreRatio()) ? 0.0f : Float.valueOf(list.get(i).getScoreRatio()).floatValue() * 100.0f;
                if (list.get(i).getStatScore() != null) {
                    dMEvaluateGradeCardView.setData((int) floatValue, list.get(i).getScoreDesc(), list.get(i).getStatScore());
                } else {
                    int i2 = (int) floatValue;
                    String scoreDesc = list.get(i).getScoreDesc();
                    dMEvaluateGradeCardView.setData(i2, scoreDesc, i2 + "%");
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, 0, 0, 0);
                addView(dMEvaluateGradeCardView, layoutParams);
            }
            TextView textView = new TextView(this.mContext);
            textView.setBackgroundColor(Color.parseColor("#149c9c9c"));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, t60.a(this.mContext, 9.0f));
            layoutParams2.setMargins(0, t60.a(this.mContext, 9.0f), 0, 0);
            textView.setLayoutParams(layoutParams2);
        }
    }

    @RequiresApi(api = 11)
    public DMEvaluateGradeBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        init(context);
    }

    @RequiresApi(api = 21)
    public DMEvaluateGradeBlockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        init(context);
    }
}
