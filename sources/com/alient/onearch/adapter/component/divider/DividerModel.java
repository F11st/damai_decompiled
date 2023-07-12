package com.alient.onearch.adapter.component.divider;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.divider.DividerContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00162\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014R(\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/alient/onearch/adapter/component/divider/DividerModel;", "Lcom/alient/onearch/adapter/view/AbsModel;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "", "Lcom/alient/onearch/adapter/component/divider/DividerContract$Model;", "item", "Ltb/wt2;", "parseModelImpl", "", "<set-?>", "dividerColor", "Ljava/lang/String;", "getDividerColor", "()Ljava/lang/String;", "", Constants.DIVIDER_HEIGHT, "Ljava/lang/Integer;", "getDividerHeight", "()Ljava/lang/Integer;", "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class DividerModel extends AbsModel<GenericItem<ItemValue>, Object> implements DividerContract.Model {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DIVIDER_COLOR = "DividerColor";
    @NotNull
    public static final String DIVIDER_HEIGHT = "DividerHeight";
    @Nullable
    private String dividerColor;
    @Nullable
    private Integer dividerHeight;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/component/divider/DividerModel$Companion;", "", "", "DIVIDER_COLOR", "Ljava/lang/String;", "DIVIDER_HEIGHT", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    @Override // com.alient.onearch.adapter.component.divider.DividerContract.Model
    @Nullable
    public String getDividerColor() {
        return this.dividerColor;
    }

    @Override // com.alient.onearch.adapter.component.divider.DividerContract.Model
    @Nullable
    public Integer getDividerHeight() {
        return this.dividerHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(@NotNull GenericItem<ItemValue> genericItem) {
        b41.i(genericItem, "item");
        JSONObject data = genericItem.getProperty().getData();
        if (data != null) {
            this.dividerColor = data.getString(DIVIDER_COLOR);
            this.dividerHeight = data.getInteger(DIVIDER_HEIGHT);
        }
    }
}
