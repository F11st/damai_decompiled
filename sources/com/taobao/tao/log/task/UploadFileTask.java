package com.taobao.tao.log.task;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.upload.LogFileUploadManager;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadFileTask {
    private static String TAG = "TLOG.UploadFileTask";

    public static synchronized void taskExecute(CommandInfo commandInfo, String str, String str2, UploadTokenInfo[] uploadTokenInfoArr, TLogEventHelper.UploadEventInfo uploadEventInfo) {
        synchronized (UploadFileTask.class) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_TYPE, uploadEventInfo.fileType.getValue());
                hashMap.put("reason", uploadEventInfo.reason.getValue());
                hashMap.put("bizCode", uploadEventInfo.bizCode);
                hashMap.put("bizType", uploadEventInfo.bizType);
                hashMap.put(TLogEventConst.PARAM_UPLOAD_ID, commandInfo.sessionId);
                hashMap.put(TLogEventConst.PARAM_TASK_ID, commandInfo.sessionId);
                if (uploadTokenInfoArr != null) {
                    hashMap.put(TLogEventConst.PARAM_UPLOAD_FILE_COUNT, String.valueOf(uploadTokenInfoArr.length));
                }
                TLogEventHelper.event(TLogEventConst.UT_TLOG_FILE_UPLOAD_EXECUTE, hashMap);
                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "消息处理：开始处理文件上传消息");
                LogFileUploadManager logFileUploadManager = new LogFileUploadManager(TLogInitializer.getInstance().getContext());
                logFileUploadManager.uploadId = str;
                logFileUploadManager.tokenType = str2;
                logFileUploadManager.tokenInfos = uploadTokenInfoArr;
                logFileUploadManager.mParmas = commandInfo;
                logFileUploadManager.eventInfo = uploadEventInfo;
                for (UploadTokenInfo uploadTokenInfo : uploadTokenInfoArr) {
                    String str3 = uploadTokenInfo.fileInfo.absolutePath;
                    if (!TextUtils.isEmpty(str3)) {
                        logFileUploadManager.addFile(str3);
                    }
                    logFileUploadManager.isForceUpload = true;
                    if (logFileUploadManager.getUploadTaskCount() == 0) {
                        TLog.loge(TLogConstant.MODEL, TAG, "There are not files matching the condition");
                    } else {
                        TLog.loge(TLogConstant.MODEL, TAG, "There are " + logFileUploadManager.getUploadTaskCount() + " files to upload!");
                    }
                }
                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：开始触发上传文件,uploadId=" + str);
                logFileUploadManager.startUpload();
            } catch (Exception e) {
                Log.e(TAG, "task execute failure ", e);
                UploadStage uploadStage = UploadStage.STAGE_UPLOAD;
                ErrorCode errorCode = ErrorCode.CODE_EXC;
                TLogEventHelper.uploadFailEvent(uploadEventInfo, uploadStage, errorCode.getValue(), e.getMessage(), commandInfo.sessionId);
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
                if (commandInfo.opCode.equals(OpCode.APPLY_UPLOAD_TOKEN_REPLY)) {
                    LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", errorCode.getValue(), "UploadFileTask:" + e.getMessage(), null);
                } else {
                    ApplyUploadCompleteRequestTask.executeFailure(commandInfo, str, null, "1", errorCode.getValue(), "UploadFileTask:" + e.getMessage(), null);
                }
            }
        }
    }
}
