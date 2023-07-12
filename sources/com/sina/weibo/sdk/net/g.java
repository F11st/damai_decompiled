package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class g implements f {
    private int code;
    private InputStream p;

    public g(int i, InputStream inputStream) {
        this.code = i;
        this.p = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.f
    public final String f() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.p.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
