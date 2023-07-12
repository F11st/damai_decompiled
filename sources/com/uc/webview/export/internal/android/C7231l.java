package com.uc.webview.export.internal.android;

import android.content.Intent;
import android.os.Build;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.internal.utility.C7349p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.l */
/* loaded from: classes11.dex */
public final class C7231l extends WebChromeClient.FileChooserParams {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ C7225i c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7231l(C7225i c7225i, String str, String str2) {
        this.c = c7225i;
        this.a = str;
        this.b = str2;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final Intent createIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (Build.VERSION.SDK_INT >= 16) {
            intent.setTypeAndNormalize(getAcceptTypes()[0]);
        } else {
            intent.setType(getAcceptTypes()[0]);
        }
        return intent;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final String[] getAcceptTypes() {
        String[] strArr = new String[1];
        strArr[0] = C7349p.a(this.a) ? "*/*" : this.a;
        return strArr;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final String getFilenameHint() {
        return "";
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final int getMode() {
        return 0;
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final CharSequence getTitle() {
        return "";
    }

    @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
    public final boolean isCaptureEnabled() {
        return !C7349p.a(this.b);
    }
}
