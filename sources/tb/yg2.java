package tb;

import com.taobao.phenix.request.C6865a;
import com.taobao.rxm.consume.Consumer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yg2 {
    private final Consumer<?, C6865a> a;
    private final int b;
    private int c;
    public final int d;
    private boolean e;
    private int f;
    private byte[] g;

    public yg2(Consumer<?, C6865a> consumer, int i, int i2) {
        this.a = consumer;
        this.d = i;
        this.b = i2;
    }

    public ne0 a() {
        return new ne0(!e(), this.g, 0, this.f);
    }

    public int b() {
        return this.f;
    }

    public boolean c(int i) {
        int i2 = this.d;
        return i2 <= 0 || this.f + i <= i2;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        int i;
        return this.g == null || ((i = this.d) > 0 && this.f != i);
    }

    public synchronized boolean f(int i) {
        int i2;
        int i3 = this.f + i;
        this.f = i3;
        Consumer<?, C6865a> consumer = this.a;
        if (consumer == null) {
            return true;
        }
        int i4 = this.d;
        if (i4 > 0 && (i2 = this.b) > 0) {
            float f = i3 / i4;
            int i5 = (int) ((100.0f * f) / i2);
            if (i5 > this.c || i3 == i4) {
                this.c = i5;
                consumer.onProgressUpdate(f);
            }
        }
        if (this.a.getContext().i()) {
            xt2.q("Stream", this.a.getContext(), "Request is cancelled while reading stream", new Object[0]);
            this.a.onCancellation();
            this.e = true;
            return false;
        }
        return true;
    }

    public void g(byte[] bArr) {
        this.g = bArr;
    }
}
