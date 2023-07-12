package com.taobao.tao.log.task;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.HeapDumpReply;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import com.taobao.android.tlog.protocol.model.reply.base.PerformanceInfo;
import com.taobao.android.tlog.protocol.model.reply.base.RemoteFileInfo;
import com.taobao.android.tlog.protocol.model.reply.base.StorageInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.godeye.core.GodEyeReponse;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.UploadQueue;
import com.taobao.tao.log.upload.UploaderInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HeapDumpReplyTask implements GodEyeReponse {
    private String TAG = "TLOG.MethodTraceReplyTask";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class HeapDumpThread extends Thread {
        private String filePath;
        private FileUploadListener fileUploadListener;
        private String uploadId;

        public HeapDumpThread(String str, String str2, String str3, FileUploadListener fileUploadListener) {
            super(str);
            this.uploadId = str2;
            this.filePath = str3;
            this.fileUploadListener = fileUploadListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.filePath);
                if (this.uploadId == null) {
                    Log.e(HeapDumpReplyTask.this.TAG, "upload id is null ");
                    TLog.loge(TLogConstant.MODEL, HeapDumpReplyTask.this.TAG, "heap dump upload id is null");
                    TLogEventHelper.uploadFailEvent(UploadFileType.HEAP_DUMP, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, ErrorCode.DATA_EMPTY.getValue(), "upload id is null", "");
                } else {
                    UploadQueue.getInstance().pushListener(this.uploadId, this.fileUploadListener);
                    ApplyTokenRequestTask.execute(null, this.uploadId, arrayList, "application/x-perf-heapdump");
                }
            } catch (Exception e) {
                e.printStackTrace();
                TLogEventHelper.uploadFailEvent(UploadFileType.HEAP_DUMP, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, ErrorCode.CODE_EXC.getValue(), e.getMessage(), "");
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, HeapDumpReplyTask.this.TAG, e);
            }
        }
    }

    public void execute(String str, String str2, JSONObject jSONObject, String str3, String str4, String str5) {
        String str6;
        JSONObject jSONObject2;
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "消息处理：堆栈dump回复消息");
        String str7 = null;
        if (jSONObject != null) {
            str7 = jSONObject.getString("fileName");
            str6 = jSONObject.getString(Constants.KEY_FILE_URL);
        } else {
            str6 = null;
        }
        LogReplyBaseInfo logReplyBaseInfo = new LogReplyBaseInfo();
        logReplyBaseInfo.replyOpCode = OpCode.HEAP_DUMP_REPLY;
        logReplyBaseInfo.replyCode = str4;
        logReplyBaseInfo.replyMsg = str5;
        logReplyBaseInfo.utdid = TLogInitializer.getUTDID();
        logReplyBaseInfo.appKey = TLogInitializer.getInstance().getAppkey();
        logReplyBaseInfo.appId = TLogInitializer.getInstance().getAppId();
        UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
        StorageInfo storageInfo = new StorageInfo();
        if (str7 != null) {
            storageInfo.put("fileName", str7);
        }
        if (str6 != null) {
            storageInfo.put(Constants.KEY_FILE_URL, "http://" + str6);
        }
        storageInfo.put("user", TLogInitializer.getInstance().getUserNick());
        HeapDumpReply heapDumpReply = new HeapDumpReply();
        UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
        String str8 = uploadInfo.type;
        heapDumpReply.tokenType = str8;
        if (str8.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
            uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
        }
        heapDumpReply.tokenInfo = uploadTokenInfo;
        RemoteFileInfo[] remoteFileInfoArr = new RemoteFileInfo[1];
        RemoteFileInfo remoteFileInfo = new RemoteFileInfo();
        if (str7 != null && str7.length() > 0) {
            File file = new File(str7);
            if (file.exists()) {
                remoteFileInfo.absolutePath = file.getAbsolutePath();
                remoteFileInfo.contentLength = Long.valueOf(file.length());
                remoteFileInfo.fileName = file.getName();
                remoteFileInfo.contentEncoding = "gzip";
                remoteFileInfo.contentType = "application/x-perf-heapdump";
            }
        }
        remoteFileInfoArr[0] = remoteFileInfo;
        remoteFileInfo.storageType = uploadInfo.type;
        remoteFileInfo.storageInfo = storageInfo;
        heapDumpReply.uploadId = str2;
        heapDumpReply.remoteFileInfos = remoteFileInfoArr;
        if (jSONObject != null && jSONObject.containsKey(Constants.KEY_APP_BUILD)) {
            String string = jSONObject.getString(Constants.KEY_APP_BUILD);
            if (heapDumpReply.extraInfo == null) {
                heapDumpReply.extraInfo = new HashMap();
            }
            heapDumpReply.extraInfo.put(Constants.KEY_APP_BUILD, string);
        }
        if (jSONObject != null && jSONObject.containsKey(Constants.KEY_STAT_DATA) && (jSONObject2 = jSONObject.getJSONObject(Constants.KEY_STAT_DATA)) != null) {
            if (heapDumpReply.performanceInfo == null) {
                heapDumpReply.performanceInfo = new PerformanceInfo();
            }
            heapDumpReply.performanceInfo.put(Constants.KEY_STAT_DATA, jSONObject2.toJSONString());
        }
        try {
            String build = heapDumpReply.build(str, logReplyBaseInfo);
            if (build != null) {
                RequestResult requestResult = new RequestResult();
                requestResult.content = build;
                SendMessage.send(TLogInitializer.getInstance().getContext(), requestResult);
                return;
            }
            Log.w(this.TAG, "content build failure");
        } catch (Exception e) {
            Log.e(this.TAG, "heap dump reply error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
        }
    }

    @Override // com.taobao.tao.log.godeye.core.GodEyeReponse
    public void sendFile(String str, String str2, FileUploadListener fileUploadListener) {
        new HeapDumpThread("heap dump", str, str2, fileUploadListener).start();
    }
}
