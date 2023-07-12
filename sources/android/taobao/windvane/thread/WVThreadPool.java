package android.taobao.windvane.thread;

import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVThreadPool {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE = 500;
    private static final int MAX_POOL_SIZE;
    private static String TAG = "WVThreadPool";
    private static WVThreadPool threadManager;
    private ExecutorService executor = null;
    LinkedHashMap<String, Future> tasks = new LinkedHashMap<>(CORE_POOL_SIZE - 1);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    public static WVThreadPool getInstance() {
        if (threadManager == null) {
            synchronized (WVThreadPool.class) {
                if (threadManager == null) {
                    threadManager = new WVThreadPool();
                }
            }
        }
        return threadManager;
    }

    private void refreshTaskMap() {
        if (this.tasks.size() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(((ThreadPoolExecutor) this.executor).getActiveCount());
        for (Map.Entry<String, Future> entry : this.tasks.entrySet()) {
            if (!entry.getValue().isDone()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.tasks.clear();
        this.tasks.putAll(linkedHashMap);
    }

    public void execute(Runnable runnable) {
        execute(runnable, null);
    }

    public ExecutorService getExecutor() {
        if (this.executor == null) {
            int i = CORE_POOL_SIZE;
            this.executor = new ThreadPoolExecutor(i, MAX_POOL_SIZE, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i));
        }
        return this.executor;
    }

    public void setClientExecutor(Executor executor) {
        if (this.executor == null && executor != null && (executor instanceof ExecutorService)) {
            TAG += "tb";
            this.executor = (ExecutorService) executor;
        }
    }

    public void execute(Runnable runnable, String str) {
        if (this.executor == null) {
            int i = CORE_POOL_SIZE;
            this.executor = new ThreadPoolExecutor(i, MAX_POOL_SIZE, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i));
        }
        if (runnable == null) {
            TaoLog.w(TAG, "execute task is null.");
            return;
        }
        refreshTaskMap();
        if (!TextUtils.isEmpty(str)) {
            if (this.tasks.size() != 0 && this.tasks.size() == CORE_POOL_SIZE - 1 && !this.tasks.containsKey(str)) {
                String str2 = (String) this.tasks.keySet().toArray()[0];
                Future remove = this.tasks.remove(str2);
                if (remove != null) {
                    remove.cancel(true);
                }
                this.tasks.put(str, this.executor.submit(runnable));
                String str3 = TAG;
                TaoLog.d(str3, "remove first task:[" + str2 + jn1.ARRAY_END_STR);
            } else {
                Future put = this.tasks.put(str, this.executor.submit(runnable));
                if (put != null) {
                    put.cancel(true);
                }
                String str4 = TAG;
                TaoLog.d(str4, "overlap the same name task:[" + str + jn1.ARRAY_END_STR);
            }
        } else {
            this.executor.execute(runnable);
        }
        String str5 = TAG;
        TaoLog.d(str5, "activeTask count after:" + ((ThreadPoolExecutor) this.executor).getActiveCount());
    }
}
