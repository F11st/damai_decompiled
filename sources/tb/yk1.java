package tb;

import kotlinx.coroutines.scheduling.TaskContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class yk1 implements TaskContext {
    public static final yk1 INSTANCE = new yk1();
    private static final int a = 0;

    private yk1() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return a;
    }
}
