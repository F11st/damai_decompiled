package com.taobao.zcache.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class StandardNetwork extends NetworkAdaptor {
    private HttpURLConnection connection;

    public StandardNetwork(DownloadRequest downloadRequest) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(downloadRequest.url).openConnection();
            this.connection = httpURLConnection;
            int i = downloadRequest.timeout;
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i * 1000);
            }
            this.connection.setInstanceFollowRedirects(true);
            try {
                this.connection.setRequestMethod("GET");
            } catch (ProtocolException unused) {
            }
            HashMap<String, String> hashMap = downloadRequest.header;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            setExceptionError(-3, e);
        }
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public void close() {
        this.connection.disconnect();
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public String getHeaderField(String str) {
        return this.connection.getHeaderField(str);
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public Map<String, List<String>> getOriginHeaderFields() {
        return this.connection.getHeaderFields();
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    protected InputStream getOriginInputStream() {
        try {
            return this.connection.getInputStream();
        } catch (IOException e) {
            setExceptionError(-5, e);
            return null;
        }
    }

    @Override // com.taobao.zcache.network.NetworkAdaptor
    public int getStatusCode() {
        try {
            return this.connection.getResponseCode();
        } catch (IOException e) {
            setExceptionError(-4, e);
            return 0;
        }
    }
}
