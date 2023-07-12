package com.youku.appalarm;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppAlarm {
    public static void alarm(String str, String str2, String str3) {
        AppAlarmManager.getInstance().alarm(str, str2, str3);
    }

    public static void alarm(String str, String str2, String str3, String str4) {
        AppAlarmManager.getInstance().alarm(str, str2, str3, str4);
    }

    public static void alarm(AppAlarmEntity appAlarmEntity) {
        if (appAlarmEntity != null) {
            alarm(appAlarmEntity.getBizType(), appAlarmEntity.getErrorCode(), appAlarmEntity.getErrorMsg(), appAlarmEntity.getPageName(), appAlarmEntity.getPageSpm(), appAlarmEntity.getClickSpm(), appAlarmEntity.getReqData(), appAlarmEntity.getRespData(), appAlarmEntity.getServiceCode(), appAlarmEntity.getServiceMsg(), appAlarmEntity.getBizData());
        }
    }

    public static void alarm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        AppAlarmManager.getInstance().alarm(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }
}
