package tb;

import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class wf {
    @Deprecated
    @NotNull
    private static final ni1 e;
    @NotNull
    private final hp0 a;
    @Nullable
    private final hp0 b;
    @NotNull
    private final ni1 c;
    @Nullable
    private final hp0 d;

    /* compiled from: Taobao */
    /* renamed from: tb.wf$a */
    /* loaded from: classes3.dex */
    private static final class C9864a {
        private C9864a() {
        }

        public /* synthetic */ C9864a(k50 k50Var) {
            this();
        }
    }

    static {
        new C9864a(null);
        ni1 i = ni1.i("<local>");
        b41.h(i, "special(\"<local>\")");
        e = i;
        b41.h(hp0.k(i), "topLevel(LOCAL_NAME)");
    }

    public wf(@NotNull hp0 hp0Var, @Nullable hp0 hp0Var2, @NotNull ni1 ni1Var, @Nullable hp0 hp0Var3) {
        b41.i(hp0Var, "packageName");
        b41.i(ni1Var, "callableName");
        this.a = hp0Var;
        this.b = hp0Var2;
        this.c = ni1Var;
        this.d = hp0Var3;
    }

    @NotNull
    public final ni1 a() {
        return this.c;
    }

    @Nullable
    public final hp0 b() {
        return this.b;
    }

    @NotNull
    public final hp0 c() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wf) {
            wf wfVar = (wf) obj;
            return b41.d(this.a, wfVar.a) && b41.d(this.b, wfVar.b) && b41.d(this.c, wfVar.c) && b41.d(this.d, wfVar.d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        hp0 hp0Var = this.b;
        int hashCode2 = (((hashCode + (hp0Var == null ? 0 : hp0Var.hashCode())) * 31) + this.c.hashCode()) * 31;
        hp0 hp0Var2 = this.d;
        return hashCode2 + (hp0Var2 != null ? hp0Var2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String y;
        StringBuilder sb = new StringBuilder();
        String b = c().b();
        b41.h(b, "packageName.asString()");
        y = C8604o.y(b, '.', r10.DIR, false, 4, null);
        sb.append(y);
        sb.append("/");
        if (b() != null) {
            sb.append(b());
            sb.append(".");
        }
        sb.append(a());
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public /* synthetic */ wf(hp0 hp0Var, hp0 hp0Var2, ni1 ni1Var, hp0 hp0Var3, int i, k50 k50Var) {
        this(hp0Var, hp0Var2, ni1Var, (i & 8) != 0 ? null : hp0Var3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wf(@NotNull hp0 hp0Var, @NotNull ni1 ni1Var) {
        this(hp0Var, null, ni1Var, null, 8, null);
        b41.i(hp0Var, "packageName");
        b41.i(ni1Var, "callableName");
    }
}
