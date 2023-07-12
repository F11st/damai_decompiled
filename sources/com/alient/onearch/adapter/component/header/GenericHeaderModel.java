package com.alient.onearch.adapter.component.header;

import android.app.Activity;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.header.GenericHeaderContract;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.onearch.adapter.view.AbsModel;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014R(\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderModel;", "Lcom/alient/onearch/adapter/view/AbsModel;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "", "Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$Model;", "item", "Ltb/wt2;", "parseModelImpl", "parseTrackInfo", "", "<set-?>", StyleConstant.HEADER_HEIGHT, "Ljava/lang/Integer;", "getHeaderHeight", "()Ljava/lang/Integer;", StyleConstant.HEADER_CORNER, "getHeaderCorner", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericHeaderModel extends AbsModel<GenericItem<ItemValue>, Object> implements GenericHeaderContract.Model {
    @Nullable
    private Integer headerCorner;
    @Nullable
    private Integer headerHeight;

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.Model
    @Nullable
    public final Integer getHeaderCorner() {
        return this.headerCorner;
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.Model
    @Nullable
    public final Integer getHeaderHeight() {
        return this.headerHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseTrackInfo(@NotNull GenericItem<ItemValue> genericItem) {
        b41.i(genericItem, "item");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(@NotNull GenericItem<ItemValue> genericItem) {
        Style style;
        Activity activity;
        Style style2;
        Activity activity2;
        b41.i(genericItem, "item");
        super.parseModelImpl((GenericHeaderModel) genericItem);
        Node node = genericItem.getNode();
        if (node != null && (style2 = node.getStyle()) != null && (activity2 = genericItem.getPageContext().getActivity()) != null) {
            this.headerHeight = Integer.valueOf(StyleUtil.INSTANCE.getDimen(activity2, style2, StyleConstant.HEADER_HEIGHT, R.dimen.resource_size_46));
        }
        Node node2 = genericItem.getNode();
        if (node2 == null || (style = node2.getStyle()) == null || (activity = genericItem.getPageContext().getActivity()) == null) {
            return;
        }
        this.headerCorner = Integer.valueOf(StyleUtil.INSTANCE.getDimen(activity, style, StyleConstant.HEADER_CORNER, R.dimen.resource_size_0));
    }
}
