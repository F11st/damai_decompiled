package com.alient.onearch.adapter.decorate;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "", "", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "I", "getComponentType", "()I", "itemType", "getItemType", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;", "indexer", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;", "getIndexer", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;", "<init>", "(IILcom/alibaba/fastjson/JSONObject;Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;)V", "Indexer", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentDecorateItem {
    private final int componentType;
    @NotNull
    private final JSONObject data;
    @NotNull
    private final Indexer indexer;
    private final int itemType;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem$Indexer;", "", "<init>", "(Ljava/lang/String;I)V", "Before", "After", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public enum Indexer {
        Before,
        After
    }

    public ComponentDecorateItem(int i, int i2, @NotNull JSONObject jSONObject, @NotNull Indexer indexer) {
        b41.i(jSONObject, "data");
        b41.i(indexer, "indexer");
        this.componentType = i;
        this.itemType = i2;
        this.data = jSONObject;
        this.indexer = indexer;
    }

    public final int getComponentType() {
        return this.componentType;
    }

    @NotNull
    public final JSONObject getData() {
        return this.data;
    }

    @NotNull
    public final Indexer getIndexer() {
        return this.indexer;
    }

    public final int getItemType() {
        return this.itemType;
    }
}
