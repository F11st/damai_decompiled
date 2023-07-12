package com.alibaba.mobsec.privacydoublelist.e;

import java.util.regex.Matcher;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.e.a */
/* loaded from: classes6.dex */
public class C3433a extends AbstractC3434b {
    public C3433a(String str) {
        this.a = str;
    }

    public String b() {
        return "a";
    }

    public String toString() {
        Matcher matcher;
        String str;
        String str2;
        if (this.a.contains(jn1.BRACKET_START_STR)) {
            matcher = AbstractC3434b.f.matcher(this.a);
        } else {
            matcher = AbstractC3434b.g.matcher(this.a);
        }
        String str3 = this.a;
        if (matcher.find()) {
            str2 = matcher.group(1);
            str = matcher.group(2);
        } else {
            str = str3;
            str2 = "";
        }
        return "" + str2 + "|" + str + "|" + this.b.get() + "|" + this.c.get() + "|" + a() + "|0|" + a() + "|" + this.e.get();
    }
}
