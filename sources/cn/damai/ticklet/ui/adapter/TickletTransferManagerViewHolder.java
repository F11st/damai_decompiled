package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rp2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferManagerViewHolder extends ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;
    private TransferAllowAdapter b;
    private TickletTransferSuccessAdapter c;
    private TickletTransferRunningAdapter d;
    private TextView e;

    public TickletTransferManagerViewHolder(Activity activity, TickletTransferCallback tickletTransferCallback, LayoutInflater layoutInflater, int i) {
        super(layoutInflater.inflate(R$layout.ticklet_transfer_manager_layout, (ViewGroup) null));
        this.a = (RecyclerView) this.itemView.findViewById(R$id.ticklet_transfer_manager_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(1);
        this.a.setLayoutManager(linearLayoutManager);
        if (i == 0) {
            TransferAllowAdapter transferAllowAdapter = new TransferAllowAdapter(activity, layoutInflater);
            this.b = transferAllowAdapter;
            transferAllowAdapter.d(tickletTransferCallback);
            this.a.setAdapter(this.b);
        } else if (i == 1) {
            TickletTransferSuccessAdapter tickletTransferSuccessAdapter = new TickletTransferSuccessAdapter(activity, layoutInflater);
            this.c = tickletTransferSuccessAdapter;
            this.a.setAdapter(tickletTransferSuccessAdapter);
        } else if (i == 2) {
            TickletTransferRunningAdapter tickletTransferRunningAdapter = new TickletTransferRunningAdapter(activity, layoutInflater);
            this.d = tickletTransferRunningAdapter;
            tickletTransferRunningAdapter.d(tickletTransferCallback);
            this.a.setAdapter(this.d);
        }
        this.e = (TextView) this.itemView.findViewById(R$id.ticklet_transfer_manager_title_text);
        TextView textView = (TextView) this.itemView.findViewById(R$id.ticklet_transfer_manager_title_more_btn);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void a(rp2 rp2Var, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418714045")) {
            ipChange.ipc$dispatch("1418714045", new Object[]{this, rp2Var, Integer.valueOf(i)});
            return;
        }
        this.e.setText(rp2Var.b());
        if (i == 0) {
            this.b.e(rp2Var.a());
        } else if (i == 1) {
            this.c.c(rp2Var.c());
        } else if (i != 2) {
        } else {
            this.d.e(rp2Var.d());
        }
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837609164")) {
            ipChange.ipc$dispatch("-1837609164", new Object[]{this});
            return;
        }
        TransferAllowAdapter transferAllowAdapter = this.b;
        if (transferAllowAdapter != null) {
            transferAllowAdapter.notifyDataSetChanged();
        }
        TickletTransferSuccessAdapter tickletTransferSuccessAdapter = this.c;
        if (tickletTransferSuccessAdapter != null) {
            tickletTransferSuccessAdapter.notifyDataSetChanged();
        }
        TickletTransferRunningAdapter tickletTransferRunningAdapter = this.d;
        if (tickletTransferRunningAdapter != null) {
            tickletTransferRunningAdapter.notifyDataSetChanged();
        }
    }

    public void c(int i) {
        TickletTransferRunningAdapter tickletTransferRunningAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131279793")) {
            ipChange.ipc$dispatch("-1131279793", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            TransferAllowAdapter transferAllowAdapter = this.b;
            if (transferAllowAdapter != null) {
                transferAllowAdapter.notifyDataSetChanged();
            }
        } else if (i != 1) {
            if (i == 2 && (tickletTransferRunningAdapter = this.d) != null) {
                tickletTransferRunningAdapter.notifyDataSetChanged();
            }
        } else {
            TickletTransferSuccessAdapter tickletTransferSuccessAdapter = this.c;
            if (tickletTransferSuccessAdapter != null) {
                tickletTransferSuccessAdapter.notifyDataSetChanged();
            }
        }
    }
}
