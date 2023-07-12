package android.taobao.windvane.connect.api;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ApiRequest {
    private Map<String, String> params = new HashMap();
    private Map<String, String> dataParams = new HashMap();
    private boolean isSec = false;

    public void addDataParam(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.dataParams.put(str, str2);
    }

    public void addDataParams(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addDataParam(entry.getKey(), entry.getValue());
        }
    }

    public void addParam(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.params.put(str, str2);
    }

    public String getDataParam(String str) {
        return this.dataParams.get(str);
    }

    public Map<String, String> getDataParams() {
        return this.dataParams;
    }

    public String getParam(String str) {
        return this.params.get(str);
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public boolean isSec() {
        return this.isSec;
    }

    public void removeParam(String str) {
        this.params.remove(str);
    }

    public void setSec(boolean z) {
        this.isSec = z;
    }
}
