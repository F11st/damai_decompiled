package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gm extends gn {
    private boolean a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f427b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public gm() {
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f427b = false;
    }

    public gm(Bundle bundle) {
        super(bundle);
        this.b = null;
        this.c = null;
        this.a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f427b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f427b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gn
    public Bundle a() {
        Bundle a = super.a();
        if (!TextUtils.isEmpty(this.b)) {
            a.putString("ext_msg_type", this.b);
        }
        String str = this.d;
        if (str != null) {
            a.putString("ext_msg_lang", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            a.putString("ext_msg_sub", str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            a.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a.putString("ext_body_encode", this.g);
        }
        String str4 = this.c;
        if (str4 != null) {
            a.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            a.putString("ext_msg_appid", str5);
        }
        if (this.a) {
            a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a.putString("ext_msg_fseq", this.k);
        }
        if (this.f427b) {
            a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a.putString("ext_msg_status", this.l);
        }
        return a;
    }

    @Override // com.xiaomi.push.gn
    /* renamed from: a */
    public String mo926a() {
        gr m927a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(gy.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gy.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gy.a(k()));
            sb.append("\"");
        }
        if (this.a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.f427b) {
            sb.append(" s=\"1\"");
        }
        sb.append(jn1.G);
        if (this.e != null) {
            sb.append("<subject>");
            sb.append(gy.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"");
                sb.append(this.g);
                sb.append("\"");
            }
            sb.append(jn1.G);
            sb.append(gy.a(this.f));
            sb.append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>");
            sb.append(this.c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.b) && (m927a = m927a()) != null) {
            sb.append(m927a.m930a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f427b = z;
    }

    public String c() {
        return this.h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.i;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.l = str;
    }

    @Override // com.xiaomi.push.gn
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gm gmVar = (gm) obj;
        if (super.equals(gmVar)) {
            String str = this.f;
            if (str == null ? gmVar.f == null : str.equals(gmVar.f)) {
                String str2 = this.d;
                if (str2 == null ? gmVar.d == null : str2.equals(gmVar.d)) {
                    String str3 = this.e;
                    if (str3 == null ? gmVar.e == null : str3.equals(gmVar.e)) {
                        String str4 = this.c;
                        if (str4 == null ? gmVar.c == null : str4.equals(gmVar.c)) {
                            return this.b == gmVar.b;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void h(String str) {
        this.f = str;
    }

    @Override // com.xiaomi.push.gn
    public int hashCode() {
        String str = this.b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.d = str;
    }
}
