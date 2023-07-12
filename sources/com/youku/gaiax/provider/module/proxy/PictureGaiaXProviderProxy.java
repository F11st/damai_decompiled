package com.youku.gaiax.provider.module.proxy;

import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/provider/module/proxy/PictureGaiaXProviderProxy;", "", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PictureGaiaXProviderProxy {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String GAIAX_IMAGE_TYPE = "gaiax_image_proxy";
    @NotNull
    private static HashMap<String, Class<?>> hashType = new HashMap<>();
    public static IProxyPictureGaiaxProvider middleProvider;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J2\u0010\n\u001a\u00020\t2*\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004`\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015RF\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004`\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/youku/gaiax/provider/module/proxy/PictureGaiaXProviderProxy$Companion;", "", "", "type", "Ljava/lang/Class;", "getClassName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashTypeImp", "Ltb/wt2;", "initClassName", "Lcom/youku/gaiax/provider/module/proxy/IProxyPictureGaiaxProvider;", "provider", "initProxyImpl", "", "isDamaiApp", "isTppApp", "utA", "GAIAX_IMAGE_TYPE", "Ljava/lang/String;", "getGAIAX_IMAGE_TYPE", "()Ljava/lang/String;", "hashType", "Ljava/util/HashMap;", "getHashType", "()Ljava/util/HashMap;", "setHashType", "(Ljava/util/HashMap;)V", "middleProvider", "Lcom/youku/gaiax/provider/module/proxy/IProxyPictureGaiaxProvider;", "getMiddleProvider", "()Lcom/youku/gaiax/provider/module/proxy/IProxyPictureGaiaxProvider;", "setMiddleProvider", "(Lcom/youku/gaiax/provider/module/proxy/IProxyPictureGaiaxProvider;)V", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @Nullable
        public final Class<?> getClassName(@NotNull String str) {
            Class<?> cls;
            b41.i(str, "type");
            if (!getHashType().containsKey(str) || (cls = getHashType().get(str)) == null) {
                return null;
            }
            return cls;
        }

        @NotNull
        public final String getGAIAX_IMAGE_TYPE() {
            return PictureGaiaXProviderProxy.GAIAX_IMAGE_TYPE;
        }

        @NotNull
        public final HashMap<String, Class<?>> getHashType() {
            return PictureGaiaXProviderProxy.hashType;
        }

        @NotNull
        public final IProxyPictureGaiaxProvider getMiddleProvider() {
            IProxyPictureGaiaxProvider iProxyPictureGaiaxProvider = PictureGaiaXProviderProxy.middleProvider;
            if (iProxyPictureGaiaxProvider != null) {
                return iProxyPictureGaiaxProvider;
            }
            b41.A("middleProvider");
            return null;
        }

        public final void initClassName(@NotNull HashMap<String, Class<?>> hashMap) {
            b41.i(hashMap, "hashTypeImp");
            getHashType().putAll(hashMap);
        }

        public final void initProxyImpl(@NotNull IProxyPictureGaiaxProvider iProxyPictureGaiaxProvider) {
            b41.i(iProxyPictureGaiaxProvider, "provider");
            setMiddleProvider(iProxyPictureGaiaxProvider);
        }

        public final boolean isDamaiApp() {
            return b41.d("cn.damai", AppInfoProviderProxy.getPackageName());
        }

        public final boolean isTppApp() {
            return b41.d("com.taobao.movie.android", AppInfoProviderProxy.getPackageName());
        }

        public final void setHashType(@NotNull HashMap<String, Class<?>> hashMap) {
            b41.i(hashMap, "<set-?>");
            PictureGaiaXProviderProxy.hashType = hashMap;
        }

        public final void setMiddleProvider(@NotNull IProxyPictureGaiaxProvider iProxyPictureGaiaxProvider) {
            b41.i(iProxyPictureGaiaxProvider, "<set-?>");
            PictureGaiaXProviderProxy.middleProvider = iProxyPictureGaiaxProvider;
        }

        @NotNull
        public final String utA() {
            return isDamaiApp() ? "a2o4t" : isTppApp() ? "a2115o" : "";
        }
    }
}
