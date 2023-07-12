package tb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.history.ApkUpdateHistory;
import com.taobao.update.framework.Processor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;
import com.taobao.update.provider.UpdateProvider;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class j6 implements Processor<ApkUpdateContext> {
    private i6 a = new i6();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements UserAction {
        final /* synthetic */ ApkUpdateContext a;
        final /* synthetic */ CountDownLatch b;

        /* compiled from: Taobao */
        /* renamed from: tb.j6$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0457a implements UserAction {
            C0457a() {
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getCancelText() {
                return "退出";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getConfirmText() {
                return "立即安装";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getTitleText() {
                return "提醒";
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onCancel() {
                j6.this.a.commitNotify(a.this.a, "ForceInstallClickCancel", Boolean.TRUE, null);
                a aVar = a.this;
                ApkUpdateContext apkUpdateContext = aVar.a;
                apkUpdateContext.errorCode = -51;
                j6.this.d(apkUpdateContext);
                a.this.b.countDown();
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onConfirm() {
                j6.this.a.commitNotify(a.this.a, "ForceInstallClickConfirm", Boolean.TRUE, null);
                a aVar = a.this;
                j6.this.e(aVar.a);
                a.this.b.countDown();
            }
        }

        a(ApkUpdateContext apkUpdateContext, CountDownLatch countDownLatch) {
            this.a = apkUpdateContext;
            this.b = countDownLatch;
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getCancelText() {
            return "取消";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getConfirmText() {
            return "立即安装";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getTitleText() {
            return "安装";
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onCancel() {
            if (this.a.isForceUpdate()) {
                j6.this.a.commitNotify(this.a, "installCancel", Boolean.TRUE, "ForceInstall");
                UpdateRuntime.doUIAlertForConfirm(pu2.getAppNameString(R$string.confirm_forceupdate_install, UpdateRuntime.sAppName), new C0457a());
                return;
            }
            j6.this.a.commitNotify(this.a, "installCancel", Boolean.TRUE, null);
            ApkUpdateContext apkUpdateContext = this.a;
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = -51;
            this.b.countDown();
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onConfirm() {
            j6.this.a.commitNotify(this.a, "installConfirm", Boolean.TRUE, null);
            j6.this.e(this.a);
            this.b.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ApkUpdateContext apkUpdateContext) {
        apkUpdateContext.success = false;
        apkUpdateContext.errorCode = -51;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ApkUpdateContext apkUpdateContext) {
        ApkUpdateHistory.Data data = new ApkUpdateHistory.Data();
        data.fromVersion = pu2.getVersionName();
        data.toVersion = apkUpdateContext.mainUpdate.version;
        data.ext = apkUpdateContext.apkPath;
        ApkUpdateHistory.update(data);
        File file = new File(apkUpdateContext.apkPath);
        if (file.exists()) {
            String path = file.getPath();
            int indexOf = path.indexOf("apkupdate");
            if (indexOf > -1) {
                path = path.substring(0, indexOf + 9);
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod -R 775 " + path);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            Log.i("ApkInstallProcess", "no exists doInstall apkPath=" + apkUpdateContext.apkPath);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = UpdateProvider.getUriForFile(apkUpdateContext.context, new File(apkUpdateContext.apkPath));
            intent.addFlags(1);
            for (ResolveInfo resolveInfo : apkUpdateContext.context.getPackageManager().queryIntentActivities(intent, 65536)) {
                apkUpdateContext.context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
            }
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            if (Build.VERSION.SDK_INT >= 26 && !apkUpdateContext.context.getPackageManager().canRequestPackageInstalls()) {
                try {
                    f(apkUpdateContext.context);
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        } else {
            intent.setDataAndType(Uri.fromFile(new File(apkUpdateContext.apkPath)), "application/vnd.android.package-archive");
        }
        apkUpdateContext.context.startActivity(intent);
    }

    private void f(Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.taobao.update.framework.Processor
    public void execute(ApkUpdateContext apkUpdateContext) {
        if (UpdateRuntime.forceInstallAfaterDownload) {
            this.a.commitNotify(apkUpdateContext, "install", Boolean.TRUE, "forceInstall");
            e(apkUpdateContext);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        UpdateRuntime.doUIAlertForConfirm(apkUpdateContext.hasNotified ? pu2.getAppNameString(R$string.update_notification_finish, UpdateRuntime.sAppName) : pu2.getAppNameString(R$string.confirm_install_hint1, UpdateRuntime.sAppName), new a(apkUpdateContext, countDownLatch));
        this.a.commitNotify(apkUpdateContext, "popInstall", Boolean.TRUE, null);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            this.a.commitNotify(apkUpdateContext, "popInstall", Boolean.FALSE, "popInstall failure");
            e.printStackTrace();
        }
    }
}
