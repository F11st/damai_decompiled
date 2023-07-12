package com.meizu.cloud.pushsdk.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx;
import com.meizu.cloud.pushsdk.notification.model.AdvertisementOption;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MessageV3 implements Parcelable {
    public static final Parcelable.Creator<MessageV3> CREATOR = new Parcelable.Creator<MessageV3>() { // from class: com.meizu.cloud.pushsdk.handler.MessageV3.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageV3 createFromParcel(Parcel parcel) {
            return new MessageV3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageV3[] newArray(int i) {
            return new MessageV3[i];
        }
    };
    private static final String TAG = "Message_V3";
    private String activity;
    private int clickType;
    private String content;
    private String deviceId;
    private boolean isDiscard;
    private AdvanceSetting mAdvanceSetting;
    private AppIconSetting mAppIconSetting;
    private NotificationStyle mNotificationStyle;
    private TimeDisplaySetting mTimeDisplaySetting;
    private String notificationMessage;
    private String packageName;
    private Map<String, String> paramsMap;
    private String pushTimestamp;
    private String seqId;
    private String taskId;
    private String throughMessage;
    private String title;
    private String uploadDataPackageName;
    private String uriPackageName;
    private String webUrl;

    public MessageV3() {
        this.paramsMap = new HashMap();
    }

    public MessageV3(Parcel parcel) {
        this.paramsMap = new HashMap();
        this.taskId = parcel.readString();
        this.seqId = parcel.readString();
        this.deviceId = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.packageName = parcel.readString();
        this.clickType = parcel.readInt();
        this.isDiscard = parcel.readByte() != 0;
        this.activity = parcel.readString();
        this.webUrl = parcel.readString();
        this.uriPackageName = parcel.readString();
        this.uploadDataPackageName = parcel.readString();
        this.pushTimestamp = parcel.readString();
        this.paramsMap = parcel.readHashMap(getClass().getClassLoader());
        this.throughMessage = parcel.readString();
        this.notificationMessage = parcel.readString();
        this.mAdvanceSetting = (AdvanceSetting) parcel.readParcelable(AdvanceSetting.class.getClassLoader());
        this.mAppIconSetting = (AppIconSetting) parcel.readParcelable(AppIconSetting.class.getClassLoader());
        this.mNotificationStyle = (NotificationStyle) parcel.readParcelable(NotificationStyle.class.getClassLoader());
        this.mTimeDisplaySetting = (TimeDisplaySetting) parcel.readParcelable(TimeDisplaySetting.class.getClassLoader());
    }

    private static Map<String, String> getParamsMap(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap(jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MessageV3 parse(String str, String str2, String str3, MPushMessage mPushMessage) {
        DebugLogger.e(TAG, "V2 message " + mPushMessage);
        MessageV3 messageV3 = new MessageV3();
        messageV3.setPackageName(str);
        messageV3.setUploadDataPackageName(str);
        messageV3.setDeviceId(str2);
        messageV3.setTaskId(str3);
        messageV3.setTitle(mPushMessage.getTitle());
        messageV3.setContent(mPushMessage.getContent());
        messageV3.setIsDiscard("true".equals(mPushMessage.getIsDiscard()));
        messageV3.setClickType(Integer.valueOf(mPushMessage.getClickType()).intValue());
        messageV3.setWhiteList(false);
        messageV3.setDelayedReportMillis(0L);
        for (Map.Entry<String, String> entry : mPushMessage.getExtra().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("activity".equals(key)) {
                messageV3.setActivity(value);
            }
            if ("url".equals(key)) {
                messageV3.setWebUrl(value);
            }
            if (PushConstants.URI_PACKAGE_NAME.equals(key)) {
                messageV3.setUriPackageName(value);
            }
            if (NotificationStyle.NOTIFICATION_STYLE.equals(key)) {
                messageV3.setNotificationStyle(NotificationStyle.parse(value));
            }
            if ("as".equals(key)) {
                messageV3.setAdvanceSetting(AdvanceSetting.parse(value));
            }
            if ("is".equals(key)) {
                messageV3.setAppIconSetting(AppIconSetting.parse(value));
            }
            if ("ts".equals(key)) {
                messageV3.setTimeDisplaySetting(TimeDisplaySetting.parse(value));
            }
            if ("bs".equals(key)) {
                messageV3.setBrightRemindSetting(BrightRemindSetting.parse(value));
            }
            if ("as".equals(key)) {
                messageV3.setAdvanceSettingEx(AdvanceSettingEx.parse(value));
            }
            if (AdvertisementOption.ADVERTISEMENT_OPTION.equals(key)) {
                messageV3.setAdvertisementOption(AdvertisementOption.parse(value));
            }
        }
        messageV3.setParamsMap(mPushMessage.getParams());
        String jSONObject = C6032e.a((Map) mPushMessage.getExtra()).toString();
        DebugLogger.e(TAG, "MessageV2 extra json is " + jSONObject);
        if (!TextUtils.isEmpty(jSONObject)) {
            messageV3.setNotificationMessage(jSONObject);
        }
        DebugLogger.i(TAG, "parse V2 message to V3 message " + messageV3);
        return messageV3;
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4) {
        return parse(str, null, null, str2, str3, null, str4, false, 0L);
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4, String str5) {
        return parse(str, null, null, str2, str3, str4, str5, false, 0L);
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return parse(str, str2, str3, str4, str5, str6, str7, false, 0L);
    }

    public static MessageV3 parse(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, long j) {
        String str8;
        MessageV3 messageV3 = new MessageV3();
        if (str.isEmpty()) {
            str8 = PushConstants.URI_PACKAGE_NAME;
        } else {
            str8 = PushConstants.URI_PACKAGE_NAME;
            messageV3.setPackageName(str);
        }
        if (!str2.isEmpty()) {
            messageV3.setUploadDataPackageName(str2);
        }
        if (!str3.isEmpty()) {
            messageV3.setPushTimestamp(str3);
        }
        if (!str4.isEmpty()) {
            messageV3.setDeviceId(str4);
        }
        if (!str5.isEmpty()) {
            messageV3.setTaskId(str5);
        }
        if (!str6.isEmpty()) {
            messageV3.setSeqId(str6);
        }
        if (!str7.isEmpty()) {
            messageV3.setNotificationMessage(str7);
        }
        messageV3.setWhiteList(z);
        messageV3.setDelayedReportMillis(j);
        try {
            JSONObject jSONObject = new JSONObject(str7).getJSONObject("data");
            if (!jSONObject.isNull("title")) {
                messageV3.setTitle(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("content")) {
                messageV3.setContent(jSONObject.getString("content"));
            }
            if (!jSONObject.isNull(PushConstants.IS_DISCARD)) {
                messageV3.setIsDiscard(jSONObject.getBoolean(PushConstants.IS_DISCARD));
            }
            if (!jSONObject.isNull(PushConstants.CLICK_TYPE)) {
                messageV3.setClickType(jSONObject.getInt(PushConstants.CLICK_TYPE));
            }
            if (!jSONObject.isNull("extra")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                if (!jSONObject2.isNull(NotificationStyle.NOTIFICATION_STYLE)) {
                    messageV3.setNotificationStyle(NotificationStyle.parse(jSONObject2.getJSONObject(NotificationStyle.NOTIFICATION_STYLE)));
                }
                if (!jSONObject2.isNull("is")) {
                    messageV3.setAppIconSetting(AppIconSetting.parse(jSONObject2.getJSONObject("is")));
                }
                if (!jSONObject2.isNull("as")) {
                    messageV3.setAdvanceSetting(AdvanceSetting.parse(jSONObject2.getJSONObject("as")));
                }
                if (!jSONObject2.isNull("ts")) {
                    messageV3.setTimeDisplaySetting(TimeDisplaySetting.parse(jSONObject2.getJSONObject("ts")));
                }
                if (!jSONObject2.isNull("activity")) {
                    messageV3.setActivity(jSONObject2.getString("activity"));
                }
                if (!jSONObject2.isNull("url")) {
                    messageV3.setWebUrl(jSONObject2.getString("url"));
                }
                if (!jSONObject2.isNull("task_id") && TextUtils.isEmpty(str5)) {
                    DebugLogger.e(TAG, "Flyme 4 notification message by through message or taskId is null");
                    messageV3.setTaskId(jSONObject2.getString("task_id"));
                }
                String str9 = str8;
                if (!jSONObject2.isNull(str9)) {
                    messageV3.setUriPackageName(jSONObject2.getString(str9));
                }
                if (!jSONObject2.isNull(PushConstants.PARAMS)) {
                    messageV3.setParamsMap(getParamsMap(jSONObject2.getJSONObject(PushConstants.PARAMS)));
                }
                if (!jSONObject2.isNull("bs")) {
                    messageV3.setBrightRemindSetting(BrightRemindSetting.parse(jSONObject2.getJSONObject("bs")));
                }
                if (!jSONObject2.isNull("as")) {
                    messageV3.setAdvanceSettingEx(AdvanceSettingEx.parse(jSONObject2.getJSONObject("as")));
                }
                if (!jSONObject2.isNull(AdvertisementOption.ADVERTISEMENT_OPTION)) {
                    messageV3.setAdvertisementOption(AdvertisementOption.parse(jSONObject2.getJSONObject(AdvertisementOption.ADVERTISEMENT_OPTION)));
                }
            }
        } catch (JSONException e) {
            DebugLogger.e(TAG, "parse message error " + e.getMessage());
        }
        return messageV3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActivity() {
        return this.activity;
    }

    public AdvanceSetting getAdvanceSetting() {
        return this.mAdvanceSetting;
    }

    public AdvanceSettingEx getAdvanceSettingEx() {
        return null;
    }

    public AdvertisementOption getAdvertisementOption() {
        return null;
    }

    public AppIconSetting getAppIconSetting() {
        return this.mAppIconSetting;
    }

    public BrightRemindSetting getBrightRemindSetting() {
        return null;
    }

    public int getClickType() {
        return this.clickType;
    }

    public String getContent() {
        return this.content;
    }

    public long getDelayedReportMillis() {
        return 0L;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getNotificationMessage() {
        return this.notificationMessage;
    }

    public NotificationStyle getNotificationStyle() {
        return this.mNotificationStyle;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Map<String, String> getParamsMap() {
        return this.paramsMap;
    }

    public String getPushTimestamp() {
        return this.pushTimestamp;
    }

    public String getSeqId() {
        return this.seqId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getThroughMessage() {
        return this.throughMessage;
    }

    public TimeDisplaySetting getTimeDisplaySetting() {
        return this.mTimeDisplaySetting;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUploadDataPackageName() {
        return this.uploadDataPackageName;
    }

    public String getUriPackageName() {
        return this.uriPackageName;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public boolean getWhiteList() {
        return false;
    }

    public boolean isDiscard() {
        return this.isDiscard;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public void setAdvanceSetting(AdvanceSetting advanceSetting) {
        this.mAdvanceSetting = advanceSetting;
    }

    public void setAdvanceSettingEx(AdvanceSettingEx advanceSettingEx) {
    }

    public void setAdvertisementOption(AdvertisementOption advertisementOption) {
    }

    public void setAppIconSetting(AppIconSetting appIconSetting) {
        this.mAppIconSetting = appIconSetting;
    }

    public void setBrightRemindSetting(BrightRemindSetting brightRemindSetting) {
    }

    public void setClickType(int i) {
        this.clickType = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDelayedReportMillis(long j) {
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIsDiscard(boolean z) {
        this.isDiscard = z;
    }

    public void setNotificationMessage(String str) {
        this.notificationMessage = str;
    }

    public void setNotificationStyle(NotificationStyle notificationStyle) {
        this.mNotificationStyle = notificationStyle;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setParamsMap(Map<String, String> map) {
        this.paramsMap = map;
    }

    public void setPushTimestamp(String str) {
        this.pushTimestamp = str;
    }

    public void setSeqId(String str) {
        this.seqId = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setThroughMessage(String str) {
        this.throughMessage = str;
    }

    public void setTimeDisplaySetting(TimeDisplaySetting timeDisplaySetting) {
        this.mTimeDisplaySetting = timeDisplaySetting;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUploadDataPackageName(String str) {
        this.uploadDataPackageName = str;
    }

    public void setUriPackageName(String str) {
        this.uriPackageName = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setWhiteList(boolean z) {
    }

    public String toString() {
        return "MessageV3{taskId='" + this.taskId + "', seqId='" + this.seqId + "', deviceId='" + this.deviceId + "', title='" + this.title + "', content='" + this.content + "', packageName='" + this.packageName + "', clickType=" + this.clickType + "', isDiscard=" + this.isDiscard + "', activity='" + this.activity + "', webUrl='" + this.webUrl + "', uriPackageName='" + this.uriPackageName + "', pushTimestamp='" + this.pushTimestamp + "', uploadDataPackageName='" + this.uploadDataPackageName + "', paramsMap=" + this.paramsMap + "', throughMessage='" + this.throughMessage + "', notificationMessage='" + this.notificationMessage + "', mAdvanceSetting=" + this.mAdvanceSetting + "', mAppIconSetting=" + this.mAppIconSetting + "', mNotificationStyle=" + this.mNotificationStyle + "', mTimeDisplaySetting=" + this.mTimeDisplaySetting + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.taskId);
        parcel.writeString(this.seqId);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.clickType);
        parcel.writeByte(this.isDiscard ? (byte) 1 : (byte) 0);
        parcel.writeString(this.activity);
        parcel.writeString(this.webUrl);
        parcel.writeString(this.uriPackageName);
        parcel.writeString(this.uploadDataPackageName);
        parcel.writeString(this.pushTimestamp);
        parcel.writeMap(this.paramsMap);
        parcel.writeString(this.throughMessage);
        parcel.writeString(this.notificationMessage);
        parcel.writeParcelable(this.mAdvanceSetting, i);
        parcel.writeParcelable(this.mAppIconSetting, i);
        parcel.writeParcelable(this.mNotificationStyle, i);
        parcel.writeParcelable(this.mTimeDisplaySetting, i);
    }
}
