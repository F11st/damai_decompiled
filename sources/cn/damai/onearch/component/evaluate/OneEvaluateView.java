package cn.damai.onearch.component.evaluate;

import android.view.View;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import cn.damai.onearch.component.evaluate.OneEvaluate;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneEvaluateView extends AbsView<GenericItem<ItemValue>, OneEvaluateModel, OneEvaluatePresent> implements OneEvaluate.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @NotNull
    private final EvaluateItemViewHolder mEvaluateView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneEvaluateView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mEvaluateView = new EvaluateItemViewHolder(view);
    }

    @Override // cn.damai.onearch.component.evaluate.OneEvaluate.View
    @NotNull
    public EvaluateItemViewHolder getEvaluateHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1763813544") ? (EvaluateItemViewHolder) ipChange.ipc$dispatch("1763813544", new Object[]{this}) : this.mEvaluateView;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1605787763") ? (View) ipChange.ipc$dispatch("1605787763", new Object[]{this}) : this.itemView;
    }
}
