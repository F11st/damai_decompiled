package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.er0;
import tb.hs0;
import tb.k80;
import tb.ld2;
import tb.ls0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionDynamicProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$a;", "params", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionDynamicProperty implements GXRegisterCenter.GXIExtensionDynamicProperty {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionDynamicProperty
    @Nullable
    public Object convert(@NotNull GXRegisterCenter.GXIExtensionDynamicProperty.C3331a c3331a) {
        hs0 A;
        boolean J;
        hs0 A2;
        boolean J2;
        b41.i(c3331a, "params");
        if (b41.d(c3331a.c(), "scroll-compute-container-height")) {
            if (b41.d(c3331a.d(), Boolean.FALSE)) {
                return Boolean.TRUE;
            }
        } else if (b41.d(c3331a.c(), "grid-compute-container-height")) {
            er0 b = c3331a.b();
            boolean z = false;
            if (b != null && !b.k()) {
                z = true;
            }
            if (z && b41.d(c3331a.d(), Boolean.FALSE)) {
                return Boolean.TRUE;
            }
        } else if (!b41.d(c3331a.c(), "size") && !b41.d(c3331a.c(), "min-size") && !b41.d(c3331a.c(), "max-size")) {
            if (b41.d(c3331a.c(), "line-height")) {
                ls0 a = c3331a.a();
                J2 = CollectionsKt___CollectionsKt.J(GXExtensionSize.Companion.getProcessSizes(), (a == null || (A2 = a.A()) == null) ? null : A2.a());
                if (J2) {
                    IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
                    Float valueOf = features == null ? null : Float.valueOf(features.largeFontScale());
                    if (valueOf != null) {
                        return Float.valueOf(((Float) c3331a.d()).floatValue() * valueOf.floatValue());
                    }
                }
            }
        } else {
            ld2 ld2Var = (ld2) c3331a.d();
            ls0 a2 = c3331a.a();
            J = CollectionsKt___CollectionsKt.J(GXExtensionSize.Companion.getProcessSizes(), (a2 == null || (A = a2.A()) == null) ? null : A.a());
            if (J) {
                IProxyFeatures features2 = GaiaXProxy.Companion.getInstance().getFeatures();
                Float valueOf2 = features2 == null ? null : Float.valueOf(features2.largeFontScale());
                if (valueOf2 != null) {
                    k80 k80Var = (k80) ld2Var.a();
                    if (k80Var instanceof k80.C9339c) {
                        ld2Var.c(new k80.C9339c(((k80.C9339c) k80Var).c() * valueOf2.floatValue()));
                    }
                    return c3331a.d();
                }
            }
        }
        return null;
    }
}
