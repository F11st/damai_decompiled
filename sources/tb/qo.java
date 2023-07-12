package tb;

import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class qo {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[CoroutineScheduler.WorkerState.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        iArr[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        iArr[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        iArr[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
        iArr[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}
