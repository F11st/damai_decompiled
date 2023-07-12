package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.C8212k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.fr2;
import tb.k50;
import tb.k71;
import tb.l71;
import tb.s61;
import tb.x02;
import tb.z71;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KTypeImpl implements KTypeBase {
    static final /* synthetic */ KProperty[] e = {a12.i(new PropertyReference1Impl(a12.b(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), a12.i(new PropertyReference1Impl(a12.b(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final x02.C9894a<Type> a;
    @Nullable
    private final x02.C9894a b;
    @NotNull
    private final x02.C9894a c;
    @NotNull
    private final z71 d;

    public KTypeImpl(@NotNull z71 z71Var, @Nullable Function0<? extends Type> function0) {
        b41.i(z71Var, "type");
        this.d = z71Var;
        x02.C9894a<Type> c9894a = null;
        x02.C9894a<Type> c9894a2 = (x02.C9894a) (!(function0 instanceof x02.C9894a) ? null : function0);
        if (c9894a2 != null) {
            c9894a = c9894a2;
        } else if (function0 != null) {
            c9894a = x02.d(function0);
        }
        this.a = c9894a;
        this.b = x02.d(new Function0<KClassifier>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$classifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final KClassifier invoke() {
                KClassifier b;
                KTypeImpl kTypeImpl = KTypeImpl.this;
                b = kTypeImpl.b(kTypeImpl.c());
                return b;
            }
        });
        this.c = x02.d(new KTypeImpl$arguments$2(this, function0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KClassifier b(z71 z71Var) {
        z71 type;
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> p = zv2.p((ClassDescriptor) declarationDescriptor);
            if (p != null) {
                if (p.isArray()) {
                    TypeProjection typeProjection = (TypeProjection) C8212k.s0(z71Var.b());
                    if (typeProjection != null && (type = typeProjection.getType()) != null) {
                        b41.h(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
                        KClassifier b = b(type);
                        if (b != null) {
                            return new KClassImpl(zv2.f(s61.b(l71.a(b))));
                        }
                        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                    }
                    return new KClassImpl(p);
                } else if (!fr2.m(z71Var)) {
                    Class<?> e2 = ReflectClassUtilKt.e(p);
                    if (e2 != null) {
                        p = e2;
                    }
                    return new KClassImpl(p);
                } else {
                    return new KClassImpl(p);
                }
            }
            return null;
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
        } else {
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
            }
            return null;
        }
    }

    @NotNull
    public final z71 c() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KTypeImpl) && b41.d(this.d, ((KTypeImpl) obj).d);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return zv2.e(this.d);
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<k71> getArguments() {
        return (List) this.c.b(this, e[1]);
    }

    @Override // kotlin.reflect.KType
    @Nullable
    public KClassifier getClassifier() {
        return (KClassifier) this.b.b(this, e[0]);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    @Nullable
    public Type getJavaType() {
        x02.C9894a<Type> c9894a = this.a;
        if (c9894a != null) {
            return c9894a.invoke();
        }
        return null;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.d.d();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.h(this.d);
    }

    public /* synthetic */ KTypeImpl(z71 z71Var, Function0 function0, int i, k50 k50Var) {
        this(z71Var, (i & 2) != 0 ? null : function0);
    }
}
