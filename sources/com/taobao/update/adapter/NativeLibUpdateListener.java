package com.taobao.update.adapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface NativeLibUpdateListener {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface DownloadListener {
        void onDownloadAllFinish(boolean z);

        void onDownloadError(String str, int i, String str2);

        void onDownloadFinish(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface InstallListener {
        void onInstallFailed(String str, String str2);

        void onInstallSuccess(String str, String str2);
    }

    DownloadListener getDownloadListener();

    InstallListener getInstallListener();
}
