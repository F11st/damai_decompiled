package com.alibaba.gaiax.studio;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXSocket;
import io.flutter.wpkbridge.WPKFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXClientToStudio {
    @NotNull
    public static final C3381a Companion = new C3381a(null);
    @NotNull
    public static final String TAG = "[GaiaX][GXStudio]";
    @NotNull
    private static final Lazy<GXClientToStudio> i;
    @Nullable
    private Context a;
    @Nullable
    private GXSocketToStudioListener b;
    @Nullable
    private GXSocket c;
    @Nullable
    private String d;
    @Nullable
    private String e;
    private boolean g;
    @NotNull
    private String f = "auto";
    @NotNull
    private final GXSocket.GXSocketListener h = new C3382b();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/studio/GXClientToStudio$GXSocketToStudioListener;", "", "", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "Ltb/wt2;", "onAddData", "onUpdate", "GaiaXAndroidClientToStudio_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXSocketToStudioListener {
        void onAddData(@NotNull String str, @NotNull JSONObject jSONObject);

        void onUpdate(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.GXClientToStudio$a */
    /* loaded from: classes6.dex */
    public static final class C3381a {
        private C3381a() {
        }

        public /* synthetic */ C3381a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXClientToStudio a() {
            return (GXClientToStudio) GXClientToStudio.i.getValue();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.GXClientToStudio$b */
    /* loaded from: classes6.dex */
    public static final class C3382b implements GXSocket.GXSocketListener {
        C3382b() {
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onSocketConnected() {
            GXClientToStudio gXClientToStudio = GXClientToStudio.this;
            gXClientToStudio.r(gXClientToStudio.f);
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onSocketDisconnected() {
            if (GXClientToStudio.this.g) {
                GXClientToStudio.this.g = false;
                GXClientToStudio.this.u();
            }
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioAddData(@NotNull String str, @NotNull JSONObject jSONObject) {
            b41.i(str, "templateId");
            b41.i(jSONObject, "templateData");
            GXSocketToStudioListener k = GXClientToStudio.this.k();
            if (k == null) {
                return;
            }
            k.onAddData(str, jSONObject);
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioConnected() {
            GXSocket gXSocket;
            Log.d(GXClientToStudio.TAG, b41.r("onStudioConnected() called currentTemplateId = ", GXClientToStudio.this.e));
            if (GXClientToStudio.this.e == null || (gXSocket = GXClientToStudio.this.c) == null) {
                return;
            }
            gXSocket.h(GXClientToStudio.this.e);
        }

        @Override // com.alibaba.gaiax.studio.GXSocket.GXSocketListener
        public void onStudioUpdate(@NotNull String str, @NotNull JSONObject jSONObject) {
            b41.i(str, "templateId");
            b41.i(jSONObject, "templateJson");
            GXSocketToStudioListener k = GXClientToStudio.this.k();
            if (k == null) {
                return;
            }
            k.onUpdate(str, jSONObject);
        }
    }

    static {
        Lazy<GXClientToStudio> b;
        b = C8177b.b(new Function0<GXClientToStudio>() { // from class: com.alibaba.gaiax.studio.GXClientToStudio$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXClientToStudio invoke() {
                return new GXClientToStudio();
            }
        });
        i = b;
    }

    private final boolean n(Context context) {
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        int length = allNetworkInfo.length - 1;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                NetworkInfo networkInfo = allNetworkInfo[i2];
                if (networkInfo.getType() == 17 && networkInfo.isConnected()) {
                    return true;
                }
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        }
        return false;
    }

    private final String p(String str) {
        try {
            Object[] array = new Regex("&").split(str, 0).toArray(new String[0]);
            if (array != null) {
                Object[] array2 = new Regex("=").split(((String[]) array)[2], 0).toArray(new String[0]);
                if (array2 != null) {
                    return ((String[]) array2)[1];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private final String q(String str) {
        try {
            Object[] array = new Regex("&").split(str, 0).toArray(new String[0]);
            if (array != null) {
                Object[] array2 = new Regex("=").split(((String[]) array)[1], 0).toArray(new String[0]);
                if (array2 != null) {
                    return ((String[]) array2)[1];
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str) {
        GXSocket gXSocket;
        GXSocket gXSocket2 = this.c;
        boolean z = false;
        if (gXSocket2 != null && gXSocket2.g(str)) {
            GXSocket gXSocket3 = this.c;
            if (gXSocket3 == null) {
                return;
            }
            gXSocket3.l();
            return;
        }
        GXSocket gXSocket4 = this.c;
        if (gXSocket4 != null && gXSocket4.f(str)) {
            z = true;
        }
        if (!z || (gXSocket = this.c) == null) {
            return;
        }
        gXSocket.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        GXSocket gXSocket = this.c;
        boolean z = false;
        if (gXSocket != null && !gXSocket.d()) {
            z = true;
        }
        if (z) {
            GXSocket gXSocket2 = this.c;
            if (gXSocket2 != null) {
                gXSocket2.m(this.h);
            }
            GXSocket gXSocket3 = this.c;
            if (gXSocket3 == null) {
                return;
            }
            gXSocket3.a(this.d);
            return;
        }
        r(this.f);
    }

    private final void v(String str, String str2, String str3) {
        Log.e(TAG, "tryToConnectGaiaStudio() called with: address = [" + str + "], templateId = [" + ((Object) str2) + "], type = [" + str3 + jn1.ARRAY_END);
        String str4 = this.d;
        this.f = str3;
        this.d = str;
        this.e = str2;
        if (str4 != null && !b41.d(str4, str)) {
            this.g = true;
            GXSocket gXSocket = this.c;
            if (gXSocket == null) {
                return;
            }
            gXSocket.c();
            return;
        }
        u();
    }

    public final void i(@NotNull Context context, @NotNull JSONObject jSONObject) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(jSONObject, "params");
        if (n(context)) {
            Log.e(TAG, "manualConnect: 请断开手机VPN后重试");
            return;
        }
        Log.e(TAG, "execute() called with: params = [" + jSONObject + jn1.ARRAY_END);
        String string = jSONObject.getString("URL");
        String string2 = jSONObject.getString("TEMPLATE_ID");
        String string3 = jSONObject.getString("TYPE");
        b41.h(string, "targetUrl");
        b41.h(string3, "type");
        v(string, string2, string3);
    }

    @Nullable
    public final Context j() {
        return this.a;
    }

    @Nullable
    public final GXSocketToStudioListener k() {
        return this.b;
    }

    @Nullable
    public final JSONObject l(@Nullable String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String decode = URLDecoder.decode(str, "UTF-8");
                Log.e(TAG, "getParams() called with:  finalUrl = [" + ((Object) decode) + jn1.ARRAY_END);
                Matcher matcher = Pattern.compile("[ws://]+[\\d+.\\d+.\\d+.\\d+]+[:\\d+]*").matcher(decode);
                if (matcher.find()) {
                    String group = matcher.group();
                    b41.h(decode, "finalUrl");
                    String q = q(decode);
                    String p = p(decode);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((JSONObject) "URL", group);
                    jSONObject.put((JSONObject) "TYPE", p);
                    jSONObject.put((JSONObject) "TEMPLATE_ID", q);
                    Log.e(TAG, "getParams() called with:  result = [" + jSONObject + jn1.ARRAY_END);
                    return jSONObject;
                }
                Log.e(TAG, "Can not find web url through regex.");
                return null;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void m(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context.getApplicationContext();
        if (this.c == null) {
            this.c = new GXSocket();
        }
    }

    public final void o(@NotNull Context context, @NotNull JSONObject jSONObject) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(jSONObject, "params");
        if (n(context)) {
            Log.e(TAG, "manualConnect: 请断开手机VPN后重试");
            return;
        }
        Log.e(TAG, "onlyConnect() called with: params = [" + jSONObject + jn1.ARRAY_END);
        String string = jSONObject.getString("URL");
        String string2 = jSONObject.getString("TYPE");
        b41.h(string, "targetUrl");
        b41.h(string2, "type");
        v(string, null, string2);
    }

    public final void s(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        GXSocket gXSocket = this.c;
        if (gXSocket == null) {
            return;
        }
        gXSocket.j(jSONObject);
    }

    public final void t(@Nullable GXSocketToStudioListener gXSocketToStudioListener) {
        this.b = gXSocketToStudioListener;
    }
}
