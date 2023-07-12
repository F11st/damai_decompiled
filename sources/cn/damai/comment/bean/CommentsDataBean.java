package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CommentsDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommentsResultBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public CommentsResultBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-94512867") ? (CommentsResultBean) ipChange.ipc$dispatch("-94512867", new Object[]{this}) : this.data;
    }
}
