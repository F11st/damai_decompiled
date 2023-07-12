package kotlin.reflect.jvm.internal.impl.load.java;

import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.f0;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gn1;
import tb.hq2;
import tb.k50;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SpecialGenericSignatures {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final List<a.C0416a> a;
    @NotNull
    private static final List<String> b;
    @NotNull
    private static final Map<a.C0416a, TypeSafeBarrierDescription> c;
    @NotNull
    private static final Map<String, TypeSafeBarrierDescription> d;
    @NotNull
    private static final Set<ni1> e;
    @NotNull
    private static final Set<String> f;
    @NotNull
    private static final a.C0416a g;
    @NotNull
    private static final Map<a.C0416a, ni1> h;
    @NotNull
    private static final Map<String, ni1> i;
    @NotNull
    private static final List<ni1> j;
    @NotNull
    private static final Map<ni1, List<ni1>> k;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        @Nullable
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class TypeSafeBarrierDescription {
        @Nullable
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = $values();

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null, null);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        private TypeSafeBarrierDescription(String str, int i, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, k50 k50Var) {
            this(str, i, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0416a {
            @NotNull
            private final ni1 a;
            @NotNull
            private final String b;

            public C0416a(@NotNull ni1 ni1Var, @NotNull String str) {
                b41.i(ni1Var, "name");
                b41.i(str, SocialOperation.GAME_SIGNATURE);
                this.a = ni1Var;
                this.b = str;
            }

            @NotNull
            public final ni1 a() {
                return this.a;
            }

            @NotNull
            public final String b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0416a) {
                    C0416a c0416a = (C0416a) obj;
                    return b41.d(this.a, c0416a.a) && b41.d(this.b, c0416a.b);
                }
                return false;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0416a m(String str, String str2, String str3, String str4) {
            ni1 f = ni1.f(str2);
            b41.h(f, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new C0416a(f, signatureBuildingComponents.k(str, str2 + '(' + str3 + ')' + str4));
        }

        @NotNull
        public final List<ni1> b(@NotNull ni1 ni1Var) {
            List<ni1> g;
            b41.i(ni1Var, "name");
            List<ni1> list = f().get(ni1Var);
            if (list == null) {
                g = m.g();
                return g;
            }
            return list;
        }

        @NotNull
        public final List<String> c() {
            return SpecialGenericSignatures.b;
        }

        @NotNull
        public final Set<ni1> d() {
            return SpecialGenericSignatures.e;
        }

        @NotNull
        public final Set<String> e() {
            return SpecialGenericSignatures.f;
        }

        @NotNull
        public final Map<ni1, List<ni1>> f() {
            return SpecialGenericSignatures.k;
        }

        @NotNull
        public final List<ni1> g() {
            return SpecialGenericSignatures.j;
        }

        @NotNull
        public final C0416a h() {
            return SpecialGenericSignatures.g;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> i() {
            return SpecialGenericSignatures.d;
        }

        @NotNull
        public final Map<String, ni1> j() {
            return SpecialGenericSignatures.i;
        }

        public final boolean k(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "<this>");
            return g().contains(ni1Var);
        }

        @NotNull
        public final SpecialSignatureInfo l(@NotNull String str) {
            b41.i(str, "builtinSignature");
            if (c().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) u.j(i(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    static {
        Set<String> g2;
        int q;
        int q2;
        int q3;
        Map<a.C0416a, TypeSafeBarrierDescription> l;
        int e2;
        Set<a.C0416a> i2;
        int q4;
        Set<ni1> E0;
        int q5;
        Set<String> E02;
        Map<a.C0416a, ni1> l2;
        int e3;
        int q6;
        int q7;
        g2 = e0.g("containsAll", "removeAll", "retainAll");
        q = n.q(g2, 10);
        ArrayList<a.C0416a> arrayList = new ArrayList(q);
        for (String str : g2) {
            a aVar = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            b41.h(desc, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        a = arrayList;
        q2 = n.q(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(q2);
        for (a.C0416a c0416a : arrayList) {
            arrayList2.add(c0416a.b());
        }
        b = arrayList2;
        List<a.C0416a> list = a;
        q3 = n.q(list, 10);
        ArrayList arrayList3 = new ArrayList(q3);
        for (a.C0416a c0416a2 : list) {
            arrayList3.add(c0416a2.a().b());
        }
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        a aVar2 = Companion;
        String i3 = signatureBuildingComponents.i("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        b41.h(desc2, "BOOLEAN.desc");
        a.C0416a m = aVar2.m(i3, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String i4 = signatureBuildingComponents.i("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        b41.h(desc3, "BOOLEAN.desc");
        String i5 = signatureBuildingComponents.i("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        b41.h(desc4, "BOOLEAN.desc");
        String i6 = signatureBuildingComponents.i("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        b41.h(desc5, "BOOLEAN.desc");
        String i7 = signatureBuildingComponents.i("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        b41.h(desc6, "BOOLEAN.desc");
        a.C0416a m2 = aVar2.m(signatureBuildingComponents.i("Map"), gn1.TYPE_OPEN_URL_METHOD_GET, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String i8 = signatureBuildingComponents.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        b41.h(desc7, "INT.desc");
        a.C0416a m3 = aVar2.m(i8, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String i9 = signatureBuildingComponents.i("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        b41.h(desc8, "INT.desc");
        l = x.l(hq2.a(m, typeSafeBarrierDescription), hq2.a(aVar2.m(i4, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), hq2.a(aVar2.m(i5, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), hq2.a(aVar2.m(i6, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), hq2.a(aVar2.m(i7, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), hq2.a(aVar2.m(signatureBuildingComponents.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), hq2.a(m2, typeSafeBarrierDescription2), hq2.a(aVar2.m(signatureBuildingComponents.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), hq2.a(m3, typeSafeBarrierDescription3), hq2.a(aVar2.m(i9, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        c = l;
        e2 = w.e(l.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(e2);
        Iterator<T> it = l.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((a.C0416a) entry.getKey()).b(), entry.getValue());
        }
        d = linkedHashMap;
        i2 = f0.i(c.keySet(), a);
        q4 = n.q(i2, 10);
        ArrayList arrayList4 = new ArrayList(q4);
        for (a.C0416a c0416a3 : i2) {
            arrayList4.add(c0416a3.a());
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList4);
        e = E0;
        q5 = n.q(i2, 10);
        ArrayList arrayList5 = new ArrayList(q5);
        for (a.C0416a c0416a4 : i2) {
            arrayList5.add(c0416a4.b());
        }
        E02 = CollectionsKt___CollectionsKt.E0(arrayList5);
        f = E02;
        a aVar3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        b41.h(desc9, "INT.desc");
        a.C0416a m4 = aVar3.m("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        g = m4;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String h2 = signatureBuildingComponents2.h("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        b41.h(desc10, "BYTE.desc");
        String h3 = signatureBuildingComponents2.h("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        b41.h(desc11, "SHORT.desc");
        String h4 = signatureBuildingComponents2.h("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        b41.h(desc12, "INT.desc");
        String h5 = signatureBuildingComponents2.h("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        b41.h(desc13, "LONG.desc");
        String h6 = signatureBuildingComponents2.h("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        b41.h(desc14, "FLOAT.desc");
        String h7 = signatureBuildingComponents2.h("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        b41.h(desc15, "DOUBLE.desc");
        String h8 = signatureBuildingComponents2.h("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        b41.h(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        b41.h(desc17, "CHAR.desc");
        l2 = x.l(hq2.a(aVar3.m(h2, "toByte", "", desc10), ni1.f("byteValue")), hq2.a(aVar3.m(h3, "toShort", "", desc11), ni1.f("shortValue")), hq2.a(aVar3.m(h4, "toInt", "", desc12), ni1.f("intValue")), hq2.a(aVar3.m(h5, "toLong", "", desc13), ni1.f("longValue")), hq2.a(aVar3.m(h6, "toFloat", "", desc14), ni1.f("floatValue")), hq2.a(aVar3.m(h7, "toDouble", "", desc15), ni1.f("doubleValue")), hq2.a(m4, ni1.f("remove")), hq2.a(aVar3.m(h8, gn1.TYPE_OPEN_URL_METHOD_GET, desc16, desc17), ni1.f("charAt")));
        h = l2;
        e3 = w.e(l2.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e3);
        Iterator<T> it2 = l2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(((a.C0416a) entry2.getKey()).b(), entry2.getValue());
        }
        i = linkedHashMap2;
        Set<a.C0416a> keySet = h.keySet();
        q6 = n.q(keySet, 10);
        ArrayList arrayList6 = new ArrayList(q6);
        for (a.C0416a c0416a5 : keySet) {
            arrayList6.add(c0416a5.a());
        }
        j = arrayList6;
        Set<Map.Entry<a.C0416a, ni1>> entrySet = h.entrySet();
        q7 = n.q(entrySet, 10);
        ArrayList<Pair> arrayList7 = new ArrayList(q7);
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            arrayList7.add(new Pair(((a.C0416a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            ni1 ni1Var = (ni1) pair.getSecond();
            Object obj = linkedHashMap3.get(ni1Var);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(ni1Var, obj);
            }
            ((List) obj).add((ni1) pair.getFirst());
        }
        k = linkedHashMap3;
    }
}
