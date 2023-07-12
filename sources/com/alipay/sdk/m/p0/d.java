package com.alipay.sdk.m.p0;

import android.database.ContentObserver;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class d extends ContentObserver {
    public static final String d = "VMS_IDLG_SDK_Observer";
    public String a;
    public int b;
    public c c;

    public d(c cVar, int i, String str) {
        super(null);
        this.c = cVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this.b, this.a);
        } else {
            Log.e(d, "mIdentifierIdClient is null");
        }
    }
}
