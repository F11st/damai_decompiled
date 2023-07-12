package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceTitleInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c41 {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout a;
    private TextView b;
    private ImageView c;
    private FrameLayout d;
    private TextView e;
    private ImageView f;
    private LinearLayout g;
    private EditText h;
    private EditText i;
    private int j;
    private Context l;
    boolean k = false;
    private View.OnClickListener m = new View$OnClickListenerC8988a();

    /* compiled from: Taobao */
    /* renamed from: tb.c41$a */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC8988a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC8988a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-312777469")) {
                ipChange.ipc$dispatch("-312777469", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (R$id.fl_invoice_type_personal == id) {
                c41.this.g(1);
            } else if (R$id.fl_invoice_type_company == id) {
                c41.this.g(2);
            }
        }
    }

    public c41(Context context, LinearLayout linearLayout, LayoutInflater layoutInflater) {
        this.l = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.removeAllViews();
        View inflate = layoutInflater.inflate(R$layout.order_create_list_line, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        linearLayout.addView(inflate);
        View inflate2 = layoutInflater.inflate(R$layout.order_detail_invoice_header, (ViewGroup) null);
        inflate2.setLayoutParams(layoutParams);
        linearLayout.addView(inflate2);
        f(inflate2);
    }

    private void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901431618")) {
            ipChange.ipc$dispatch("901431618", new Object[]{this, view});
            return;
        }
        this.a = (FrameLayout) view.findViewById(R$id.fl_invoice_type_personal);
        this.b = (TextView) view.findViewById(R$id.tv_invoice_type_personal);
        this.c = (ImageView) view.findViewById(R$id.iv_invoice_type_personal);
        this.d = (FrameLayout) view.findViewById(R$id.fl_invoice_type_company);
        this.e = (TextView) view.findViewById(R$id.tv_invoice_type_company);
        this.f = (ImageView) view.findViewById(R$id.iv_invoice_type_company);
        this.g = (LinearLayout) view.findViewById(R$id.ll_invoice_content);
        this.h = (EditText) view.findViewById(R$id.edit_invoice_name);
        this.i = (EditText) view.findViewById(R$id.edit_invoice_tax_num);
        this.a.setVisibility(8);
        this.d.setVisibility(8);
        this.a.setOnClickListener(this.m);
        this.d.setOnClickListener(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288352208")) {
            ipChange.ipc$dispatch("-288352208", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.j = i;
        if (i == 1) {
            this.b.setTextColor(this.l.getResources().getColor(R$color.main_color));
            this.b.setBackgroundResource(R$drawable.bg_border_corner_fa_trans);
            this.c.setVisibility(0);
            this.e.setTextColor(this.l.getResources().getColor(R$color.color_666666));
            this.e.setBackgroundResource(R$drawable.bg_border_corner_cc);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        } else if (i != 2) {
        } else {
            this.e.setTextColor(this.l.getResources().getColor(R$color.main_color));
            this.e.setBackgroundResource(R$drawable.bg_border_corner_fa_trans);
            this.f.setVisibility(0);
            this.b.setTextColor(this.l.getResources().getColor(R$color.color_666666));
            this.b.setBackgroundResource(R$drawable.bg_border_corner_cc);
            this.c.setVisibility(8);
            this.g.setVisibility(0);
            this.h.setHint("填写公司名称");
            this.i.setHint("填写公司税号");
        }
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1706808800") ? (String) ipChange.ipc$dispatch("1706808800", new Object[]{this}) : this.i.getText().toString();
    }

    public String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2054350509") ? (String) ipChange.ipc$dispatch("-2054350509", new Object[]{this}) : this.h.getText().toString();
    }

    public int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1670198009") ? ((Integer) ipChange.ipc$dispatch("-1670198009", new Object[]{this})).intValue() : this.j;
    }

    public void e(List<InvoiceTitleInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212128361")) {
            ipChange.ipc$dispatch("212128361", new Object[]{this, list});
            return;
        }
        for (int i = 0; i < wh2.e(list); i++) {
            InvoiceTitleInfo invoiceTitleInfo = list.get(i);
            if (invoiceTitleInfo != null) {
                try {
                    int parseInt = Integer.parseInt(invoiceTitleInfo.typeId);
                    if (parseInt == 1) {
                        this.a.setVisibility(0);
                        this.b.setText(invoiceTitleInfo.typeName);
                        if (!this.k) {
                            this.k = true;
                            g(parseInt);
                        }
                    } else if (parseInt == 2) {
                        this.d.setVisibility(0);
                        this.e.setText(invoiceTitleInfo.typeName);
                        if (!this.k) {
                            this.k = true;
                            g(parseInt);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
