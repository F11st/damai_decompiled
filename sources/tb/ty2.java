package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ty2 {
    @NotNull
    public static final ty2 INSTANCE = new ty2();
    @NotNull
    private static final Map<uy2, Integer> a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends uy2 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends uy2 {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
            super("internal", false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends uy2 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class d extends uy2 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super("local", false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class e extends uy2 {
        @NotNull
        public static final e INSTANCE = new e();

        private e() {
            super(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class f extends uy2 {
        @NotNull
        public static final f INSTANCE = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // tb.uy2
        @NotNull
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class g extends uy2 {
        @NotNull
        public static final g INSTANCE = new g();

        private g() {
            super("protected", true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class h extends uy2 {
        @NotNull
        public static final h INSTANCE = new h();

        private h() {
            super("public", true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class i extends uy2 {
        @NotNull
        public static final i INSTANCE = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map c2 = kotlin.collections.u.c();
        c2.put(f.INSTANCE, 0);
        c2.put(e.INSTANCE, 0);
        c2.put(b.INSTANCE, 1);
        c2.put(g.INSTANCE, 1);
        c2.put(h.INSTANCE, 2);
        a = kotlin.collections.u.b(c2);
    }

    private ty2() {
    }

    @Nullable
    public final Integer a(@NotNull uy2 uy2Var, @NotNull uy2 uy2Var2) {
        b41.i(uy2Var, ShareperfenceConstants.FIRST);
        b41.i(uy2Var2, "second");
        if (uy2Var == uy2Var2) {
            return 0;
        }
        Map<uy2, Integer> map = a;
        Integer num = map.get(uy2Var);
        Integer num2 = map.get(uy2Var2);
        if (num == null || num2 == null || b41.d(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@NotNull uy2 uy2Var) {
        b41.i(uy2Var, "visibility");
        return uy2Var == e.INSTANCE || uy2Var == f.INSTANCE;
    }
}
