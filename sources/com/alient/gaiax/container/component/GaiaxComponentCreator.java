package com.alient.gaiax.container.component;

import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.creator.ComponentCreator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/alient/gaiax/container/component/GaiaxComponentCreator;", "Lcom/youku/arch/v3/creator/ComponentCreator;", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", Constants.CONFIG, "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "create", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GaiaxComponentCreator extends ComponentCreator {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.arch.v3.creator.ComponentCreator, com.youku.arch.v3.ICreator
    @NotNull
    public IComponent<ComponentValue> create(@NotNull Config<Node> config) {
        b41.i(config, Constants.CONFIG);
        return new GaiaxComponent(config.getContext(), config.getData());
    }
}
