package cn.damai.pay.alipay;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ResultChecker {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int RESULT_CHECK_SIGN_FAILED = 1;
    public static final int RESULT_CHECK_SIGN_SUCCEED = 2;
    public static final int RESULT_INVALID_PARAM = 0;
    String mContent;

    public ResultChecker(String str) {
        this.mContent = str;
    }

    int checkSign() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838439962")) {
            return ((Integer) ipChange.ipc$dispatch("-1838439962", new Object[]{this})).intValue();
        }
        try {
            String string = BaseHelper.string2JSON(this.mContent, ";").getString("result");
            String substring = string.substring(1, string.length() - 1);
            substring.substring(0, substring.indexOf("&sign_type="));
            JSONObject string2JSON = BaseHelper.string2JSON(substring, "&");
            string2JSON.getString(AlixDefine.sign_type).replace("\"", "");
            string2JSON.getString("sign").replace("\"", "");
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906327589")) {
            return (String) ipChange.ipc$dispatch("-906327589", new Object[]{this});
        }
        try {
            String string = BaseHelper.string2JSON(this.mContent, ";").getString("result");
            return BaseHelper.string2JSON(string.substring(1, string.length() - 1), "&").getString("success").replace("\"", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isPayOk() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-286899230") ? ((Boolean) ipChange.ipc$dispatch("-286899230", new Object[]{this})).booleanValue() : getSuccess().equalsIgnoreCase("true");
    }
}
