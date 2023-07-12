package com.taobao.android.dinamicx.template.download;

import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
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
        e eVar = new e(str);
        IDXDownloader iDXDownloader = this.a;
        if (iDXDownloader instanceof e01) {
            download = ((e01) iDXDownloader).a(dXTemplateItem.templateUrl, str, dXTemplateItem);
        } else {
            download = iDXDownloader.download(dXTemplateItem.templateUrl);
        }
        if (download == null) {
            e.a aVar = new e.a("Downloader", "Downloader_download", 60000);
            t00Var.a = dXTemplateItem;
            eVar.b = dXTemplateItem;
            eVar.c.add(aVar);
            t00Var.d(eVar);
            iDXDownloadCallback.onFailed(t00Var);
            return;
        }
        if (b.g(dXTemplateItem, download, dz.c().b() + r10.DIR + str + r10.DIR + dXTemplateItem.name + r10.DIR + dXTemplateItem.version + r10.DIR, iDXUnzipCallback, eVar)) {
            iDXDownloadCallback.onFinished(dXTemplateItem);
            return;
        }
        t00Var.a = dXTemplateItem;
        t00Var.d(eVar);
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
    public void j(e eVar) {
        DXAppMonitor.n(eVar);
    }

    public void g(final String str, final List<DXTemplateItem> list, final IDXUnzipCallback iDXUnzipCallback, final boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        DXDownLoadRunnable dXDownLoadRunnable = new DXDownLoadRunnable(0, new Runnable() { // from class: com.taobao.android.dinamicx.template.download.DXDownloadManager.1

            /* compiled from: Taobao */
            /* renamed from: com.taobao.android.dinamicx.template.download.DXDownloadManager$1$a */
            /* loaded from: classes11.dex */
            class a implements IDXDownloadCallback {
                final /* synthetic */ com.taobao.android.dinamicx.template.download.a a;
                final /* synthetic */ long b;

                a(com.taobao.android.dinamicx.template.download.a aVar, long j) {
                    this.a = aVar;
                    this.b = j;
                }

                @Override // com.taobao.android.dinamicx.template.download.DXDownloadManager.IDXDownloadCallback
                public void onFailed(t00<DXTemplateItem> t00Var) {
                    if (wt.i0()) {
                        DXDownloadManager.this.h(t00Var.a);
                    }
                    com.taobao.android.dinamicx.template.download.a aVar = this.a;
                    aVar.b = false;
                    aVar.a = t00Var.a;
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
                    com.taobao.android.dinamicx.template.download.a aVar = this.a;
                    aVar.b = true;
                    aVar.a = dXTemplateItem;
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
                    com.taobao.android.dinamicx.template.download.a aVar = new com.taobao.android.dinamicx.template.download.a();
                    DXDownloadManager.this.f(str, dXTemplateItem, iDXUnzipCallback, new a(aVar, nanoTime));
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
