package com.youku.arch.solid.download;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDownloader {
    void download(DownloadTask downloadTask, IDownloadListener iDownloadListener);

    void init();
}
