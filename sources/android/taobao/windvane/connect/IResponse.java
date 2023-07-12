package android.taobao.windvane.connect;

import android.taobao.windvane.monitor.WVPerformanceMonitorInterface;
import android.taobao.windvane.util.CommonUtils;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class IResponse {
    private int StatusCode;
    private byte[] data;
    private String desc;
    private String encoding;
    private String mimeType;
    public WVPerformanceMonitorInterface.NetStat mNetstat = new WVPerformanceMonitorInterface.NetStat();
    private Map<String, String> headersMap = new HashMap();

    public byte[] getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Map<String, String> getHeadersMap() {
        return this.headersMap;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setHeadMap(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                List<String> list = map.get(str);
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        this.headersMap.put(str, list.get(i));
                    }
                }
            }
            String str2 = this.headersMap.get("content-type");
            if (str2 != null) {
                this.mimeType = CommonUtils.parseMimeType(str2);
                String parseCharset = CommonUtils.parseCharset(str2);
                this.encoding = parseCharset;
                this.encoding = TextUtils.isEmpty(parseCharset) ? "utf-8" : this.encoding;
            }
        }
    }

    public void setStatusCode(int i) {
        this.StatusCode = i;
    }
}
