package com.uploader.implement.b.a;

import com.uploader.implement.C7399c;
import com.uploader.implement.b.InterfaceC7398e;
import tb.j33;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.f */
/* loaded from: classes11.dex */
public class C7393f extends j33 {
    public final boolean f;

    public C7393f(String str, int i, boolean z, boolean z2) {
        super(str, i, null, 0, z);
        this.f = z2;
    }

    @Override // tb.j33
    public InterfaceC7398e a(C7399c c7399c) {
        if (this.e) {
            return new C7389d(c7399c, this);
        }
        return new C7389d(c7399c, this);
    }

    @Override // tb.j33
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C7393f) && super.equals(obj) && this.f == ((C7393f) obj).f;
    }
}
