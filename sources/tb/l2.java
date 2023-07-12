package tb;

import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class l2 extends fd2 {
    @NotNull
    public static final C9400a Companion = new C9400a(null);
    @NotNull
    private final TypeConstructor b;
    private final boolean c;
    @NotNull
    private final MemberScope d;

    /* compiled from: Taobao */
    /* renamed from: tb.l2$a */
    /* loaded from: classes3.dex */
    public static final class C9400a {
        private C9400a() {
        }

        public /* synthetic */ C9400a(k50 k50Var) {
            this();
        }
    }

    public l2(@NotNull TypeConstructor typeConstructor, boolean z) {
        b41.i(typeConstructor, "originalTypeVariable");
        this.b = typeConstructor;
        this.c = z;
        MemberScope h = kf0.h(b41.r("Scope for stub type: ", typeConstructor));
        b41.h(h, "createErrorScope(\"Scope …: $originalTypeVariable\")");
        this.d = h;
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        List<TypeProjection> g;
        g = C8214m.g();
        return g;
    }

    @Override // tb.z71
    public boolean d() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return this.d;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return z == d() ? this : m(z);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: k */
    public fd2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return this;
    }

    @NotNull
    public final TypeConstructor l() {
        return this.b;
    }

    @NotNull
    public abstract l2 m(boolean z);

    @Override // tb.gu2
    @NotNull
    /* renamed from: n */
    public l2 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }
}
