package com.alient.onearch.adapter.loader;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "", "", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "limitSize", "Ltb/wt2;", "addComponentLimitSize", "geComponentLimitSize", "(I)Ljava/lang/Integer;", "", "hasComponentLimitSize", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "componentItemsLimit", "Ljava/util/HashMap;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentItemDisplayLimiter {
    @NotNull
    private HashMap<Integer, Integer> componentItemsLimit = new HashMap<>();

    public final void addComponentLimitSize(int i, int i2) {
        this.componentItemsLimit.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Nullable
    public final Integer geComponentLimitSize(int i) {
        return this.componentItemsLimit.get(Integer.valueOf(i));
    }

    public final boolean hasComponentLimitSize(int i) {
        return this.componentItemsLimit.containsKey(Integer.valueOf(i));
    }
}
