package com.alient.onearch.adapter.component.footer;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.live.dago.model.PlayerInteract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J,\u0010\r\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegate;", "", "Lcom/alient/onearch/adapter/component/footer/GenericFooterView;", "view", "Lcom/alient/onearch/adapter/component/footer/GenericFooterModel;", "model", "Ltb/wt2;", "onBindView", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "data", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", PlayerInteract.ELEMENT_DEFAULT_ACTION, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public interface ComponentFooterDelegate {
    void onBindView(@Nullable GenericFooterView genericFooterView, @Nullable GenericFooterModel genericFooterModel);

    void onClick(@Nullable IItem<ItemValue> iItem, @Nullable GenericFooterModel genericFooterModel, @Nullable EventHandler eventHandler);
}
