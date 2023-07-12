package anet.channel.strategy.dispatch;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.a5;
import tb.hu0;
import tb.t9;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AmdcTaskExecutor {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";
    private static Random c = new Random();
    private Map<String, Object> a;
    private AtomicBoolean b = new AtomicBoolean(true);

    public void c(Map<String, Object> map) {
        try {
            map.put("Env", hu0.e());
            synchronized (this) {
                Map<String, Object> map2 = this.a;
                if (map2 == null) {
                    this.a = map;
                    int nextInt = (t9.E() && this.b.compareAndSet(true, false)) ? 0 : c.nextInt(3000) + 2000;
                    ALog.f(TAG, "merge amdc request", null, "delay", Integer.valueOf(nextInt));
                    a5.c(new AmdcTask(), nextInt);
                } else {
                    Set set = (Set) map2.get("hosts");
                    Set set2 = (Set) map.get("hosts");
                    if (map.get("Env") != this.a.get("Env")) {
                        this.a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.a = map;
                    } else {
                        a5.d(new AmdcTask(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class AmdcTask implements Runnable {
        private Map<String, Object> params;

        AmdcTask(Map<String, Object> map) {
            this.params = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.params;
                if (map2 == null) {
                    synchronized (AmdcTaskExecutor.class) {
                        map = AmdcTaskExecutor.this.a;
                        AmdcTaskExecutor.this.a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.n()) {
                    if (hu0.e() != map2.get("Env")) {
                        ALog.k(AmdcTaskExecutor.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        a.g(b.a(map2));
                    }
                }
            } catch (Exception e) {
                ALog.d(AmdcTaskExecutor.TAG, "exec amdc task failed.", null, e, new Object[0]);
            }
        }

        AmdcTask() {
        }
    }
}
