package com.taobao.alivfssdk.fresco.binaryresource;

import com.taobao.alivfssdk.fresco.common.internal.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import tb.bu1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a implements BinaryResource {
    private final File a;

    private a(File file) {
        this.a = (File) bu1.a(file);
    }

    public static a a(File file) {
        if (file != null) {
            return new a(file);
        }
        return null;
    }

    public File b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return this.a.equals(((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.taobao.alivfssdk.fresco.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        return new FileInputStream(this.a);
    }

    @Override // com.taobao.alivfssdk.fresco.binaryresource.BinaryResource
    public byte[] read() throws IOException {
        return c.b(this.a);
    }

    @Override // com.taobao.alivfssdk.fresco.binaryresource.BinaryResource
    public long size() {
        return this.a.length();
    }
}
