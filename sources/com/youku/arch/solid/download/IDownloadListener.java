package com.youku.arch.solid.download;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDownloadListener {
    void onError();

    void onLibError(DownloadItem downloadItem, String str);

    void onLibStart(DownloadItem downloadItem);

    void onLibSuccess(DownloadItem downloadItem, String str, long j);

    void onSuccess(long j);
}
