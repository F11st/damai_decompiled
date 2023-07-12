package com.taobao.orange.impl;

import android.os.RemoteException;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.aidl.Connection;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.inner.INetConnection;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.c22;
import tb.k60;
import tb.mh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBNetConnection implements INetConnection {
    private Connection connection;
    private k60 network;
    private Map<String, String> params;
    private Request request;

    @Override // com.taobao.orange.inner.INetConnection
    public void addHeader(String str, String str2) {
        Request request = this.request;
        if (request != null) {
            request.addHeader(str, str2);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void connect() throws IOException {
        this.connection = this.network.getConnection(this.request, null);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void disconnect() {
        try {
            Connection connection = this.connection;
            if (connection != null) {
                connection.cancel();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public Map<String, List<String>> getHeadFields() {
        Connection connection = this.connection;
        if (connection == null) {
            return null;
        }
        try {
            return connection.getConnHeadFields();
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.taobao.orange.inner.INetConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getResponse() throws java.io.IOException {
        /*
            r6 = this;
            anetwork.channel.aidl.Connection r0 = r6.connection
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            anetwork.channel.aidl.ParcelableInputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L42
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L33 android.os.RemoteException -> L38
            r2.<init>()     // Catch: java.lang.Throwable -> L33 android.os.RemoteException -> L38
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
        L13:
            int r3 = r0.read(r1)     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
            r4 = -1
            if (r3 == r4) goto L1f
            r4 = 0
            r2.write(r1, r4, r3)     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
            goto L13
        L1f:
            java.lang.String r1 = new java.lang.String     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
            byte[] r3 = r2.toByteArray()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
            java.lang.String r4 = "utf-8"
            r1.<init>(r3, r4)     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L4c
            r0.close()     // Catch: android.os.RemoteException -> L2d
        L2d:
            com.taobao.orange.util.OrangeUtils.close(r2)
            return r1
        L31:
            r1 = move-exception
            goto L46
        L33:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L4d
        L38:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L46
        L3d:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L4d
        L42:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L46:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L4c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L4c
            throw r3     // Catch: java.lang.Throwable -> L4c
        L4c:
            r1 = move-exception
        L4d:
            if (r0 == 0) goto L52
            r0.close()     // Catch: android.os.RemoteException -> L52
        L52:
            com.taobao.orange.util.OrangeUtils.close(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.impl.TBNetConnection.getResponse():java.lang.String");
    }

    @Override // com.taobao.orange.inner.INetConnection
    public int getResponseCode() throws IOException {
        Connection connection = this.connection;
        if (connection == null) {
            return 0;
        }
        try {
            return connection.getStatusCode();
        } catch (RemoteException e) {
            throw new IOException(e);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void openConnection(String str) throws IOException {
        this.network = new k60(GlobalOrange.context);
        c22 c22Var = new c22(str);
        this.request = c22Var;
        c22Var.setCharset("utf-8");
        this.request.setConnectTimeout(5000);
        this.request.setReadTimeout(5000);
        Map<String, String> map = this.params;
        if (map == null || map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            arrayList.add(new mh2(entry.getKey(), entry.getValue()));
        }
        this.request.setParams(arrayList);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setBody(byte[] bArr) throws IOException {
        Request request = this.request;
        if (request != null) {
            request.setBodyEntry(new ByteArrayEntry(bArr));
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setMethod(String str) throws ProtocolException {
        Request request = this.request;
        if (request != null) {
            request.setMethod(str);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setParams(Map<String, String> map) {
        this.params = map;
    }
}
