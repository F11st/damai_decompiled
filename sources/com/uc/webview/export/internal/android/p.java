package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebSettings;
import com.uc.webview.export.WebSettings;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class p extends WebSettings {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(android.webkit.WebSettings webSettings) {
        this.mSettings = webSettings;
    }

    @Override // com.uc.webview.export.WebSettings
    @TargetApi(14)
    public final synchronized int getTextZoom() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.mSettings.getTextZoom();
        } else if (this.mSettings.getTextSize() == WebSettings.TextSize.SMALLEST) {
            return WebSettings.TextSize.SMALLEST.value;
        } else if (this.mSettings.getTextSize() == WebSettings.TextSize.SMALLER) {
            return WebSettings.TextSize.SMALLER.value;
        } else if (this.mSettings.getTextSize() == WebSettings.TextSize.LARGER) {
            return WebSettings.TextSize.LARGER.value;
        } else if (this.mSettings.getTextSize() == WebSettings.TextSize.LARGEST) {
            return WebSettings.TextSize.LARGEST.value;
        } else {
            return WebSettings.TextSize.NORMAL.value;
        }
    }

    @Override // com.uc.webview.export.WebSettings
    @TargetApi(14)
    public final synchronized void setTextZoom(int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.mSettings.setTextZoom(i);
            return;
        }
        if (i == 50) {
            this.mSettings.setTextSize(WebSettings.TextSize.SMALLEST);
        } else if (i == 75) {
            this.mSettings.setTextSize(WebSettings.TextSize.SMALLER);
        } else if (i == 150) {
            this.mSettings.setTextSize(WebSettings.TextSize.LARGER);
        } else if (i == 200) {
            this.mSettings.setTextSize(WebSettings.TextSize.LARGEST);
        }
        this.mSettings.setTextSize(WebSettings.TextSize.NORMAL);
    }
}
