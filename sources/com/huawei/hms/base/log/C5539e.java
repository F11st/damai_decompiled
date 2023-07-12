package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.base.log.e */
/* loaded from: classes10.dex */
public class C5539e implements InterfaceC5536b {
    public InterfaceC5536b a;

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(Context context, String str) {
        InterfaceC5536b interfaceC5536b = this.a;
        if (interfaceC5536b != null) {
            interfaceC5536b.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(InterfaceC5536b interfaceC5536b) {
        this.a = interfaceC5536b;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5536b
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        InterfaceC5536b interfaceC5536b = this.a;
        if (interfaceC5536b != null) {
            interfaceC5536b.a(str, i, str2, str3);
        }
    }
}
