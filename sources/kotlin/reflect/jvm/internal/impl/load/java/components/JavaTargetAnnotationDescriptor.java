package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;
import tb.fn;
import tb.hq2;
import tb.ni1;
import tb.r81;
import tb.tg2;
import tb.z41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JavaTargetAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] h = {a12.i(new PropertyReference1Impl(a12.b(JavaTargetAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final NotNullLazyValue g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTargetAnnotationDescriptor(@NotNull JavaAnnotation javaAnnotation, @NotNull r81 r81Var) {
        super(r81Var, javaAnnotation, c.a.target);
        b41.i(javaAnnotation, "annotation");
        b41.i(r81Var, com.huawei.hms.opendevice.c.a);
        this.g = r81Var.e().createLazyValue(new Function0<Map<ni1, ? extends fn<? extends Object>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor$allValueArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<ni1, ? extends fn<? extends Object>> invoke() {
                fn<?> fnVar;
                List<? extends JavaAnnotationArgument> e;
                Map<ni1, ? extends fn<? extends Object>> i;
                JavaAnnotationArgument a = JavaTargetAnnotationDescriptor.this.a();
                if (a instanceof JavaArrayAnnotationArgument) {
                    fnVar = JavaAnnotationTargetMapper.INSTANCE.c(((JavaArrayAnnotationArgument) JavaTargetAnnotationDescriptor.this.a()).getElements());
                } else if (a instanceof JavaEnumValueAnnotationArgument) {
                    JavaAnnotationTargetMapper javaAnnotationTargetMapper = JavaAnnotationTargetMapper.INSTANCE;
                    e = l.e(JavaTargetAnnotationDescriptor.this.a());
                    fnVar = javaAnnotationTargetMapper.c(e);
                } else {
                    fnVar = null;
                }
                Map<ni1, ? extends fn<? extends Object>> f = fnVar != null ? w.f(hq2.a(z41.INSTANCE.d(), fnVar)) : null;
                if (f != null) {
                    return f;
                }
                i = x.i();
                return i;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<Object>> getAllValueArguments() {
        return (Map) tg2.a(this.g, this, h[0]);
    }
}
