package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import tb.si2;
import tb.uk1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EventBus {
    public static String p = "Event";
    static volatile EventBus q;
    private static final de.greenrobot.event.a r = new de.greenrobot.event.a();
    private static final Map<Class<?>, List<Class<?>>> s = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<g>> a;
    private final Map<Object, List<Class<?>>> b;
    private final Map<Class<?>, Object> c;
    private final ThreadLocal<c> d;
    private final de.greenrobot.event.b e;
    private final BackgroundPoster f;
    private final AsyncPoster g;
    private final f h;
    private final ExecutorService i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    interface PostCallback {
        void onPostCompleted(List<si2> list);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class a extends ThreadLocal<c> {
        a(EventBus eventBus) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public c initialValue() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        Object d;
        boolean e;

        c() {
        }
    }

    public EventBus() {
        this(r);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus b() {
        if (q == null) {
            synchronized (EventBus.class) {
                if (q == null) {
                    q = new EventBus();
                }
            }
        }
        return q;
    }

    private void d(g gVar, Object obj, Throwable th) {
        if (obj instanceof si2) {
            if (this.k) {
                String str = p;
                Log.e(str, "SubscriberExceptionEvent subscriber " + gVar.a.getClass() + " threw an exception", th);
                si2 si2Var = (si2) obj;
                String str2 = p;
                Log.e(str2, "Initial event " + si2Var.b + " caused exception in " + si2Var.c, si2Var.a);
            }
        } else if (!this.j) {
            if (this.k) {
                String str3 = p;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + gVar.a.getClass(), th);
            }
            if (this.m) {
                i(new si2(this, th, obj, gVar.a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    private List<Class<?>> h(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = s;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                s.put(cls, list);
            }
        }
        return list;
    }

    private void j(Object obj, c cVar) throws Error {
        boolean k;
        Class<?> cls = obj.getClass();
        if (this.o) {
            List<Class<?>> h = h(cls);
            int size = h.size();
            k = false;
            for (int i = 0; i < size; i++) {
                k |= k(obj, cVar, h.get(i));
            }
        } else {
            k = k(obj, cVar, cls);
        }
        if (k) {
            return;
        }
        if (this.l) {
            String str = p;
            Log.d(str, "No subscribers registered for event " + cls);
        }
        if (!this.n || cls == uk1.class || cls == si2.class) {
            return;
        }
        i(new uk1(this, obj));
    }

    private boolean k(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<g> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            cVar.d = obj;
            try {
                l(next, obj, cVar.c);
                if (cVar.e) {
                    return true;
                }
            } finally {
                cVar.e = false;
            }
        }
        return true;
    }

    private void l(g gVar, Object obj, boolean z) {
        int i = b.a[gVar.b.b.ordinal()];
        if (i == 1) {
            f(gVar, obj);
        } else if (i == 2) {
            if (z) {
                f(gVar, obj);
            } else {
                this.e.a(gVar, obj);
            }
        } else if (i == 3) {
            if (z) {
                this.f.enqueue(gVar, obj);
            } else {
                f(gVar, obj);
            }
        } else if (i == 4) {
            this.g.enqueue(gVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + gVar.b.b);
        }
    }

    private synchronized void n(Object obj, boolean z, int i) {
        for (e eVar : this.h.a(obj.getClass())) {
            o(obj, eVar, z, i);
        }
    }

    private void o(Object obj, e eVar, boolean z, int i) {
        Object obj2;
        Class<?> cls = eVar.c;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.a.get(cls);
        g gVar = new g(obj, eVar, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(gVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || gVar.c > copyOnWriteArrayList.get(i2).c) {
                copyOnWriteArrayList.add(i2, gVar);
                break;
            }
        }
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.c) {
                obj2 = this.c.get(cls);
            }
            if (obj2 != null) {
                l(gVar, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void q(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                g gVar = copyOnWriteArrayList.get(i);
                if (gVar.a == obj) {
                    gVar.d = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(de.greenrobot.event.c cVar) {
        Object obj = cVar.a;
        g gVar = cVar.b;
        de.greenrobot.event.c.b(cVar);
        if (gVar.d) {
            f(gVar, obj);
        }
    }

    void f(g gVar, Object obj) {
        try {
            gVar.b.a.invoke(gVar.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            d(gVar, obj, e2.getCause());
        }
    }

    public synchronized boolean g(Object obj) {
        return this.b.containsKey(obj);
    }

    public void i(Object obj) {
        c cVar = this.d.get();
        List<Object> list = cVar.a;
        list.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = Looper.getMainLooper() == Looper.myLooper();
        cVar.b = true;
        if (!cVar.e) {
            while (!list.isEmpty()) {
                try {
                    j(list.remove(0), cVar);
                } finally {
                    cVar.b = false;
                    cVar.c = false;
                }
            }
            return;
        }
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    public void m(Object obj) {
        n(obj, false, 0);
    }

    public synchronized void p(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                q(obj, cls);
            }
            this.b.remove(obj);
        } else {
            String str = p;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    EventBus(de.greenrobot.event.a aVar) {
        this.d = new a(this);
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        this.e = new de.greenrobot.event.b(this, Looper.getMainLooper(), 10);
        this.f = new BackgroundPoster(this);
        this.g = new AsyncPoster(this);
        this.h = new f(aVar.h);
        this.k = aVar.a;
        this.l = aVar.b;
        this.m = aVar.c;
        this.n = aVar.d;
        this.j = aVar.e;
        this.o = aVar.f;
        this.i = aVar.g;
    }
}
