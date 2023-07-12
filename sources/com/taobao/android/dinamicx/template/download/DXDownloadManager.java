package com.taobao.android.dinamicx.template.download;

import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.thread.DXDownLoadRunnable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import tb.dz;
import tb.e01;
import tb.nz;
import tb.r10;
import tb.t00;
import tb.wt;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXDownloadManager {
    private IDXDownloader a;
    private WeakReference<DXNotificationCenter> b;
    private Map<String, DXTemplateItem> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IDXDownloadCallback {
        void onFailed(t00<DXTemplateItem> t00Var);

        void onFinished(DXTemplateItem dXTemplateItem);
    }

    public DXDownloadManager(IDXDownloader iDXDownloader, DXNotificationCenter dXNotificationCenter, Map<String, DXTemplateItem> map) {
        if (iDXDownloader == null) {
            this.a = new e01();
        } else {
            this.a = iDXDownloader;
        }
        this.b = new WeakReference<>(dXNotificationCenter);
        this.c = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f(String str, DXTemplateItem dXTemplateItem, IDXUnzipCallback iDXUnzipCallback, IDXDownloadCallback iDXDownloadCallback) {
        byte[] download;
        t00<DXTemplateItem> t00Var = new t00<>();
        C6368e c6368e = new C6368e(str);
        IDXDownloader iDXDownloader = this.a;
        if (iDXDownloader instanceof e01) {
            download = ((e01) iDXDownloader).a(dXTemplateItem.templateUrl, str, dXTemplateItem);
        } else {
            download = iDXDownloader.download(dXTemplateItem.templateUrl);
        }
        if (download == null) {
            C6368e.C6369a c6369a = new C6368e.C6369a("Downloader", "Downloader_download", 60000);
            t00Var.a = dXTemplateItem;
            c6368e.b = dXTemplateItem;
            c6368e.c.add(c6369a);
            t00Var.d(c6368e);
            iDXDownloadCallback.onFailed(t00Var);
            return;
        }
        if (C6399b.g(dXTemplateItem, download, dz.c().b() + r10.DIR + str + r10.DIR + dXTemplateItem.name + r10.DIR + dXTemplateItem.version + r10.DIR, iDXUnzipCallback, c6368e)) {
            iDXDownloadCallback.onFinished(dXTemplateItem);
            return;
        }
        t00Var.a = dXTemplateItem;
        t00Var.d(c6368e);
        iDXDownloadCallback.onFailed(t00Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(DXTemplateItem dXTemplateItem) {
        Map<String, DXTemplateItem> map;
        if (dXTemplateItem != null && (map = this.c) != null && !map.isEmpty()) {
            for (Map.Entry<String, DXTemplateItem> entry : this.c.entrySet()) {
                if (dXTemplateItem.getIdentifier().equals(entry.getKey())) {
                    this.c.remove(entry.getKey());
                    if (DinamicXEngine.x()) {
                        nz.b("DXDownloadManager", dXTemplateItem.getIdentifier() + " 已在下载完成，从队列移除 " + this.c.size());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "Downloader", str, dXTemplateItem, DXAppMonitor.g((float) j), j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(C6368e c6368e) {
        DXAppMonitor.n(c6368e);
    }

    public void g(final String str, final List<DXTemplateItem> list, final IDXUnzipCallback iDXUnzipCallback, final boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        DXDownLoadRunnable dXDownLoadRunnable = new DXDownLoadRunnable(0, new Runnable() { // from class: com.taobao.android.dinamicx.template.download.DXDownloadManager.1

            /* compiled from: Taobao */
            /* renamed from: com.taobao.android.dinamicx.template.download.DXDownloadManager$1$a */
            /* loaded from: classes11.dex */
            class C6397a implements IDXDownloadCallback {
                final /* synthetic */ C6398a a;
                final /* synthetic */ long b;

                C6397a(C6398a c6398a, long j) {
                    this.a = c6398a;
                    this.b = j;
                }

                @Override // com.taobao.android.dinamicx.template.download.DXDownloadManager.IDXDownloadCallback
                public void onFailed(t00<DXTemplateItem> t00Var) {
                    if (wt.i0()) {
                        DXDownloadManager.this.h(t00Var.a);
                    }
                    C6398a c6398a = this.a;
                    c6398a.b = false;
                    c6398a.a = t00Var.a;
                    DXNotificationCenter dXNotificationCenter = (DXNotificationCenter) DXDownloadManager.this.b.get();
                    if (dXNotificationCenter != null && z) {
                        dXNotificationCenter.d(this.a);
                    }
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    DXDownloadManager.this.i("Downloader_download", str, this.a.a, System.nanoTime() - this.b);
                    DXDownloadManager.this.j(t00Var.a());
                }

                @Override // com.taobao.android.dinamicx.template.download.DXDownloadManager.IDXDownloadCallback
                public void onFinished(DXTemplateItem dXTemplateItem) {
                    if (wt.i0()) {
                        DXDownloadManager.this.h(dXTemplateItem);
                    }
                    C6398a c6398a = this.a;
                    c6398a.b = true;
                    c6398a.a = dXTemplateItem;
                    DXNotificationCenter dXNotificationCenter = (DXNotificationCenter) DXDownloadManager.this.b.get();
                    if (dXNotificationCenter != null && z) {
                        dXNotificationCenter.d(this.a);
                    }
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    DXDownloadManager.this.i("Downloader_download", str, dXTemplateItem, System.nanoTime() - this.b);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                for (DXTemplateItem dXTemplateItem : list) {
                    long nanoTime = System.nanoTime();
                    C6398a c6398a = new C6398a();
                    DXDownloadManager.this.f(str, dXTemplateItem, iDXUnzipCallback, new C6397a(c6398a, nanoTime));
                }
            }
        });
        if (z) {
            y00.f(dXDownLoadRunnable);
        } else {
            dXDownLoadRunnable.run();
        }
    }
}
