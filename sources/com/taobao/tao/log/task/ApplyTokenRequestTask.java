package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.ApplyTokenRequest;
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
import com.taobao.tao.log.upload.UploaderInfo;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplyTokenRequestTask {
    private static String TAG = "TLOG.ApplyTokenRequestTask";

    public static void execute(CommandInfo commandInfo, String str, List<String> list, String str2) {
        UploadFileType pullFileType = TLogEventHelper.getPullFileType(str2);
        try {
            TLogEventHelper.UploadEventInfo uploadEventInfo = new TLogEventHelper.UploadEventInfo();
            uploadEventInfo.fileType = pullFileType;
            UploadReason uploadReason = UploadReason.SERVER_PULL;
            uploadEventInfo.reason = uploadReason;
            uploadEventInfo.sessionID = str;
            TLogEventHelper.saveUploadIdInfo(str, uploadEventInfo);
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_TOKEN_REQ, uploadEventInfo.fileType, uploadReason, str);
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "非主动上报消息处理：申请token消息");
            UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
            ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
            applyTokenRequest.uploadId = str;
            applyTokenRequest.opCode = OpCode.APPLY_UPLOAD_TOKEN;
            applyTokenRequest.appKey = TLogInitializer.getInstance().getAppkey();
            applyTokenRequest.appId = TLogInitializer.getInstance().getAppId();
            applyTokenRequest.utdid = TLogInitializer.getUTDID();
            applyTokenRequest.user = TLogInitializer.getInstance().getUserNick();
            UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
            String str3 = uploadInfo.type;
            applyTokenRequest.tokenType = str3;
            if (str3.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
                uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            }
            applyTokenRequest.tokenInfo = uploadTokenInfo;
            FileInfo[] fileInfoArr = new FileInfo[list.size()];
            for (int i = 0; i < list.size(); i++) {
                String str4 = list.get(i);
                FileInfo fileInfo = new FileInfo();
                File file = new File(str4);
                if (file.exists()) {
                    fileInfo.fileName = file.getName();
                    fileInfo.absolutePath = str4;
                    fileInfo.contentLength = Long.valueOf(file.length());
                    fileInfo.lastModified = Long.valueOf(file.lastModified());
                    fileInfo.contentType = str2;
                    fileInfo.contentEncoding = "gzip";
                    fileInfoArr[i] = fileInfo;
                }
            }
            applyTokenRequest.fileInfos = fileInfoArr;
            SendMessage.send(TLogInitializer.getInstance().getContext(), applyTokenRequest.build(str));
        } catch (Exception e) {
            Log.e(TAG, "execute error", e);
            if (commandInfo != null) {
                LogUploadReplyTask.executeFailure(commandInfo, str, null, "1", ErrorCode.CODE_EXC.getValue(), e.getMessage(), null);
            }
            TLogEventHelper.uploadFailEvent(pullFileType, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ_TOKEN, ErrorCode.CODE_EXC.getValue(), e.getMessage(), str);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }
}
