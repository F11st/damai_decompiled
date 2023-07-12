package cn.damai.pay.alipay;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetworkManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final String TAG = "NetworkManager";
    Context mContext;
    private int connectTimeout = 30000;
    private int readTimeout = 30000;
    Proxy mProxy = null;

    public NetworkManager(Context context) {
        this.mContext = context;
        setDefaultHostnameVerifier();
    }

    private void setDefaultHostnameVerifier() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417342193")) {
            ipChange.ipc$dispatch("-1417342193", new Object[]{this});
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: cn.damai.pay.alipay.NetworkManager.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1243631952")) {
                        return ((Boolean) ipChange2.ipc$dispatch("1243631952", new Object[]{this, str, sSLSession})).booleanValue();
                    }
                    return true;
                }
            });
        }
    }

    public String SendAndWaitResponse(String str, String str2) {
        IOException e;
        String str3;
        HttpURLConnection httpURLConnection;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666308834")) {
            return (String) ipChange.ipc$dispatch("-1666308834", new Object[]{this, str, str2});
        }
        detectProxy();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("requestData", str));
        HttpURLConnection httpURLConnection2 = null;
        String str4 = null;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
                URL url = new URL(str2);
                Proxy proxy = this.mProxy;
                if (proxy != null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                try {
                    httpURLConnection.setConnectTimeout(this.connectTimeout);
                    httpURLConnection.setReadTimeout(this.readTimeout);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    urlEncodedFormEntity.writeTo(outputStream);
                    outputStream.flush();
                    str4 = BaseHelper.convertStreamToString(httpURLConnection.getInputStream());
                    BaseHelper.log(TAG, "response " + str4);
                    httpURLConnection.disconnect();
                    return str4;
                } catch (IOException e2) {
                    e = e2;
                    HttpURLConnection httpURLConnection4 = httpURLConnection;
                    str3 = str4;
                    httpURLConnection2 = httpURLConnection4;
                    e.printStackTrace();
                    httpURLConnection2.disconnect();
                    return str3;
                } catch (Throwable th) {
                    HttpURLConnection httpURLConnection5 = httpURLConnection;
                    th = th;
                    httpURLConnection3 = httpURLConnection5;
                    httpURLConnection3.disconnect();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                str3 = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void detectProxy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678681624")) {
            ipChange.ipc$dispatch("-678681624", new Object[]{this});
            return;
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.mContext.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0) {
            String defaultHost = android.net.Proxy.getDefaultHost();
            int defaultPort = android.net.Proxy.getDefaultPort();
            if (defaultHost != null) {
                this.mProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort));
            }
        }
    }

    public boolean urlDownloadToFile(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905920891")) {
            return ((Boolean) ipChange.ipc$dispatch("1905920891", new Object[]{this, context, str, str2})).booleanValue();
        }
        detectProxy();
        try {
            URL url = new URL(str);
            Proxy proxy = this.mProxy;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(this.connectTimeout);
            httpURLConnection.setReadTimeout(this.readTimeout);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
