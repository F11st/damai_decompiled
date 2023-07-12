package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8207h;
import kotlin.collections.C8214m;
import kotlin.collections.C8225w;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ty1;
import tb.x61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KotlinClassHeader {
    @NotNull
    private final Kind a;
    @NotNull
    private final x61 b;
    @Nullable
    private final String[] c;
    @Nullable
    private final String[] d;
    @Nullable
    private final String[] e;
    @Nullable
    private final String f;
    private final int g;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @NotNull
        public static final C8378a Companion = new C8378a(null);
        @NotNull
        private static final Map<Integer, Kind> entryById;
        private final int id;

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind$a */
        /* loaded from: classes3.dex */
        public static final class C8378a {
            private C8378a() {
            }

            public /* synthetic */ C8378a(k50 k50Var) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Kind a(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        static {
            int e;
            int a;
            Kind[] values = values();
            e = C8225w.e(values.length);
            a = ty1.a(e, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a);
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i) {
            this.id = i;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i) {
            return Companion.a(i);
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull x61 x61Var, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i, @Nullable String str2) {
        b41.i(kind, "kind");
        b41.i(x61Var, "metadataVersion");
        this.a = kind;
        this.b = x61Var;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    private final boolean h(int i, int i2) {
        return (i & i2) != 0;
    }

    @Nullable
    public final String[] a() {
        return this.c;
    }

    @Nullable
    public final String[] b() {
        return this.d;
    }

    @NotNull
    public final Kind c() {
        return this.a;
    }

    @NotNull
    public final x61 d() {
        return this.b;
    }

    @Nullable
    public final String e() {
        String str = this.f;
        if (c() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> f() {
        List<String> g;
        String[] strArr = this.c;
        if (!(c() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> d = strArr != null ? C8207h.d(strArr) : null;
        if (d != null) {
            return d;
        }
        g = C8214m.g();
        return g;
    }

    @Nullable
    public final String[] g() {
        return this.e;
    }

    public final boolean i() {
        return h(this.g, 2);
    }

    public final boolean j() {
        return h(this.g, 64) && !h(this.g, 32);
    }

    public final boolean k() {
        return h(this.g, 16) && !h(this.g, 32);
    }

    @NotNull
    public String toString() {
        return this.a + " version=" + this.b;
    }
}
