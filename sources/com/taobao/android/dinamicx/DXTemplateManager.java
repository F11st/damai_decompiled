package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXDownloadManager;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.template.download.IDXUnzipCallback;
import com.taobao.android.dinamicx.thread.DXDownLoadRunnable;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.a00;
import tb.dz;
import tb.nz;
import tb.o10;
import tb.p10;
import tb.q10;
import tb.r10;
import tb.s00;
import tb.t20;
import tb.wt;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTemplateManager extends b {
    protected a00 d;
    private DXDownloadManager e;
    private p10 f;
    protected Context g;
    private long h;
    private Map<String, DXTemplateItem> i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class a {
        List<DXTemplateItem> a = new ArrayList();

        a(DXTemplateManager dXTemplateManager) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXTemplateManager(d dVar, final Context context) {
        super(dVar);
        this.g = context;
        this.h = this.a.e();
        this.d = new a00();
        this.f = new p10(this.a.d);
        this.i = new ConcurrentHashMap();
        this.e = new DXDownloadManager(DXGlobalCenter.d, dVar.e().l, this.i);
        y00.p(new Runnable() { // from class: com.taobao.android.dinamicx.DXTemplateManager.1
            @Override // java.lang.Runnable
            public void run() {
                o10.b().c(context, r10.DB_NAME);
            }
        });
        dz.c().d(context);
        l();
    }

    private boolean d(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem.getTemplateType() == 0) {
            return false;
        }
        for (Map.Entry<String, DXTemplateItem> entry : this.i.entrySet()) {
            if (dXTemplateItem.getIdentifier().equals(entry.getKey())) {
                if (DinamicXEngine.x()) {
                    nz.b("DXTemplateManager", dXTemplateItem.getIdentifier() + " 已在下载队列中，无需下载 " + this.i.size());
                }
                return true;
            }
        }
        this.i.put(dXTemplateItem.getIdentifier(), dXTemplateItem);
        return false;
    }

    private a i(List<DXTemplateItem> list) {
        a aVar = new a(this);
        if (list != null && !list.isEmpty()) {
            HashSet<DXTemplateItem> hashSet = new HashSet(list);
            if (hashSet.size() > 0) {
                for (DXTemplateItem dXTemplateItem : hashSet) {
                    if (r10.b(dXTemplateItem) && !k(dXTemplateItem) && (!wt.i0() || !d(dXTemplateItem))) {
                        aVar.a.add(dXTemplateItem);
                    }
                }
            }
        }
        return aVar;
    }

    private void l() {
        if (q10.f().l(this.b)) {
            q10 f = q10.f();
            String str = this.b;
            f.m(str, com.taobao.android.dinamicx.template.download.b.f(str));
        }
    }

    private void n(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "Template", str, dXTemplateItem, DXAppMonitor.g((float) j), j, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(DXTemplateItem dXTemplateItem) {
        this.f.c(this.b, this.h, dXTemplateItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(List<DXTemplateItem> list) {
        this.e.g(this.b, i(list).a, new IDXUnzipCallback() { // from class: com.taobao.android.dinamicx.DXTemplateManager.2
            @Override // com.taobao.android.dinamicx.template.download.IDXUnzipCallback
            public void onUnzipFinished(final DXTemplateItem dXTemplateItem, Map<String, byte[]> map) {
                if (map == null || map.size() <= 0) {
                    return;
                }
                final int size = map.size();
                final AtomicInteger atomicInteger = new AtomicInteger();
                for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                    final String key = entry.getKey();
                    final byte[] value = entry.getValue();
                    dz.c().f(key, value);
                    y00.f(new DXDownLoadRunnable(2, new Runnable() { // from class: com.taobao.android.dinamicx.DXTemplateManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (dz.c().g(key, value) && atomicInteger.incrementAndGet() == size) {
                                o10.b().d(DXTemplateManager.this.b, dXTemplateItem);
                            }
                        }
                    }));
                }
                q10 f = q10.f();
                DXTemplateManager dXTemplateManager = DXTemplateManager.this;
                f.r(dXTemplateManager.b, dXTemplateManager.h, dXTemplateItem);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(List<DXTemplateItem> list, final IDXDownloadCallback iDXDownloadCallback, boolean z) {
        this.e.g(this.b, i(list).a, new IDXUnzipCallback() { // from class: com.taobao.android.dinamicx.DXTemplateManager.3
            @Override // com.taobao.android.dinamicx.template.download.IDXUnzipCallback
            public void onUnzipFinished(final DXTemplateItem dXTemplateItem, Map<String, byte[]> map) {
                if (map == null || map.size() <= 0) {
                    return;
                }
                final int size = map.size();
                final AtomicInteger atomicInteger = new AtomicInteger();
                for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                    final String key = entry.getKey();
                    final byte[] value = entry.getValue();
                    dz.c().f(key, value);
                    y00.f(new DXDownLoadRunnable(2, new Runnable() { // from class: com.taobao.android.dinamicx.DXTemplateManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (dz.c().g(key, value) && atomicInteger.incrementAndGet() == size) {
                                o10.b().d(DXTemplateManager.this.b, dXTemplateItem);
                            }
                        }
                    }));
                }
                q10 f = q10.f();
                DXTemplateManager dXTemplateManager = DXTemplateManager.this;
                f.r(dXTemplateManager.b, dXTemplateManager.h, dXTemplateItem);
                iDXDownloadCallback.callback(dXTemplateItem);
            }
        }, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXTemplateItem h(DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        DXTemplateItem a2 = this.f.a(this.b, this.h, dXTemplateItem);
        n("Template_Fetch", this.b, dXTemplateItem, System.nanoTime() - nanoTime);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized DXWidgetNode j(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null) {
            return null;
        }
        DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(null);
        e eVar = new e(this.a.a);
        cloneWithWidgetNode.dxError = eVar;
        eVar.b = dXRuntimeContext.dxTemplateItem;
        cloneWithWidgetNode.dxUserContext = null;
        DXTemplateItem dXTemplateItem = cloneWithWidgetNode.dxTemplateItem;
        if (k(dXTemplateItem)) {
            DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
            if (dXTemplatePackageInfo == null || TextUtils.isEmpty(dXTemplatePackageInfo.mainFilePath)) {
                dXTemplateItem.packageInfo = q10.f().g(this.b, dXTemplateItem);
            }
            if (dXTemplateItem.packageInfo == null) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline_Render", "Pipeline_Stage_Get_Template_Widget", e.DX_GET_PACKAGEINFO_NULL));
                s00.b("templateItem.packageInfo == null");
                return null;
            }
            DXWidgetNode b = t20.d().b(this.b, dXTemplateItem);
            if (b == null) {
                s00.b(" cache widgetTree == null");
                long nanoTime = System.nanoTime();
                b = this.d.a(dXTemplateItem, cloneWithWidgetNode, this.g);
                if (b == null) {
                    s00.b(" load widgetTree == null");
                    dXRuntimeContext.getDxError().c.add(new e.a("Pipeline_Render", "Pipeline_Stage_Get_Template_Widget", e.DX_LOAD_WT_NULL));
                }
                long nanoTime2 = System.nanoTime() - nanoTime;
                DXAppMonitor.s(3, this.b, "Template", "Pipeline_Stage_Load_Binary", dXTemplateItem, DXAppMonitor.g((float) nanoTime2), nanoTime2, true);
                if (b != null) {
                    b.setStatFlag(1);
                    t20.d().g(this.b, dXTemplateItem, b);
                }
            }
            if (b == null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null && cloneWithWidgetNode.getDxError() != null && cloneWithWidgetNode.getDxError().c != null) {
                dXRuntimeContext.getDxError().c.addAll(cloneWithWidgetNode.getDxError().c);
            }
            return b;
        }
        return null;
    }

    boolean k(DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        boolean k = q10.f().k(this.b, dXTemplateItem);
        n("Template_Exist", this.b, dXTemplateItem, System.nanoTime() - nanoTime);
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i) {
        this.f.b(i);
    }
}
