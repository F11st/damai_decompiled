package com.alient.gaiax.container.config;

import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeConfigCreator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/config/GaiaxViewTypeConfigCreator;", "Lcom/youku/arch/v3/adapter/ViewTypeConfigCreator;", "", "type", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "create", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GaiaxViewTypeConfigCreator implements ViewTypeConfigCreator {
    @Override // com.youku.arch.v3.adapter.ViewTypeConfigCreator
    @NotNull
    public ViewTypeConfig create(int i) {
        return new GaiaxViewTypeConfig();
    }
}
