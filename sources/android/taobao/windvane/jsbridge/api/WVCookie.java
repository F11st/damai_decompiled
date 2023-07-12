package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.WVCookieManager;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVCookie extends WVApiPlugin {
    private static final String TAG = "WVCookie";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("readCookies".equals(str)) {
            readCookies(wVCallBackContext, str2);
            return true;
        } else if ("writeCookies".equals(str)) {
            writeCookies(wVCallBackContext, str2);
            return true;
        } else if (kh1.OPERATION_READ.equals(str)) {
            read(wVCallBackContext, str2);
            return true;
        } else if (kh1.OPERATION_WRITE.equals(str)) {
            write(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    public void read(WVCallBackContext wVCallBackContext, String str) {
        String string;
        WVResult wVResult = new WVResult();
        if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e("WVCookie", "readCookies: param decode error, param=" + str);
            }
            try {
                string = new JSONObject(str).getString("url");
            } catch (JSONException unused2) {
                TaoLog.e("WVCookie", "readCookies: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        String cookie = WVCookieManager.getCookie(string);
        if (cookie == null) {
            TaoLog.w("WVCookie", "readCookies: cookieStr is null");
            cookie = "";
        }
        String[] split = cookie.replace("\"", "\\\\\"").split(";");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2 != null && split2.length > 1) {
                try {
                    jSONObject2.put(split2[0].trim(), split2[1].trim());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            if (!EnvUtil.isAppDebug()) {
                jSONObject.put("values", jSONObject2);
            }
            jSONObject.put("value", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        wVResult.addData("value", jSONObject);
        wVCallBackContext.success(wVResult);
    }

    public void readCookies(WVCallBackContext wVCallBackContext, String str) {
        String string;
        WVResult wVResult = new WVResult();
        if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e("WVCookie", "readCookies: param decode error, param=" + str);
            }
            try {
                string = new JSONObject(str).getString("url");
            } catch (JSONException unused2) {
                TaoLog.e("WVCookie", "readCookies: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        String cookie = WVCookieManager.getCookie(string);
        if (cookie == null) {
            TaoLog.w("WVCookie", "readCookies: cookieStr is null");
            cookie = "";
        }
        String replace = cookie.replace("\"", "\\\\\"");
        replace.split(";");
        wVResult.addData("value", replace);
        wVCallBackContext.success(wVResult);
    }

    public void write(WVCallBackContext wVCallBackContext, String str) {
        String string;
        WVResult wVResult = new WVResult();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e("WVCookie", "writeCookies: param decode error, param=" + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string2 = jSONObject.getString(next);
                    sb.append(next);
                    sb.append("=");
                    sb.append(string2);
                    if (keys.hasNext()) {
                        sb.append("; ");
                    }
                }
                string = jSONObject.getString("domain");
            } catch (JSONException unused2) {
                TaoLog.e("WVCookie", "writeCookies: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(string)) {
            WVCookieManager.setCookie(string, sb2);
            wVCallBackContext.success(wVResult);
            return;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.w("WVCookie", "writeCookies: Illegal param: cookieStr=" + sb2 + ";domain=" + string);
        }
        wVCallBackContext.error(wVResult);
    }

    public void writeCookies(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        String string;
        WVResult wVResult = new WVResult();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e("WVCookie", "writeCookies: param decode error, param=" + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string2 = jSONObject.getString("name");
                try {
                    str2 = URLEncoder.encode(jSONObject.getString("value"), "utf-8");
                } catch (UnsupportedEncodingException unused2) {
                    TaoLog.e("WVCookie", "writeCookies: URLEncoder.encode error: value=" + str2);
                }
                string = jSONObject.getString("domain");
                String optString = jSONObject.optString(HttpConnector.EXPIRES);
                String optString2 = jSONObject.optString(a.V);
                String optString3 = jSONObject.optString("secure");
                sb.append(string2);
                sb.append("=");
                sb.append(str2);
                sb.append("; ");
                sb.append("Domain=");
                sb.append(string);
                if (!TextUtils.isEmpty(optString2)) {
                    sb.append("; ");
                    sb.append("Path=");
                    sb.append(optString2);
                }
                if (!TextUtils.isEmpty(optString)) {
                    sb.append("; ");
                    sb.append("Expires=");
                    sb.append(optString);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    sb.append("; ");
                    sb.append("Secure");
                }
            } catch (JSONException unused3) {
                TaoLog.e("WVCookie", "writeCookies: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(string)) {
            WVCookieManager.setCookie(string, sb2);
            wVCallBackContext.success(wVResult);
            return;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.w("WVCookie", "writeCookies: Illegal param: cookieStr=" + sb2 + ";domain=" + string);
        }
        wVCallBackContext.error(wVResult);
    }
}
