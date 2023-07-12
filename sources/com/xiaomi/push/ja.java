package com.xiaomi.push;

import com.xiaomi.push.jb;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ja {
    private jf a;

    /* renamed from: a  reason: collision with other field name */
    private final jm f792a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f793a;

    public ja() {
        this(new jb.C7681a());
    }

    public ja(jh jhVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f793a = byteArrayOutputStream;
        jm jmVar = new jm(byteArrayOutputStream);
        this.f792a = jmVar;
        this.a = jhVar.a(jmVar);
    }

    public byte[] a(iu iuVar) {
        this.f793a.reset();
        iuVar.b(this.a);
        return this.f793a.toByteArray();
    }
}
