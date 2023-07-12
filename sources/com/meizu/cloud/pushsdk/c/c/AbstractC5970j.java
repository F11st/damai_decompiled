package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.C5987g;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5983c;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5993m;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.j */
/* loaded from: classes10.dex */
public abstract class AbstractC5970j {
    public static AbstractC5970j a(final C5964g c5964g, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new AbstractC5970j() { // from class: com.meizu.cloud.pushsdk.c.c.j.2
            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public C5964g a() {
                return C5964g.this;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public void a(InterfaceC5983c interfaceC5983c) throws IOException {
                InterfaceC5993m interfaceC5993m = null;
                try {
                    interfaceC5993m = C5987g.a(file);
                    interfaceC5983c.a(interfaceC5993m);
                } finally {
                    C5974m.a(interfaceC5993m);
                }
            }

            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public long b() {
                return file.length();
            }
        };
    }

    public static AbstractC5970j a(C5964g c5964g, String str) {
        Charset charset = C5974m.c;
        if (c5964g != null) {
            Charset b = c5964g.b();
            if (b == null) {
                c5964g = C5964g.a(c5964g + "; charset=utf-8");
            } else {
                charset = b;
            }
        }
        return a(c5964g, str.getBytes(charset));
    }

    public static AbstractC5970j a(C5964g c5964g, byte[] bArr) {
        return a(c5964g, bArr, 0, bArr.length);
    }

    public static AbstractC5970j a(final C5964g c5964g, final byte[] bArr, final int i, final int i2) {
        Objects.requireNonNull(bArr, "content == null");
        C5974m.a(bArr.length, i, i2);
        return new AbstractC5970j() { // from class: com.meizu.cloud.pushsdk.c.c.j.1
            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public C5964g a() {
                return C5964g.this;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public void a(InterfaceC5983c interfaceC5983c) throws IOException {
                interfaceC5983c.c(bArr, i, i2);
            }

            @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
            public long b() {
                return i2;
            }
        };
    }

    public abstract C5964g a();

    public abstract void a(InterfaceC5983c interfaceC5983c) throws IOException;

    public long b() throws IOException {
        return -1L;
    }
}
