package com.vivo.push.model;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.model.a */
/* loaded from: classes11.dex */
public final class C7493a {
    private String a;
    private String b;

    public C7493a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C7493a.class == obj.getClass()) {
            C7493a c7493a = (C7493a) obj;
            String str = this.a;
            if (str == null) {
                if (c7493a.a != null) {
                    return false;
                }
            } else if (!str.equals(c7493a.a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.a + "', mValue='" + this.b + "'}";
    }
}
