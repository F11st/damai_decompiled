package cn.damai.issue.tool.draft;

import cn.damai.issue.listener.OnCheckDraftListener;
import cn.damai.issue.listener.OnDialogListener;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface IDraftBox {
    boolean checkBackPressed(OnDialogListener onDialogListener);

    void checkCacheDraft(OnCheckDraftListener onCheckDraftListener);

    void deleteCurDraft();

    void notifyPublishSuccess();

    void quitAutoDraft();

    void release();

    void startAutoDraft();
}
