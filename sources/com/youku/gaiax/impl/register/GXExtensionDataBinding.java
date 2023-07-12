package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.rq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionDataBinding;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDataBinding;", "", "expVersion", "", "value", "Ltb/rq0;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionDataBinding implements GXRegisterCenter.GXIExtensionDataBinding {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionDataBinding
    @Nullable
    public rq0 create(@Nullable String str, @NotNull Object obj) {
        b41.i(obj, "value");
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        if (features == null) {
            return null;
        }
        return features.createDataBinding(str, obj);
    }
}
