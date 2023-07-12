package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketItemView extends ConstraintLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTicketCallback callback;
    private TextView certCardName;
    Context context;
    TickletDetailEventCodeView eventCodeView;
    private TickletExtraInfo extraInfo;
    LinearLayout ll_deatil_seat;
    private int mPosition;
    private UserTicketTable mTicketTable;
    private TextView mVoucherIdTv;
    TickletTicketMainView mainView;
    TickletTicketOrderView orderView;
    View partent;
    private FrameLayout rlGetModel;
    TickletTicketStandPortalView standPortalView;
    TickletTicketHeadView ticketHeadView;
    TickletTicketTipView ticketTipView;
    TickletTicketActionView ticklet_ll_action;
    private TextView tvGetModelDesc;

    public TickletTicketItemView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278578092")) {
            ipChange.ipc$dispatch("1278578092", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_detail_item, this);
        this.partent = inflate;
        this.ticketHeadView = (TickletTicketHeadView) inflate.findViewById(R$id.ticklet_ticket_rl_header_view);
        this.ticketTipView = (TickletTicketTipView) this.partent.findViewById(R$id.ticklet_ticket_rl_tip_view);
        this.mainView = (TickletTicketMainView) this.partent.findViewById(R$id.ticklet_ticket_main_view);
        this.orderView = (TickletTicketOrderView) this.partent.findViewById(R$id.ticklet_ticket_order_view);
        this.standPortalView = (TickletTicketStandPortalView) this.partent.findViewById(R$id.ticklet_ticket_stand_portal_view);
        this.ticklet_ll_action = (TickletTicketActionView) this.partent.findViewById(R$id.ticklet_ll_action);
        this.ll_deatil_seat = (LinearLayout) this.partent.findViewById(R$id.ll_deatil_seat);
        this.mVoucherIdTv = (TextView) this.partent.findViewById(R$id.ticket_unique_no_tv);
        this.certCardName = (TextView) this.partent.findViewById(R$id.ticket_card_name_cert);
        this.eventCodeView = (TickletDetailEventCodeView) this.partent.findViewById(R$id.ticklet_per_tic_event_code);
        this.rlGetModel = (FrameLayout) this.partent.findViewById(R$id.ticket_get_model_layout);
        this.tvGetModelDesc = (TextView) this.partent.findViewById(R$id.tv_get_model_desc);
    }

    public TextView getTipTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "845742062") ? (TextView) ipChange.ipc$dispatch("845742062", new Object[]{this}) : this.ticketTipView.getTipTv();
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003443936")) {
            ipChange.ipc$dispatch("1003443936", new Object[]{this, tickletTicketCallback});
        } else {
            this.callback = tickletTicketCallback;
        }
    }

    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, TicketDeatilResult ticketDeatilResult, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471728131")) {
            ipChange.ipc$dispatch("-1471728131", new Object[]{this, userTicketTable, tickletExtraInfo, ticketDeatilResult, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable == null) {
        } else {
            this.mPosition = i;
            this.mTicketTable = userTicketTable;
            this.extraInfo = tickletExtraInfo;
            this.ticketHeadView.update(userTicketTable, i2, i);
            this.ticketHeadView.setTicketCallback(this.callback);
            this.ticketTipView.update(userTicketTable, tickletExtraInfo);
            this.mainView.setTicketCallback(this.callback);
            this.mainView.update(this, userTicketTable, tickletExtraInfo, i2, i);
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
            this.standPortalView.update(userTicketTable, i);
            this.ll_deatil_seat.removeAllViews();
            py2.y(this.context, userTicketTable, this.ll_deatil_seat);
            py2.F(this.mVoucherIdTv, userTicketTable.getProductSystemVoucherIdWithPre());
            this.ticklet_ll_action.addAction(userTicketTable, tickletExtraInfo, ticketDeatilResult, i);
            this.ticklet_ll_action.setTicketCallback(this.callback);
            this.eventCodeView.update(userTicketTable.activityCodeInfoVO, userTicketTable.voucherState);
            py2.f().g(this.rlGetModel, this.tvGetModelDesc, userTicketTable.getExtAttr());
        }
    }

    public TickletTicketItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
