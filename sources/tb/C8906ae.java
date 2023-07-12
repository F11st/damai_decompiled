package tb;

import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: tb.ae */
/* loaded from: classes3.dex */
public final class C8906ae extends va2 {
    @NotNull
    public static final C8906ae INSTANCE = new C8906ae();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private C8906ae() {
        /*
            r14 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.c r1 = kotlin.reflect.jvm.internal.impl.protobuf.C8447c.d()
            tb.C9041de.a(r1)
            tb.wt2 r0 = tb.wt2.INSTANCE
            java.lang.String r0 = "newInstance().apply(Buil…f::registerAllExtensions)"
            tb.b41.h(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r2 = tb.C9041de.packageFqName
            java.lang.String r0 = "packageFqName"
            tb.b41.h(r2, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r3 = tb.C9041de.constructorAnnotation
            java.lang.String r0 = "constructorAnnotation"
            tb.b41.h(r3, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r4 = tb.C9041de.classAnnotation
            java.lang.String r0 = "classAnnotation"
            tb.b41.h(r4, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r5 = tb.C9041de.functionAnnotation
            java.lang.String r0 = "functionAnnotation"
            tb.b41.h(r5, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r6 = tb.C9041de.propertyAnnotation
            java.lang.String r0 = "propertyAnnotation"
            tb.b41.h(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r7 = tb.C9041de.propertyGetterAnnotation
            java.lang.String r0 = "propertyGetterAnnotation"
            tb.b41.h(r7, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r8 = tb.C9041de.propertySetterAnnotation
            java.lang.String r0 = "propertySetterAnnotation"
            tb.b41.h(r8, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r9 = tb.C9041de.enumEntryAnnotation
            java.lang.String r0 = "enumEntryAnnotation"
            tb.b41.h(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r10 = tb.C9041de.compileTimeValue
            java.lang.String r0 = "compileTimeValue"
            tb.b41.h(r10, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r11 = tb.C9041de.parameterAnnotation
            java.lang.String r0 = "parameterAnnotation"
            tb.b41.h(r11, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r12 = tb.C9041de.typeAnnotation
            java.lang.String r0 = "typeAnnotation"
            tb.b41.h(r12, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r13 = tb.C9041de.typeParameterAnnotation
            java.lang.String r0 = "typeParameterAnnotation"
            tb.b41.h(r13, r0)
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.C8906ae.<init>():void");
    }

    private final String o(hp0 hp0Var) {
        if (hp0Var.d()) {
            return "default-package";
        }
        String b = hp0Var.g().b();
        b41.h(b, "fqName.shortName().asString()");
        return b;
    }

    @NotNull
    public final String m(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return b41.r(o(hp0Var), ".kotlin_builtins");
    }

    @NotNull
    public final String n(@NotNull hp0 hp0Var) {
        String y;
        b41.i(hp0Var, "fqName");
        StringBuilder sb = new StringBuilder();
        String b = hp0Var.b();
        b41.h(b, "fqName.asString()");
        y = C8604o.y(b, '.', r10.DIR, false, 4, null);
        sb.append(y);
        sb.append(r10.DIR);
        sb.append(m(hp0Var));
        return sb.toString();
    }
}
