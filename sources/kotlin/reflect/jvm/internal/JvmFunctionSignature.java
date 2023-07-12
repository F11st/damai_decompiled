package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.ul;
import tb.w61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class JvmFunctionSignature {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        @NotNull
        private final List<Method> a;
        @NotNull
        private final Class<?> b;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int a;
                Method method = (Method) t;
                b41.h(method, AdvanceSetting.NETWORK_TYPE);
                String name = method.getName();
                Method method2 = (Method) t2;
                b41.h(method2, AdvanceSetting.NETWORK_TYPE);
                a = ul.a(name, method2.getName());
                return a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeJavaAnnotationConstructor(@NotNull Class<?> cls) {
            super(null);
            List<Method> P;
            b41.i(cls, "jClass");
            this.b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            b41.h(declaredMethods, "jClass.declaredMethods");
            P = ArraysKt___ArraysKt.P(declaredMethods, new a());
            this.a = P;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            String Z;
            Z = CollectionsKt___CollectionsKt.Z(this.a, "", "<init>(", ")V", 0, null, new Function1<Method, CharSequence>() { // from class: kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(Method method) {
                    b41.h(method, AdvanceSetting.NETWORK_TYPE);
                    Class<?> returnType = method.getReturnType();
                    b41.h(returnType, "it.returnType");
                    return ReflectClassUtilKt.b(returnType);
                }
            }, 24, null);
            return Z;
        }

        @NotNull
        public final List<Method> b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class JavaConstructor extends JvmFunctionSignature {
        @NotNull
        private final Constructor<?> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaConstructor(@NotNull Constructor<?> constructor) {
            super(null);
            b41.i(constructor, "constructor");
            this.a = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            String F;
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            b41.h(parameterTypes, "constructor.parameterTypes");
            F = ArraysKt___ArraysKt.F(parameterTypes, "", "<init>(", ")V", 0, null, new Function1<Class<?>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor$asString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(Class<?> cls) {
                    b41.h(cls, AdvanceSetting.NETWORK_TYPE);
                    return ReflectClassUtilKt.b(cls);
                }
            }, 24, null);
            return F;
        }

        @NotNull
        public final Constructor<?> b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends JvmFunctionSignature {
        @NotNull
        private final Method a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Method method) {
            super(null);
            b41.i(method, "method");
            this.a = method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            String b;
            b = RuntimeTypeMapperKt.b(this.a);
            return b;
        }

        @NotNull
        public final Method b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends JvmFunctionSignature {
        private final String a;
        @NotNull
        private final w61.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull w61.b bVar) {
            super(null);
            b41.i(bVar, SocialOperation.GAME_SIGNATURE);
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final String b() {
            return this.b.b();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends JvmFunctionSignature {
        private final String a;
        @NotNull
        private final w61.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull w61.b bVar) {
            super(null);
            b41.i(bVar, SocialOperation.GAME_SIGNATURE);
            this.b = bVar;
            this.a = bVar.a();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final String b() {
            return this.b.b();
        }

        @NotNull
        public final String c() {
            return this.b.c();
        }
    }

    private JvmFunctionSignature() {
    }

    @NotNull
    public abstract String a();

    public /* synthetic */ JvmFunctionSignature(k50 k50Var) {
        this();
    }
}
