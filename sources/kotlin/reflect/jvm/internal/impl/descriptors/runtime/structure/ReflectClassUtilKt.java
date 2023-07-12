package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.aranger.constant.Constants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.b90;
import tb.hj;
import tb.hp0;
import tb.hq2;
import tb.ni1;
import tb.qb1;
import tb.r10;
import tb.s61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ReflectClassUtilKt {
    @NotNull
    private static final List<KClass<? extends Object>> a;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> b;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> c;
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> d;

    static {
        List<KClass<? extends Object>> j;
        int q;
        Map<Class<? extends Object>, Class<? extends Object>> r;
        int q2;
        Map<Class<? extends Object>, Class<? extends Object>> r2;
        List j2;
        int q3;
        Map<Class<? extends Function<?>>, Integer> r3;
        int i = 0;
        j = m.j(a12.b(Boolean.TYPE), a12.b(Byte.TYPE), a12.b(Character.TYPE), a12.b(Double.TYPE), a12.b(Float.TYPE), a12.b(Integer.TYPE), a12.b(Long.TYPE), a12.b(Short.TYPE));
        a = j;
        q = n.q(j, 10);
        ArrayList arrayList = new ArrayList(q);
        Iterator<T> it = j.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(hq2.a(s61.c(kClass), s61.d(kClass)));
        }
        r = x.r(arrayList);
        b = r;
        List<KClass<? extends Object>> list = a;
        q2 = n.q(list, 10);
        ArrayList arrayList2 = new ArrayList(q2);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            KClass kClass2 = (KClass) it2.next();
            arrayList2.add(hq2.a(s61.d(kClass2), s61.c(kClass2)));
        }
        r2 = x.r(arrayList2);
        c = r2;
        j2 = m.j(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        q3 = n.q(j2, 10);
        ArrayList arrayList3 = new ArrayList(q3);
        for (Object obj : j2) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            arrayList3.add(hq2.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        r3 = x.r(arrayList3);
        d = r3;
    }

    @NotNull
    public static final hj a(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    String simpleName = cls.getSimpleName();
                    b41.h(simpleName, "simpleName");
                    if (!(simpleName.length() == 0)) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        hj d2 = declaringClass == null ? null : a(declaringClass).d(ni1.f(cls.getSimpleName()));
                        if (d2 == null) {
                            d2 = hj.m(new hp0(cls.getName()));
                        }
                        b41.h(d2, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                        return d2;
                    }
                }
                hp0 hp0Var = new hp0(cls.getName());
                return new hj(hp0Var.e(), hp0.k(hp0Var.g()), true);
            }
            throw new IllegalArgumentException(b41.r("Can't compute ClassId for array type: ", cls));
        }
        throw new IllegalArgumentException(b41.r("Can't compute ClassId for primitive type: ", cls));
    }

    @NotNull
    public static final String b(@NotNull Class<?> cls) {
        String y;
        String y2;
        b41.i(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return "C";
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name.equals(Constants.VOID)) {
                        return "V";
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        return UTConstant.Args.UT_SUCCESS_F;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return ExifInterface.LATITUDE_SOUTH;
                    }
                    break;
            }
            throw new IllegalArgumentException(b41.r("Unsupported primitive type: ", cls));
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            b41.h(name2, "name");
            y2 = o.y(name2, '.', r10.DIR, false, 4, null);
            return y2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(qb1.LEVEL_L);
            String name3 = cls.getName();
            b41.h(name3, "name");
            y = o.y(name3, '.', r10.DIR, false, 4, null);
            sb.append(y);
            sb.append(b90.TokenSEM);
            return sb.toString();
        }
    }

    @Nullable
    public static final Integer c(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        return d.get(cls);
    }

    @NotNull
    public static final List<Type> d(@NotNull Type type) {
        List<Type> X;
        List<Type> g;
        b41.i(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            g = m.g();
            return g;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            b41.h(actualTypeArguments, "actualTypeArguments");
            X = ArraysKt___ArraysKt.X(actualTypeArguments);
            return X;
        }
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.h(type, new Function1<ParameterizedType, ParameterizedType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ParameterizedType invoke(@NotNull ParameterizedType parameterizedType2) {
                b41.i(parameterizedType2, AdvanceSetting.NETWORK_TYPE);
                Type ownerType = parameterizedType2.getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    return (ParameterizedType) ownerType;
                }
                return null;
            }
        }), new Function1<ParameterizedType, Sequence<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Sequence<Type> invoke(@NotNull ParameterizedType parameterizedType2) {
                Sequence<Type> o;
                b41.i(parameterizedType2, AdvanceSetting.NETWORK_TYPE);
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                b41.h(actualTypeArguments2, "it.actualTypeArguments");
                o = ArraysKt___ArraysKt.o(actualTypeArguments2);
                return o;
            }
        }));
    }

    @Nullable
    public static final Class<?> e(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        return b.get(cls);
    }

    @NotNull
    public static final ClassLoader f(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            b41.h(systemClassLoader, "getSystemClassLoader()");
            return systemClassLoader;
        }
        return classLoader;
    }

    @Nullable
    public static final Class<?> g(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        return c.get(cls);
    }

    public static final boolean h(@NotNull Class<?> cls) {
        b41.i(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
