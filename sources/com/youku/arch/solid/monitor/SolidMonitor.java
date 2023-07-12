package com.youku.arch.solid.monitor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.Status;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SolidMonitor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CHECK_TYPE_GROUP = "group";
    public static final String CHECK_TYPE_LIB = "lib";
    public static final String CHECK_TYPE_LIB_LIST = "libList";
    public static final String FALSE = "0";
    public static final String TRUE = "1";
    private static final Set<String> hasReportedCheckGroupList = new CopyOnWriteArraySet();
    private static final Set<String> hasReportedCheckLibList = new CopyOnWriteArraySet();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum Params {
        ELAPSE_SINCE_LAUNCH,
        COST_TIME,
        SUCCESS,
        ERROR_MSG,
        NEED_DOWNLOAD_SO_LIST,
        NEED_DOWNLOAD_GROUP_LIST,
        NEED_DOWNLOAD_COUNT,
        LIB_NAME,
        FILE_SIZE,
        CHECK_TYPE,
        IS_FIRST_CHECK,
        STATUS,
        PCDN_VERSION
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum Stage {
        PCDN_INIT,
        SOLID_CHECK_STATUS,
        SOLID_START,
        SOLID_REQUEST,
        SOLID_INSTALL,
        SOLID_LIB_DOWNLOAD,
        SOLID_LIB_START_DOWNLOAD,
        SOLID_GROUP_DOWNLOAD,
        SOLID_UNZIP,
        APK_UPDATE
    }

    public static void reportCheck(String str, Status status, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1817177002")) {
            ipChange.ipc$dispatch("1817177002", new Object[]{str, status, str2, Long.valueOf(j)});
        } else if (reportFirstCheck(str, status, str2, j)) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(Params.LIB_NAME, str);
            hashMap.put(Params.STATUS, status.name());
            hashMap.put(Params.CHECK_TYPE, str2);
            Params params = Params.ELAPSE_SINCE_LAUNCH;
            hashMap.put(params, j + "");
            Solid.getInstance().getMonitor().reportStageResult(Stage.SOLID_CHECK_STATUS, hashMap);
        }
    }

    private static boolean reportFirstCheck(String str, Status status, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169533920")) {
            return ((Boolean) ipChange.ipc$dispatch("-169533920", new Object[]{str, status, str2, Long.valueOf(j)})).booleanValue();
        }
        if (CHECK_TYPE_GROUP.equals(str2)) {
            Set<String> set = hasReportedCheckGroupList;
            if (set.contains(str)) {
                return false;
            }
            set.add(str);
        } else if (CHECK_TYPE_LIB.equals(str2)) {
            Set<String> set2 = hasReportedCheckLibList;
            if (set2.contains(str)) {
                return false;
            }
            set2.add(str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Params.LIB_NAME, str);
        hashMap.put(Params.STATUS, status.name());
        hashMap.put(Params.CHECK_TYPE, str2);
        hashMap.put(Params.IS_FIRST_CHECK, "1");
        Params params = Params.ELAPSE_SINCE_LAUNCH;
        hashMap.put(params, j + "");
        Solid.getInstance().getMonitor().reportStageResult(Stage.SOLID_CHECK_STATUS, hashMap);
        return true;
    }
}
