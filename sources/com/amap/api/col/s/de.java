package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class de extends cz {
    private static de f;
    private Handler g;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private de() {
        try {
            if (Looper.myLooper() == null) {
                this.g = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.g = new a();
            }
        } catch (Throwable th) {
            cl.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static dg a(df dfVar, df.b bVar, int i) throws bj {
        try {
            cz.d(dfVar);
            dfVar.a(bVar);
            dfVar.c(i);
            return new dc().a(dfVar);
        } catch (bj e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bj(AMapException.ERROR_UNKNOWN);
        }
    }

    public static de b() {
        return c();
    }

    private static synchronized de c() {
        de deVar;
        synchronized (de.class) {
            try {
                if (f == null) {
                    f = new de();
                }
                deVar = f;
            }
        }
        return deVar;
    }

    @Deprecated
    private static dg d(df dfVar, boolean z) throws bj {
        byte[] bArr;
        cz.d(dfVar);
        dfVar.a(z ? df.c.HTTPS : df.c.HTTP);
        dg dgVar = null;
        long j = 0;
        boolean z2 = false;
        if (cz.b(dfVar)) {
            boolean c = cz.c(dfVar);
            try {
                j = SystemClock.elapsedRealtime();
                dgVar = a(dfVar, cz.a(dfVar, c), cz.c(dfVar, c));
            } catch (bj e) {
                if (e.f() == 21 && dfVar.o() == df.a.INTERRUPT_IO) {
                    throw e;
                }
                if (!c) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (dgVar == null || (bArr = dgVar.a) == null || bArr.length <= 0) {
            try {
                return a(dfVar, cz.b(dfVar, z2), cz.a(dfVar, j));
            } catch (bj e2) {
                throw e2;
            }
        }
        return dgVar;
    }

    public static dg e(df dfVar) throws bj {
        return d(dfVar, dfVar.r());
    }
}
