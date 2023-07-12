package com.youku.usercenter.passport.statistics;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PassportAppMonitor {
    private static final String MONITOR_MODEL = "passport";
    private static final String MONITOR_POINT_SECURITY_IO = "securityIOError";
    private static final String MONITOR_POINT_STOKEN_EXPIRE = "stokenExpire";
    private static final String MONITOR_POINT_THIRDPARTYLOGIN = "thirdpartyLogin";
    private static final String MONITOR_POINT_UTDID_CHANGE = "utdidChange";
    private static boolean sSecurityIORegistered;
    private static boolean sTPLoginRegistered;

    public static void commitSTokenExpire(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        AppMonitor.Counter.commit(MONITOR_MODEL, MONITOR_POINT_STOKEN_EXPIRE, str, 1.0d);
    }

    public static void commitSecurityIOError(String str, String str2, String str3, int i) {
        if (!sSecurityIORegistered) {
            sSecurityIORegistered = true;
            AppMonitor.register(MONITOR_MODEL, MONITOR_POINT_SECURITY_IO, (MeasureSet) null, DimensionSet.create().addDimension("type").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("key").addDimension("errorCode"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("type", str);
        create.setValue(TLogEventConst.PARAM_UPLOAD_STAGE, str2);
        create.setValue("key", str3);
        create.setValue("errorCode", String.valueOf(i));
        AppMonitor.Stat.commit(MONITOR_MODEL, MONITOR_POINT_SECURITY_IO, create, (MeasureValueSet) null);
    }

    public static void commitUtdidChange(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        AppMonitor.Counter.commit(MONITOR_MODEL, MONITOR_POINT_UTDID_CHANGE, str, 1.0d);
    }
}
