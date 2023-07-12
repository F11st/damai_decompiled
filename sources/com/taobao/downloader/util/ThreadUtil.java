package com.taobao.downloader.util;

import android.annotation.TargetApi;
import android.os.Process;
import com.taobao.downloader.adpater.ThreadExecutor;
import java.util.TimerTask;
import tb.um;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ThreadUtil {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.downloader.util.ThreadUtil$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    final class AnonymousClass2 extends TimerTask {
        final /* synthetic */ Runnable val$runnable;

        AnonymousClass2(Runnable runnable) {
            this.val$runnable = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.val$runnable.run();
        }
    }

    @TargetApi(3)
    public static void a(final Runnable runnable, boolean z) {
        ThreadExecutor threadExecutor = um.d;
        if (threadExecutor != null) {
            threadExecutor.execute(runnable, z);
        } else {
            new Thread(new Runnable() { // from class: com.taobao.downloader.util.ThreadUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }).start();
        }
    }
}
