package com.taobao.update.apk.processor;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.update.adapter.UINotify;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.framework.Processor;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import org.android.agoo.common.AgooConstants;
import tb.jn1;
import tb.jq1;
import tb.l41;
import tb.pu2;
import tb.qc0;
import tb.sc0;
import tb.wb;
import tb.xc1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApkDownloadProcessor implements Processor<ApkUpdateContext> {
    private UINotify a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.update.apk.processor.ApkDownloadProcessor$a */
    /* loaded from: classes11.dex */
    public class C6916a implements DownloadListener {
        int a = -1;
        final /* synthetic */ boolean b;
        final /* synthetic */ ApkUpdateContext c;
        final /* synthetic */ CountDownLatch d;

        C6916a(boolean z, ApkUpdateContext apkUpdateContext, CountDownLatch countDownLatch) {
            this.b = z;
            this.c = apkUpdateContext;
            this.d = countDownLatch;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            if (this.b) {
                ApkDownloadProcessor.this.e(str2, this.c.isForceUpdate());
            }
            Log.d("ApkDownloadProcessor", "onDownloadError " + i + jn1.G + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            if (this.b) {
                ApkDownloadProcessor.this.f(str2, this.c.isForceUpdate());
            }
            this.c.apkPath = str2;
            Log.d("ApkDownloadProcessor", "onDownloadFinish " + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
            Log.d("ApkDownloadProcessor", "on process " + i);
            if (!this.b || this.a == i) {
                return;
            }
            this.a = i;
            ApkDownloadProcessor.this.g(i, this.c.isForceUpdate());
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            Log.d("ApkDownloadProcessor", "onFinish " + z);
            this.c.success = z;
            this.d.countDown();
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z) {
        xc1.execute(new Runnable() { // from class: com.taobao.update.apk.processor.ApkDownloadProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                ApkDownloadProcessor.this.h(z).notifyDownloadError(TextUtils.isEmpty(str) ? "下载失败" : str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final String str, final boolean z) {
        xc1.execute(new Runnable() { // from class: com.taobao.update.apk.processor.ApkDownloadProcessor.4
            @Override // java.lang.Runnable
            public void run() {
                ApkDownloadProcessor.this.h(z).notifyDownloadFinish(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final int i, boolean z) {
        if (i(z)) {
            xc1.execute(new Runnable() { // from class: com.taobao.update.apk.processor.ApkDownloadProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    ApkDownloadProcessor.this.h(true).notifyDownloadProgress(i);
                }
            });
        } else {
            h(false).notifyDownloadProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UINotify h(boolean z) {
        UINotify uINotify = this.a;
        if (uINotify != null) {
            return uINotify;
        }
        if (z) {
            this.a = (UINotify) wb.getInstance(AgooConstants.MESSAGE_NOTIFICATION, UINotify.class);
        } else {
            this.a = (UINotify) wb.getInstance("sysnotify", UINotify.class);
        }
        return this.a;
    }

    private boolean i(boolean z) {
        return !pu2.isNotificationPermissioned() || z;
    }

    public DownloadListener getListener(CountDownLatch countDownLatch, ApkUpdateContext apkUpdateContext, boolean z) {
        return new C6916a(z, apkUpdateContext, countDownLatch);
    }

    @Override // com.taobao.update.framework.Processor
    public void execute(ApkUpdateContext apkUpdateContext) {
        if (TextUtils.isEmpty(apkUpdateContext.apkPath)) {
            MainUpdateData mainUpdateData = apkUpdateContext.mainUpdate;
            String str = pu2.getStorePath(apkUpdateContext.context) + "/apkupdate/";
            String str2 = str + mainUpdateData.version;
            try {
                Runtime.getRuntime().exec("chmod 775 " + str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Runtime.getRuntime().exec("chmod 775 " + str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            ArrayList arrayList = new ArrayList(1);
            l41 l41Var = new l41();
            arrayList.add(l41Var);
            l41Var.a = mainUpdateData.getDownloadUrl();
            l41Var.b = mainUpdateData.size;
            l41Var.c = mainUpdateData.md5;
            jq1 jq1Var = new jq1();
            qc0 qc0Var = new qc0();
            qc0Var.a = arrayList;
            qc0Var.b = jq1Var;
            jq1Var.c = 7;
            jq1Var.f = str2;
            jq1Var.d = 0;
            jq1Var.a = "apkupdate";
            jq1Var.b = 20;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            sc0.c().b(qc0Var, getListener(countDownLatch, apkUpdateContext, apkUpdateContext.hasNotified));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
