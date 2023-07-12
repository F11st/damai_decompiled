package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliveryInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HnOrderInvoiceDeliveryInfoHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private View c;
    private EditText d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private HnInvoiceDeliveryInfo k;
    private OnSwitchExpressAddressListener l;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSwitchExpressAddressListener {
        void onSwitchExpressAddress();
    }

    public HnOrderInvoiceDeliveryInfoHolder(LayoutInflater layoutInflater) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.hn_order_invoice_delivery_info, (ViewGroup) null);
        this.a = inflate;
        inflate.setLayoutParams(layoutParams);
        c(this.a);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1078147345")) {
            ipChange.ipc$dispatch("1078147345", new Object[]{this, view});
            return;
        }
        this.b = (TextView) view.findViewById(R$id.tv_invoice_delivery_type);
        this.c = view.findViewById(R$id.layout_invoice_delivery_type_mail);
        this.d = (EditText) view.findViewById(R$id.et_invoice_mail_content);
        this.e = view.findViewById(R$id.layout_invoice_delivery_type_express);
        View findViewById = view.findViewById(R$id.layout_invoice_express_address_info);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        this.f = (TextView) view.findViewById(R$id.tv_invoice_express_contacts);
        this.g = (TextView) view.findViewById(R$id.tv_invoice_express_phone);
        this.h = (TextView) view.findViewById(R$id.tv_invoice_express_address);
        this.i = (TextView) view.findViewById(R$id.tv_invoice_freight_content);
        this.j = (TextView) view.findViewById(R$id.tv_invoice_freight_tip);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "333376400") ? (View) ipChange.ipc$dispatch("333376400", new Object[]{this}) : this.a;
    }

    public HnInvoiceDeliveryInfo b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124363889")) {
            return (HnInvoiceDeliveryInfo) ipChange.ipc$dispatch("-124363889", new Object[]{this});
        }
        HnInvoiceDeliveryInfo hnInvoiceDeliveryInfo = this.k;
        if (hnInvoiceDeliveryInfo == null) {
            return null;
        }
        if (hnInvoiceDeliveryInfo.deliveryAddress == null) {
            hnInvoiceDeliveryInfo.deliveryAddress = new HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress();
        }
        if (!TextUtils.isEmpty(this.d.getText())) {
            this.k.deliveryAddress.email = this.d.getText().toString();
        } else {
            this.k.deliveryAddress.email = "";
        }
        return this.k;
    }

    public void d(OnSwitchExpressAddressListener onSwitchExpressAddressListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "851842784")) {
            ipChange.ipc$dispatch("851842784", new Object[]{this, onSwitchExpressAddressListener});
        } else {
            this.l = onSwitchExpressAddressListener;
        }
    }

    public void e(HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress hnInvoiceDeliveryAddress) {
        HnInvoiceDeliveryInfo hnInvoiceDeliveryInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672933612")) {
            ipChange.ipc$dispatch("1672933612", new Object[]{this, hnInvoiceDeliveryAddress});
        } else if (hnInvoiceDeliveryAddress == null || (hnInvoiceDeliveryInfo = this.k) == null) {
        } else {
            hnInvoiceDeliveryInfo.deliveryAddress = hnInvoiceDeliveryAddress;
            TextView textView = this.i;
            textView.setText("¥" + this.k.postFee);
            this.f.setText(hnInvoiceDeliveryAddress.consignee);
            this.f.setVisibility(0);
            this.g.setText(hnInvoiceDeliveryAddress.mobile);
            this.h.setText(hnInvoiceDeliveryAddress.getDetailAddress());
            this.h.setVisibility(0);
        }
    }

    public HnOrderInvoiceDeliveryInfoHolder f(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult, HnInvoiceDeliveryInfo hnInvoiceDeliveryInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947664732")) {
            return (HnOrderInvoiceDeliveryInfoHolder) ipChange.ipc$dispatch("-947664732", new Object[]{this, hnInvoiceApplyInfoResult, hnInvoiceDeliveryInfo});
        }
        this.k = hnInvoiceDeliveryInfo;
        if (hnInvoiceDeliveryInfo == null) {
            return this;
        }
        this.b.setText(hnInvoiceDeliveryInfo.deliveryWayStr);
        this.j.setText(hnInvoiceDeliveryInfo.deliveryMessage);
        if (!TextUtils.isEmpty(hnInvoiceDeliveryInfo.threeSideMessage)) {
            if (!TextUtils.isEmpty(hnInvoiceDeliveryInfo.deliveryMessage)) {
                TextView textView = this.j;
                textView.append(StringUtils.LF + hnInvoiceDeliveryInfo.threeSideMessage);
            } else {
                this.j.append(hnInvoiceDeliveryInfo.threeSideMessage);
            }
        }
        if ("1".equals(hnInvoiceDeliveryInfo.deliveryWay)) {
            this.e.setVisibility(0);
            HnInvoiceDeliveryInfo.HnInvoiceDeliveryAddress hnInvoiceDeliveryAddress = hnInvoiceDeliveryInfo.deliveryAddress;
            if (hnInvoiceDeliveryAddress != null) {
                this.f.setText(hnInvoiceDeliveryAddress.consignee);
                this.f.setVisibility(0);
                this.g.setText(hnInvoiceDeliveryInfo.deliveryAddress.mobile);
                this.h.setText(hnInvoiceDeliveryInfo.deliveryAddress.getDetailAddress());
                this.h.setVisibility(0);
                if (hnInvoiceApplyInfoResult != null) {
                    TextView textView2 = this.i;
                    textView2.setText("¥" + hnInvoiceDeliveryInfo.postFee);
                }
            }
            return this;
        }
        if ("3".equals(hnInvoiceDeliveryInfo.deliveryWay)) {
            this.c.setVisibility(0);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676027335")) {
            ipChange.ipc$dispatch("1676027335", new Object[]{this, view});
        } else if (view.getId() == R$id.layout_invoice_express_address_info) {
            this.l.onSwitchExpressAddress();
        }
    }
}
