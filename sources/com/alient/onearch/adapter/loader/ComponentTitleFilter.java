package com.alient.onearch.adapter.loader;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "", "", "componentId", "", "isFilterTitle", "Ltb/wt2;", "addTitleFilterComponent", "", "componentIds", "Ljava/util/List;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentTitleFilter {
    @NotNull
    private final List<Integer> componentIds = new ArrayList();

    public final void addTitleFilterComponent(int i) {
        this.componentIds.add(Integer.valueOf(i));
    }

    public final boolean isFilterTitle(int i) {
        return this.componentIds.contains(Integer.valueOf(i));
    }
}
