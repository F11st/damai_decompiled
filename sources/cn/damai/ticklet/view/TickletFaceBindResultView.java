package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletFaceBindResultView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout mLvTicketSeatInfo;
    private TextView mTvBindResultNote;
    private TextView mTvBindResultSubNote;
    private TextView mTvCertificateNum;

    public TickletFaceBindResultView(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2003932489")) {
            ipChange.ipc$dispatch("2003932489", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.ticklet_face_bind_message_layout, this);
        this.mTvBindResultNote = (TextView) findViewById(R$id.ticklet_face_bind_result_note_tv);
        this.mTvBindResultSubNote = (TextView) findViewById(R$id.ticklet_face_bind_result_sub_note_tv);
        this.mLvTicketSeatInfo = (LinearLayout) findViewById(R$id.ticklet_face_bind_ticket_seat_lv);
        this.mTvCertificateNum = (TextView) findViewById(R$id.ticklet_face_bind_certificate_num_tv);
    }

    private void setCertificateNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592219702")) {
            ipChange.ipc$dispatch("-592219702", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mTvCertificateNum.setText(str);
        } else {
            this.mTvCertificateNum.setText("");
        }
    }

    public void setBindSuccessMessage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372086636")) {
            ipChange.ipc$dispatch("372086636", new Object[]{this, str, str2, str3});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTvBindResultNote.setText(str);
        } else {
            this.mTvBindResultNote.setText("");
        }
        py2.A(getContext(), "1", 14, str2, this.mLvTicketSeatInfo, 17);
        setCertificateNum(str3);
        this.mLvTicketSeatInfo.setVisibility(0);
        this.mTvBindResultNote.setVisibility(0);
        this.mTvBindResultSubNote.setVisibility(8);
    }

    public void setFailureMessage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999352998")) {
            ipChange.ipc$dispatch("1999352998", new Object[]{this, str, str2});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTvBindResultNote.setText(str);
        } else {
            this.mTvBindResultNote.setText("");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mTvBindResultSubNote.setText(str2);
            this.mTvBindResultSubNote.setVisibility(0);
        } else {
            this.mTvBindResultSubNote.setText("");
            this.mTvBindResultSubNote.setVisibility(8);
        }
        this.mTvBindResultNote.setVisibility(0);
        this.mLvTicketSeatInfo.setVisibility(8);
        setCertificateNum("");
    }

    public TickletFaceBindResultView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletFaceBindResultView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
