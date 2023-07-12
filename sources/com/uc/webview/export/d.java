package com.uc.webview.export;

import android.view.KeyEvent;
import android.view.View;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class d implements View.OnKeyListener {
    final /* synthetic */ View.OnKeyListener a;
    final /* synthetic */ WebView b;
    private View.OnKeyListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WebView webView, View.OnKeyListener onKeyListener) {
        this.b = webView;
        this.a = onKeyListener;
        this.c = onKeyListener;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.c != null) {
            if (i.a().b(UCCore.ENABLE_WEBVIEW_LISTENER_STANDARDIZATION_OPTION)) {
                return this.c.onKey(this.b, i, keyEvent);
            }
            return this.c.onKey(view, i, keyEvent);
        }
        return false;
    }
}
