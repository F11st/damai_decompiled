package com.taobao.downloader.wrapper;

import com.taobao.downloader.request.DownloadListener;
import com.taobao.downloader.request.task.TaskListener;
import com.taobao.downloader.util.ThreadUtil;
import tb.id2;
import tb.jq1;
import tb.l41;
import tb.qc0;
import tb.xf;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ListenerWrapper implements TaskListener {
    private qc0 a;
    private DownloadListener b;
    private long c;
    private long d;
    private String e;
    private xf f;

    public ListenerWrapper(qc0 qc0Var, DownloadListener downloadListener) {
        this.a = qc0Var;
        this.b = downloadListener;
        String str = qc0Var.b.a;
        this.e = str;
        this.f = new xf(str, qc0Var, downloadListener);
    }

    private long b() {
        long j = this.c;
        if (0 != j) {
            return j;
        }
        long j2 = 0;
        for (l41 l41Var : this.a.a) {
            long j3 = l41Var.b;
            if (j3 <= 0) {
                return 0L;
            }
            j2 += j3;
        }
        this.c = j2;
        return j2;
    }

    @Override // com.taobao.downloader.request.task.TaskListener
    public void onDownloadStateChange(String str, boolean z) {
        this.b.onDownloadStateChange(str, z);
    }

    @Override // com.taobao.downloader.request.task.TaskListener
    public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        this.b.onNetworkLimit(i, jq1Var, networkLimitCallback);
    }

    @Override // com.taobao.downloader.download.IListener
    public synchronized void onProgress(long j) {
        b();
        long j2 = this.c;
        if (0 == j2) {
            return;
        }
        DownloadListener downloadListener = this.b;
        if (downloadListener != null) {
            int i = (int) (((this.d + j) * 100) / j2);
            if (i > 100) {
                i = 100;
            }
            downloadListener.onDownloadProgress(i);
        }
    }

    @Override // com.taobao.downloader.download.IListener
    public synchronized void onResult(final id2 id2Var) {
        this.d += id2Var.e.b;
        if (this.b == null) {
            return;
        }
        ThreadUtil.a(new Runnable() { // from class: com.taobao.downloader.wrapper.ListenerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                ListenerWrapper.this.f.a(id2Var);
            }
        }, true);
    }
}
