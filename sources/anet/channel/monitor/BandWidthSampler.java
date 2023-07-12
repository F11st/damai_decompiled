package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import tb.ea;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BandWidthSampler {
    private static volatile boolean d = false;
    static int e = 0;
    static long f = 0;
    static long g = 0;
    static long h = 0;
    static long i = 0;
    static long j = 0;
    static double k = 0.0d;
    static double l = 0.0d;
    static double m = 0.0d;
    static double n = 40.0d;
    private int a;
    private int b;
    private C0185a c;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.monitor.BandWidthSampler$a */
    /* loaded from: classes.dex */
    class C0183a implements NetworkStatusHelper.INetworkStatusChangeListener {
        C0183a() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            BandWidthSampler.this.c.a();
            BandWidthSampler.j = 0L;
            BandWidthSampler.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.monitor.BandWidthSampler$b */
    /* loaded from: classes.dex */
    public static class C0184b {
        static BandWidthSampler a = new BandWidthSampler(null);
    }

    /* synthetic */ BandWidthSampler(C0183a c0183a) {
        this();
    }

    static /* synthetic */ int d(BandWidthSampler bandWidthSampler) {
        int i2 = bandWidthSampler.b;
        bandWidthSampler.b = i2 + 1;
        return i2;
    }

    public static BandWidthSampler f() {
        return C0184b.a;
    }

    public double g() {
        return m;
    }

    public int h() {
        if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.a;
    }

    public void i(final long j2, final long j3, final long j4) {
        if (d) {
            if (ALog.g(1)) {
                ALog.c("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= 3000 || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.i(new Runnable() { // from class: anet.channel.monitor.BandWidthSampler.2
                @Override // java.lang.Runnable
                public void run() {
                    BandWidthSampler.e++;
                    BandWidthSampler.i += j4;
                    if (BandWidthSampler.e == 1) {
                        BandWidthSampler.h = j3 - j2;
                    }
                    int i2 = BandWidthSampler.e;
                    if (i2 >= 2 && i2 <= 3) {
                        long j5 = j2;
                        long j6 = BandWidthSampler.g;
                        if (j5 >= j6) {
                            BandWidthSampler.h += j3 - j5;
                        } else if (j5 < j6) {
                            long j7 = j3;
                            if (j7 >= j6) {
                                long j8 = BandWidthSampler.h + (j7 - j5);
                                BandWidthSampler.h = j8;
                                BandWidthSampler.h = j8 - (BandWidthSampler.g - j5);
                            }
                        }
                    }
                    BandWidthSampler.f = j2;
                    BandWidthSampler.g = j3;
                    if (BandWidthSampler.e == 3) {
                        BandWidthSampler.m = (long) BandWidthSampler.this.c.b(BandWidthSampler.i, BandWidthSampler.h);
                        BandWidthSampler.j++;
                        BandWidthSampler.d(BandWidthSampler.this);
                        if (BandWidthSampler.j > 30) {
                            BandWidthSampler.this.c.a();
                            BandWidthSampler.j = 3L;
                        }
                        double d2 = (BandWidthSampler.m * 0.68d) + (BandWidthSampler.l * 0.27d) + (BandWidthSampler.k * 0.05d);
                        BandWidthSampler.k = BandWidthSampler.l;
                        BandWidthSampler.l = BandWidthSampler.m;
                        if (BandWidthSampler.m < BandWidthSampler.k * 0.65d || BandWidthSampler.m > BandWidthSampler.k * 2.0d) {
                            BandWidthSampler.m = d2;
                        }
                        if (ALog.g(1)) {
                            ALog.c("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(BandWidthSampler.i), "mKalmanTimeUsed", Long.valueOf(BandWidthSampler.h), "speed", Double.valueOf(BandWidthSampler.m), "mSpeedKalmanCount", Long.valueOf(BandWidthSampler.j));
                        }
                        if (BandWidthSampler.this.b > 5 || BandWidthSampler.j == 2) {
                            ea.b().c(BandWidthSampler.m);
                            BandWidthSampler.this.b = 0;
                            BandWidthSampler.this.a = BandWidthSampler.m < BandWidthSampler.n ? 1 : 5;
                            ALog.f("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
                        }
                        BandWidthSampler.h = 0L;
                        BandWidthSampler.i = 0L;
                        BandWidthSampler.e = 0;
                    }
                }
            });
        }
    }

    public synchronized void j() {
        try {
            ALog.f("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.i());
        } catch (Exception e2) {
            ALog.j("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.G2) {
            d = false;
        } else {
            d = true;
        }
    }

    public void k() {
        d = false;
    }

    private BandWidthSampler() {
        this.a = 5;
        this.b = 0;
        this.c = new C0185a();
        NetworkStatusHelper.a(new C0183a());
    }
}
