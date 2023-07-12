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
    private static final C8102a r = new C8102a();
    private static final Map<Class<?>, List<Class<?>>> s = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<C8108g>> a;
    private final Map<Object, List<Class<?>>> b;
    private final Map<Class<?>, Object> c;
    private final ThreadLocal<C8101c> d;
    private final HandlerC8103b e;
    private final BackgroundPoster f;
    private final AsyncPoster g;
    private final C8107f h;
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
    /* renamed from: de.greenrobot.event.EventBus$a */
    /* loaded from: classes3.dex */
    class C8099a extends ThreadLocal<C8101c> {
        C8099a(EventBus eventBus) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public C8101c initialValue() {
            return new C8101c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: de.greenrobot.event.EventBus$b */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C8100b {
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
    /* renamed from: de.greenrobot.event.EventBus$c */
    /* loaded from: classes3.dex */
    public static final class C8101c {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        Object d;
        boolean e;

        C8101c() {
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

    private void d(C8108g c8108g, Object obj, Throwable th) {
        if (obj instanceof si2) {
            if (this.k) {
                String str = p;
                Log.e(str, "SubscriberExceptionEvent subscriber " + c8108g.a.getClass() + " threw an exception", th);
                si2 si2Var = (si2) obj;
                String str2 = p;
                Log.e(str2, "Initial event " + si2Var.b + " caused exception in " + si2Var.c, si2Var.a);
            }
        } else if (!this.j) {
            if (this.k) {
                String str3 = p;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + c8108g.a.getClass(), th);
            }
            if (this.m) {
                i(new si2(this, th, obj, c8108g.a));
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

    private void j(Object obj, C8101c c8101c) throws Error {
        boolean k;
        Class<?> cls = obj.getClass();
        if (this.o) {
            List<Class<?>> h = h(cls);
            int size = h.size();
            k = false;
            for (int i = 0; i < size; i++) {
                k |= k(obj, c8101c, h.get(i));
            }
        } else {
            k = k(obj, c8101c, cls);
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

    private boolean k(Object obj, C8101c c8101c, Class<?> cls) {
        CopyOnWriteArrayList<C8108g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<C8108g> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            C8108g next = it.next();
            c8101c.d = obj;
            try {
                l(next, obj, c8101c.c);
                if (c8101c.e) {
                    return true;
                }
            } finally {
                c8101c.e = false;
            }
        }
        return true;
    }

    private void l(C8108g c8108g, Object obj, boolean z) {
        int i = C8100b.a[c8108g.b.b.ordinal()];
        if (i == 1) {
            f(c8108g, obj);
        } else if (i == 2) {
            if (z) {
                f(c8108g, obj);
            } else {
                this.e.a(c8108g, obj);
            }
        } else if (i == 3) {
            if (z) {
                this.f.enqueue(c8108g, obj);
            } else {
                f(c8108g, obj);
            }
        } else if (i == 4) {
            this.g.enqueue(c8108g, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + c8108g.b.b);
        }
    }

    private synchronized void n(Object obj, boolean z, int i) {
        for (C8106e c8106e : this.h.a(obj.getClass())) {
            o(obj, c8106e, z, i);
        }
    }

    private void o(Object obj, C8106e c8106e, boolean z, int i) {
        Object obj2;
        Class<?> cls = c8106e.c;
        CopyOnWriteArrayList<C8108g> copyOnWriteArrayList = this.a.get(cls);
        C8108g c8108g = new C8108g(obj, c8106e, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(c8108g)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || c8108g.c > copyOnWriteArrayList.get(i2).c) {
                copyOnWriteArrayList.add(i2, c8108g);
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
                l(c8108g, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void q(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<C8108g> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                C8108g c8108g = copyOnWriteArrayList.get(i);
                if (c8108g.a == obj) {
                    c8108g.d = false;
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
    public void e(C8104c c8104c) {
        Object obj = c8104c.a;
        C8108g c8108g = c8104c.b;
        C8104c.b(c8104c);
        if (c8108g.d) {
            f(c8108g, obj);
        }
    }

    void f(C8108g c8108g, Object obj) {
        try {
            c8108g.b.a.invoke(c8108g.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            d(c8108g, obj, e2.getCause());
        }
    }

    public synchronized boolean g(Object obj) {
        return this.b.containsKey(obj);
    }

    public void i(Object obj) {
        C8101c c8101c = this.d.get();
        List<Object> list = c8101c.a;
        list.add(obj);
        if (c8101c.b) {
            return;
        }
        c8101c.c = Looper.getMainLooper() == Looper.myLooper();
        c8101c.b = true;
        if (!c8101c.e) {
            while (!list.isEmpty()) {
                try {
                    j(list.remove(0), c8101c);
                } finally {
                    c8101c.b = false;
                    c8101c.c = false;
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

    EventBus(C8102a c8102a) {
        this.d = new C8099a(this);
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        this.e = new HandlerC8103b(this, Looper.getMainLooper(), 10);
        this.f = new BackgroundPoster(this);
        this.g = new AsyncPoster(this);
        this.h = new C8107f(c8102a.h);
        this.k = c8102a.a;
        this.l = c8102a.b;
        this.m = c8102a.c;
        this.n = c8102a.d;
        this.j = c8102a.e;
        this.o = c8102a.f;
        this.i = c8102a.g;
    }
}
