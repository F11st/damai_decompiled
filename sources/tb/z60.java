package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class z60 {
    @JvmField
    @NotNull
    public static final z60 ALL;
    @JvmField
    @NotNull
    public static final z60 CALLABLES;
    @JvmField
    @NotNull
    public static final z60 CLASSIFIERS;
    @NotNull
    public static final C10015a Companion;
    @JvmField
    @NotNull
    public static final z60 FUNCTIONS;
    @JvmField
    @NotNull
    public static final z60 NON_SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final z60 PACKAGES;
    @JvmField
    @NotNull
    public static final z60 SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final z60 TYPE_ALIASES;
    @JvmField
    @NotNull
    public static final z60 VALUES;
    @JvmField
    @NotNull
    public static final z60 VARIABLES;
    private static int c;
    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    @NotNull
    private static final List<C10015a.C10016a> n;
    @NotNull
    private static final List<C10015a.C10016a> o;
    @NotNull
    private final List<y60> a;
    private final int b;

    /* compiled from: Taobao */
    /* renamed from: tb.z60$a */
    /* loaded from: classes3.dex */
    public static final class C10015a {

        /* compiled from: Taobao */
        /* renamed from: tb.z60$a$a */
        /* loaded from: classes3.dex */
        private static final class C10016a {
            private final int a;
            @NotNull
            private final String b;

            public C10016a(int i, @NotNull String str) {
                b41.i(str, "name");
                this.a = i;
                this.b = str;
            }

            public final int a() {
                return this.a;
            }

            @NotNull
            public final String b() {
                return this.b;
            }
        }

        private C10015a() {
        }

        public /* synthetic */ C10015a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i = z60.c;
            C10015a c10015a = z60.Companion;
            z60.c <<= 1;
            return i;
        }

        public final int b() {
            return z60.j;
        }

        public final int c() {
            return z60.k;
        }

        public final int d() {
            return z60.h;
        }

        public final int e() {
            return z60.d;
        }

        public final int f() {
            return z60.g;
        }

        public final int g() {
            return z60.e;
        }

        public final int h() {
            return z60.f;
        }

        public final int i() {
            return z60.i;
        }
    }

    static {
        C10015a.C10016a c10016a;
        C10015a.C10016a c10016a2;
        C10015a c10015a = new C10015a(null);
        Companion = c10015a;
        c = 1;
        int j2 = c10015a.j();
        d = j2;
        int j3 = c10015a.j();
        e = j3;
        int j4 = c10015a.j();
        f = j4;
        int j5 = c10015a.j();
        g = j5;
        int j6 = c10015a.j();
        h = j6;
        int j7 = c10015a.j();
        i = j7;
        int j8 = c10015a.j() - 1;
        j = j8;
        int i2 = j2 | j3 | j4;
        k = i2;
        int i3 = j3 | j6 | j7;
        l = i3;
        int i4 = j6 | j7;
        m = i4;
        ALL = new z60(j8, null, 2, null);
        CALLABLES = new z60(i4, null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new z60(j2, null, 2, null);
        SINGLETON_CLASSIFIERS = new z60(j3, null, 2, null);
        TYPE_ALIASES = new z60(j4, null, 2, null);
        CLASSIFIERS = new z60(i2, null, 2, null);
        PACKAGES = new z60(j5, null, 2, null);
        FUNCTIONS = new z60(j6, null, 2, null);
        VARIABLES = new z60(j7, null, 2, null);
        VALUES = new z60(i3, null, 2, null);
        Field[] fields = z60.class.getFields();
        b41.h(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            z60 z60Var = obj instanceof z60 ? (z60) obj : null;
            if (z60Var != null) {
                int m2 = z60Var.m();
                String name = field2.getName();
                b41.h(name, "field.name");
                c10016a2 = new C10015a.C10016a(m2, name);
            } else {
                c10016a2 = null;
            }
            if (c10016a2 != null) {
                arrayList2.add(c10016a2);
            }
        }
        n = arrayList2;
        Field[] fields2 = z60.class.getFields();
        b41.h(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (b41.d(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                b41.h(name2, "field.name");
                c10016a = new C10015a.C10016a(intValue, name2);
            } else {
                c10016a = null;
            }
            if (c10016a != null) {
                arrayList5.add(c10016a);
            }
        }
        o = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z60(int i2, @NotNull List<? extends y60> list) {
        b41.i(list, "excludes");
        this.a = list;
        for (y60 y60Var : list) {
            i2 &= ~y60Var.a();
        }
        this.b = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.b) != 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (b41.d(z60.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
            z60 z60Var = (z60) obj;
            return b41.d(this.a, z60Var.a) && this.b == z60Var.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public final List<y60> l() {
        return this.a;
    }

    public final int m() {
        return this.b;
    }

    @Nullable
    public final z60 n(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new z60(i3, this.a);
    }

    @NotNull
    public String toString() {
        Object obj;
        boolean z;
        Iterator<T> it = n.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((C10015a.C10016a) obj).a() == m()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        C10015a.C10016a c10016a = (C10015a.C10016a) obj;
        String b = c10016a == null ? null : c10016a.b();
        if (b == null) {
            List<C10015a.C10016a> list = o;
            ArrayList arrayList = new ArrayList();
            for (C10015a.C10016a c10016a2 : list) {
                String b2 = a(c10016a2.a()) ? c10016a2.b() : null;
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            b = CollectionsKt___CollectionsKt.Z(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b + AVFSCacheConstants.COMMA_SEP + this.a + ')';
    }

    public /* synthetic */ z60(int i2, List list, int i3, k50 k50Var) {
        this(i2, (i3 & 2) != 0 ? C8214m.g() : list);
    }
}
