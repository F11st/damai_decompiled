package com.youku.live.dsl.network;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.network.IRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.ReflectUtil;
import tb.mu0;
import tb.w20;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IMtopRequestImp implements IRequest, MtopCallback.MtopFinishListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String api;
    private final String apiVersion;
    private IRequestCallback failureCallback;
    private Handler mHandler;
    private IResponse mResponse;
    private String mSheduler;
    private MtopBuilder mtopBuilder;
    private ApiID mtopRequest;
    private final boolean needLogin;
    private final Map<String, String> params;
    private final boolean post;
    private MtopRequest request;
    private IRequestCallback successCallback;

    public IMtopRequestImp(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        this.api = str;
        this.apiVersion = str2;
        Map<String, String> c = w20.b().c(str, map);
        this.params = c;
        this.post = z;
        this.needLogin = z2;
        MtopRequest mtopRequest = new MtopRequest();
        this.request = mtopRequest;
        mtopRequest.setApiName(str);
        this.request.setVersion(str2);
        this.request.setNeedEcode(z2);
        this.request.setData(ReflectUtil.convertMapToDataStr(c));
        MtopBuilder addListener = Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p()).build(this.request, AppConfig.p()).reqMethod(z ? MethodEnum.POST : MethodEnum.GET).addListener(this);
        this.mtopBuilder = addListener;
        try {
            addListener.headers(buildRequestHeader(str, c));
        } catch (Exception unused) {
        }
    }

    private Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1669785245")) {
            return (Map) ipChange.ipc$dispatch("1669785245", new Object[]{this, str, map});
        }
        HashMap hashMap = new HashMap();
        TextUtils.isEmpty(((IUser) Dsl.getService(IUser.class)).getId());
        return hashMap;
    }

    private void clearCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225295348")) {
            ipChange.ipc$dispatch("-225295348", new Object[]{this});
            return;
        }
        this.mResponse = null;
        this.request = null;
        this.mtopBuilder = null;
        this.successCallback = null;
        this.failureCallback = null;
        this.mtopRequest = null;
    }

    private Handler getHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682417703")) {
            return (Handler) ipChange.ipc$dispatch("-1682417703", new Object[]{this});
        }
        if (this.mHandler == null) {
            synchronized (this) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.mHandler;
    }

    private String getSheduler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30155675")) {
            return (String) ipChange.ipc$dispatch("-30155675", new Object[]{this});
        }
        String str = this.mSheduler;
        return str == null ? IRequest.Scheduler.ASYNC_SCHEDULER : str;
    }

    private boolean isMainSheduler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2079752490") ? ((Boolean) ipChange.ipc$dispatch("2079752490", new Object[]{this})).booleanValue() : getSheduler().equals(IRequest.Scheduler.MAIN_SCHEDULER);
    }

    private void processMtopResponse(MtopResponse mtopResponse) {
        final IRequestCallback iRequestCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463557462")) {
            ipChange.ipc$dispatch("1463557462", new Object[]{this, mtopResponse});
            return;
        }
        final IResponse iResponse = this.mResponse;
        if (mtopResponse != null && mtopResponse.isApiSuccess()) {
            iRequestCallback = this.successCallback;
        } else {
            iRequestCallback = this.failureCallback;
        }
        if (iRequestCallback != null) {
            if (iResponse instanceof IMtopResponseAttacher) {
                ((IMtopResponseAttacher) iResponse).attachResponse(mtopResponse);
            }
            if (iResponse instanceof IMtopResponseModelImp) {
                ((IMtopResponseModelImp) iResponse).getMtopBeanWithClass(IMtopResponseModelImp.getSuperClassGenricType(iRequestCallback.getClass(), 0));
            }
            Runnable runnable = new Runnable() { // from class: com.youku.live.dsl.network.IMtopRequestImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "712691889")) {
                        ipChange2.ipc$dispatch("712691889", new Object[]{this});
                    } else {
                        iRequestCallback.onCallback(iResponse);
                    }
                }
            };
            if (isMainSheduler()) {
                getHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
        clearCache();
    }

    @Override // com.youku.live.dsl.network.IRequest
    public IRequest async(IRequestCallback iRequestCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316018928")) {
            return (IRequest) ipChange.ipc$dispatch("1316018928", new Object[]{this, iRequestCallback});
        }
        this.successCallback = iRequestCallback;
        this.mResponse = new IMtopResponseImp();
        this.mtopRequest = this.mtopBuilder.asyncRequest();
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425256281")) {
            ipChange.ipc$dispatch("-425256281", new Object[]{this});
            return;
        }
        ApiID apiID = this.mtopRequest;
        if (apiID == null || apiID.isCancelled()) {
            return;
        }
        this.mtopRequest.cancelApiCall();
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "848904")) {
            ipChange.ipc$dispatch("848904", new Object[]{this, mtopFinishEvent, obj});
        } else {
            processMtopResponse(mtopFinishEvent != null ? mtopFinishEvent.mtopResponse : null);
        }
    }

    @Override // com.youku.live.dsl.network.IRequest
    public IRequest postCallbackOn(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449750416")) {
            return (IRequest) ipChange.ipc$dispatch("1449750416", new Object[]{this, str});
        }
        if (IRequest.Scheduler.MAIN_SCHEDULER.equals(str)) {
            this.mSheduler = IRequest.Scheduler.MAIN_SCHEDULER;
        } else if (IRequest.Scheduler.ASYNC_SCHEDULER.equals(str)) {
            this.mSheduler = IRequest.Scheduler.ASYNC_SCHEDULER;
        }
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public IRequest sync(IRequestCallback iRequestCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013853641")) {
            return (IRequest) ipChange.ipc$dispatch("-2013853641", new Object[]{this, iRequestCallback});
        }
        this.successCallback = iRequestCallback;
        this.mResponse = new IMtopResponseImp();
        processMtopResponse(this.mtopBuilder.syncRequest());
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public <Model extends Serializable> IRequest async(IRequestModelCallback<Model> iRequestModelCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927286337")) {
            return (IRequest) ipChange.ipc$dispatch("-1927286337", new Object[]{this, iRequestModelCallback});
        }
        this.successCallback = iRequestModelCallback;
        this.mResponse = new IMtopResponseModelImp();
        this.mtopRequest = this.mtopBuilder.asyncRequest();
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public IRequest sync(IRequestCallback iRequestCallback, IRequestCallback iRequestCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249178959")) {
            return (IRequest) ipChange.ipc$dispatch("249178959", new Object[]{this, iRequestCallback, iRequestCallback2});
        }
        this.successCallback = iRequestCallback;
        this.failureCallback = iRequestCallback2;
        this.mResponse = new IMtopResponseImp();
        processMtopResponse(this.mtopBuilder.syncRequest());
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public IRequest async(IRequestCallback iRequestCallback, IRequestCallback iRequestCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311619894")) {
            return (IRequest) ipChange.ipc$dispatch("311619894", new Object[]{this, iRequestCallback, iRequestCallback2});
        }
        this.successCallback = iRequestCallback;
        this.failureCallback = iRequestCallback2;
        this.mResponse = new IMtopResponseImp();
        this.mtopRequest = this.mtopBuilder.asyncRequest();
        return this;
    }

    @Override // com.youku.live.dsl.network.IRequest
    public <Model extends Serializable> IRequest async(IRequestModelCallback<Model> iRequestModelCallback, IRequestModelCallback<Model> iRequestModelCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219920824")) {
            return (IRequest) ipChange.ipc$dispatch("-1219920824", new Object[]{this, iRequestModelCallback, iRequestModelCallback2});
        }
        this.successCallback = iRequestModelCallback;
        this.failureCallback = iRequestModelCallback2;
        this.mResponse = new IMtopResponseModelImp();
        this.mtopRequest = this.mtopBuilder.asyncRequest();
        return this;
    }
}
