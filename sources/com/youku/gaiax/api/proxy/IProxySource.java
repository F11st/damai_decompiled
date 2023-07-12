package com.youku.gaiax.api.proxy;

import androidx.annotation.Keep;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxySource;", "", "Ltb/wt2;", "sourceInit", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "getAssetsTemplateSource", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "getRemoteTemplateSource", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IProxySource {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static GXExtensionTemplateAssetsSource getAssetsTemplateSource(@NotNull IProxySource iProxySource) {
            b41.i(iProxySource, "this");
            return null;
        }

        @Nullable
        public static GXExtensionTemplateRemoteSource getRemoteTemplateSource(@NotNull IProxySource iProxySource) {
            b41.i(iProxySource, "this");
            return null;
        }

        public static void sourceInit(@NotNull IProxySource iProxySource) {
            b41.i(iProxySource, "this");
        }
    }

    @Nullable
    GXExtensionTemplateAssetsSource getAssetsTemplateSource();

    @Nullable
    GXExtensionTemplateRemoteSource getRemoteTemplateSource();

    void sourceInit();
}
