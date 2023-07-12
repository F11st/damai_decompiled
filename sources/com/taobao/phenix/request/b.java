package com.taobao.phenix.request;

import android.text.TextUtils;
import tb.h62;
import tb.md2;
import tb.ye;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    private static final int[] k = {10, 30, 60, 100, 200, 300, 500, 800, 1100, 1500};
    private final ye a;
    private final h62 b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;

    public b(String str, ye yeVar) {
        this.a = yeVar;
        this.c = str;
        if (str == null) {
            this.b = new h62(1);
            return;
        }
        h62 d = h62.d(str);
        this.b = d;
        if (d.c() && d.g) {
            this.i = md2.f(d.e, d.f);
        }
    }

    private int c(int i) {
        int length = k.length;
        int i2 = length / 2;
        char c = 65535;
        while (i2 >= 0 && i2 < length) {
            int i3 = k[i2];
            if (i > i3) {
                if (c >= 0) {
                    if (c == 2) {
                        break;
                    }
                } else {
                    c = 1;
                }
                i2++;
            } else if (i >= i3) {
                break;
            } else {
                if (c >= 0) {
                    if (c == 1) {
                        break;
                    }
                } else {
                    c = 2;
                }
                i2--;
            }
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= length) {
            i2 = length - 1;
        } else {
            if (c == 1) {
                int[] iArr = k;
                if (i <= (iArr[i2 - 1] + iArr[i2]) / 2) {
                    i2--;
                }
            }
            if (c == 2) {
                int[] iArr2 = k;
                int i4 = i2 + 1;
                if (i > (iArr2[i2] + iArr2[i4]) / 2) {
                    i2 = i4;
                }
            }
        }
        return k[i2];
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.j == null) {
            this.j = str;
            return;
        }
        this.j += str;
    }

    public boolean b() {
        return this.b.g;
    }

    public ye d() {
        return this.a;
    }

    public int e() {
        ye yeVar = this.a;
        if (yeVar != null) {
            return yeVar.a(this.c, this.i);
        }
        return this.i;
    }

    public String f() {
        StringBuilder sb;
        if (this.h == null) {
            String str = this.b.b;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            sb.append(this.b.d);
            String sb2 = sb.toString();
            this.h = sb2;
            ye yeVar = this.a;
            if (yeVar != null) {
                this.h = yeVar.b(this.c, sb2);
            }
        }
        return this.h;
    }

    public String g() {
        StringBuilder sb;
        if (this.g == null) {
            String str = this.b.c;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            this.g = sb.toString();
        }
        return this.g;
    }

    public int h() {
        return this.b.f;
    }

    public String i() {
        return this.b.d;
    }

    public String j() {
        StringBuilder sb;
        int i;
        if (this.f == null) {
            String str = this.b.b;
            if (str != null) {
                sb = new StringBuilder(str);
            } else {
                sb = new StringBuilder();
            }
            int i2 = this.i;
            if (i2 == 0 && ((i = this.d) != 0 || this.e != 0)) {
                sb.append(md2.f(c(i), c(this.e)));
            } else {
                sb.append(i2);
            }
            String sb2 = sb.toString();
            this.f = sb2;
            ye yeVar = this.a;
            if (yeVar != null) {
                this.f = yeVar.c(this.c, sb2);
            }
            if (this.f != null && this.j != null) {
                this.f += this.j;
            }
        }
        return this.f;
    }

    public String k() {
        return this.c;
    }

    public h62 l() {
        return this.b;
    }

    public int m() {
        return this.b.e;
    }

    public boolean n() {
        return this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public String toString() {
        return "path: " + this.c + "\nscheme info: " + this.b + "\nbase cache catalog: " + e() + "\nmemory cache key: " + j() + "\ndisk cache key: " + f() + "\ndisk cache catalog: " + e();
    }
}
