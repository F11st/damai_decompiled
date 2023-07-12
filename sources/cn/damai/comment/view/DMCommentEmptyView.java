package cn.damai.comment.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMCommentEmptyView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMCommentEmptyView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344220952")) {
            ipChange.ipc$dispatch("-1344220952", new Object[]{this, context});
            return;
        }
        setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 45, 0, 45);
        TextView textView = new TextView(context);
        textView.setTextSize(13.0f);
        textView.setGravity(17);
        textView.setText("暂时还没有人回复ta哦~");
        textView.setTextColor(context.getResources().getColor(R$color.color_999999));
        textView.setLayoutParams(layoutParams2);
        addView(textView);
    }
}
