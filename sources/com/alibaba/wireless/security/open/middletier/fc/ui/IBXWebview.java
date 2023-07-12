package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IBXWebview {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface IBXDownloadService {
        long startDownload(String str, String str2);
    }

    void bxDestroy();

    void bxLoadUrl(String str);

    void bxSetUp(Context context, IUrlVerifyCallback iUrlVerifyCallback, IBXDownloadService iBXDownloadService);
}
