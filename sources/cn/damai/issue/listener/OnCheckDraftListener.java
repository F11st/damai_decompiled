package cn.damai.issue.listener;

import cn.damai.issue.bean.DraftBean;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface OnCheckDraftListener {
    void onHasDraft(DraftBean draftBean);

    void onNoneDraft();
}
