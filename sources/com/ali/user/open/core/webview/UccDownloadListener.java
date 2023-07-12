package com.ali.user.open.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccDownloadListener implements DownloadListener {
    private static final Pattern APK_PATTERN = Pattern.compile("\\.apk$", 2);
    private WeakReference<Context> contextWeakReference;

    public UccDownloadListener(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    public static boolean shouldDownload(Context context, String str, String str2, String str3, String str4, long j) {
        if (str == null) {
            return false;
        }
        String path = Uri.parse(str).getPath();
        if ((path == null || !APK_PATTERN.matcher(path).find()) && (str3 == null || !APK_PATTERN.matcher(str3).find())) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.contextWeakReference.get() != null) {
            shouldDownload(this.contextWeakReference.get(), str, str2, str3, str4, j);
        }
    }
}
