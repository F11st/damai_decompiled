package com.taobao.android.riverlogger;

import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.riverlogger.d */
/* loaded from: classes11.dex */
class C6573d implements RVLLogInterface {
    public final boolean a = true;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.riverlogger.d$a */
    /* loaded from: classes12.dex */
    static /* synthetic */ class C6574a {
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
        int i = C6574a.a[c6572c.a.ordinal()];
        if (i == 1) {
            String str = c6572c.b;
            TLog.loge(str, str, c6572c.a());
        } else if (i == 2) {
            String str2 = c6572c.b;
            TLog.logw(str2, str2, c6572c.a());
        } else if (i == 3) {
            String str3 = c6572c.b;
            TLog.logi(str3, str3, c6572c.a());
        } else if (i != 4) {
            String str4 = c6572c.b;
            TLog.logv(str4, str4, c6572c.a());
        } else {
            String str5 = c6572c.b;
            TLog.logd(str5, str5, c6572c.a());
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        return RVLLevel.Verbose;
    }
}
