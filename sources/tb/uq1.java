package tb;

import android.text.TextUtils;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uq1 {
    private e31 a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private class b implements DownloadListener {
        CountDownLatch a;

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            uq1.this.a.success = false;
            uq1.this.a.errorMsg = str2;
            uq1.this.a.errorCode = i;
            CountDownLatch countDownLatch = this.a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            uq1.this.a.path = str2;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            CountDownLatch countDownLatch = this.a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            uq1.this.a.success = z;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }

        private b(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }
    }

    public uq1(e31 e31Var) {
        this.a = e31Var;
    }

    public void download(InstantUpdateInfo instantUpdateInfo) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        qc0 qc0Var = new qc0();
        l41 l41Var = new l41(instantUpdateInfo.patchUrl);
        l41Var.c = instantUpdateInfo.md5;
        l41Var.b = Long.valueOf(instantUpdateInfo.size).longValue();
        jq1 jq1Var = new jq1();
        jq1Var.f = this.a.getPatchPath();
        jq1Var.a = lu2.HOTPATCH;
        jq1Var.b = 10;
        qc0Var.b = jq1Var;
        ArrayList arrayList = new ArrayList();
        qc0Var.a = arrayList;
        arrayList.add(l41Var);
        sc0.c().b(qc0Var, new b(countDownLatch));
        try {
            countDownLatch.await();
            e31 e31Var = this.a;
            if (e31Var.success && !ud1.isMd5Same(instantUpdateInfo.md5, e31Var.path)) {
                e31 e31Var2 = this.a;
                e31Var2.success = false;
                e31Var2.errorMsg = "download fail: md5 mismatch";
            }
        } catch (Throwable th) {
            th.printStackTrace();
            e31 e31Var3 = this.a;
            e31Var3.success = false;
            e31Var3.errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(this.a.path) || !new File(this.a.path).exists()) {
            e31 e31Var4 = this.a;
            e31Var4.success = false;
            e31Var4.errorMsg = "download fail";
        }
    }
}
