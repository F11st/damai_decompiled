package com.taobao.phenix.compat.mtop;

import android.os.RemoteException;
import android.text.TextUtils;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends InputStream {
    ParcelableInputStream a;

    public a(ParcelableInputStream parcelableInputStream) {
        this.a = parcelableInputStream;
    }

    private boolean a(Exception exc) {
        return !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().contains("await timeout");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.a.close();
        } catch (RemoteException e) {
            throw new IOException(e);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.readByte();
        } catch (RemoteException e) {
            throw new IOException(e);
        } catch (RuntimeException e2) {
            if (a(e2)) {
                throw new MtopReadTimeoutException();
            }
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (RemoteException e) {
            throw new IOException(e);
        } catch (RuntimeException e2) {
            if (a(e2)) {
                throw new MtopReadTimeoutException();
            }
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.a.readBytes(bArr, i, i2);
        } catch (RemoteException e) {
            throw new IOException(e);
        } catch (RuntimeException e2) {
            if (a(e2)) {
                throw new MtopReadTimeoutException();
            }
            throw e2;
        }
    }
}
