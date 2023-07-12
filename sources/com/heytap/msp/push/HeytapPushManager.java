package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.C5462c;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONObject;
import tb.dg2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HeytapPushManager {
    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        C5462c.m().clearNotificationType(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        C5462c.m().clearNotifications(jSONObject);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        C5462c.m().disableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        C5462c.m().enableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        C5462c.m().getAppNotificationSwitch(iGetAppNotificationCallBackService);
    }

    public static String getMcsPackageName(Context context) {
        return C5462c.m().o(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        C5462c.m().getNotificationStatus(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return C5462c.m().s();
    }

    public static void getPushStatus() {
        C5462c.m().v();
    }

    public static int getPushVersionCode() {
        return C5462c.m().w();
    }

    public static String getPushVersionName() {
        return C5462c.m().x();
    }

    public static String getReceiveSdkAction(Context context) {
        return C5462c.m().y(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        C5462c.m().getRegister(jSONObject);
    }

    public static String getRegisterID() {
        return C5462c.m().getRegisterID();
    }

    public static int getSDKVersionCode() {
        return C5462c.z();
    }

    public static String getSDKVersionName() {
        return C5462c.A();
    }

    public static void init(Context context, boolean z) {
        C5462c.m().B(context, z);
    }

    public static boolean isSupportPush(Context context) {
        return C5462c.m().D(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        C5462c.m().openNotificationSettings(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        C5462c.m().pausePush(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        C5462c.m().register(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void requestNotificationPermission() {
        C5462c.m().requestNotificationPermission();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        C5462c.m().resumePush(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        C5462c.m().F(str, str2);
    }

    public static void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    public static void setNotificationType(int i, JSONObject jSONObject) {
        C5462c.m().setNotificationType(i, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        C5462c.m().G(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        C5462c.m().setPushTime(list, i, i2, i3, i4, jSONObject);
    }

    public static void setRegisterID(String str) {
        C5462c.m().setRegisterID(str);
    }

    public static void statisticEvent(Context context, String str, DataMessage dataMessage) {
        StatisticUtils.statisticEvent(context, str, dataMessage);
    }

    @Deprecated
    public static void statisticMessage(Context context, MessageStat messageStat) {
        dg2.b(context, messageStat);
    }

    @Deprecated
    public static void statisticMessage(Context context, List<MessageStat> list) {
        dg2.c(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        C5462c.m().J(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        C5462c.m().unRegister(jSONObject);
    }
}
