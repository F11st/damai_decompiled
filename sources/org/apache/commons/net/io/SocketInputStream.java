package org.apache.commons.net.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SocketInputStream extends FilterInputStream {
    private final Socket __socket;

    public SocketInputStream(Socket socket, InputStream inputStream) {
        super(inputStream);
        this.__socket = socket;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.__socket.close();
    }
}
