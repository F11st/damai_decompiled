package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.huawei.hms.opendevice.AbstractC5658c;
import java.util.Map;
import kotlin.collections.C8225w;
import kotlin.collections.C8226x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
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
public final class JavaRetentionAnnotationDescriptor extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] h = {a12.i(new PropertyReference1Impl(a12.b(JavaRetentionAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull
    private final NotNullLazyValue g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor(@NotNull JavaAnnotation javaAnnotation, @NotNull r81 r81Var) {
        super(r81Var, javaAnnotation, C8277c.C8278a.retention);
        b41.i(javaAnnotation, "annotation");
        b41.i(r81Var, AbstractC5658c.a);
        this.g = r81Var.e().createLazyValue(new Function0<Map<ni1, ? extends fn<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor$allValueArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<ni1, ? extends fn<?>> invoke() {
                Map<ni1, ? extends fn<?>> i;
                fn<?> a = JavaAnnotationTargetMapper.INSTANCE.a(JavaRetentionAnnotationDescriptor.this.a());
                Map<ni1, ? extends fn<?>> f = a == null ? null : C8225w.f(hq2.a(z41.INSTANCE.c(), a));
                if (f != null) {
                    return f;
                }
                i = C8226x.i();
                return i;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        return (Map) tg2.a(this.g, this, h[0]);
    }
}
