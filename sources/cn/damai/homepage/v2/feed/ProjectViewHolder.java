package cn.damai.homepage.v2.feed;

import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.viewholder.HomeFeedProjectViewHolder;
import cn.damai.homepage.bean.WaterFlowRec2Project;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.sy0;
import tb.ux0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ProjectViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public final sy0 homeProjectItemListenerV2;
    private final HomeFeedProjectViewHolder<WaterFlowRecommendItem> viewHolder;

    public ProjectViewHolder(View view) {
        super(view);
        sy0 sy0Var = new sy0(view.getContext());
        this.homeProjectItemListenerV2 = sy0Var;
        this.viewHolder = new HomeFeedProjectViewHolder<>(null, view, sy0Var);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818033962")) {
            ipChange.ipc$dispatch("-818033962", new Object[]{this, iItem});
            return;
        }
        try {
            this.homeProjectItemListenerV2.c(ux0.g(getComponentActions()), iItem.getIndex());
            this.viewHolder.a(new WaterFlowRec2Project(getValue()), 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
