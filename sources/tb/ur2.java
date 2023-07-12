package tb;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.taobao.tao.update.common.R$string;
import com.taobao.update.adapter.UINotify;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.provider.UpdateProvider;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ur2 implements UINotify {
    private a a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private int a = 34858;
        private String b = "update_channel_" + this.a;
        private NotificationManager c;
        private Context d;
        private Notification.Builder e;

        public a(Context context) {
            this.d = context;
            this.c = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                this.c.createNotificationChannel(new NotificationChannel(this.b, "更新部署", 2));
            }
            this.e = new Notification.Builder(UpdateRuntime.getContext());
        }

        public void error(String str) {
            if (pu2.isNotificationPermissioned()) {
                this.e.setContentText(pu2.getAppNameString(R$string.update_notification_fail, UpdateRuntime.sAppName)).setProgress(0, 0, false).setSmallIcon(UpdateRuntime.sLogoResourceId);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.e.setChannelId(this.b);
                }
                this.c.notify(this.a, this.e.build());
            }
        }

        public void finish(String str) {
            if (pu2.isNotificationPermissioned()) {
                this.e.setContentTitle("点击安装").setContentText(pu2.getAppNameString(R$string.update_notification_finish, UpdateRuntime.sAppName)).setSmallIcon(UpdateRuntime.sLogoResourceId);
                this.e.setProgress(0, 0, false);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(268435456);
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        Uri uriForFile = UpdateProvider.getUriForFile(this.d, new File(str));
                        intent.addFlags(1);
                        for (ResolveInfo resolveInfo : this.d.getPackageManager().queryIntentActivities(intent, 65536)) {
                            this.d.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
                        }
                        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                } else {
                    intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                }
                this.e.setContentIntent(PendingIntent.getActivity(this.d, 0, intent, 134217728));
                if (Build.VERSION.SDK_INT >= 26) {
                    this.e.setChannelId(this.b);
                }
                this.c.notify(this.a, this.e.build());
            }
        }

        public void updateProgress(int i) {
            if (pu2.isNotificationPermissioned()) {
                Notification.Builder contentTitle = this.e.setContentTitle("更新包下载中...");
                contentTitle.setContentText(pu2.getAppNameString(R$string.update_notification_downloading, UpdateRuntime.sAppName) + i + "%").setSmallIcon(UpdateRuntime.sLogoResourceId);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.e.setChannelId(this.b);
                }
                this.e.setProgress(100, i, false);
                this.c.notify(this.a, this.e.build());
                if (i == 100) {
                    this.c.cancel(this.a);
                    this.e.setContentTitle("更新包校验中...").setContentText(pu2.getAppNameString(R$string.update_notification_finish, UpdateRuntime.sAppName)).setSmallIcon(UpdateRuntime.sLogoResourceId);
                    if (i2 >= 26) {
                        this.e.setChannelId(this.b);
                    }
                    this.e.setProgress(0, 0, false);
                    this.c.notify(this.a, this.e.build());
                }
            }
        }
    }

    private void a() {
        this.a = null;
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadError(String str) {
        a();
        new a(UpdateRuntime.getContext()).error(str);
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadFinish(String str) {
        a();
        new a(UpdateRuntime.getContext()).finish(str);
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadProgress(int i) {
        if (this.a == null) {
            this.a = new a(UpdateRuntime.getContext());
        }
        this.a.updateProgress(i);
    }
}
