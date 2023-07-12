package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IRemoteBaseListener extends IRemoteListener {
    void onSystemError(int i, MtopResponse mtopResponse, Object obj);
}
