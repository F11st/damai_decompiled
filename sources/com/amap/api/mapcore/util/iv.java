package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class iv extends jb {
    ByteArrayOutputStream a;

    public iv() {
        this.a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.mapcore.util.jb
    protected byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.mapcore.util.jb
    public void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public iv(jb jbVar) {
        super(jbVar);
        this.a = new ByteArrayOutputStream();
    }
}
