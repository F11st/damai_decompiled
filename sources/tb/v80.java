package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class v80 {
    private String a;
    private iy2 b;
    private Object c;
    private Object d;
    private Object e;

    /* compiled from: Taobao */
    /* renamed from: tb.v80$b */
    /* loaded from: classes11.dex */
    public static final class C9812b {
        private String a = "default";
        private iy2 b;
        private Object c;
        private Object d;
        private Object e;

        public v80 f() {
            return new v80(this);
        }

        public C9812b g(Object obj) {
            this.e = obj;
            return this;
        }

        public C9812b h(Object obj) {
            this.c = obj;
            return this;
        }

        public C9812b i(String str) {
            this.a = str;
            return this;
        }

        public C9812b j(Object obj) {
            this.d = obj;
            return this;
        }

        public C9812b k(iy2 iy2Var) {
            this.b = iy2Var;
            return this;
        }
    }

    public Object a() {
        return this.e;
    }

    public Object b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public Object d() {
        return this.d;
    }

    public iy2 e() {
        return this.b;
    }

    public void f(Object obj) {
        this.e = obj;
    }

    private v80(C9812b c9812b) {
        this.a = "default";
        this.a = c9812b.a;
        this.e = c9812b.e;
        this.c = c9812b.c;
        this.d = c9812b.d;
        this.b = c9812b.b;
    }
}
