package com.taobao.aranger.core.handler.reply;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements IReplyHandler {
    protected final Call a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Call call) {
        this.a = call;
    }

    protected abstract Object a(Object[] objArr) throws IPCException;

    @Override // com.taobao.aranger.core.handler.reply.IReplyHandler
    public Reply handleReply() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList();
        Object[] a = com.taobao.aranger.utils.a.a(this.a.getParameterWrappers(), arrayList);
        long currentTimeMillis = System.currentTimeMillis();
        Object a2 = a(a);
        Reply invokeTime = Reply.obtain().setResult(a2).setInvokeTime(System.currentTimeMillis() - currentTimeMillis);
        if (!arrayList.isEmpty()) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[arrayList.size()];
            for (Integer num : arrayList) {
                int intValue = num.intValue();
                parameterWrapperArr[intValue] = ParameterWrapper.obtain().setData(a[((Integer) arrayList.get(intValue)).intValue()]);
            }
            invokeTime.setFlowParameterWrappers(parameterWrapperArr);
        }
        return invokeTime;
    }
}
