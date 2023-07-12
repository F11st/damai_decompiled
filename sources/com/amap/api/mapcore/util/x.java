package com.amap.api.mapcore.util;

import com.amap.api.maps.model.BitmapDescriptor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class x {
    private BitmapDescriptor b;
    private int c;
    private float d;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 1.0f;
    private float h = 1.0f;
    private boolean i = false;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private String a = ei.a();

    public x(BitmapDescriptor bitmapDescriptor, int i) {
        this.d = 1.0f;
        this.b = bitmapDescriptor;
        this.c = i;
        BitmapDescriptor bitmapDescriptor2 = this.b;
        if (bitmapDescriptor2 != null) {
            this.d = (float) ((bitmapDescriptor2.getWidth() * 1.0d) / this.b.getHeight());
        }
    }

    public boolean a() {
        return this.i;
    }

    public float b() {
        return this.l;
    }

    public float c() {
        return this.m;
    }

    public float d() {
        return this.j;
    }

    public float e() {
        return this.k;
    }

    public float f() {
        return this.f;
    }

    public float g() {
        return this.e;
    }

    public float h() {
        return this.g;
    }

    public float i() {
        return this.h;
    }

    public BitmapDescriptor j() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public float l() {
        return this.d;
    }

    public void m() {
        this.n++;
    }

    public void n() {
        this.n--;
    }

    public int o() {
        return this.n;
    }

    public String p() {
        return this.a;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(float f) {
        this.m = f;
    }

    public void c(float f) {
        this.j = f;
    }

    public void d(float f) {
        this.k = f;
    }

    public void e(float f) {
        this.f = f;
    }

    public void f(float f) {
        this.e = f;
    }

    public void g(float f) {
        this.g = f;
    }

    public void h(float f) {
        this.h = f;
    }

    public void a(float f) {
        this.l = f;
    }

    public void a(int i) {
        this.c = i;
    }
}
