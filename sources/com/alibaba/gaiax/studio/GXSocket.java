package com.alibaba.gaiax.studio;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.SocketListener;
import com.alibaba.gaiax.studio.third.socket.websocket.b;
import com.taobao.orange.OConstant;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gf0;
import tb.h13;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXSocket implements SocketListener {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "[GaiaX][FastPreview]";
    private boolean a;
    @Nullable
    private GXSocketListener b;
    @Nullable
    private Runnable c;
    @Nullable
    private String d;
    private int e;
    @Nullable
    private String f;
    @Nullable
    private JSONObject g;
    @Nullable
    private b h;
    @Nullable
    private h13 i;
    @Nullable
    private String j;
    @NotNull
    private final Handler k = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/alibaba/gaiax/studio/GXSocket$GXSocketListener;", "", "Ltb/wt2;", "onSocketDisconnected", "onSocketConnected", "onStudioConnected", "", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "onStudioAddData", "templateJson", "onStudioUpdate", "GaiaXAndroidClientToStudio_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface GXSocketListener {
        void onSocketConnected();

        void onSocketDisconnected();

        void onStudioAddData(@NotNull String str, @NotNull JSONObject jSONObject);

        void onStudioConnected();

        void onStudioUpdate(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private final JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String string = jSONObject.getString("index.json");
        String string2 = jSONObject.getString("index.css");
        String string3 = jSONObject.getString("index.js");
        String string4 = jSONObject.getString("index.databinding");
        String string5 = jSONObject.getString("index.mock");
        if (string5 == null) {
            string5 = "{}";
        }
        jSONObject.getString("index.data");
        jSONObject2.put((JSONObject) "index.mock", (String) JSON.parseObject(string5));
        jSONObject2.put((JSONObject) "index.databinding", (String) JSON.parseObject(string4));
        jSONObject2.put((JSONObject) "index.json", (String) JSON.parseObject(string));
        jSONObject2.put((JSONObject) "index.css", string2);
        jSONObject2.put((JSONObject) "index.js", string3);
        return jSONObject2;
    }

    private final void i(String str) {
        Log.e(TAG, b41.r("sendGetTemplateData104() called with: templateId = ", str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "jsonrpc", "2.0");
        jSONObject.put((JSONObject) "method", "template/getTemplateData");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) "id", str);
        jSONObject.put((JSONObject) "params", (String) jSONObject2);
        jSONObject.put((JSONObject) "id", (String) 104);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.j = r4
            r0 = 0
            if (r4 == 0) goto L67
            r1 = 1
            if (r4 != 0) goto La
        L8:
            r4 = 0
            goto L16
        La:
            int r4 = r4.length()
            if (r4 != 0) goto L12
            r4 = 1
            goto L13
        L12:
            r4 = 0
        L13:
            if (r4 != r1) goto L8
            r4 = 1
        L16:
            if (r4 == 0) goto L19
            goto L67
        L19:
            r3.a = r1
            tb.h13 r4 = new tb.h13
            r4.<init>()
            r3.i = r4
            java.lang.String r2 = r3.j
            r4.m(r2)
            tb.h13 r4 = r3.i
            if (r4 != 0) goto L2c
            goto L31
        L2c:
            r2 = 15000(0x3a98, float:2.102E-41)
            r4.l(r2)
        L31:
            tb.h13 r4 = r3.i
            if (r4 != 0) goto L36
            goto L39
        L36:
            r4.n(r0)
        L39:
            tb.h13 r4 = r3.i
            if (r4 != 0) goto L3e
            goto L41
        L3e:
            r4.o(r1)
        L41:
            tb.h13 r4 = r3.i
            if (r4 != 0) goto L46
            goto L49
        L46:
            r4.p(r1)
        L49:
            com.alibaba.gaiax.studio.GXClientToStudio$a r4 = com.alibaba.gaiax.studio.GXClientToStudio.Companion
            com.alibaba.gaiax.studio.GXClientToStudio r4 = r4.a()
            android.content.Context r4 = r4.j()
            com.alibaba.gaiax.studio.third.socket.websocket.a.h(r4)
            tb.h13 r4 = r3.i
            java.lang.String r0 = "GaiaXSocket"
            com.alibaba.gaiax.studio.third.socket.websocket.b r4 = com.alibaba.gaiax.studio.third.socket.websocket.a.g(r0, r4)
            r3.h = r4
            if (r4 != 0) goto L63
            goto L66
        L63:
            r4.h(r3)
        L66:
            return
        L67:
            r3.a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.studio.GXSocket.a(java.lang.String):void");
    }

    public final void c() {
        if (this.a) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.p(this);
            }
            b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.j();
            }
            this.h = null;
        }
    }

    public final boolean d() {
        return this.a;
    }

    @Nullable
    public final GXSocketListener e() {
        return this.b;
    }

    public final boolean f(@NotNull String str) {
        b41.i(str, "type");
        return b41.d("auto", str);
    }

    public final boolean g(@NotNull String str) {
        b41.i(str, "type");
        return b41.d("manual", str);
    }

    public final void h(@Nullable String str) {
        Log.e(TAG, b41.r("sendGetTemplateData103() called with: templateId = ", str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "jsonrpc", "2.0");
        jSONObject.put((JSONObject) "method", "template/getTemplateData");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) "id", str);
        jSONObject.put((JSONObject) "params", (String) jSONObject2);
        jSONObject.put((JSONObject) "id", (String) 103);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void j(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void k() {
        Log.e(TAG, "sendMsgWithFastPreviewInit() called");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "jsonrpc", "2.0");
        jSONObject.put((JSONObject) "method", "initialize");
        jSONObject.put((JSONObject) "id", (String) 102);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void l() {
        Log.e(TAG, "sendMsgWithManualPushInit() called");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "jsonrpc", "2.0");
        jSONObject.put((JSONObject) "method", "initializeManual");
        jSONObject.put((JSONObject) "id", (String) 101);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void m(@Nullable GXSocketListener gXSocketListener) {
        this.b = gXSocketListener;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnectFailed(@NotNull Throwable th) {
        b41.i(th, "e");
        Log.e(TAG, "onConnectFailed() called with: e = [" + th + jn1.ARRAY_END);
        this.a = false;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnected() {
        Log.e(TAG, "onConnected() called");
        this.a = true;
        GXSocketListener gXSocketListener = this.b;
        if (gXSocketListener == null) {
            return;
        }
        gXSocketListener.onSocketConnected();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onDisconnect() {
        Log.e(TAG, "onDisconnect() called");
        b bVar = this.h;
        if (bVar != null) {
            bVar.i();
        }
        this.h = null;
        com.alibaba.gaiax.studio.third.socket.websocket.a.i("GaiaXSocket");
        this.j = null;
        this.i = null;
        this.a = false;
        GXSocketListener gXSocketListener = this.b;
        if (gXSocketListener != null) {
            gXSocketListener.onSocketDisconnected();
        }
        this.b = null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(@Nullable String str, T t) {
        GXSocketListener gXSocketListener;
        GXSocketListener gXSocketListener2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        GXSocketListener gXSocketListener3;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (str != null) {
            if (str.length() == 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(str);
            String string = parseObject.getString("id");
            String string2 = parseObject.getString("method");
            Log.e(TAG, "onMessage() called with: socketId = [" + ((Object) string) + "], method = [" + ((Object) string2) + jn1.ARRAY_END);
            if (!b41.d("template/didChangedNotification", string2) && !b41.d("template/didManualChangedNotification", string2)) {
                if (b41.d(OConstant.CODE_POINT_EXP_GET_TARGET_DIR, string)) {
                    JSONObject jSONObject5 = parseObject.getJSONObject("result");
                    String string3 = jSONObject5.getString("id");
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("data");
                    b41.h(jSONObject6, "templateDataSrc");
                    JSONObject b = b(jSONObject6);
                    GXSocketListener gXSocketListener4 = this.b;
                    if (gXSocketListener4 != null) {
                        b41.h(string3, "templateId");
                        gXSocketListener4.onStudioAddData(string3, b);
                    }
                    JSONObject jSONObject7 = b.getJSONObject("index.json");
                    if (jSONObject7 != null && (jSONObject3 = jSONObject7.getJSONObject("package")) != null && (jSONObject4 = jSONObject3.getJSONObject("dependencies")) != null) {
                        for (Map.Entry<String, Object> entry : jSONObject4.entrySet()) {
                            this.e++;
                            i(entry.getKey());
                        }
                    }
                    this.f = string3;
                    this.g = b;
                    if (this.e == 0) {
                        if (string3 != null && (gXSocketListener3 = this.b) != null) {
                            b41.f(string3);
                            JSONObject jSONObject8 = this.g;
                            b41.f(jSONObject8);
                            gXSocketListener3.onStudioUpdate(string3, jSONObject8);
                        }
                        this.f = "";
                        this.g = null;
                        return;
                    }
                    return;
                } else if (b41.d(OConstant.CODE_POINT_EXP_CREATE_TARGET_DIR, string)) {
                    this.e--;
                    JSONObject jSONObject9 = parseObject.getJSONObject("result");
                    String string4 = jSONObject9.getString("id");
                    JSONObject jSONObject10 = jSONObject9.getJSONObject("data");
                    b41.h(jSONObject10, "templateDataSrc");
                    JSONObject b2 = b(jSONObject10);
                    GXSocketListener gXSocketListener5 = this.b;
                    if (gXSocketListener5 != null) {
                        b41.h(string4, "templateId");
                        gXSocketListener5.onStudioAddData(string4, b2);
                    }
                    JSONObject jSONObject11 = b2.getJSONObject("index.json");
                    if (jSONObject11 != null && (jSONObject = jSONObject11.getJSONObject("package")) != null && (jSONObject2 = jSONObject.getJSONObject("dependencies")) != null) {
                        for (Map.Entry<String, Object> entry2 : jSONObject2.entrySet()) {
                            this.e++;
                            i(entry2.getKey());
                        }
                    }
                    if (this.e == 0) {
                        String str2 = this.f;
                        if (str2 != null && this.g != null && (gXSocketListener2 = this.b) != null) {
                            b41.f(str2);
                            JSONObject jSONObject12 = this.g;
                            b41.f(jSONObject12);
                            gXSocketListener2.onStudioUpdate(str2, jSONObject12);
                        }
                        this.f = "";
                        this.g = null;
                        return;
                    }
                    return;
                } else if (b41.d(OConstant.CODE_POINT_EXP_LOAD_CACHE, string)) {
                    GXSocketListener gXSocketListener6 = this.b;
                    if (gXSocketListener6 == null) {
                        return;
                    }
                    gXSocketListener6.onStudioConnected();
                    return;
                } else if (b41.d("", this.d)) {
                    return;
                } else {
                    h(this.d);
                    return;
                }
            }
            JSONObject jSONObject13 = parseObject.getJSONObject("params");
            final String string5 = jSONObject13.getString("templateId");
            JSONObject jSONObject14 = jSONObject13.getJSONObject("data");
            if (string5 == null || jSONObject14 == null) {
                return;
            }
            Log.e(TAG, "onMessage() called with: templateId = [" + ((Object) string5) + jn1.ARRAY_END);
            final JSONObject b3 = b(jSONObject14);
            if (b41.d("template/didChangedNotification", string2)) {
                GXSocketListener gXSocketListener7 = this.b;
                if (gXSocketListener7 != null) {
                    gXSocketListener7.onStudioAddData(string5, b3);
                }
                this.d = string5;
                Runnable runnable = this.c;
                if (runnable != null) {
                    this.k.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.alibaba.gaiax.studio.GXSocket$onMessage$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        GXSocket.GXSocketListener e = GXSocket.this.e();
                        if (e == null) {
                            return;
                        }
                        String str3 = string5;
                        b41.h(str3, "templateId");
                        e.onStudioUpdate(str3, b3);
                    }
                };
                this.c = runnable2;
                this.k.postDelayed(runnable2, 200L);
            }
            if (!b41.d("template/didManualChangedNotification", string2) || (gXSocketListener = this.b) == null) {
                return;
            }
            gXSocketListener.onStudioAddData(string5, b3);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(@Nullable ByteBuffer byteBuffer, T t) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPing(@Nullable Framedata framedata) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPong(@Nullable Framedata framedata) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onSendDataError(@Nullable gf0 gf0Var) {
    }
}
