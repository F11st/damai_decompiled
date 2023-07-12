package com.taobao.slide.request;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import tb.jn1;
import tb.nl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d implements IConnection {
    private HttpURLConnection a;
    private Map<String, String> b;

    @Override // com.taobao.slide.request.IConnection
    public void addHeader(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // com.taobao.slide.request.IConnection
    public void connect() throws IOException {
        this.a.connect();
    }

    @Override // com.taobao.slide.request.IConnection
    public void disconnect() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public Map<String, List<String>> getHeadFields() {
        return this.a.getHeaderFields();
    }

    @Override // com.taobao.slide.request.IConnection
    public String getResponse() throws IOException {
        Closeable closeable;
        Throwable th;
        InputStream inputStream;
        try {
            try {
                inputStream = this.a.getInputStream();
            } catch (IOException e) {
                throw e;
            } catch (Throwable th2) {
                closeable = null;
                th = th2;
                inputStream = null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e2) {
                        throw e2;
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                nl.a(inputStream);
                nl.a(byteArrayOutputStream);
                return str;
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th3) {
                closeable = null;
                th = th3;
                nl.a(inputStream);
                nl.a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public int getResponseCode() throws IOException {
        return this.a.getResponseCode();
    }

    @Override // com.taobao.slide.request.IConnection
    public void openConnection(String str) throws IOException {
        String b = nl.b(this.b, "UTF-8");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(b)) {
            sb.append(jn1.CONDITION_IF);
            sb.append(b);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
        this.a = httpURLConnection;
        httpURLConnection.setConnectTimeout(5000);
        this.a.setReadTimeout(5000);
        this.a.setUseCaches(false);
        this.a.setDoInput(true);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setBody(byte[] bArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        nl.a(dataOutputStream);
    }

    @Override // com.taobao.slide.request.IConnection
    public void setMethod(String str) throws ProtocolException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setRequestMethod(str);
        if ("POST".equalsIgnoreCase(str)) {
            this.a.setDoOutput(true);
        }
    }

    @Override // com.taobao.slide.request.IConnection
    public void setParams(Map<String, String> map) {
        this.b = map;
    }
}
