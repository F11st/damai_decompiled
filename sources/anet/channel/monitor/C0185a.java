package anet.channel.monitor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.a */
/* loaded from: classes.dex */
public class C0185a {
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private long a = 0;
    private double i = 0.0d;
    private double j = 0.0d;
    private double k = 0.0d;

    public void a() {
        this.a = 0L;
        this.k = 0.0d;
    }

    public double b(double d, double d2) {
        double d3 = d / d2;
        if (d3 < 8.0d) {
            if (this.a != 0) {
                return this.k;
            }
            this.k = d3;
            return d3;
        }
        long j = this.a;
        if (j == 0) {
            this.i = d3;
            this.h = d3;
            this.d = d3 * 0.1d;
            this.c = 0.02d * d3;
            this.e = 0.1d * d3 * d3;
        } else if (j == 1) {
            this.j = d3;
            this.h = d3;
        } else {
            double d4 = this.j;
            double d5 = d3 - d4;
            this.i = d4;
            this.j = d3;
            double d6 = d3 / 0.95d;
            this.b = d6;
            this.g = d6 - (this.h * 0.95d);
            char c = 0;
            double sqrt = Math.sqrt(this.d);
            double d7 = this.g;
            if (d7 >= 4.0d * sqrt) {
                this.g = (d7 * 0.75d) + (sqrt * 2.0d);
                c = 1;
            } else if (d7 <= (-4.0d) * sqrt) {
                this.g = (sqrt * (-1.0d)) + (d7 * 0.75d);
                c = 2;
            }
            double d8 = this.g;
            double min = Math.min(Math.max(Math.abs((this.d * 1.05d) - ((0.0025d * d8) * d8)), this.d * 0.8d), this.d * 1.25d);
            this.d = min;
            double d9 = this.e;
            double d10 = d9 / ((0.9025d * d9) + min);
            this.f = d10;
            double d11 = this.h + (1.0526315789473684d * d5) + (d10 * this.g);
            this.h = d11;
            if (c == 1) {
                this.h = Math.min(d11, this.b);
            } else if (c == 2) {
                this.h = Math.max(d11, this.b);
            }
            this.e = (1.0d - (0.95d * this.f)) * (this.e + this.c);
        }
        double d12 = this.h;
        if (d12 < 0.0d) {
            double d13 = this.j * 0.7d;
            this.k = d13;
            this.h = d13;
        } else {
            this.k = d12;
        }
        return this.k;
    }
}
