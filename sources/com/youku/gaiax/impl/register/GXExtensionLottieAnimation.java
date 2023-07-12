package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.mr0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionLottieAnimation;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "Ltb/mr0;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionLottieAnimation implements GXRegisterCenter.GXIExtensionLottieAnimation {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionLottieAnimation
    @Nullable
    public mr0 create() {
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        if (features == null) {
            return null;
        }
        return features.createLottieAnimation();
    }
}
