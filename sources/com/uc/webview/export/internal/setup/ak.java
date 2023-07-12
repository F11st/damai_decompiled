package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [CALLBACK_TYPE] */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ak<CALLBACK_TYPE> implements ValueCallback<CALLBACK_TYPE> {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Object obj) {
        File file;
        File file2;
        File file3;
        String str = aj.d;
        StringBuilder sb = new StringBuilder(".startCallback MCE(");
        file = this.a.g;
        sb.append(file.exists());
        sb.append(",");
        file2 = this.a.f;
        sb.append(file2.exists());
        sb.append(",");
        file3 = this.a.h;
        sb.append(file3.exists());
        sb.append(jn1.BRACKET_END_STR);
        Log.d(str, sb.toString());
        aj.d(this.a);
        aj.e(this.a);
    }
}
