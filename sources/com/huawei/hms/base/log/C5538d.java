package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.base.log.d */
/* loaded from: classes10.dex */
public class C5538d implements InterfaceC5536b {
    public final HMSExtLogger a;
    public InterfaceC5536b b;

    public C5538d(HMSExtLogger hMSExtLogger) {
        this.a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(Context context, String str) {
        InterfaceC5536b interfaceC5536b = this.b;
        if (interfaceC5536b != null) {
            interfaceC5536b.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(InterfaceC5536b interfaceC5536b) {
        this.b = interfaceC5536b;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(String str, int i, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.a;
        if (hMSExtLogger != null) {
            if (i == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        InterfaceC5536b interfaceC5536b = this.b;
        if (interfaceC5536b != null) {
            interfaceC5536b.a(str, i, str2, str3);
        }
    }
}
