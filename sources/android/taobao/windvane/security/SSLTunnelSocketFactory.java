package android.taobao.windvane.security;

import android.taobao.windvane.util.TaoLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SSLTunnelSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory dfactory;
    private String tunnelHost;
    private int tunnelPort;
    private String useragent;

    public SSLTunnelSocketFactory(String str, int i, SSLSocketFactory sSLSocketFactory, String str2) {
        this.tunnelHost = str;
        this.tunnelPort = i;
        if (sSLSocketFactory != null) {
            this.dfactory = sSLSocketFactory;
        } else {
            this.dfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
        this.useragent = str2;
    }

    private void doTunnelHandshake(Socket socket, String str, int i) throws IOException {
        byte[] bytes;
        String str2;
        OutputStream outputStream = socket.getOutputStream();
        String str3 = "CONNECT " + str + ":" + i + " HTTP/1.1\nUser-Agent: " + this.useragent + "\nHost:" + str + "\r\n\r\n";
        try {
            bytes = str3.getBytes("ASCII7");
        } catch (UnsupportedEncodingException unused) {
            bytes = str3.getBytes();
        }
        outputStream.write(bytes);
        outputStream.flush();
        byte[] bArr = new byte[200];
        InputStream inputStream = socket.getInputStream();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < 2) {
            int read = inputStream.read();
            if (read < 0) {
                throw new IOException("Unexpected EOF from proxy");
            }
            if (read == 10) {
                i2++;
                z = true;
            } else if (read != 13) {
                if (!z && i3 < 200) {
                    bArr[i3] = (byte) read;
                    i3++;
                }
                i2 = 0;
            }
        }
        try {
            str2 = new String(bArr, 0, i3, "ASCII7");
        } catch (UnsupportedEncodingException unused2) {
            str2 = new String(bArr, 0, i3);
        }
        if (str2.toLowerCase().indexOf("200 connection established") != -1) {
            return;
        }
        throw new IOException("Unable to tunnel through " + this.tunnelHost + ":" + this.tunnelPort + ".  Proxy returns \"" + str2 + "\"");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return createSocket((Socket) null, str, i, true);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.dfactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.dfactory.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return createSocket((Socket) null, str, i, true);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket((Socket) null, inetAddress.getHostName(), i, true);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket((Socket) null, inetAddress.getHostName(), i, true);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        Socket socket2 = new Socket(this.tunnelHost, this.tunnelPort);
        doTunnelHandshake(socket2, str, i);
        SSLSocket sSLSocket = (SSLSocket) this.dfactory.createSocket(socket2, str, i, z);
        sSLSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() { // from class: android.taobao.windvane.security.SSLTunnelSocketFactory.1
            @Override // javax.net.ssl.HandshakeCompletedListener
            public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                TaoLog.d("tag", "Handshake finished!");
                TaoLog.d("tag", "\t CipherSuite:" + handshakeCompletedEvent.getCipherSuite());
                TaoLog.d("tag", "\t SessionId " + handshakeCompletedEvent.getSession());
                TaoLog.d("tag", "\t PeerHost " + handshakeCompletedEvent.getSession().getPeerHost());
            }
        });
        sSLSocket.startHandshake();
        return sSLSocket;
    }
}
