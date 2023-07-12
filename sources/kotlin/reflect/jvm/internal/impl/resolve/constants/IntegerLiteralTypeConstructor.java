package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.cr2;
import tb.fd2;
import tb.jn1;
import tb.k50;
import tb.ku1;
import tb.z71;
import tb.zq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long a;
    @NotNull
    private final ModuleDescriptor b;
    @NotNull
    private final Set<z71> c;
    @NotNull
    private final fd2 d;
    @NotNull
    private final Lazy e;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$Companion$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C8492a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final fd2 a(Collection<? extends fd2> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    Companion companion = IntegerLiteralTypeConstructor.Companion;
                    next = companion.e((fd2) next, (fd2) it.next(), mode);
                }
                return (fd2) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final fd2 c(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set V;
            int i = C8492a.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                V = CollectionsKt___CollectionsKt.V(integerLiteralTypeConstructor.e(), integerLiteralTypeConstructor2.e());
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                V = CollectionsKt___CollectionsKt.F0(integerLiteralTypeConstructor.e(), integerLiteralTypeConstructor2.e());
            }
            return KotlinTypeFactory.e(Annotations.Companion.b(), new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.a, integerLiteralTypeConstructor.b, V, null), false);
        }

        private final fd2 d(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, fd2 fd2Var) {
            if (integerLiteralTypeConstructor.e().contains(fd2Var)) {
                return fd2Var;
            }
            return null;
        }

        private final fd2 e(fd2 fd2Var, fd2 fd2Var2, Mode mode) {
            if (fd2Var == null || fd2Var2 == null) {
                return null;
            }
            TypeConstructor c = fd2Var.c();
            TypeConstructor c2 = fd2Var2.c();
            boolean z = c instanceof IntegerLiteralTypeConstructor;
            if (z && (c2 instanceof IntegerLiteralTypeConstructor)) {
                return c((IntegerLiteralTypeConstructor) c, (IntegerLiteralTypeConstructor) c2, mode);
            }
            if (z) {
                return d((IntegerLiteralTypeConstructor) c, fd2Var2);
            }
            if (c2 instanceof IntegerLiteralTypeConstructor) {
                return d((IntegerLiteralTypeConstructor) c2, fd2Var);
            }
            return null;
        }

        @Nullable
        public final fd2 b(@NotNull Collection<? extends fd2> collection) {
            b41.i(collection, "types");
            return a(collection, Mode.INTERSECTION_TYPE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set<? extends z71> set) {
        Lazy b;
        this.d = KotlinTypeFactory.e(Annotations.Companion.b(), this, false);
        b = C8177b.b(new Function0<List<fd2>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$supertypes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<fd2> invoke() {
                fd2 fd2Var;
                List e;
                List<fd2> m;
                boolean g;
                fd2 defaultType = IntegerLiteralTypeConstructor.this.getBuiltIns().x().getDefaultType();
                b41.h(defaultType, "builtIns.comparable.defaultType");
                Variance variance = Variance.IN_VARIANCE;
                fd2Var = IntegerLiteralTypeConstructor.this.d;
                e = C8213l.e(new zq2(variance, fd2Var));
                m = C8214m.m(cr2.f(defaultType, e, null, 2, null));
                g = IntegerLiteralTypeConstructor.this.g();
                if (!g) {
                    m.add(IntegerLiteralTypeConstructor.this.getBuiltIns().L());
                }
                return m;
            }
        });
        this.e = b;
        this.a = j;
        this.b = moduleDescriptor;
        this.c = set;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, k50 k50Var) {
        this(j, moduleDescriptor, set);
    }

    private final List<z71> f() {
        return (List) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        Collection<z71> a = ku1.a(this.b);
        if ((a instanceof Collection) && a.isEmpty()) {
            return true;
        }
        for (z71 z71Var : a) {
            if (!(!e().contains(z71Var))) {
                return false;
            }
        }
        return true;
    }

    private final String h() {
        String Z;
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        Z = CollectionsKt___CollectionsKt.Z(this.c, ",", null, null, 0, null, new Function1<z71, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$valueToString$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull z71 z71Var) {
                b41.i(z71Var, AdvanceSetting.NETWORK_TYPE);
                return z71Var.toString();
            }
        }, 30, null);
        sb.append(Z);
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    @NotNull
    public final Set<z71> e() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public AbstractC8271b getBuiltIns() {
        return this.b.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<z71> getSupertypes() {
        return f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        return b41.r("IntegerLiteralType", h());
    }
}
