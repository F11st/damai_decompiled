package com.xiaomi.push;

import com.xiaomi.push.jb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iy {
    private final jf a;

    /* renamed from: a  reason: collision with other field name */
    private final jo f788a;

    public iy() {
        this(new jb.a());
    }

    public iy(jh jhVar) {
        jo joVar = new jo();
        this.f788a = joVar;
        this.a = jhVar.a(joVar);
    }

    public void a(iu iuVar, byte[] bArr) {
        try {
            this.f788a.a(bArr);
            iuVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
