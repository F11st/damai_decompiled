package com.taobao.android.task;

import com.taobao.android.task.Coordinator;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Flow {
    protected static final String TAG = "Flow";
    protected ArrayList<Coordinator.TaggedRunnable> mTaskList = new ArrayList<>();
    protected boolean mCancel = false;
    protected boolean mAbortIfError = false;

    public Flow addTask(Coordinator.TaggedRunnable taggedRunnable) {
        if (taggedRunnable != null) {
            this.mTaskList.add(taggedRunnable);
        }
        return this;
    }

    public void cancel() {
        this.mCancel = true;
    }

    public void start() {
        Coordinator.getDefaultAsyncTaskExecutor().execute(new Runnable() { // from class: com.taobao.android.task.Flow.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                RuntimeException runtimeException;
                int size = Flow.this.mTaskList.size();
                for (int i = 0; i < size; i++) {
                    Flow flow = Flow.this;
                    if (flow.mCancel) {
                        return;
                    }
                    try {
                        flow.mTaskList.get(i).run();
                    } finally {
                        if (!z) {
                        }
                    }
                }
            }
        });
    }
}
