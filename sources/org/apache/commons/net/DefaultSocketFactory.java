package org.apache.commons.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultSocketFactory extends SocketFactory {
    private final Proxy connProxy;

    public DefaultSocketFactory() {
        this(null);
    }

    public ServerSocket createServerSocket(int i) throws IOException {
        return new ServerSocket(i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        if (this.connProxy != null) {
            return new Socket(this.connProxy);
        }
        return new Socket();
    }

    public DefaultSocketFactory(Proxy proxy) {
        this.connProxy = proxy;
    }

    public ServerSocket createServerSocket(int i, int i2) throws IOException {
        return new ServerSocket(i, i2);
    }

    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        return new ServerSocket(i, i2, inetAddress);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws UnknownHostException, IOException {
        if (this.connProxy != null) {
            Socket socket = new Socket(this.connProxy);
            socket.connect(new InetSocketAddress(str, i));
            return socket;
        }
        return new Socket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.connProxy != null) {
            Socket socket = new Socket(this.connProxy);
            socket.connect(new InetSocketAddress(inetAddress, i));
            return socket;
        }
        return new Socket(inetAddress, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws UnknownHostException, IOException {
        if (this.connProxy != null) {
            Socket socket = new Socket(this.connProxy);
            socket.bind(new InetSocketAddress(inetAddress, i2));
            socket.connect(new InetSocketAddress(str, i));
            return socket;
        }
        return new Socket(str, i, inetAddress, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.connProxy != null) {
            Socket socket = new Socket(this.connProxy);
            socket.bind(new InetSocketAddress(inetAddress2, i2));
            socket.connect(new InetSocketAddress(inetAddress, i));
            return socket;
        }
        return new Socket(inetAddress, i, inetAddress2, i2);
    }
}
