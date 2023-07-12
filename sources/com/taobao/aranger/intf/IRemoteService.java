package com.taobao.aranger.intf;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IRemoteService extends IService {
    void connect() throws Exception;

    boolean isRemote();

    Reply sendCall(Call call) throws Exception;
}
