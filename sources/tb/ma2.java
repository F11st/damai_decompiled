package tb;

import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ma2 {
    private int a;
    private int b;
    private float[][] c;
    private int d;
    private int e;

    public ma2(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i <= 0) {
            throw new IllegalArgumentException("sampleBufSize is invalid.");
        }
        if (i2 > 0) {
            this.c = (float[][]) Array.newInstance(float.class, i, i2);
            return;
        }
        throw new IllegalArgumentException("numAxes is invalid.");
    }

    public void a(float[] fArr) {
        if (fArr.length >= this.b) {
            this.d = (this.d + 1) % this.a;
            for (int i = 0; i < this.b; i++) {
                this.c[this.d][i] = fArr[i];
            }
            this.e++;
            return;
        }
        throw new IllegalArgumentException("values.length is less than # of axes.");
    }

    public float b(int i) {
        if (f()) {
            if (i < 0 || i >= this.b) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("axis must be between 0 and ");
                sb.append(this.b - 1);
                throw new IllegalStateException(sb.toString());
            }
            float f = 0.0f;
            int i2 = 0;
            while (true) {
                int i3 = this.a;
                if (i2 >= i3) {
                    return f / i3;
                }
                f += this.c[i2][i];
                i2++;
            }
        } else {
            throw new IllegalStateException("Average not available. Not enough samples.");
        }
    }

    public float c() {
        float f = 0.0f;
        for (int i = 0; i < this.b; i++) {
            f = Math.max(f, d(i));
        }
        return f;
    }

    public float d(int i) {
        if (i >= 0 && i < this.b) {
            float b = b(i);
            float f = 0.0f;
            for (int i2 = 0; i2 < this.a; i2++) {
                f = Math.max(Math.abs(this.c[i2][i] - b), f);
            }
            return f;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("axis must be between 0 and ");
        sb.append(this.b - 1);
        throw new IllegalStateException(sb.toString());
    }

    public void e() {
        this.e = 0;
        this.d = 0;
    }

    public boolean f() {
        return this.e >= this.a;
    }
}
