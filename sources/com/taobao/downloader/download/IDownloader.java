package com.taobao.downloader.download;

import tb.id2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IDownloader {
    void cancel();

    void download(id2 id2Var, IListener iListener);

    void pause();
}
