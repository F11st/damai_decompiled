package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hj;
import tb.hp0;
import tb.ip0;
import tb.kk;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c {
    @JvmField
    @NotNull
    public static final hp0 ANNOTATION_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final hp0 BUILT_INS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final Set<hp0> BUILT_INS_PACKAGE_FQ_NAMES;
    @JvmField
    @NotNull
    public static final ni1 BUILT_INS_PACKAGE_NAME;
    @JvmField
    @NotNull
    public static final ni1 CHAR_CODE;
    @JvmField
    @NotNull
    public static final hp0 COLLECTIONS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final hp0 CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final hp0 CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final hp0 COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final hp0 COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final hp0 COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final ni1 ENUM_VALUES;
    @JvmField
    @NotNull
    public static final ni1 ENUM_VALUE_OF;
    @NotNull
    public static final c INSTANCE = new c();
    @JvmField
    @NotNull
    public static final hp0 KOTLIN_REFLECT_FQ_NAME;
    @JvmField
    @NotNull
    public static final List<String> PREFIXES;
    @JvmField
    @NotNull
    public static final hp0 RANGES_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final hp0 RESULT_FQ_NAME;
    @JvmField
    @NotNull
    public static final hp0 TEXT_PACKAGE_FQ_NAME;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static final a INSTANCE;
        @JvmField
        @NotNull
        public static final ip0 _boolean;
        @JvmField
        @NotNull
        public static final ip0 _byte;
        @JvmField
        @NotNull
        public static final ip0 _char;
        @JvmField
        @NotNull
        public static final ip0 _double;
        @JvmField
        @NotNull
        public static final ip0 _enum;
        @JvmField
        @NotNull
        public static final ip0 _float;
        @JvmField
        @NotNull
        public static final ip0 _int;
        @JvmField
        @NotNull
        public static final ip0 _long;
        @JvmField
        @NotNull
        public static final ip0 _short;
        @JvmField
        @NotNull
        public static final hp0 annotation;
        @JvmField
        @NotNull
        public static final hp0 annotationRetention;
        @JvmField
        @NotNull
        public static final hp0 annotationTarget;
        @JvmField
        @NotNull
        public static final ip0 any;
        @JvmField
        @NotNull
        public static final ip0 array;
        @JvmField
        @NotNull
        public static final Map<ip0, PrimitiveType> arrayClassFqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final ip0 charSequence;
        @JvmField
        @NotNull
        public static final ip0 cloneable;
        @JvmField
        @NotNull
        public static final hp0 collection;
        @JvmField
        @NotNull
        public static final hp0 comparable;
        @JvmField
        @NotNull
        public static final hp0 deprecated;
        @JvmField
        @NotNull
        public static final hp0 deprecatedSinceKotlin;
        @JvmField
        @NotNull
        public static final hp0 deprecationLevel;
        @JvmField
        @NotNull
        public static final hp0 extensionFunctionType;
        @JvmField
        @NotNull
        public static final Map<ip0, PrimitiveType> fqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final ip0 functionSupertype;
        @JvmField
        @NotNull
        public static final ip0 intRange;
        @JvmField
        @NotNull
        public static final hp0 iterable;
        @JvmField
        @NotNull
        public static final hp0 iterator;
        @JvmField
        @NotNull
        public static final ip0 kCallable;
        @JvmField
        @NotNull
        public static final ip0 kClass;
        @JvmField
        @NotNull
        public static final ip0 kDeclarationContainer;
        @JvmField
        @NotNull
        public static final ip0 kMutableProperty0;
        @JvmField
        @NotNull
        public static final ip0 kMutableProperty1;
        @JvmField
        @NotNull
        public static final ip0 kMutableProperty2;
        @JvmField
        @NotNull
        public static final ip0 kMutablePropertyFqName;
        @JvmField
        @NotNull
        public static final hj kProperty;
        @JvmField
        @NotNull
        public static final ip0 kProperty0;
        @JvmField
        @NotNull
        public static final ip0 kProperty1;
        @JvmField
        @NotNull
        public static final ip0 kProperty2;
        @JvmField
        @NotNull
        public static final ip0 kPropertyFqName;
        @JvmField
        @NotNull
        public static final hp0 list;
        @JvmField
        @NotNull
        public static final hp0 listIterator;
        @JvmField
        @NotNull
        public static final ip0 longRange;
        @JvmField
        @NotNull
        public static final hp0 map;
        @JvmField
        @NotNull
        public static final hp0 mapEntry;
        @JvmField
        @NotNull
        public static final hp0 mustBeDocumented;
        @JvmField
        @NotNull
        public static final hp0 mutableCollection;
        @JvmField
        @NotNull
        public static final hp0 mutableIterable;
        @JvmField
        @NotNull
        public static final hp0 mutableIterator;
        @JvmField
        @NotNull
        public static final hp0 mutableList;
        @JvmField
        @NotNull
        public static final hp0 mutableListIterator;
        @JvmField
        @NotNull
        public static final hp0 mutableMap;
        @JvmField
        @NotNull
        public static final hp0 mutableMapEntry;
        @JvmField
        @NotNull
        public static final hp0 mutableSet;
        @JvmField
        @NotNull
        public static final ip0 nothing;
        @JvmField
        @NotNull
        public static final ip0 number;
        @JvmField
        @NotNull
        public static final hp0 parameterName;
        @JvmField
        @NotNull
        public static final Set<ni1> primitiveArrayTypeShortNames;
        @JvmField
        @NotNull
        public static final Set<ni1> primitiveTypeShortNames;
        @JvmField
        @NotNull
        public static final hp0 publishedApi;
        @JvmField
        @NotNull
        public static final hp0 repeatable;
        @JvmField
        @NotNull
        public static final hp0 replaceWith;
        @JvmField
        @NotNull
        public static final hp0 retention;
        @JvmField
        @NotNull
        public static final hp0 set;
        @JvmField
        @NotNull
        public static final ip0 string;
        @JvmField
        @NotNull
        public static final hp0 suppress;
        @JvmField
        @NotNull
        public static final hp0 target;
        @JvmField
        @NotNull
        public static final hp0 throwable;
        @JvmField
        @NotNull
        public static final hj uByte;
        @JvmField
        @NotNull
        public static final hp0 uByteArrayFqName;
        @JvmField
        @NotNull
        public static final hp0 uByteFqName;
        @JvmField
        @NotNull
        public static final hj uInt;
        @JvmField
        @NotNull
        public static final hp0 uIntArrayFqName;
        @JvmField
        @NotNull
        public static final hp0 uIntFqName;
        @JvmField
        @NotNull
        public static final hj uLong;
        @JvmField
        @NotNull
        public static final hp0 uLongArrayFqName;
        @JvmField
        @NotNull
        public static final hp0 uLongFqName;
        @JvmField
        @NotNull
        public static final hj uShort;
        @JvmField
        @NotNull
        public static final hp0 uShortArrayFqName;
        @JvmField
        @NotNull
        public static final hp0 uShortFqName;
        @JvmField
        @NotNull
        public static final ip0 unit;
        @JvmField
        @NotNull
        public static final hp0 unsafeVariance;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            any = aVar.d("Any");
            nothing = aVar.d("Nothing");
            cloneable = aVar.d("Cloneable");
            suppress = aVar.c("Suppress");
            unit = aVar.d("Unit");
            charSequence = aVar.d("CharSequence");
            string = aVar.d("String");
            array = aVar.d("Array");
            _boolean = aVar.d("Boolean");
            _char = aVar.d("Char");
            _byte = aVar.d("Byte");
            _short = aVar.d("Short");
            _int = aVar.d("Int");
            _long = aVar.d("Long");
            _float = aVar.d("Float");
            _double = aVar.d("Double");
            number = aVar.d("Number");
            _enum = aVar.d("Enum");
            functionSupertype = aVar.d("Function");
            throwable = aVar.c("Throwable");
            comparable = aVar.c("Comparable");
            intRange = aVar.e("IntRange");
            longRange = aVar.e("LongRange");
            deprecated = aVar.c("Deprecated");
            deprecatedSinceKotlin = aVar.c("DeprecatedSinceKotlin");
            deprecationLevel = aVar.c("DeprecationLevel");
            replaceWith = aVar.c("ReplaceWith");
            extensionFunctionType = aVar.c("ExtensionFunctionType");
            parameterName = aVar.c("ParameterName");
            annotation = aVar.c("Annotation");
            target = aVar.a("Target");
            annotationTarget = aVar.a("AnnotationTarget");
            annotationRetention = aVar.a("AnnotationRetention");
            retention = aVar.a("Retention");
            repeatable = aVar.a("Repeatable");
            mustBeDocumented = aVar.a("MustBeDocumented");
            unsafeVariance = aVar.c("UnsafeVariance");
            publishedApi = aVar.c("PublishedApi");
            iterator = aVar.b("Iterator");
            iterable = aVar.b("Iterable");
            collection = aVar.b("Collection");
            list = aVar.b("List");
            listIterator = aVar.b("ListIterator");
            set = aVar.b("Set");
            hp0 b = aVar.b("Map");
            map = b;
            hp0 c = b.c(ni1.f("Entry"));
            b41.h(c, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = c;
            mutableIterator = aVar.b("MutableIterator");
            mutableIterable = aVar.b("MutableIterable");
            mutableCollection = aVar.b("MutableCollection");
            mutableList = aVar.b("MutableList");
            mutableListIterator = aVar.b("MutableListIterator");
            mutableSet = aVar.b("MutableSet");
            hp0 b2 = aVar.b("MutableMap");
            mutableMap = b2;
            hp0 c2 = b2.c(ni1.f("MutableEntry"));
            b41.h(c2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = c2;
            kClass = f("KClass");
            kCallable = f("KCallable");
            kProperty0 = f("KProperty0");
            kProperty1 = f("KProperty1");
            kProperty2 = f("KProperty2");
            kMutableProperty0 = f("KMutableProperty0");
            kMutableProperty1 = f("KMutableProperty1");
            kMutableProperty2 = f("KMutableProperty2");
            ip0 f = f("KProperty");
            kPropertyFqName = f;
            kMutablePropertyFqName = f("KMutableProperty");
            hj m = hj.m(f.l());
            b41.h(m, "topLevel(kPropertyFqName.toSafe())");
            kProperty = m;
            kDeclarationContainer = f("KDeclarationContainer");
            hp0 c3 = aVar.c("UByte");
            uByteFqName = c3;
            hp0 c4 = aVar.c("UShort");
            uShortFqName = c4;
            hp0 c5 = aVar.c("UInt");
            uIntFqName = c5;
            hp0 c6 = aVar.c("ULong");
            uLongFqName = c6;
            hj m2 = hj.m(c3);
            b41.h(m2, "topLevel(uByteFqName)");
            uByte = m2;
            hj m3 = hj.m(c4);
            b41.h(m3, "topLevel(uShortFqName)");
            uShort = m3;
            hj m4 = hj.m(c5);
            b41.h(m4, "topLevel(uIntFqName)");
            uInt = m4;
            hj m5 = hj.m(c6);
            b41.h(m5, "topLevel(uLongFqName)");
            uLong = m5;
            uByteArrayFqName = aVar.c("UByteArray");
            uShortArrayFqName = aVar.c("UShortArray");
            uIntArrayFqName = aVar.c("UIntArray");
            uLongArrayFqName = aVar.c("ULongArray");
            HashSet f2 = kk.f(PrimitiveType.values().length);
            int i = 0;
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                f2.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = f2;
            HashSet f3 = kk.f(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                f3.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = f3;
            HashMap e = kk.e(PrimitiveType.values().length);
            PrimitiveType[] values = PrimitiveType.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                PrimitiveType primitiveType3 = values[i2];
                i2++;
                a aVar2 = INSTANCE;
                String b3 = primitiveType3.getTypeName().b();
                b41.h(b3, "primitiveType.typeName.asString()");
                e.put(aVar2.d(b3), primitiveType3);
            }
            fqNameToPrimitiveType = e;
            HashMap e2 = kk.e(PrimitiveType.values().length);
            PrimitiveType[] values2 = PrimitiveType.values();
            int length2 = values2.length;
            while (i < length2) {
                PrimitiveType primitiveType4 = values2[i];
                i++;
                a aVar3 = INSTANCE;
                String b4 = primitiveType4.getArrayTypeName().b();
                b41.h(b4, "primitiveType.arrayTypeName.asString()");
                e2.put(aVar3.d(b4), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = e2;
        }

        private a() {
        }

        private final hp0 a(String str) {
            hp0 c = c.ANNOTATION_PACKAGE_FQ_NAME.c(ni1.f(str));
            b41.h(c, "ANNOTATION_PACKAGE_FQ_NA…e.identifier(simpleName))");
            return c;
        }

        private final hp0 b(String str) {
            hp0 c = c.COLLECTIONS_PACKAGE_FQ_NAME.c(ni1.f(str));
            b41.h(c, "COLLECTIONS_PACKAGE_FQ_N…e.identifier(simpleName))");
            return c;
        }

        private final hp0 c(String str) {
            hp0 c = c.BUILT_INS_PACKAGE_FQ_NAME.c(ni1.f(str));
            b41.h(c, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(simpleName))");
            return c;
        }

        private final ip0 d(String str) {
            ip0 j = c(str).j();
            b41.h(j, "fqName(simpleName).toUnsafe()");
            return j;
        }

        private final ip0 e(String str) {
            ip0 j = c.RANGES_PACKAGE_FQ_NAME.c(ni1.f(str)).j();
            b41.h(j, "RANGES_PACKAGE_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return j;
        }

        @JvmStatic
        @NotNull
        public static final ip0 f(@NotNull String str) {
            b41.i(str, "simpleName");
            ip0 j = c.KOTLIN_REFLECT_FQ_NAME.c(ni1.f(str)).j();
            b41.h(j, "KOTLIN_REFLECT_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return j;
        }
    }

    static {
        List<String> j;
        Set<hp0> g;
        ni1 f = ni1.f("values");
        b41.h(f, "identifier(\"values\")");
        ENUM_VALUES = f;
        ni1 f2 = ni1.f("valueOf");
        b41.h(f2, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = f2;
        ni1 f3 = ni1.f("code");
        b41.h(f3, "identifier(\"code\")");
        CHAR_CODE = f3;
        hp0 hp0Var = new hp0("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME_RELEASE = hp0Var;
        hp0 c = hp0Var.c(ni1.f("experimental"));
        b41.h(c, "COROUTINES_PACKAGE_FQ_NA…entifier(\"experimental\"))");
        COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = c;
        hp0 c2 = c.c(ni1.f("intrinsics"));
        b41.h(c2, "COROUTINES_PACKAGE_FQ_NA…identifier(\"intrinsics\"))");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = c2;
        hp0 c3 = c.c(ni1.f("Continuation"));
        b41.h(c3, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = c3;
        hp0 c4 = hp0Var.c(ni1.f("Continuation"));
        b41.h(c4, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_RELEASE = c4;
        RESULT_FQ_NAME = new hp0("kotlin.Result");
        hp0 hp0Var2 = new hp0("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = hp0Var2;
        j = m.j("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
        PREFIXES = j;
        ni1 f4 = ni1.f("kotlin");
        b41.h(f4, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = f4;
        hp0 k = hp0.k(f4);
        b41.h(k, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = k;
        hp0 c5 = k.c(ni1.f("annotation"));
        b41.h(c5, "BUILT_INS_PACKAGE_FQ_NAM…identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = c5;
        hp0 c6 = k.c(ni1.f("collections"));
        b41.h(c6, "BUILT_INS_PACKAGE_FQ_NAM…dentifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = c6;
        hp0 c7 = k.c(ni1.f("ranges"));
        b41.h(c7, "BUILT_INS_PACKAGE_FQ_NAM…ame.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = c7;
        hp0 c8 = k.c(ni1.f("text"));
        b41.h(c8, "BUILT_INS_PACKAGE_FQ_NAM…(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = c8;
        hp0 c9 = k.c(ni1.f("internal"));
        b41.h(c9, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(\"internal\"))");
        g = e0.g(k, c6, c7, c5, hp0Var2, c9, hp0Var);
        BUILT_INS_PACKAGE_FQ_NAMES = g;
    }

    private c() {
    }

    @JvmStatic
    @NotNull
    public static final hj a(int i) {
        return new hj(BUILT_INS_PACKAGE_FQ_NAME, ni1.f(b(i)));
    }

    @JvmStatic
    @NotNull
    public static final String b(int i) {
        return b41.r("Function", Integer.valueOf(i));
    }

    @JvmStatic
    @NotNull
    public static final hp0 c(@NotNull PrimitiveType primitiveType) {
        b41.i(primitiveType, "primitiveType");
        hp0 c = BUILT_INS_PACKAGE_FQ_NAME.c(primitiveType.getTypeName());
        b41.h(c, "BUILT_INS_PACKAGE_FQ_NAM…d(primitiveType.typeName)");
        return c;
    }

    @JvmStatic
    @NotNull
    public static final String d(int i) {
        return b41.r(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i));
    }

    @JvmStatic
    public static final boolean e(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "arrayFqName");
        return a.arrayClassFqNameToPrimitiveType.get(ip0Var) != null;
    }
}
