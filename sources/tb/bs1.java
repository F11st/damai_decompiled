package tb;

import com.taobao.phenix.lifecycle.IPhenixLifeCycle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bs1 implements IPhenixLifeCycle {
    private List<IPhenixLifeCycle> a;
    private Lock b;
    private Lock c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        private static final bs1 a = new bs1();
    }

    public static bs1 b() {
        return b.a;
    }

    public void a(IPhenixLifeCycle iPhenixLifeCycle) {
        this.c.lock();
        if (iPhenixLifeCycle != null) {
            try {
                if (!this.a.contains(iPhenixLifeCycle)) {
                    this.a.add(iPhenixLifeCycle);
                }
            } finally {
                this.c.unlock();
            }
        }
    }

    public void c(IPhenixLifeCycle iPhenixLifeCycle) {
        this.c.lock();
        try {
            this.a.remove(iPhenixLifeCycle);
        } finally {
            this.c.unlock();
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onCancel(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            for (IPhenixLifeCycle iPhenixLifeCycle : this.a) {
                iPhenixLifeCycle.onCancel(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onError(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            for (IPhenixLifeCycle iPhenixLifeCycle : this.a) {
                iPhenixLifeCycle.onError(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            for (IPhenixLifeCycle iPhenixLifeCycle : this.a) {
                iPhenixLifeCycle.onEvent(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onFinished(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            for (IPhenixLifeCycle iPhenixLifeCycle : this.a) {
                iPhenixLifeCycle.onFinished(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            for (IPhenixLifeCycle iPhenixLifeCycle : this.a) {
                iPhenixLifeCycle.onRequest(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    private bs1() {
        this.a = new ArrayList(2);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
    }
}
