package com.taobao.android.riverlogger;

import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.riverlogger.b */
/* loaded from: classes11.dex */
class C6570b implements RVLLogInterface {
    public static final C6570b instance = new C6570b();
    private RVLLevel a = RVLLevel.Info;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.riverlogger.b$a */
    /* loaded from: classes12.dex */
    static /* synthetic */ class C6571a {
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
    public void log(C6572c c6572c) {
        int i = C6571a.a[c6572c.a.ordinal()];
        if (i == 1) {
            Log.e(c6572c.b, c6572c.a());
        } else if (i == 2) {
            Log.w(c6572c.b, c6572c.a());
        } else if (i == 3) {
            Log.i(c6572c.b, c6572c.a());
        } else if (i != 4) {
            Log.v(c6572c.b, c6572c.a());
        } else {
            Log.d(c6572c.b, c6572c.a());
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        return this.a;
    }
}
