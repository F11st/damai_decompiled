package com.taobao.android.tlog.protocol.model.reply;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.joint.point.BackgroundJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.EventJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.LifecycleJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.NotificationJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.TimerJointPoint;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ParseHelper {
    public static JointPoint jointPointParse(String str, JSONObject jSONObject) {
        if (str.equals("background")) {
            return new BackgroundJointPoint();
        }
        if (str.equals("event")) {
            return new EventJointPoint();
        }
        if (str.equals(ForegroundJointPoint.TYPE)) {
            return new ForegroundJointPoint();
        }
        if (str.equals("lifecycle")) {
            return new LifecycleJointPoint();
        }
        if (str.equals("notification")) {
            NotificationJointPoint notificationJointPoint = new NotificationJointPoint();
            if (jSONObject.containsKey("action")) {
                notificationJointPoint.action = jSONObject.getString("action");
            }
            if (jSONObject.containsKey("uri")) {
                notificationJointPoint.uri = jSONObject.getString("uri");
            }
            return notificationJointPoint;
        } else if (str.equals(StartupJointPoint.TYPE)) {
            return new StartupJointPoint();
        } else {
            if (str.equals("timer")) {
                TimerJointPoint timerJointPoint = new TimerJointPoint();
                if (jSONObject.containsKey("waitMilliseconds")) {
                    timerJointPoint.waitMilliseconds = jSONObject.getInteger("waitMilliseconds").intValue();
                }
                return timerJointPoint;
            }
            return null;
        }
    }

    public static UploadTokenInfo[] parseUploadInfos(JSONArray jSONArray) {
        UploadTokenInfo[] uploadTokenInfoArr = new UploadTokenInfo[jSONArray.size()];
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
            if (jSONObject.containsKey("fileInfo")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("fileInfo");
                FileInfo fileInfo = new FileInfo();
                if (jSONObject2.containsKey("fileName")) {
                    fileInfo.fileName = jSONObject2.getString("fileName");
                }
                if (jSONObject2.containsKey("absolutePath")) {
                    fileInfo.absolutePath = jSONObject2.getString("absolutePath");
                }
                if (jSONObject2.containsKey("lastModified")) {
                    fileInfo.lastModified = jSONObject2.getLong("lastModified");
                }
                if (jSONObject2.containsKey("contentLength")) {
                    fileInfo.contentLength = jSONObject2.getLong("contentLength");
                }
                if (jSONObject2.containsKey("contentType")) {
                    fileInfo.contentType = jSONObject2.getString("contentType");
                }
                if (jSONObject2.containsKey("contentMD5")) {
                    fileInfo.contentMD5 = jSONObject2.getString("contentMD5");
                }
                if (jSONObject2.containsKey("contentEncoding")) {
                    fileInfo.contentEncoding = jSONObject2.getString("contentEncoding");
                }
                uploadTokenInfo.fileInfo = fileInfo;
            }
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    uploadTokenInfo.put(key, String.valueOf(value));
                }
            }
            uploadTokenInfoArr[i] = uploadTokenInfo;
        }
        return uploadTokenInfoArr;
    }
}
