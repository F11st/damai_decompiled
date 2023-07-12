package kotlin.reflect.jvm.internal.impl.types;

import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.JvmName;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.yd2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractTypeCheckerContext {
    private int a;
    private boolean b;
    @Nullable
    private ArrayDeque<SimpleTypeMarker> c;
    @Nullable
    private Set<SimpleTypeMarker> d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static abstract class AbstractC0430a extends a {
            public AbstractC0430a() {
                super(null);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class b extends a {
            @NotNull
            public static final b INSTANCE = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                b41.i(kotlinTypeMarker, "type");
                return abstractTypeCheckerContext.j().lowerBoundIfFlexible(kotlinTypeMarker);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class c extends a {
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            public /* bridge */ /* synthetic */ SimpleTypeMarker a(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                return (SimpleTypeMarker) b(abstractTypeCheckerContext, kotlinTypeMarker);
            }

            @NotNull
            public Void b(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                b41.i(kotlinTypeMarker, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class d extends a {
            @NotNull
            public static final d INSTANCE = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                b41.i(kotlinTypeMarker, "type");
                return abstractTypeCheckerContext.j().upperBoundIfFlexible(kotlinTypeMarker);
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public abstract SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker);
    }

    public static /* synthetic */ Boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z = false;
            }
            return abstractTypeCheckerContext.c(kotlinTypeMarker, kotlinTypeMarker2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    @Nullable
    public Boolean c(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        b41.i(kotlinTypeMarker, "subType");
        b41.i(kotlinTypeMarker2, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.c;
        b41.f(arrayDeque);
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.d;
        b41.f(set);
        set.clear();
        this.b = false;
    }

    public boolean f(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        b41.i(kotlinTypeMarker, "subType");
        b41.i(kotlinTypeMarker2, "superType");
        return true;
    }

    @NotNull
    public LowerCapturedTypePolicy g(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CapturedTypeMarker capturedTypeMarker) {
        b41.i(simpleTypeMarker, "subType");
        b41.i(capturedTypeMarker, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Nullable
    public final ArrayDeque<SimpleTypeMarker> h() {
        return this.c;
    }

    @Nullable
    public final Set<SimpleTypeMarker> i() {
        return this.d;
    }

    @NotNull
    public abstract TypeSystemContext j();

    public final void k() {
        this.b = true;
        if (this.c == null) {
            this.c = new ArrayDeque<>(4);
        }
        if (this.d == null) {
            this.d = yd2.Companion.a();
        }
    }

    public abstract boolean l(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @JvmName(name = "isAllowedTypeVariableBridge")
    public final boolean m(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        b41.i(kotlinTypeMarker, "type");
        return l(kotlinTypeMarker);
    }

    public abstract boolean n();

    public abstract boolean o();

    @NotNull
    public abstract KotlinTypeMarker p(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract KotlinTypeMarker q(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract a r(@NotNull SimpleTypeMarker simpleTypeMarker);
}
