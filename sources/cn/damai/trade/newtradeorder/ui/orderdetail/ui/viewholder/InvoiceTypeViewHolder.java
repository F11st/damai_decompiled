package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoicesTrans;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.InvoiceSelectAddressView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.cs;
import tb.d41;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class InvoiceTypeViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int A;
    private View a;
    private FrameLayout b;
    private TextView c;
    private ImageView d;
    private FrameLayout e;
    private TextView f;
    private ImageView g;
    private LinearLayout h;
    private TextView i;
    private LinearLayout j;
    private EditText k;
    private EditText l;
    private LinearLayout m;
    private RelativeLayout n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private RelativeLayout s;
    private String t;
    private AddressBean v;
    private PopupWindow w;
    private InvoiceSelectAddressView x;
    private Activity y;
    private View.OnClickListener z = new a();
    private List<AddressBean> u = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1565609552")) {
                ipChange.ipc$dispatch("-1565609552", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (R$id.fl_invoice_way_invite == id) {
                InvoiceTypeViewHolder.this.C((InvoicesTrans) view.getTag());
            } else if (R$id.fl_invoice_way_delivery == id) {
                InvoiceTypeViewHolder.this.C((InvoicesTrans) view.getTag());
            } else if (R$id.invoice_delivery_address_rv == id) {
                InvoiceTypeViewHolder.this.A();
            } else if (R$id.invoice_no_address_rv == id) {
                InvoiceTypeViewHolder.this.B();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1637996110")) {
                ipChange.ipc$dispatch("-1637996110", new Object[]{this, view});
            } else {
                InvoiceTypeViewHolder.this.p();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "473294259")) {
                ipChange.ipc$dispatch("473294259", new Object[]{this, view});
            } else {
                InvoiceTypeViewHolder.this.B();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1710382668")) {
                ipChange.ipc$dispatch("-1710382668", new Object[]{this, view});
            } else {
                InvoiceTypeViewHolder.this.p();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class e implements InvoiceSelectAddressView.OnAddressItemSelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderdetail.ui.view.InvoiceSelectAddressView.OnAddressItemSelectedListener
        public void onItemSelected(AddressBean addressBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1003130877")) {
                ipChange.ipc$dispatch("1003130877", new Object[]{this, addressBean});
            } else if (addressBean != null) {
                InvoiceTypeViewHolder.this.p();
                InvoiceTypeViewHolder.this.D(addressBean);
            }
        }
    }

    public InvoiceTypeViewHolder(Activity activity, LinearLayout linearLayout, LayoutInflater layoutInflater, View view) {
        this.y = activity;
        this.a = view;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.removeAllViews();
        View inflate = layoutInflater.inflate(R$layout.order_create_list_line, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        linearLayout.addView(inflate);
        View inflate2 = layoutInflater.inflate(R$layout.order_detail_invoice_way, (ViewGroup) null);
        inflate2.setLayoutParams(layoutParams);
        linearLayout.addView(inflate2);
        u(inflate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151177751")) {
            ipChange.ipc$dispatch("-151177751", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.w;
        if (popupWindow == null || !popupWindow.isShowing()) {
            q();
            int[] iArr = new int[2];
            this.a.getLocationOnScreen(iArr);
            this.w.showAtLocation(this.a, 81, iArr[0], iArr[1] - m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145765844")) {
            ipChange.ipc$dispatch("1145765844", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 1);
        DMNav.from(this.y).withExtras(bundle).forResult(10001).toUri(cs.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(InvoicesTrans invoicesTrans) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895097766")) {
            ipChange.ipc$dispatch("895097766", new Object[]{this, invoicesTrans});
        } else if (invoicesTrans == null) {
        } else {
            String str = invoicesTrans.transId;
            this.t = str;
            if (str.equals("2")) {
                w(invoicesTrans.mess);
                this.c.setTextColor(this.y.getResources().getColor(R$color.main_color));
                this.c.setBackgroundResource(R$drawable.bg_border_corner_fa_trans);
                this.d.setVisibility(0);
                this.f.setTextColor(this.y.getResources().getColor(R$color.color_666666));
                this.f.setBackgroundResource(R$drawable.bg_border_corner_cc);
                this.g.setVisibility(8);
                this.j.setVisibility(0);
                this.m.setVisibility(8);
            } else if (this.t.equals("1")) {
                w(invoicesTrans.mess);
                this.f.setTextColor(this.y.getResources().getColor(R$color.main_color));
                this.f.setBackgroundResource(R$drawable.bg_border_corner_fa_trans);
                this.g.setVisibility(0);
                this.c.setTextColor(this.y.getResources().getColor(R$color.color_666666));
                this.c.setBackgroundResource(R$drawable.bg_border_corner_cc);
                this.d.setVisibility(8);
                this.m.setVisibility(0);
                this.j.setVisibility(8);
                v();
            }
            xr.c("1", this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187216207")) {
            ipChange.ipc$dispatch("1187216207", new Object[]{this, addressBean});
        } else if (addressBean != null) {
            if (this.v == null || addressBean.getAddressId() != this.v.getAddressId()) {
                this.v = addressBean;
                v();
            }
        }
    }

    private int m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2120807797") ? ((Integer) ipChange.ipc$dispatch("-2120807797", new Object[]{this})).intValue() : DisplayMetrics.getheightPixels(this.y.getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552412804")) {
            ipChange.ipc$dispatch("1552412804", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.w;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.w.dismiss();
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1604253686")) {
            ipChange.ipc$dispatch("1604253686", new Object[]{this});
            return;
        }
        t();
        if (this.w == null) {
            PopupWindow popupWindow = new PopupWindow(this.x, -1, -1);
            this.w = popupWindow;
            popupWindow.setFocusable(true);
            this.w.setTouchable(true);
            this.w.setOutsideTouchable(true);
            this.w.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
        }
    }

    private void r(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72542455")) {
            ipChange.ipc$dispatch("-72542455", new Object[]{this, view});
            return;
        }
        this.m = (LinearLayout) view.findViewById(R$id.ll_delivery_way_container);
        this.n = (RelativeLayout) view.findViewById(R$id.invoice_delivery_address_rv);
        this.o = (TextView) view.findViewById(R$id.invoice_receiver_name_phone_tv);
        this.p = (TextView) view.findViewById(R$id.invoice_detail_address_tv);
        this.q = (LinearLayout) view.findViewById(R$id.ll_invoice_freight);
        this.r = (TextView) view.findViewById(R$id.tv_amount);
        this.s = (RelativeLayout) view.findViewById(R$id.invoice_no_address_rv);
        this.n.setOnClickListener(this.z);
        this.s.setOnClickListener(this.z);
    }

    private void s(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803302660")) {
            ipChange.ipc$dispatch("-803302660", new Object[]{this, view});
            return;
        }
        this.j = (LinearLayout) view.findViewById(R$id.ll_invite_way_container);
        this.k = (EditText) view.findViewById(R$id.edit_invoice_username);
        this.l = (EditText) view.findViewById(R$id.edit_invoice_phone);
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "383499680")) {
            ipChange.ipc$dispatch("383499680", new Object[]{this});
            return;
        }
        if (this.x == null) {
            InvoiceSelectAddressView invoiceSelectAddressView = new InvoiceSelectAddressView(this.y);
            this.x = invoiceSelectAddressView;
            invoiceSelectAddressView.setOnClickListener(new b());
            this.x.setOnAddAddressClickListener(new c());
            this.x.setOnCancelClickListener(new d());
            this.x.setOnAddressItemSelectedListener(new e());
        }
        this.x.setOrderAddressListAndSelected(this.u, this.v);
    }

    private void u(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107943669")) {
            ipChange.ipc$dispatch("2107943669", new Object[]{this, view});
            return;
        }
        this.b = (FrameLayout) view.findViewById(R$id.fl_invoice_way_invite);
        this.c = (TextView) view.findViewById(R$id.tv_invoice_way_invite);
        this.d = (ImageView) view.findViewById(R$id.iv_invoice_way_invite);
        this.e = (FrameLayout) view.findViewById(R$id.fl_invoice_way_delivery);
        this.f = (TextView) view.findViewById(R$id.tv_invoice_way_delivery);
        this.g = (ImageView) view.findViewById(R$id.iv_invoice_way_delivery);
        this.h = (LinearLayout) view.findViewById(R$id.ll_invoice_tip);
        this.i = (TextView) view.findViewById(R$id.tv_invoice_tip);
        this.b.setVisibility(8);
        this.e.setVisibility(8);
        this.b.setOnClickListener(this.z);
        this.e.setOnClickListener(this.z);
        s(view);
        r(view);
    }

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1560097595")) {
            ipChange.ipc$dispatch("-1560097595", new Object[]{this});
        } else if (this.v != null) {
            this.s.setVisibility(8);
            this.n.setVisibility(0);
            this.q.setVisibility(0);
            x(this.v);
        } else {
            this.n.setVisibility(8);
            this.q.setVisibility(8);
            this.s.setVisibility(0);
        }
    }

    private void w(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892543224")) {
            ipChange.ipc$dispatch("-892543224", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.i.setText(str);
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    private void x(final AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34801638")) {
            ipChange.ipc$dispatch("34801638", new Object[]{this, addressBean});
        } else if (this.A <= 0) {
            this.o.post(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.InvoiceTypeViewHolder.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1962088161")) {
                        ipChange2.ipc$dispatch("-1962088161", new Object[]{this});
                        return;
                    }
                    InvoiceTypeViewHolder invoiceTypeViewHolder = InvoiceTypeViewHolder.this;
                    invoiceTypeViewHolder.A = (invoiceTypeViewHolder.o.getWidth() - InvoiceTypeViewHolder.this.o.getPaddingLeft()) - InvoiceTypeViewHolder.this.o.getPaddingRight();
                    InvoiceTypeViewHolder.this.z(addressBean);
                }
            });
        } else {
            z(addressBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730922857")) {
            ipChange.ipc$dispatch("-730922857", new Object[]{this, addressBean});
        } else if (addressBean == null) {
        } else {
            String mobile = addressBean.getMobile();
            String consigneeName = addressBean.getConsigneeName();
            if (TextUtils.isEmpty(consigneeName)) {
                consigneeName = "";
            }
            if (TextUtils.isEmpty(mobile)) {
                mobile = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            TextPaint paint = this.o.getPaint();
            if (((int) paint.measureText(new SpannableStringBuilder().append((CharSequence) " ").append((CharSequence) " ").append((CharSequence) mobile).toString())) + (((int) paint.measureText(consigneeName)) % this.A) > this.A) {
                spannableStringBuilder.append((CharSequence) consigneeName).append((CharSequence) StringUtils.LF).append((CharSequence) mobile);
            } else {
                spannableStringBuilder.append((CharSequence) consigneeName).append((CharSequence) " ").append((CharSequence) " ").append((CharSequence) mobile);
            }
            if (!wh2.j(spannableStringBuilder.toString())) {
                this.o.setText(spannableStringBuilder.toString());
            } else {
                this.o.setText("");
            }
            String a2 = d41.a(addressBean);
            if (!wh2.j(a2)) {
                this.p.setText(a2);
            } else {
                this.p.setText("");
            }
        }
    }

    public void i(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118987479")) {
            ipChange.ipc$dispatch("1118987479", new Object[]{this, addressBean});
        } else if (addressBean != null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.u.add(0, addressBean);
            p();
            D(addressBean);
        }
    }

    public String j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1717827265") ? (String) ipChange.ipc$dispatch("-1717827265", new Object[]{this}) : this.l.getText().toString();
    }

    public String k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "354961983") ? (String) ipChange.ipc$dispatch("354961983", new Object[]{this}) : this.t;
    }

    public String l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1002755323") ? (String) ipChange.ipc$dispatch("1002755323", new Object[]{this}) : this.k.getText().toString();
    }

    public AddressBean n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2098670675") ? (AddressBean) ipChange.ipc$dispatch("-2098670675", new Object[]{this}) : this.v;
    }

    public void o(List<InvoicesTrans> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14689820")) {
            ipChange.ipc$dispatch("-14689820", new Object[]{this, list, str});
            return;
        }
        if (!wh2.j(str)) {
            this.r.setText(str);
        } else {
            this.r.setText("10元");
        }
        boolean z = false;
        for (int i = 0; i < wh2.e(list); i++) {
            InvoicesTrans invoicesTrans = list.get(i);
            if (invoicesTrans != null) {
                if (invoicesTrans.transId.equals("2")) {
                    this.b.setVisibility(0);
                    this.b.setTag(invoicesTrans);
                    if (!wh2.j(invoicesTrans.transName)) {
                        this.c.setText(invoicesTrans.transName);
                    } else {
                        this.c.setText("自取");
                    }
                    if (!z) {
                        C(invoicesTrans);
                        z = true;
                    }
                } else if (invoicesTrans.transId.equals("1")) {
                    this.e.setVisibility(0);
                    this.e.setTag(invoicesTrans);
                    if (!wh2.j(invoicesTrans.transName)) {
                        this.f.setText(invoicesTrans.transName);
                    } else {
                        this.f.setText("快递");
                    }
                    if (!z) {
                        C(invoicesTrans);
                        z = true;
                    }
                }
            }
        }
    }

    public void y(List<AddressBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39342577")) {
            ipChange.ipc$dispatch("39342577", new Object[]{this, list});
            return;
        }
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.clear();
        this.u.addAll(list);
        if (wh2.e(this.u) > 0) {
            this.v = this.u.get(0);
        } else {
            this.v = null;
        }
    }
}
