package com.uc.webview.export.internal.android;

import android.webkit.DownloadListener;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.a */
/* loaded from: classes11.dex */
public final class C7216a implements DownloadListener {
    private com.uc.webview.export.DownloadListener a;

    public C7216a(com.uc.webview.export.DownloadListener downloadListener) {
        this.a = downloadListener;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        com.uc.webview.export.DownloadListener downloadListener = this.a;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
