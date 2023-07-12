package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceDataHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailDeliveryViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailLogisticsViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HNInvoiceDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<HNInvoiceDataHolder> b;

    public HNInvoiceDetailAdapter(Context context, List<HNInvoiceDataHolder> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "603169116") ? ((Integer) ipChange.ipc$dispatch("603169116", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "375950851") ? ((Integer) ipChange.ipc$dispatch("375950851", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2086500893")) {
            ipChange.ipc$dispatch("2086500893", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            HNInvoiceDataHolder hNInvoiceDataHolder = this.b.get(i);
            int i2 = hNInvoiceDataHolder.mType;
            if (i2 == 0) {
                ((HNInvoiceDetailViewHolder) viewHolder).a(hNInvoiceDataHolder.invoicesDetail);
            } else if (i2 == 1) {
                ((HNInvoiceDetailDeliveryViewHolder) viewHolder).a(hNInvoiceDataHolder.expressNo, hNInvoiceDataHolder.expressName, hNInvoiceDataHolder.status);
            } else if (i2 != 2) {
            } else {
                ((HNInvoiceDetailLogisticsViewHolder) viewHolder).a(hNInvoiceDataHolder.mTransInfo, hNInvoiceDataHolder.mTransFirst, hNInvoiceDataHolder.mTransEnd);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899746183")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1899746183", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new HNInvoiceDetailLogisticsViewHolder(this.a, from);
            }
            return new HNInvoiceDetailDeliveryViewHolder(from);
        }
        return new HNInvoiceDetailViewHolder(from);
    }
}
