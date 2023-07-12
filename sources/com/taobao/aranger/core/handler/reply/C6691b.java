package com.taobao.aranger.core.handler.reply;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.exception.IPCException;
import tb.gk1;
import tb.kf1;
import tb.zt0;

/* compiled from: Taobao */
/* renamed from: com.taobao.aranger.core.handler.reply.b */
/* loaded from: classes12.dex */
public class C6691b {
    public static IReplyHandler a(Call call) throws IPCException {
        int type = call.getServiceWrapper().getType();
        if (type != 0) {
            if (type != 1) {
                if (type == 3) {
                    return new kf1(call);
                }
                throw new IPCException(13, "Type " + call.getServiceWrapper().getType() + " is not supported.");
            }
            return new zt0(call);
        }
        return new gk1(call);
    }
}
