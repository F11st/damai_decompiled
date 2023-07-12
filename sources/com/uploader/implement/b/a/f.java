package com.uploader.implement.b.a;

import tb.j33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f extends j33 {
    public final boolean f;

    public f(String str, int i, boolean z, boolean z2) {
        super(str, i, null, 0, z);
        this.f = z2;
    }

    @Override // tb.j33
    public com.uploader.implement.b.e a(com.uploader.implement.c cVar) {
        if (this.e) {
            return new d(cVar, this);
        }
        return new d(cVar, this);
    }

    @Override // tb.j33
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && super.equals(obj) && this.f == ((f) obj).f;
    }
}
