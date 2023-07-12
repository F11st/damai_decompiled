package com.uploader.implement.b.a;

import com.uploader.implement.C7399c;
import com.uploader.implement.b.InterfaceC7398e;
import tb.j33;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.g */
/* loaded from: classes11.dex */
public class C7394g extends j33 {
    public final String f;
    public final String g;

    public C7394g(String str, int i, String str2, String str3) {
        super(str, i, null, 0, false);
        this.f = str2;
        this.g = str3;
    }

    @Override // tb.j33
    public InterfaceC7398e a(C7399c c7399c) {
        return new C7391e(c7399c, this);
    }

    @Override // tb.j33
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C7394g) && super.equals(obj)) {
            C7394g c7394g = (C7394g) obj;
            String str = this.f;
            if (str == null ? c7394g.f == null : str.equals(c7394g.f)) {
                String str2 = this.g;
                String str3 = c7394g.g;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }
}
