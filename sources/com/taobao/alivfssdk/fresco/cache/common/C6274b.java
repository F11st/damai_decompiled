package com.taobao.alivfssdk.fresco.cache.common;

import com.taobao.alivfssdk.fresco.common.internal.C6286a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.fresco.cache.common.b */
/* loaded from: classes8.dex */
public class C6274b {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.cache.common.b$a */
    /* loaded from: classes8.dex */
    static class C6275a implements WriterCallback {
        final /* synthetic */ InputStream a;

        C6275a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.common.WriterCallback
        public OutputStream write(OutputStream outputStream) throws IOException {
            C6286a.a(this.a, outputStream);
            return outputStream;
        }
    }

    public static WriterCallback a(InputStream inputStream) {
        return new C6275a(inputStream);
    }
}
