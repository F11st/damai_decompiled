package com.taobao.orange.impl;

import android.text.TextUtils;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.OrangeUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HurlNetConnection implements INetConnection {
    private HttpURLConnection httpURLConnection;
    private Map<String, String> params;

    @Override // com.taobao.orange.inner.INetConnection
    public void addHeader(String str, String str2) {
        this.httpURLConnection.addRequestProperty(str, str2);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void connect() throws IOException {
        this.httpURLConnection.connect();
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void disconnect() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public Map<String, List<String>> getHeadFields() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable, java.io.InputStream] */
    @Override // com.taobao.orange.inner.INetConnection
    public String getResponse() throws IOException {
        Closeable closeable;
        ?? r0 = this.httpURLConnection;
        try {
            if (r0 == 0) {
                return null;
            }
            try {
                r0 = r0.getInputStream();
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                closeable = null;
                th = th;
                r0 = 0;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = r0.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                            OrangeUtils.close(r0);
                            OrangeUtils.close(byteArrayOutputStream);
                            return str;
                        }
                    }
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th2) {
                closeable = null;
                th = th2;
                OrangeUtils.close(r0);
                OrangeUtils.close(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public int getResponseCode() throws IOException {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection == null) {
            return 0;
        }
        return httpURLConnection.getResponseCode();
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void openConnection(String str) throws IOException {
        String encodeQueryParams = OrangeUtils.encodeQueryParams(this.params, "utf-8");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(encodeQueryParams)) {
            sb.append(jn1.CONDITION_IF);
            sb.append(encodeQueryParams);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
        this.httpURLConnection = httpURLConnection;
        httpURLConnection.setConnectTimeout(5000);
        this.httpURLConnection.setReadTimeout(5000);
        this.httpURLConnection.setUseCaches(false);
        this.httpURLConnection.setDoInput(true);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setBody(byte[] bArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        OrangeUtils.close(dataOutputStream);
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setMethod(String str) throws ProtocolException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.httpURLConnection.setRequestMethod(str);
        if ("POST".equalsIgnoreCase(str)) {
            this.httpURLConnection.setDoOutput(true);
        }
    }

    @Override // com.taobao.orange.inner.INetConnection
    public void setParams(Map<String, String> map) {
        this.params = map;
    }
}
