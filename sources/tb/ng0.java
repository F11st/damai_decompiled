package tb;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ng0 {
    private int a;
    private int b;
    private int c;
    private long d;
    private boolean e;
    private ThreadFactory f;

    /* compiled from: Taobao */
    /* renamed from: tb.ng0$a */
    /* loaded from: classes5.dex */
    public static class C9473a {
        private int a;
        private int b;
        private int c;
        private long d;
        private boolean e;
        private ThreadFactory f;

        @NonNull
        public C9473a g(boolean z) {
            this.e = z;
            return this;
        }

        @NonNull
        public ng0 h() {
            return new ng0(this);
        }

        @NonNull
        public C9473a i(int i) {
            this.a = i;
            return this;
        }

        @NonNull
        public C9473a j(long j) {
            this.d = j;
            return this;
        }

        @NonNull
        public C9473a k(int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public C9473a l(int i) {
            this.c = i;
            return this;
        }

        @NonNull
        public C9473a m(ThreadFactory threadFactory) {
            this.f = threadFactory;
            return this;
        }
    }

    ng0(@NonNull C9473a c9473a) {
        this.a = c9473a.a;
        this.b = c9473a.b;
        this.d = c9473a.d;
        this.f = c9473a.f;
        this.c = c9473a.c;
        this.e = c9473a.e;
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public ThreadFactory e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }
}
