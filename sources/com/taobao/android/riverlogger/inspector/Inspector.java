package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.C6581b;
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
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<C6575a>> b;
    private static final AtomicBoolean c;
    private static boolean d;
    private static final ConcurrentLinkedQueue<IConnectionListener> e;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<C6576a>> f;
    private static final ConcurrentHashMap<String, Set<String>> g;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IConnectionListener {
        void connected(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.riverlogger.inspector.Inspector$a */
    /* loaded from: classes12.dex */
    public static class C6575a {
        public String a;
        public InspectorAgent b;

        C6575a(InspectorAgent inspectorAgent, String str) {
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

    private static void a(C6575a c6575a, boolean z) {
        for (Map.Entry<String, InspectorCommandHandler> entry : c6575a.b.getCommands().entrySet()) {
            ConcurrentHashMap<String, ConcurrentLinkedQueue<C6576a>> concurrentHashMap = f;
            ConcurrentLinkedQueue<C6576a> putIfAbsent = concurrentHashMap.putIfAbsent(entry.getKey(), new ConcurrentLinkedQueue<>());
            if (putIfAbsent == null) {
                putIfAbsent = concurrentHashMap.get(entry.getKey());
            }
            putIfAbsent.add(new C6576a(entry.getValue(), entry.getKey(), c6575a.a));
        }
        if (z && d) {
            c6575a.b.connectionChanged(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.taobao.android.riverlogger.inspector.C6576a b(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.Nullable java.util.Set<java.lang.String> r4) {
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
            com.taobao.android.riverlogger.inspector.a r1 = (com.taobao.android.riverlogger.inspector.C6576a) r1
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
        C6576a b2;
        if (str2 != null) {
            Set<String> set = g.get(str2);
            if (set != null && (b2 = b(str, set)) != null) {
                b2.a.handle(jSONObject, new C6577b(str, i, str2, jSONObject));
                return;
            }
        } else {
            C6576a b3 = b(str, null);
            if (b3 != null) {
                b3.a.handle(jSONObject, new C6577b(str, i, str2, jSONObject));
                return;
            }
        }
        RemoteChannel c2 = C6581b.c();
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
        C6575a c6575a = new C6575a(inspectorAgent, str);
        if (c.get()) {
            a(c6575a, true);
            return;
        }
        ConcurrentHashMap<String, ConcurrentLinkedQueue<C6575a>> concurrentHashMap = b;
        ConcurrentLinkedQueue<C6575a> putIfAbsent = concurrentHashMap.putIfAbsent(str, new ConcurrentLinkedQueue<>());
        if (putIfAbsent == null) {
            putIfAbsent = concurrentHashMap.get(str);
        }
        putIfAbsent.add(c6575a);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        a.put(str, str2);
        f();
    }

    private static void f() {
        RemoteChannel c2 = C6581b.c();
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
                for (ConcurrentLinkedQueue<C6575a> concurrentLinkedQueue : b.values()) {
                    Iterator<C6575a> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        a(it.next(), false);
                    }
                }
            }
            f();
        }
        InspectorNativeAgent.setConnectedNative(z);
        for (ConcurrentLinkedQueue<C6575a> concurrentLinkedQueue2 : b.values()) {
            Iterator<C6575a> it2 = concurrentLinkedQueue2.iterator();
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
