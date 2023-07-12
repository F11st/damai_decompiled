package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketStandPortalView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private Context context;
    private LinearLayout llBg;
    private LinearLayout llStand;
    private View partent;
    private int postion;
    private String projectId;
    private TextView standEntry;
    private UserTicketTable ticket;
    private String viewType;

    public TickletTicketStandPortalView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751849029")) {
            ipChange.ipc$dispatch("-1751849029", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_stand_portal_layout, this);
        this.partent = inflate;
        this.llBg = (LinearLayout) inflate.findViewById(R$id.ll_stand_portal_view_bg);
        this.standEntry = (TextView) this.partent.findViewById(R$id.tv_stand_portal_entry);
        LinearLayout linearLayout = (LinearLayout) this.partent.findViewById(R$id.ll_stand_portal_icon);
        this.llStand = linearLayout;
        linearLayout.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934211297")) {
            ipChange.ipc$dispatch("1934211297", new Object[]{this, view});
        } else if (this.context == null || this.ticket.getStandPortal() == null) {
        } else {
            c.e().x(b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "center", "open_entrance_pic", un2.k().t(this.projectId, this.ticket.getPerformId()), Boolean.TRUE));
            py2.f().u((Activity) this.context, this.ticket.getStandPortal().pic);
        }
    }

    public void update(UserTicketTable userTicketTable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749306835")) {
            ipChange.ipc$dispatch("-1749306835", new Object[]{this, userTicketTable, Integer.valueOf(i)});
        } else if (userTicketTable != null && userTicketTable.isShowStandPortal()) {
            setVisibility(0);
            this.ticket = userTicketTable;
            this.postion = i;
            if (userTicketTable.isNftTicket()) {
                this.llBg.setBackgroundResource(R$drawable.shape_50ffffff_6_bg);
            } else {
                this.llBg.setBackgroundResource(R$drawable.shape_f7f8fa_6_bg);
            }
            this.standEntry.setText(userTicketTable.getStandPortal().desc);
            if (!TextUtils.isEmpty(userTicketTable.getStandPortal().pic)) {
                py2.E(this.llStand, true);
            } else {
                py2.E(this.llStand, false);
            }
            Context context = this.context;
            if (context == null || !(context instanceof TicketDeatilActivity)) {
                return;
            }
            this.projectId = ((TicketDeatilActivity) context).getProjectId();
            c e = c.e();
            TextView textView = this.standEntry;
            e.G(textView, "button_" + this.postion, "center", un2.TICKLET_DETAIL_PAGE, un2.k().t(this.projectId, userTicketTable.getPerformId()));
        } else {
            setVisibility(8);
        }
    }

    public TickletTicketStandPortalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketStandPortalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context;
        this.activity = (DamaiBaseActivity) context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
