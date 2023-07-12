package org.android.agoo.assist.filter.devicechecker;

import com.vivo.push.PushClient;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.filter.DeviceChecker;
import org.android.agoo.assist.filter.operator.VivoOperator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VivoDeviceChecker extends DeviceChecker {
    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByBrand() {
        return DeviceChecker.mBrand.contains("vivo") || DeviceChecker.mBrand.contains("iqoo");
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected boolean checkByInvoke() {
        try {
            return PushClient.getInstance(this.mContext).isSupport();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // org.android.agoo.assist.filter.DeviceChecker
    protected PhoneType getPhoneType() {
        return new PhoneType("vivo", AssistConstant.TOKEN_TYPE_VIVO, new VivoOperator());
    }
}
