package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.d;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k71;
import tb.s61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypesJVMKt {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalStdlibApi
    public static final Type c(KType kType, boolean z) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new b((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class c = z ? s61.c(kClass) : s61.b(kClass);
            List<k71> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return c;
            }
            if (c.isArray()) {
                if (c.getComponentType().isPrimitive()) {
                    return c;
                }
                k71 k71Var = (k71) k.s0(arguments);
                if (k71Var != null) {
                    KVariance a2 = k71Var.a();
                    KType b = k71Var.b();
                    int i = a2 == null ? -1 : a.$EnumSwitchMapping$0[a2.ordinal()];
                    if (i == -1 || i == 1) {
                        return c;
                    }
                    if (i != 2 && i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    b41.f(b);
                    Type d = d(b, false, 1, null);
                    return d instanceof Class ? c : new kotlin.reflect.a(d);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return e(c, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    static /* synthetic */ Type d(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(kType, z);
    }

    @ExperimentalStdlibApi
    private static final Type e(Class<?> cls, List<k71> list) {
        int q;
        int q2;
        int q3;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            q3 = n.q(list, 10);
            ArrayList arrayList = new ArrayList(q3);
            for (k71 k71Var : list) {
                arrayList.add(g(k71Var));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            q2 = n.q(list, 10);
            ArrayList arrayList2 = new ArrayList(q2);
            for (k71 k71Var2 : list) {
                arrayList2.add(g(k71Var2));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type e = e(declaringClass, list.subList(length, list.size()));
            List<k71> subList = list.subList(0, length);
            q = n.q(subList, 10);
            ArrayList arrayList3 = new ArrayList(q);
            for (k71 k71Var3 : subList) {
                arrayList3.add(g(k71Var3));
            }
            return new ParameterizedTypeImpl(cls, e, arrayList3);
        }
    }

    @NotNull
    public static final Type f(@NotNull KType kType) {
        Type javaType;
        b41.i(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? d(kType, false, 1, null) : javaType;
    }

    private static final Type g(k71 k71Var) {
        KVariance d = k71Var.d();
        if (d == null) {
            return c.Companion.a();
        }
        KType c = k71Var.c();
        b41.f(c);
        int i = a.$EnumSwitchMapping$0[d.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new c(c(c, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return c(c, true);
        }
        return new c(null, c(c, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        String name;
        int m;
        String v;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence h = SequencesKt__SequencesKt.h(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                StringBuilder sb = new StringBuilder();
                sb.append(((Class) d.u(h)).getName());
                m = SequencesKt___SequencesKt.m(h);
                v = o.v("[]", m);
                sb.append(v);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            b41.h(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }
}
