package com.youku.arch.v3.token;

import android.content.Context;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.analysis.StageType;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.util.ResUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.b41;
import tb.hi;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002R$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/youku/arch/v3/token/TokenManager;", "", "", "string", "", "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", StageType.PARSE, "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/net/Uri;", "uri", "getContentByUri", "", "getResId", "Ljava/io/Closeable;", "closeable", "Ltb/wt2;", "closeQuietly", UCCore.LEGACY_EVENT_INIT, "tokenKey", "getColorToken", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "getDimenToken", "getFontToken", "", "getOpacityToken", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Double;", "Lcom/youku/arch/v3/token/SizeTokenValue;", "getSizeToken", "tokens", "Ljava/util/Map;", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TokenManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BUFFER_SIZE = 8192;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DEV_PHONE = "dev_phone";
    @NotNull
    private static final Lazy<TokenManager> instance$delegate;
    @Nullable
    private Map<String, ? extends StrategyTokenJavaBean> tokens;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/token/TokenManager$Companion;", "", "Lcom/youku/arch/v3/token/TokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/token/TokenManager;", "instance", "", "BUFFER_SIZE", "I", "", "DEV_PHONE", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final TokenManager getInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-288598397") ? (TokenManager) ipChange.ipc$dispatch("-288598397", new Object[]{this}) : (TokenManager) TokenManager.instance$delegate.getValue();
        }
    }

    static {
        Lazy<TokenManager> a;
        a = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<TokenManager>() { // from class: com.youku.arch.v3.token.TokenManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TokenManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-564134815") ? (TokenManager) ipChange.ipc$dispatch("-564134815", new Object[]{this}) : new TokenManager();
            }
        });
        instance$delegate = a;
    }

    private final void closeQuietly(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513929192")) {
            ipChange.ipc$dispatch("513929192", new Object[]{this, closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    private final String getContentByUri(Context context, Uri uri) {
        InputStream openInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640532939")) {
            return (String) ipChange.ipc$dispatch("-640532939", new Object[]{this, context, uri});
        }
        ?? d = b41.d("android.resource", uri.getScheme());
        if (d != 0) {
            int resId = getResId(context, uri);
            if (resId > 0) {
                openInputStream = context.getResources().openRawResource(resId);
            }
            openInputStream = null;
        } else {
            try {
                openInputStream = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
        if (openInputStream != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openInputStream);
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(openInputStream.available());
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    d = 0;
                    closeQuietly(openInputStream);
                    closeQuietly(d);
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    Ref$IntRef ref$IntRef = new Ref$IntRef();
                    ref$IntRef.element = -1;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        ref$IntRef.element = read;
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            b41.h(byteArray, "rawData");
                            String str = new String(byteArray, hi.UTF_8);
                            closeQuietly(openInputStream);
                            closeQuietly(byteArrayOutputStream);
                            closeQuietly(bufferedInputStream);
                            return str;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (AppInfoProviderProxy.isDebuggable()) {
                        e.printStackTrace();
                    }
                    closeQuietly(openInputStream);
                    closeQuietly(byteArrayOutputStream);
                    closeQuietly(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(openInputStream);
                closeQuietly(d);
                closeQuietly(bufferedInputStream);
                throw th;
            }
        }
        return null;
    }

    private final int getResId(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955036199")) {
            return ((Integer) ipChange.ipc$dispatch("-1955036199", new Object[]{this, context, uri})).intValue();
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() != 2) {
            return -1;
        }
        return ResUtil.getIdentifier(context, pathSegments.get(1), pathSegments.get(0));
    }

    private final Map<String, StrategyTokenJavaBean> parse(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1378524362")) {
            return (Map) ipChange.ipc$dispatch("1378524362", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    StrategyTokenJavaBean strategyTokenJavaBean = new StrategyTokenJavaBean();
                    strategyTokenJavaBean.token = jSONObject.getString("token");
                    strategyTokenJavaBean.type = jSONObject.getString("type");
                    strategyTokenJavaBean.value = new HashMap<>();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("value");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            b41.h(next2, "key2");
                            String string = jSONObject3.getString(next2);
                            b41.h(string, "l3.getString(key2)");
                            hashMap2.put(next2, string);
                        }
                        HashMap<String, HashMap<String, Object>> hashMap3 = strategyTokenJavaBean.value;
                        b41.h(hashMap3, "tokenJavaBean.value");
                        hashMap3.put(next, hashMap2);
                    }
                    String str2 = strategyTokenJavaBean.token;
                    b41.h(str2, "tokenJavaBean.token");
                    hashMap.put(str2, strategyTokenJavaBean);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        } catch (JSONException e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
        return hashMap;
    }

    @Nullable
    public final Integer getColorToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511661159")) {
            return (Integer) ipChange.ipc$dispatch("1511661159", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        return ColorStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final Integer getDimenToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990729895")) {
            return (Integer) ipChange.ipc$dispatch("-1990729895", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        return DimenStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final Integer getFontToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944073471")) {
            return (Integer) ipChange.ipc$dispatch("-944073471", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        return FontStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final Double getOpacityToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584000120")) {
            return (Double) ipChange.ipc$dispatch("-584000120", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        return OpacityStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    @Nullable
    public final SizeTokenValue getSizeToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338856863")) {
            return (SizeTokenValue) ipChange.ipc$dispatch("-1338856863", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        return SizeStrategyTokenManager.Companion.getInstance().getToken(context, str);
    }

    public final void init(@NotNull Context context, @NotNull Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283962277")) {
            ipChange.ipc$dispatch("-283962277", new Object[]{this, context, uri});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(uri, "uri");
        String contentByUri = getContentByUri(context, uri);
        if (contentByUri == null) {
            return;
        }
        Map<String, StrategyTokenJavaBean> parse = parse(contentByUri);
        for (StrategyTokenJavaBean strategyTokenJavaBean : parse.values()) {
            String str = strategyTokenJavaBean.type;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1840138807:
                        if (str.equals("foundation-color")) {
                            ColorStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                            break;
                        } else {
                            continue;
                        }
                    case -1839393385:
                        if (str.equals("foundation-dimen")) {
                            DimenStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                            break;
                        } else {
                            continue;
                        }
                    case -1826695567:
                        if (str.equals("foundation-ratio")) {
                            RatioStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                            break;
                        } else {
                            continue;
                        }
                    case 1049108777:
                        if (str.equals("foundation-font")) {
                            FontStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                            break;
                        } else {
                            continue;
                        }
                    case 1049490651:
                        if (str.equals("foundation-size")) {
                            SizeStrategyTokenManager.Companion.getInstance().addToken(strategyTokenJavaBean);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
        wt2 wt2Var = wt2.INSTANCE;
        this.tokens = parse;
    }
}
