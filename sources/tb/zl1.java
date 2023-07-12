package tb;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.framework.Processor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;
import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zl1 implements Processor<ApkUpdateContext> {
    private i6 a = new i6();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.zl1$a */
    /* loaded from: classes11.dex */
    public class C10027a implements UserAction {
        final /* synthetic */ ApkUpdateContext a;
        final /* synthetic */ CountDownLatch b;

        /* compiled from: Taobao */
        /* renamed from: tb.zl1$a$a */
        /* loaded from: classes11.dex */
        class C10028a implements UserAction {
            C10028a() {
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getCancelText() {
                return "退出";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getConfirmText() {
                return "立即下载";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getTitleText() {
                return null;
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onCancel() {
                zl1.this.a.commitNotify(C10027a.this.a, "ForceUpdateClickCancel", Boolean.TRUE, null);
                C10027a c10027a = C10027a.this;
                ApkUpdateContext apkUpdateContext = c10027a.a;
                apkUpdateContext.success = false;
                apkUpdateContext.errorCode = -51;
                c10027a.b.countDown();
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onConfirm() {
                zl1.this.a.commitNotify(C10027a.this.a, "ForceUpdateClickConfirm", Boolean.TRUE, null);
                C10027a.this.b.countDown();
            }
        }

        C10027a(ApkUpdateContext apkUpdateContext, CountDownLatch countDownLatch) {
            this.a = apkUpdateContext;
            this.b = countDownLatch;
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getCancelText() {
            return "取消";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getConfirmText() {
            return "立即下载";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getTitleText() {
            return null;
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onCancel() {
            if (this.a.isForceUpdate()) {
                zl1.this.a.commitNotify(this.a, "clickCancel", Boolean.TRUE, "ForceUpdate");
                UpdateRuntime.doUIAlertForConfirm(pu2.getAppNameString(R$string.confirm_forceupdate_cancel, UpdateRuntime.sAppName), new C10028a());
                return;
            }
            zl1.this.a.commitNotify(this.a, "clickCancel", Boolean.TRUE, null);
            ApkUpdateContext apkUpdateContext = this.a;
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = -51;
            this.b.countDown();
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onConfirm() {
            zl1.this.a.commitNotify(this.a, "clickConfirm", Boolean.TRUE, null);
            this.b.countDown();
        }
    }

    private String b(long j) {
        if (j / 1048576 > 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return "" + decimalFormat.format(((float) j) / 1048576.0f) + "MB";
        }
        long j2 = j / 1024;
        if (j2 > 0) {
            return "" + j2 + "KB";
        }
        return "" + j + "B";
    }

    private boolean c(ApkUpdateContext apkUpdateContext) {
        return !apkUpdateContext.isSilentUpdate();
    }

    @Override // com.taobao.update.framework.Processor
    public void execute(ApkUpdateContext apkUpdateContext) {
        MainUpdateData mainUpdateData = apkUpdateContext.mainUpdate;
        if (mainUpdateData != null && !TextUtils.isEmpty(mainUpdateData.getDownloadUrl())) {
            l41 l41Var = new l41();
            l41Var.a = mainUpdateData.getDownloadUrl();
            l41Var.b = mainUpdateData.size;
            l41Var.c = mainUpdateData.md5;
            String d = sc0.c().d(pu2.getStorePath(apkUpdateContext.context) + "/apkupdate/" + mainUpdateData.version, l41Var);
            if (!TextUtils.isEmpty(d)) {
                Log.d("Updater", "apk has downloaded");
                apkUpdateContext.apkPath = d;
                return;
            } else if (c(apkUpdateContext)) {
                apkUpdateContext.hasNotified = true;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                C10027a c10027a = new C10027a(apkUpdateContext, countDownLatch);
                Log.d("Updater", "start to doUIAlertForConfirm");
                UpdateRuntime.doUIAlertForConfirm(mainUpdateData.info + "\n\n更新包大小：" + b(mainUpdateData.size), c10027a);
                this.a.commitNotify(apkUpdateContext, "popUpdate", Boolean.TRUE, null);
                try {
                    countDownLatch.await();
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.a.commitNotify(apkUpdateContext, "popUpdate", Boolean.FALSE, "popUpdate failure");
                    return;
                }
            } else {
                return;
            }
        }
        apkUpdateContext.success = false;
        apkUpdateContext.errorCode = 31;
        Log.d("Updater", "no update");
    }
}
