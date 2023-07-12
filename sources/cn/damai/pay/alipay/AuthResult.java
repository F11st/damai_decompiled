package cn.damai.pay.alipay;

import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.alipay.sdk.m.u.l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AuthResult {
    private static transient /* synthetic */ IpChange $ipChange;
    private String alipayOpenId;
    private String authCode;
    private String memo;
    private String result;
    private String resultCode;
    private String resultStatus;

    public AuthResult(Map<String, String> map, boolean z) {
        String[] split;
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, l.a)) {
                this.resultStatus = map.get(str);
            } else if (TextUtils.equals(str, "result")) {
                this.result = map.get(str);
            } else if (TextUtils.equals(str, l.b)) {
                this.memo = map.get(str);
            }
        }
        for (String str2 : this.result.split("&")) {
            if (str2.startsWith("alipay_open_id")) {
                this.alipayOpenId = removeBrackets(getValue("alipay_open_id=", str2), z);
            } else if (str2.startsWith("auth_code")) {
                this.authCode = removeBrackets(getValue("auth_code=", str2), z);
            } else if (str2.startsWith(FontsContractCompat.Columns.RESULT_CODE)) {
                this.resultCode = removeBrackets(getValue("result_code=", str2), z);
            }
        }
    }

    private String getValue(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2105488566") ? (String) ipChange.ipc$dispatch("-2105488566", new Object[]{this, str, str2}) : str2.substring(str.length(), str2.length());
    }

    private String removeBrackets(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202303588")) {
            return (String) ipChange.ipc$dispatch("202303588", new Object[]{this, str, Boolean.valueOf(z)});
        }
        if (!z || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("\"")) {
            str = str.replaceFirst("\"", "");
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public String getAlipayOpenId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2007890392") ? (String) ipChange.ipc$dispatch("2007890392", new Object[]{this}) : this.alipayOpenId;
    }

    public String getAuthCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1296501150") ? (String) ipChange.ipc$dispatch("1296501150", new Object[]{this}) : this.authCode;
    }

    public String getMemo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1393376675") ? (String) ipChange.ipc$dispatch("1393376675", new Object[]{this}) : this.memo;
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1604505210") ? (String) ipChange.ipc$dispatch("-1604505210", new Object[]{this}) : this.result;
    }

    public String getResultCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "218133907") ? (String) ipChange.ipc$dispatch("218133907", new Object[]{this}) : this.resultCode;
    }

    public String getResultStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1049282472") ? (String) ipChange.ipc$dispatch("-1049282472", new Object[]{this}) : this.resultStatus;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "147412239")) {
            return (String) ipChange.ipc$dispatch("147412239", new Object[]{this});
        }
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }
}
