package com.youku.live.dago.widgetlib.interactive.resource.resource;

import com.taobao.downloader.request.DownloadListener;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLDownloadListener extends DownloadListener {
    void onProcessFailure(String str, int i, String str2);

    void onProcessSuccess(String str, int i, String str2);
}
