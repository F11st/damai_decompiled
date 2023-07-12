package com.taobao.android.sopatch.download;

import com.taobao.android.sopatch.download.FileDownloader;
import com.taobao.downloader.request.DownloadListener;
import java.io.File;
import tb.jq1;
import tb.l41;
import tb.ob1;
import tb.qc0;
import tb.sc0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements FileDownloader {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sopatch.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0302a implements DownloadListener {
        final /* synthetic */ FileDownloader.Callback a;

        C0302a(a aVar, FileDownloader.Callback callback) {
            this.a = callback;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            ob1.d(str, str2);
            this.a.onFail();
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            ob1.d(str, "succ");
            this.a.onSuccess();
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }
    }

    @Override // com.taobao.android.sopatch.download.FileDownloader
    public void download(String str, File file, FileDownloader.Callback callback) {
        qc0 qc0Var = new qc0();
        l41 l41Var = new l41();
        l41Var.a = str;
        l41Var.d = file.getName();
        qc0Var.a.add(l41Var);
        jq1 jq1Var = qc0Var.b;
        jq1Var.a = "soLoader";
        jq1Var.f = file.getParent();
        qc0Var.b.m = false;
        sc0.c().b(qc0Var, new C0302a(this, callback));
    }
}
