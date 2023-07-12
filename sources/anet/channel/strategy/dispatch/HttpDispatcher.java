package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.hu0;
import tb.y90;
import tb.z90;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HttpDispatcher {
    private CopyOnWriteArraySet<IDispatchEventListener> a;
    private AmdcTaskExecutor b;
    private volatile boolean c;
    private Set<String> d;
    private Set<String> e;
    private AtomicBoolean f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface IDispatchEventListener {
        void onEvent(z90 z90Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.dispatch.HttpDispatcher$b */
    /* loaded from: classes.dex */
    public static class C0230b {
        static HttpDispatcher a = new HttpDispatcher();
    }

    private void c() {
        if (this.f.get() || hu0.c() == null || !this.f.compareAndSet(false, true)) {
            return;
        }
        this.e.add(y90.a());
        if (hu0.j()) {
            this.e.addAll(Arrays.asList(y90.a));
        }
    }

    public static HttpDispatcher f() {
        return C0230b.a;
    }

    public synchronized void a(List<String> list) {
        if (list != null) {
            this.e.addAll(list);
            this.d.clear();
        }
    }

    public void b(IDispatchEventListener iDispatchEventListener) {
        this.a.add(iDispatchEventListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(z90 z90Var) {
        Iterator<IDispatchEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(z90Var);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized Set<String> e() {
        c();
        return new HashSet(this.e);
    }

    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.d.contains(str);
        if (!contains) {
            this.d.add(str);
        }
        return !contains;
    }

    public void h(Set<String> set, int i) {
        if (this.c && set != null && !set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!AmdcRuntimeInfo.d(next)) {
                    ALog.e("awcn.HttpDispatcher", "Not allow to send send amdc request.", null, "host", next);
                    it.remove();
                }
            }
            if (set.isEmpty()) {
                return;
            }
            if (ALog.g(2)) {
                ALog.f("awcn.HttpDispatcher", "sendAmdcRequest", null, "hosts", set.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("hosts", set);
            hashMap.put(y90.CONFIG_VERSION, String.valueOf(i));
            this.b.c(hashMap);
            return;
        }
        ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
    }

    public void i() {
        this.d.clear();
        this.e.clear();
        this.f.set(false);
    }

    private HttpDispatcher() {
        this.a = new CopyOnWriteArraySet<>();
        this.b = new AmdcTaskExecutor();
        this.c = true;
        this.d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.e = new TreeSet();
        this.f = new AtomicBoolean();
        c();
    }
}
