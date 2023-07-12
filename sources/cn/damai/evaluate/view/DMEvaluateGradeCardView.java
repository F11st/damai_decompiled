package cn.damai.evaluate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateGradeCardView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private TextView evaluate_grade_desc;
    private TextView evaluate_grade_weight;
    private ProgressBar progressbar;

    public DMEvaluateGradeCardView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626604261")) {
            ipChange.ipc$dispatch("-1626604261", new Object[]{this});
            return;
        }
        setOrientation(0);
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.evaluate_grade_card_layout, this);
        this.progressbar = (ProgressBar) inflate.findViewById(R$id.progressbar);
        this.evaluate_grade_weight = (TextView) inflate.findViewById(R$id.evaluate_grade_weight);
        this.evaluate_grade_desc = (TextView) inflate.findViewById(R$id.evaluate_grade_desc);
    }

    public void setData(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638332535")) {
            ipChange.ipc$dispatch("-1638332535", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        if (i == 100) {
            this.progressbar.setProgressDrawable(getResources().getDrawable(R$drawable.evaluate_progress_full_gb));
        } else {
            this.progressbar.setProgressDrawable(getResources().getDrawable(R$drawable.evaluate_progress_gb));
        }
        if (i > 0 && i < 4) {
            i = 4;
        }
        this.progressbar.setProgress(i);
        this.evaluate_grade_weight.setText(str2);
        this.evaluate_grade_desc.setText(str);
    }

    public DMEvaluateGradeCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMEvaluateGradeCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setPadding(t60.a(context, 12.0f), t60.a(context, 3.0f), t60.a(context, 12.0f), t60.a(context, 3.0f));
        initView();
    }
}
