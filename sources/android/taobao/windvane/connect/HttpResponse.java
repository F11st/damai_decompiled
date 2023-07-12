package android.taobao.windvane.connect;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HttpResponse {
    private int httpCode = 0;
    private String errorMsg = null;
    private Map<String, String> headers = new HashMap();
    private byte[] data = null;

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public byte[] getData() {
        return this.data;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public boolean isSuccess() {
        return this.httpCode == 200;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setHeaders(Map<String, String> map) {
        if (map != null) {
            this.headers = map;
        }
    }

    public void setHttpCode(int i) {
        this.httpCode = i;
    }
}
