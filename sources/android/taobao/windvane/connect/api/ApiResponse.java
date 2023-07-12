package android.taobao.windvane.connect.api;

import android.taobao.windvane.util.TaoLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ApiResponse {
    public static final String ERR_CODE = "ERR_CODE";
    public static final String ERR_SID_INVALID = "ERR_SID_INVALID";
    public static final String FAIL = "FAIL";
    public static final String KEY = "KEY";
    public static final String SUCCESS = "SUCCESS";
    private static String TAG = "core.ApiResponse";
    public static final String VALUE = "VALUE";
    public String api;
    public JSONObject data;
    public String errCode;
    public String errInfo;
    public boolean success;
    public String v;

    public ApiResponse parseJsonResult(String str) {
        this.success = false;
        try {
            this.data = new JSONObject(str);
            this.success = true;
        } catch (JSONException unused) {
            String str2 = TAG;
            TaoLog.e(str2, "parseJsonResult fail, str = " + str);
            this.success = false;
        }
        return this;
    }

    public ApiResponse parseResult(String str) {
        this.success = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.api = jSONObject.getString("api");
            this.v = jSONObject.getString("v");
            parseRet(jSONObject.getJSONArray("ret"));
            this.data = jSONObject.getJSONObject("data");
        } catch (JSONException e) {
            e.printStackTrace();
            this.success = false;
            this.errCode = "";
            this.errInfo = "";
        }
        return this;
    }

    public void parseRet(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            int indexOf = string.indexOf("::");
            if (indexOf >= 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY, string.substring(0, indexOf));
                hashMap.put(VALUE, string.substring(indexOf + 2));
                arrayList.add(hashMap);
            }
        }
        if (arrayList.size() == 1) {
            Map map = (Map) arrayList.get(0);
            if ("SUCCESS".equals(map.get(KEY))) {
                this.success = true;
            } else {
                this.success = false;
            }
            this.errCode = (String) map.get(KEY);
            this.errInfo = (String) map.get(VALUE);
        } else if (arrayList.size() == 2) {
            Map map2 = (Map) arrayList.get(0);
            Map map3 = (Map) arrayList.get(1);
            if ("FAIL".equals(map2.get(KEY)) && ERR_CODE.equals(map3.get(KEY))) {
                this.success = false;
                this.errCode = (String) map3.get(VALUE);
                this.errInfo = (String) map2.get(VALUE);
                return;
            }
            this.success = false;
            this.errCode = (String) map3.get(KEY);
            this.errInfo = (String) map3.get(VALUE);
        }
    }
}
