package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneSchedulerExceptionHandler;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.group.Group;
import com.alibaba.android.onescheduler.task.C3242a;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class um1 {
    public static final String DEFAULT_GROUP = "default_group";
    private yu0 a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.um1$b */
    /* loaded from: classes5.dex */
    public static class C9782b {
        private static final um1 a = new um1();
    }

    public static void d(Runnable runnable) {
        g().h().setTaskName(runnable.toString()).setTaskGroup("default_group").setRunnable(runnable).buildCommonTask().run();
    }

    public static void e(Runnable runnable, TaskType taskType) {
        g().h().setTaskName(runnable.toString()).setTaskGroup("default_group").setRunnable(runnable).setTaskType(taskType).buildCommonTask().run();
    }

    public static um1 g() {
        return C9782b.a;
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        this.a.a(str, i);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.b(str);
    }

    public String c() {
        return this.a.c();
    }

    public Group f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.d(str);
    }

    public C3242a h() {
        return new C3242a();
    }

    public void i(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.a.e(str);
    }

    public void j(@Nullable OneSchedulerExceptionHandler oneSchedulerExceptionHandler) {
        if (oneSchedulerExceptionHandler == null) {
            return;
        }
        tf0.a().h(oneSchedulerExceptionHandler);
    }

    public void k(@Nullable TaskTracker taskTracker) {
        if (taskTracker == null) {
            return;
        }
        tf0.a().i(taskTracker);
    }

    public void l(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.a.f(str);
    }

    private um1() {
        yu0 e = ll2.f().e();
        this.a = e;
        e.a("default_group", 10);
    }
}
