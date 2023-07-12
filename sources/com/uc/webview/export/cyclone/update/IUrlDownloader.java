package com.uc.webview.export.cyclone.update;

import com.uc.webview.export.cyclone.Constant;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public interface IUrlDownloader {

    /* compiled from: Taobao */
    @Constant
    /* loaded from: classes11.dex */
    public interface Client {
        void onFailed(String str, Throwable th);

        void onProgressChanged(int i);

        void onStart();

        void onSuccess(String str, long j, long j2);
    }

    void delete();

    boolean start(String str, String str2, Client client);

    void stop();
}
