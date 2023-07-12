package com.huawei.hms.hatool;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class k {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public j g;
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

    public k() {
        this.e = "";
        this.f = "";
        this.g = new j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public k(k kVar) {
        this.e = "";
        this.f = "";
        this.g = new j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.g = kVar.g;
        b(kVar.a);
        a(kVar.c);
        b(kVar.d);
        e(kVar.e);
        g(kVar.f);
        d(kVar.h);
        f(kVar.j);
        c(kVar.b);
        a(kVar.k);
        b(kVar.l);
        d(kVar.m);
        a(kVar.n);
        e(kVar.o);
        a(kVar.i);
        c(kVar.p);
        a(kVar.q);
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

    public j j() {
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
