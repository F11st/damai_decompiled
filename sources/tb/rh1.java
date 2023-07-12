package tb;

import com.taobao.network.lifecycle.IMtopLifecycle;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rh1 implements IMtopLifecycle {
    private IMtopLifecycle a;
    private Lock b;
    private Lock c;

    /* compiled from: Taobao */
    /* renamed from: tb.rh1$b */
    /* loaded from: classes11.dex */
    private static final class C9652b {
        private static final rh1 a = new rh1();
    }

    public static rh1 a() {
        return C9652b.a;
    }

    public void b(IMtopLifecycle iMtopLifecycle) {
        this.c.lock();
        try {
            this.a = null;
        } finally {
            this.c.unlock();
        }
    }

    public void c(IMtopLifecycle iMtopLifecycle) {
        this.c.lock();
        try {
            if (this.a == null) {
                this.a = iMtopLifecycle;
            }
        } finally {
            this.c.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopCancel(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopCancel(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopError(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopError(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopEvent(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopEvent(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopFinished(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopFinished(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopRequest(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopRequest(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    private rh1() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
    }
}
