package com.uploader.export;

import tb.fl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ITaskListener {
    void onCancel(IUploaderTask iUploaderTask);

    void onFailure(IUploaderTask iUploaderTask, fl2 fl2Var);

    void onPause(IUploaderTask iUploaderTask);

    void onProgress(IUploaderTask iUploaderTask, int i);

    void onResume(IUploaderTask iUploaderTask);

    void onStart(IUploaderTask iUploaderTask);

    void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult);

    void onWait(IUploaderTask iUploaderTask);
}
