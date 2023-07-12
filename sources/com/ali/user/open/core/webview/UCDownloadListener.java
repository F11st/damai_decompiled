package com.ali.user.open.core.webview;

import android.content.Context;
import com.uc.webview.export.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UCDownloadListener implements DownloadListener {
    private static final Pattern APK_PATTERN = Pattern.compile("\\.apk$", 2);
    private WeakReference<Context> contextWeakReference;

    public UCDownloadListener(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    @Override // com.uc.webview.export.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.contextWeakReference.get() != null) {
            UccDownloadListener.shouldDownload(this.contextWeakReference.get(), str, str2, str3, str4, j);
        }
    }
}
