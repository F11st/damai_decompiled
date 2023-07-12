package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8214m;
import kotlin.collections.C8226x;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.ai2;
import tb.b41;
import tb.d6;
import tb.fd2;
import tb.hj;
import tb.hp0;
import tb.hq2;
import tb.ni1;
import tb.xe0;
import tb.y7;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AnnotationUtilKt {
    @NotNull
    private static final ni1 a;
    @NotNull
    private static final ni1 b;
    @NotNull
    private static final ni1 c;
    @NotNull
    private static final ni1 d;
    @NotNull
    private static final ni1 e;

    static {
        ni1 f = ni1.f("message");
        b41.h(f, "identifier(\"message\")");
        a = f;
        ni1 f2 = ni1.f("replaceWith");
        b41.h(f2, "identifier(\"replaceWith\")");
        b = f2;
        ni1 f3 = ni1.f("level");
        b41.h(f3, "identifier(\"level\")");
        c = f3;
        ni1 f4 = ni1.f(DXTraceUtil.TYPE_EXPRESSION_STRING);
        b41.h(f4, "identifier(\"expression\")");
        d = f4;
        ni1 f5 = ni1.f("imports");
        b41.h(f5, "identifier(\"imports\")");
        e = f5;
    }

    @NotNull
    public static final AnnotationDescriptor a(@NotNull final AbstractC8271b abstractC8271b, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        List g;
        Map l;
        Map l2;
        b41.i(abstractC8271b, "<this>");
        b41.i(str, "message");
        b41.i(str2, "replaceWith");
        b41.i(str3, "level");
        hp0 hp0Var = C8277c.C8278a.replaceWith;
        ni1 ni1Var = e;
        g = C8214m.g();
        l = C8226x.l(hq2.a(d, new ai2(str2)), hq2.a(ni1Var, new y7(g, new Function1<ModuleDescriptor, z71>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final z71 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                b41.i(moduleDescriptor, "module");
                fd2 l3 = moduleDescriptor.getBuiltIns().l(Variance.INVARIANT, AbstractC8271b.this.W());
                b41.h(l3, "module.builtIns.getArray…ce.INVARIANT, stringType)");
                return l3;
            }
        })));
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(abstractC8271b, hp0Var, l);
        hp0 hp0Var2 = C8277c.C8278a.deprecated;
        ni1 ni1Var2 = c;
        hj m = hj.m(C8277c.C8278a.deprecationLevel);
        b41.h(m, "topLevel(StandardNames.FqNames.deprecationLevel)");
        ni1 f = ni1.f(str3);
        b41.h(f, "identifier(level)");
        l2 = C8226x.l(hq2.a(a, new ai2(str)), hq2.a(b, new d6(builtInAnnotationDescriptor)), hq2.a(ni1Var2, new xe0(m, f)));
        return new BuiltInAnnotationDescriptor(abstractC8271b, hp0Var2, l2);
    }

    public static /* synthetic */ AnnotationDescriptor b(AbstractC8271b abstractC8271b, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return a(abstractC8271b, str, str2, str3);
    }
}
