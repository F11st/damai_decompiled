package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketPerformTransferAcceptResult;
import cn.damai.ticklet.bean.TicketTable;
import cn.damai.ticklet.bean.Tips;
import cn.damai.uikit.view.DMActionButtonBgView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.py2;
import tb.x30;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferDetailWaitAcceptAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<TicketPerformTransferAcceptResult.TicketPerformTransferData> a;
    private Context b;
    private TickletTransferWaitCallback c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface TickletTransferWaitCallback {
        void acceptConfirm(TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        LinearLayout f;
        LinearLayout g;
        LinearLayout h;
        DMActionButtonBgView i;

        public ViewHolder(TickletTransferDetailWaitAcceptAdapter tickletTransferDetailWaitAcceptAdapter, View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketPerformTransferAcceptResult.TicketPerformTransferData a;

        a(TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData) {
            this.a = ticketPerformTransferData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1371932314")) {
                ipChange.ipc$dispatch("1371932314", new Object[]{this, view});
            } else {
                TickletTransferDetailWaitAcceptAdapter.this.c.acceptConfirm(this.a);
            }
        }
    }

    public TickletTransferDetailWaitAcceptAdapter(Context context, List<TicketPerformTransferAcceptResult.TicketPerformTransferData> list) {
        this.a = new ArrayList();
        this.b = context;
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903826911")) {
            ipChange.ipc$dispatch("903826911", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData = this.a.get(i);
        if (ticketPerformTransferData == null) {
            return;
        }
        viewHolder.i.setBackground(true);
        viewHolder.i.update("接收");
        viewHolder.itemView.setTag(Integer.valueOf(i));
        Tips tips = ticketPerformTransferData.headTitleTips;
        if (tips != null) {
            py2.F(viewHolder.a, tips.getText());
        }
        if (this.a.get(i).tips != null) {
            py2.F(viewHolder.b, ticketPerformTransferData.tips.getText());
        }
        py2.F(viewHolder.c, ticketPerformTransferData.projectName);
        if (!TextUtils.isEmpty(ticketPerformTransferData.timeTitle)) {
            viewHolder.d.setText(ticketPerformTransferData.timeTitle);
        } else {
            viewHolder.d.setText(x30.f(ticketPerformTransferData.beginTime.longValue()));
        }
        if (!TextUtils.isEmpty(ticketPerformTransferData.venueName)) {
            viewHolder.h.setVisibility(0);
            viewHolder.e.setText(ticketPerformTransferData.venueName);
        } else {
            viewHolder.h.setVisibility(8);
        }
        viewHolder.f.removeAllViews();
        if (this.a.get(i).ticketInfoVOs == null || this.a.get(i).ticketInfoVOs.size() <= 0) {
            z = false;
        } else {
            Iterator<TicketTable> it = this.a.get(i).ticketInfoVOs.iterator();
            z = false;
            while (it.hasNext()) {
                TicketTable next = it.next();
                if (!TextUtils.isEmpty(next.fullSeatInfo)) {
                    TextView textView = new TextView(this.b);
                    textView.setText(next.fullSeatInfo);
                    textView.setGravity(3);
                    textView.setTextColor(Color.parseColor("#0E0E0E"));
                    textView.setTextSize(14.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = 8;
                    viewHolder.f.addView(textView, layoutParams);
                    z = true;
                }
            }
        }
        if (z) {
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.g.setVisibility(8);
        }
        viewHolder.i.setOnClickListener(new a(ticketPerformTransferData));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526721609")) {
            return (ViewHolder) ipChange.ipc$dispatch("-526721609", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_transfer_wait_item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (TextView) inflate.findViewById(R$id.ticklet_detail_accept_num);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_detail_accept_invalid_time);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_detail_accept_perform_name);
        viewHolder.d = (TextView) inflate.findViewById(R$id.ticklet_transfer_tv_show_time_content);
        viewHolder.e = (TextView) inflate.findViewById(R$id.ticklet_transfer_tv_address_content);
        viewHolder.f = (LinearLayout) inflate.findViewById(R$id.ticklet_accept_transfer_ll_seat_content);
        viewHolder.g = (LinearLayout) inflate.findViewById(R$id.ticklet_accept_transfer_ll_seat);
        viewHolder.h = (LinearLayout) inflate.findViewById(R$id.ticklet_transfer_wait_address_layout);
        viewHolder.i = (DMActionButtonBgView) inflate.findViewById(R$id.ticklet_accept_transfer_confirm);
        return viewHolder;
    }

    public void d(TickletTransferWaitCallback tickletTransferWaitCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630507952")) {
            ipChange.ipc$dispatch("-1630507952", new Object[]{this, tickletTransferWaitCallback});
        } else {
            this.c = tickletTransferWaitCallback;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1371552841") ? ((Integer) ipChange.ipc$dispatch("1371552841", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698504179")) {
            return ((Long) ipChange.ipc$dispatch("-1698504179", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        return 0L;
    }
}
