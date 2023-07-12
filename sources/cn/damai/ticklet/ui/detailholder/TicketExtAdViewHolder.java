package cn.damai.ticklet.ui.detailholder;

import android.view.View;
import cn.damai.ticklet.bean.TicketExtAdBean;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TicketExtAdViewHolder extends BaseViewHolder<TicketExtAdBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TickletDetailAdvertItemViewHolder viewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketExtAdViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.viewHolder = new TickletDetailAdvertItemViewHolder(view);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13484158")) {
            ipChange.ipc$dispatch("13484158", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        this.viewHolder.b(getValue());
    }

    @NotNull
    public final TickletDetailAdvertItemViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "814687161") ? (TickletDetailAdvertItemViewHolder) ipChange.ipc$dispatch("814687161", new Object[]{this}) : this.viewHolder;
    }

    public final void setViewHolder(@NotNull TickletDetailAdvertItemViewHolder tickletDetailAdvertItemViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254740967")) {
            ipChange.ipc$dispatch("254740967", new Object[]{this, tickletDetailAdvertItemViewHolder});
            return;
        }
        b41.i(tickletDetailAdvertItemViewHolder, "<set-?>");
        this.viewHolder = tickletDetailAdvertItemViewHolder;
    }
}
