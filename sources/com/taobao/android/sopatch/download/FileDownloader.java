package com.taobao.android.sopatch.download;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface FileDownloader {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Callback {
        void onFail();

        void onSuccess();
    }

    void download(String str, File file, Callback callback);
}
