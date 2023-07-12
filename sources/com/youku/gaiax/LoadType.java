package com.youku.gaiax;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0004\u001a\u00020\u0003j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/LoadType;", "", "Ljava/io/Serializable;", "", "getValue", "<init>", "(Ljava/lang/String;I)V", "SYNC_NORMAL", "ASYNC_NORMAL", "ASYNC_NORMAL_SUPER_MERGE", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum LoadType {
    SYNC_NORMAL,
    ASYNC_NORMAL,
    ASYNC_NORMAL_SUPER_MERGE;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.SYNC_NORMAL.ordinal()] = 1;
            iArr[LoadType.ASYNC_NORMAL.ordinal()] = 2;
            iArr[LoadType.ASYNC_NORMAL_SUPER_MERGE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int getValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 1;
        }
        return 0;
    }
}
