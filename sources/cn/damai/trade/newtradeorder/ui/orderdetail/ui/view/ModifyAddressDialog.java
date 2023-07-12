package cn.damai.trade.newtradeorder.ui.orderdetail.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ModifyAddressDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        a(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "112765294")) {
                ipChange.ipc$dispatch("112765294", new Object[]{this, view});
                return;
            }
            ModifyAddressDialog.this.dismiss();
            this.a.onClick(ModifyAddressDialog.this, -2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        b(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2070911633")) {
                ipChange.ipc$dispatch("-2070911633", new Object[]{this, view});
                return;
            }
            ModifyAddressDialog.this.dismiss();
            this.a.onClick(ModifyAddressDialog.this, -1);
        }
    }

    public ModifyAddressDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887040645")) {
            ipChange.ipc$dispatch("-887040645", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.layout_modify_address_dialog, (ViewGroup) null);
        this.a = (TextView) inflate.findViewById(R$id.tv_name);
        this.b = (TextView) inflate.findViewById(R$id.tv_phone);
        this.c = (TextView) inflate.findViewById(R$id.tv_address);
        this.d = (TextView) inflate.findViewById(R$id.confirm_btn);
        this.e = (TextView) inflate.findViewById(R$id.cancel_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (DisplayMetrics.getheightPixels(q60.b(getContext())) * 0.05d)));
        setContentView(inflate);
    }

    public ModifyAddressDialog b(OrderAddressModifyResult.DeliveryInfo deliveryInfo) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685116086")) {
            return (ModifyAddressDialog) ipChange.ipc$dispatch("1685116086", new Object[]{this, deliveryInfo});
        }
        String str2 = deliveryInfo.consignee;
        if (str2 != null) {
            this.a.setText(str2);
        }
        String str3 = deliveryInfo.phoneNumber;
        if (str3 != null) {
            this.b.setText(str3);
        }
        OrderAddressModifyResult.DeliveryInfo.AddressInfo addressInfo = deliveryInfo.address;
        if (addressInfo != null && (str = addressInfo.fullAddress) != null) {
            this.c.setText(str);
        }
        return this;
    }

    public ModifyAddressDialog c(DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352203361")) {
            return (ModifyAddressDialog) ipChange.ipc$dispatch("-352203361", new Object[]{this, onClickListener});
        }
        this.e.setOnClickListener(new a(onClickListener));
        return this;
    }

    public ModifyAddressDialog d(DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643761397")) {
            return (ModifyAddressDialog) ipChange.ipc$dispatch("-643761397", new Object[]{this, onClickListener});
        }
        this.d.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207178463")) {
            ipChange.ipc$dispatch("207178463", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public ModifyAddressDialog(@NonNull Context context, int i) {
        super(context, i);
        a();
    }
}
