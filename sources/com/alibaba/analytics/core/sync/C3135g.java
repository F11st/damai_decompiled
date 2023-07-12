package com.alibaba.analytics.core.sync;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.C3109b;
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
/* renamed from: com.alibaba.analytics.core.sync.g */
/* loaded from: classes5.dex */
public class C3135g implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    static C3135g k = new C3135g();
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
    /* renamed from: com.alibaba.analytics.core.sync.g$a */
    /* loaded from: classes5.dex */
    public class C3136a implements IUploadExcuted {
        C3136a() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            C3133e.h().c(C3135g.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.sync.g$b */
    /* loaded from: classes5.dex */
    public class C3137b implements ILogChangeListener {
        C3137b() {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onDelete(long j, long j2) {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onInsert(long j, long j2) {
            if (C3109b.a()) {
                synchronized (C3135g.this.h) {
                    if (C3135g.this.d != null) {
                        LogStoreMgr.l().o(C3135g.this.d);
                    }
                    Variables.n().p0();
                }
                return;
            }
            Logger.f("RealTimeMode", AdUtConstants.XAD_UT_ARG_COUNT, Long.valueOf(j), "dbSize", Long.valueOf(j2));
            if (j <= 0 || j2 <= 0 || UploadMode.REALTIME != C3135g.this.b) {
                return;
            }
            C3135g.this.c = hl2.c().d(null, C3135g.this.e, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.sync.g$c */
    /* loaded from: classes5.dex */
    public class C3138c implements IUploadExcuted {
        C3138c() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            C3135g c3135g = C3135g.this;
            c3135g.a = c3135g.k();
            Logger.f("UploadMgr", "CurrentUploadInterval", Long.valueOf(C3135g.this.a));
            C3134f.i().c(C3135g.this.f);
            C3135g.this.c = hl2.c().d(C3135g.this.c, C3135g.this.e, C3135g.this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.sync.g$d */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C3139d {
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

    private C3135g() {
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

    public static C3135g p() {
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
        if (C3139d.a[uploadMode.ordinal()] != 1) {
            w();
        } else {
            x();
        }
    }

    private void w() {
        Logger.f("UploadMgr", "startIntervalMode CurrentUploadInterval", Long.valueOf(this.a));
        C3134f.i().d(new C3138c());
        this.c = hl2.c().d(this.c, this.e, 3000L);
    }

    private void x() {
        if (this.d != null) {
            LogStoreMgr.l().o(this.d);
        }
        this.d = new C3137b();
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
        C3133e.h().c(this.f);
        C3133e.h().d(new C3136a());
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
