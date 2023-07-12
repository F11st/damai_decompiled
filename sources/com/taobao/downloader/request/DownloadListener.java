package com.taobao.downloader.request;

import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DownloadListener {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface NetworkLimitCallback {
        void hasChangeParams(boolean z);
    }

    void onDownloadError(String str, int i, String str2);

    void onDownloadFinish(String str, String str2);

    void onDownloadProgress(int i);

    void onDownloadStateChange(String str, boolean z);

    void onFinish(boolean z);

    void onNetworkLimit(int i, jq1 jq1Var, NetworkLimitCallback networkLimitCallback);
}
