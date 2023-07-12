package cn.damai.message.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageReponse extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private MessageList data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public MessageList getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1846461030") ? (MessageList) ipChange.ipc$dispatch("-1846461030", new Object[]{this}) : this.data;
    }
}
