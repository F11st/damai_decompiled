package android.taobao.windvane.jsbridge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVResult {
    public static final String ERROR_EXECUTE = "HY_ERROR_EXECUTE";
    public static final String FAIL = "HY_FAILED";
    public static final String NO_CLASS = "HY_NO_CLASS";
    public static final String PARAM_ERR = "HY_PARAM_ERR";
    public static final String SUCCESS = "HY_SUCCESS";
    public static final WVResult RET_SUCCESS = new WVResult(SUCCESS);
    public static final WVResult RET_FAIL = new WVResult("HY_FAILED");
    public static final WVResult RET_PARAM_ERR = new WVResult("HY_PARAM_ERR");
    public static final String NO_METHOD = "HY_NO_HANDLER";
    public static final WVResult RET_NO_METHOD = new WVResult(NO_METHOD);
    public static final String NO_PERMISSION = "HY_NO_PERMISSION";
    public static final WVResult RET_NO_PERMISSION = new WVResult(NO_PERMISSION);
    public static final String CLOSED = "HY_CLOSED";
    public static final WVResult RET_CLOSED = new WVResult(CLOSED);
    private int success = 0;
    private JSONObject result = new JSONObject();

    public WVResult() {
    }

    public void addData(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.result.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String get(String str, String str2) {
        try {
            JSONObject jSONObject = this.result;
            return jSONObject == null ? "HY_FAILED_NO_RESULT" : jSONObject.optString(str, str2);
        } catch (Throwable unused) {
            return "HY_FAILED_EXCEPTION";
        }
    }

    public void setData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.result = jSONObject;
        }
    }

    public void setResult(String str) {
        try {
            this.result.put("ret", str);
            this.success = SUCCESS.equals(str) ? 1 : -1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setSuccess() {
        this.success = 1;
    }

    public String toJsonString() {
        try {
            int i = this.success;
            if (i == 1) {
                this.result.put("ret", SUCCESS);
            } else if (i == 0) {
                this.result.put("ret", "HY_FAILED");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.result.toString();
    }

    public void addData(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        try {
            this.result.put(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public WVResult(String str) {
        setResult(str);
    }

    public void addData(String str, JSONArray jSONArray) {
        if (str == null || jSONArray == null) {
            return;
        }
        try {
            this.result.put(str, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addData(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            this.result.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
