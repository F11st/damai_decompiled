package com.taobao.zcache.model;

import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCacheResourceResponse {
    public static final String ZCACHE_INFO = "X-ZCache-Info";
    public static final String ZCACHE_NO_HEADER = "NO_HEADER";
    public static final String ZCACHE_NO_RESPONSE = "NO_RESPONSE";
    public String encoding;
    public Map<String, String> headers;
    public InputStream inputStream;
    public boolean isSuccess = false;
    public String mimeType;
    public int status;
    public String zcacheInfo;

    public void insertZCacheInfo(String str, long j, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.put("X-ZCache-Info", str + JSMethod.NOT_SET + j + JSMethod.NOT_SET + str2);
    }
}
