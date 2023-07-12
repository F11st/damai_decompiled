package com.taobao.android.riverlogger.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.RVLRemoteInfo;
import com.taobao.android.riverlogger.inspector.Inspector;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RemoteChannel {
    private static final ExecutorService f = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue());
    private static final String[] g = {"result", "error"};
    private final String a;
    private final RVLRemoteInfo.CommandFilter b;
    private RVLWebSocketClient d;
    private final AtomicInteger c = new AtomicInteger(0);
    private ConcurrentHashMap<Integer, RemoteCommandCallback> e = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface RemoteCommandCallback {
        void finish(JSONObject jSONObject, Integer num, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.riverlogger.remote.RemoteChannel$a */
    /* loaded from: classes11.dex */
    public class C6579a implements WebSocketCallback {
        C6579a() {
        }

        @Override // com.taobao.android.riverlogger.remote.WebSocketCallback
        public void onSocketClose(int i, String str) {
            RemoteChannel.this.h(Integer.valueOf(i), str);
            if (i == 4040) {
                C6581b.b();
            }
            RemoteChannel.this.d = null;
        }

        @Override // com.taobao.android.riverlogger.remote.WebSocketCallback
        public void onSocketError(String str) {
            RemoteChannel.this.h(-1, str);
            RemoteChannel.this.d = null;
        }

        @Override // com.taobao.android.riverlogger.remote.WebSocketCallback
        public void onSocketMessage(String str) {
            RemoteChannel.this.i(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteChannel(@NonNull String str, @Nullable RVLRemoteInfo.CommandFilter commandFilter) {
        this.a = str;
        this.b = commandFilter;
        f();
    }

    private RVLWebSocketClient f() {
        if (this.d == null) {
            RVLWebSocketClient rVLWebSocketClient = new RVLWebSocketClient(URI.create(this.a), new C6579a());
            this.d = rVLWebSocketClient;
            rVLWebSocketClient.connect();
        }
        return this.d;
    }

    private int g() {
        int i;
        int i2;
        do {
            i = this.c.get();
            i2 = i + 1;
        } while (!this.c.compareAndSet(i, i2));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Integer num, String str) {
        ConcurrentHashMap<Integer, RemoteCommandCallback> concurrentHashMap = this.e;
        this.e = new ConcurrentHashMap<>();
        for (RemoteCommandCallback remoteCommandCallback : concurrentHashMap.values()) {
            remoteCommandCallback.finish(null, num, str);
        }
    }

    public void d(int i, @Nullable JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
                jSONObject2.put("result", new JSONObject());
            } else {
                jSONObject2 = new JSONObject(jSONObject, g);
            }
            jSONObject2.put("id", i);
            j(jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    public String e() {
        return this.a;
    }

    void i(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            final int optInt = jSONObject.optInt("id", -1);
            final String optString = jSONObject.optString("method");
            if (optInt >= 0) {
                if (optString.length() > 0) {
                    f.execute(new Runnable() { // from class: com.taobao.android.riverlogger.remote.RemoteChannel.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String optString2 = jSONObject.optString("sessionId", null);
                            JSONObject optJSONObject = jSONObject.optJSONObject("params");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            }
                            if (RemoteChannel.this.b == null || RemoteChannel.this.b.filter(optString, optString2)) {
                                Inspector.c(optString, optInt, optString2, optJSONObject);
                            }
                        }
                    });
                    return;
                }
                final RemoteCommandCallback remoteCommandCallback = this.e.get(Integer.valueOf(optInt));
                if (remoteCommandCallback != null) {
                    this.e.remove(Integer.valueOf(optInt));
                    f.execute(new Runnable() { // from class: com.taobao.android.riverlogger.remote.RemoteChannel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject optJSONObject = jSONObject.optJSONObject("error");
                            if (optJSONObject == null) {
                                remoteCommandCallback.finish(jSONObject.optJSONObject("result"), null, null);
                                return;
                            }
                            String optString2 = optJSONObject.optString("message");
                            remoteCommandCallback.finish(null, (Integer) optJSONObject.opt("code"), optString2);
                        }
                    });
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void j(@NonNull String str) {
        if (str != null) {
            f().send(str);
        }
    }

    public void k(String str, String str2, JSONObject jSONObject, RemoteCommandCallback remoteCommandCallback) {
        if (str == null) {
            return;
        }
        RVLRemoteInfo.CommandFilter commandFilter = this.b;
        if (commandFilter == null || commandFilter.filter(str, str2)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("method", str);
                if (remoteCommandCallback != null) {
                    int g2 = g();
                    jSONObject2.put("id", g2);
                    this.e.put(Integer.valueOf(g2), remoteCommandCallback);
                }
                jSONObject2.putOpt("sessionId", str2);
                if (jSONObject == null) {
                    jSONObject2.put("params", new JSONObject());
                } else {
                    jSONObject2.put("params", jSONObject);
                }
                j(jSONObject2.toString());
            } catch (JSONException unused) {
            }
        }
    }
}
