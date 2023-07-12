package tb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8205f0;
import kotlin.collections.C8214m;
import kotlin.collections.C8220r;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r61 {
    @NotNull
    public static final r61 INSTANCE;
    @NotNull
    private static final Set<String> a;
    @NotNull
    private static final Set<String> b;
    @NotNull
    private static final Set<String> c;
    @NotNull
    private static final Set<String> d;
    @NotNull
    private static final Set<String> e;
    @NotNull
    private static final Set<String> f;

    static {
        Set<String> j;
        Set i;
        Set i2;
        Set i3;
        Set i4;
        Set i5;
        Set<String> i6;
        Set i7;
        Set i8;
        Set i9;
        Set i10;
        Set i11;
        Set<String> i12;
        Set i13;
        Set<String> i14;
        Set i15;
        Set<String> i16;
        r61 r61Var = new r61();
        INSTANCE = r61Var;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        j = C8205f0.j(signatureBuildingComponents.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        a = j;
        i = C8205f0.i(r61Var.b(), signatureBuildingComponents.f("List", "sort(Ljava/util/Comparator;)V"));
        i2 = C8205f0.i(i, signatureBuildingComponents.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        i3 = C8205f0.i(i2, signatureBuildingComponents.e("Double", "isInfinite()Z", "isNaN()Z"));
        i4 = C8205f0.i(i3, signatureBuildingComponents.e("Float", "isInfinite()Z", "isNaN()Z"));
        i5 = C8205f0.i(i4, signatureBuildingComponents.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        i6 = C8205f0.i(i5, signatureBuildingComponents.e("CharSequence", "isEmpty()Z"));
        b = i6;
        i7 = C8205f0.i(signatureBuildingComponents.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), signatureBuildingComponents.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        i8 = C8205f0.i(i7, signatureBuildingComponents.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        i9 = C8205f0.i(i8, signatureBuildingComponents.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        i10 = C8205f0.i(i9, signatureBuildingComponents.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        i11 = C8205f0.i(i10, signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        i12 = C8205f0.i(i11, signatureBuildingComponents.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        c = i12;
        i13 = C8205f0.i(signatureBuildingComponents.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), signatureBuildingComponents.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        i14 = C8205f0.i(i13, signatureBuildingComponents.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        d = i14;
        Set<String> a2 = r61Var.a();
        String[] b2 = signatureBuildingComponents.b("D");
        i15 = C8205f0.i(a2, signatureBuildingComponents.e("Float", (String[]) Arrays.copyOf(b2, b2.length)));
        String[] b3 = signatureBuildingComponents.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        i16 = C8205f0.i(i15, signatureBuildingComponents.e("String", (String[]) Arrays.copyOf(b3, b3.length)));
        e = i16;
        String[] b4 = signatureBuildingComponents.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f = signatureBuildingComponents.e("Throwable", (String[]) Arrays.copyOf(b4, b4.length));
    }

    private r61() {
    }

    private final Set<String> a() {
        List<JvmPrimitiveType> j;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        j = C8214m.j(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType2 : j) {
            String b2 = jvmPrimitiveType2.getWrapperFqName().g().b();
            b41.h(b2, "it.wrapperFqName.shortName().asString()");
            String[] b3 = signatureBuildingComponents.b("Ljava/lang/String;");
            C8220r.v(linkedHashSet, signatureBuildingComponents.e(b2, (String[]) Arrays.copyOf(b3, b3.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        List<JvmPrimitiveType> j;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        j = C8214m.j(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : j) {
            String b2 = jvmPrimitiveType.getWrapperFqName().g().b();
            b41.h(b2, "it.wrapperFqName.shortName().asString()");
            C8220r.v(linkedHashSet, signatureBuildingComponents.e(b2, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> c() {
        return a;
    }

    @NotNull
    public final Set<String> d() {
        return e;
    }

    @NotNull
    public final Set<String> e() {
        return b;
    }

    @NotNull
    public final Set<String> f() {
        return d;
    }

    @NotNull
    public final Set<String> g() {
        return f;
    }

    @NotNull
    public final Set<String> h() {
        return c;
    }

    public final boolean i(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "fqName");
        return b41.d(ip0Var, C8277c.C8278a.array) || C8277c.e(ip0Var);
    }

    public final boolean j(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "fqName");
        if (i(ip0Var)) {
            return true;
        }
        hj o = o51.INSTANCE.o(ip0Var);
        if (o == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(o.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
