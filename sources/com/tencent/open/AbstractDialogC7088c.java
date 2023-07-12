package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.c */
/* loaded from: classes11.dex */
public abstract class AbstractDialogC7088c extends Dialog {
    protected C7077b a;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient b;

    public AbstractDialogC7088c(Context context, int i) {
        super(context, i);
        this.b = new WebChromeClient() { // from class: com.tencent.open.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT > 7) {
                    AbstractDialogC7088c.this.a(consoleMessage.message());
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i2 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    AbstractDialogC7088c.this.a(str);
                }
            }
        };
    }

    protected abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new C7077b();
    }
}
