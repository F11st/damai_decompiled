package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ix extends ByteArrayOutputStream {
    public ix() {
    }

    public ix(int i) {
        super(i);
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1090a() {
        return ((ByteArrayOutputStream) this).buf;
    }
}
