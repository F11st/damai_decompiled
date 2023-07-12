package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class af implements Comparable<af> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CACHE_CACHE_EXPIRED = 2;
    public static final int CACHE_CACHE_VALID = 1;
    public static final int CACHE_NO_CACHE = 0;
    @NotNull
    public static final a Companion = new a(null);
    private int a;
    private long b;
    @Nullable
    private String c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public af(@NotNull String str, @Nullable String str2) {
        b41.i(str, "key");
        this.b = System.currentTimeMillis();
        this.c = str2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NotNull af afVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-39823685")) {
            return ((Integer) ipChange.ipc$dispatch("-39823685", new Object[]{this, afVar})).intValue();
        }
        b41.i(afVar, "co");
        long j = this.b;
        long j2 = afVar.b;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1913258053") ? ((Integer) ipChange.ipc$dispatch("1913258053", new Object[]{this})).intValue() : this.a;
    }

    public final long c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1337614510") ? ((Long) ipChange.ipc$dispatch("1337614510", new Object[]{this})).longValue() : this.b;
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "614796328") ? (String) ipChange.ipc$dispatch("614796328", new Object[]{this}) : this.c;
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758665475")) {
            ipChange.ipc$dispatch("-1758665475", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a = i;
        }
    }

    public final void f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979932094")) {
            ipChange.ipc$dispatch("979932094", new Object[]{this, Long.valueOf(j)});
        } else {
            this.b = j;
        }
    }

    public final void g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75217230")) {
            ipChange.ipc$dispatch("75217230", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }
}
