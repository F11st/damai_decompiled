package com.taobao.tao.log.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogNative;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.godeye.methodtrace.file.TraceFileUploadListener;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;
import com.taobao.tao.log.task.ApplyUploadCompleteRequestTask;
import com.taobao.tao.log.task.ApplyUploadFileRequestTask;
import com.taobao.tao.log.task.LogUploadReplyTask;
import com.taobao.tao.log.upload.LogFileUploadManager;
import com.taobao.tao.log.utils.TLogMultiProcessTool;
import com.taobao.tao.log.utils.TLogThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogFileUploadManager {
    private static final int MAX_RETRY_COUNT = 3;
    private static String TAG = "TLog.LogFileUploadManager";
    public TLogEventHelper.UploadEventInfo eventInfo;
    private LogUploader logUploader;
    private Context mContext;
    public CommandInfo mParmas;
    public UploadTokenInfo[] tokenInfos;
    public String tokenType;
    public String uploadId;
    public boolean isForceUpload = false;
    private int retryCount = 0;
    private File uploadTempDir = new File(TLogConstant.UPLOAD_DIR);
    private List<String> mFiles = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class TLogUploadListener extends OSSUploadListener {
        public TLogUploadListener(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        @Override // com.taobao.tao.log.upload.FileUploadListener
        public void onError(String str, String str2, String str3) {
            LogFileUploadManager logFileUploadManager = LogFileUploadManager.this;
            TLogEventHelper.uploadOneFailEvent(logFileUploadManager.eventInfo, logFileUploadManager.mParmas.sessionId, String.format("%s,%s", str, str2), str3);
            if (LogFileUploadManager.access$004(LogFileUploadManager.this) > 3) {
                LogFileUploadManager.this.mFiles.remove(0);
                LogFileUploadManager.this.retryCount = 0;
                LogFileUploadManager.this.uploadFailed(this.fileName, this.contentType, str, str2, str3);
            } else {
                LogFileUploadManager logFileUploadManager2 = LogFileUploadManager.this;
                TLogEventHelper.uploadOneRetryEvent(logFileUploadManager2.eventInfo, logFileUploadManager2.mParmas.sessionId);
                StringBuilder sb = new StringBuilder();
                sb.append("文件上传：文件上传失败,uploadId=");
                String str4 = LogFileUploadManager.this.uploadId;
                if (str4 == null) {
                    str4 = "-";
                }
                sb.append(str4);
                sb.append(" file path=");
                String str5 = this.fileName;
                if (str5 == null) {
                    str5 = "-";
                }
                sb.append(str5);
                sb.append(" error info=");
                if (str3 == null) {
                    str3 = "-";
                }
                sb.append(str3);
                sb.append(" errCode=");
                if (str2 == null) {
                    str2 = "-";
                }
                sb.append(str2);
                sb.append(" retryCount = " + LogFileUploadManager.this.retryCount);
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, LogFileUploadManager.TAG, sb.toString());
            }
            LogFileUploadManager.this.uploadFile(false);
        }

        @Override // com.taobao.tao.log.upload.FileUploadListener
        public void onSucessed(String str, String str2) {
            Log.e("tlog-debug", "upload file onSucessed , originalFilePath = " + str);
            LogFileUploadManager.this.mFiles.remove(0);
            LogFileUploadManager.this.retryCount = 0;
            LogFileUploadManager logFileUploadManager = LogFileUploadManager.this;
            TLogEventHelper.uploadOneSuccessEvent(logFileUploadManager.eventInfo, logFileUploadManager.mParmas.sessionId);
            LogFileUploadManager.this.uploadSuccess(str, this.contentType, str2, this.ossObjectKey, this.ossEndpoint);
            LogFileUploadManager logFileUploadManager2 = LogFileUploadManager.this;
            logFileUploadManager2.isForceUpload = true;
            logFileUploadManager2.uploadFile(false);
        }
    }

    public LogFileUploadManager(Context context) {
        this.mContext = context.getApplicationContext();
        try {
            this.logUploader = (LogUploader) TLogInitializer.getInstance().getLogUploader().getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            this.logUploader = TLogInitializer.getInstance().getLogUploader();
        }
    }

    static /* synthetic */ int access$004(LogFileUploadManager logFileUploadManager) {
        int i = logFileUploadManager.retryCount + 1;
        logFileUploadManager.retryCount = i;
        return i;
    }

    private boolean checkNetworkIsWifi() {
        if (this.isForceUpload) {
            return true;
        }
        return TLogUtils.checkNetworkIsWifi(this.mContext);
    }

    private boolean filePathUpload(String str, UploadReason uploadReason, List<String> list, String str2, String str3, String str4, Map<String, String> map, FileUploadListener fileUploadListener) {
        if (!"exception".equalsIgnoreCase(str3) && !TextUtils.isEmpty(str2)) {
            TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
            String str5 = TLogStage.MSG_LOG_UPLOAD;
            String str6 = TAG;
            tLogMonitor.stageInfo(str5, str6, "文件上传：触发主动上传文件，" + str3);
            ApplyUploadFileRequestTask.execute(str, uploadReason, list, str2, str3, str4, map, fileUploadListener);
            return true;
        }
        String str7 = TAG;
        Log.w(str7, "unSupport type :" + str2 + " " + str3);
        TLogMonitor tLogMonitor2 = TLogInitializer.getInstance().gettLogMonitor();
        String str8 = TLogStage.MSG_LOG_UPLOAD;
        String str9 = TAG;
        tLogMonitor2.stageError(str8, str9, "unSupport type :" + str2 + " " + str3 + this.uploadId + " isForceUpload:" + this.isForceUpload);
        UploadFileType pushFileType = TLogEventHelper.getPushFileType(str2);
        UploadStage uploadStage = UploadStage.STAGE_REQ;
        ErrorCode errorCode = ErrorCode.UNSUPPORTED_BIZ_TYPE;
        String value = errorCode.getValue();
        TLogEventHelper.uploadFailEvent(pushFileType, uploadReason, str3, str4, uploadStage, value, "unSupport type :" + str2 + " " + str3, str);
        if (fileUploadListener != null) {
            fileUploadListener.onError("", errorCode.getValue(), "unSupport biztype");
            return false;
        }
        return false;
    }

    private String getFileContentType(String str) {
        UploadTokenInfo[] uploadTokenInfoArr = this.tokenInfos;
        if (uploadTokenInfoArr != null) {
            for (UploadTokenInfo uploadTokenInfo : uploadTokenInfoArr) {
                FileInfo fileInfo = uploadTokenInfo.fileInfo;
                if (fileInfo != null && str.equals(fileInfo.absolutePath)) {
                    return uploadTokenInfo.fileInfo.contentType;
                }
            }
            return null;
        }
        return null;
    }

    private Map<String, String> getTokenParam(String str) {
        UploadTokenInfo[] uploadTokenInfoArr = this.tokenInfos;
        if (uploadTokenInfoArr != null) {
            for (UploadTokenInfo uploadTokenInfo : uploadTokenInfoArr) {
                FileInfo fileInfo = uploadTokenInfo.fileInfo;
                if (fileInfo != null && str.equals(fileInfo.absolutePath)) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, String> entry : uploadTokenInfo.entrySet()) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                    return hashMap;
                }
            }
        }
        uploadFailed(str, "unknown", "tokenNotFound", ErrorCode.TOKEN_EMPTY.getValue(), "tokenNotFound");
        return null;
    }

    private void preFixUpload(String[] strArr, String str, String str2, String str3, Map<String, String> map, FileUploadListener fileUploadListener) {
        String nameprefix = TLogInitializer.getInstance().getNameprefix();
        List<String> filePathAll = TLogUtils.getFilePathAll(nameprefix, 0, strArr);
        if (filePathAll == null || filePathAll.isEmpty()) {
            TLogNative.appenderFlushData(true);
            filePathAll = TLogUtils.getFilePathAll(nameprefix, 0, strArr);
        }
        if (filePathAll != null && !filePathAll.isEmpty()) {
            filePathUpload(str, UploadReason.LOCAL_PUSH, filePathAll, "tlog", str2, str3, map, fileUploadListener);
            return;
        }
        Log.e(TAG, "uploadFile failure, file path is empty");
        if (!TLogNative.isSoOpen()) {
            UploadFileType uploadFileType = UploadFileType.LOG;
            UploadReason uploadReason = UploadReason.LOCAL_PUSH;
            UploadStage uploadStage = UploadStage.STAGE_REQ;
            ErrorCode errorCode = ErrorCode.TLOG_INIT_ERROR;
            TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, str2, str3, uploadStage, errorCode.getValue(), "so not open", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode.getValue(), "so not open");
            }
        } else {
            UploadFileType uploadFileType2 = UploadFileType.LOG;
            UploadReason uploadReason2 = UploadReason.LOCAL_PUSH;
            UploadStage uploadStage2 = UploadStage.STAGE_REQ;
            ErrorCode errorCode2 = ErrorCode.UPLOAD_NO_FILE;
            TLogEventHelper.uploadFailEvent(uploadFileType2, uploadReason2, str2, str3, uploadStage2, errorCode2.getValue(), "pathList is null", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode2.getValue(), "pathList is null");
            }
        }
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str4 = TLogStage.MSG_LOG_UPLOAD;
        String str5 = TAG;
        tLogMonitor.stageError(str4, str5, "null == pathList || pathList.isEmpty(), " + this.uploadId + " isForceUpload:" + this.isForceUpload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailed(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append("文件上传：文件上传失败,uploadId=");
        String str6 = this.uploadId;
        if (str6 == null) {
            str6 = "-";
        }
        sb.append(str6);
        sb.append(" file path=");
        sb.append(str == null ? "-" : str);
        sb.append(" error info=");
        sb.append(str5 != null ? str5 : "-");
        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, sb.toString());
        if (this.mParmas.opCode.equals(OpCode.APPLY_UPLOAD_TOKEN_REPLY)) {
            LogUploadReplyTask.executeFailure(this.mParmas, this.uploadId, str, str3, str4, str5, str2);
        } else {
            ApplyUploadCompleteRequestTask.executeFailure(this.mParmas, this.uploadId, str, str3, str4, str5, str2);
        }
        TLog.logi(TLogConstant.MODEL, TAG, " upload remote file failure!");
        this.isForceUpload = false;
        TLogUtils.deleteDir(this.uploadTempDir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFile(final boolean z) {
        TLogThreadPool.getInstance().executeUpload(new Runnable() { // from class: tb.ua1
            @Override // java.lang.Runnable
            public final void run() {
                LogFileUploadManager.this.lambda$uploadFile$4(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFinishHandler */
    public void lambda$uploadFile$4(boolean z) {
        String str;
        String str2;
        String str3;
        if (this.mFiles.size() <= 0) {
            if (z) {
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：file size <= 0,uploadId=" + this.uploadId + " isForceUpload:" + this.isForceUpload);
                TLogEventHelper.uploadOneEvent(this.eventInfo, this.mParmas.sessionId);
                TLogEventHelper.uploadOneFailEvent(this.eventInfo, this.mParmas.sessionId, ErrorCode.UPLOAD_NO_FILE.getValue(), "No file to upload!");
                return;
            }
            return;
        }
        TLogEventHelper.uploadOneEvent(this.eventInfo, this.mParmas.sessionId);
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        while (this.mFiles.size() > 0) {
            str5 = this.mFiles.get(0);
            File file = new File(str5);
            if (file.exists() && file.length() != 0) {
                break;
            }
            this.mFiles.remove(0);
            z2 = true;
            file.delete();
        }
        if (this.mFiles.size() == 0) {
            if (z2) {
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：file size == 0,uploadId=" + this.uploadId + " isForceUpload:" + this.isForceUpload);
                TLogEventHelper.uploadOneFailEvent(this.eventInfo, this.mParmas.sessionId, ErrorCode.UPLOAD_NO_FILE.getValue(), "File not exist or empty");
                return;
            }
            return;
        }
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_LOG_UPLOAD_COUNT, "MSG LOG UPLOAD COUNT", "文件上传：上传文件");
        if (this.logUploader != null) {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：校验通过，开始执行文件上传,uploadId=" + this.uploadId);
            UploaderParam uploaderParam = new UploaderParam();
            uploaderParam.build(this.mParmas);
            uploaderParam.context = this.mContext;
            uploaderParam.appVersion = TLogInitializer.getInstance().getAppVersion();
            uploaderParam.logFilePathTmp = this.uploadTempDir.getAbsolutePath();
            uploaderParam.params = getTokenParam(str5);
            uploaderParam.fileContentType = getFileContentType(str5);
            if (this.logUploader.getUploadInfo().type.equals(TLogConstant.TOKEN_TYPE_OSS)) {
                Map<String, String> map = uploaderParam.params;
                if (map != null) {
                    str4 = map.get("ossObjectKey");
                    str3 = uploaderParam.params.get("ossEndpoint");
                } else {
                    TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：oss->params is null, uploadId=" + this.uploadId);
                    str3 = null;
                }
                Map<String, String> map2 = uploaderParam.params;
                if (map2 != null && !map2.containsKey(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY)) {
                    uploaderParam.params.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
                }
            } else if (this.logUploader.getUploadInfo().type.equals(TLogConstant.TOKEN_TYPE_ARUP)) {
                Map<String, String> map3 = uploaderParam.params;
                if (map3 != null) {
                    str4 = map3.get("ossObjectKey");
                    str3 = uploaderParam.params.get("ossEndpoint");
                } else {
                    TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：arup->params is null, uploadId=" + this.uploadId);
                    str3 = null;
                }
                Map<String, String> map4 = uploaderParam.params;
                if (map4 != null && !map4.containsKey(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY)) {
                    uploaderParam.params.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
                }
            } else {
                if (this.logUploader.getUploadInfo().type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
                    Map<String, String> map5 = uploaderParam.params;
                    if (map5 != null) {
                        str4 = map5.get("objectKey");
                        str3 = uploaderParam.params.get("endpoint");
                    } else {
                        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：ceph->params is null, uploadId=" + this.uploadId);
                    }
                } else {
                    TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：not support this type:" + this.logUploader.getUploadInfo().type + ", uploadId=" + this.uploadId);
                }
                str = null;
                str2 = null;
                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：校验通过，调用上传通道,uploadId=" + this.uploadId);
                this.logUploader.startUpload(uploaderParam, str5, new TLogUploadListener(str5, uploaderParam.fileContentType, str, str2));
            }
            str = str4;
            str2 = str3;
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：校验通过，调用上传通道,uploadId=" + this.uploadId);
            this.logUploader.startUpload(uploaderParam, str5, new TLogUploadListener(str5, uploaderParam.fileContentType, str, str2));
        } else {
            Log.w(TAG, "you need impl file uploader ");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "文件上传：没有实现文件上传通道,uploadId=" + this.uploadId);
            TLogEventHelper.uploadOneFailEvent(this.eventInfo, this.mParmas.sessionId, ErrorCode.NOT_IMPLEMENTED.getValue(), "need impl file uploader ");
            this.mFiles.remove(0);
        }
        TLog.logi(TLogConstant.MODEL, TAG, "Current upload task has finished and to upload next -->  " + str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSuccess(String str, String str2, String str3, String str4, String str5) {
        String str6 = this.uploadId;
        if (str6 == null) {
            str6 = "-";
        }
        this.uploadId = str6;
        String str7 = str == null ? "-" : str;
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str8 = TLogStage.MSG_LOG_UPLOAD;
        String str9 = TAG;
        tLogMonitor.stageInfo(str8, str9, "文件上传：文件上传成功,uploadId=" + this.uploadId + " file path=" + str7);
        StringBuilder sb = new StringBuilder();
        sb.append("LogFileUploadManager uploadSuccess... opCode = ");
        sb.append(this.mParmas.opCode);
        Log.e("tlog-debug", sb.toString());
        if (this.mParmas.opCode.equals(OpCode.APPLY_UPLOAD_TOKEN_REPLY)) {
            if (this.uploadId != null) {
                FileUploadListener popListener = UploadQueue.getInstance().popListener(this.uploadId);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("find listener by uploadId, find is null = ");
                sb2.append(popListener == null);
                Log.e("tlog-debug", sb2.toString());
                if (popListener != null) {
                    if (popListener instanceof OSSUploadListener) {
                        OSSUploadListener oSSUploadListener = (OSSUploadListener) popListener;
                        oSSUploadListener.ossEndpoint = str5;
                        oSSUploadListener.ossObjectKey = str4;
                    }
                    popListener.onSucessed(str7, str3);
                    if (popListener instanceof TraceFileUploadListener) {
                        return;
                    }
                }
            }
            LogUploadReplyTask.executeSuccess(this.mParmas, this.uploadId, str7, str3, str2, str4, str5);
        } else {
            if (this.mParmas.requestId != null) {
                FileUploadListener popListener2 = UploadQueue.getInstance().popListener(this.mParmas.requestId);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("find listener by requestId, find is null = ");
                sb3.append(popListener2 == null);
                Log.e("tlog-debug", sb3.toString());
                if (popListener2 != null) {
                    if (popListener2 instanceof OSSUploadListener) {
                        OSSUploadListener oSSUploadListener2 = (OSSUploadListener) popListener2;
                        oSSUploadListener2.ossEndpoint = str5;
                        oSSUploadListener2.ossObjectKey = str4;
                    }
                    popListener2.onSucessed(str7, str3);
                    if (popListener2 instanceof TraceFileUploadListener) {
                        return;
                    }
                }
            }
            ApplyUploadCompleteRequestTask.executeSuccess(this.mParmas, this.uploadId, str7, str3, str2, str4, str5);
        }
        TLog.logi(TLogConstant.MODEL, TAG, " upload remote file success!");
        this.isForceUpload = false;
        TLogUtils.deleteDir(this.uploadTempDir);
    }

    public void addFile(String str) {
        if (this.mFiles == null) {
            this.mFiles = new ArrayList();
        }
        if (TextUtils.isEmpty(str) || this.mFiles.contains(str)) {
            return;
        }
        this.mFiles.add(str);
    }

    public void addFiles(List<String> list) {
        if (this.mFiles == null) {
            this.mFiles = new ArrayList();
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (!this.mFiles.contains(str)) {
                this.mFiles.add(str);
            }
        }
    }

    public int getUploadTaskCount() {
        List<String> list = this.mFiles;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void startUpload() {
        Log.e("tlog-debug", "LogFileUploadManager.startUpload uploadId = " + this.uploadId);
        if (this.mFiles.size() > 0) {
            if (TextUtils.isEmpty(this.mParmas.sessionId)) {
                this.uploadTempDir = new File(this.uploadTempDir, RandomIdUtils.getRandomId());
            } else {
                this.uploadTempDir = new File(this.uploadTempDir, this.mParmas.sessionId);
            }
            TLogNative.appenderFlushData(true);
            this.retryCount = 0;
            uploadFile(true);
            return;
        }
        TLogEventHelper.UploadEventInfo uploadEventInfo = this.eventInfo;
        UploadStage uploadStage = UploadStage.STAGE_UPLOAD;
        ErrorCode errorCode = ErrorCode.UPLOAD_NO_FILE;
        TLogEventHelper.uploadFailEvent(uploadEventInfo, uploadStage, errorCode.getValue(), "File list is null", this.mParmas.sessionId);
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str = TLogStage.MSG_HANDLE;
        String str2 = TAG;
        tLogMonitor.stageError(str, str2, "There is not files to upload!，" + this.uploadId);
        if (this.mParmas.opCode.equals(OpCode.APPLY_UPLOAD_TOKEN_REPLY)) {
            LogUploadReplyTask.executeFailure(this.mParmas, this.uploadId, null, "1", errorCode.getValue(), "File list is null", null);
        } else {
            ApplyUploadCompleteRequestTask.executeFailure(this.mParmas, this.uploadId, null, "1", errorCode.getValue(), "File list is null", null);
        }
    }

    public void uploadTLogFile(String str, String[] strArr, String str2, String str3, Map<String, String> map, FileUploadListener fileUploadListener) {
        UploadFileType uploadFileType = UploadFileType.LOG;
        UploadReason uploadReason = UploadReason.LOCAL_PUSH;
        TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ, uploadFileType, uploadReason, str2, str3, str);
        if (str3 == null) {
            Log.e(TAG, "you need set bizCode");
            UploadStage uploadStage = UploadStage.STAGE_REQ;
            ErrorCode errorCode = ErrorCode.BIZ_ERROR;
            TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, str2, str3, uploadStage, errorCode.getValue(), "bizCode is null", str);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePrefix you need set bizCode");
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode.getValue(), "bizCode is null");
            }
        } else if (str2 == null) {
            Log.e(TAG, "you need set bizType");
            UploadStage uploadStage2 = UploadStage.STAGE_REQ;
            ErrorCode errorCode2 = ErrorCode.BIZ_ERROR;
            TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, str2, str3, uploadStage2, errorCode2.getValue(), "bizType is null", str);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePrefix you need set bizType");
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode2.getValue(), "bizType is null");
            }
        } else {
            TLogMultiProcessTool.notifyProcessFlushLog();
            TLogNative.appenderFlushData(false);
            preFixUpload(strArr, str, str2, str3, map, fileUploadListener);
        }
    }

    @Deprecated
    public void uploadWithFilePath(String str, String str2) {
    }

    public boolean uploadWithFilePath(String str, UploadReason uploadReason, String str2, String str3, String str4, String str5, Map<String, String> map, FileUploadListener fileUploadListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        return uploadWithFilePath(str, uploadReason, arrayList, str3, str4, str5, map, fileUploadListener);
    }

    @Deprecated
    public void uploadWithFilePrefix(String str, String str2) {
    }

    @Deprecated
    public void uploadWithFilePrefix(String str, String str2, String str3, FileUploadListener fileUploadListener) {
    }

    public void uploadWithFilePrefix(String str, String str2, Map<String, String> map, FileUploadListener fileUploadListener) {
        uploadTLogFile(RandomIdUtils.getRandomId(), TLogUtils.getDays(1), str, str2, map, fileUploadListener);
    }

    public boolean uploadWithFilePath(String str, UploadReason uploadReason, List<String> list, String str2, String str3, String str4, Map<String, String> map, FileUploadListener fileUploadListener) {
        if (list == null) {
            Log.e(TAG, "you need set file path");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePath you need set file path");
            UploadFileType uploadFileType = UploadFileType.UDF;
            UploadStage uploadStage = UploadStage.STAGE_REQ;
            ErrorCode errorCode = ErrorCode.DATA_EMPTY;
            TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, uploadStage, errorCode.getValue(), "filePath is null", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode.getValue(), "filePath is null");
            }
            return false;
        } else if (str2 == null) {
            Log.e(TAG, "you need set debugType");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePath you need set debugType");
            UploadFileType uploadFileType2 = UploadFileType.UDF;
            UploadStage uploadStage2 = UploadStage.STAGE_REQ;
            ErrorCode errorCode2 = ErrorCode.DATA_EMPTY;
            TLogEventHelper.uploadFailEvent(uploadFileType2, uploadReason, uploadStage2, errorCode2.getValue(), "debugType is null", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode2.getValue(), "debugType is null");
            }
            return false;
        } else if (str4 == null) {
            Log.e(TAG, "you need set bizCode");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePath you need set bizCode");
            UploadFileType uploadFileType3 = UploadFileType.UDF;
            UploadStage uploadStage3 = UploadStage.STAGE_REQ;
            ErrorCode errorCode3 = ErrorCode.BIZ_ERROR;
            TLogEventHelper.uploadFailEvent(uploadFileType3, uploadReason, uploadStage3, errorCode3.getValue(), "bizCode is null", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode3.getValue(), "bizCode is null");
            }
            return false;
        } else if (str3 == null) {
            Log.e(TAG, "you need set bizType");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_LOG_UPLOAD, TAG, "uploadWithFilePath you need set bizType");
            UploadFileType uploadFileType4 = UploadFileType.UDF;
            UploadStage uploadStage4 = UploadStage.STAGE_REQ;
            ErrorCode errorCode4 = ErrorCode.BIZ_ERROR;
            TLogEventHelper.uploadFailEvent(uploadFileType4, uploadReason, uploadStage4, errorCode4.getValue(), "bizType is null", str);
            if (fileUploadListener != null) {
                fileUploadListener.onError("", errorCode4.getValue(), "bizType is null");
            }
            return false;
        } else {
            return filePathUpload(str, uploadReason, list, str2, str3, str4, map, fileUploadListener);
        }
    }
}
