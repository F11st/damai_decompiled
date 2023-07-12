package com.meizu.cloud.pushsdk.handler;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d {
    public static MessageV3 a(String str) {
        String str2;
        MessageV3 messageV3;
        DebugLogger.i("MessageSerialize", "message serialize stringToMessageV3 start, msgText=" + str);
        try {
            messageV3 = new MessageV3();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("task_id")) {
                    messageV3.setTaskId(jSONObject.getString("task_id"));
                }
                if (!jSONObject.isNull(PushConstants.SEQ_ID)) {
                    messageV3.setSeqId(jSONObject.getString(PushConstants.SEQ_ID));
                }
                if (!jSONObject.isNull(PushConstants.DEVICE_ID)) {
                    messageV3.setDeviceId(jSONObject.getString(PushConstants.DEVICE_ID));
                }
                if (!jSONObject.isNull("title")) {
                    messageV3.setTitle(jSONObject.getString("title"));
                }
                if (!jSONObject.isNull("content")) {
                    messageV3.setContent(jSONObject.getString("content"));
                }
                if (!jSONObject.isNull("package_name")) {
                    messageV3.setPackageName(jSONObject.getString("package_name"));
                }
                if (!jSONObject.isNull(PushConstants.CLICK_TYPE)) {
                    messageV3.setClickType(jSONObject.getInt(PushConstants.CLICK_TYPE));
                }
                if (!jSONObject.isNull(PushConstants.IS_DISCARD)) {
                    messageV3.setIsDiscard(jSONObject.getBoolean(PushConstants.IS_DISCARD));
                }
                if (!jSONObject.isNull("activity")) {
                    messageV3.setActivity(jSONObject.getString("activity"));
                }
                if (!jSONObject.isNull("url")) {
                    messageV3.setWebUrl(jSONObject.getString("url"));
                }
                if (!jSONObject.isNull(PushConstants.URI_PACKAGE_NAME)) {
                    messageV3.setUriPackageName(jSONObject.getString(PushConstants.URI_PACKAGE_NAME));
                }
                if (!jSONObject.isNull(PushConstants.PUSH_TIMESTAMP)) {
                    messageV3.setPushTimestamp(jSONObject.getString(PushConstants.PUSH_TIMESTAMP));
                }
                if (!jSONObject.isNull(PushConstants.UPLOAD_DATA_PACKAGE_NAME)) {
                    messageV3.setUploadDataPackageName(jSONObject.getString(PushConstants.UPLOAD_DATA_PACKAGE_NAME));
                }
                if (!jSONObject.isNull(PushConstants.PARAMS)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(PushConstants.PARAMS);
                    HashMap hashMap = new HashMap(jSONObject2.length());
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    messageV3.setParamsMap(hashMap);
                }
                if (!jSONObject.isNull(PushConstants.THROUGH_MESSAGE)) {
                    messageV3.setThroughMessage(jSONObject.getString(PushConstants.THROUGH_MESSAGE));
                }
                if (!jSONObject.isNull(PushConstants.NOTIFICATION_MESSAGE)) {
                    messageV3.setNotificationMessage(jSONObject.getString(PushConstants.NOTIFICATION_MESSAGE));
                }
                str2 = "MessageSerialize";
            } catch (JSONException e) {
                e = e;
                str2 = "MessageSerialize";
            }
        } catch (JSONException e2) {
            e = e2;
            str2 = "MessageSerialize";
        }
        try {
            DebugLogger.i(str2, "message serialize stringToMessageV3 success, messageV3=" + messageV3);
            return messageV3;
        } catch (JSONException e3) {
            e = e3;
            DebugLogger.e(str2, "message serialize stringToMessageV3 error， " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static String a(MessageV3 messageV3) {
        DebugLogger.i("MessageSerialize", "message serialize messageV3ToString start, messageV3=" + messageV3);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(messageV3.getTaskId())) {
                jSONObject.put("task_id", messageV3.getTaskId());
            }
            if (!TextUtils.isEmpty(messageV3.getSeqId())) {
                jSONObject.put(PushConstants.SEQ_ID, messageV3.getSeqId());
            }
            if (!TextUtils.isEmpty(messageV3.getDeviceId())) {
                jSONObject.put(PushConstants.DEVICE_ID, messageV3.getDeviceId());
            }
            if (!TextUtils.isEmpty(messageV3.getTitle())) {
                jSONObject.put("title", messageV3.getTitle());
            }
            if (!TextUtils.isEmpty(messageV3.getContent())) {
                jSONObject.put("content", messageV3.getContent());
            }
            if (!TextUtils.isEmpty(messageV3.getPackageName())) {
                jSONObject.put("package_name", messageV3.getPackageName());
            }
            jSONObject.put(PushConstants.CLICK_TYPE, messageV3.getClickType());
            jSONObject.put(PushConstants.IS_DISCARD, messageV3.isDiscard());
            if (!TextUtils.isEmpty(messageV3.getActivity())) {
                jSONObject.put("activity", messageV3.getActivity());
            }
            if (!TextUtils.isEmpty(messageV3.getWebUrl())) {
                jSONObject.put("url", messageV3.getWebUrl());
            }
            if (!TextUtils.isEmpty(messageV3.getUriPackageName())) {
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, messageV3.getUriPackageName());
            }
            if (!TextUtils.isEmpty(messageV3.getPushTimestamp())) {
                jSONObject.put(PushConstants.PUSH_TIMESTAMP, messageV3.getPushTimestamp());
            }
            if (!TextUtils.isEmpty(messageV3.getUploadDataPackageName())) {
                jSONObject.put(PushConstants.UPLOAD_DATA_PACKAGE_NAME, messageV3.getUploadDataPackageName());
            }
            if (messageV3.getParamsMap() != null && messageV3.getParamsMap().size() > 0) {
                jSONObject.put(PushConstants.PARAMS, new JSONObject(messageV3.getParamsMap()));
            }
            if (!TextUtils.isEmpty(messageV3.getThroughMessage())) {
                jSONObject.put(PushConstants.THROUGH_MESSAGE, messageV3.getThroughMessage());
            }
            if (!TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                jSONObject.put(PushConstants.NOTIFICATION_MESSAGE, messageV3.getNotificationMessage());
            }
            String jSONObject2 = jSONObject.toString();
            DebugLogger.i("MessageSerialize", "message serialize messageV3ToString success, msgText=" + jSONObject2);
            return jSONObject2;
        } catch (JSONException e) {
            DebugLogger.e("MessageSerialize", "message serialize messageV3ToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
