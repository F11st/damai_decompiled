package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8215n;
import kotlin.collections.C8220r;
import kotlin.collections.C8226x;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a70;
import tb.b41;
import tb.fd2;
import tb.fn;
import tb.hj;
import tb.hq2;
import tb.kf0;
import tb.ni1;
import tb.xe0;
import tb.y7;
import tb.z41;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper {
    @NotNull
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> a;
    @NotNull
    private static final Map<String, KotlinRetention> b;

    static {
        Map<String, EnumSet<KotlinTarget>> l;
        Map<String, KotlinRetention> l2;
        l = C8226x.l(hq2.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), hq2.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), hq2.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), hq2.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), hq2.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), hq2.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), hq2.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), hq2.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), hq2.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), hq2.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
        a = l;
        l2 = C8226x.l(hq2.a("RUNTIME", KotlinRetention.RUNTIME), hq2.a("CLASS", KotlinRetention.BINARY), hq2.a("SOURCE", KotlinRetention.SOURCE));
        b = l2;
    }

    private JavaAnnotationTargetMapper() {
    }

    @Nullable
    public final fn<?> a(@Nullable JavaAnnotationArgument javaAnnotationArgument) {
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument ? (JavaEnumValueAnnotationArgument) javaAnnotationArgument : null;
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = b;
        ni1 entryName = javaEnumValueAnnotationArgument.getEntryName();
        KotlinRetention kotlinRetention = map.get(entryName == null ? null : entryName.b());
        if (kotlinRetention == null) {
            return null;
        }
        hj m = hj.m(C8277c.C8278a.annotationRetention);
        b41.h(m, "topLevel(StandardNames.F…ames.annotationRetention)");
        ni1 f = ni1.f(kotlinRetention.name());
        b41.h(f, "identifier(retention.name)");
        return new xe0(m, f);
    }

    @NotNull
    public final Set<KotlinTarget> b(@Nullable String str) {
        Set<KotlinTarget> d;
        EnumSet<KotlinTarget> enumSet = a.get(str);
        if (enumSet == null) {
            d = C8203e0.d();
            return d;
        }
        return enumSet;
    }

    @NotNull
    public final fn<?> c(@NotNull List<? extends JavaAnnotationArgument> list) {
        int q;
        b41.i(list, "arguments");
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument : arrayList) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = INSTANCE;
            ni1 entryName = javaEnumValueAnnotationArgument.getEntryName();
            C8220r.v(arrayList2, javaAnnotationTargetMapper.b(entryName == null ? null : entryName.b()));
        }
        q = C8215n.q(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(q);
        for (KotlinTarget kotlinTarget : arrayList2) {
            hj m = hj.m(C8277c.C8278a.annotationTarget);
            b41.h(m, "topLevel(StandardNames.FqNames.annotationTarget)");
            ni1 f = ni1.f(kotlinTarget.name());
            b41.h(f, "identifier(kotlinTarget.name)");
            arrayList3.add(new xe0(m, f));
        }
        return new y7(arrayList3, new Function1<ModuleDescriptor, z71>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper$mapJavaTargetArguments$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final z71 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                b41.i(moduleDescriptor, "module");
                ValueParameterDescriptor b2 = a70.b(z41.INSTANCE.d(), moduleDescriptor.getBuiltIns().o(C8277c.C8278a.target));
                z71 type = b2 == null ? null : b2.getType();
                if (type == null) {
                    fd2 j = kf0.j("Error: AnnotationTarget[]");
                    b41.h(j, "createErrorType(\"Error: AnnotationTarget[]\")");
                    return j;
                }
                return type;
            }
        });
    }
}
