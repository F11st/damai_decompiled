package com.taobao.tlog.adapter;

import android.content.Context;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.collect.LogFileUploadManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogFileUploader {
    private static boolean isValid = true;

    public static void uploadLogFile(Context context, Map<String, Object> map) {
        uploadLogFile(context, map, null);
    }

    public static void uploadLogFile(Context context, Map<String, Object> map, String str) {
        if (isValid) {
            if (map != null) {
                Object obj = map.get("type");
                if ((obj instanceof String) && "exception".equalsIgnoreCase((String) obj)) {
                    return;
                }
            }
            LogFileUploadManager instances = LogFileUploadManager.getInstances(context);
            if (str == null) {
                instances.addFiles(TLogUtils.getFilePath(TLogConstant.FILE_PREFIX, 1, null));
            } else {
                instances.addFiles(TLogUtils.getFilePath(str, 1, null));
            }
            instances.setType("client");
            instances.setExtData(map);
            HashMap hashMap = new HashMap();
            hashMap.put("userId", "-1");
            hashMap.put("serviceId", "motu-remote");
            hashMap.put(TLogConstant.PERSIST_SERIAL_NUMBER, "-1");
            hashMap.put(TLogConstant.PERSIST_TASK_ID, "-1");
            instances.setReportParams(hashMap);
            instances.startUpload();
        }
    }
}
