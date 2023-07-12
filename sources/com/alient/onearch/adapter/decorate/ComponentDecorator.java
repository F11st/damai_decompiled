package com.alient.onearch.adapter.decorate;

import android.util.SparseArray;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "", "", "componentId", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "item", "Ltb/wt2;", "addComponentDecorate", "removeComponentDecorate", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;", "indexer", "getComponentDecorate", "", "isExistDecorate", "Landroid/util/SparseArray;", "headerDecorateItems", "Landroid/util/SparseArray;", "footerDecorateItems", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentDecorator {
    @NotNull
    private final SparseArray<ComponentDecorateItem> headerDecorateItems = new SparseArray<>();
    @NotNull
    private final SparseArray<ComponentDecorateItem> footerDecorateItems = new SparseArray<>();

    public final void addComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(componentDecorateItem, "item");
        if (componentDecorateItem.getIndexer() == ComponentDecorateItem.Indexer.Before) {
            this.headerDecorateItems.put(i, componentDecorateItem);
        } else {
            this.footerDecorateItems.put(i, componentDecorateItem);
        }
    }

    @Nullable
    public final ComponentDecorateItem getComponentDecorate(int i, @NotNull ComponentDecorateItem.Indexer indexer) {
        b41.i(indexer, "indexer");
        if (indexer == ComponentDecorateItem.Indexer.Before) {
            return this.headerDecorateItems.get(i);
        }
        return this.footerDecorateItems.get(i);
    }

    public final boolean isExistDecorate(int i) {
        return (this.headerDecorateItems.get(i, null) == null && this.footerDecorateItems.get(i, null) == null) ? false : true;
    }

    public final void removeComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(componentDecorateItem, "item");
        if (componentDecorateItem.getIndexer() == ComponentDecorateItem.Indexer.Before) {
            this.headerDecorateItems.remove(i);
        } else {
            this.footerDecorateItems.remove(i);
        }
    }
}
