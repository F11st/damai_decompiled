package tb;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;
import tb.b81;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class mj extends AbstractTypeCheckerContext {
    @NotNull
    public static final C9442a Companion = new C9442a(null);
    private final boolean e;
    private final boolean f;
    private final boolean g;
    @NotNull
    private final b81 h;
    @NotNull
    private final KotlinTypePreparator i;
    @NotNull
    private final ClassicTypeSystemContext j;

    /* compiled from: Taobao */
    /* renamed from: tb.mj$a */
    /* loaded from: classes3.dex */
    public static final class C9442a {

        /* compiled from: Taobao */
        /* renamed from: tb.mj$a$a */
        /* loaded from: classes3.dex */
        public static final class C9443a extends AbstractTypeCheckerContext.AbstractC8531a.AbstractC8532a {
            final /* synthetic */ ClassicTypeSystemContext a;
            final /* synthetic */ TypeSubstitutor b;

            C9443a(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
                this.a = classicTypeSystemContext;
                this.b = typeSubstitutor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.AbstractC8531a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                b41.i(kotlinTypeMarker, "type");
                ClassicTypeSystemContext classicTypeSystemContext = this.a;
                z71 n = this.b.n((z71) classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker), Variance.INVARIANT);
                b41.h(n, "substitutor.safeSubstitu…ANT\n                    )");
                SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(n);
                b41.f(asSimpleType);
                return asSimpleType;
            }
        }

        private C9442a() {
        }

        public /* synthetic */ C9442a(k50 k50Var) {
            this();
        }

        @NotNull
        public final AbstractTypeCheckerContext.AbstractC8531a.AbstractC8532a a(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            String b;
            b41.i(classicTypeSystemContext, "<this>");
            b41.i(simpleTypeMarker, "type");
            if (!(simpleTypeMarker instanceof fd2)) {
                b = nj.b(simpleTypeMarker);
                throw new IllegalArgumentException(b.toString());
            }
            return new C9443a(classicTypeSystemContext, oq2.Companion.b((z71) simpleTypeMarker).c());
        }
    }

    public /* synthetic */ mj(boolean z, boolean z2, boolean z3, b81 b81Var, KotlinTypePreparator kotlinTypePreparator, ClassicTypeSystemContext classicTypeSystemContext, int i, k50 k50Var) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) == 0 ? z3 : true, (i & 8) != 0 ? b81.C8955a.INSTANCE : b81Var, (i & 16) != 0 ? KotlinTypePreparator.C8547a.INSTANCE : kotlinTypePreparator, (i & 32) != 0 ? xc2.INSTANCE : classicTypeSystemContext);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean l(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        b41.i(kotlinTypeMarker, "<this>");
        return (kotlinTypeMarker instanceof gu2) && this.g && (((gu2) kotlinTypeMarker).c() instanceof NewTypeVariableConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean n() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean o() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    public KotlinTypeMarker p(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        String b;
        b41.i(kotlinTypeMarker, "type");
        if (!(kotlinTypeMarker instanceof z71)) {
            b = nj.b(kotlinTypeMarker);
            throw new IllegalArgumentException(b.toString());
        }
        return this.i.a(((z71) kotlinTypeMarker).f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    public KotlinTypeMarker q(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        String b;
        b41.i(kotlinTypeMarker, "type");
        if (!(kotlinTypeMarker instanceof z71)) {
            b = nj.b(kotlinTypeMarker);
            throw new IllegalArgumentException(b.toString());
        }
        return this.h.g((z71) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    /* renamed from: s */
    public ClassicTypeSystemContext j() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    /* renamed from: t */
    public AbstractTypeCheckerContext.AbstractC8531a.AbstractC8532a r(@NotNull SimpleTypeMarker simpleTypeMarker) {
        b41.i(simpleTypeMarker, "type");
        return Companion.a(j(), simpleTypeMarker);
    }

    public mj(boolean z, boolean z2, boolean z3, @NotNull b81 b81Var, @NotNull KotlinTypePreparator kotlinTypePreparator, @NotNull ClassicTypeSystemContext classicTypeSystemContext) {
        b41.i(b81Var, "kotlinTypeRefiner");
        b41.i(kotlinTypePreparator, "kotlinTypePreparator");
        b41.i(classicTypeSystemContext, "typeSystemContext");
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = b81Var;
        this.i = kotlinTypePreparator;
        this.j = classicTypeSystemContext;
    }
}
