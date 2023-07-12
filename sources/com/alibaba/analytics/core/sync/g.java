package com.alibaba.analytics.core.sync;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.store.ILogChangeListener;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.UploadLog;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.concurrent.ScheduledFuture;
import org.apache.commons.lang3.time.DateUtils;
import tb.hl2;
import tb.u6;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class g implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    static g k = new g();
    private ScheduledFuture c;
    private ILogChangeListener d;
    private long a = 30000;
    private UploadMode b = null;
    private UploadTask e = new UploadTask();
    private UploadLog.NetworkStatus f = UploadLog.NetworkStatus.ALL;
    private boolean g = false;
    private final Object h = new Object();
    private boolean i = false;
    private long j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements IUploadExcuted {
        a() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            e.h().c(g.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements ILogChangeListener {
        b() {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onDelete(long j, long j2) {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onInsert(long j, long j2) {
            if (com.alibaba.analytics.core.config.b.a()) {
                synchronized (g.this.h) {
                    if (g.this.d != null) {
                        LogStoreMgr.l().o(g.this.d);
                    }
                    Variables.n().p0();
                }
                return;
            }
            Logger.f("RealTimeMode", AdUtConstants.XAD_UT_ARG_COUNT, Long.valueOf(j), "dbSize", Long.valueOf(j2));
            if (j <= 0 || j2 <= 0 || UploadMode.REALTIME != g.this.b) {
                return;
            }
            g.this.c = hl2.c().d(null, g.this.e, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements IUploadExcuted {
        c() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            g gVar = g.this;
            gVar.a = gVar.k();
            Logger.f("UploadMgr", "CurrentUploadInterval", Long.valueOf(g.this.a));
            f.i().c(g.this.f);
            g.this.c = hl2.c().d(g.this.c, g.this.e, g.this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UploadMode.values().length];
            a = iArr;
            try {
                iArr[UploadMode.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private g() {
        UTServerAppStatusTrigger.d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long k() {
        if (this.g) {
            return r() ? n() : m();
        }
        this.i = false;
        long o = o();
        if (o == 0) {
            return 30000L;
        }
        return o;
    }

    private long m() {
        long j = SystemConfigMgr.i().j("bu") * 1000;
        if (j <= 0) {
            return 300000L;
        }
        return j;
    }

    private long n() {
        long j = SystemConfigMgr.i().j("bu2") * 1000;
        if (j <= 0) {
            return 600000L;
        }
        return j;
    }

    private long o() {
        long j = SystemConfigMgr.i().j(IRequestConst.FU) * 1000;
        if (j <= 0) {
            return 30000L;
        }
        return j;
    }

    public static g p() {
        return k;
    }

    private boolean r() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.j > DateUtils.MILLIS_PER_MINUTE) {
            this.j = elapsedRealtime;
            boolean j = u6.j(Variables.n().j());
            this.i = j;
            Logger.f("UploadMgr", "isMainProcessDeadExtend", Boolean.valueOf(j));
        } else {
            Logger.f("UploadMgr", "time limit. isMainProcessDeadExtend", Boolean.valueOf(this.i));
        }
        return this.i;
    }

    private void s() {
        String f = u6.f(Variables.n().j(), "UTANALYTICS_UPLOAD_ALLOWED_NETWORK_STATUS");
        if (TextUtils.isEmpty(f)) {
            return;
        }
        if ("ALL".equalsIgnoreCase(f)) {
            this.f = UploadLog.NetworkStatus.ALL;
        } else if ("2G".equalsIgnoreCase(f)) {
            this.f = UploadLog.NetworkStatus.TWO_GENERATION;
        } else if ("3G".equalsIgnoreCase(f)) {
            this.f = UploadLog.NetworkStatus.THRID_GENERATION;
        } else if ("4G".equalsIgnoreCase(f)) {
            this.f = UploadLog.NetworkStatus.FOUR_GENERATION;
        } else if ("WIFI".equalsIgnoreCase(f)) {
            this.f = UploadLog.NetworkStatus.WIFI;
        }
    }

    private synchronized void v(UploadMode uploadMode) {
        Logger.f("startMode", "mode", uploadMode);
        if (d.a[uploadMode.ordinal()] != 1) {
            w();
        } else {
            x();
        }
    }

    private void w() {
        Logger.f("UploadMgr", "startIntervalMode CurrentUploadInterval", Long.valueOf(this.a));
        f.i().d(new c());
        this.c = hl2.c().d(this.c, this.e, 3000L);
    }

    private void x() {
        if (this.d != null) {
            LogStoreMgr.l().o(this.d);
        }
        this.d = new b();
        LogStoreMgr.l().m(this.d);
    }

    public void l() {
        Logger.d();
        hl2.c().f(this.e);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("UploadMgr", "onBackground", Boolean.TRUE);
        l();
        if (UploadMode.INTERVAL == this.b) {
            this.g = true;
            long k2 = k();
            if (this.a != k2) {
                this.a = k2;
                u();
            }
        }
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
        Logger.f("UploadMgr", "onForeground", Boolean.TRUE);
        l();
        if (UploadMode.INTERVAL == this.b) {
            this.g = false;
            long k2 = k();
            if (this.a != k2) {
                this.a = k2;
                u();
            }
        }
    }

    public synchronized void q(Context context) {
        boolean z = !u6.g(context);
        this.g = z;
        Logger.f("UploadMgr", "init mIsAppOnBackground", Boolean.valueOf(z));
        u();
    }

    public void t(UploadMode uploadMode) {
        if (uploadMode == null || this.b == uploadMode) {
            return;
        }
        this.b = uploadMode;
        u();
    }

    public synchronized void u() {
        Logger.q();
        s();
        UploadQueueMgr.getInstance().start();
        e.h().c(this.f);
        e.h().d(new a());
        if (this.b == null) {
            this.b = UploadMode.INTERVAL;
        }
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        v(this.b);
    }
}
