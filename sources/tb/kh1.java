package tb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class kh1 {
    public static final String CACHE_FILE = "file";
    public static final String CACHE_MMAP = "mmap";
    public static final String CACHE_SQL = "sql";
    public static final String OPERATION_READ = "read";
    public static final String OPERATION_WRITE = "write";
    public static final String RESOURCE_OBJECT = "object";
    public static final String RESOURCE_STREAM = "stream";
    public final String a;
    public final String b;
    public String c;
    public int d;
    public String e;
    public final boolean f;
    public boolean g;
    public long h;

    /* compiled from: Taobao */
    /* renamed from: tb.kh1$b */
    /* loaded from: classes8.dex */
    public static final class C9360b {
        private final String a;
        private final String b;
        private Exception c;
        private String d;
        private int e;
        private String f;
        private final boolean g;
        private boolean h;
        private long i;

        public kh1 j() {
            return new kh1(this);
        }

        public C9360b k(long j) {
            this.i = j;
            return this;
        }

        public C9360b l(int i) {
            this.e = i;
            return this;
        }

        public C9360b m(String str) {
            this.d = str;
            return this;
        }

        public C9360b n(boolean z) {
            this.h = z;
            return this;
        }

        public C9360b o(String str) {
            this.f = str;
            return this;
        }

        private C9360b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.g = z;
        }
    }

    public static C9360b a(String str, String str2, boolean z) {
        return new C9360b(str, str2, z);
    }

    private kh1(C9360b c9360b) {
        this.a = c9360b.a;
        this.b = c9360b.b;
        Exception unused = c9360b.c;
        this.c = c9360b.d;
        this.d = c9360b.e;
        this.e = c9360b.f;
        this.f = c9360b.g;
        this.g = c9360b.h;
        this.h = c9360b.i;
    }
}
