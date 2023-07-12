package com.taobao.tao.remotebusiness;

import android.content.Context;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class RemoteBusiness extends MtopBusiness {
    protected RemoteBusiness(Mtop mtop, IMTOPDataObject iMTOPDataObject, String str) {
        super(mtop, iMTOPDataObject, str);
    }

    public static RemoteBusiness build(IMTOPDataObject iMTOPDataObject, String str) {
        return new RemoteBusiness(Mtop.instance((Context) null, str), iMTOPDataObject, str);
    }

    @Deprecated
    public static void init(Context context, String str) {
        Mtop.instance(context, str);
    }

    @Deprecated
    public RemoteBusiness registeListener(MtopListener mtopListener) {
        return (RemoteBusiness) super.registerListener(mtopListener);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness
    @Deprecated
    public void setErrorNotifyNeedAfterCache(boolean z) {
        super.setErrorNotifyAfterCache(z);
    }

    protected RemoteBusiness(Mtop mtop, MtopRequest mtopRequest, String str) {
        super(mtop, mtopRequest, str);
    }

    public static RemoteBusiness build(IMTOPDataObject iMTOPDataObject) {
        return build(iMTOPDataObject, (String) null);
    }

    @Deprecated
    public RemoteBusiness registeListener(IRemoteListener iRemoteListener) {
        return (RemoteBusiness) super.registerListener(iRemoteListener);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness
    @Deprecated
    public RemoteBusiness setErrorNotifyAfterCache(boolean z) {
        return (RemoteBusiness) super.setErrorNotifyAfterCache(z);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness
    @Deprecated
    public RemoteBusiness showLoginUI(boolean z) {
        return (RemoteBusiness) super.showLoginUI(z);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest, String str) {
        return new RemoteBusiness(Mtop.instance((Context) null, str), mtopRequest, str);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness, mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public RemoteBusiness addListener(MtopListener mtopListener) {
        return (RemoteBusiness) super.addListener(mtopListener);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness, mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public RemoteBusiness reqContext(Object obj) {
        return (RemoteBusiness) super.reqContext(obj);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness, mtopsdk.mtop.intf.MtopBuilder
    public RemoteBusiness retryTime(int i) {
        return (RemoteBusiness) super.retryTime(i);
    }

    @Override // com.taobao.tao.remotebusiness.MtopBusiness, mtopsdk.mtop.intf.MtopBuilder
    @Deprecated
    public RemoteBusiness setBizId(int i) {
        return (RemoteBusiness) super.setBizId(i);
    }

    public static RemoteBusiness build(MtopRequest mtopRequest) {
        return build(mtopRequest, (String) null);
    }

    @Deprecated
    public static RemoteBusiness build(Context context, IMTOPDataObject iMTOPDataObject, String str) {
        init(context, str);
        return build(iMTOPDataObject, str);
    }

    @Deprecated
    public static RemoteBusiness build(Context context, MtopRequest mtopRequest, String str) {
        init(context, str);
        return build(mtopRequest, str);
    }
}
