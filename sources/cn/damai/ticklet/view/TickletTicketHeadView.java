package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$dimen;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.in2;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketHeadView extends RelativeLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private TextView bnt_position;
    private Context context;
    private DMIconFontTextView forgetIcon;
    private LinearLayout ll_forget_card;
    private View partent;
    private UserTicketTable ticket;
    private TickletTicketCallback ticketCallback;
    private TextView ticklet_ticket_head_num_line;
    private LinearLayout ticklet_ticket_num;
    private TextView tvForgetConent;
    private TextView tv_ticket_unit;
    private TextView tv_total;
    private String viewType;

    public TickletTicketHeadView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791979833")) {
            ipChange.ipc$dispatch("791979833", new Object[]{this});
            return;
        }
        if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_head_float_layer_layout, this);
        } else {
            View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_head_layout, this);
            this.partent = inflate;
            this.ll_forget_card = (LinearLayout) inflate.findViewById(R$id.ticklet_ticket_ll_forget_card);
            this.forgetIcon = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_tv_tip_icon);
            this.tvForgetConent = (TextView) this.partent.findViewById(R$id.ticklt_forget_card_tip_content);
            this.ll_forget_card.setOnClickListener(this);
        }
        this.bnt_position = (TextView) this.partent.findViewById(R$id.bnt_position);
        this.tv_total = (TextView) this.partent.findViewById(R$id.tv_total);
        this.tv_ticket_unit = (TextView) this.partent.findViewById(R$id.tv_ticket_unit);
        this.ticklet_ticket_head_num_line = (TextView) this.partent.findViewById(R$id.ticklet_ticket_head_num_line);
        this.ticklet_ticket_num = (LinearLayout) this.partent.findViewById(R$id.ticklet_ticket_num_tip_layout);
        if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnt_position.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ll_forget_card.getLayoutParams();
        if (in2.TICKLET_TICKET_VIEW_DETAIL_NFT.equals(getViewType())) {
            layoutParams.leftMargin = Math.round(getResources().getDimension(R$dimen.margin_1dp));
            layoutParams2.rightMargin = 0;
            setViewColor(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
        } else if ("DEFAULT".equals(getViewType())) {
            layoutParams.leftMargin = Math.round(getResources().getDimension(R$dimen.margin_20dp));
            layoutParams2.rightMargin = Math.round(getResources().getDimension(R$dimen.margin_15dp));
            setViewColor(Color.parseColor("#000000"), Color.parseColor("#ff2d79"));
        }
    }

    private void setViewColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963682194")) {
            ipChange.ipc$dispatch("963682194", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.bnt_position.setTextColor(i2);
        this.tv_total.setTextColor(i);
        this.tv_ticket_unit.setTextColor(i);
        this.ticklet_ticket_head_num_line.setTextColor(i);
        this.forgetIcon.setTextColor(i2);
        this.tvForgetConent.setTextColor(i2);
    }

    public String getViewType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1949191303") ? (String) ipChange.ipc$dispatch("-1949191303", new Object[]{this}) : this.viewType;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TickletTicketCallback tickletTicketCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509151967")) {
            ipChange.ipc$dispatch("1509151967", new Object[]{this, view});
        } else if (view.getId() != R$id.ticklet_ticket_ll_forget_card || (tickletTicketCallback = this.ticketCallback) == null) {
        } else {
            UserTicketTable userTicketTable = this.ticket;
            tickletTicketCallback.cardCorrespondingNumRequest(userTicketTable.voucherUniqueKey, userTicketTable.getPerformId(), this.ticket.getVoucherCertName(), this.ticket.getVoucherCertNo());
        }
    }

    public void setTicketCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803190055")) {
            ipChange.ipc$dispatch("-1803190055", new Object[]{this, tickletTicketCallback});
        } else {
            this.ticketCallback = tickletTicketCallback;
        }
    }

    public void setViewType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177716091")) {
            ipChange.ipc$dispatch("-177716091", new Object[]{this, str});
        } else {
            this.viewType = str;
        }
    }

    public void update(UserTicketTable userTicketTable, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162939080")) {
            ipChange.ipc$dispatch("-1162939080", new Object[]{this, userTicketTable, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable == null) {
        } else {
            this.ticket = userTicketTable;
            if (i == 1) {
                this.bnt_position.setText(String.valueOf(i2 + 1));
                this.ticklet_ticket_head_num_line.setVisibility(8);
                this.tv_total.setVisibility(8);
                if (userTicketTable.isCouponTicket()) {
                    this.ticklet_ticket_num.setVisibility(4);
                } else {
                    this.ticklet_ticket_num.setVisibility(0);
                }
            } else if (i > 1) {
                this.ticklet_ticket_num.setVisibility(0);
                this.bnt_position.setText(String.valueOf(i2 + 1));
                this.tv_total.setText(String.valueOf(i));
            } else if (!in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
                this.ticklet_ticket_num.setVisibility(8);
            } else {
                this.ticklet_ticket_num.setVisibility(4);
            }
            if (userTicketTable.isCouponTicket()) {
                py2.f();
                py2.w(this.tv_ticket_unit);
            } else {
                py2.f();
                py2.G(this.tv_ticket_unit);
            }
            if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType()) || this.ll_forget_card == null) {
                return;
            }
            if ("1".equals(userTicketTable.isForgotCardEntrance)) {
                this.ll_forget_card.setVisibility(0);
            } else {
                this.ll_forget_card.setVisibility(8);
            }
        }
    }

    public TickletTicketHeadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context;
        this.activity = (DamaiBaseActivity) context;
        setGravity(16);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
