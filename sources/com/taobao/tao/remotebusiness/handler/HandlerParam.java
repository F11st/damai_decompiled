package com.taobao.tao.remotebusiness.handler;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HandlerParam implements Serializable {
    private static final long serialVersionUID = 9196408638670689787L;
    public MtopEvent event;
    public MtopListener listener;
    public MtopBusiness mtopBusiness;
    public MtopResponse mtopResponse;
    public BaseOutDo pojo;

    public HandlerParam(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        this.listener = mtopListener;
        this.event = mtopEvent;
        this.mtopBusiness = mtopBusiness;
    }
}
