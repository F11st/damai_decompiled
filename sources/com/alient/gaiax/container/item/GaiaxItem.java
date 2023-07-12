package com.alient.gaiax.container.item;

import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/alient/gaiax/container/item/GaiaxItem;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Lcom/youku/arch/v3/core/IContext;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GaiaxItem extends GenericItem<ItemValue> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaiaxItem(@NotNull IContext iContext) {
        super(iContext);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
    }
}
