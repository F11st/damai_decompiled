package com.alibaba.analytics.core.store;

import android.util.Log;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import tb.ea2;
import tb.fa2;
import tb.hl2;
import tb.qa1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LogStoreMgr implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static LogStoreMgr f = new LogStoreMgr();
    public static fa2 g = new fa2();
    private static int h = 0;
    private static final Object i = new Object();
    private static final Object j = new Object();
    private List<qa1> b = new CopyOnWriteArrayList();
    private List<ILogChangeListener> c = Collections.synchronizedList(new ArrayList());
    private ScheduledFuture d = null;
    private Runnable e = new Runnable() { // from class: com.alibaba.analytics.core.store.LogStoreMgr.1
        @Override // java.lang.Runnable
        public void run() {
            LogStoreMgr.this.n();
        }
    };
    private ILogStore a = new a(Variables.n().j());

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class CleanDbTask implements Runnable {
        CleanDbTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int f;
            Logger.d();
            int g = LogStoreMgr.this.g();
            if (g > 0) {
                LogStoreMgr.g.onEvent(ea2.a(ea2.i, "time_ex", Double.valueOf(g)));
            }
            int count = LogStoreMgr.this.a.count();
            if (count <= 9000 || (f = LogStoreMgr.this.f(count)) <= 0) {
                return;
            }
            LogStoreMgr.g.onEvent(ea2.a(ea2.i, "count_ex", Double.valueOf(f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class CleanLogTask implements Runnable {
        CleanLogTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.f("LogStoreMgr", "CleanLogTask");
            int count = LogStoreMgr.this.a.count();
            if (count > 9000) {
                LogStoreMgr.this.f(count);
            }
        }
    }

    private LogStoreMgr() {
        hl2.c().f(new CleanDbTask());
        UTServerAppStatusTrigger.d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2) {
        Logger.f("LogStoreMgr", "clearOldLogByCount", Integer.valueOf(i2 > 9000 ? this.a.clearOldLogByCount((i2 - 9000) + 1000) : 0));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        Logger.d();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        return this.a.clearOldLogByField("time", String.valueOf(calendar.getTimeInMillis()));
    }

    private void j(int i2, int i3) {
        for (int i4 = 0; i4 < this.c.size(); i4++) {
            ILogChangeListener iLogChangeListener = this.c.get(i4);
            if (iLogChangeListener != null) {
                if (i2 == 1) {
                    iLogChangeListener.onInsert(i3, h());
                } else if (i2 == 2) {
                    iLogChangeListener.onDelete(i3, h());
                }
            }
        }
    }

    public static LogStoreMgr l() {
        return f;
    }

    public void d(qa1 qa1Var) {
        int size;
        if (Logger.n()) {
            Logger.m("LogStoreMgr", "Log", qa1Var.b());
        }
        synchronized (j) {
            this.b.add(qa1Var);
            size = this.b.size();
        }
        if (size < 45 && !Variables.n().M()) {
            ScheduledFuture scheduledFuture = this.d;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.d = hl2.c().d(this.d, this.e, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        } else {
            this.d = hl2.c().d(null, this.e, 0L);
        }
        synchronized (i) {
            int i2 = h + 1;
            h = i2;
            if (i2 > 5000) {
                h = 0;
                hl2.c().f(new CleanLogTask());
            }
        }
    }

    public void e(qa1 qa1Var) {
        d(qa1Var);
        n();
    }

    public long h() {
        return this.a.count();
    }

    public int i(List<qa1> list) {
        return this.a.delete(list);
    }

    public List<qa1> k(int i2) {
        return this.a.get(i2);
    }

    public void m(ILogChangeListener iLogChangeListener) {
        this.c.add(iLogChangeListener);
    }

    public void n() {
        ArrayList arrayList = null;
        try {
            synchronized (j) {
                if (this.b.size() > 0) {
                    arrayList = new ArrayList(this.b);
                    this.b.clear();
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.a.insert(arrayList);
            j(1, arrayList.size());
        } catch (Throwable th) {
            Log.w("LogStoreMgr", "", th);
        }
    }

    public void o(ILogChangeListener iLogChangeListener) {
        this.c.remove(iLogChangeListener);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("LogStoreMgr", "onBackground", Boolean.TRUE);
        this.d = hl2.c().d(null, this.e, 0L);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
    }

    public void p(List<qa1> list) {
        this.a.updateLogPriority(list);
    }
}
