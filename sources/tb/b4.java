package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.address.bean.PhoneAllowableResult;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class b4 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(PhoneAllowableResult phoneAllowableResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988819406")) {
            ipChange.ipc$dispatch("-988819406", new Object[]{phoneAllowableResult});
        } else if (phoneAllowableResult == null) {
        } else {
            try {
                z20.T("supported_phone_allowable", JSON.toJSONString(phoneAllowableResult));
            } catch (Exception unused) {
            }
        }
    }

    private static PhoneAllowableResult b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973901985")) {
            return (PhoneAllowableResult) ipChange.ipc$dispatch("-973901985", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (PhoneAllowableResult) JSON.parseObject(str, PhoneAllowableResult.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static PhoneAllowableResult c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1306087134") ? (PhoneAllowableResult) ipChange.ipc$dispatch("-1306087134", new Object[0]) : b(z20.B("supported_phone_allowable"));
    }
}
