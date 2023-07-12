package com.taobao.pexode.entity;

import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.taobao.pexode.entity.b */
/* loaded from: classes11.dex */
public class C6836b extends C6837c {
    private boolean i;
    private FileChannel j;
    private long k;
    private FileDescriptor l;

    public C6836b(@NonNull FileInputStream fileInputStream, int i) {
        super(fileInputStream, 0);
        this.j = fileInputStream.getChannel();
        try {
            this.l = fileInputStream.getFD();
        } catch (IOException unused) {
        }
        this.k = -1L;
        FileChannel fileChannel = this.j;
        if (fileChannel != null) {
            try {
                this.k = fileChannel.position();
            } catch (IOException unused2) {
            }
        }
        boolean f = f(null);
        this.i = f;
        if (!f) {
            e(i);
        } else if (this.l != null) {
            resetInputType(2);
        }
    }

    private boolean f(IOException[] iOExceptionArr) {
        long j = this.k;
        if (j >= 0) {
            try {
                this.j.position(j);
                return true;
            } catch (IOException e) {
                if (iOExceptionArr == null || iOExceptionArr.length <= 0) {
                    return false;
                }
                iOExceptionArr[0] = e;
                return false;
            }
        }
        return false;
    }

    @Override // com.taobao.pexode.entity.C6837c, com.taobao.pexode.entity.RewindableStream
    public int getBufferLength() {
        try {
            if (this.j.size() > 0) {
                return (int) this.j.size();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.getBufferLength();
    }

    @Override // com.taobao.pexode.entity.C6837c, com.taobao.pexode.entity.RewindableStream
    public FileDescriptor getFD() {
        return this.l;
    }

    @Override // com.taobao.pexode.entity.C6837c, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.i) {
            return this.a.read(bArr, i, i2);
        }
        return super.read(bArr, i, i2);
    }

    @Override // com.taobao.pexode.entity.C6837c, com.taobao.pexode.entity.RewindableStream
    public void rewind() throws IOException {
        if (this.i) {
            if (!this.h) {
                IOException[] iOExceptionArr = new IOException[1];
                if (f(iOExceptionArr)) {
                    return;
                }
                IOException iOException = iOExceptionArr[0];
                StringBuilder sb = new StringBuilder();
                sb.append("cannot rewind cause file stream reposition(");
                sb.append(this.k);
                sb.append(":");
                sb.append(this.l);
                sb.append(") failed, detail=");
                sb.append(iOException != null ? iOException.getMessage() : "null");
                sb.append(jn1.AND_NOT);
                throw new IOException(sb.toString());
            }
            throw new IOException("cannot rewind cause file stream has been closed!");
        }
        super.rewind();
    }

    @Override // com.taobao.pexode.entity.C6837c, com.taobao.pexode.entity.RewindableStream
    public void rewindAndSetBufferSize(int i) throws IOException {
        rewind();
        e(i);
    }

    @Override // com.taobao.pexode.entity.C6837c, java.io.InputStream
    public int read() throws IOException {
        if (this.i) {
            return this.a.read();
        }
        return super.read();
    }
}
