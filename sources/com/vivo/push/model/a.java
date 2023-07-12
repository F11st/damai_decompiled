package com.vivo.push.model;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    private String a;
    private String b;

    public a(String str, String str2) {
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
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.a;
            if (str == null) {
                if (aVar.a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.a)) {
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
