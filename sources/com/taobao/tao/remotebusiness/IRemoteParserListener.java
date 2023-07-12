package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IRemoteParserListener extends MtopListener {
    void parseResponse(MtopResponse mtopResponse);
}
