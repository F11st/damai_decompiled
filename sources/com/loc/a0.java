package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.loc.m;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a0 extends SSLSocketFactory {
    private SSLSocketFactory a;
    private Context b;
    private SSLContext c;

    public a0(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.b = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    an.m(th, "myssl", "<init>");
                    try {
                        if (this.c == null && Build.VERSION.SDK_INT >= 9) {
                            this.c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        an.m(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.a == null) {
                            this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        an.m(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (Throwable th4) {
                    try {
                        if (this.c == null && Build.VERSION.SDK_INT >= 9) {
                            this.c = SSLContext.getDefault();
                        }
                    } catch (Throwable th5) {
                        an.m(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.a == null) {
                            this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th6) {
                        an.m(th6, "myssl", "<init3>");
                    }
                    throw th4;
                }
            }
        }
        this.c = sSLContext;
        if (sSLContext != null) {
            this.a = sSLContext.getSocketFactory();
        }
        try {
            if (this.c == null && Build.VERSION.SDK_INT >= 9) {
                this.c = SSLContext.getDefault();
            }
        } catch (Throwable th7) {
            an.m(th7, "myssl", "<init2>");
        }
        try {
            if (this.a == null) {
                this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th8) {
            an.m(th8, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && m.f.b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            an.m(th, "myssl", "stlv2");
        }
        return socket;
    }

    private void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(v1.v("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String v = v1.v("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(v)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            an.m(th, "myssl", "isc2");
        }
    }

    private static void d(Socket socket) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && m.f.c && m.f.e && (socket instanceof SSLSocket)) {
            int i2 = m.f.f;
            int i3 = m.f.d;
            if (i2 <= i3) {
                i3 = m.f.f;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(v1.v("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    an.m(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && m.f.c && this.b != null && this.c != null) {
            int i2 = m.f.d;
            if (i2 <= 17 || i <= i2) {
                SSLSessionCache sSLSessionCache = new SSLSessionCache(this.b);
                if (i <= 20 || i >= 28) {
                    c(sSLSessionCache);
                    return;
                }
                try {
                    sSLSessionCache.getClass().getMethod(v1.v("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.c);
                } catch (Throwable th) {
                    an.m(th, "myssl", "isc1");
                    c(sSLSessionCache);
                }
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket());
                d(a);
                return a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket(str, i));
                d(a);
                return a;
            }
            return null;
        } catch (Throwable th) {
            an.m(th, "myssl", "cs3");
            if (th instanceof UnknownHostException) {
                throw th;
            }
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
                d(a);
                return a;
            }
            return null;
        } catch (Throwable th) {
            an.m(th, "myssl", "cs4");
            if (th instanceof UnknownHostException) {
                throw th;
            }
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket(inetAddress, i));
                d(a);
                return a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
                d(a);
                return a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        boolean z2;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                Socket a = a(sSLSocketFactory.createSocket(socket, str, i, z));
                d(a);
                return a;
            }
            return null;
        } finally {
            if (!z2) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            an.m(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            an.m(th, "myssl", "gscs");
        }
        return new String[0];
    }
}
