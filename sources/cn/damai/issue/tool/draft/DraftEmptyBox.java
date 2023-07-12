package cn.damai.issue.tool.draft;

import android.os.Handler;
import android.os.Looper;
import cn.damai.issue.listener.OnCheckDraftListener;
import cn.damai.issue.listener.OnDialogListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DraftEmptyBox implements IDraftBox {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public boolean checkBackPressed(OnDialogListener onDialogListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397896163")) {
            return ((Boolean) ipChange.ipc$dispatch("1397896163", new Object[]{this, onDialogListener})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void checkCacheDraft(final OnCheckDraftListener onCheckDraftListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521894068")) {
            ipChange.ipc$dispatch("521894068", new Object[]{this, onCheckDraftListener});
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.issue.tool.draft.DraftEmptyBox.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1397350934")) {
                        ipChange2.ipc$dispatch("-1397350934", new Object[]{this});
                    } else {
                        onCheckDraftListener.onNoneDraft();
                    }
                }
            });
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void deleteCurDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888578236")) {
            ipChange.ipc$dispatch("888578236", new Object[]{this});
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void notifyPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192334155")) {
            ipChange.ipc$dispatch("1192334155", new Object[]{this});
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void quitAutoDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572467265")) {
            ipChange.ipc$dispatch("-572467265", new Object[]{this});
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65899163")) {
            ipChange.ipc$dispatch("65899163", new Object[]{this});
        }
    }

    @Override // cn.damai.issue.tool.draft.IDraftBox
    public void startAutoDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283457880")) {
            ipChange.ipc$dispatch("283457880", new Object[]{this});
        }
    }
}
