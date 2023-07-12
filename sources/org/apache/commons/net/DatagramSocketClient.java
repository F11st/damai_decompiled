package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class DatagramSocketClient {
    private static final DatagramSocketFactory __DEFAULT_SOCKET_FACTORY = new DefaultDatagramSocketFactory();
    private Charset charset = Charset.defaultCharset();
    protected DatagramSocket _socket_ = null;
    protected int _timeout_ = 0;
    protected boolean _isOpen_ = false;
    protected DatagramSocketFactory _socketFactory_ = __DEFAULT_SOCKET_FACTORY;

    public void close() {
        DatagramSocket datagramSocket = this._socket_;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        this._socket_ = null;
        this._isOpen_ = false;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public int getDefaultTimeout() {
        return this._timeout_;
    }

    public InetAddress getLocalAddress() {
        return this._socket_.getLocalAddress();
    }

    public int getLocalPort() {
        return this._socket_.getLocalPort();
    }

    public int getSoTimeout() throws SocketException {
        return this._socket_.getSoTimeout();
    }

    public boolean isOpen() {
        return this._isOpen_;
    }

    public void open() throws SocketException {
        DatagramSocket createDatagramSocket = this._socketFactory_.createDatagramSocket();
        this._socket_ = createDatagramSocket;
        createDatagramSocket.setSoTimeout(this._timeout_);
        this._isOpen_ = true;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setDatagramSocketFactory(DatagramSocketFactory datagramSocketFactory) {
        if (datagramSocketFactory == null) {
            this._socketFactory_ = __DEFAULT_SOCKET_FACTORY;
        } else {
            this._socketFactory_ = datagramSocketFactory;
        }
    }

    public void setDefaultTimeout(int i) {
        this._timeout_ = i;
    }

    public void setSoTimeout(int i) throws SocketException {
        this._socket_.setSoTimeout(i);
    }

    public void open(int i) throws SocketException {
        DatagramSocket createDatagramSocket = this._socketFactory_.createDatagramSocket(i);
        this._socket_ = createDatagramSocket;
        createDatagramSocket.setSoTimeout(this._timeout_);
        this._isOpen_ = true;
    }

    public void open(int i, InetAddress inetAddress) throws SocketException {
        DatagramSocket createDatagramSocket = this._socketFactory_.createDatagramSocket(i, inetAddress);
        this._socket_ = createDatagramSocket;
        createDatagramSocket.setSoTimeout(this._timeout_);
        this._isOpen_ = true;
    }
}
