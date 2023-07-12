package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferConfirmDialogView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContent;
    private View partent;
    private TextView tvReceivePhone;
    private TextView tvTickletNum;
    private TextView tvTip;

    public TickletTransferConfirmDialogView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41124158")) {
            ipChange.ipc$dispatch("-41124158", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContent).inflate(R$layout.ticklet_transfer_confirm_dialog_layout, this);
        this.partent = inflate;
        this.tvReceivePhone = (TextView) inflate.findViewById(R$id.ticklet_transfer_phone);
        this.tvTickletNum = (TextView) this.partent.findViewById(R$id.ticklet_transfer_ticklet_num);
        this.tvTip = (TextView) this.partent.findViewById(R$id.ticklet_transfer_tv_alarm);
    }

    private void setParam() {
        LinearLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345336716")) {
            ipChange.ipc$dispatch("1345336716", new Object[]{this});
            return;
        }
        if (this.tvTip.getText().length() > 420) {
            layoutParams = new LinearLayout.LayoutParams(-1, DisplayMetrics.getheightPixels(t60.b(this.mContent)) - t60.a(this.mContent, 120.0f));
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        setLayoutParams(layoutParams);
    }

    public void setData(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552075696")) {
            ipChange.ipc$dispatch("552075696", new Object[]{this, Integer.valueOf(i), str, str2});
        } else if (i == 0) {
        } else {
            py2.F(this.tvReceivePhone, str);
            TextView textView = this.tvTickletNum;
            textView.setText(String.valueOf(i) + "张");
            setParam();
            if (!TextUtils.isEmpty(str2)) {
                this.tvTip.setVisibility(0);
                this.tvTip.setText(str2);
                return;
            }
            this.tvTip.setVisibility(8);
        }
    }

    public TickletTransferConfirmDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTransferConfirmDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContent = context;
        setOrientation(1);
        setBackgroundResource(R$color.white);
        initView();
    }
}
