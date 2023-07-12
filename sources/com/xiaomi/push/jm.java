package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jm extends jp {
    protected InputStream a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f805a;

    protected jm() {
        this.a = null;
        this.f805a = null;
    }

    public jm(OutputStream outputStream) {
        this.a = null;
        this.f805a = null;
        this.f805a = outputStream;
    }

    @Override // com.xiaomi.push.jp
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new jq(4);
            } catch (IOException e) {
                throw new jq(0, e);
            }
        }
        throw new jq(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.jp
    /* renamed from: a  reason: collision with other method in class */
    public void mo1113a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f805a;
        if (outputStream == null) {
            throw new jq(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jq(0, e);
        }
    }
}
