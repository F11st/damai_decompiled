package com.meizu.cloud.pushsdk.notification;

import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MPushMessage implements Serializable {
    private static final String TAG = "MPushMessage";
    private String clickType;
    private String content;
    private String isDiscard;
    private String notifyType;
    private String packageName;
    private String pushType;
    private String taskId;
    private String title;
    private Map<String, String> extra = new HashMap();
    private Map<String, String> params = new HashMap();

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

    public static MPushMessage parsePushMessage(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        MPushMessage mPushMessage = new MPushMessage();
        try {
            mPushMessage.setTaskId(str4);
            mPushMessage.setPushType(str);
            mPushMessage.setPackageName(str3);
            JSONObject jSONObject2 = new JSONObject(str2).getJSONObject("data");
            if (!jSONObject2.isNull("content")) {
                mPushMessage.setContent(jSONObject2.getString("content"));
            }
            if (!jSONObject2.isNull(PushConstants.IS_DISCARD)) {
                mPushMessage.setIsDiscard(jSONObject2.getString(PushConstants.IS_DISCARD));
            }
            if (!jSONObject2.isNull("title")) {
                mPushMessage.setTitle(jSONObject2.getString("title"));
            }
            if (!jSONObject2.isNull(PushConstants.CLICK_TYPE)) {
                mPushMessage.setClickType(jSONObject2.getString(PushConstants.CLICK_TYPE));
            }
            if (!jSONObject2.isNull("extra") && (jSONObject = jSONObject2.getJSONObject("extra")) != null) {
                if (!jSONObject.isNull(PushConstants.PARAMS)) {
                    try {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.PARAMS);
                        if (jSONObject3 != null) {
                            mPushMessage.setParams(getParamsMap(jSONObject3));
                        }
                    } catch (JSONException e) {
                        DebugLogger.i(TAG, "parameter parse error message " + e.getMessage());
                    }
                    jSONObject.remove(PushConstants.PARAMS);
                }
                mPushMessage.setExtra(getParamsMap(jSONObject));
            }
        } catch (JSONException e2) {
            DebugLogger.i(TAG, "parse push message error " + e2.getMessage());
        }
        DebugLogger.i(TAG, " parsePushMessage " + mPushMessage);
        return mPushMessage;
    }

    public String getClickType() {
        return this.clickType;
    }

    public String getContent() {
        return this.content;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getIsDiscard() {
        return this.isDiscard;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getPushType() {
        return this.pushType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setClickType(String str) {
        this.clickType = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtra(Map<String, String> map) {
        this.extra = map;
    }

    public void setIsDiscard(String str) {
        this.isDiscard = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setPushType(String str) {
        this.pushType = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MPushMessage{taskId='" + this.taskId + "', pushType='" + this.pushType + "', packageName='" + this.packageName + "', title='" + this.title + "', content='" + this.content + "', notifyType='" + this.notifyType + "', clickType='" + this.clickType + "', isDiscard='" + this.isDiscard + "', extra=" + this.extra + ", params=" + this.params + '}';
    }
}
