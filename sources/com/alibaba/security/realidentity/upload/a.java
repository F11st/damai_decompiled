package com.alibaba.security.realidentity.upload;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.track.model.TrackLog;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import java.util.HashMap;
import java.util.Map;
import tb.fl2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a extends com.alibaba.security.realidentity.upload.a.a {
    private static final String c = "a";
    private static final String d = "x-arup-biz-ret";
    private static final String e = "ossBucketName";
    private static final String f = "ossObjectKey";
    private final IUploaderManager g;

    public a(Context context) {
        super(context);
        this.g = com.uploader.export.a.a();
    }

    @Override // com.alibaba.security.realidentity.upload.b.a
    public final Object a(final UploadFileModel uploadFileModel, final com.alibaba.security.realidentity.upload.b.b bVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("arup-directory", uploadFileModel.getDestDir());
        hashMap.put("arup-file-name", uploadFileModel.getRemoteFileName());
        final IUploaderTask iUploaderTask = new IUploaderTask() { // from class: com.alibaba.security.realidentity.upload.a.1
            @Override // com.uploader.export.IUploaderTask
            public final String getBizType() {
                return "rp_asset";
            }

            @Override // com.uploader.export.IUploaderTask
            public final String getFilePath() {
                return uploadFileModel.getLocalFilePath();
            }

            @Override // com.uploader.export.IUploaderTask
            public final String getFileType() {
                return uploadFileModel.getFileType();
            }

            @Override // com.uploader.export.IUploaderTask
            public final Map<String, String> getMetaInfo() {
                return hashMap;
            }
        };
        final long a = e.a(uploadFileModel.getLocalFilePath());
        final long currentTimeMillis = System.currentTimeMillis();
        a(iUploaderTask.getFilePath(), iUploaderTask.getFileType(), a);
        this.g.uploadAsync(iUploaderTask, new ITaskListener() { // from class: com.alibaba.security.realidentity.upload.a.2
            @Override // com.uploader.export.ITaskListener
            public final void onCancel(IUploaderTask iUploaderTask2) {
                bVar.a();
            }

            @Override // com.uploader.export.ITaskListener
            public final void onFailure(IUploaderTask iUploaderTask2, fl2 fl2Var) {
                bVar.b(fl2Var != null ? fl2Var.toString() : "other error");
                a.this.a("oss upload failed", fl2Var != null ? fl2Var.toString() : "other error", iUploaderTask.getFilePath());
                a.this.a(iUploaderTask.getFilePath(), iUploaderTask.getFileType(), null, fl2Var != null ? fl2Var.a : "-1", fl2Var != null ? fl2Var.toString() : "other error", System.currentTimeMillis() - currentTimeMillis, a);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onPause(IUploaderTask iUploaderTask2) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onProgress(IUploaderTask iUploaderTask2, int i) {
                long j = a;
                bVar.a((i / 100.0f) * j, j);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onResume(IUploaderTask iUploaderTask2) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onStart(IUploaderTask iUploaderTask2) {
            }

            @Override // com.uploader.export.ITaskListener
            public final void onSuccess(IUploaderTask iUploaderTask2, ITaskResult iTaskResult) {
                Map<String, String> result = iTaskResult.getResult();
                String str = null;
                if (result != null && result.containsKey(a.d)) {
                    JSONObject parseObject = JSON.parseObject(result.get(a.d));
                    String string = (parseObject == null || !parseObject.containsKey("ossBucketName")) ? null : parseObject.getString("ossBucketName");
                    String string2 = (parseObject == null || !parseObject.containsKey(a.f)) ? null : parseObject.getString(a.f);
                    if (string != null && string2 != null) {
                        str = "oss://" + string + ":" + string2;
                    }
                }
                if (str == null) {
                    a.this.a(iUploaderTask.getFilePath(), iUploaderTask.getFileType(), str, "-1", "remote url is null", System.currentTimeMillis() - currentTimeMillis, a);
                    a.this.a("oss upload failed", "remote url is null", iUploaderTask.getFilePath());
                    bVar.b("remote url is null");
                    return;
                }
                a.this.a(iUploaderTask.getFilePath(), iUploaderTask.getFileType(), str, "0", null, System.currentTimeMillis() - currentTimeMillis, a);
                bVar.a(str);
            }

            @Override // com.uploader.export.ITaskListener
            public final void onWait(IUploaderTask iUploaderTask2) {
            }
        }, null);
        return iUploaderTask;
    }

    protected final void a(String str, String str2, String str3) {
        a(TrackLog.createSdkExceptionLog(str, str2, str3));
    }

    @Override // com.alibaba.security.realidentity.upload.b.a
    public final void a(Object obj) {
        if (obj instanceof IUploaderTask) {
            this.g.cancelAsync((IUploaderTask) obj);
        }
    }
}
