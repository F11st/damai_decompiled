package com.taobao.alivfssdk.fresco.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.fresco.common.internal.c */
/* loaded from: classes8.dex */
public class C6291c {
    static byte[] a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return j == 0 ? C6286a.b(inputStream) : C6286a.c(inputStream, (int) j);
        }
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    public static byte[] b(File file) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a = a(fileInputStream, fileInputStream.getChannel().size());
            fileInputStream.close();
            return a;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }
}
