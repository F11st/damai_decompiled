package com.uc.webview.export.internal.android;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Jni;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WebChromeClientCompatibility extends WebChromeClient {
    protected WebView a;
    protected com.uc.webview.export.WebChromeClient b;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.android.WebChromeClientCompatibility$a */
    /* loaded from: classes11.dex */
    class C7214a extends WebChromeClient.FileChooserParams {
        private WebChromeClient.FileChooserParams b;

        C7214a(WebChromeClient.FileChooserParams fileChooserParams) {
            this.b = fileChooserParams;
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final Intent createIntent() {
            return this.b.createIntent();
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final String[] getAcceptTypes() {
            return this.b.getAcceptTypes();
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final String getFilenameHint() {
            return this.b.getFilenameHint();
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final int getMode() {
            return this.b.getMode();
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final CharSequence getTitle() {
            return this.b.getTitle();
        }

        @Override // com.uc.webview.export.WebChromeClient.FileChooserParams
        public final boolean isCaptureEnabled() {
            return this.b.isCaptureEnabled();
        }
    }

    @Override // android.webkit.WebChromeClient
    @Jni
    public boolean onShowFileChooser(android.webkit.WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return this.b.onShowFileChooser(this.a, valueCallback, fileChooserParams == null ? null : new C7214a(fileChooserParams));
    }
}
