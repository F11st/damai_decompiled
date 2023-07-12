package org.android.agoo.assist.filter.devicechecker;

import android.os.Build;
import android.text.TextUtils;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.FlymeOperator;
import org.android.agoo.assist.util.SystemProperties;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FlymeDeviceChecker extends DeviceChecker {
    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByBrand() {
        return "meizu".equals(DeviceChecker.mBrand) || "22c4185e".equals(DeviceChecker.mBrand);
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByInvoke() {
        return false;
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByRom() {
        if (!TextUtils.isEmpty(SystemProperties.get("ro.meizu.product.model"))) {
            return true;
        }
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected PhoneType getPhoneType() {
        return new PhoneType("meizu", AssistConstant.TOKEN_TYPE_MZ, new FlymeOperator());
    }
}
