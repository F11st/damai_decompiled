package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MyFeedBack {
    private static transient /* synthetic */ IpChange $ipChange;
    public MyFeedBackDO feedbackDO;
    public List<MyFeedReplyDO> replyDOs;

    public MyFeedReplyDO getFisrFeedReplyDO() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951805621")) {
            return (MyFeedReplyDO) ipChange.ipc$dispatch("-1951805621", new Object[]{this});
        }
        if (wh2.e(this.replyDOs) > 0) {
            return this.replyDOs.get(0);
        }
        return null;
    }
}
