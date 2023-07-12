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
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletFaceUnbindDialogView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = TickletFaceUnbindDialogView.class.getSimpleName();
    private Context context;
    private LinearLayout lvSeatInfo;
    private View partent;
    private TextView tvCertNameNum;

    public TickletFaceUnbindDialogView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274864552")) {
            ipChange.ipc$dispatch("274864552", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_face_unbind_dialog_layout, this);
        this.partent = inflate;
        this.lvSeatInfo = (LinearLayout) inflate.findViewById(R$id.ticklet_face_unbind_ticket_dialog_item_seat_info_lv);
        this.tvCertNameNum = (TextView) this.partent.findViewById(R$id.ticklet_face_unbind_ticket_dialog_item_cert_name_tv);
    }

    private void setCertInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743521517")) {
            ipChange.ipc$dispatch("743521517", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            this.tvCertNameNum.setVisibility(8);
        } else {
            this.tvCertNameNum.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" | ");
                }
                sb.append(str2);
            }
            setCertName(this.tvCertNameNum, sb.toString());
        }
    }

    private void setCertName(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337689138")) {
            ipChange.ipc$dispatch("1337689138", new Object[]{this, textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
    }

    public void initSeatData(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603669503")) {
            ipChange.ipc$dispatch("603669503", new Object[]{this, userTicketTable});
        }
    }

    public TickletFaceUnbindDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletFaceUnbindDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setOrientation(1);
        setBackgroundResource(R$color.white);
        initView();
    }
}
