package tb;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class k02 extends g02 implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    /* renamed from: a */
    public vz1 findAnnotation(@NotNull hp0 hp0Var) {
        return ReflectJavaAnnotationOwner.C8322a.a(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    /* renamed from: b */
    public List<vz1> getAnnotations() {
        return ReflectJavaAnnotationOwner.C8322a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    @NotNull
    /* renamed from: c */
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = d().getDeclaringClass();
        b41.h(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }

    @NotNull
    public abstract Member d();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[LOOP:0: B:9:0x002b->B:22:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[EDGE_INSN: B:27:0x00a1->B:25:0x00a1 ?: BREAK  , SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> e(@org.jetbrains.annotations.NotNull java.lang.reflect.Type[] r12, @org.jetbrains.annotations.NotNull java.lang.annotation.Annotation[][] r13, boolean r14) {
        /*
            r11 = this;
            java.lang.String r0 = "parameterTypes"
            tb.b41.i(r12, r0)
            java.lang.String r0 = "parameterAnnotations"
            tb.b41.i(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.length
            r0.<init>(r1)
            tb.y41 r1 = tb.y41.INSTANCE
            java.lang.reflect.Member r2 = r11.d()
            java.util.List r1 = r1.b(r2)
            r2 = 0
            if (r1 != 0) goto L1f
            r3 = 0
            goto L25
        L1f:
            int r3 = r1.size()
            int r4 = r12.length
            int r3 = r3 - r4
        L25:
            int r4 = r12.length
            int r4 = r4 + (-1)
            if (r4 < 0) goto La1
            r5 = 0
        L2b:
            int r6 = r5 + 1
            tb.o02$a r7 = tb.o02.Factory
            r8 = r12[r5]
            tb.o02 r7 = r7.a(r8)
            if (r1 != 0) goto L39
            r8 = 0
            goto L43
        L39:
            int r8 = r5 + r3
            java.lang.Object r8 = kotlin.collections.C8212k.S(r1, r8)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L5d
        L43:
            if (r14 == 0) goto L4d
            int r9 = kotlin.collections.C8202e.x(r12)
            if (r5 != r9) goto L4d
            r9 = 1
            goto L4e
        L4d:
            r9 = 0
        L4e:
            tb.q02 r10 = new tb.q02
            r5 = r13[r5]
            r10.<init>(r7, r5, r8, r9)
            r0.add(r10)
            if (r6 <= r4) goto L5b
            goto La1
        L5b:
            r5 = r6
            goto L2b
        L5d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "No parameter with index "
            r12.append(r13)
            r12.append(r5)
            r13 = 43
            r12.append(r13)
            r12.append(r3)
            java.lang.String r13 = " (name="
            r12.append(r13)
            tb.ni1 r13 = r11.getName()
            r12.append(r13)
            java.lang.String r13 = " type="
            r12.append(r13)
            r12.append(r7)
            java.lang.String r13 = ") in "
            r12.append(r13)
            r12.append(r1)
            java.lang.String r13 = "@ReflectJavaMember"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.k02.e(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.List");
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof k02) && b41.d(d(), ((k02) obj).d());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @NotNull
    public AnnotatedElement getElement() {
        return (AnnotatedElement) d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return d().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public ni1 getName() {
        String name = d().getName();
        ni1 f = name == null ? null : ni1.f(name);
        if (f == null) {
            ni1 ni1Var = af2.NO_NAME_PROVIDED;
            b41.h(ni1Var, "NO_NAME_PROVIDED");
            return ni1Var;
        }
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    @NotNull
    public uy2 getVisibility() {
        return ReflectJavaModifierListOwner.C8323a.a(this);
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.C8323a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.C8322a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.C8323a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.C8323a.d(this);
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + d();
    }
}
