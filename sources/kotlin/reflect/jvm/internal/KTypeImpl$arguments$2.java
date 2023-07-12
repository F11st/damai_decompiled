package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.collections.e;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.i71;
import tb.k71;
import tb.z71;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Ltb/k71;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends k71>> {
    final /* synthetic */ Function0 $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0 function0) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends k71> invoke() {
        final Lazy a;
        int q;
        k71 d;
        List<? extends k71> g;
        List<TypeProjection> b = this.this$0.c().b();
        if (b.isEmpty()) {
            g = m.g();
            return g;
        }
        a = b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<List<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$parameterizedTypeArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Type> invoke() {
                Type javaType = KTypeImpl$arguments$2.this.this$0.getJavaType();
                b41.f(javaType);
                return ReflectClassUtilKt.d(javaType);
            }
        });
        q = n.q(b, 10);
        ArrayList arrayList = new ArrayList(q);
        final int i = 0;
        for (Object obj : b) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                d = k71.Companion.c();
            } else {
                z71 type = typeProjection.getType();
                b41.h(type, "typeProjection.type");
                KTypeImpl kTypeImpl = new KTypeImpl(type, this.$computeJavaType != null ? new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Type invoke() {
                        Type javaType = this.this$0.getJavaType();
                        if (javaType instanceof Class) {
                            Class cls = (Class) javaType;
                            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                            b41.h(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                            return componentType;
                        } else if (javaType instanceof GenericArrayType) {
                            if (i == 0) {
                                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                                b41.h(genericComponentType, "javaType.genericComponentType");
                                return genericComponentType;
                            }
                            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0);
                        } else if (javaType instanceof ParameterizedType) {
                            Type type2 = (Type) ((List) a.getValue()).get(i);
                            if (type2 instanceof WildcardType) {
                                WildcardType wildcardType = (WildcardType) type2;
                                Type[] lowerBounds = wildcardType.getLowerBounds();
                                b41.h(lowerBounds, "argument.lowerBounds");
                                Type type3 = (Type) e.v(lowerBounds);
                                if (type3 != null) {
                                    type2 = type3;
                                } else {
                                    Type[] upperBounds = wildcardType.getUpperBounds();
                                    b41.h(upperBounds, "argument.upperBounds");
                                    type2 = (Type) e.u(upperBounds);
                                }
                            }
                            b41.h(type2, "if (argument !is Wildcar…ument.upperBounds.first()");
                            return type2;
                        } else {
                            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0);
                        }
                    }
                } : null);
                int i3 = i71.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i3 == 1) {
                    d = k71.Companion.d(kTypeImpl);
                } else if (i3 == 2) {
                    d = k71.Companion.a(kTypeImpl);
                } else if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    d = k71.Companion.b(kTypeImpl);
                }
            }
            arrayList.add(d);
            i = i2;
        }
        return arrayList;
    }
}
