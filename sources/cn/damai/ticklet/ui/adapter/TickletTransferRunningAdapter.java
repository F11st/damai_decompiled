package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.py2;
import tb.x30;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferRunningAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<TickletTransferManagerListExtra> a = new ArrayList();
    private Context b;
    private TickletTransferCallback c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        TextView d;
        LinearLayout e;
        LinearLayout f;
        LinearLayout g;
        TextView h;
        View i;

        public ViewHolder(TickletTransferRunningAdapter tickletTransferRunningAdapter, View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletTransferManagerListExtra a;
        final /* synthetic */ int b;

        a(TickletTransferManagerListExtra tickletTransferManagerListExtra, int i) {
            this.a = tickletTransferManagerListExtra;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-148236443")) {
                ipChange.ipc$dispatch("-148236443", new Object[]{this, view});
                return;
            }
            TickletTransferCallback tickletTransferCallback = TickletTransferRunningAdapter.this.c;
            TickletTransferManagerListExtra tickletTransferManagerListExtra = this.a;
            tickletTransferCallback.callCancelTransfer(tickletTransferManagerListExtra.transferRecordId, this.b, tickletTransferManagerListExtra.recvUserMobile);
        }
    }

    public TickletTransferRunningAdapter(Activity activity, LayoutInflater layoutInflater) {
        this.b = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291344325")) {
            ipChange.ipc$dispatch("291344325", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TickletTransferManagerListExtra tickletTransferManagerListExtra = this.a.get(i);
        if (tickletTransferManagerListExtra == null) {
            return;
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.e.setVisibility(0);
        viewHolder.d.setVisibility(0);
        viewHolder.b.setText(tickletTransferManagerListExtra.fullSeatInfo);
        viewHolder.f.setVisibility(0);
        if (!TextUtils.isEmpty(tickletTransferManagerListExtra.realCountDown)) {
            viewHolder.c.setVisibility(0);
            TextView textView = viewHolder.c;
            textView.setText("剩余时间 " + x30.c(tickletTransferManagerListExtra.realCountDown));
        } else if (!TextUtils.isEmpty(tickletTransferManagerListExtra.transferValidityTime)) {
            viewHolder.c.setVisibility(0);
            TextView textView2 = viewHolder.c;
            textView2.setText("剩余时间 " + x30.c(String.valueOf(Long.parseLong(tickletTransferManagerListExtra.transferValidityTime) - x30.a())));
        } else {
            viewHolder.c.setVisibility(8);
        }
        if (TextUtils.isEmpty(tickletTransferManagerListExtra.recvUserMobile) && TextUtils.isEmpty(tickletTransferManagerListExtra.recvUserNick)) {
            viewHolder.a.setVisibility(4);
        } else {
            viewHolder.a.setVisibility(0);
            if (!TextUtils.isEmpty(tickletTransferManagerListExtra.recvUserMobile)) {
                viewHolder.a.setText(tickletTransferManagerListExtra.recvUserMobile);
            } else {
                viewHolder.a.setText(tickletTransferManagerListExtra.recvUserNick);
            }
        }
        if (!TextUtils.isEmpty(tickletTransferManagerListExtra.productSystemVoucherIdWithPre)) {
            py2.E(viewHolder.g, true);
            viewHolder.h.setText(tickletTransferManagerListExtra.productSystemVoucherIdWithPre);
        } else {
            py2.E(viewHolder.g, false);
        }
        viewHolder.d.setOnClickListener(new a(tickletTransferManagerListExtra, i));
        if (i != this.a.size() - 1) {
            viewHolder.i.setVisibility(0);
        } else {
            viewHolder.i.setVisibility(4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466537519")) {
            return (ViewHolder) ipChange.ipc$dispatch("-466537519", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_transfer_running_or_success_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (TextView) inflate.findViewById(R$id.ticklet_transfer_phone);
        viewHolder.d = (TextView) inflate.findViewById(R$id.ticklet_transfer_cancel);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_transfer_seat_num);
        viewHolder.e = (LinearLayout) inflate.findViewById(R$id.ticklet_transfer_ll_running_time);
        viewHolder.g = (LinearLayout) inflate.findViewById(R$id.ticklet_ll_transfer_tn);
        viewHolder.h = (TextView) inflate.findViewById(R$id.ticklet_transfer_tn);
        viewHolder.f = (LinearLayout) inflate.findViewById(R$id.ticklet_transfer_ll_phone);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_transfer_remainingTime);
        viewHolder.i = inflate.findViewById(R$id.ticklet_transfer_running_success_line);
        return viewHolder;
    }

    public void d(TickletTransferCallback tickletTransferCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5052711")) {
            ipChange.ipc$dispatch("5052711", new Object[]{this, tickletTransferCallback});
        } else {
            this.c = tickletTransferCallback;
        }
    }

    public void e(List<TickletTransferManagerListExtra> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655050319")) {
            ipChange.ipc$dispatch("-655050319", new Object[]{this, list});
        } else {
            this.a = list;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1623375084") ? ((Integer) ipChange.ipc$dispatch("-1623375084", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349773720")) {
            return ((Long) ipChange.ipc$dispatch("349773720", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        return 0L;
    }

    public TickletTransferRunningAdapter(Context context) {
        this.b = context;
    }
}
