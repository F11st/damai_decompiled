package com.uc.webview.export;

import android.view.MotionEvent;
import android.view.View;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class c implements View.OnTouchListener {
    final /* synthetic */ View.OnTouchListener a;
    final /* synthetic */ WebView b;
    private View.OnTouchListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WebView webView, View.OnTouchListener onTouchListener) {
        this.b = webView;
        this.a = onTouchListener;
        this.c = onTouchListener;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.c != null) {
            if (i.a().b(UCCore.ENABLE_WEBVIEW_LISTENER_STANDARDIZATION_OPTION)) {
                return this.c.onTouch(this.b, motionEvent);
            }
            return this.c.onTouch(view, motionEvent);
        }
        return false;
    }
}
