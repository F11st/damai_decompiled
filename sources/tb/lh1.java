package tb;

import androidx.annotation.NonNull;
import com.alipay.sdk.m.e0.C4186a;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class lh1 {
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;

    /* compiled from: Taobao */
    /* renamed from: tb.lh1$a */
    /* loaded from: classes5.dex */
    public static class C9413a {
        private int a = 500;
        private int b = 2000;
        private int c = 180000;
        private int d = C4186a.a;
        private boolean e = true;

        @NonNull
        public lh1 f() {
            return new lh1(this);
        }
    }

    lh1(@NonNull C9413a c9413a) {
        this.a = c9413a.a;
        this.b = c9413a.b;
        this.d = c9413a.d;
        this.c = c9413a.c;
        this.e = c9413a.e;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }
}
