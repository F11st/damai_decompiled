package cn.damai.ticklet.ui.detailholder;

import android.app.Activity;
import android.view.View;
import cn.damai.ticklet.bean.TicketExtMapBean;
import cn.damai.ticklet.inteface.TickletDetailCallback;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TicketExtMapViewHolder extends BaseViewHolder<TicketExtMapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TickletDetailSceneVenueItemHolder viewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketExtMapViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.viewHolder = new TickletDetailSceneVenueItemHolder(view);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731794785")) {
            ipChange.ipc$dispatch("1731794785", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        TicketExtMapBean value = getValue();
        Activity activity = iItem.getPageContext().getActivity();
        TickletDetailCallback tickletDetailCallback = activity instanceof TickletDetailCallback ? (TickletDetailCallback) activity : null;
        if (tickletDetailCallback != null) {
            this.viewHolder.e(value, tickletDetailCallback);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036473639")) {
            return ((Boolean) ipChange.ipc$dispatch("2036473639", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554570975")) {
            return ((Boolean) ipChange.ipc$dispatch("-1554570975", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @NotNull
    public final TickletDetailSceneVenueItemHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-868655988") ? (TickletDetailSceneVenueItemHolder) ipChange.ipc$dispatch("-868655988", new Object[]{this}) : this.viewHolder;
    }

    public final void setViewHolder(@NotNull TickletDetailSceneVenueItemHolder tickletDetailSceneVenueItemHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299399328")) {
            ipChange.ipc$dispatch("-299399328", new Object[]{this, tickletDetailSceneVenueItemHolder});
            return;
        }
        b41.i(tickletDetailSceneVenueItemHolder, "<set-?>");
        this.viewHolder = tickletDetailSceneVenueItemHolder;
    }
}
