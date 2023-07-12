package com.taobao.update.datasource;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.result.BundleUpdateStep;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import tb.lu2;
import tb.qu1;
import tb.ub1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TaskManager {
    private static TaskManager e;
    private boolean b;
    private boolean c;
    private BlockingQueue<Task> a = new PriorityBlockingQueue(5);
    private Log d = ub1.getLog(TaskManager.class, (Log) null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements UpdateListener.PatchListener {
        a() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("dexpatch fix:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.b = true;
            if (TaskManager.this.a.peek() != null) {
                if (TaskManager.this.a.peek() == null || ((qu1) TaskManager.this.a.peek()).getPatchType().getPriority() != 4) {
                    return;
                }
                TaskManager.this.a.poll();
                return;
            }
            UpdateDataSource.getInstance().clearCache();
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements UpdateListener.PatchListener {
        b() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("Apk update:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.a.clear();
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class c implements UpdateListener.PatchListener {
        c() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("dynamic update:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.c = true;
            TaskManager.this.a.clear();
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    private TaskManager() {
    }

    private void e(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.update.datasource.TaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }

    public static TaskManager instance() {
        if (e == null) {
            synchronized (TaskManager.class) {
                if (e == null) {
                    e = new TaskManager();
                }
            }
        }
        return e;
    }

    public void add(Task task) {
        boolean z = this.c;
        if (z || this.b) {
            UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", z ? "update_dynamic_success" : "update_dexpatch_success", "");
            qu1 qu1Var = (qu1) task;
            if (qu1Var.getPatchType().getPriority() == 2 || qu1Var.getPatchType().getPriority() == 4) {
                if (qu1Var.from().equals(lu2.SCAN)) {
                    e("动态部署或者dexpatch已经成功,杀进程生效,在这期间不能再次操作");
                    return;
                }
                Log log = this.d;
                log.w("dynamic has finished " + this.c + " or dexpatch has finished " + this.b);
                return;
            }
        }
        if (!this.a.contains(task)) {
            this.a.add(task);
        } else if (!((qu1) task).isBackground()) {
            e("正在更新中");
        } else {
            this.d.w("update is in progress....");
        }
    }

    public void run() throws InterruptedException {
        while (true) {
            Task poll = this.a.poll(1000L, TimeUnit.MILLISECONDS);
            if (poll == null || !(poll instanceof qu1)) {
                return;
            }
            qu1 qu1Var = (qu1) poll;
            if (qu1Var.getPatchType().getPriority() == 0) {
                qu1Var.asyncRun();
            } else if (qu1Var.getPatchType().getPriority() == 1) {
                qu1Var.asyncRun();
            } else if (qu1Var.getPatchType().getPriority() == 2) {
                UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", "update_dispatch_dexpatch", "");
                if (qu1Var.getRunnable().getUpdateListener() != null) {
                    qu1Var.getRunnable().getUpdateListener().patchProcessListener(new a());
                }
                qu1Var.syncRun();
            } else if (qu1Var.getPatchType().getPriority() == 3) {
                if (qu1Var.getRunnable().getUpdateListener() != null) {
                    qu1Var.getRunnable().getUpdateListener().patchProcessListener(new b());
                }
                qu1Var.syncRun();
            } else if (qu1Var.getPatchType().getPriority() == 4) {
                if (this.b) {
                    return;
                }
                UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", "update_dispatch_dynamic", "");
                if (qu1Var.getRunnable().getUpdateListener() != null) {
                    qu1Var.getRunnable().getUpdateListener().patchProcessListener(new c());
                }
                qu1Var.syncRun();
            } else if (qu1Var.getPatchType().getPriority() == 5) {
                qu1Var.asyncRun();
                return;
            }
        }
    }
}
