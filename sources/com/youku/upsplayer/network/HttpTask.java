package com.youku.upsplayer.network;

import android.text.TextUtils;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.util.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HttpTask implements INetworkTask {
    private static final String TAG = "HttpTask";
    private String recvData = null;
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;

    protected static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append(SocketClient.NETASCII_EOL);
                    }
                } catch (Exception e) {
                    Logger.e("Util", e.toString());
                }
                try {
                    break;
                } catch (Exception e2) {
                    Logger.e("Util", e2.toString());
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    Logger.e("Util", e3.toString());
                }
                throw th;
            }
        }
        inputStream.close();
        return sb.toString();
    }

    private void setHttps(HttpURLConnection httpURLConnection, URL url) {
        if (url == null || httpURLConnection == null) {
            return;
        }
        String protocol = url.getProtocol();
        if (TextUtils.isEmpty(protocol) || !protocol.equalsIgnoreCase("https")) {
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e(TAG, e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0161 A[Catch: IOException -> 0x01b3, TRY_LEAVE, TryCatch #3 {IOException -> 0x01b3, blocks: (B:6:0x0017, B:8:0x005f, B:9:0x007c, B:11:0x0084, B:12:0x008b, B:14:0x0093, B:15:0x009a, B:17:0x00db, B:37:0x0159, B:39:0x0161, B:26:0x0109, B:27:0x010d, B:36:0x0154, B:46:0x0187, B:18:0x00dd, B:19:0x00f4, B:21:0x00fa, B:22:0x00fe, B:32:0x0114, B:23:0x0104, B:33:0x014f), top: B:56:0x0017, inners: #1, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connectAPI(com.youku.upsplayer.data.RequestData r11) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.upsplayer.network.HttpTask.connectAPI(com.youku.upsplayer.data.RequestData):void");
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        if (requestData == null) {
            return null;
        }
        connectAPI(requestData);
        return new GetInfoResult(this.recvData, this.header, this.connectStat);
    }

    protected String getString(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception unused) {
            return bArr.toString();
        }
    }
}
