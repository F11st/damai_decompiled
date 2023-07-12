package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
abstract class MtopBaseListener {
    protected MtopListener listener;
    protected MtopBusiness mtopBusiness;

    /* JADX INFO: Access modifiers changed from: protected */
    public MtopBaseListener(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.mtopBusiness = mtopBusiness;
        this.listener = mtopListener;
    }
}
