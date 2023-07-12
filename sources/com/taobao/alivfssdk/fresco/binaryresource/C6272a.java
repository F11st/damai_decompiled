package com.taobao.alivfssdk.fresco.binaryresource;

import com.taobao.alivfssdk.fresco.common.internal.C6291c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import tb.bu1;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.fresco.binaryresource.a */
/* loaded from: classes8.dex */
public class C6272a implements BinaryResource {
    private final File a;

    private C6272a(File file) {
        this.a = (File) bu1.a(file);
    }

    public static C6272a a(File file) {
        if (file != null) {
            return new C6272a(file);
        }
        return null;
    }

    public File b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C6272a)) {
            return false;
        }
        return this.a.equals(((C6272a) obj).a);
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
        return C6291c.b(this.a);
    }

    @Override // com.taobao.alivfssdk.fresco.binaryresource.BinaryResource
    public long size() {
        return this.a.length();
    }
}
