package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.in2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketOrderView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private Context context;
    private ImageView orderIcon;
    private TextView orderNum;
    private View partent;
    private int postion;
    private UserTicketTable ticket;
    private String viewType;

    public TickletTicketOrderView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92763097")) {
            ipChange.ipc$dispatch("-92763097", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_order_num_layout, this);
        this.partent = inflate;
        this.orderNum = (TextView) inflate.findViewById(R$id.tv_coupon_order_num);
        this.orderIcon = (ImageView) this.partent.findViewById(R$id.iv_coupon_order_icon);
        if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.viewType)) {
            setOnClickListener(null);
            this.orderIcon.setVisibility(8);
            return;
        }
        setOnClickListener(this);
        this.orderIcon.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303195571")) {
            ipChange.ipc$dispatch("-303195571", new Object[]{this, view});
        } else if (this.context != null) {
            un2 k = un2.k();
            UserTicketTable userTicketTable = this.ticket;
            C0529c.e().x(C0528b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "center_" + this.postion, "checkorder", k.u(userTicketTable.tradeOrderId, userTicketTable.getPerformId()), Boolean.TRUE));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.ticket.tradeOrderId);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(cs.COUPON_ORDER_DETAIL));
        }
    }

    public void update(UserTicketTable userTicketTable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590128537")) {
            ipChange.ipc$dispatch("590128537", new Object[]{this, userTicketTable, Integer.valueOf(i)});
        } else if (userTicketTable == null) {
        } else {
            this.ticket = userTicketTable;
            this.postion = i;
            TextView textView = this.orderNum;
            textView.setText("订单号：" + userTicketTable.tradeOrderId);
            C0529c e = C0529c.e();
            TextView textView2 = this.orderNum;
            e.G(textView2, "checkorder", "center_" + this.postion, un2.TICKLET_DETAIL_PAGE, un2.k().u(userTicketTable.tradeOrderId, userTicketTable.getPerformId()));
        }
    }

    public TickletTicketOrderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketOrderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context;
        this.activity = (DamaiBaseActivity) context;
        setGravity(17);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
