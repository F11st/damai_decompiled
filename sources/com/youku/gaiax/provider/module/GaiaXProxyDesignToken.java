package com.youku.gaiax.provider.module;

import android.content.Context;
import androidx.annotation.Keep;
import com.youku.arch.v3.token.DimenStrategyTokenManager;
import com.youku.arch.v3.token.FontStrategyTokenManager;
import com.youku.gaiax.api.proxy.IProxyDesignToken;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\bJ\b\u0010\f\u001a\u00020\u000bH\u0016J#\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyDesignToken;", "Lcom/youku/gaiax/api/proxy/IProxyDesignToken;", "", "color", "", "getResIdByColor", "token", "getFontToken", "(Ljava/lang/String;)Ljava/lang/Integer;", "getDimenToken", "deviceToken", "Ltb/wt2;", "designTokenInit", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "designTokenColor", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "dim", "", "designTokenDimen", "(Ljava/lang/String;)Ljava/lang/Float;", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyDesignToken implements IProxyDesignToken {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX][Token]";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyDesignToken$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    private final Integer deviceToken(String str) {
        Integer dimenToken = getDimenToken(str);
        if (dimenToken != null) {
            return dimenToken;
        }
        Integer fontToken = getFontToken(str);
        if (fontToken != null) {
            return fontToken;
        }
        return null;
    }

    private final Integer getDimenToken(String str) {
        try {
            DimenStrategyTokenManager companion = DimenStrategyTokenManager.Companion.getInstance();
            Context appContext = AppInfoProviderProxy.getAppContext();
            b41.h(appContext, "getAppContext()");
            return companion.getToken(appContext, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Integer getFontToken(String str) {
        try {
            FontStrategyTokenManager companion = FontStrategyTokenManager.Companion.getInstance();
            Context appContext = AppInfoProviderProxy.getAppContext();
            b41.h(appContext, "getAppContext()");
            return companion.getToken(appContext, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private final int getResIdByColor(String str) {
        try {
            Context appContext = AppInfoProviderProxy.getAppContext();
            return appContext.getResources().getIdentifier(str, "color", appContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxyDesignToken
    @Nullable
    public Integer designTokenColor(@Nullable Context context, @NotNull String str) {
        b41.i(str, "color");
        return null;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyDesignToken
    @Nullable
    public Float designTokenDimen(@NotNull String str) {
        b41.i(str, "dim");
        Integer deviceToken = deviceToken(str);
        if (deviceToken == null) {
            return null;
        }
        return Float.valueOf(deviceToken.intValue());
    }

    @Override // com.youku.gaiax.api.proxy.IProxyDesignToken
    public void designTokenInit() {
    }
}
