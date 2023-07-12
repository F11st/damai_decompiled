package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.im.AliMeUtil;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailFaq;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.ServiceOrderInfo;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.m62;
import tb.pp2;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailTicketNotifyViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private String b;
    private String c;
    private int d;
    private LinearLayout.LayoutParams e;
    private LinearLayout f;
    private FlowLayout g;
    private TextView h;
    private View i;
    private LinearLayout j;
    private TextView k;
    private boolean l;
    protected DMProgressDialog m;
    private View.OnClickListener n;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(OrderDetailTicketNotifyViewHolder orderDetailTicketNotifyViewHolder) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "213774675")) {
                ipChange.ipc$dispatch("213774675", new Object[]{this, dialogInterface});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class a implements AliMeUtil.UserCodeListener {
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTicketNotifyViewHolder$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0082a implements AliMeUtil.AliMeTokenListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0082a() {
                }

                @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
                public void onFailed() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1647626987")) {
                        ipChange.ipc$dispatch("1647626987", new Object[]{this});
                        return;
                    }
                    OrderDetailTicketNotifyViewHolder.this.i();
                    OrderDetailTicketNotifyViewHolder.this.l = true;
                    AliMeUtil.o();
                }

                @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
                public void onSuccess(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-633943511")) {
                        ipChange.ipc$dispatch("-633943511", new Object[]{this, str});
                        return;
                    }
                    OrderDetailTicketNotifyViewHolder.this.i();
                    OrderDetailTicketNotifyViewHolder.this.l = true;
                    if (!TextUtils.isEmpty(str)) {
                        AliMeUtil.b(OrderDetailTicketNotifyViewHolder.this.a, AliMeUtil.g(AliMeUtil.FROM_ORDER_DETAIL_QUEST, str, OrderDetailTicketNotifyViewHolder.this.b, OrderDetailTicketNotifyViewHolder.this.c, b.this.a));
                    } else {
                        AliMeUtil.o();
                    }
                }
            }

            a() {
            }

            @Override // cn.damai.im.AliMeUtil.UserCodeListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1097580194")) {
                    ipChange.ipc$dispatch("-1097580194", new Object[]{this});
                    return;
                }
                OrderDetailTicketNotifyViewHolder.this.i();
                OrderDetailTicketNotifyViewHolder.this.l = true;
                AliMeUtil.o();
            }

            @Override // cn.damai.im.AliMeUtil.UserCodeListener
            public void onSuccess(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "219616824")) {
                    ipChange.ipc$dispatch("219616824", new Object[]{this, Long.valueOf(j)});
                } else {
                    AliMeUtil.e(j, AliMeUtil.FROM_ORDER_DETAIL_QUEST, new C0082a());
                }
            }
        }

        b(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "682414334")) {
                ipChange.ipc$dispatch("682414334", new Object[]{this, view});
            } else if (TextUtils.isEmpty(OrderDetailTicketNotifyViewHolder.this.b) || !OrderDetailTicketNotifyViewHolder.this.l) {
            } else {
                OrderDetailTicketNotifyViewHolder.this.l = false;
                OrderDetailTicketNotifyViewHolder.this.h();
                cn.damai.common.user.c.e().x(pp2.u().r1(OrderDetailTicketNotifyViewHolder.this.b, OrderDetailTicketNotifyViewHolder.this.c, this.a, this.b));
                AliMeUtil.j(new a());
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
            if (AndroidInstantRuntime.support(ipChange, "-1501262593")) {
                ipChange.ipc$dispatch("-1501262593", new Object[]{this, view});
            } else if (TextUtils.isEmpty(OrderDetailTicketNotifyViewHolder.this.c)) {
            } else {
                cn.damai.common.user.c.e().x(pp2.u().F(z20.E(), OrderDetailTicketNotifyViewHolder.this.c));
                AliMeUtil.k(OrderDetailTicketNotifyViewHolder.this.a, AliMeUtil.FROM_ORDER_DETAILS);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ ServiceOrderInfo b;

        d(String str, ServiceOrderInfo serviceOrderInfo) {
            this.a = str;
            this.b = serviceOrderInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "610027776")) {
                ipChange.ipc$dispatch("610027776", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().x(this.a));
            DMNav.from(OrderDetailTicketNotifyViewHolder.this.a).toUri(this.b.progressUrl);
        }
    }

    public OrderDetailTicketNotifyViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_ticket_info_item, (ViewGroup) null));
        this.l = true;
        this.n = new c();
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        this.d = (DisplayMetrics.getwidthPixels(m62.b(context)) - m62.a(context, 15.0f)) / 2;
        this.e = new LinearLayout.LayoutParams(this.d, -2);
        this.f = (LinearLayout) this.itemView.findViewById(R$id.ll_user_service);
        this.g = (FlowLayout) this.itemView.findViewById(R$id.fl_quest);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_ticket_title);
        this.i = this.itemView.findViewById(R$id.line_ticket_title);
        this.j = (LinearLayout) this.itemView.findViewById(R$id.ll_after_service);
        this.k = (TextView) this.itemView.findViewById(R$id.after_service_content);
        this.f.setOnClickListener(this.n);
    }

    private View f(OrderDetailFaq orderDetailFaq, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124740055")) {
            return (View) ipChange.ipc$dispatch("124740055", new Object[]{this, orderDetailFaq, Integer.valueOf(i)});
        }
        if (orderDetailFaq == null) {
            return null;
        }
        String str = orderDetailFaq.question;
        if (str == null) {
            str = "";
        }
        if (this.e == null) {
            this.e = new LinearLayout.LayoutParams(this.d, -2);
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.order_detail_quest_text, (ViewGroup) this.g, false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_quest);
        textView.setText(str);
        inflate.setLayoutParams(this.e);
        textView.setOnClickListener(new b(str, i));
        return inflate;
    }

    public void g(String str, String str2, List<OrderDetailFaq> list, ServiceOrderInfo serviceOrderInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692352634")) {
            ipChange.ipc$dispatch("692352634", new Object[]{this, str, str2, list, serviceOrderInfo});
            return;
        }
        this.b = str;
        this.c = str2;
        if (serviceOrderInfo != null && serviceOrderInfo.isShowView()) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(this.j, "aftersalesservice", "problem", pp2.ORDER_DETAL_PAGE, hashMap);
            this.j.setVisibility(0);
            this.k.setText(serviceOrderInfo.afterServiceGuide);
            if (!TextUtils.isEmpty(serviceOrderInfo.progressUrl)) {
                this.j.setOnClickListener(new d(str, serviceOrderInfo));
            }
        } else {
            this.j.setVisibility(8);
        }
        int e = wh2.e(list);
        if (e > 0) {
            this.g.setVisibility(0);
            this.g.removeAllViews();
            for (int i = 0; i < e; i++) {
                View f = f(list.get(i), i);
                if (f != null) {
                    this.g.addView(f);
                }
            }
        } else {
            this.g.setVisibility(8);
        }
        if (e <= 0 && (serviceOrderInfo == null || !serviceOrderInfo.isShowView())) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        this.i.setVisibility(0);
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463339532")) {
            ipChange.ipc$dispatch("-463339532", new Object[]{this});
            return;
        }
        if (this.m == null) {
            DMProgressDialog a2 = new DMProgressDialog(this.a).a();
            this.m = a2;
            a2.setOnDismissListener(new a(this));
        }
        this.m.show();
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079260120")) {
            ipChange.ipc$dispatch("-1079260120", new Object[]{this});
            return;
        }
        DMProgressDialog dMProgressDialog = this.m;
        if (dMProgressDialog != null) {
            dMProgressDialog.dismiss();
            this.m = null;
        }
    }
}
