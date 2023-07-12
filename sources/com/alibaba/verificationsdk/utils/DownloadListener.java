package com.alibaba.verificationsdk.utils;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface DownloadListener {
    void downloadFinished(File file);

    void downloadStart();
}
