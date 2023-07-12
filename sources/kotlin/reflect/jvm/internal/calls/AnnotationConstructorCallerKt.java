package kotlin.reflect.jvm.internal.calls;

import com.alipay.sdk.m.n.a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;
import tb.jn1;
import tb.s61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements InvocationHandler {
        final /* synthetic */ Class a;
        final /* synthetic */ Lazy b;
        final /* synthetic */ KProperty c;
        final /* synthetic */ Lazy d;
        final /* synthetic */ KProperty e;
        final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$2 f;
        final /* synthetic */ Map g;

        a(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2, Map map) {
            this.a = cls;
            this.b = lazy;
            this.c = kProperty;
            this.d = lazy2;
            this.e = kProperty2;
            this.f = annotationConstructorCallerKt$createAnnotationInstance$2;
            this.g = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            List X;
            b41.h(method, "method");
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return this.d.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.b.getValue();
                }
            }
            if (b41.d(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.f.invoke2(e.L(objArr)));
            }
            if (this.g.containsKey(name)) {
                return this.g.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            X = ArraysKt___ArraysKt.X(objArr);
            sb.append(X);
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    @NotNull
    public static final <T> T c(@NotNull final Class<T> cls, @NotNull final Map<String, ? extends Object> map, @NotNull List<Method> list) {
        Lazy b;
        Lazy b2;
        b41.i(cls, "annotationClass");
        b41.i(map, "values");
        b41.i(list, "methods");
        AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, list, map);
        b = b.b(new Function0<Integer>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                int hashCode;
                int i = 0;
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof boolean[]) {
                        hashCode = Arrays.hashCode((boolean[]) value);
                    } else if (value instanceof char[]) {
                        hashCode = Arrays.hashCode((char[]) value);
                    } else if (value instanceof byte[]) {
                        hashCode = Arrays.hashCode((byte[]) value);
                    } else if (value instanceof short[]) {
                        hashCode = Arrays.hashCode((short[]) value);
                    } else if (value instanceof int[]) {
                        hashCode = Arrays.hashCode((int[]) value);
                    } else if (value instanceof float[]) {
                        hashCode = Arrays.hashCode((float[]) value);
                    } else if (value instanceof long[]) {
                        hashCode = Arrays.hashCode((long[]) value);
                    } else if (value instanceof double[]) {
                        hashCode = Arrays.hashCode((double[]) value);
                    } else {
                        hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                    }
                    i += hashCode ^ (str.hashCode() * 127);
                }
                return i;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }
        });
        b2 = b.b(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                sb.append(cls.getCanonicalName());
                CollectionsKt___CollectionsKt.X(map.entrySet(), sb, AVFSCacheConstants.COMMA_SEP, jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, new Function1<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1
                    @NotNull
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final CharSequence invoke2(@NotNull Map.Entry<String, ? extends Object> entry) {
                        String arrays;
                        b41.i(entry, "entry");
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof boolean[]) {
                            arrays = Arrays.toString((boolean[]) value);
                        } else if (value instanceof char[]) {
                            arrays = Arrays.toString((char[]) value);
                        } else if (value instanceof byte[]) {
                            arrays = Arrays.toString((byte[]) value);
                        } else if (value instanceof short[]) {
                            arrays = Arrays.toString((short[]) value);
                        } else if (value instanceof int[]) {
                            arrays = Arrays.toString((int[]) value);
                        } else if (value instanceof float[]) {
                            arrays = Arrays.toString((float[]) value);
                        } else if (value instanceof long[]) {
                            arrays = Arrays.toString((long[]) value);
                        } else if (value instanceof double[]) {
                            arrays = Arrays.toString((double[]) value);
                        } else {
                            arrays = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
                        }
                        return key + a.h + arrays;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                        return invoke2((Map.Entry<String, ? extends Object>) entry);
                    }
                }, 48, null);
                String sb2 = sb.toString();
                b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        });
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls, b2, null, b, null, annotationConstructorCallerKt$createAnnotationInstance$2, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object d(Class cls, Map map, List list, int i, Object obj) {
        int q;
        if ((i & 4) != 0) {
            Set<String> keySet = map.keySet();
            q = n.q(keySet, 10);
            ArrayList arrayList = new ArrayList(q);
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return c(cls, map, list);
    }

    public static final Void e(int i, String str, Class<?> cls) {
        KClass e;
        String qualifiedName;
        if (b41.d(cls, Class.class)) {
            e = a12.b(KClass.class);
        } else if (cls.isArray() && b41.d(cls.getComponentType(), Class.class)) {
            e = a12.b(KClass[].class);
        } else {
            e = s61.e(cls);
        }
        if (b41.d(e.getQualifiedName(), a12.b(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getQualifiedName());
            sb.append('<');
            Class<?> componentType = s61.b(e).getComponentType();
            b41.h(componentType, "kotlinClass.java.componentType");
            sb.append(s61.e(componentType).getQualifiedName());
            sb.append('>');
            qualifiedName = sb.toString();
        } else {
            qualifiedName = e.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + qualifiedName);
    }

    public static final Object f(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = s61.b((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(s61.b(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
