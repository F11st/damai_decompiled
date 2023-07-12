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
    /* loaded from: classes8.dex */
    public static final class b {
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

        public b k(long j) {
            this.i = j;
            return this;
        }

        public b l(int i) {
            this.e = i;
            return this;
        }

        public b m(String str) {
            this.d = str;
            return this;
        }

        public b n(boolean z) {
            this.h = z;
            return this;
        }

        public b o(String str) {
            this.f = str;
            return this;
        }

        private b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.g = z;
        }
    }

    public static b a(String str, String str2, boolean z) {
        return new b(str, str2, z);
    }

    private kh1(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        Exception unused = bVar.c;
        this.c = bVar.d;
        this.d = bVar.e;
        this.e = bVar.f;
        this.f = bVar.g;
        this.g = bVar.h;
        this.h = bVar.i;
    }
}
