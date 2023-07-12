package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceDataList;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.InvoiceDetailDeliveryViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.InvoiceDetailLogisticsViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.InvoiceDetailViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderInvoiceDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<InvoiceDataList> b;
    private InvoiceDetailViewHolder c;
    private InvoiceDetailDeliveryViewHolder d;
    private InvoiceDetailLogisticsViewHolder e;

    public OrderInvoiceDetailAdapter(Context context, List<InvoiceDataList> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-393946042") ? ((Integer) ipChange.ipc$dispatch("-393946042", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1756251117") ? ((Integer) ipChange.ipc$dispatch("1756251117", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994581261")) {
            ipChange.ipc$dispatch("-994581261", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            InvoiceDataList invoiceDataList = this.b.get(i);
            int i2 = invoiceDataList.type;
            if (i2 == 0) {
                ((InvoiceDetailViewHolder) viewHolder).a(invoiceDataList.invoiceDetail);
            } else if (i2 == 1) {
                ((InvoiceDetailDeliveryViewHolder) viewHolder).a(invoiceDataList.invoicesTrans);
            } else if (i2 != 2) {
            } else {
                ((InvoiceDetailLogisticsViewHolder) viewHolder).a(invoiceDataList.expressInfo, invoiceDataList.expressFirst, invoiceDataList.expressEnd);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130055779")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("130055779", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i == 0) {
            InvoiceDetailViewHolder invoiceDetailViewHolder = new InvoiceDetailViewHolder(from);
            this.c = invoiceDetailViewHolder;
            return invoiceDetailViewHolder;
        } else if (i == 1) {
            InvoiceDetailDeliveryViewHolder invoiceDetailDeliveryViewHolder = new InvoiceDetailDeliveryViewHolder(from);
            this.d = invoiceDetailDeliveryViewHolder;
            return invoiceDetailDeliveryViewHolder;
        } else if (i != 2) {
            return null;
        } else {
            InvoiceDetailLogisticsViewHolder invoiceDetailLogisticsViewHolder = new InvoiceDetailLogisticsViewHolder(this.a, from);
            this.e = invoiceDetailLogisticsViewHolder;
            return invoiceDetailLogisticsViewHolder;
        }
    }
}
