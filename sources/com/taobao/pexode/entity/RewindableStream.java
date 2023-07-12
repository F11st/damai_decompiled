package com.taobao.pexode.entity;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class RewindableStream extends InputStream {
    private int mInputType;

    public RewindableStream(int i) {
        this.mInputType = i;
    }

    public void back2StreamType() {
        this.mInputType = 3;
    }

    public abstract byte[] getBuffer();

    public abstract int getBufferLength();

    public abstract int getBufferOffset();

    public abstract FileDescriptor getFD();

    public final int getInputType() {
        return this.mInputType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetInputType(int i) {
        this.mInputType = i;
    }

    public abstract void rewind() throws IOException;

    public abstract void rewindAndSetBufferSize(int i) throws IOException;
}
