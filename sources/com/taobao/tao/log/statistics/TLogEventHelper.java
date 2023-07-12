package com.taobao.tao.log.statistics;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.upload.TLogUploadDiagnoseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogEventHelper {
    private static final String TAG = "TLogEventHelper";
    private static Map<String, UploadEventInfo> maps = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, TLogUploadDiagnoseListener> listenMap = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UploadEventInfo {
        public UploadFileType fileType = UploadFileType.UNKNOWN;
        public UploadReason reason = UploadReason.UNKNOWN;
        public String bizCode = "";
        public String bizType = "";
        public String sessionID = "";
    }

    public static UploadEventInfo UploadEventInfo(String str) {
        try {
            if (!TextUtils.isEmpty(str) && maps.containsKey(str)) {
                return maps.remove(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UploadEventInfo();
    }

    public static synchronized void clearUploadDiagnoseListener(String str) {
        synchronized (TLogEventHelper.class) {
            listenMap.remove(str);
        }
    }

    public static void errorEvent(String str, String str2, String str3, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", str2);
        hashMap.put("errMsg", str3);
        if (map != null) {
            hashMap.putAll(map);
        }
        event(str, hashMap);
    }

    public static void event(String str, Map<String, String> map) {
        if (TLogInitializer.getInstance().isScanUploadEnable()) {
            uploadDiagnose(str, map);
        }
        if (!TLogStatisticsManager.isIsEnable()) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = map == null ? "" : map.toString();
            Log.d(TAG, String.format("tlog_ut disable: eventName=%s, data=%s", objArr));
            return;
        }
        ITLogStatistics tLogStatistics = TLogInitializer.getInstance().getTLogStatistics();
        if (tLogStatistics == null) {
            Log.i(TAG, "TLogStatistics is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.i(TAG, "eventName is null");
        } else {
            try {
                tLogStatistics.event(str, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileSizeEvent(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put(TLogEventConst.PARAM_FILE_DATE, str2);
        hashMap.put(TLogEventConst.PARAM_FILE_SIZE, String.valueOf(j));
        event(TLogEventConst.UT_TLOG_FILE_SIZE, hashMap);
    }

    public static UploadFileType getPullFileType(String str) {
        if (str == null) {
            return UploadFileType.UNKNOWN;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1348220061:
                if (str.equals("application/x-udf")) {
                    c = 0;
                    break;
                }
                break;
            case -39861260:
                if (str.equals("application/x-perf-methodtrace")) {
                    c = 1;
                    break;
                }
                break;
            case 728226032:
                if (str.equals("application/x-perf-heapdump")) {
                    c = 2;
                    break;
                }
                break;
            case 1154829348:
                if (str.equals("application/x-tlog")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return UploadFileType.UDF;
            case 1:
                return UploadFileType.METHOD_TRACE;
            case 2:
                return UploadFileType.HEAP_DUMP;
            case 3:
                return UploadFileType.LOG;
            default:
                return UploadFileType.UNKNOWN;
        }
    }

    public static UploadFileType getPushFileType(String str) {
        if (str == null) {
            return UploadFileType.UNKNOWN;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354499993:
                if (str.equals("HEAP_DUMP")) {
                    c = 0;
                    break;
                }
                break;
            case 2578000:
                if (str.equals(TLogConstant.MODEL)) {
                    c = 1;
                    break;
                }
                break;
            case 3563088:
                if (str.equals("tlog")) {
                    c = 2;
                    break;
                }
                break;
            case 267531335:
                if (str.equals("METHOD_TRACE")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return UploadFileType.HEAP_DUMP;
            case 1:
                return UploadFileType.UDF;
            case 2:
                return UploadFileType.LOG;
            case 3:
                return UploadFileType.METHOD_TRACE;
            default:
                return UploadFileType.UNKNOWN;
        }
    }

    public static void saveUploadIdInfo(String str, UploadEventInfo uploadEventInfo) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            maps.put(str, uploadEventInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void setUploadDiagnoseListener(String str, TLogUploadDiagnoseListener tLogUploadDiagnoseListener) {
        synchronized (TLogEventHelper.class) {
            listenMap.put(str, tLogUploadDiagnoseListener);
        }
    }

    static synchronized void uploadDiagnose(String str, Map<String, String> map) {
        String value;
        synchronized (TLogEventHelper.class) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!listenMap.isEmpty() && map != null && !map.isEmpty()) {
                String str2 = "";
                TLogUploadDiagnoseListener tLogUploadDiagnoseListener = null;
                if (map.containsKey(TLogEventConst.PARAM_TASK_ID)) {
                    str2 = map.get(TLogEventConst.PARAM_TASK_ID);
                    if (!TextUtils.isEmpty(str2) && listenMap.containsKey(str2)) {
                        tLogUploadDiagnoseListener = listenMap.get(str2);
                    }
                }
                UploadStage.UNKNOWN.getValue();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1985564511:
                        if (str.equals(TLogEventConst.UT_TLOG_ARUP_ERR)) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1735725634:
                        if (str.equals(TLogEventConst.UT_TLOG_ARUP_CANCEL)) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1722410037:
                        if (str.equals(TLogEventConst.UT_TLOG_ARUP_REQUEST)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1149039458:
                        if (str.equals(TLogEventConst.UT_TLOG_ARUP_START)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -1139276476:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_REPLY_SUCCESS)) {
                            c = CharUtils.CR;
                            break;
                        }
                        break;
                    case -1066216896:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_SUCCESS)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -390305473:
                        if (str.equals(TLogEventConst.UT_TLOG_ARUP_SUCCESS)) {
                            c = '\f';
                            break;
                        }
                        break;
                    case -296544474:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_REPLY_ERROR)) {
                            c = 14;
                            break;
                        }
                        break;
                    case -199294341:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_ERR)) {
                            c = 15;
                            break;
                        }
                        break;
                    case -199284868:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -199282252:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -114048478:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_ERROR)) {
                            c = 5;
                            break;
                        }
                        break;
                    case -112724597:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_EXECUTE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 278646254:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_REQ)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 278646256:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_RES)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2080186405:
                        if (str.equals(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_RETRY)) {
                            c = 7;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        value = UploadStage.STAGE_REQ.getValue();
                        break;
                    case 1:
                        value = UploadStage.STAGE_REQ_TOKEN.getValue();
                        break;
                    case 2:
                        value = UploadStage.STAGE_RES_TOKEN.getValue();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                        value = UploadStage.STAGE_UPLOAD.getValue();
                        break;
                    case 15:
                        value = map.get(TLogEventConst.PARAM_UPLOAD_STAGE);
                        break;
                    default:
                        return;
                }
                if (tLogUploadDiagnoseListener != null) {
                    tLogUploadDiagnoseListener.onEvent(str2, value, str, map);
                }
            }
        }
    }

    public static void uploadEvent(String str, UploadFileType uploadFileType, UploadReason uploadReason, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadFileType.getValue());
        hashMap.put("reason", uploadReason.getValue());
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, str2);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, str2);
        event(str, hashMap);
    }

    public static void uploadFailEvent(UploadFileType uploadFileType, UploadReason uploadReason, String str, String str2, UploadStage uploadStage, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, uploadStage.getValue());
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadFileType.getValue());
        hashMap.put("reason", uploadReason.getValue());
        hashMap.put("bizType", str);
        hashMap.put("bizCode", str2);
        hashMap.put("errCode", str3);
        hashMap.put("errMsg", str4);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, str5);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, str5);
        event(TLogEventConst.UT_TLOG_FILE_UPLOAD_ERR, hashMap);
    }

    public static void uploadOneEvent(UploadEventInfo uploadEventInfo, String str) {
        uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE, uploadEventInfo, str);
    }

    public static void uploadOneFailEvent(UploadEventInfo uploadEventInfo, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadEventInfo.fileType.getValue());
        hashMap.put("reason", uploadEventInfo.reason.getValue());
        hashMap.put("bizType", uploadEventInfo.bizType);
        hashMap.put("bizCode", uploadEventInfo.bizCode);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, str);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, str);
        hashMap.put("errCode", str2);
        hashMap.put("errMsg", str3);
        event(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_ERROR, hashMap);
    }

    public static void uploadOneRetryEvent(UploadEventInfo uploadEventInfo, String str) {
        uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_RETRY, uploadEventInfo, str);
    }

    public static void uploadOneSuccessEvent(UploadEventInfo uploadEventInfo, String str) {
        uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_ONE_SUCCESS, uploadEventInfo, str);
    }

    public static void errorEvent(String str, String str2, String str3) {
        errorEvent(str, str2, str3, null);
    }

    public static void errorEvent(String str, ErrorCode errorCode, String str2) {
        errorEvent(str, errorCode.getValue(), str2, null);
    }

    public static void uploadEvent(String str, UploadFileType uploadFileType, UploadReason uploadReason, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadFileType.getValue());
        hashMap.put("reason", uploadReason.getValue());
        hashMap.put("bizType", str2);
        hashMap.put("bizCode", str3);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, str4);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, str4);
        event(str, hashMap);
    }

    public static void errorEvent(String str, ErrorCode errorCode) {
        errorEvent(str, errorCode, "");
    }

    public static void event(String str) {
        event(str, null);
    }

    public static void event(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str2, str3);
            event(str, hashMap);
            return;
        }
        event(str, null);
    }

    public static void uploadFailEvent(UploadFileType uploadFileType, UploadReason uploadReason, UploadStage uploadStage, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, uploadStage.getValue());
        hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadFileType.getValue());
        hashMap.put("reason", uploadReason.getValue());
        hashMap.put("errCode", str);
        hashMap.put("errMsg", str2);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, str3);
        hashMap.put(TLogEventConst.PARAM_TASK_ID, str3);
        event(TLogEventConst.UT_TLOG_FILE_UPLOAD_ERR, hashMap);
    }

    public static void uploadEvent(String str, UploadEventInfo uploadEventInfo, String str2) {
        if (uploadEventInfo == null) {
            uploadEventInfo = new UploadEventInfo();
        }
        uploadEvent(str, uploadEventInfo.fileType, uploadEventInfo.reason, uploadEventInfo.bizType, uploadEventInfo.bizCode, str2);
    }

    public static void uploadFailEvent(UploadEventInfo uploadEventInfo, UploadStage uploadStage, String str, String str2, String str3) {
        if (uploadEventInfo == null) {
            uploadEventInfo = new UploadEventInfo();
        }
        uploadFailEvent(uploadEventInfo.fileType, uploadEventInfo.reason, uploadEventInfo.bizType, uploadEventInfo.bizCode, uploadStage, str, str2, str3);
    }
}
