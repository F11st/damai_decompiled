package com.taobao.tao.log.godeye.methodtrace.file;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.tao.log.godeye.api.command.ResponseData;
import com.taobao.tao.log.godeye.api.command.TraceProgress;
import com.taobao.tao.log.godeye.api.command.TraceTask;
import com.taobao.tao.log.godeye.methodtrace.MethodTraceController;
import com.taobao.tao.log.godeye.methodtrace.MethodTraceInitializer;
import com.taobao.tao.log.upload.OSSUploadListener;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TraceFileUploadListener extends OSSUploadListener {
    private final MethodTraceController mMethodTraceController;
    private final TraceTask mTraceTask;

    public TraceFileUploadListener(MethodTraceController methodTraceController, TraceTask traceTask) {
        this.mTraceTask = traceTask;
        this.mMethodTraceController = methodTraceController;
    }

    @Override // com.taobao.tao.log.upload.FileUploadListener
    public void onError(String str, String str2, String str3) {
        Log.e("xxxxxx", "TraceFileUploadListener onError...");
        TraceTask traceTask = this.mTraceTask;
        if (traceTask == null) {
            return;
        }
        traceTask.progress = TraceProgress.EXCEPTION_ON_UPLOAD.name();
        this.mMethodTraceController.saveTaskRunningStatus(this.mTraceTask);
        MethodTraceInitializer.sGodeye.response(this.mMethodTraceController, new ResponseData(6, str3, null));
    }

    @Override // com.taobao.tao.log.upload.FileUploadListener
    public void onSucessed(String str, String str2) {
        TraceTask traceTask = this.mTraceTask;
        if (traceTask == null) {
            return;
        }
        this.mMethodTraceController.saveTaskRunningStatus(traceTask);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fileName", (Object) str);
        jSONObject.put(Constants.KEY_FILE_URL, (Object) str2);
        ResponseData responseData = new ResponseData(5, "file-upload-success", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        responseData.tokenData = jSONObject2;
        jSONObject2.put("ossObjectKey", (Object) this.ossObjectKey);
        responseData.tokenData.put("ossEndpoint", (Object) this.ossEndpoint);
        MethodTraceInitializer.sGodeye.response(this.mMethodTraceController, responseData);
        MethodTraceInitializer.sGodeye.defaultCommandManager().removeLocalCommand(this.mMethodTraceController);
        File file = new File(str);
        if (file.exists()) {
            Log.e("tlog-debug", "file upload success, delete:" + str);
            file.delete();
        }
    }
}
