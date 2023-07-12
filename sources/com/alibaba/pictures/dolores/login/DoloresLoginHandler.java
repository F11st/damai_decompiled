package com.alibaba.pictures.dolores.login;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.rq;
import tb.sb0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DoloresLoginHandler extends Handler implements IDoloresLoginListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int LOGIN = 0;
    public static final int LOGIN_RET_CANCEL = 3;
    public static final int LOGIN_RET_FAIL = 2;
    public static final int LOGIN_RET_INIT = 0;
    public static final int LOGIN_RET_SUCCESS = 1;
    @NotNull
    private static final String b;
    @NotNull
    private static final AtomicBoolean c;
    @NotNull
    private static final Lazy d;
    private static final ReentrantLock e;
    private static Condition f;
    private int a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @NotNull
        public final DoloresLoginHandler a() {
            Object value;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2126724172")) {
                value = ipChange.ipc$dispatch("2126724172", new Object[]{this});
            } else {
                Lazy lazy = DoloresLoginHandler.d;
                a aVar = DoloresLoginHandler.Companion;
                value = lazy.getValue();
            }
            return (DoloresLoginHandler) value;
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        Lazy b2;
        String simpleName = DoloresLoginHandler.class.getSimpleName();
        b41.h(simpleName, "DoloresLoginHandler::class.java.simpleName");
        b = simpleName;
        c = new AtomicBoolean();
        b2 = b.b(new Function0<DoloresLoginHandler>() { // from class: com.alibaba.pictures.dolores.login.DoloresLoginHandler$Companion$sInstance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DoloresLoginHandler invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "603310016")) {
                    return (DoloresLoginHandler) ipChange.ipc$dispatch("603310016", new Object[]{this});
                }
                Looper mainLooper = Looper.getMainLooper();
                b41.h(mainLooper, "Looper.getMainLooper()");
                return new DoloresLoginHandler(mainLooper, null);
            }
        });
        d = b2;
        ReentrantLock reentrantLock = new ReentrantLock();
        e = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        b41.h(newCondition, "lock.newCondition()");
        f = newCondition;
    }

    private DoloresLoginHandler(Looper looper) {
        super(looper);
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970798375")) {
            return ((Integer) ipChange.ipc$dispatch("-1970798375", new Object[]{this})).intValue();
        }
        d();
        e.lock();
        try {
            AtomicBoolean atomicBoolean = c;
            if (!atomicBoolean.get()) {
                atomicBoolean.set(true);
                this.a = 0;
                sendEmptyMessage(0);
            }
            try {
                String str = b;
                rq.a(str, this + " wait");
                f.await();
                rq.a(str, this + " wakeup");
            } catch (Exception e2) {
                rq.b(b, e2);
            }
            e.unlock();
            return this.a;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1916304416")) {
            return ((Boolean) ipChange.ipc$dispatch("1916304416", new Object[]{this})).booleanValue();
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            IDoloresLoginDelegate d2 = sb0.Companion.d();
            if (d2 != null) {
                if (d2.isSessionValid()) {
                    z = true;
                }
            }
        } catch (Exception unused) {
            reentrantLock = e;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
        reentrantLock.unlock();
        return z;
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847952401")) {
            ipChange.ipc$dispatch("-847952401", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            rq.a(str, this + " onLoginCancel");
            this.a = 3;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022227118")) {
            ipChange.ipc$dispatch("-2022227118", new Object[]{this, message});
            return;
        }
        b41.i(message, "msg");
        if (message.what != 0) {
            return;
        }
        String str = b;
        rq.a(str, this + " handleMessage login");
        IDoloresLoginDelegate d2 = sb0.Companion.d();
        if (d2 != null) {
            d2.doLogin(true, this);
            return;
        }
        rq.c(str, this + " loginDelegate==null");
        onLoginFail();
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649263558")) {
            ipChange.ipc$dispatch("-649263558", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            rq.a(str, this + " onLoginCancel");
            this.a = 3;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896759594")) {
            ipChange.ipc$dispatch("-1896759594", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            rq.a(str, this + " onLoginFail");
            this.a = 2;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273281293")) {
            ipChange.ipc$dispatch("-1273281293", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            rq.a(str, this + " onLoginSuccess");
            this.a = 1;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public /* synthetic */ DoloresLoginHandler(Looper looper, k50 k50Var) {
        this(looper);
    }
}
