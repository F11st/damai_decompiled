package com.alient.onearch.adapter.component.nomore;

import android.view.View;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.nomore.NoMoreContract;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/alient/onearch/adapter/component/nomore/NoMoreView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/nomore/NoMoreModel;", "Lcom/alient/onearch/adapter/component/nomore/NoMorePresent;", "Lcom/alient/onearch/adapter/component/nomore/NoMoreContract$View;", "", "content", "Ltb/wt2;", "renderContent", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class NoMoreView extends AbsView<GenericItem<ItemValue>, NoMoreModel, NoMorePresent> implements NoMoreContract.View {
    @NotNull
    private final TextView content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoMoreView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R.id.content);
        b41.h(findViewById, "view.findViewById(R.id.content)");
        this.content = (TextView) findViewById;
    }

    @Override // com.alient.onearch.adapter.component.nomore.NoMoreContract.View
    public void renderContent(@Nullable String str) {
        this.content.setText(str);
    }
}
