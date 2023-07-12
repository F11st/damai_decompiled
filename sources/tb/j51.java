package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class j51 {
    private static final boolean a(JavaMethod javaMethod) {
        hp0 fqName;
        JavaValueParameter javaValueParameter = (JavaValueParameter) kotlin.collections.k.s0(javaMethod.getValueParameters());
        JavaType type = javaValueParameter == null ? null : javaValueParameter.getType();
        JavaClassifierType javaClassifierType = type instanceof JavaClassifierType ? (JavaClassifierType) type : null;
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifier classifier = javaClassifierType.getClassifier();
        return (classifier instanceof JavaClass) && (fqName = ((JavaClass) classifier).getFqName()) != null && b41.d(fqName.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0.equals("hashCode") == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0.equals("toString") == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        return r3.getValueParameters().isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean b(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r3) {
        /*
            tb.ni1 r0 = r3.getName()
            java.lang.String r0 = r0.b()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L3b
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L3b
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L3b
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
        L3b:
            r3 = 0
            goto L45
        L3d:
            java.util.List r3 = r3.getValueParameters()
            boolean r3 = r3.isEmpty()
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.j51.b(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod):boolean");
    }

    public static final boolean c(@NotNull JavaMember javaMember) {
        b41.i(javaMember, "<this>");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof JavaMethod) && b((JavaMethod) javaMember);
    }
}
