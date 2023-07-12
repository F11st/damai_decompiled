package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e02;
import tb.f02;
import tb.g02;
import tb.hp0;
import tb.i02;
import tb.if2;
import tb.l02;
import tb.ni1;
import tb.p02;
import tb.uy2;
import tb.vz1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ReflectJavaClass extends g02 implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    @NotNull
    private final Class<?> a;

    public ReflectJavaClass(@NotNull Class<?> cls) {
        b41.i(cls, "klass");
        this.a = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(Method method) {
        String name = method.getName();
        if (b41.d(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            b41.h(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (b41.d(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    /* renamed from: b */
    public vz1 findAnnotation(@NotNull hp0 hp0Var) {
        return ReflectJavaAnnotationOwner.a.a(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    /* renamed from: c */
    public List<vz1> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    /* renamed from: d */
    public List<f02> getConstructors() {
        Sequence o;
        Sequence p;
        Sequence v;
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        b41.h(declaredConstructors, "klass.declaredConstructors");
        o = ArraysKt___ArraysKt.o(declaredConstructors);
        p = SequencesKt___SequencesKt.p(o, ReflectJavaClass$constructors$1.INSTANCE);
        v = SequencesKt___SequencesKt.v(p, ReflectJavaClass$constructors$2.INSTANCE);
        return SequencesKt___SequencesKt.B(v);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @NotNull
    /* renamed from: e */
    public Class<?> getElement() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaClass) && b41.d(this.a, ((ReflectJavaClass) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    /* renamed from: f */
    public List<i02> getFields() {
        Sequence o;
        Sequence p;
        Sequence v;
        Field[] declaredFields = this.a.getDeclaredFields();
        b41.h(declaredFields, "klass.declaredFields");
        o = ArraysKt___ArraysKt.o(declaredFields);
        p = SequencesKt___SequencesKt.p(o, ReflectJavaClass$fields$1.INSTANCE);
        v = SequencesKt___SequencesKt.v(p, ReflectJavaClass$fields$2.INSTANCE);
        return SequencesKt___SequencesKt.B(v);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    /* renamed from: g */
    public List<ni1> getInnerClassNames() {
        Sequence o;
        Sequence p;
        Sequence w;
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        b41.h(declaredClasses, "klass.declaredClasses");
        o = ArraysKt___ArraysKt.o(declaredClasses);
        p = SequencesKt___SequencesKt.p(o, new Function1<Class<?>, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$innerClassNames$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(Class<?> cls) {
                String simpleName = cls.getSimpleName();
                b41.h(simpleName, "it.simpleName");
                return Boolean.valueOf(simpleName.length() == 0);
            }
        });
        w = SequencesKt___SequencesKt.w(p, new Function1<Class<?>, ni1>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$innerClassNames$2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ni1 invoke(Class<?> cls) {
                String simpleName = cls.getSimpleName();
                if (!ni1.h(simpleName)) {
                    simpleName = null;
                }
                if (simpleName == null) {
                    return null;
                }
                return ni1.f(simpleName);
            }
        });
        return SequencesKt___SequencesKt.B(w);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public hp0 getFqName() {
        hp0 b = ReflectClassUtilKt.a(this.a).b();
        b41.h(b, "klass.classId.asSingleFqName()");
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @Nullable
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public ni1 getName() {
        ni1 f = ni1.f(this.a.getSimpleName());
        b41.h(f, "identifier(klass.simpleName)");
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaClassifierType> getPermittedTypes() {
        List g;
        g = m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaRecordComponent> getRecordComponents() {
        List g;
        g = m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaClassifierType> getSupertypes() {
        Class cls;
        List<Type> j;
        int q;
        List g;
        cls = Object.class;
        if (b41.d(this.a, cls)) {
            g = m.g();
            return g;
        }
        if2 if2Var = new if2(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        if2Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        b41.h(genericInterfaces, "klass.genericInterfaces");
        if2Var.b(genericInterfaces);
        j = m.j(if2Var.d(new Type[if2Var.c()]));
        q = n.q(j, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Type type : j) {
            arrayList.add(new e02(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<p02> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        b41.h(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new p02(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    @NotNull
    public uy2 getVisibility() {
        return ReflectJavaModifierListOwner.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    /* renamed from: h */
    public List<l02> getMethods() {
        Sequence o;
        Sequence o2;
        Sequence v;
        Method[] declaredMethods = this.a.getDeclaredMethods();
        b41.h(declaredMethods, "klass.declaredMethods");
        o = ArraysKt___ArraysKt.o(declaredMethods);
        o2 = SequencesKt___SequencesKt.o(o, new Function1<Method, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
                if (r5 == false) goto L4;
             */
            @Override // kotlin.jvm.functions.Function1
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(java.lang.reflect.Method r5) {
                /*
                    r4 = this;
                    boolean r0 = r5.isSynthetic()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto La
                L8:
                    r1 = 0
                    goto L1f
                La:
                    kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.this
                    boolean r0 = r0.isEnum()
                    if (r0 == 0) goto L1f
                    kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.this
                    java.lang.String r3 = "method"
                    tb.b41.h(r5, r3)
                    boolean r5 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.a(r0, r5)
                    if (r5 != 0) goto L8
                L1f:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1.invoke(java.lang.reflect.Method):java.lang.Boolean");
            }
        });
        v = SequencesKt___SequencesKt.v(o2, ReflectJavaClass$methods$2.INSTANCE);
        return SequencesKt___SequencesKt.B(v);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @Nullable
    /* renamed from: i */
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.a.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.a.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.a.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.d(this);
    }

    @NotNull
    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.a;
    }
}
