package com.taobao.updatecenter.hotpatch;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.downloader.request.DownloadListener;
import tb.jq1;
import tb.ku2;
import tb.lu2;
import tb.pz0;
import tb.rz0;
import tb.vq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HotPatchDownloaderListener implements DownloadListener {
    private vq1 a;
    private Context b;
    private String c;
    private boolean d;

    public HotPatchDownloaderListener(vq1 vq1Var, Context context, String str, boolean z) {
        this.a = vq1Var;
        this.b = context;
        this.c = str;
        this.d = z;
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadError(String str, int i, String str2) {
        ku2.a(pz0.ANDFIX_DOWNLOAD, this.a.f + "", i + "", str2);
        rz0.d(false, "download", i + "", str2, HotPatchManager.getInstance().getMainVersion(), this.a.f + "", "");
        pz0.b(false, pz0.ANDFIX_DOWNLOAD, i + "", str2, HotPatchManager.getInstance().getMainVersion(), this.a.f + "", str);
        if (this.c.equalsIgnoreCase("SafeMode")) {
            Intent intent = new Intent(lu2.UPDATE_ACTION);
            intent.putExtra("updateType", "hotpatch");
            intent.putExtra("success", false);
            intent.putExtra("errorMsg", str2);
            LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
        }
    }

    @Override // com.taobao.downloader.request.DownloadListener
    public void onDownloadFinish(String str, final String str2) {
        ku2.b(pz0.ANDFIX_DOWNLOAD, this.a.f + "");
        String mainVersion = HotPatchManager.getInstance().getMainVersion();
        pz0.b(true, pz0.ANDFIX_DOWNLOAD, "0", "", mainVersion, this.a.f + "", str);
        String mainVersion2 = HotPatchManager.getInstance().getMainVersion();
        rz0.d(true, "download", "0", "", mainVersion2, this.a.f + "", "");
        if (this.d) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.updatecenter.hotpatch.HotPatchDownloaderListener.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(HotPatchDownloaderListener.this.b, "Patch 包下载完毕，准备加载！", 1).show();
                }
            });
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            new Thread() { // from class: com.taobao.updatecenter.hotpatch.HotPatchDownloaderListener.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    HotPatchManager.getInstance().loadDownloadedPatch(str2, HotPatchDownloaderListener.this.a);
                    if (HotPatchDownloaderListener.this.c.equalsIgnoreCase("SafeMode")) {
                        Intent intent = new Intent(lu2.UPDATE_ACTION);
                        intent.putExtra("updateType", "hotpatch");
                        intent.putExtra("success", true);
                        intent.putExtra("errorMsg", "");
                        LocalBroadcastManager.getInstance(HotPatchDownloaderListener.this.b).sendBroadcast(intent);
                    }
                }
            }.start();
            return;
        }
        HotPatchManager.getInstance().loadDownloadedPatch(str2, this.a);
        if (this.c.equalsIgnoreCase("SafeMode")) {
            Intent intent = new Intent(lu2.UPDATE_ACTION);
            intent.putExtra("updateType", "hotpatch");
            intent.putExtra("success", true);
            intent.putExtra("errorMsg", "");
            LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
        }
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
