package com.uploader.implement.b.a;

import tb.j33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class g extends j33 {
    public final String f;
    public final String g;

    public g(String str, int i, String str2, String str3) {
        super(str, i, null, 0, false);
        this.f = str2;
        this.g = str3;
    }

    @Override // tb.j33
    public com.uploader.implement.b.e a(com.uploader.implement.c cVar) {
        return new e(cVar, this);
    }

    @Override // tb.j33
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof g) && super.equals(obj)) {
            g gVar = (g) obj;
            String str = this.f;
            if (str == null ? gVar.f == null : str.equals(gVar.f)) {
                String str2 = this.g;
                String str3 = gVar.g;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }
}
