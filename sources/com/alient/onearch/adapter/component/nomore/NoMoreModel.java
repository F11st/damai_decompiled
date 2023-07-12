package com.alient.onearch.adapter.component.nomore;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.nomore.NoMoreContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014R(\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/alient/onearch/adapter/component/nomore/NoMoreModel;", "Lcom/alient/onearch/adapter/view/AbsModel;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "", "Lcom/alient/onearch/adapter/component/nomore/NoMoreContract$Model;", "item", "Ltb/wt2;", "parseModelImpl", "", "<set-?>", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class NoMoreModel extends AbsModel<GenericItem<ItemValue>, Object> implements NoMoreContract.Model {
    @Nullable
    private String content;

    @Override // com.alient.onearch.adapter.component.nomore.NoMoreContract.Model
    @Nullable
    public String getContent() {
        return this.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(@NotNull GenericItem<ItemValue> genericItem) {
        b41.i(genericItem, "item");
        JSONObject data = genericItem.getProperty().getData();
        if (data != null && data.containsKey("content")) {
            this.content = data.getString("content");
        }
    }
}
