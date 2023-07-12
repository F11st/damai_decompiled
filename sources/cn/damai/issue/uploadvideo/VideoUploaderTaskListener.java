package cn.damai.issue.uploadvideo;

import tb.rx2;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes14.dex */
public interface VideoUploaderTaskListener {
    void onCancel(rx2 rx2Var);

    void onFailure(rx2 rx2Var, String str);

    void onPause(rx2 rx2Var);

    void onProgress(rx2 rx2Var, int i);

    void onResume(rx2 rx2Var);

    void onStart(rx2 rx2Var);

    void onSuccess(rx2 rx2Var, String str, String str2);

    void onWait(rx2 rx2Var);
}
