package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.in2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketTipView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private View partent;
    private UserTicketTable ticket;
    private TextView tv_second_tips;
    private TextView tv_tips;
    private String viewType;

    public TickletTicketTipView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393917388")) {
            ipChange.ipc$dispatch("-393917388", new Object[]{this});
            return;
        }
        if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_tip_layout, this);
        } else {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_tip_layout, this);
        }
        this.tv_tips = (TextView) this.partent.findViewById(R$id.tv_tips);
        this.tv_second_tips = (TextView) this.partent.findViewById(R$id.tv_second_tips);
    }

    public TextView getTipTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1534613898") ? (TextView) ipChange.ipc$dispatch("-1534613898", new Object[]{this}) : this.tv_tips;
    }

    public String getViewType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-731837196") ? (String) ipChange.ipc$dispatch("-731837196", new Object[]{this}) : this.viewType;
    }

    public void setViewType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094444438")) {
            ipChange.ipc$dispatch("-1094444438", new Object[]{this, str});
        } else {
            this.viewType = str;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
        if (r0.equals("3") == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(cn.damai.ticklet.bean.UserTicketTable r10, cn.damai.ticklet.bean.TickletExtraInfo r11) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.view.TickletTicketTipView.update(cn.damai.ticklet.bean.UserTicketTable, cn.damai.ticklet.bean.TickletExtraInfo):void");
    }

    public TickletTicketTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context;
        setGravity(16);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
