package cn.damai.onearch.component.corner;

import android.view.View;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class TopCornerViewHolder extends BaseViewHolder<Object> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopCornerViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59947685")) {
            ipChange.ipc$dispatch("-59947685", new Object[]{this, iItem});
        } else {
            b41.i(iItem, "item");
        }
    }
}
