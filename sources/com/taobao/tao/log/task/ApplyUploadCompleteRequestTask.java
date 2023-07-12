package com.taobao.tao.log.task;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.RemoteFileInfo;
import com.taobao.android.tlog.protocol.model.reply.base.StorageInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.ApplyUploadCompleteRequest;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.UploadQueue;
import com.taobao.tao.log.upload.UploaderInfo;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplyUploadCompleteRequestTask {
    private static String TAG = "TLOG.ApplyUploadCompleteRequestTask";

    public static void executeFailure(CommandInfo commandInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        ApplyUploadCompleteRequest applyUploadCompleteRequest = new ApplyUploadCompleteRequest();
        UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
        applyUploadCompleteRequest.uploadId = str;
        StorageInfo storageInfo = new StorageInfo();
        UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
        String str7 = uploadInfo.type;
        applyUploadCompleteRequest.tokenType = str7;
        if (str7.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
            uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            storageInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            storageInfo.put("ossObjectKey", "");
            storageInfo.put("ossPath", "");
        }
        applyUploadCompleteRequest.tokenInfo = uploadTokenInfo;
        applyUploadCompleteRequest.tokenType = uploadInfo.type;
        RemoteFileInfo[] remoteFileInfoArr = new RemoteFileInfo[1];
        RemoteFileInfo remoteFileInfo = new RemoteFileInfo();
        remoteFileInfo.storageType = uploadInfo.type;
        remoteFileInfo.storageInfo = storageInfo;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                remoteFileInfo.absolutePath = file.getAbsolutePath();
                remoteFileInfo.contentLength = Long.valueOf(file.length());
                remoteFileInfo.fileName = file.getName();
                remoteFileInfo.contentEncoding = "gzip";
                remoteFileInfo.contentType = str6;
                if (str6 == null) {
                    remoteFileInfo.contentType = "application/x-tlog";
                }
            }
        }
        remoteFileInfoArr[0] = remoteFileInfo;
        applyUploadCompleteRequest.remoteFileInfos = remoteFileInfoArr;
        String appkey = TLogInitializer.getInstance().getAppkey();
        String utdid = TLogInitializer.getUTDID();
        applyUploadCompleteRequest.appKey = appkey;
        applyUploadCompleteRequest.appId = TLogInitializer.getInstance().getAppId();
        applyUploadCompleteRequest.utdid = utdid;
        applyUploadCompleteRequest.user = TLogInitializer.getInstance().getUserNick();
        applyUploadCompleteRequest.opCode = OpCode.APPLY_UPLOAD_COMPLETE;
        try {
            SendMessage.send(TLogInitializer.getInstance().getContext(), applyUploadCompleteRequest.build(str4, str5));
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REPLY_ERROR, TLogEventHelper.getPullFileType(str6), UploadReason.LOCAL_PUSH, commandInfo.sessionId);
            FileUploadListener popListener = UploadQueue.getInstance().popListener(commandInfo.requestId);
            if (popListener != null) {
                popListener.onError(str3, str4, str5);
            }
        } catch (Exception e) {
            Log.e(TAG, "build apply upload complete request error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }

    public static void executeSuccess(CommandInfo commandInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "消息处理：文件上传成功");
        ApplyUploadCompleteRequest applyUploadCompleteRequest = new ApplyUploadCompleteRequest();
        UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
        applyUploadCompleteRequest.uploadId = str;
        StorageInfo storageInfo = new StorageInfo();
        UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
        String str7 = uploadInfo.type;
        applyUploadCompleteRequest.tokenType = str7;
        if (str7.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
            uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            storageInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            storageInfo.put("ossObjectKey", str5);
            if (uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_OSS)) {
                if (str6 != null) {
                    storageInfo.put("ossPath", "http://" + TLogInitializer.getInstance().ossBucketName + "/" + str6 + "/" + str3);
                }
            } else if (uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP)) {
                storageInfo.put("ossPath", str3);
            }
        }
        RemoteFileInfo[] remoteFileInfoArr = new RemoteFileInfo[1];
        RemoteFileInfo remoteFileInfo = new RemoteFileInfo();
        remoteFileInfo.storageType = uploadInfo.type;
        remoteFileInfo.storageInfo = storageInfo;
        File file = new File(str2);
        if (file.exists()) {
            remoteFileInfo.absolutePath = file.getAbsolutePath();
            remoteFileInfo.contentLength = Long.valueOf(file.length());
            remoteFileInfo.fileName = file.getName();
            remoteFileInfo.contentEncoding = "gzip";
            remoteFileInfo.contentType = str4;
            if (str4 == null) {
                remoteFileInfo.contentType = "application/x-tlog";
            }
        }
        remoteFileInfoArr[0] = remoteFileInfo;
        applyUploadCompleteRequest.remoteFileInfos = remoteFileInfoArr;
        applyUploadCompleteRequest.tokenInfo = uploadTokenInfo;
        applyUploadCompleteRequest.tokenType = uploadInfo.type;
        String appkey = TLogInitializer.getInstance().getAppkey();
        String utdid = TLogInitializer.getUTDID();
        applyUploadCompleteRequest.appKey = appkey;
        applyUploadCompleteRequest.appId = TLogInitializer.getInstance().getAppId();
        applyUploadCompleteRequest.utdid = utdid;
        applyUploadCompleteRequest.user = TLogInitializer.getInstance().getUserNick();
        applyUploadCompleteRequest.opCode = OpCode.APPLY_UPLOAD_COMPLETE;
        try {
            SendMessage.send(TLogInitializer.getInstance().getContext(), applyUploadCompleteRequest.build("200", null));
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REPLY_SUCCESS, TLogEventHelper.getPullFileType(str4), UploadReason.LOCAL_PUSH, commandInfo.sessionId);
        } catch (Exception e) {
            Log.e(TAG, "build apply upload complete request error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }
}
