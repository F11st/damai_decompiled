package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.request.LogUploadRequest;
import com.taobao.android.tlog.protocol.model.request.base.LogFeature;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogNative;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.utils.TLogMultiProcessTool;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogUploadRequestTask implements ICommandTask {
    private String TAG = "TLOG.LogUploadRequestTask";

    private List<String> findFile(LogFeature[] logFeatureArr) {
        ArrayList arrayList = new ArrayList();
        if (logFeatureArr == null) {
            Log.e(this.TAG, "log features is null ");
            return null;
        }
        for (LogFeature logFeature : logFeatureArr) {
            String str = logFeature.appenderName;
            if (str == null) {
                str = TLogInitializer.getInstance().getNameprefix();
            }
            String str2 = logFeature.suffix;
            Integer num = logFeature.maxHistory;
            List<String> filePathAll = (str2 == null || str2.length() <= 0) ? null : TLogUtils.getFilePathAll(str2, 0);
            List<String> filePathAll2 = (str == null || str.length() <= 0) ? null : TLogUtils.getFilePathAll(str, 0, TLogUtils.getDays(num));
            if (filePathAll != null) {
                for (String str3 : filePathAll) {
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            }
            if (filePathAll2 != null) {
                for (String str4 : filePathAll2) {
                    if (!arrayList.contains(str4)) {
                        arrayList.add(str4);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(CommandInfo commandInfo) {
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "消息处理：服务端请求上传文件");
        TLogMultiProcessTool.notifyProcessFlushLog();
        TLogNative.appenderFlushData(false);
        try {
            LogUploadRequest logUploadRequest = new LogUploadRequest();
            logUploadRequest.parse(commandInfo.data, commandInfo);
            String str = logUploadRequest.uploadId;
            LogFeature[] logFeatureArr = logUploadRequest.logFeatures;
            Boolean bool = logUploadRequest.allowNotWifi;
            UploadFileType uploadFileType = UploadFileType.LOG;
            UploadReason uploadReason = UploadReason.SERVER_PULL;
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ, uploadFileType, uploadReason, str);
            if (bool != null && !bool.booleanValue() && !Boolean.valueOf(TLogUtils.checkNetworkIsWifi(TLogInitializer.getInstance().getContext())).booleanValue()) {
                UploadStage uploadStage = UploadStage.STAGE_REQ;
                ErrorCode errorCode = ErrorCode.UPLOAD_NOT_WIFI;
                TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, uploadStage, errorCode.getValue(), "NotWifi", str);
                LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", errorCode.getValue(), "NotWifi", null);
                return this;
            }
            TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
            String str2 = TLogStage.MSG_HANDLE;
            String str3 = this.TAG;
            tLogMonitor.stageInfo(str2, str3, "消息处理：服务端请求上传文件,是否允许非wifi上传：" + bool);
            List<String> findFile = findFile(logFeatureArr);
            if (findFile != null && findFile.size() > 0) {
                ApplyTokenRequestTask.execute(commandInfo, str, findFile, "application/x-tlog");
                return null;
            }
            UploadStage uploadStage2 = UploadStage.STAGE_REQ;
            ErrorCode errorCode2 = ErrorCode.UPLOAD_NO_FILE;
            TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, uploadStage2, errorCode2.getValue(), "", str);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "files == null || files.size() <= 0");
            LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", errorCode2.getValue(), "Can't find the logfie", null);
            return null;
        } catch (Exception e) {
            Log.e(this.TAG, "execute error", e);
            UploadFileType uploadFileType2 = UploadFileType.LOG;
            UploadReason uploadReason2 = UploadReason.SERVER_PULL;
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ, uploadFileType2, uploadReason2, "");
            UploadStage uploadStage3 = UploadStage.STAGE_REQ;
            ErrorCode errorCode3 = ErrorCode.CODE_EXC;
            TLogEventHelper.uploadFailEvent(uploadFileType2, uploadReason2, uploadStage3, errorCode3.getValue(), e.getMessage(), "");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
            LogUploadReplyTask.executeFailure(commandInfo, "", null, "1", errorCode3.getValue(), e.getMessage(), null);
            return null;
        }
    }
}
