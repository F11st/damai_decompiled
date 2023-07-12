package com.taobao.android.launcher.switches;

import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.common.Switches;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LauncherSwitches {
    private static final boolean FEATURE_ENABLE_SWITCH = true;
    private static final boolean FEATURE_REPORT_DAG = true;
    private static final String SWITCH_DAG_REPORT_ON = ".dag_report_switch_on";
    private static final String SWITCH_DEMAND_IDLE_DELAY = ".dag_switch_idle_delay";
    private static final String SWITCH_DEMAND_STAGE_OFF = ".dag_switch_stage_off_";

    public static long getIdleDelay() {
        return Switches.getLong(SWITCH_DEMAND_IDLE_DELAY, 0L);
    }

    public static boolean isDAGReportEnable() {
        boolean z = LauncherRuntime.sDebuggable;
        return Switches.isSwitchOn(SWITCH_DAG_REPORT_ON);
    }

    public static boolean isStageSwitchOn(String str) {
        boolean z = LauncherRuntime.sDebuggable;
        return Switches.isSwitchOn(SWITCH_DEMAND_STAGE_OFF + str);
    }
}
