package org.android.agoo.assist.filter.devicechecker;

import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.HuaweiOperator;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HuaweiDeviceChecker extends DeviceChecker {
    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByBrand() {
        return DeviceChecker.mBrand.equalsIgnoreCase("huawei") || DeviceChecker.mBrand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR);
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByInvoke() {
        return false;
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected PhoneType getPhoneType() {
        return new PhoneType("huawei", AssistConstant.TOKEN_TYPE_HW, new HuaweiOperator());
    }
}
