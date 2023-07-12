package com.youku.gaiax.provider.module;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.api.data.RasterizeRule;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.utils.NotchUtils;
import com.youku.gaiax.provider.module.animation.GaiaXYKLottieAnimation;
import com.youku.gaiax.provider.module.util.Utils;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mr0;
import tb.rq0;
import tb.wt2;
import tb.xq0;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyFeatures;", "Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "", Constants.Name.FONT_FAMILY, "Landroid/graphics/Typeface;", "picCreateFontFamily", "getParentTypeface", "createFontFamilyFromResFontFolder", "platform", "", "checkRemoteTemplatePlatform", "env", "", "getEnvExpressionResult", "isNetworkConnected", "createFontFamily", "Ltb/mr0;", "createLottieAnimation", "expVersion", "data", "Ltb/rq0;", "createDataBinding", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "Ltb/wt2;", "sendRibutMessage", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyFeatures implements IProxyFeatures {
    private final Typeface createFontFamilyFromResFontFolder(String str) {
        Context applicationContext;
        IProxyApp app2;
        Resources resources;
        int identifier;
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app3 = companion.getInstance().getApp();
        if (app3 == null || (applicationContext = app3.applicationContext()) == null || (app2 = companion.getInstance().getApp()) == null || (resources = app2.resources()) == null || (identifier = resources.getIdentifier(str, URIAdapter.FONT, applicationContext.getPackageName())) == 0) {
            return null;
        }
        try {
            return ResourcesCompat.getFont(applicationContext, identifier);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Typeface getParentTypeface(String str) {
        try {
            return IProxyFeatures.DefaultImpls.createFontFamily(this, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r2.equals("URWDIN-Medium") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r2.equals("damai_digit") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        r0 = com.youku.gaiax.impl.GaiaXProxy.Companion.getInstance().getApp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        r0 = r0.resources();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        return getParentTypeface(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        return android.graphics.Typeface.createFromAsset(r0.getAssets(), "damai_digit.otf");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.graphics.Typeface picCreateFontFamily(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1864622618: goto L2f;
                case -737385400: goto L1f;
                case -379705773: goto L16;
                case 3226745: goto L8;
                default: goto L7;
            }
        L7:
            goto L5b
        L8:
            java.lang.String r0 = "icon"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L11
            goto L5b
        L11:
            android.graphics.Typeface r2 = r1.createFontFamilyFromResFontFolder(r2)
            return r2
        L16:
            java.lang.String r0 = "URWDIN-Medium"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L38
            goto L5b
        L1f:
            java.lang.String r0 = "iconfont"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L28
            goto L5b
        L28:
            java.lang.String r2 = "damai_iconfont"
            android.graphics.Typeface r2 = r1.getParentTypeface(r2)
            return r2
        L2f:
            java.lang.String r0 = "damai_digit"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L38
            goto L5b
        L38:
            com.youku.gaiax.impl.GaiaXProxy$Companion r0 = com.youku.gaiax.impl.GaiaXProxy.Companion
            com.youku.gaiax.impl.GaiaXProxy r0 = r0.getInstance()
            com.youku.gaiax.api.proxy.IProxyApp r0 = r0.getApp()
            if (r0 != 0) goto L45
            goto L4b
        L45:
            android.content.res.Resources r0 = r0.resources()
            if (r0 != 0) goto L50
        L4b:
            android.graphics.Typeface r2 = r1.getParentTypeface(r2)
            return r2
        L50:
            android.content.res.AssetManager r2 = r0.getAssets()
            java.lang.String r0 = "damai_digit.otf"
            android.graphics.Typeface r2 = android.graphics.Typeface.createFromAsset(r2, r0)
            return r2
        L5b:
            android.graphics.Typeface r2 = r1.getParentTypeface(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.provider.module.GaiaXProxyFeatures.picCreateFontFamily(java.lang.String):android.graphics.Typeface");
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean checkRemoteTemplatePlatform(@Nullable String str) {
        return b41.d("ANDROID", str) || b41.d("APAD", str) || b41.d(Utils.DAMAI_PLATFORM, str) || b41.d(Utils.TPP_PLATFORM, str);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public rq0 createDataBinding(@Nullable String str, @NotNull Object obj) {
        b41.i(obj, "data");
        LinkedHashMap linkedHashMap = null;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("value");
            String string2 = jSONObject.getString(Constants.Name.PLACEHOLDER);
            String string3 = jSONObject.getString("accessibilityDesc");
            String string4 = jSONObject.getString("accessibilityEnable");
            String string5 = jSONObject.getString("accessibilityTraits");
            JSONObject jSONObject2 = jSONObject.getJSONObject("extend");
            xq0 xq0Var = xq0.INSTANCE;
            GXIExpression a = xq0Var.a(str, string);
            GXIExpression a2 = xq0Var.a(str, string2);
            GXIExpression a3 = xq0Var.a(str, string3);
            GXIExpression a4 = xq0Var.a(str, string4);
            GXIExpression a5 = xq0Var.a(str, string5);
            if (jSONObject2 != null && (!jSONObject2.isEmpty())) {
                linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        xq0 xq0Var2 = xq0.INSTANCE;
                        String key = entry.getKey();
                        b41.h(key, "entry.key");
                        GXIExpression b = xq0Var2.b(str, key, entry.getValue());
                        if (b != null) {
                            String key2 = entry.getKey();
                            b41.h(key2, "entry.key");
                            linkedHashMap.put(key2, b);
                        }
                    }
                }
            }
            return new rq0(a, a3, a4, a5, a2, linkedHashMap);
        } else if (obj instanceof String) {
            return new rq0(xq0.INSTANCE.a(str, obj), null, null, null, null, null, 62, null);
        } else {
            return null;
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public Typeface createFontFamily(@NotNull String str) {
        b41.i(str, Constants.Name.FONT_FAMILY);
        return picCreateFontFamily(str);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public mr0 createLottieAnimation() {
        return new GaiaXYKLottieAnimation();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void featuresInit() {
        IProxyFeatures.DefaultImpls.featuresInit(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public Object getEnvExpressionResult(@NotNull String str) {
        b41.i(str, "env");
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context context = app2 == null ? null : app2.topActivity();
        switch (str.hashCode()) {
            case -2007745357:
                if (str.equals("screenHeight") && context != null) {
                    return Float.valueOf(ScreenUtils.INSTANCE.getScreenHeightDP(context));
                }
                return null;
            case -1441169947:
                if (str.equals("isAndroid")) {
                    return Boolean.TRUE;
                }
                break;
            case -50798406:
                if (str.equals("screenWidth") && context != null) {
                    return Float.valueOf(ScreenUtils.INSTANCE.getScreenWidthDP(context));
                }
                return null;
            case 100468355:
                if (str.equals("isIOS")) {
                    return Boolean.FALSE;
                }
                break;
            case 1484112759:
                if (str.equals("appVersion")) {
                    return AppInfoProviderProxy.getVersionName();
                }
                break;
            case 1721112372:
                if (str.equals("isLiuHaiPing")) {
                    if (context == null) {
                        return Boolean.FALSE;
                    }
                    return NotchUtils.INSTANCE.isNotch();
                }
                break;
            case 1874684019:
                if (str.equals("platform")) {
                    return "android";
                }
                break;
        }
        return null;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public RasterizeRule.Result getRasterizeRule(@NotNull RasterizeRule.Config config) {
        return IProxyFeatures.DefaultImpls.getRasterizeRule(this, config);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public float getResponsiveLayoutScale() {
        return IProxyFeatures.DefaultImpls.getResponsiveLayoutScale(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public int getResponsiveSpan(@Nullable Float f, int i) {
        return IProxyFeatures.DefaultImpls.getResponsiveSpan(this, f, i);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isLargeFontMode() {
        return IProxyFeatures.DefaultImpls.isLargeFontMode(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isNetworkConnected() {
        return NetworkInfoProviderProxy.isNetworkAvailable() || NetworkInfoProviderProxy.isMobile() || NetworkInfoProviderProxy.isWifi();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isSupportResponsiveLayout(@Nullable Context context) {
        return IProxyFeatures.DefaultImpls.isSupportResponsiveLayout(this, context);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public float largeFontScale() {
        return IProxyFeatures.DefaultImpls.largeFontScale(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void registerAccs(@NotNull String str, @NotNull Function2<? super String, ? super JSONObject, wt2> function2) {
        IProxyFeatures.DefaultImpls.registerAccs(this, str, function2);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void runJSAppBundle(@NotNull Function0<wt2> function0) {
        IProxyFeatures.DefaultImpls.runJSAppBundle(this, function0);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void sendRibutMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(str, "templateId");
    }
}
