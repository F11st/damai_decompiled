package com.ali.user.mobile.app;

import android.text.TextUtils;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.utils.FileUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginContext {
    public static boolean NEED_ACCS_LOGIN = false;
    public static int launchTime = -1;
    public static String loginUIType;
    public static String mFrom;
    public static LoginParam sCurrentLoginParam;
    public static String traceid;

    public static int getLaunchTimes() {
        if (launchTime == -1) {
            launchTime = FileUtil.getLaunchTimes();
        }
        return launchTime;
    }

    public static String getTraceId() {
        if (TextUtils.isEmpty(traceid)) {
            traceid = AppInfo.getInstance().getUtdid() + JSMethod.NOT_SET + (System.currentTimeMillis() / 1000) + JSMethod.NOT_SET + Build.getBRAND();
        }
        return traceid;
    }
}
