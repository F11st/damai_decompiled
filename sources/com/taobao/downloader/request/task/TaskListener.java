package com.taobao.downloader.request.task;

import com.taobao.downloader.download.IListener;
import com.taobao.downloader.request.DownloadListener;
import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface TaskListener extends IListener {
    void onDownloadStateChange(String str, boolean z);

    void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback);
}
