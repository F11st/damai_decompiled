package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.e;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.collections.q;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.f70;
import tb.l71;
import tb.s02;
import tb.s61;
import tb.ul;
import tb.x02;
import tb.z71;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final x02.a<List<Annotation>> a;
    private final x02.a<ArrayList<KParameter>> b;
    private final x02.a<KTypeImpl> c;
    private final x02.a<List<KTypeParameterImpl>> d;

    public KCallableImpl() {
        x02.a<List<Annotation>> d = x02.d(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_annotations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return zv2.e(KCallableImpl.this.i());
            }
        });
        b41.h(d, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.a = d;
        x02.a<ArrayList<KParameter>> d2 = x02.d(new Function0<ArrayList<KParameter>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1

            /* compiled from: Taobao */
            /* loaded from: classes3.dex */
            public static final class a<T> implements Comparator {
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int a;
                    a = ul.a(((KParameter) t).getName(), ((KParameter) t2).getName());
                    return a;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<KParameter> invoke() {
                int i;
                final CallableMemberDescriptor i2 = KCallableImpl.this.i();
                ArrayList<KParameter> arrayList = new ArrayList<>();
                final int i3 = 0;
                if (KCallableImpl.this.k()) {
                    i = 0;
                } else {
                    final ReceiverParameterDescriptor i4 = zv2.i(i2);
                    if (i4 != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, 0, KParameter.Kind.INSTANCE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    final ReceiverParameterDescriptor extensionReceiverParameter = i2.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i++;
                    }
                }
                List<ValueParameterDescriptor> valueParameters = i2.getValueParameters();
                b41.h(valueParameters, "descriptor.valueParameters");
                int size = valueParameters.size();
                while (i3 < size) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.VALUE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final ParameterDescriptor invoke() {
                            ValueParameterDescriptor valueParameterDescriptor = CallableMemberDescriptor.this.getValueParameters().get(i3);
                            b41.h(valueParameterDescriptor, "descriptor.valueParameters[i]");
                            return valueParameterDescriptor;
                        }
                    }));
                    i3++;
                    i++;
                }
                if (KCallableImpl.this.j() && (i2 instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                    q.u(arrayList, new a());
                }
                arrayList.trimToSize();
                return arrayList;
            }
        });
        b41.h(d2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.b = d2;
        x02.a<KTypeImpl> d3 = x02.d(new Function0<KTypeImpl>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KTypeImpl invoke() {
                z71 returnType = KCallableImpl.this.i().getReturnType();
                b41.f(returnType);
                b41.h(returnType, "descriptor.returnType!!");
                return new KTypeImpl(returnType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Type invoke() {
                        Type e;
                        e = KCallableImpl.this.e();
                        return e != null ? e : KCallableImpl.this.f().getReturnType();
                    }
                });
            }
        });
        b41.h(d3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.c = d3;
        x02.a<List<KTypeParameterImpl>> d4 = x02.d(new Function0<List<? extends KTypeParameterImpl>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_typeParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                int q;
                List<TypeParameterDescriptor> typeParameters = KCallableImpl.this.i().getTypeParameters();
                b41.h(typeParameters, "descriptor.typeParameters");
                q = n.q(typeParameters, 10);
                ArrayList arrayList = new ArrayList(q);
                for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
                    KCallableImpl kCallableImpl = KCallableImpl.this;
                    b41.h(typeParameterDescriptor, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
                }
                return arrayList;
            }
        });
        b41.h(d4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.d = d4;
    }

    private final R b(Map<KParameter, ? extends Object> map) {
        int q;
        Object d;
        List<KParameter> parameters = getParameters();
        q = n.q(parameters, 10);
        ArrayList arrayList = new ArrayList(q);
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                d = map.get(kParameter);
                if (d == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                d = null;
            } else if (!kParameter.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            } else {
                d = d(kParameter.getType());
            }
            arrayList.add(d);
        }
        Caller<?> h = h();
        if (h != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) h.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + i());
    }

    private final Object d(KType kType) {
        Class b = s61.b(l71.b(kType));
        if (b.isArray()) {
            Object newInstance = Array.newInstance(b.getComponentType(), 0);
            b41.h(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + b.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type e() {
        Type[] lowerBounds;
        CallableMemberDescriptor i = i();
        if (!(i instanceof FunctionDescriptor)) {
            i = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) i;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object d0 = k.d0(f().getParameterTypes());
        if (!(d0 instanceof ParameterizedType)) {
            d0 = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) d0;
        if (b41.d(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            b41.h(actualTypeArguments, "continuationType.actualTypeArguments");
            Object L = e.L(actualTypeArguments);
            if (!(L instanceof WildcardType)) {
                L = null;
            }
            WildcardType wildcardType = (WildcardType) L;
            if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
                return null;
            }
            return (Type) e.u(lowerBounds);
        }
        return null;
    }

    public final R c(@NotNull Map<KParameter, ? extends Object> map, @Nullable Continuation<?> continuation) {
        b41.i(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                Caller<?> h = h();
                if (h != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) h.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (IllegalAccessException e) {
                        throw new IllegalCallableAccessException(e);
                    }
                }
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + i());
            }
            KParameter next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(zv2.k(next.getType()) ? null : zv2.g(s02.a(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z = true;
            } else if (next.isVararg()) {
                arrayList.add(d(next.getType()));
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
            }
            if (next.getKind() == KParameter.Kind.VALUE) {
                i++;
            }
        }
    }

    @Override // kotlin.reflect.KCallable
    public R call(@NotNull Object... objArr) {
        b41.i(objArr, "args");
        try {
            return (R) f().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(@NotNull Map<KParameter, ? extends Object> map) {
        b41.i(map, "args");
        return j() ? b(map) : c(map, null);
    }

    @NotNull
    public abstract Caller<?> f();

    @NotNull
    public abstract KDeclarationContainerImpl g();

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this.a.invoke();
        b41.h(invoke, "_annotations()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this.b.invoke();
        b41.h(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public KType getReturnType() {
        KTypeImpl invoke = this.c.invoke();
        b41.h(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this.d.invoke();
        b41.h(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @Nullable
    public KVisibility getVisibility() {
        f70 visibility = i().getVisibility();
        b41.h(visibility, "descriptor.visibility");
        return zv2.q(visibility);
    }

    @Nullable
    public abstract Caller<?> h();

    @NotNull
    public abstract CallableMemberDescriptor i();

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return i().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return i().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return i().getModality() == Modality.OPEN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean j() {
        return b41.d(getName(), "<init>") && g().getJClass().isAnnotation();
    }

    public abstract boolean k();
}
