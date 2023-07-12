package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.ApplyUploadRequest;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.UploadQueue;
import com.taobao.tao.log.upload.UploaderInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplyUploadFileRequestTask {
    private static String TAG = "TLOG.ApplyUploadFileRequestTask";

    public static void execute(String str, UploadReason uploadReason, List<String> list, String str2, String str3, String str4, Map<String, String> map, FileUploadListener fileUploadListener) {
        UploadFileType pushFileType = TLogEventHelper.getPushFileType(str2);
        try {
            TLogEventHelper.UploadEventInfo uploadEventInfo = new TLogEventHelper.UploadEventInfo();
            uploadEventInfo.fileType = pushFileType;
            try {
                uploadEventInfo.reason = uploadReason;
                uploadEventInfo.bizType = str3;
                uploadEventInfo.bizCode = str4;
                uploadEventInfo.sessionID = str;
                TLogEventHelper.saveUploadIdInfo(str, uploadEventInfo);
                TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_REQ, uploadEventInfo, str);
                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "主动上报 消息处理：请求文件上传消息");
                UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
                ApplyUploadRequest applyUploadRequest = new ApplyUploadRequest();
                applyUploadRequest.bizType = str3;
                applyUploadRequest.debugType = str2;
                applyUploadRequest.bizCode = str4;
                applyUploadRequest.tokenType = uploadInfo.type;
                UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
                String str5 = uploadInfo.type;
                applyUploadRequest.tokenType = str5;
                if (str5.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
                    uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
                }
                applyUploadRequest.tokenInfo = uploadTokenInfo;
                if (map != null && map.size() > 0) {
                    applyUploadRequest.extraInfo = new HashMap();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        applyUploadRequest.extraInfo.put(entry.getKey(), entry.getValue());
                    }
                }
                FileInfo[] fileInfoArr = new FileInfo[list.size()];
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    File file = new File(list.get(i2));
                    FileInfo fileInfo = new FileInfo();
                    if (file.exists()) {
                        fileInfo.fileName = file.getName();
                        fileInfo.absolutePath = file.getAbsolutePath();
                        fileInfo.contentLength = Long.valueOf(file.length());
                        fileInfo.lastModified = Long.valueOf(file.lastModified());
                        if (str2.equals("method_trace")) {
                            fileInfo.contentType = "application/x-perf-methodtrace";
                        } else if (str2.equals("heap_dump")) {
                            fileInfo.contentType = "application/x-perf-heapdump";
                        } else if (str2.equals("tlog")) {
                            fileInfo.contentType = "application/x-tlog";
                        } else if (str2.equals(TLogConstant.MODEL)) {
                            fileInfo.contentType = "application/x-udf";
                        }
                        fileInfo.contentEncoding = "gzip";
                        i++;
                    }
                    fileInfoArr[i2] = fileInfo;
                }
                if (i == 0) {
                    TLogEventHelper.uploadFailEvent(pushFileType, uploadReason, str4, str3, UploadStage.STAGE_REQ_TOKEN, ErrorCode.UPLOAD_NO_FILE.getValue(), "upload file not exist!", str);
                    return;
                }
                applyUploadRequest.fileInfos = fileInfoArr;
                String appkey = TLogInitializer.getInstance().getAppkey();
                String utdid = TLogInitializer.getUTDID();
                applyUploadRequest.appKey = appkey;
                applyUploadRequest.appId = TLogInitializer.getInstance().getAppId();
                applyUploadRequest.utdid = utdid;
                applyUploadRequest.user = TLogInitializer.getInstance().getUserNick();
                applyUploadRequest.opCode = OpCode.APPLY_UPLOAD;
                RequestResult build = applyUploadRequest.build(str);
                if (fileUploadListener != null) {
                    UploadQueue.getInstance().pushListener(build.requestId, fileUploadListener);
                }
                SendMessage.send(TLogInitializer.getInstance().getContext(), build);
            } catch (Exception e) {
                e = e;
                Log.e(TAG, "send request message error ", e);
                UploadStage uploadStage = UploadStage.STAGE_REQ_TOKEN;
                ErrorCode errorCode = ErrorCode.CODE_EXC;
                TLogEventHelper.uploadFailEvent(pushFileType, uploadReason, str4, str3, uploadStage, errorCode.getValue(), e.getMessage(), str);
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
                if (fileUploadListener != null) {
                    fileUploadListener.onError("", errorCode.getValue(), e.getMessage());
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
