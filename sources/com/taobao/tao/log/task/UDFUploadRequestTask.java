package com.taobao.tao.log.task;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.request.UserDefineUploadRequest;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.LogFileUploadManager;
import com.taobao.tao.log.uploader.service.TLogFileUploader;
import com.taobao.tao.log.uploader.service.TLogFileUploaderCallBack;
import com.taobao.tao.log.uploader.service.TLogUploadFileModel;
import com.taobao.tao.log.uploader.service.TLogUploadMsg;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UDFUploadRequestTask implements ICommandTask {
    private String TAG = "TLOG.UDFUploadRequestTask";
    private String defaultBizType = "USER_UPLOAD";
    private String defaultDebugType = TLogConstant.MODEL;

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(final CommandInfo commandInfo) {
        UserDefineUploadRequest userDefineUploadRequest;
        String str;
        String str2;
        final String randomId = RandomIdUtils.getRandomId();
        commandInfo.sessionId = randomId;
        TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ, UploadFileType.UDF, UploadReason.SERVER_PULL, randomId);
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "消息处理：服务端请求上传用户自定义文件");
        try {
            userDefineUploadRequest = new UserDefineUploadRequest();
            userDefineUploadRequest.parse(commandInfo.data, commandInfo);
            str = userDefineUploadRequest.bizType;
            str2 = userDefineUploadRequest.bizCode;
        } catch (Exception e) {
            Log.e(this.TAG, "execute error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
            ErrorCode errorCode = ErrorCode.CODE_EXC;
            String value = errorCode.getValue();
            TLogEventHelper.uploadFailEvent(UploadFileType.UDF, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, errorCode.getValue(), e.getMessage(), randomId);
            UDFUploadReplyTask.executeFailure(commandInfo, value, "消息处理：自定义文件上传失败，抛错，请查看错误日志");
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (!this.defaultBizType.equals(str)) {
                String value2 = ErrorCode.BIZ_ERROR.getValue();
                UDFUploadReplyTask.executeFailure(commandInfo, value2, "消息处理：自定义文件上传失败，bizType不对:" + str);
                return null;
            }
            Map<String, String> map = userDefineUploadRequest.extraInfo;
            Map<String, TLogFileUploader> map2 = TLogInitializer.getInstance().fileUploaderMap;
            if (map2 != null && !map2.isEmpty()) {
                final TLogFileUploader tLogFileUploader = map2.get(str2);
                if (tLogFileUploader == null) {
                    String value3 = ErrorCode.NOT_IMPLEMENTED.getValue();
                    UDFUploadReplyTask.executeFailure(commandInfo, value3, "消息处理：自定义文件上传失败，客户端没有可处理的uploader:" + str2);
                    return null;
                }
                String bizCode = tLogFileUploader.getBizCode();
                if (!bizCode.equals(str2)) {
                    String value4 = ErrorCode.BIZ_ERROR.getValue();
                    UDFUploadReplyTask.executeFailure(commandInfo, value4, "消息处理：自定义文件上传失败，bizCode校验失败,uploader的bizCode=" + bizCode);
                    return null;
                }
                TLogUploadMsg tLogUploadMsg = new TLogUploadMsg();
                tLogUploadMsg.extInfo = map;
                tLogFileUploader.executeUploadTask(TLogInitializer.getInstance().getContext(), tLogUploadMsg, new TLogFileUploaderCallBack() { // from class: com.taobao.tao.log.task.UDFUploadRequestTask.1
                    private Boolean fileUpload(TLogUploadFileModel tLogUploadFileModel) {
                        if (new LogFileUploadManager(TLogInitializer.getInstance().getContext()).uploadWithFilePath(randomId, UploadReason.SERVER_PULL, tLogUploadFileModel.fileList, UDFUploadRequestTask.this.defaultDebugType, UDFUploadRequestTask.this.defaultBizType, tLogUploadFileModel.bizCode, tLogUploadFileModel.extraInfos, new FileUploadListener() { // from class: com.taobao.tao.log.task.UDFUploadRequestTask.1.1
                            @Override // com.taobao.tao.log.upload.FileUploadListener
                            public void onError(String str3, String str4, String str5) {
                                TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
                                String str6 = TLogStage.MSG_HANDLE;
                                String str7 = UDFUploadRequestTask.this.TAG;
                                tLogMonitor.stageError(str6, str7, "消息处理：执行用户自定义文件上传失败：" + str4 + ":" + str5);
                                tLogFileUploader.onUploadDone(false, "");
                            }

                            @Override // com.taobao.tao.log.upload.FileUploadListener
                            public void onSucessed(String str3, String str4) {
                                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, UDFUploadRequestTask.this.TAG, "消息处理：执行用户自定义文件上传成功");
                                tLogFileUploader.onUploadDone(true, str3);
                            }
                        })) {
                            UDFUploadReplyTask.executeSuccess(commandInfo);
                        } else {
                            UDFUploadReplyTask.executeFailure(commandInfo, ErrorCode.COMMON.getValue(), "uploadWithFilePath failed");
                        }
                        return Boolean.TRUE;
                    }

                    @Override // com.taobao.tao.log.uploader.service.TLogFileUploaderCallBack
                    public Boolean onFileUpload(TLogUploadFileModel tLogUploadFileModel) {
                        Log.d(UDFUploadRequestTask.this.TAG, "TLogFileUploader::onFileUpload callback....");
                        if (tLogUploadFileModel == null) {
                            CommandInfo commandInfo2 = commandInfo;
                            ErrorCode errorCode2 = ErrorCode.DATA_EMPTY;
                            UDFUploadReplyTask.executeFailure(commandInfo2, errorCode2.getValue(), "TLogUploadFileModel is null");
                            TLogEventHelper.uploadFailEvent(UploadFileType.UDF, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, errorCode2.getValue(), "TLogUploadFileModel is null", randomId);
                            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, UDFUploadRequestTask.this.TAG, "消息处理：执行用户自定义文件上传校验失败，业务返回参数有错，TLogUploadFileModel为空");
                            return Boolean.FALSE;
                        } else if (TextUtils.isEmpty(tLogUploadFileModel.bizCode)) {
                            CommandInfo commandInfo3 = commandInfo;
                            ErrorCode errorCode3 = ErrorCode.BIZ_ERROR;
                            UDFUploadReplyTask.executeFailure(commandInfo3, errorCode3.getValue(), "TLogUploadMsg bizCode is null");
                            TLogEventHelper.uploadFailEvent(UploadFileType.UDF, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, errorCode3.getValue(), "bizCode is null", randomId);
                            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, UDFUploadRequestTask.this.TAG, "消息处理：执行用户自定义文件上传校验失败，业务返回参数有错，bizcode为空");
                            return Boolean.FALSE;
                        } else {
                            List<String> list = tLogUploadFileModel.fileList;
                            if (list != null && !list.isEmpty()) {
                                return fileUpload(tLogUploadFileModel);
                            }
                            CommandInfo commandInfo4 = commandInfo;
                            ErrorCode errorCode4 = ErrorCode.UPLOAD_NO_FILE;
                            UDFUploadReplyTask.executeFailure(commandInfo4, errorCode4.getValue(), "TLogUploadMsg fileList is null");
                            TLogEventHelper.uploadFailEvent(UploadFileType.UDF, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, errorCode4.getValue(), "file path or bizCode is null", randomId);
                            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, UDFUploadRequestTask.this.TAG, "消息处理：执行用户自定义文件上传校验失败，业务返回参数有错，fileList为空");
                            return Boolean.FALSE;
                        }
                    }
                });
                return null;
            }
            String value5 = ErrorCode.NOT_IMPLEMENTED.getValue();
            UDFUploadReplyTask.executeFailure(commandInfo, value5, "消息处理：自定义文件上传失败，客户端没有注册任何uploader:" + str2);
            return null;
        }
        UDFUploadReplyTask.executeFailure(commandInfo, ErrorCode.BIZ_ERROR.getValue(), "消息处理：自定义文件上传失败，bizCode 或者 bizType为空");
        return null;
    }
}
