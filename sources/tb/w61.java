package tb;

import com.tencent.open.SocialConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class w61 {

    /* compiled from: Taobao */
    /* renamed from: tb.w61$a */
    /* loaded from: classes3.dex */
    public static final class C9845a extends w61 {
        @NotNull
        private final String a;
        @NotNull
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9845a(@NotNull String str, @NotNull String str2) {
            super(null);
            b41.i(str, "name");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            this.a = str;
            this.b = str2;
        }

        @Override // tb.w61
        @NotNull
        public String a() {
            return c() + jn1.CONDITION_IF_MIDDLE + b();
        }

        @Override // tb.w61
        @NotNull
        public String b() {
            return this.b;
        }

        @Override // tb.w61
        @NotNull
        public String c() {
            return this.a;
        }

        @NotNull
        public final String d() {
            return c();
        }

        @NotNull
        public final String e() {
            return b();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9845a) {
                C9845a c9845a = (C9845a) obj;
                return b41.d(c(), c9845a.c()) && b41.d(b(), c9845a.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.w61$b */
    /* loaded from: classes3.dex */
    public static final class C9846b extends w61 {
        @NotNull
        private final String a;
        @NotNull
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9846b(@NotNull String str, @NotNull String str2) {
            super(null);
            b41.i(str, "name");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            this.a = str;
            this.b = str2;
        }

        @Override // tb.w61
        @NotNull
        public String a() {
            return b41.r(c(), b());
        }

        @Override // tb.w61
        @NotNull
        public String b() {
            return this.b;
        }

        @Override // tb.w61
        @NotNull
        public String c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9846b) {
                C9846b c9846b = (C9846b) obj;
                return b41.d(c(), c9846b.c()) && b41.d(b(), c9846b.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    private w61() {
    }

    public /* synthetic */ w61(k50 k50Var) {
        this();
    }

    @NotNull
    public abstract String a();

    @NotNull
    public abstract String b();

    @NotNull
    public abstract String c();

    @NotNull
    public final String toString() {
        return a();
    }
}
