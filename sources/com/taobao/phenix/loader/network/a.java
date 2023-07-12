package com.taobao.phenix.loader.network;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.taobao.phenix.loader.network.HttpLoader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Future;
import tb.p22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements HttpLoader {
    private int a = 15000;
    private int b = 10000;

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void connectTimeout(int i) {
        this.a = i;
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public Future<?> load(String str, Map<String, String> map, HttpLoader.FinishCallback finishCallback) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(WVUtils.URL_SEPARATOR)) {
                str = "http:" + str;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(this.a);
            httpURLConnection.setReadTimeout(this.b);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                finishCallback.onFinished(new p22(httpURLConnection.getInputStream(), httpURLConnection.getContentLength()));
                return null;
            }
            finishCallback.onError(new HttpCodeResponseException(responseCode));
            return null;
        } catch (Exception e) {
            finishCallback.onError(e);
            return null;
        }
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void readTimeout(int i) {
        this.b = i;
    }
}
