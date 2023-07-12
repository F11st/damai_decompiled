package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.C7077b;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.web.security.b */
/* loaded from: classes11.dex */
public class C7131b extends C7077b {
    @Override // com.tencent.open.C7077b
    public void a(String str, String str2, List<String> list, C7077b.C7078a c7078a) {
        SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C7077b.C7079b c7079b = this.a.get(str);
        if (c7079b != null) {
            SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            c7079b.call(str2, list, c7078a);
            return;
        }
        SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (c7078a != null) {
            c7078a.a();
        }
    }

    @Override // com.tencent.open.C7077b
    public boolean a(WebView webView, String str) {
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 7) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            String str4 = (String) arrayList.get(4);
            String str5 = (String) arrayList.get(5);
            SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                try {
                    a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new C7132c(webView, Long.parseLong(str4), str, str5));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return false;
    }
}
