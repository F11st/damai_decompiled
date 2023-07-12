package org.android.agoo.assist.filter;

import android.content.Context;
import android.util.Pair;
import org.android.agoo.assist.common.PhoneType;
import org.android.agoo.assist.util.DeviceUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class DeviceChecker {
    protected static String mBrand = DeviceUtil.brand;
    protected Context mContext;
    private DeviceChecker mPrev;

    public Pair<Boolean, PhoneType> check(Context context) {
        this.mContext = context;
        DeviceChecker deviceChecker = this.mPrev;
        if (deviceChecker != null) {
            Pair<Boolean, PhoneType> check = deviceChecker.check(context);
            if (((Boolean) check.first).booleanValue()) {
                return check;
            }
        }
        if (checkByInvoke() || checkByBrand() || checkByRom()) {
            return Pair.create(Boolean.TRUE, getPhoneType());
        }
        return Pair.create(Boolean.FALSE, null);
    }

    protected abstract boolean checkByBrand();

    protected abstract boolean checkByInvoke();

    protected boolean checkByRom() {
        return false;
    }

    protected abstract PhoneType getPhoneType();

    public DeviceChecker setAndGetPrev(DeviceChecker deviceChecker) {
        this.mPrev = deviceChecker;
        return deviceChecker;
    }
}
