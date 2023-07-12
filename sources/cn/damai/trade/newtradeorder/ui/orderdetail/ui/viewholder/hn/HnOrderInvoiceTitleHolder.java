package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliveryInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliverySupport;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceTitleType;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HnOrderInvoiceTitleHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private TextView c;
    private TextView d;
    private EditText e;
    private TextView f;
    private TextView g;
    private DMIconFontTextView h;
    private HnInvoiceTitleType i;
    private OnSelectedContractsListener j;
    private OnSwitchInvoiceTitleListener k;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSelectedContractsListener {
        void onContractsClicked();
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSwitchInvoiceTitleListener {
        void onSwitchInvoiceTitle();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.hn.HnOrderInvoiceTitleHolder$a */
    /* loaded from: classes16.dex */
    public static class C2227a {
        public HnInvoiceTitleType a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    public HnOrderInvoiceTitleHolder(LayoutInflater layoutInflater) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.hn_order_create_invoice_title_type, (ViewGroup) null);
        this.a = inflate;
        inflate.setLayoutParams(layoutParams);
        c(this.a);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744679449")) {
            ipChange.ipc$dispatch("1744679449", new Object[]{this, view});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_invoice_title_type);
        this.c = textView;
        textView.setText("请选择");
        view.findViewById(R$id.layout_invoice_title_type).setOnClickListener(this);
        this.b = view.findViewById(R$id.layout_invoice_title_content);
        this.d = (TextView) view.findViewById(R$id.tv_invoice_title_1);
        this.e = (EditText) view.findViewById(R$id.et_invoice_title_1_content);
        this.f = (TextView) view.findViewById(R$id.tv_invoice_title_2);
        this.g = (EditText) view.findViewById(R$id.et_invoice_title_2_content);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.ic_person);
        this.h = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "946788232") ? (View) ipChange.ipc$dispatch("946788232", new Object[]{this}) : this.a;
    }

    @Nullable
    public C2227a b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693448468")) {
            return (C2227a) ipChange.ipc$dispatch("1693448468", new Object[]{this});
        }
        if (this.i == null) {
            return null;
        }
        C2227a c2227a = new C2227a();
        HnInvoiceTitleType hnInvoiceTitleType = this.i;
        c2227a.a = hnInvoiceTitleType;
        if ("1".equals(hnInvoiceTitleType.invoiceTitleType)) {
            c2227a.d = this.e.getText().toString();
            c2227a.e = this.g.getText().toString();
        } else {
            c2227a.b = this.e.getText().toString();
            c2227a.c = this.g.getText().toString();
        }
        return c2227a;
    }

    public void d(OnSelectedContractsListener onSelectedContractsListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592080052")) {
            ipChange.ipc$dispatch("592080052", new Object[]{this, onSelectedContractsListener});
        } else {
            this.j = onSelectedContractsListener;
        }
    }

    public void e(OnSwitchInvoiceTitleListener onSwitchInvoiceTitleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1333660732")) {
            ipChange.ipc$dispatch("1333660732", new Object[]{this, onSwitchInvoiceTitleListener});
        } else {
            this.k = onSwitchInvoiceTitleListener;
        }
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670398890")) {
            ipChange.ipc$dispatch("-670398890", new Object[]{this, str});
            return;
        }
        HnInvoiceTitleType hnInvoiceTitleType = this.i;
        if (hnInvoiceTitleType == null || "1".equals(hnInvoiceTitleType.invoiceTitleType)) {
            this.g.setText(str);
        }
    }

    public HnOrderInvoiceTitleHolder g(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult, HnInvoiceTitleType hnInvoiceTitleType) {
        List<HnInvoiceDeliverySupport> list;
        HnInvoiceDeliverySupport hnInvoiceDeliverySupport;
        List<HnInvoiceDeliveryInfo> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464757828")) {
            return (HnOrderInvoiceTitleHolder) ipChange.ipc$dispatch("1464757828", new Object[]{this, hnInvoiceApplyInfoResult, hnInvoiceTitleType});
        }
        if (hnInvoiceApplyInfoResult != null && (list = hnInvoiceApplyInfoResult.deliveryWaySupports) != null && !list.isEmpty() && hnInvoiceTitleType != null) {
            this.i = hnInvoiceTitleType;
            this.c.setText(hnInvoiceTitleType.invoiceTitleTypeStr);
            this.b.setVisibility(8);
            if ("2".equals(hnInvoiceTitleType.invoiceTitleType)) {
                this.d.setText("公司抬头:");
                this.e.setText("");
                this.e.setHint("请填写发票抬头");
                this.f.setText("纳税识别号:");
                this.g.setText("");
                this.g.setHint("请填写纳税识别号");
                this.h.setVisibility(8);
                this.b.setVisibility(0);
                return this;
            } else if (!"1".equals(hnInvoiceTitleType.invoiceTitleType) || (list2 = (hnInvoiceDeliverySupport = hnInvoiceApplyInfoResult.deliveryWaySupports.get(0)).deliveryWays) == null || list2.isEmpty() || "1".equals(hnInvoiceDeliverySupport.deliveryWays.get(0).deliveryWay)) {
                return this;
            } else {
                this.d.setText("联系人:");
                this.e.setText("");
                this.e.setHint("请输入姓名");
                this.f.setText("手机号:");
                this.g.setText("");
                this.g.setHint("请输入手机号码");
                this.h.setVisibility(0);
                this.b.setVisibility(0);
            }
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnSelectedContractsListener onSelectedContractsListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113170367")) {
            ipChange.ipc$dispatch("2113170367", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.layout_invoice_title_type) {
            OnSwitchInvoiceTitleListener onSwitchInvoiceTitleListener = this.k;
            if (onSwitchInvoiceTitleListener != null) {
                onSwitchInvoiceTitleListener.onSwitchInvoiceTitle();
            }
        } else if (id != R$id.ic_person || (onSelectedContractsListener = this.j) == null) {
        } else {
            onSelectedContractsListener.onContractsClicked();
        }
    }
}
