package com.youku.arch.v3.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Util {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void throwIf(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206966508")) {
            ipChange.ipc$dispatch("206966508", new Object[]{Boolean.valueOf(z)});
        } else if (z) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNot(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799202011")) {
            ipChange.ipc$dispatch("-1799202011", new Object[]{Boolean.valueOf(z)});
        } else if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNotNull(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565601436")) {
            ipChange.ipc$dispatch("-565601436", new Object[]{obj});
        } else if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public static <T> T throwIfNull(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299313451")) {
            return (T) ipChange.ipc$dispatch("-299313451", new Object[]{t});
        }
        Objects.requireNonNull(t);
        return t;
    }

    public static void throwIf(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342559670")) {
            ipChange.ipc$dispatch("1342559670", new Object[]{Boolean.valueOf(z), str});
        } else if (z) {
            throw new IllegalStateException(str);
        }
    }

    public static void throwIfNot(boolean z, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64188126")) {
            ipChange.ipc$dispatch("-64188126", new Object[]{Boolean.valueOf(z), str, objArr});
        } else if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T1, T2> void throwIfNull(T1 t1, T2 t2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815468903")) {
            ipChange.ipc$dispatch("-1815468903", new Object[]{t1, t2});
            return;
        }
        throwIfNull(t1);
        throwIfNull(t2);
    }

    public static <T1, T2, T3> void throwIfNull(T1 t1, T2 t2, T3 t3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186744885")) {
            ipChange.ipc$dispatch("186744885", new Object[]{t1, t2, t3});
            return;
        }
        throwIfNull(t1);
        throwIfNull(t2);
        throwIfNull(t3);
    }
}
