package tb;

import com.taobao.network.lifecycle.INetworkLifecycle;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uj1 implements INetworkLifecycle {
    private INetworkLifecycle a;
    private Lock b;
    private Lock c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class b {
        private static final uj1 a = new uj1();
    }

    public static uj1 a() {
        return b.a;
    }

    public void b(INetworkLifecycle iNetworkLifecycle) {
        this.c.lock();
        try {
            this.a = null;
        } finally {
            this.c.unlock();
        }
    }

    public void c(INetworkLifecycle iNetworkLifecycle) {
        this.c.lock();
        try {
            if (this.a == null) {
                this.a = iNetworkLifecycle;
            }
        } finally {
            this.c.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onCancel(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onCancel(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onError(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onError(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onEvent(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onFinished(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onFinished(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onRequest(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onValidRequest(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            INetworkLifecycle iNetworkLifecycle = this.a;
            if (iNetworkLifecycle != null) {
                iNetworkLifecycle.onValidRequest(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    private uj1() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
    }
}
