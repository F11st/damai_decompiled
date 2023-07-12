package cn.damai.uikit.banner;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class WeakHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HandlerC2475b a;
    private Lock b;
    @VisibleForTesting
    final C2474a c;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class WeakRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<Runnable> mDelegate;
        private final WeakReference<C2474a> mReference;

        WeakRunnable(WeakReference<Runnable> weakReference, WeakReference<C2474a> weakReference2) {
            this.mDelegate = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1949622152")) {
                ipChange.ipc$dispatch("1949622152", new Object[]{this});
                return;
            }
            Runnable runnable = this.mDelegate.get();
            C2474a c2474a = this.mReference.get();
            if (c2474a != null) {
                c2474a.b();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.banner.WeakHandler$a */
    /* loaded from: classes17.dex */
    public static class C2474a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        C2474a a;
        @Nullable
        C2474a b;
        @NonNull
        final Runnable c;
        @NonNull
        final WeakRunnable d;
        @NonNull
        Lock e;

        public C2474a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.c = runnable;
            this.e = lock;
            this.d = new WeakRunnable(new WeakReference(runnable), new WeakReference(this));
        }

        public void a(@NonNull C2474a c2474a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365766209")) {
                ipChange.ipc$dispatch("365766209", new Object[]{this, c2474a});
                return;
            }
            this.e.lock();
            try {
                C2474a c2474a2 = this.a;
                if (c2474a2 != null) {
                    c2474a2.b = c2474a;
                }
                c2474a.a = c2474a2;
                this.a = c2474a;
                c2474a.b = this;
            } finally {
                this.e.unlock();
            }
        }

        public WeakRunnable b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "513670258")) {
                return (WeakRunnable) ipChange.ipc$dispatch("513670258", new Object[]{this});
            }
            this.e.lock();
            try {
                C2474a c2474a = this.b;
                if (c2474a != null) {
                    c2474a.a = this.a;
                }
                C2474a c2474a2 = this.a;
                if (c2474a2 != null) {
                    c2474a2.b = c2474a;
                }
                this.b = null;
                this.a = null;
                this.e.unlock();
                return this.d;
            } catch (Throwable th) {
                this.e.unlock();
                throw th;
            }
        }

        @Nullable
        public WeakRunnable c(Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1674772300")) {
                return (WeakRunnable) ipChange.ipc$dispatch("-1674772300", new Object[]{this, runnable});
            }
            this.e.lock();
            try {
                for (C2474a c2474a = this.a; c2474a != null; c2474a = c2474a.a) {
                    if (c2474a.c == runnable) {
                        return c2474a.b();
                    }
                }
                this.e.unlock();
                return null;
            } finally {
                this.e.unlock();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.banner.WeakHandler$b */
    /* loaded from: classes17.dex */
    public static class HandlerC2475b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<Handler.Callback> a = null;

        HandlerC2475b() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Handler.Callback callback;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-402550731")) {
                ipChange.ipc$dispatch("-402550731", new Object[]{this, message});
                return;
            }
            WeakReference<Handler.Callback> weakReference = this.a;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }
    }

    public WeakHandler() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.b = reentrantLock;
        this.c = new C2474a(reentrantLock, null);
        this.a = new HandlerC2475b();
    }

    private WeakRunnable e(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71445064")) {
            return (WeakRunnable) ipChange.ipc$dispatch("-71445064", new Object[]{this, runnable});
        }
        Objects.requireNonNull(runnable, "Runnable can't be null");
        C2474a c2474a = new C2474a(this.b, runnable);
        this.c.a(c2474a);
        return c2474a.d;
    }

    public final boolean a(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2052660138") ? ((Boolean) ipChange.ipc$dispatch("-2052660138", new Object[]{this, runnable})).booleanValue() : this.a.post(e(runnable));
    }

    public final boolean b(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "508734166") ? ((Boolean) ipChange.ipc$dispatch("508734166", new Object[]{this, runnable, Long.valueOf(j)})).booleanValue() : this.a.postDelayed(e(runnable), j);
    }

    public final void c(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1311774550")) {
            ipChange.ipc$dispatch("-1311774550", new Object[]{this, runnable});
            return;
        }
        WeakRunnable c = this.c.c(runnable);
        if (c != null) {
            this.a.removeCallbacks(c);
        }
    }

    public final void d(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1009730953")) {
            ipChange.ipc$dispatch("-1009730953", new Object[]{this, obj});
        } else {
            this.a.removeCallbacksAndMessages(obj);
        }
    }
}
