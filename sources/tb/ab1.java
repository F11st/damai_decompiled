package tb;

import com.alibaba.pictures.cornerstone.protocol.ILogger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ab1 extends hb<ILogger> implements ILogger {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ab1 INSTANCE;

    static {
        ab1 ab1Var = new ab1();
        INSTANCE = ab1Var;
        hb.f(ab1Var, new sb1(), null, 2, null);
    }

    private ab1() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1831934128")) {
            ipChange.ipc$dispatch("1831934128", new Object[]{this, str});
        } else {
            a().d(str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206122161")) {
            ipChange.ipc$dispatch("-206122161", new Object[]{this, str});
        } else {
            a().e(str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763570301")) {
            ipChange.ipc$dispatch("1763570301", new Object[]{this, str});
        } else {
            a().w(str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void d(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006406022")) {
            ipChange.ipc$dispatch("-1006406022", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        a().d(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void e(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455173977")) {
            ipChange.ipc$dispatch("455173977", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        a().e(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ILogger
    public void w(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993810183")) {
            ipChange.ipc$dispatch("993810183", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "tag");
        a().w(str, str2);
    }
}
