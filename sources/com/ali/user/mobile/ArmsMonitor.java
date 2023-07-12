package com.ali.user.mobile;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.login4android.config.LoginSwitch;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ArmsMonitor {
    private static final String TAG = "ArmsMonitorAdapter";
    private static Context context;
    private static final TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: com.ali.user.mobile.ArmsMonitor.2
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};

    private static String buildData(Context context2, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse("?").buildUpon();
        try {
            buildUpon.appendQueryParameter("p1", str).appendQueryParameter("p2", str2).appendQueryParameter("type", "action").appendQueryParameter("app_version", Mtop.instance(context2).getMtopConfig().appVersion).appendQueryParameter("sdk_version", "1.0").appendQueryParameter("uid", Mtop.instance(context2).getUserId()).appendQueryParameter("sid", Mtop.instance(context2).getSid()).appendQueryParameter(PushConstants.DEVICE_ID, Mtop.instance(context2).getDeviceId()).appendQueryParameter("ua", Mtop.instance(context2).getTtid()).appendQueryParameter("env", "pre").appendQueryParameter("pid", Mtop.instance(context2).getMtopConfig().appKey);
            JSONObject parseObject = JSON.parseObject(str3);
            if (parseObject != null) {
                buildUpon.appendQueryParameter("p3", parseObject.getString("action")).appendQueryParameter("p4", parseObject.getString("type")).appendQueryParameter("p5", parseObject.getString("status")).appendQueryParameter("p6", parseObject.getString("code")).appendQueryParameter("p7", parseObject.getString(SocialConstants.PARAM_COMMENT)).appendQueryParameter("p8", parseObject.getString("duration")).appendQueryParameter("p9", parseObject.getString("traceid")).appendQueryParameter("url", parseObject.getString("page")).appendQueryParameter("title", parseObject.getString("page"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gmkey", (Object) "OTHER");
        jSONObject.put("logtype", (Object) "2");
        jSONObject.put("gokey", (Object) buildUpon.build().toString());
        return jSONObject.toJSONString();
    }

    public static void commitSuccess(String str, String str2, String str3) {
        commitSuccess(context, str, str2, str3);
    }

    public static void init(Context context2) {
        context = context2;
    }

    private static void sendRequestToArms(final String str) {
        new Thread(new Runnable() { // from class: com.ali.user.mobile.ArmsMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                StringBuffer stringBuffer = new StringBuffer();
                String str2 = "";
                HttpsURLConnection httpsURLConnection = null;
                try {
                    try {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL("https://s-gm.mmstat.com/arms.1.1").openConnection();
                        try {
                            httpsURLConnection2.setRequestMethod("POST");
                            httpsURLConnection2.setConnectTimeout(5000);
                            httpsURLConnection2.setReadTimeout(5000);
                            httpsURLConnection2.setRequestProperty(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                            httpsURLConnection2.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.setDoOutput(true);
                            ArmsMonitor.trustAllHosts(httpsURLConnection2);
                            OutputStream outputStream = httpsURLConnection2.getOutputStream();
                            outputStream.write(str.getBytes());
                            outputStream.flush();
                            outputStream.close();
                            if (httpsURLConnection2.getResponseCode() == 200) {
                                InputStream inputStream = httpsURLConnection2.getInputStream();
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                str2 = bufferedReader.readLine();
                                if (str2 != null) {
                                    stringBuffer.append(str2);
                                }
                                inputStream.close();
                                bufferedReader.close();
                            } else {
                                Log.e(ArmsMonitor.TAG, "code:" + httpsURLConnection2.getResponseCode());
                            }
                            httpsURLConnection2.disconnect();
                        } catch (Exception e) {
                            e = e;
                            httpsURLConnection = httpsURLConnection2;
                            e.printStackTrace();
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            Log.d(ArmsMonitor.TAG, "result: " + str2);
                        } catch (Throwable th) {
                            th = th;
                            httpsURLConnection = httpsURLConnection2;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                Log.d(ArmsMonitor.TAG, "result: " + str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SSLSocketFactory trustAllHosts(HttpsURLConnection httpsURLConnection) {
        SSLSocketFactory sSLSocketFactory = httpsURLConnection.getSSLSocketFactory();
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustAllCerts, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sSLSocketFactory;
    }

    public static void commitSuccess(Context context2, String str, String str2, String str3) {
        if (context2 == null) {
            Log.d(TAG, "请先初始化或者传入context ");
        } else if (LoginSwitch.isInABTestRegion("armsMonitor", 100)) {
            sendRequestToArms(buildData(context2, str, str2, str3));
        }
    }
}
