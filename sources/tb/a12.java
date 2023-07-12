package tb;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class a12 {
    private static final c12 a;
    private static final KClass[] b;

    static {
        c12 c12Var = null;
        try {
            c12Var = (c12) d12.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c12Var == null) {
            c12Var = new c12();
        }
        a = c12Var;
        b = new KClass[0];
    }

    public static KFunction a(FunctionReference functionReference) {
        return a.a(functionReference);
    }

    public static KClass b(Class cls) {
        return a.b(cls);
    }

    @SinceKotlin(version = "1.4")
    public static KDeclarationContainer c(Class cls) {
        return a.c(cls, "");
    }

    public static KDeclarationContainer d(Class cls, String str) {
        return a.c(cls, str);
    }

    public static KMutableProperty0 e(MutablePropertyReference0 mutablePropertyReference0) {
        return a.d(mutablePropertyReference0);
    }

    public static KMutableProperty1 f(MutablePropertyReference1 mutablePropertyReference1) {
        return a.e(mutablePropertyReference1);
    }

    public static KMutableProperty2 g(MutablePropertyReference2 mutablePropertyReference2) {
        return a.f(mutablePropertyReference2);
    }

    public static KProperty0 h(PropertyReference0 propertyReference0) {
        return a.g(propertyReference0);
    }

    public static KProperty1 i(PropertyReference1 propertyReference1) {
        return a.h(propertyReference1);
    }

    public static KProperty2 j(PropertyReference2 propertyReference2) {
        return a.i(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    public static String k(FunctionBase functionBase) {
        return a.j(functionBase);
    }

    @SinceKotlin(version = "1.1")
    public static String l(Lambda lambda) {
        return a.k(lambda);
    }
}
