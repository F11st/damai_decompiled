package com.taobao.pexode;

import android.graphics.BitmapFactory;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.IncrementalStaging;
import com.taobao.tcommon.core.BytesPool;
import tb.hh0;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements DegradeEventListener {
    public boolean a;
    public boolean b;
    int c;
    int d;
    int e;
    private BytesPool f;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.pexode.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0320a {
        private static final a a = new a();
    }

    private int a(int i, boolean z) {
        return ((i << 1) + (z ? 1 : 0)) & 1023;
    }

    public static boolean b(PexodeOptions pexodeOptions) {
        return pexodeOptions.cancelled;
    }

    private int c(int i) {
        int i2 = (i - ((i >> 1) & (-613566757))) - ((i >> 2) & 1227133513);
        return ((-954437177) & (i2 + (i2 >> 3))) % 63;
    }

    public static IncrementalStaging d(PexodeOptions pexodeOptions) {
        return pexodeOptions.mIncrementalStaging;
    }

    public static int e(PexodeOptions pexodeOptions) {
        return pexodeOptions.lastSampleSize;
    }

    public static a f() {
        return C0320a.a;
    }

    public static boolean i(or1 or1Var, PexodeOptions pexodeOptions) {
        return pexodeOptions.cancelled || j(or1Var, pexodeOptions);
    }

    public static boolean j(or1 or1Var, PexodeOptions pexodeOptions) {
        return (pexodeOptions.justDecodeBounds && pexodeOptions.isSizeAvailable()) || (pexodeOptions.incrementalDecode && pexodeOptions.mIncrementalStaging != null) || !(or1Var == null || (or1Var.a == null && or1Var.b == null));
    }

    public static void l(PexodeOptions pexodeOptions, IncrementalStaging incrementalStaging) {
        pexodeOptions.mIncrementalStaging = incrementalStaging;
    }

    public static void m(PexodeOptions pexodeOptions, int i) {
        pexodeOptions.lastSampleSize = i;
    }

    public static void n(PexodeOptions pexodeOptions, BitmapFactory.Options options) {
        pexodeOptions.setUponSysOptions(options);
    }

    public byte[] g(int i) {
        BytesPool bytesPool = this.f;
        byte[] offer = bytesPool != null ? bytesPool.offer(i) : null;
        return offer == null ? new byte[i] : offer;
    }

    public void h(byte[] bArr) {
        BytesPool bytesPool = this.f;
        if (bytesPool != null) {
            bytesPool.release(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(BytesPool bytesPool) {
        this.f = bytesPool;
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2NoAshmem(boolean z) {
        if (!this.b) {
            int a = a(this.d, z);
            this.d = a;
            if (c(a) >= 8) {
                this.b = true;
                hh0.i(Pexode.TAG, "auto degrading to no ashmem, history=%d", Integer.valueOf(this.d));
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2NoAshmem();
                }
            }
        }
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2NoInBitmap(boolean z) {
        if (!this.a) {
            int a = a(this.c, z);
            this.c = a;
            if (c(a) >= 8) {
                this.a = true;
                hh0.i(Pexode.TAG, "auto degrading to no inBitmap, history=%d", Integer.valueOf(this.c));
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2NoInBitmap();
                }
            }
        }
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2System(boolean z) {
        if (!Pexode.k()) {
            int a = a(this.e, z);
            this.e = a;
            if (c(a) >= 8) {
                Pexode.f(true);
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2System();
                }
            }
        }
    }
}
