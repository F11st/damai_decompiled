package com.uc.webview.export;

import android.view.View;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b implements View.OnLongClickListener {
    final /* synthetic */ View.OnLongClickListener a;
    final /* synthetic */ WebView b;
    private View.OnLongClickListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WebView webView, View.OnLongClickListener onLongClickListener) {
        this.b = webView;
        this.a = onLongClickListener;
        this.c = onLongClickListener;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.c != null) {
            if (i.a().b(UCCore.ENABLE_WEBVIEW_LISTENER_STANDARDIZATION_OPTION)) {
                return this.c.onLongClick(this.b);
            }
            return this.c.onLongClick(view);
        }
        return false;
    }
}
