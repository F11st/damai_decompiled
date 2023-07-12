package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bg implements bi {
    private final String a;
    private final String b;

    public bg(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.bi
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.bi
    public String b() {
        return this.b;
    }
}
