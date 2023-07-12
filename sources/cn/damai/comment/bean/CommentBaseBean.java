package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CommentBaseBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-478441743") ? ipChange.ipc$dispatch("-478441743", new Object[]{this}) : this.data;
    }

    public void setData(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835349903")) {
            ipChange.ipc$dispatch("-1835349903", new Object[]{this, obj});
        } else {
            this.data = obj;
        }
    }
}
