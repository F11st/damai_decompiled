package com.alipay.sdk.m.c0;

import com.alipay.sdk.m.z.C4368a;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c0.a */
/* loaded from: classes12.dex */
public final class C4165a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public C4165a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.a);
        stringBuffer.append("," + this.b);
        stringBuffer.append("," + this.c);
        stringBuffer.append("," + this.d);
        if (C4368a.a(this.e) || this.e.length() < 20) {
            sb = new StringBuilder(",");
            str = this.e;
        } else {
            sb = new StringBuilder(",");
            str = this.e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (C4368a.a(this.f) || this.f.length() < 20) {
            sb2 = new StringBuilder(",");
            str2 = this.f;
        } else {
            sb2 = new StringBuilder(",");
            str2 = this.f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (C4368a.a(this.g) || this.g.length() < 20) {
            sb3 = new StringBuilder(",");
            str3 = this.g;
        } else {
            sb3 = new StringBuilder(",");
            str3 = this.g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
