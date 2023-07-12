package cn.damai.issue.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import cn.damai.issue.bean.DraftBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class MainThreadDraftListener implements OnDraftListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnDraftListener a;

    public MainThreadDraftListener(OnDraftListener onDraftListener) {
        this.a = onDraftListener;
    }

    @Override // cn.damai.issue.listener.OnDraftListener
    public void onDraft(@Nullable final DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717421765")) {
            ipChange.ipc$dispatch("-717421765", new Object[]{this, draftBean});
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.a.onDraft(draftBean);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.issue.listener.MainThreadDraftListener.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1615427885")) {
                        ipChange2.ipc$dispatch("1615427885", new Object[]{this});
                    } else {
                        MainThreadDraftListener.this.a.onDraft(draftBean);
                    }
                }
            });
        }
    }
}
