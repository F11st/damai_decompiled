package com.taobao.slide.request;

import android.content.Context;
import android.os.RemoteException;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.c22;
import tb.k60;
import tb.mh2;
import tb.nl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e implements IConnection {
    private Context a;
    private Request b;
    private k60 c;
    private Connection d;
    private Map<String, String> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.a = context;
    }

    @Override // com.taobao.slide.request.IConnection
    public void addHeader(String str, String str2) {
        this.b.addHeader(str, str2);
    }

    @Override // com.taobao.slide.request.IConnection
    public void connect() {
        this.d = this.c.getConnection(this.b, null);
    }

    @Override // com.taobao.slide.request.IConnection
    public void disconnect() {
        try {
            Connection connection = this.d;
            if (connection != null) {
                connection.cancel();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public Map<String, List<String>> getHeadFields() {
        Connection connection = this.d;
        if (connection == null) {
            return null;
        }
        try {
            return connection.getConnHeadFields();
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [anetwork.channel.aidl.Connection] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Override // com.taobao.slide.request.IConnection
    public String getResponse() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r0 = this.d;
        ParcelableInputStream parcelableInputStream = null;
        try {
            if (r0 == 0) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (RemoteException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                r0 = 0;
                if (0 != 0) {
                    try {
                        parcelableInputStream.close();
                    } catch (RemoteException unused) {
                    }
                }
                nl.a(r0);
                throw th;
            }
            try {
                ParcelableInputStream inputStream = this.d.getInputStream();
                if (inputStream != null) {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (RemoteException unused2) {
                    }
                }
                nl.a(byteArrayOutputStream);
                return str;
            } catch (RemoteException e2) {
                e = e2;
                throw new IOException(e);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public int getResponseCode() throws IOException {
        Connection connection = this.d;
        if (connection == null) {
            return 0;
        }
        try {
            return connection.getStatusCode();
        } catch (RemoteException e) {
            throw new IOException(e);
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public void openConnection(String str) {
        this.c = new k60(this.a);
        c22 c22Var = new c22(str);
        this.b = c22Var;
        c22Var.setCharset("UTF-8");
        this.b.setConnectTimeout(5000);
        this.b.setReadTimeout(5000);
        Map<String, String> map = this.e;
        if (map == null || map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.e.entrySet()) {
            arrayList.add(new mh2(entry.getKey(), entry.getValue()));
        }
        this.b.setParams(arrayList);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setBody(byte[] bArr) {
        this.b.setBodyEntry(new ByteArrayEntry(bArr));
    }

    @Override // com.taobao.slide.request.IConnection
    public void setMethod(String str) {
        this.b.setMethod(str);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setParams(Map<String, String> map) {
        this.e = map;
    }
}
