package tb;

import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ne1 {
    @NotNull
    public static final C9470a Companion = new C9470a(null);
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: tb.ne1$a */
    /* loaded from: classes3.dex */
    public static final class C9470a {
        private C9470a() {
        }

        public /* synthetic */ C9470a(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ne1 a(@NotNull String str, @NotNull String str2) {
            b41.i(str, "name");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            return new ne1(str + '#' + str2, null);
        }

        @JvmStatic
        @NotNull
        public final ne1 b(@NotNull w61 w61Var) {
            b41.i(w61Var, SocialOperation.GAME_SIGNATURE);
            if (w61Var instanceof w61.C9846b) {
                return d(w61Var.c(), w61Var.b());
            }
            if (w61Var instanceof w61.C9845a) {
                return a(w61Var.c(), w61Var.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        @NotNull
        public final ne1 c(@NotNull NameResolver nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            b41.i(nameResolver, "nameResolver");
            b41.i(jvmMethodSignature, SocialOperation.GAME_SIGNATURE);
            return d(nameResolver.getString(jvmMethodSignature.getName()), nameResolver.getString(jvmMethodSignature.getDesc()));
        }

        @JvmStatic
        @NotNull
        public final ne1 d(@NotNull String str, @NotNull String str2) {
            b41.i(str, "name");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            return new ne1(b41.r(str, str2), null);
        }

        @JvmStatic
        @NotNull
        public final ne1 e(@NotNull ne1 ne1Var, int i) {
            b41.i(ne1Var, SocialOperation.GAME_SIGNATURE);
            return new ne1(ne1Var.a() + '@' + i, null);
        }
    }

    private ne1(String str) {
        this.a = str;
    }

    public /* synthetic */ ne1(String str, k50 k50Var) {
        this(str);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ne1) && b41.d(this.a, ((ne1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "MemberSignature(signature=" + this.a + ')';
    }
}
