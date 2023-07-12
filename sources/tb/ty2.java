package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import kotlin.collections.C8223u;
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
    /* renamed from: tb.ty2$a */
    /* loaded from: classes3.dex */
    public static final class C9737a extends uy2 {
        @NotNull
        public static final C9737a INSTANCE = new C9737a();

        private C9737a() {
            super("inherited", false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$b */
    /* loaded from: classes3.dex */
    public static final class C9738b extends uy2 {
        @NotNull
        public static final C9738b INSTANCE = new C9738b();

        private C9738b() {
            super("internal", false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$c */
    /* loaded from: classes3.dex */
    public static final class C9739c extends uy2 {
        @NotNull
        public static final C9739c INSTANCE = new C9739c();

        private C9739c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$d */
    /* loaded from: classes3.dex */
    public static final class C9740d extends uy2 {
        @NotNull
        public static final C9740d INSTANCE = new C9740d();

        private C9740d() {
            super("local", false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$e */
    /* loaded from: classes3.dex */
    public static final class C9741e extends uy2 {
        @NotNull
        public static final C9741e INSTANCE = new C9741e();

        private C9741e() {
            super(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$f */
    /* loaded from: classes3.dex */
    public static final class C9742f extends uy2 {
        @NotNull
        public static final C9742f INSTANCE = new C9742f();

        private C9742f() {
            super("private_to_this", false);
        }

        @Override // tb.uy2
        @NotNull
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$g */
    /* loaded from: classes3.dex */
    public static final class C9743g extends uy2 {
        @NotNull
        public static final C9743g INSTANCE = new C9743g();

        private C9743g() {
            super("protected", true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$h */
    /* loaded from: classes3.dex */
    public static final class C9744h extends uy2 {
        @NotNull
        public static final C9744h INSTANCE = new C9744h();

        private C9744h() {
            super("public", true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ty2$i */
    /* loaded from: classes3.dex */
    public static final class C9745i extends uy2 {
        @NotNull
        public static final C9745i INSTANCE = new C9745i();

        private C9745i() {
            super("unknown", false);
        }
    }

    static {
        Map c = C8223u.c();
        c.put(C9742f.INSTANCE, 0);
        c.put(C9741e.INSTANCE, 0);
        c.put(C9738b.INSTANCE, 1);
        c.put(C9743g.INSTANCE, 1);
        c.put(C9744h.INSTANCE, 2);
        a = C8223u.b(c);
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
        return uy2Var == C9741e.INSTANCE || uy2Var == C9742f.INSTANCE;
    }
}
