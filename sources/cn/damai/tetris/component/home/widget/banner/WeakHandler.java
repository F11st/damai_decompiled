package cn.damai.tetris.component.home.widget.banner;

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
/* loaded from: classes16.dex */
public class WeakHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HandlerC1893b a;
    private Lock b;
    @VisibleForTesting
    final C1892a c;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class WeakRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<Runnable> mDelegate;
        private final WeakReference<C1892a> mReference;

        WeakRunnable(WeakReference<Runnable> weakReference, WeakReference<C1892a> weakReference2) {
            this.mDelegate = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-902081376")) {
                ipChange.ipc$dispatch("-902081376", new Object[]{this});
                return;
            }
            Runnable runnable = this.mDelegate.get();
            C1892a c1892a = this.mReference.get();
            if (c1892a != null) {
                c1892a.b();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.widget.banner.WeakHandler$a */
    /* loaded from: classes16.dex */
    public static class C1892a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        C1892a a;
        @Nullable
        C1892a b;
        @NonNull
        final Runnable c;
        @NonNull
        final WeakRunnable d;
        @NonNull
        Lock e;

        public C1892a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.c = runnable;
            this.e = lock;
            this.d = new WeakRunnable(new WeakReference(runnable), new WeakReference(this));
        }

        public void a(@NonNull C1892a c1892a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1415590679")) {
                ipChange.ipc$dispatch("1415590679", new Object[]{this, c1892a});
                return;
            }
            this.e.lock();
            try {
                C1892a c1892a2 = this.a;
                if (c1892a2 != null) {
                    c1892a2.b = c1892a;
                }
                c1892a.a = c1892a2;
                this.a = c1892a;
                c1892a.b = this;
            } finally {
                this.e.unlock();
            }
        }

        public WeakRunnable b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1160020984")) {
                return (WeakRunnable) ipChange.ipc$dispatch("-1160020984", new Object[]{this});
            }
            this.e.lock();
            try {
                C1892a c1892a = this.b;
                if (c1892a != null) {
                    c1892a.a = this.a;
                }
                C1892a c1892a2 = this.a;
                if (c1892a2 != null) {
                    c1892a2.b = c1892a;
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
            if (AndroidInstantRuntime.support(ipChange, "-1182283386")) {
                return (WeakRunnable) ipChange.ipc$dispatch("-1182283386", new Object[]{this, runnable});
            }
            this.e.lock();
            try {
                for (C1892a c1892a = this.a; c1892a != null; c1892a = c1892a.a) {
                    if (c1892a.c == runnable) {
                        return c1892a.b();
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
    /* renamed from: cn.damai.tetris.component.home.widget.banner.WeakHandler$b */
    /* loaded from: classes16.dex */
    public static class HandlerC1893b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<Handler.Callback> a = null;

        HandlerC1893b() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Handler.Callback callback;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1381716509")) {
                ipChange.ipc$dispatch("1381716509", new Object[]{this, message});
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
        this.c = new C1892a(reentrantLock, null);
        this.a = new HandlerC1893b();
    }

    private WeakRunnable e(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752037582")) {
            return (WeakRunnable) ipChange.ipc$dispatch("-1752037582", new Object[]{this, runnable});
        }
        Objects.requireNonNull(runnable, "Runnable can't be null");
        C1892a c1892a = new C1892a(this.b, runnable);
        this.c.a(c1892a);
        return c1892a.d;
    }

    public final boolean a(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1563246226") ? ((Boolean) ipChange.ipc$dispatch("-1563246226", new Object[]{this, runnable})).booleanValue() : this.a.post(e(runnable));
    }

    public final boolean b(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-625217554") ? ((Boolean) ipChange.ipc$dispatch("-625217554", new Object[]{this, runnable, Long.valueOf(j)})).booleanValue() : this.a.postDelayed(e(runnable), j);
    }

    public final void c(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345285266")) {
            ipChange.ipc$dispatch("1345285266", new Object[]{this, runnable});
            return;
        }
        WeakRunnable c = this.c.c(runnable);
        if (c != null) {
            this.a.removeCallbacks(c);
        }
    }

    public final void d(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675079281")) {
            ipChange.ipc$dispatch("-675079281", new Object[]{this, obj});
        } else {
            this.a.removeCallbacksAndMessages(obj);
        }
    }
}
