package com.alipay.sdk.m.p0;

import android.database.ContentObserver;
import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.p0.d */
/* loaded from: classes12.dex */
public class C4276d extends ContentObserver {
    public static final String d = "VMS_IDLG_SDK_Observer";
    public String a;
    public int b;
    public C4274c c;

    public C4276d(C4274c c4274c, int i, String str) {
        super(null);
        this.c = c4274c;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4274c c4274c = this.c;
        if (c4274c != null) {
            c4274c.a(this.b, this.a);
        } else {
            Log.e(d, "mIdentifierIdClient is null");
        }
    }
}
