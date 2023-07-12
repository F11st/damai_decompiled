package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Inspector {
    private static final ConcurrentHashMap<String, String> a;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> b;
    private static final AtomicBoolean c;
    private static boolean d;
    private static final ConcurrentLinkedQueue<IConnectionListener> e;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<com.taobao.android.riverlogger.inspector.a>> f;
    private static final ConcurrentHashMap<String, Set<String>> g;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IConnectionListener {
        void connected(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a {
        public String a;
        public InspectorAgent b;

        a(InspectorAgent inspectorAgent, String str) {
            this.b = inspectorAgent;
            this.a = str;
        }
    }

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        b = new ConcurrentHashMap<>();
        c = new AtomicBoolean(false);
        d = false;
        e = new ConcurrentLinkedQueue<>();
        f = new ConcurrentHashMap<>();
        g = new ConcurrentHashMap<>();
        concurrentHashMap.put("os", "Android");
    }

    private static void a(a aVar, boolean z) {
        for (Map.Entry<String, InspectorCommandHandler> entry : aVar.b.getCommands().entrySet()) {
            ConcurrentHashMap<String, ConcurrentLinkedQueue<com.taobao.android.riverlogger.inspector.a>> concurrentHashMap = f;
            ConcurrentLinkedQueue<com.taobao.android.riverlogger.inspector.a> putIfAbsent = concurrentHashMap.putIfAbsent(entry.getKey(), new ConcurrentLinkedQueue<>());
            if (putIfAbsent == null) {
                putIfAbsent = concurrentHashMap.get(entry.getKey());
            }
            putIfAbsent.add(new com.taobao.android.riverlogger.inspector.a(entry.getValue(), entry.getKey(), aVar.a));
        }
        if (z && d) {
            aVar.b.connectionChanged(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.taobao.android.riverlogger.inspector.a b(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.Nullable java.util.Set<java.lang.String> r4) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentLinkedQueue<com.taobao.android.riverlogger.inspector.a>> r0 = com.taobao.android.riverlogger.inspector.Inspector.f
            java.lang.Object r3 = r0.get(r3)
            java.util.concurrent.ConcurrentLinkedQueue r3 = (java.util.concurrent.ConcurrentLinkedQueue) r3
            r0 = 0
            if (r3 != 0) goto Lc
            return r0
        Lc:
            java.util.Iterator r3 = r3.iterator()
        L10:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L28
            java.lang.Object r1 = r3.next()
            com.taobao.android.riverlogger.inspector.a r1 = (com.taobao.android.riverlogger.inspector.a) r1
            if (r4 != 0) goto L1f
            return r1
        L1f:
            java.lang.String r2 = r1.b
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L10
            return r1
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.riverlogger.inspector.Inspector.b(java.lang.String, java.util.Set):com.taobao.android.riverlogger.inspector.a");
    }

    public static void c(@NonNull String str, int i, @Nullable String str2, @NonNull JSONObject jSONObject) {
        com.taobao.android.riverlogger.inspector.a b2;
        if (str2 != null) {
            Set<String> set = g.get(str2);
            if (set != null && (b2 = b(str, set)) != null) {
                b2.a.handle(jSONObject, new b(str, i, str2, jSONObject));
                return;
            }
        } else {
            com.taobao.android.riverlogger.inspector.a b3 = b(str, null);
            if (b3 != null) {
                b3.a.handle(jSONObject, new b(str, i, str2, jSONObject));
                return;
            }
        }
        RemoteChannel c2 = com.taobao.android.riverlogger.remote.b.c();
        if (c2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -70550);
                jSONObject3.put("message", String.format("Method \"%s\" not found", str));
                jSONObject2.put("error", jSONObject3);
            } catch (JSONException unused) {
            }
            c2.d(i, jSONObject2);
        }
    }

    public static void d(@NonNull InspectorAgent inspectorAgent, @NonNull String str) {
        if (inspectorAgent == null || str == null) {
            return;
        }
        a aVar = new a(inspectorAgent, str);
        if (c.get()) {
            a(aVar, true);
            return;
        }
        ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> concurrentHashMap = b;
        ConcurrentLinkedQueue<a> putIfAbsent = concurrentHashMap.putIfAbsent(str, new ConcurrentLinkedQueue<>());
        if (putIfAbsent == null) {
            putIfAbsent = concurrentHashMap.get(str);
        }
        putIfAbsent.add(aVar);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        a.put(str, str2);
        f();
    }

    private static void f() {
        RemoteChannel c2 = com.taobao.android.riverlogger.remote.b.c();
        if (c2 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        c2.k("Dev.clientInfo", null, jSONObject, null);
    }

    public static void g(boolean z) {
        if (z == d) {
            return;
        }
        d = z;
        if (z) {
            if (c.compareAndSet(false, true)) {
                for (ConcurrentLinkedQueue<a> concurrentLinkedQueue : b.values()) {
                    Iterator<a> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        a(it.next(), false);
                    }
                }
            }
            f();
        }
        InspectorNativeAgent.setConnectedNative(z);
        for (ConcurrentLinkedQueue<a> concurrentLinkedQueue2 : b.values()) {
            Iterator<a> it2 = concurrentLinkedQueue2.iterator();
            while (it2.hasNext()) {
                it2.next().b.connectionChanged(z);
            }
        }
        Iterator<IConnectionListener> it3 = e.iterator();
        while (it3.hasNext()) {
            it3.next().connected(z);
        }
    }
}
