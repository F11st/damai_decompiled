package cn.damai.comment.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jn1;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMCommentTitleView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView moudleTitle;

    public DMCommentTitleView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1851901754")) {
            ipChange.ipc$dispatch("-1851901754", new Object[]{this});
            return;
        }
        setOrientation(0);
        setPadding(t60.a(this.mContext, 21.0f), 0, t60.a(this.mContext, 15.0f), t60.a(this.mContext, 0.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.mContext);
        this.moudleTitle = textView;
        textView.setTextSize(1, 16.0f);
        this.moudleTitle.setTextColor(this.mContext.getResources().getColor(R$color.color_000000));
        this.moudleTitle.setLayoutParams(layoutParams);
        addView(this.moudleTitle);
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330038221")) {
            ipChange.ipc$dispatch("1330038221", new Object[]{this, str});
        } else {
            setData(str, 0);
        }
    }

    public void setData(String str, int i) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718458666")) {
            ipChange.ipc$dispatch("-1718458666", new Object[]{this, str, Integer.valueOf(i)});
        } else if (!TextUtils.isEmpty(str)) {
            this.moudleTitle.setVisibility(0);
            if (i != 0) {
                str2 = jn1.BRACKET_START_STR + String.valueOf(i) + jn1.BRACKET_END_STR;
            } else {
                str2 = "";
            }
            this.moudleTitle.setText(str + str2);
        } else {
            this.moudleTitle.setVisibility(8);
        }
    }
}
