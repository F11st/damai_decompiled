package com.taobao.android.riverlogger;

import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class d implements RVLLogInterface {
    public final boolean a = true;

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
            String str = cVar.b;
            TLog.loge(str, str, cVar.a());
        } else if (i == 2) {
            String str2 = cVar.b;
            TLog.logw(str2, str2, cVar.a());
        } else if (i == 3) {
            String str3 = cVar.b;
            TLog.logi(str3, str3, cVar.a());
        } else if (i != 4) {
            String str4 = cVar.b;
            TLog.logv(str4, str4, cVar.a());
        } else {
            String str5 = cVar.b;
            TLog.logd(str5, str5, cVar.a());
        }
    }

    @Override // com.taobao.android.riverlogger.RVLLogInterface
    public RVLLevel logLevel() {
        return RVLLevel.Verbose;
    }
}
