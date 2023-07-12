package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketItemFloatLayerView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTicketCallback callback;
    private TextView certCardName;
    Context context;
    LinearLayout ll_deatil_seat;
    private TextView mVoucherIdTv;
    TickletTicketMainView mainView;
    TickletTicketOrderView orderView;
    View partent;
    TickletTicketHeadView ticketHeadView;
    TickletTicketTipView ticketTipView;
    LinearLayout ticklet_ticket_item_layout;

    public TickletTicketItemFloatLayerView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105919265")) {
            ipChange.ipc$dispatch("2105919265", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_float_layer_item, this);
        this.partent = inflate;
        this.ticklet_ticket_item_layout = (LinearLayout) inflate.findViewById(R$id.ticklet_ticket_item_layout);
        this.ticketHeadView = (TickletTicketHeadView) this.partent.findViewById(R$id.ticklet_ticket_rl_header_view);
        this.ticketTipView = (TickletTicketTipView) this.partent.findViewById(R$id.ticklet_ticket_rl_tip_view);
        this.mainView = (TickletTicketMainView) this.partent.findViewById(R$id.ticklet_ticket_main_view);
        this.ll_deatil_seat = (LinearLayout) this.partent.findViewById(R$id.ll_deatil_seat);
        this.mVoucherIdTv = (TextView) this.partent.findViewById(R$id.ticket_unique_no_tv);
        this.certCardName = (TextView) this.partent.findViewById(R$id.ticket_card_name_cert);
        this.orderView = (TickletTicketOrderView) this.partent.findViewById(R$id.ticklet_ticket_order_view);
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41430997")) {
            ipChange.ipc$dispatch("41430997", new Object[]{this, tickletTicketCallback});
        } else {
            this.callback = tickletTicketCallback;
        }
    }

    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873742324")) {
            ipChange.ipc$dispatch("-873742324", new Object[]{this, userTicketTable, tickletExtraInfo, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable == null) {
        } else {
            this.ticketHeadView.update(userTicketTable, i2, i);
            this.mainView.setTicketCallback(this.callback);
            this.mainView.update(this, userTicketTable, tickletExtraInfo, i2, i);
            this.ticketTipView.update(userTicketTable, tickletExtraInfo);
            if (userTicketTable.isCertCardTicket() && userTicketTable.isCertShowMode()) {
                py2.E(this.certCardName, false);
            } else if (TextUtils.isEmpty(userTicketTable.getVoucherCertName()) && TextUtils.isEmpty(userTicketTable.getVoucherCertNo())) {
                py2.E(this.certCardName, false);
            } else {
                py2.E(this.certCardName, true);
                String voucherCertName = !TextUtils.isEmpty(userTicketTable.getVoucherCertName()) ? userTicketTable.getVoucherCertName() : "";
                String voucherCertNo = TextUtils.isEmpty(userTicketTable.getVoucherCertNo()) ? "" : userTicketTable.getVoucherCertNo();
                TextView textView = this.certCardName;
                textView.setText(voucherCertName + AltriaXLaunchTime.SPACE + voucherCertNo);
            }
            if (userTicketTable.isCouponTicket() && !TextUtils.isEmpty(userTicketTable.tradeOrderId)) {
                this.orderView.update(userTicketTable, i);
                py2.f();
                py2.G(this.orderView);
            } else {
                py2.f();
                py2.w(this.orderView);
            }
            this.ll_deatil_seat.removeAllViews();
            py2.y(this.context, userTicketTable, this.ll_deatil_seat);
            py2.F(this.mVoucherIdTv, userTicketTable.getProductSystemVoucherIdWithPre());
        }
    }

    public TickletTicketItemFloatLayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketItemFloatLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
