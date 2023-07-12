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
    /* loaded from: classes5.dex */
    public static class a {
        private int a;
        private int b;
        private int c;
        private long d;
        private boolean e;
        private ThreadFactory f;

        @NonNull
        public a g(boolean z) {
            this.e = z;
            return this;
        }

        @NonNull
        public ng0 h() {
            return new ng0(this);
        }

        @NonNull
        public a i(int i) {
            this.a = i;
            return this;
        }

        @NonNull
        public a j(long j) {
            this.d = j;
            return this;
        }

        @NonNull
        public a k(int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public a l(int i) {
            this.c = i;
            return this;
        }

        @NonNull
        public a m(ThreadFactory threadFactory) {
            this.f = threadFactory;
            return this;
        }
    }

    ng0(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.d = aVar.d;
        this.f = aVar.f;
        this.c = aVar.c;
        this.e = aVar.e;
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
