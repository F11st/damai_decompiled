package cn.damai.user.repertoite.bean.comment;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RepertoireDetailCommentResultBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private RepertoireDetailCommentBean data;

    public void setData(RepertoireDetailCommentBean repertoireDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746569475")) {
            ipChange.ipc$dispatch("-746569475", new Object[]{this, repertoireDetailCommentBean});
        } else {
            this.data = repertoireDetailCommentBean;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public RepertoireDetailCommentBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "192280143") ? (RepertoireDetailCommentBean) ipChange.ipc$dispatch("192280143", new Object[]{this}) : this.data;
    }
}
