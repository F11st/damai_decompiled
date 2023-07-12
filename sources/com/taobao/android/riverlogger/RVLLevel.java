package com.taobao.android.riverlogger;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes12.dex */
public enum RVLLevel {
    Off(0),
    Error(1),
    Warn(2),
    Info(3),
    Debug(4),
    Verbose(5);
    
    public final int value;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RVLLevel.values().length];
            a = iArr;
            try {
                iArr[RVLLevel.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RVLLevel.Warn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RVLLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RVLLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    RVLLevel(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "verbose" : "debug" : "info" : "warn" : "error";
    }

    public static RVLLevel valueOf(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return Verbose;
                    }
                    return Debug;
                }
                return Info;
            }
            return Warn;
        }
        return Error;
    }
}
