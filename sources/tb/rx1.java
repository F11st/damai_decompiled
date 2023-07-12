package tb;

import android.graphics.PointF;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class rx1 {
    public static final int POS_START = 0;
    private float c;
    private float d;
    private int g;
    protected int a = 0;
    private PointF b = new PointF();
    private int e = 0;
    private int f = 0;
    private int h = 0;
    private float i = 1.2f;
    private float j = 1.7f;
    private boolean k = false;
    private int l = -1;
    private int m = 0;

    public void A() {
        this.m = this.e;
    }

    protected void B(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(float f, float f2, float f3, float f4) {
        F(f3, f4 / this.j);
    }

    public final void D(int i) {
        int i2 = this.e;
        this.f = i2;
        this.e = i;
        B(i, i2);
    }

    public void E(int i) {
        this.g = i;
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public void G(int i) {
        this.l = i;
    }

    public void H(int i) {
        this.i = (this.g * 1.0f) / i;
        this.a = i;
    }

    public void I(float f) {
        this.i = f;
        this.a = (int) (this.g * f);
    }

    public void J(float f) {
        this.j = f;
    }

    protected void K() {
        this.a = (int) (this.i * this.g);
    }

    public boolean L(int i) {
        return i < 0;
    }

    public void a(rx1 rx1Var) {
        this.e = rx1Var.e;
        this.f = rx1Var.f;
        this.g = rx1Var.g;
    }

    public boolean b() {
        return this.f < h() && this.e >= h();
    }

    public float c() {
        int i = this.g;
        if (i == 0) {
            return 0.0f;
        }
        return (this.e * 1.0f) / i;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        int i = this.l;
        return i >= 0 ? i : this.g;
    }

    public int h() {
        return this.a;
    }

    public float i() {
        return this.c;
    }

    public float j() {
        return this.d;
    }

    public float k() {
        return this.i;
    }

    public float l() {
        return this.j;
    }

    public boolean m() {
        return this.e >= this.m;
    }

    public boolean n() {
        return this.f != 0 && t();
    }

    public boolean o() {
        return this.f == 0 && q();
    }

    public boolean p() {
        int i = this.f;
        int i2 = this.g;
        return i < i2 && this.e >= i2;
    }

    public boolean q() {
        return this.e > 0;
    }

    public boolean r() {
        return this.e != this.h;
    }

    public boolean s(int i) {
        return this.e == i;
    }

    public boolean t() {
        return this.e == 0;
    }

    public boolean u() {
        return this.e > g();
    }

    public boolean v() {
        return this.e >= h();
    }

    public boolean w() {
        return this.k;
    }

    public final void x(float f, float f2) {
        PointF pointF = this.b;
        C(f, f2, f - pointF.x, f2 - pointF.y);
        this.b.set(f, f2);
    }

    public void y(float f, float f2) {
        this.k = true;
        this.h = this.e;
        this.b.set(f, f2);
    }

    public void z() {
        this.k = false;
    }
}
