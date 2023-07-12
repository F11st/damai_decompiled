package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.ni1;
import tb.x02;
import tb.z71;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty[] f = {a12.i(new PropertyReference1Impl(a12.b(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final x02.C9894a a;
    @NotNull
    private final x02.C9894a b;
    @NotNull
    private final KCallableImpl<?> c;
    private final int d;
    @NotNull
    private final KParameter.Kind e;

    public KParameterImpl(@NotNull KCallableImpl<?> kCallableImpl, int i, @NotNull KParameter.Kind kind, @NotNull Function0<? extends ParameterDescriptor> function0) {
        b41.i(kCallableImpl, "callable");
        b41.i(kind, "kind");
        b41.i(function0, "computeDescriptor");
        this.c = kCallableImpl;
        this.d = i;
        this.e = kind;
        this.a = x02.d(function0);
        this.b = x02.d(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$annotations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                ParameterDescriptor c;
                c = KParameterImpl.this.c();
                return zv2.e(c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParameterDescriptor c() {
        return (ParameterDescriptor) this.a.b(this, f[0]);
    }

    @NotNull
    public final KCallableImpl<?> b() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (b41.d(this.c, kParameterImpl.c) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return (List) this.b.b(this, f[1]);
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.d;
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind getKind() {
        return this.e;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        ParameterDescriptor c = c();
        if (!(c instanceof ValueParameterDescriptor)) {
            c = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) c;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        ni1 name = valueParameterDescriptor.getName();
        b41.h(name, "valueParameter.name");
        if (name.g()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KType getType() {
        z71 type = c().getType();
        b41.h(type, "descriptor.type");
        return new KTypeImpl(type, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$type$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Type invoke() {
                ParameterDescriptor c;
                c = KParameterImpl.this.c();
                if ((c instanceof ReceiverParameterDescriptor) && b41.d(zv2.i(KParameterImpl.this.b().i()), c) && KParameterImpl.this.b().i().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    DeclarationDescriptor containingDeclaration = KParameterImpl.this.b().i().getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> p = zv2.p((ClassDescriptor) containingDeclaration);
                    if (p != null) {
                        return p;
                    }
                    throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + c);
                }
                return KParameterImpl.this.b().f().getParameterTypes().get(KParameterImpl.this.getIndex());
            }
        });
    }

    public int hashCode() {
        return (this.c.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor c = c();
        if (!(c instanceof ValueParameterDescriptor)) {
            c = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) c;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.a(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor c = c();
        return (c instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) c).getVarargElementType() != null;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.f(this);
    }
}
