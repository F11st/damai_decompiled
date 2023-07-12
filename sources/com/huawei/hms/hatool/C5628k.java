package com.huawei.hms.hatool;

import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.k */
/* loaded from: classes10.dex */
public class C5628k {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public C5626j g;
    public String h;
    public Map<String, String> i;
    public String j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public long q;

    public C5628k() {
        this.e = "";
        this.f = "";
        this.g = new C5626j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public C5628k(C5628k c5628k) {
        this.e = "";
        this.f = "";
        this.g = new C5626j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.g = c5628k.g;
        b(c5628k.a);
        a(c5628k.c);
        b(c5628k.d);
        e(c5628k.e);
        g(c5628k.f);
        d(c5628k.h);
        f(c5628k.j);
        c(c5628k.b);
        a(c5628k.k);
        b(c5628k.l);
        d(c5628k.m);
        a(c5628k.n);
        e(c5628k.o);
        a(c5628k.i);
        c(c5628k.p);
        a(c5628k.q);
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(Map<String, String> map) {
        this.i = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.k;
    }

    public void b(int i) {
        this.l = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.l;
    }

    public void d(String str) {
        this.h = str;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public boolean g() {
        return this.m;
    }

    public String h() {
        return this.d;
    }

    public boolean i() {
        return this.o;
    }

    public C5626j j() {
        return this.g;
    }

    public Map<String, String> k() {
        return this.i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.h;
    }

    public String o() {
        return this.e;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.f;
    }
}
