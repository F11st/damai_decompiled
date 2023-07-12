package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailAddressViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailDeliveryViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailInvoiceViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLineViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLogistViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailPickUpViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailPriceViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailProjectViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailShareViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTicketNotifyViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTicketViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTimeViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.co1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<co1> b;

    public OrderDetailAdapter(Context context, List<co1> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "946838549") ? ((Integer) ipChange.ipc$dispatch("946838549", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1116111932") ? ((Integer) ipChange.ipc$dispatch("1116111932", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403308092")) {
            ipChange.ipc$dispatch("-1403308092", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            co1 co1Var = this.b.get(i);
            switch (co1Var.a) {
                case 0:
                    ((OrderDetailLogistViewHolder) viewHolder).b(co1Var.d, co1Var.b);
                    return;
                case 1:
                    ((OrderDetailAddressViewHolder) viewHolder).b(co1Var.s);
                    return;
                case 2:
                    ((OrderDetailPickUpViewHolder) viewHolder).b(co1Var.t);
                    return;
                case 3:
                    ((OrderDetailTicketViewHolder) viewHolder).b(co1Var.e);
                    return;
                case 4:
                    ((OrderDetailProjectViewHolder) viewHolder).t(co1Var.b, co1Var.g, co1Var.i, co1Var.d, co1Var.j, co1Var.k, co1Var.m, co1Var.l, co1Var.n, co1Var.o, co1Var.p, co1Var.H);
                    return;
                case 5:
                    ((OrderDetailPriceViewHolder) viewHolder).b(co1Var.h, co1Var.q);
                    return;
                case 6:
                    ((OrderDetailDeliveryViewHolder) viewHolder).a(co1Var.r, co1Var.s, co1Var.u, co1Var.v);
                    return;
                case 7:
                    ((OrderDetailTicketNotifyViewHolder) viewHolder).g(co1Var.c, co1Var.b, co1Var.F, co1Var.G);
                    return;
                case 8:
                    ((OrderDetailInvoiceViewHolder) viewHolder).b(co1Var.b, co1Var.c, co1Var.w, co1Var.x, co1Var.y);
                    return;
                case 9:
                    ((OrderDetailTimeViewHolder) viewHolder).b(co1Var.b, co1Var.z, co1Var.A, co1Var.E, co1Var.D, co1Var.B, co1Var.C);
                    return;
                case 10:
                    ((OrderDetailGuideViewHolder) viewHolder).e(co1Var.c, co1Var.b);
                    return;
                case 11:
                    ((OrderDetailLineViewHolder) viewHolder).a(ContextCompat.getColor(this.a, R$color.color_f8f8f8));
                    return;
                case 12:
                    ((OrderDetailShareViewHolder) viewHolder).b(co1Var.f);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210389170")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("210389170", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        switch (i) {
            case 0:
                return new OrderDetailLogistViewHolder(viewGroup.getContext(), from);
            case 1:
                return new OrderDetailAddressViewHolder(viewGroup.getContext(), from);
            case 2:
                return new OrderDetailPickUpViewHolder(viewGroup.getContext(), from);
            case 3:
                return new OrderDetailTicketViewHolder(viewGroup.getContext(), from);
            case 4:
                return new OrderDetailProjectViewHolder(viewGroup.getContext(), from);
            case 5:
                return new OrderDetailPriceViewHolder(viewGroup.getContext(), from);
            case 6:
                return new OrderDetailDeliveryViewHolder(from);
            case 7:
                return new OrderDetailTicketNotifyViewHolder(viewGroup.getContext(), from);
            case 8:
                return new OrderDetailInvoiceViewHolder(viewGroup.getContext(), from);
            case 9:
                return new OrderDetailTimeViewHolder(viewGroup.getContext(), from);
            case 10:
                return new OrderDetailGuideViewHolder(viewGroup.getContext(), from);
            case 11:
                return new OrderDetailLineViewHolder(viewGroup.getContext(), from, 12);
            case 12:
                return new OrderDetailShareViewHolder(viewGroup.getContext(), from);
            default:
                return null;
        }
    }
}
