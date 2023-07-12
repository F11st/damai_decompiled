package com.alient.onearch.adapter.component.divider;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alient.onearch.adapter.component.divider.DividerContract;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0019\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/alient/onearch/adapter/component/divider/DividerView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/divider/DividerModel;", "Lcom/alient/onearch/adapter/component/divider/DividerPresent;", "Lcom/alient/onearch/adapter/component/divider/DividerContract$View;", "", "dividerColor", "Ltb/wt2;", "renderDividerColor", "", "height", "renderDividerHeight", "(Ljava/lang/Integer;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class DividerView extends AbsView<GenericItem<ItemValue>, DividerModel, DividerPresent> implements DividerContract.View {
    public DividerView(@Nullable View view) {
        super(view);
    }

    @Override // com.alient.onearch.adapter.component.divider.DividerContract.View
    public void renderDividerColor(@Nullable String str) {
        View renderView;
        if (TextUtils.isEmpty(str) || (renderView = getRenderView()) == null) {
            return;
        }
        renderView.setBackgroundColor(Color.parseColor(str));
    }

    @Override // com.alient.onearch.adapter.component.divider.DividerContract.View
    public void renderDividerHeight(@Nullable Integer num) {
        int intValue;
        if (num == null || (intValue = num.intValue()) == 0) {
            return;
        }
        View renderView = getRenderView();
        ViewGroup.LayoutParams layoutParams = renderView == null ? null : renderView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = intValue;
    }
}
