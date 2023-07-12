package com.alibaba.poplayer.layermanager.view.app;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppLayerNotify {
    public static final String TAG = "AppLayerNotify";
    private HandlerC3672b a = new HandlerC3672b();
    private Application b;
    private ActivityManager c;
    private AppBackgroundNotify d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface AppBackgroundNotify {
        void onKeepInBackground();

        void onQuicklyIntoBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.view.app.AppLayerNotify$b */
    /* loaded from: classes8.dex */
    public final class HandlerC3672b extends Handler {
        private HandlerC3672b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                AppLayerNotify.this.b();
            } else if (i != 10) {
            } else {
                AppLayerNotify.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppLayerNotify(Application application, AppBackgroundNotify appBackgroundNotify) {
        this.b = application;
        this.d = appBackgroundNotify;
        this.c = (ActivityManager) application.getSystemService("activity");
    }

    void a() {
        if (c() && d()) {
            this.d.onKeepInBackground();
        } else {
            this.a.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    void b() {
        this.d.onQuicklyIntoBackground();
        this.a.removeMessages(10);
        this.a.sendEmptyMessageDelayed(10, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    boolean c() {
        int i;
        String packageName = this.b.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.c.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && ((i = runningAppProcessInfo.importance) == 100 || i == 200)) {
                return true;
            }
        }
        return false;
    }

    boolean d() {
        List<ActivityManager.RunningTaskInfo> runningTasks = this.c.getRunningTasks(1);
        return (runningTasks.isEmpty() || runningTasks.get(0).topActivity.getPackageName().equals(this.b.getPackageName())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.a.sendEmptyMessageDelayed(1, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.a.removeCallbacksAndMessages(null);
    }
}
