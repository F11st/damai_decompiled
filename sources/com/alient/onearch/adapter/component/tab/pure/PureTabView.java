package com.alient.onearch.adapter.component.tab.pure;

import android.view.View;
import com.alient.onearch.adapter.component.tab.generic.GenericTabView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/pure/PureTabView;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabView;", "", "selectedTabTextSize", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class PureTabView extends GenericTabView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PureTabView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView
    public float selectedTabTextSize() {
        return 13.0f;
    }
}
