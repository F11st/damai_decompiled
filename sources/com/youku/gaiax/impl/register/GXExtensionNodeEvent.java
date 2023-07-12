package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionNodeEvent;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionNodeEvent implements GXRegisterCenter.GXIExtensionNodeEvent {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionNodeEvent
    @NotNull
    public GXINodeEvent create() {
        return new GXMixNodeEvent();
    }
}
