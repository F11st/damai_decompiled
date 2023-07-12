package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.c;
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
        c.m().clearNotificationType(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        c.m().clearNotifications(jSONObject);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        c.m().disableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        c.m().enableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        c.m().getAppNotificationSwitch(iGetAppNotificationCallBackService);
    }

    public static String getMcsPackageName(Context context) {
        return c.m().o(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        c.m().getNotificationStatus(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return c.m().s();
    }

    public static void getPushStatus() {
        c.m().v();
    }

    public static int getPushVersionCode() {
        return c.m().w();
    }

    public static String getPushVersionName() {
        return c.m().x();
    }

    public static String getReceiveSdkAction(Context context) {
        return c.m().y(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        c.m().getRegister(jSONObject);
    }

    public static String getRegisterID() {
        return c.m().getRegisterID();
    }

    public static int getSDKVersionCode() {
        return c.z();
    }

    public static String getSDKVersionName() {
        return c.A();
    }

    public static void init(Context context, boolean z) {
        c.m().B(context, z);
    }

    public static boolean isSupportPush(Context context) {
        return c.m().D(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        c.m().openNotificationSettings(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        c.m().pausePush(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        c.m().register(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void requestNotificationPermission() {
        c.m().requestNotificationPermission();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        c.m().resumePush(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        c.m().F(str, str2);
    }

    public static void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    public static void setNotificationType(int i, JSONObject jSONObject) {
        c.m().setNotificationType(i, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        c.m().G(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        c.m().setPushTime(list, i, i2, i3, i4, jSONObject);
    }

    public static void setRegisterID(String str) {
        c.m().setRegisterID(str);
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
        c.m().J(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        c.m().unRegister(jSONObject);
    }
}
