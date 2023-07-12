package com.alient.onearch.adapter.component.raw;

import android.view.View;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0014\b\u0000\u0010\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u001a\b\u0001\u0010\u0006*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00028\u00000\u00052\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/alient/onearch/adapter/component/raw/RawView;", "Lcom/youku/arch/v3/view/IContract$Model;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Lcom/alient/onearch/adapter/view/AbsView;", "Landroid/view/View;", "renderView", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class RawView<M extends IContract.Model<GenericItem<ItemValue>>, P extends IContract.Presenter<GenericItem<ItemValue>, M>> extends AbsView<GenericItem<ItemValue>, M, P> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawView(@NotNull View view) {
        super(view);
        b41.i(view, "renderView");
    }
}
