package org.android.agoo.assist.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.utl.ALog;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.Operator;
import org.android.agoo.assist.filter.devicechecker.FlymeDeviceChecker;
import org.android.agoo.assist.filter.devicechecker.HuaweiDeviceChecker;
import org.android.agoo.assist.filter.devicechecker.OppoDeviceChecker;
import org.android.agoo.assist.filter.devicechecker.VivoDeviceChecker;
import org.android.agoo.assist.filter.devicechecker.XiaomiDeviceChecker;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DeviceUtil {
    private static final String TAG = "DeviceUtil";
    public static final String brand;
    private static DeviceChecker deviceChecker;
    private static PhoneType phoneType;

    static {
        String brand2 = Build.getBRAND();
        if (TextUtils.isEmpty(brand2)) {
            brand2 = Build.getMANUFACTURER();
        }
        brand = brand2 == null ? "" : brand2.toLowerCase();
    }

    public static PhoneType checkDevice(Context context) {
        PhoneType phoneType2 = phoneType;
        if (phoneType2 != null) {
            return phoneType2;
        }
        if (deviceChecker == null) {
            FlymeDeviceChecker flymeDeviceChecker = new FlymeDeviceChecker();
            deviceChecker = flymeDeviceChecker;
            flymeDeviceChecker.setAndGetPrev(new VivoDeviceChecker()).setAndGetPrev(new OppoDeviceChecker()).setAndGetPrev(new XiaomiDeviceChecker()).setAndGetPrev(new HuaweiDeviceChecker());
        }
        Pair<Boolean, PhoneType> check = deviceChecker.check(context);
        PhoneType phoneType3 = ((Boolean) check.first).booleanValue() ? (PhoneType) check.second : new PhoneType(null, null, Operator.empty);
        phoneType = phoneType3;
        phoneType3.init(context);
        ALog.d(TAG, "checkDevice:", HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, phoneType.getMsgSource());
        return phoneType;
    }
}
