package com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface;
import com.alipay.mobile.common.transport.utils.LogCatUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MPaaSSCLogCatImpl implements SCLogCatInterface {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void debug(String str, String str2) {
        LogCatUtil.debug(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2) {
        LogCatUtil.error(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void info(String str, String str2) {
        LogCatUtil.info(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printError(String str, Throwable th) {
        LogCatUtil.printError(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printInfo(String str, String str2) {
        LogCatUtil.printInfo(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void verbose(String str, String str2) {
        LogCatUtil.verbose(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2) {
        LogCatUtil.warn(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, Throwable th) {
        LogCatUtil.error(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, Throwable th) {
        LogCatUtil.warn(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2, Throwable th) {
        LogCatUtil.error(str, str2, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2, Throwable th) {
        LogCatUtil.warn(str, str2, th);
    }
}
