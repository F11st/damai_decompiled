package com.android.dingtalk.share.ddsharemodule;

import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.BaseResp;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IDDAPIEventHandler {
    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
