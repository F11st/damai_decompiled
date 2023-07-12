package cn.damai.common.app.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ProtocolDialog extends DMDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    protected TextView p;
    private CheckBox q;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnConfirmListener {
        void onConfirmClick(boolean z, DialogInterface dialogInterface);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.ProtocolDialog$a */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0479a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0479a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1328580559")) {
                ipChange.ipc$dispatch("1328580559", new Object[]{this, view});
            } else {
                ProtocolDialog.this.q.setChecked(!ProtocolDialog.this.q.isChecked());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.ProtocolDialog$b */
    /* loaded from: classes13.dex */
    public static class DialogInterface$OnClickListenerC0480b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnConfirmListener a;
        private ProtocolDialog b;

        public DialogInterface$OnClickListenerC0480b(OnConfirmListener onConfirmListener, ProtocolDialog protocolDialog) {
            this.a = onConfirmListener;
            this.b = protocolDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "58822103")) {
                ipChange.ipc$dispatch("58822103", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            OnConfirmListener onConfirmListener = this.a;
            if (onConfirmListener != null) {
                onConfirmListener.onConfirmClick(this.b.D(), dialogInterface);
            }
        }
    }

    public ProtocolDialog(@NonNull Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_bottom_check_box_ui, (ViewGroup) null);
        z(inflate);
        this.q = (CheckBox) inflate.findViewById(R$id.icb_check);
        inflate.findViewById(R$id.icb_check_container).setOnClickListener(new View$OnClickListenerC0479a());
        this.p = (TextView) inflate.findViewById(R$id.icb_protocol_text);
    }

    public static ProtocolDialog C(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i, DialogInterface.OnClickListener onClickListener, CharSequence charSequence5, int i2, OnConfirmListener onConfirmListener, View.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360066436")) {
            return (ProtocolDialog) ipChange.ipc$dispatch("1360066436", new Object[]{context, charSequence, charSequence2, charSequence3, charSequence4, Integer.valueOf(i), onClickListener, charSequence5, Integer.valueOf(i2), onConfirmListener, onClickListener2});
        }
        ProtocolDialog protocolDialog = new ProtocolDialog(context);
        protocolDialog.m(charSequence5, i2, new DialogInterface$OnClickListenerC0480b(onConfirmListener, protocolDialog));
        protocolDialog.h(charSequence4, i, onClickListener);
        protocolDialog.v(charSequence);
        protocolDialog.q(charSequence2);
        protocolDialog.p.setText(charSequence3);
        protocolDialog.t(19);
        protocolDialog.b(false);
        if (onClickListener2 != null) {
            protocolDialog.p.setOnClickListener(onClickListener2);
        }
        return protocolDialog;
    }

    public boolean D() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-990166048") ? ((Boolean) ipChange.ipc$dispatch("-990166048", new Object[]{this})).booleanValue() : this.q.isChecked();
    }
}
