package tb;

import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final /* synthetic */ class j7 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[BufferOverflow.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
        iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
        iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
    }
}
