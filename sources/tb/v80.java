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
    /* loaded from: classes11.dex */
    public static final class b {
        private String a = "default";
        private iy2 b;
        private Object c;
        private Object d;
        private Object e;

        public v80 f() {
            return new v80(this);
        }

        public b g(Object obj) {
            this.e = obj;
            return this;
        }

        public b h(Object obj) {
            this.c = obj;
            return this;
        }

        public b i(String str) {
            this.a = str;
            return this;
        }

        public b j(Object obj) {
            this.d = obj;
            return this;
        }

        public b k(iy2 iy2Var) {
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

    private v80(b bVar) {
        this.a = "default";
        this.a = bVar.a;
        this.e = bVar.e;
        this.c = bVar.c;
        this.d = bVar.d;
        this.b = bVar.b;
    }
}
