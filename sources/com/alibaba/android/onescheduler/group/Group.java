package com.alibaba.android.onescheduler.group;

import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.IScheduler;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Group implements IGroup {
    private static ExecutorService i = Executors.newSingleThreadExecutor(new ThreadFactoryC3237a());
    private Priority d;
    private IScheduler h;
    private int a = 1;
    private volatile boolean b = false;
    private volatile boolean c = false;
    @NonNull
    private Queue<InnerOneTask> e = new PriorityBlockingQueue(5, new C3238b(this));
    @NonNull
    private List<InnerOneTask> f = new ArrayList();
    private final ReentrantLock g = new ReentrantLock();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.onescheduler.group.Group$a */
    /* loaded from: classes5.dex */
    static class ThreadFactoryC3237a implements ThreadFactory {
        ThreadFactoryC3237a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Group");
            thread.setPriority(5);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.onescheduler.group.Group$b */
    /* loaded from: classes5.dex */
    class C3238b implements Comparator<InnerOneTask> {
        C3238b(Group group) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(@NonNull InnerOneTask innerOneTask, @NonNull InnerOneTask innerOneTask2) {
            long prioritySequence;
            long prioritySequence2;
            if (innerOneTask.getPriority() == null && innerOneTask2.getPriority() == null) {
                prioritySequence = innerOneTask.getPrioritySequence();
                prioritySequence2 = innerOneTask2.getPrioritySequence();
            } else if (innerOneTask.getPriority() == null) {
                return -1;
            } else {
                if (innerOneTask2 == null || innerOneTask2.getPriority() == null) {
                    return 1;
                }
                int compareTo = innerOneTask.getPriority().compareTo(innerOneTask2.getPriority()) * (-1);
                if (compareTo != 0) {
                    return compareTo;
                }
                prioritySequence = innerOneTask.getPrioritySequence();
                prioritySequence2 = innerOneTask2.getPrioritySequence();
            }
            return (int) (prioritySequence - prioritySequence2);
        }
    }

    public Group(IScheduler iScheduler) {
        this.h = iScheduler;
    }

    private InnerOneTask b() {
        if (this.c || this.b || this.e.isEmpty() || this.f.size() >= this.a) {
            return null;
        }
        InnerOneTask poll = this.e.poll();
        if (poll != null) {
            this.f.add(poll);
            poll.setRunningState(true);
        }
        return poll;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("concurrents", this.a);
            StringBuilder sb = new StringBuilder();
            if (this.f.size() > 0) {
                jSONObject.put("runningSize", this.f.size());
                for (InnerOneTask innerOneTask : new ArrayList(this.f)) {
                    if (innerOneTask != null) {
                        sb.append(innerOneTask.getName());
                        sb.append(":");
                        sb.append("isCancelled=");
                        sb.append(innerOneTask.isCancelled());
                        sb.append(";");
                    }
                }
            }
            jSONObject.put("runningTasks", sb.toString());
            sb.setLength(0);
            if (this.e.size() > 0) {
                jSONObject.put("waitingSize", this.e.size());
                for (InnerOneTask innerOneTask2 : new ArrayList(this.e)) {
                    if (innerOneTask2 != null) {
                        sb.append(innerOneTask2.getName());
                        sb.append(":");
                        sb.append("isCancelled=");
                        sb.append(innerOneTask2.isCancelled());
                        sb.append(";");
                    }
                }
            }
            jSONObject.put("waitingTasks", sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void addTask(@NonNull InnerOneTask innerOneTask) {
        if (Build.VERSION.SDK_INT >= 17) {
            innerOneTask.setPrioritySequence(SystemClock.elapsedRealtimeNanos());
        } else {
            innerOneTask.setPrioritySequence(SystemClock.elapsedRealtime());
        }
        innerOneTask.setGroupPriority(this.d);
        try {
            this.g.lock();
            if (!this.b && this.f.size() < this.a) {
                this.f.add(innerOneTask);
                innerOneTask.setRunningState(true);
                this.h.schedule(innerOneTask);
            } else {
                this.e.add(innerOneTask);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void destroy() {
        this.c = true;
        try {
            this.g.lock();
            ArrayList<InnerOneTask> arrayList = !this.e.isEmpty() ? new ArrayList(this.e) : null;
            ArrayList<InnerOneTask> arrayList2 = this.f.isEmpty() ? null : new ArrayList(this.f);
            if (arrayList != null && arrayList.size() > 0) {
                for (InnerOneTask innerOneTask : arrayList) {
                    innerOneTask.cancel(true);
                }
            }
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            for (InnerOneTask innerOneTask2 : arrayList2) {
                innerOneTask2.cancel(true);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public int getConcurrents() {
        return this.a;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void pause() {
        this.b = true;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void removeCanceledTask(@NonNull InnerOneTask innerOneTask) {
        if (innerOneTask.isRunningState()) {
            try {
                this.g.lock();
                this.f.remove(innerOneTask);
                InnerOneTask b = b();
                if (b != null) {
                    this.h.schedule(b);
                }
                return;
            } finally {
            }
        }
        try {
            this.g.lock();
            this.e.remove(innerOneTask);
        } finally {
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void removeFinishedTask(@NonNull InnerOneTask innerOneTask) {
        final CallableCallback callback;
        if (!innerOneTask.isCancelled() && (callback = innerOneTask.getCallback()) != null) {
            try {
                final Object obj = innerOneTask.getFutureTask().get();
                i.execute(new Runnable() { // from class: com.alibaba.android.onescheduler.group.Group.2
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onTaskFinished(obj);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
        try {
            this.g.lock();
            this.f.remove(innerOneTask);
            InnerOneTask b = b();
            if (b != null) {
                this.h.schedule(b);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void resume() {
        this.b = false;
        try {
            this.g.lock();
            InnerOneTask b = b();
            if (b != null) {
                this.h.schedule(b);
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void setConcurrents(int i2) {
        this.a = i2;
    }

    @Override // com.alibaba.android.onescheduler.group.IGroup
    public void setPriority(Priority priority) {
        this.d = priority;
    }
}
