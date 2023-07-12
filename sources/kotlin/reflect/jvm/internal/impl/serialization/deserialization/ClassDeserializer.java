package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.youku.arch.v3.data.Constants;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ej;
import tb.h70;
import tb.hj;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ClassDeserializer {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    private static final Set<hj> c;
    @NotNull
    private final h70 a;
    @NotNull
    private final Function1<a, ClassDescriptor> b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        private final hj a;
        @Nullable
        private final ej b;

        public a(@NotNull hj hjVar, @Nullable ej ejVar) {
            b41.i(hjVar, "classId");
            this.a = hjVar;
            this.b = ejVar;
        }

        @Nullable
        public final ej a() {
            return this.b;
        }

        @NotNull
        public final hj b() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && b41.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @NotNull
        public final Set<hj> a() {
            return ClassDeserializer.c;
        }
    }

    static {
        Set<hj> c2;
        c2 = d0.c(hj.m(c.a.cloneable.l()));
        c = c2;
    }

    public ClassDeserializer(@NotNull h70 h70Var) {
        b41.i(h70Var, Constants.COMPONENT);
        this.a = h70Var;
        this.b = h70Var.u().createMemoizedFunctionWithNullableValues(new Function1<a, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ClassDescriptor invoke(@NotNull ClassDeserializer.a aVar) {
                ClassDescriptor c2;
                b41.i(aVar, "key");
                c2 = ClassDeserializer.this.c(aVar);
                return c2;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00b9 A[EDGE_INSN: B:104:0x00b9->B:96:0x00b9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.a r13) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$a):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
    }

    public static /* synthetic */ ClassDescriptor e(ClassDeserializer classDeserializer, hj hjVar, ej ejVar, int i, Object obj) {
        if ((i & 2) != 0) {
            ejVar = null;
        }
        return classDeserializer.d(hjVar, ejVar);
    }

    @Nullable
    public final ClassDescriptor d(@NotNull hj hjVar, @Nullable ej ejVar) {
        b41.i(hjVar, "classId");
        return this.b.invoke(new a(hjVar, ejVar));
    }
}
