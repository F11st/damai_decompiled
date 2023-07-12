package tb;

import android.text.TextUtils;
import com.taobao.downloader.download.protocol.DLConnection;
import com.taobao.downloader.download.protocol.DLInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import mtopsdk.network.util.Constants;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iv0 implements DLConnection {
    protected HttpURLConnection a;

    private String a(String str, int i) {
        String str2;
        List<String> ipPorts;
        if (um.i == null) {
            return str;
        }
        try {
            URL url = new URL(str);
            String host = url.getHost();
            int port = url.getPort();
            if (port == -1) {
                str2 = host;
            } else {
                str2 = host + ":" + port;
            }
            ipPorts = um.i.getIpPorts(host);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (ipPorts.isEmpty()) {
            return str;
        }
        String str3 = ipPorts.get(i % ipPorts.size());
        if (!TextUtils.isEmpty(str3)) {
            return str.replaceFirst(str2, str3);
        }
        return str;
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public void addRequestProperty(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public void connect() throws IOException {
        this.a.connect();
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public void disConnect() {
        this.a.disconnect();
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public long getDownloadLength() {
        String headerField = this.a.getHeaderField(Constants.Protocol.CONTENT_LENGTH);
        if (TextUtils.isEmpty(headerField) || !TextUtils.isDigitsOnly(headerField)) {
            return 0L;
        }
        return Long.valueOf(headerField).longValue();
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public String getErrorMsg() {
        if (this.a == null) {
            return "HttpResponse is empty!";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getResponseCode());
            sb.append(StringUtils.LF);
            sb.append(this.a.getResponseMessage());
            sb.append(StringUtils.LF);
            Map<String, List<String>> headerFields = this.a.getHeaderFields();
            for (String str : headerFields.keySet()) {
                sb.append((Object) str);
                sb.append(":");
                sb.append(headerFields.get(str));
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        } catch (Throwable th) {
            ka0.d("hucCon", "getErrorMsg", th, new Object[0]);
            return "";
        }
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public String getHeaderField(String str) {
        return this.a.getHeaderField(str);
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public DLInputStream getInputStream() throws IOException {
        return new jv0(this.a.getInputStream());
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public int getStatusCode() throws Exception {
        return this.a.getResponseCode();
    }

    @Override // com.taobao.downloader.download.protocol.DLConnection
    public void openConnection(URL url, qq qqVar) throws IOException {
        if (url.getProtocol().equals("http") && !qqVar.d()) {
            url = new URL(a(url.toString(), qqVar.a()));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        this.a = httpURLConnection;
        httpURLConnection.setConnectTimeout(qqVar.b());
        this.a.setReadTimeout(qqVar.c());
        this.a.setInstanceFollowRedirects(qq.i);
    }
}
