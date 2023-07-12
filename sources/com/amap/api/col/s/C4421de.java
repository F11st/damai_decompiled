package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.de */
/* loaded from: classes10.dex */
public final class C4421de extends cz {
    private static C4421de f;
    private Handler g;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.de$a */
    /* loaded from: classes10.dex */
    static class HandlerC4422a extends Handler {
        /* synthetic */ HandlerC4422a(Looper looper, byte b) {
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

        private HandlerC4422a(Looper looper) {
            super(looper);
        }

        public HandlerC4422a() {
        }
    }

    private C4421de() {
        try {
            if (Looper.myLooper() == null) {
                this.g = new HandlerC4422a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.g = new HandlerC4422a();
            }
        } catch (Throwable th) {
            cl.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static dg a(df dfVar, df.EnumC4424b enumC4424b, int i) throws bj {
        try {
            cz.d(dfVar);
            dfVar.a(enumC4424b);
            dfVar.c(i);
            return new dc().a(dfVar);
        } catch (bj e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bj(AMapException.ERROR_UNKNOWN);
        }
    }

    public static C4421de b() {
        return c();
    }

    private static synchronized C4421de c() {
        C4421de c4421de;
        synchronized (C4421de.class) {
            try {
                if (f == null) {
                    f = new C4421de();
                }
                c4421de = f;
            }
        }
        return c4421de;
    }

    @Deprecated
    private static dg d(df dfVar, boolean z) throws bj {
        byte[] bArr;
        cz.d(dfVar);
        dfVar.a(z ? df.EnumC4425c.HTTPS : df.EnumC4425c.HTTP);
        dg dgVar = null;
        long j = 0;
        boolean z2 = false;
        if (cz.b(dfVar)) {
            boolean c = cz.c(dfVar);
            try {
                j = SystemClock.elapsedRealtime();
                dgVar = a(dfVar, cz.a(dfVar, c), cz.c(dfVar, c));
            } catch (bj e) {
                if (e.f() == 21 && dfVar.o() == df.EnumC4423a.INTERRUPT_IO) {
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
