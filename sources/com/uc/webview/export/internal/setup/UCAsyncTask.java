package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.utility.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UCAsyncTask<RETURN_TYPE extends UCAsyncTask, CALLBACK_TYPE extends UCAsyncTask> implements Runnable {
    private static final Boolean p = Boolean.FALSE;
    private UCAsyncTask a;
    private ConcurrentLinkedQueue<UCAsyncTask> b;
    private int c;
    private final Object d;
    private final Integer e;
    private final Boolean f;
    private boolean g;
    private boolean h;
    private final bq i;
    private HandlerThread j;
    private Looper k;
    private Handler l;
    private String m;
    public ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> mCallbacks;
    protected UCSetupException mException;
    protected UCSetupException mExtraException;
    protected boolean mHasStarted;
    protected int mPercent;
    private long n;
    private Runnable o;
    private Vector<Pair<String, Pair<Long, Long>>> q;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        public a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object obj) {
            UCAsyncTask.this.callback(((UCAsyncTask) obj).getEvent());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        public b() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object obj) {
            UCAsyncTask.this.stop();
        }
    }

    public UCAsyncTask(Integer num) {
        this(num, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(UCAsyncTask uCAsyncTask) {
        uCAsyncTask.g = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int e(UCAsyncTask uCAsyncTask) {
        int i = uCAsyncTask.c + 1;
        uCAsyncTask.c = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int f(UCAsyncTask uCAsyncTask) {
        ConcurrentLinkedQueue<UCAsyncTask> concurrentLinkedQueue = uCAsyncTask.b;
        if (concurrentLinkedQueue == null) {
            return 1;
        }
        return concurrentLinkedQueue.size() + uCAsyncTask.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long h(UCAsyncTask uCAsyncTask) {
        uCAsyncTask.n = 0L;
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(UCAsyncTask uCAsyncTask) {
        ConcurrentLinkedQueue<UCAsyncTask> concurrentLinkedQueue = uCAsyncTask.b;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        Log.d("UCAsyncTask", "clearSubTasks");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(UCAsyncTask uCAsyncTask) {
        uCAsyncTask.b = null;
        Log.i("UCAsyncTask", "cleanThread mLooper " + uCAsyncTask.k);
        Looper looper = uCAsyncTask.k;
        if (looper != null) {
            looper.quit();
            uCAsyncTask.k = null;
        }
        uCAsyncTask.l = null;
        HandlerThread handlerThread = uCAsyncTask.j;
        if (handlerThread != null) {
            handlerThread.quit();
            uCAsyncTask.j = null;
        }
        Log.d("UCAsyncTask", "cleanThread");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callback(String str) {
        UCLogger create;
        UCLogger create2;
        StringBuilder sb;
        String str2;
        this.m = str;
        try {
            UCSetupException exception = getException();
            if (!UCCore.EVENT_STAT.equals(str) && (create2 = UCLogger.create("d", "UCAsyncTask")) != null) {
                String str3 = "";
                if ("cost".equals(str)) {
                    if (p.booleanValue()) {
                        Pair<String, Pair<Long, Long>> lastElement = this.q.lastElement();
                        sb = new StringBuilder("callback: ");
                        sb.append(a(a()));
                        sb.append(getClass().getSimpleName());
                        sb.append(".");
                        sb.append(str);
                        sb.append(" cost:");
                        sb.append(String.format("%5s", ((Pair) lastElement.second).first));
                        sb.append(" cost_cpu:");
                        sb.append(String.format("%5s", ((Pair) lastElement.second).second));
                        sb.append(" task:");
                        str2 = (String) lastElement.first;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder("callback: ");
                    sb2.append(a(a()));
                    sb2.append(getClass().getSimpleName());
                    sb2.append(".");
                    sb2.append(str);
                    sb2.append(" ");
                    sb2.append("progress".equals(str) ? Integer.valueOf(getPercent()) : "");
                    if ("exception".equals(str) && exception != null) {
                        str3 = exception.toString();
                    }
                    String str4 = str3;
                    sb = sb2;
                    str2 = str4;
                }
                sb.append(str2);
                create2.print(sb.toString(), new Throwable[0]);
            }
            if ("exception".equals(str) && (this instanceof UCSetupTask) && exception != null && (create = UCLogger.create("e", "UCAsyncTask")) != null) {
                create.print("callback: exception: ", exception);
                if (exception != exception.getRootCause()) {
                    create.print("callback: rootCause: ", exception.getRootCause());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ValueCallback<CALLBACK_TYPE> callback = getCallback(str);
        if (callback instanceof WeakReference) {
            callback = (ValueCallback<CALLBACK_TYPE>) ((WeakReference) callback).get();
        }
        if (callback instanceof ValueCallback) {
            try {
                callback.onReceiveValue(this);
            } catch (Throwable th2) {
                android.util.Log.e("UCAsyncTask", "callback exception", th2);
            }
        }
    }

    public final ValueCallback<CALLBACK_TYPE> getCallback(String str) {
        ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap = this.mCallbacks;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final Vector<Pair<String, Pair<Long, Long>>> getCosts() {
        return this.q;
    }

    public final String getEvent() {
        return this.m;
    }

    @Reflection
    public UCSetupException getException() {
        return this.mException;
    }

    @Reflection
    public UCSetupException getExtraException() {
        return this.mExtraException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UCAsyncTask getParent() {
        return this.a;
    }

    public int getPercent() {
        return this.mPercent;
    }

    protected final int getPriority() {
        return this.e.intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean inThread() {
        return Thread.currentThread() == this.j;
    }

    public boolean isPaused() {
        boolean a2;
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            a2 = b2.i.a();
        }
        return a2;
    }

    public boolean isStopped() {
        boolean z;
        synchronized (this.i) {
            z = this.h;
        }
        return z;
    }

    public RETURN_TYPE onEvent(String str, ValueCallback<CALLBACK_TYPE> valueCallback) {
        if (str != null) {
            if (this.mCallbacks == null) {
                synchronized (this) {
                    if (this.mCallbacks == null) {
                        this.mCallbacks = new ConcurrentHashMap<>();
                    }
                }
            }
            if (valueCallback == null) {
                this.mCallbacks.remove(str);
            } else {
                this.mCallbacks.put(str, valueCallback);
            }
        }
        return this;
    }

    public RETURN_TYPE pause() {
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            if (!b2.i.a()) {
                b2.g = true;
            }
        }
        return this;
    }

    protected final RETURN_TYPE post(UCAsyncTask uCAsyncTask) {
        if (uCAsyncTask.a == this) {
            synchronized (this.d) {
                if (this.b == null) {
                    this.b = new ConcurrentLinkedQueue<>();
                }
                this.b.add(uCAsyncTask);
            }
            return this;
        }
        throw new RuntimeException("Please use \"new UCAsyncTask(parentTask).start()\" instead of \"post(new UCAsyncTask())\" to add sub task.");
    }

    public RETURN_TYPE resume() {
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            b2.g = false;
            if (b2.i.a()) {
                b2.i.a(0, null);
            }
        }
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.o;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final RETURN_TYPE setCallbacks(ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap) {
        for (Map.Entry<String, ValueCallback<CALLBACK_TYPE>> entry : concurrentHashMap.entrySet()) {
            onEvent(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public void setException(UCSetupException uCSetupException) {
        this.mException = uCSetupException;
    }

    public void setExtraException(UCSetupException uCSetupException) {
        this.mExtraException = uCSetupException;
    }

    public final RETURN_TYPE setParent(UCAsyncTask uCAsyncTask) {
        this.a = uCAsyncTask;
        return this;
    }

    public final void setPriority(int i) {
        Process.setThreadPriority(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3 A[Catch: all -> 0x00c3, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000b, B:32:0x00c1, B:10:0x000f, B:12:0x0016, B:13:0x001b, B:15:0x0021, B:17:0x002e, B:20:0x0037, B:22:0x0054, B:26:0x00af, B:28:0x00b3, B:23:0x0082, B:25:0x008b, B:29:0x00b7, B:31:0x00be), top: B:37:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RETURN_TYPE start() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.d
            monitor-enter(r0)
            boolean r1 = r4.mHasStarted     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto Lf
            com.uc.webview.export.internal.setup.UCAsyncTask r1 = r4.a     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto Lc1
            android.os.HandlerThread r1 = r4.j     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto Lc1
        Lf:
            r1 = 1
            r4.mHasStarted = r1     // Catch: java.lang.Throwable -> Lc3
            com.uc.webview.export.internal.setup.UCAsyncTask r1 = r4.a     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto L1b
            r1.post(r4)     // Catch: java.lang.Throwable -> Lc3
            goto Lc1
        L1b:
            android.os.HandlerThread r1 = r4.j     // Catch: java.lang.Throwable -> Lc3
            r2 = 225(0xe1, float:3.15E-43)
            if (r1 != 0) goto Lb7
            com.uc.webview.export.internal.uc.startup.b.a(r2)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> Lc3
            if (r1 == r2) goto L8b
            java.lang.Boolean r1 = r4.f     // Catch: java.lang.Throwable -> Lc3
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto L37
            goto L8b
        L37:
            java.lang.String r1 = "UCAsyncTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "createThreadIfNeed myLooper "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r3 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lc3
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lc3
            com.uc.webview.export.internal.utility.Log.i(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto L82
            android.os.Looper.prepare()     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lc3
            r4.k = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "UCAsyncTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "createThreadIfNeed new myLooper "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r3 = r4.k     // Catch: java.lang.Throwable -> Lc3
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lc3
            com.uc.webview.export.internal.utility.Log.i(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper r1 = r4.k     // Catch: java.lang.Throwable -> Lc3
            r4.a(r1)     // Catch: java.lang.Throwable -> Lc3
            android.os.Looper.loop()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "UCAsyncTask"
            java.lang.String r2 = "createThreadIfNeed Looper.loop after"
            com.uc.webview.export.internal.utility.Log.i(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            goto L89
        L82:
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lc3
            r4.a(r1)     // Catch: java.lang.Throwable -> Lc3
        L89:
            r1 = 0
            goto Laf
        L8b:
            java.lang.String r1 = "UCAsyncTask"
            java.lang.String r2 = "createThreadIfNeed Looper.myLooper() == Looper.getMainLooper "
            com.uc.webview.export.internal.utility.Log.i(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            com.uc.webview.export.internal.setup.bs r1 = new com.uc.webview.export.internal.setup.bs     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "U4StartupTask_"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            int r3 = r4.hashCode()     // Catch: java.lang.Throwable -> Lc3
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Integer r3 = r4.e     // Catch: java.lang.Throwable -> Lc3
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> Lc3
            r1.<init>(r4, r2, r3)     // Catch: java.lang.Throwable -> Lc3
        Laf:
            r4.j = r1     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto Lc1
            r1.start()     // Catch: java.lang.Throwable -> Lc3
            goto Lc1
        Lb7:
            com.uc.webview.export.internal.uc.startup.b.a(r2)     // Catch: java.lang.Throwable -> Lc3
            android.os.HandlerThread r1 = r4.j     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto Lc1
            r1.start()     // Catch: java.lang.Throwable -> Lc3
        Lc1:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc3
            return r4
        Lc3:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc3
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.UCAsyncTask.start():com.uc.webview.export.internal.setup.UCAsyncTask");
    }

    public RETURN_TYPE stop() {
        synchronized (this.i) {
            resume();
            this.h = true;
        }
        return this;
    }

    public UCAsyncTask(Integer num, Boolean bool) {
        this.c = 0;
        this.d = new Object();
        this.g = false;
        this.h = false;
        this.i = new bq();
        this.n = 0L;
        this.mHasStarted = false;
        this.q = p.booleanValue() ? new Vector<>() : null;
        this.e = num;
        this.f = bool;
    }

    private UCAsyncTask b() {
        UCAsyncTask<RETURN_TYPE, CALLBACK_TYPE> uCAsyncTask = this;
        while (uCAsyncTask.getParent() != null) {
            uCAsyncTask = uCAsyncTask.getParent();
        }
        return uCAsyncTask;
    }

    private int a() {
        int i = 0;
        for (UCAsyncTask parent = getParent(); parent != null; parent = parent.getParent()) {
            i++;
        }
        return i;
    }

    private static String a(int i) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                sb.append("    ");
                i = i2;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler a(Looper looper) {
        com.uc.webview.export.internal.uc.startup.b.a(TypedValues.Position.TYPE_PERCENT_X);
        br brVar = new br(this, looper);
        this.l = brVar;
        brVar.post(this);
        com.uc.webview.export.internal.uc.startup.b.a(TypedValues.Position.TYPE_PERCENT_Y);
        return this.l;
    }

    public UCAsyncTask(Runnable runnable) {
        this((Integer) 0);
        this.o = runnable;
    }

    public UCAsyncTask(UCAsyncTask uCAsyncTask) {
        this((Runnable) null);
        setParent(uCAsyncTask);
    }

    public final RETURN_TYPE start(long j) {
        this.n = j;
        return start();
    }
}
