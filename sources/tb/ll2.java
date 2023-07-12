package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.event.OnTaskFinishedListener;
import com.alibaba.android.onescheduler.group.Group;
import com.alibaba.android.onescheduler.group.ITaskTools;
import com.alibaba.android.onescheduler.scheduler.SimpleScheduler;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ll2 {
    @NonNull
    private Map<FutureTask, InnerOneTask> a;
    private yu0 b;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements OnTaskFinishedListener {
        a() {
        }

        @Override // com.alibaba.android.onescheduler.event.OnTaskFinishedListener
        public void onFinished(FutureTask futureTask) {
            InnerOneTask innerOneTask = (InnerOneTask) ll2.this.a.remove(futureTask);
            if (innerOneTask == null) {
                return;
            }
            String groupName = innerOneTask.getGroupName();
            if (!TextUtils.isEmpty(groupName)) {
                Group d = ll2.this.b.d(groupName);
                if (d == null) {
                    return;
                }
                d.removeFinishedTask(innerOneTask);
                return;
            }
            xm1.a("Doraemon thread Group name is null !!!");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements ITaskTools {
        b() {
        }

        @Override // com.alibaba.android.onescheduler.group.ITaskTools
        @NonNull
        public OneCommonTask convert(FutureTask futureTask) {
            return (OneCommonTask) ll2.this.a.get(futureTask);
        }

        @Override // com.alibaba.android.onescheduler.group.ITaskTools
        @Nullable
        public List<String> getTaskNames(TaskType taskType) {
            return ll2.this.g(taskType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class c {
        private static final ll2 a = new ll2(null);
    }

    /* synthetic */ ll2(a aVar) {
        this();
    }

    @NonNull
    public static ll2 f() {
        return c.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<String> g(@Nullable TaskType taskType) {
        if (taskType == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(this.a.values()).iterator();
        while (it.hasNext()) {
            InnerOneTask innerOneTask = (InnerOneTask) it.next();
            if (taskType == innerOneTask.getTaskType()) {
                arrayList.add(innerOneTask.getName());
            }
        }
        return arrayList;
    }

    public void d(@NonNull InnerOneTask innerOneTask) {
        String groupName = innerOneTask.getGroupName();
        if (TextUtils.isEmpty(groupName)) {
            xm1.a("Doraemon thread Group name is null !!!");
        }
        this.a.remove(innerOneTask.getFutureTask());
        Group d = this.b.d(groupName);
        if (d == null) {
            return;
        }
        d.removeCanceledTask(innerOneTask);
    }

    public yu0 e() {
        return this.b;
    }

    public void h(@NonNull InnerOneTask innerOneTask) {
        String groupName = innerOneTask.getGroupName();
        if (TextUtils.isEmpty(groupName)) {
            xm1.a("Doraemon thread Group name is null !!!");
            return;
        }
        Group d = this.b.d(groupName);
        if (d == null) {
            xm1.a("Group is null !!!");
            return;
        }
        this.a.put(innerOneTask.getFutureTask(), innerOneTask);
        d.addTask(innerOneTask);
    }

    private ll2() {
        this.a = new ConcurrentHashMap();
        this.b = new yu0(new SimpleScheduler());
        tf0.a().j(new a());
        tf0.a().k(new b());
    }
}
