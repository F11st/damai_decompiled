package org.android.agoo.assist.filter.devicechecker;

import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.XiaomiOperator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class XiaomiDeviceChecker extends DeviceChecker {
    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByBrand() {
        return "xiaomi".equals(DeviceChecker.mBrand) || "redmi".equals(DeviceChecker.mBrand) || "blackshark".equals(DeviceChecker.mBrand);
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByInvoke() {
        return false;
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected PhoneType getPhoneType() {
        return new PhoneType("xiaomi", AssistConstant.TOKEN_TYPE_XM, new XiaomiOperator());
    }
}
