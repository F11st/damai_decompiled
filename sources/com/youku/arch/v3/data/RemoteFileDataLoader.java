package com.youku.arch.v3.data;

import android.net.Uri;
import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.jsbridge.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.kh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/data/RemoteFileDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "", a.V, "getJSONData", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/wt2;", "process", "Ljava/io/InputStream;", "inStream", "", kh1.OPERATION_READ, "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RemoteFileDataLoader implements DataLoader<RequestContext> {
    private static transient /* synthetic */ IpChange $ipChange;

    private final String getJSONData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613200760")) {
            return (String) ipChange.ipc$dispatch("-1613200760", new Object[]{this, str});
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(1000);
                httpURLConnection.setReadTimeout(1000);
                httpURLConnection.setRequestMethod("GET");
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    b41.h(inputStream, "`in`");
                    byte[] read = read(inputStream);
                    Charset forName = Charset.forName("UTF-8");
                    b41.h(forName, "forName(\"UTF-8\")");
                    return new String(read, forName);
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        Uri uri;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1745706131")) {
            ipChange.ipc$dispatch("-1745706131", new Object[]{this, chain});
            return;
        }
        b41.i(chain, "chain");
        RequestContext param = chain.getParam();
        IRequest request = param.getRequest();
        Bundle bundle = request.getBundle();
        if (bundle != null && (uri = (Uri) bundle.getParcelable("uri")) != null && (b41.d("http", uri.getScheme()) || b41.d("https", uri.getScheme()))) {
            Response build = new Response.Builder().setId(request.getId()).setSource(Constants.ResponseSource.REMOTE_FILE).setTimestamp(System.currentTimeMillis()).build();
            JSONObject jSONObject = new JSONObject();
            String jSONData = getJSONData(uri.toString());
            if (jSONData != null && jSONData.length() != 0) {
                z = false;
            }
            if (z) {
                build.setRetCode("FAIL");
                build.setRetMessage("小二很忙，请稍后再试");
                jSONObject.put((JSONObject) "data", (String) new JSONObject());
            } else {
                build.setRetCode("SUCCESS");
                build.setRetMessage("调用成功");
                jSONObject.put((JSONObject) "data", (String) JSON.parseObject(jSONData));
            }
            build.setJsonObject(jSONObject);
            build.setRawData(jSONObject.toJSONString());
            param.setResponse(build);
            DataLoadCallback callback = param.getCallback();
            if (callback != null) {
                callback.onFilter(build);
            }
            DataLoadCallback callback2 = param.getCallback();
            if (callback2 != null) {
                callback2.onResponse(build);
            }
        }
        chain.proceed();
    }

    @NotNull
    public final byte[] read(@NotNull InputStream inputStream) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089100040")) {
            return (byte[]) ipChange.ipc$dispatch("1089100040", new Object[]{this, inputStream});
        }
        b41.i(inputStream, "inStream");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                b41.h(byteArray, "outStream.toByteArray()");
                return byteArray;
            }
        }
    }
}
