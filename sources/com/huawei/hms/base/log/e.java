package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e implements b {
    public b a;

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.a = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
