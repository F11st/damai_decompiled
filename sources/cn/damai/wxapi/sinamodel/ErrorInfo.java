package cn.damai.wxapi.sinamodel;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ErrorInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String error;
    public String error_code;
    public String request;

    public static ErrorInfo parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631268921")) {
            return (ErrorInfo) ipChange.ipc$dispatch("1631268921", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ErrorInfo errorInfo = new ErrorInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            errorInfo.error = jSONObject.optString("error");
            errorInfo.error_code = jSONObject.optString("error_code");
            errorInfo.request = jSONObject.optString("request");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorInfo;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591097119")) {
            return (String) ipChange.ipc$dispatch("-1591097119", new Object[]{this});
        }
        return "error: " + this.error + ", error_code: " + this.error_code + ", request: " + this.request;
    }
}
