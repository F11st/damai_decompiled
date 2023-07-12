package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.huawei.hms.opendevice.c;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.k;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.fd2;
import tb.fn;
import tb.hp0;
import tb.ni1;
import tb.r81;
import tb.tg2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] f = {a12.i(new PropertyReference1Impl(a12.b(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    @NotNull
    private final hp0 a;
    @NotNull
    private final SourceElement b;
    @NotNull
    private final NotNullLazyValue c;
    @Nullable
    private final JavaAnnotationArgument d;
    private final boolean e;

    public JavaAnnotationDescriptor(@NotNull final r81 r81Var, @Nullable JavaAnnotation javaAnnotation, @NotNull hp0 hp0Var) {
        Collection<JavaAnnotationArgument> arguments;
        b41.i(r81Var, c.a);
        b41.i(hp0Var, "fqName");
        this.a = hp0Var;
        JavaAnnotationArgument javaAnnotationArgument = null;
        SourceElement source = javaAnnotation == null ? null : r81Var.a().t().source(javaAnnotation);
        if (source == null) {
            source = SourceElement.NO_SOURCE;
            b41.h(source, "NO_SOURCE");
        }
        this.b = source;
        this.c = r81Var.e().createLazyValue(new Function0<fd2>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final fd2 invoke() {
                fd2 defaultType = r81.this.d().getBuiltIns().o(this.getFqName()).getDefaultType();
                b41.h(defaultType, "c.module.builtIns.getBui…qName(fqName).defaultType");
                return defaultType;
            }
        });
        if (javaAnnotation != null && (arguments = javaAnnotation.getArguments()) != null) {
            javaAnnotationArgument = (JavaAnnotationArgument) k.Q(arguments);
        }
        this.d = javaAnnotationArgument;
        boolean z = false;
        if (javaAnnotation != null && javaAnnotation.isIdeExternalAnnotation()) {
            z = true;
        }
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final JavaAnnotationArgument a() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    /* renamed from: b */
    public fd2 getType() {
        return (fd2) tg2.a(this.c, this, f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<ni1, fn<?>> getAllValueArguments() {
        Map<ni1, fn<?>> i;
        i = x.i();
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public hp0 getFqName() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SourceElement getSource() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.e;
    }
}
