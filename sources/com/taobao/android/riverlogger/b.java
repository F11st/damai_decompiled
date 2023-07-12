package com.taobao.android.riverlogger;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class b implements RVLLogInterface {
    public static final b instance = new b();
    private RVLLevel a = RVLLevel.Info;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RVLLevel.values().length];
            a = iArr;
            try {
                iArr[RVLLevel.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RVLLevel.Warn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RVLLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RVLLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public void log(c cVar) {
        int i = a.a[cVar.a.ordinal()];
        if (i == 1) {
            Log.e(cVar.b, cVar.a());
        } else if (i == 2) {
            Log.w(cVar.b, cVar.a());
        } else if (i == 3) {
            Log.i(cVar.b, cVar.a());
        } else if (i != 4) {
            Log.v(cVar.b, cVar.a());
        } else {
            Log.d(cVar.b, cVar.a());
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        return this.a;
    }
}
