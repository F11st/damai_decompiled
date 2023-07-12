package com.youku.gaiax.api.proxy;

import android.content.Context;
import androidx.annotation.Keep;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyDesignToken;", "", "Ltb/wt2;", "designTokenInit", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "color", "", "designTokenColor", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "dim", "", "designTokenDimen", "(Ljava/lang/String;)Ljava/lang/Float;", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IProxyDesignToken {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Integer designTokenColor(@NotNull IProxyDesignToken iProxyDesignToken, @Nullable Context context, @NotNull String str) {
            b41.i(iProxyDesignToken, "this");
            b41.i(str, "color");
            return null;
        }

        @Nullable
        public static Float designTokenDimen(@NotNull IProxyDesignToken iProxyDesignToken, @NotNull String str) {
            b41.i(iProxyDesignToken, "this");
            b41.i(str, "dim");
            return null;
        }

        public static void designTokenInit(@NotNull IProxyDesignToken iProxyDesignToken) {
            b41.i(iProxyDesignToken, "this");
        }
    }

    @Nullable
    Integer designTokenColor(@Nullable Context context, @NotNull String str);

    @Nullable
    Float designTokenDimen(@NotNull String str);

    void designTokenInit();
}
