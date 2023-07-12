package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.ai2;
import tb.b41;
import tb.fn;
import tb.hq2;
import tb.ni1;
import tb.r81;
import tb.tg2;
import tb.z41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JavaDeprecatedAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] h = {a12.i(new PropertyReference1Impl(a12.b(JavaDeprecatedAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final NotNullLazyValue g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaDeprecatedAnnotationDescriptor(@Nullable JavaAnnotation javaAnnotation, @NotNull r81 r81Var) {
        super(r81Var, javaAnnotation, c.a.deprecated);
        b41.i(r81Var, com.huawei.hms.opendevice.c.a);
        this.g = r81Var.e().createLazyValue(new Function0<Map<ni1, ? extends ai2>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor$allValueArguments$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<ni1, ? extends ai2> invoke() {
                Map<ni1, ? extends ai2> f;
                f = w.f(hq2.a(z41.INSTANCE.b(), new ai2("Deprecated in Java")));
                return f;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        return (Map) tg2.a(this.g, this, h[0]);
    }
}
