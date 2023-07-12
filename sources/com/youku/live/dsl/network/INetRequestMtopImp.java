package com.youku.live.dsl.network;

import android.app.Activity;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.IUser;
import com.youku.live.widgets.WidgetSDKEngine;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;
import tb.mu0;
import tb.w20;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class INetRequestMtopImp implements IRemoteBaseListener, INetRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String api;
    private String apiVersion;
    private boolean isPost;
    private WeakReference<Activity> mActivity;
    private MtopBusiness mMtopBusiness;
    private MtopRequest mMtopRequest;
    private INetCallback mNetCallback;
    private INetError mNetError;
    private boolean needLogin;
    private Map<String, String> params;

    public INetRequestMtopImp(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        this.api = str;
        this.apiVersion = str2;
        this.params = w20.b().c(str, map);
        this.isPost = z;
        this.needLogin = z2;
    }

    private void buildMtopBussiness(MtopBusiness mtopBusiness, String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118331448")) {
            ipChange.ipc$dispatch("-118331448", new Object[]{this, mtopBusiness, str, map, Boolean.valueOf(z)});
            return;
        }
        mtopBusiness.reqMethod(z ? MethodEnum.GET : MethodEnum.POST);
        try {
            mtopBusiness.headers(buildRequestHeader(str, map));
        } catch (Exception unused) {
        }
        mtopBusiness.registerListener((IRemoteListener) this);
    }

    private Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357552086")) {
            return (Map) ipChange.ipc$dispatch("357552086", new Object[]{this, str, map});
        }
        HashMap hashMap = new HashMap();
        TextUtils.isEmpty(((IUser) Dsl.getService(IUser.class)).getId());
        return hashMap;
    }

    private boolean isSuccessCode(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1118517131") ? ((Boolean) ipChange.ipc$dispatch("1118517131", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i >= 200 && i < 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preprocess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638683556")) {
            ipChange.ipc$dispatch("-638683556", new Object[]{this});
            return;
        }
        MtopRequest mtopRequest = new MtopRequest();
        buildMtopRequest(mtopRequest, this.api, this.apiVersion, this.needLogin, this.params);
        MtopBusiness build = MtopBusiness.build(Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p()), mtopRequest);
        buildMtopBussiness(build, this.api, this.params, true ^ this.isPost);
        this.mMtopRequest = mtopRequest;
        this.mMtopBusiness = build;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async(final INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921877716")) {
            return (INetRequest) ipChange.ipc$dispatch("-921877716", new Object[]{this, iNetCallback});
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.dsl.network.INetRequestMtopImp.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-456344214")) {
                    ipChange2.ipc$dispatch("-456344214", new Object[]{this});
                    return;
                }
                INetRequestMtopImp.this.preprocess();
                MtopBusiness mtopBusiness = INetRequestMtopImp.this.mMtopBusiness;
                INetRequestMtopImp.this.mNetCallback = iNetCallback;
                mtopBusiness.startRequest();
            }
        });
        return this;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async2(Activity activity, INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877697290")) {
            return (INetRequest) ipChange.ipc$dispatch("1877697290", new Object[]{this, activity, iNetCallback});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async2(Activity activity, INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015725811")) {
            return (INetRequest) ipChange.ipc$dispatch("-2015725811", new Object[]{this, activity, iNetCallback, iNetError});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async2(INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961435336")) {
            return (INetRequest) ipChange.ipc$dispatch("-961435336", new Object[]{this, iNetCallback});
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async2(INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68638021")) {
            return (INetRequest) ipChange.ipc$dispatch("-68638021", new Object[]{this, iNetCallback, iNetError});
        }
        return null;
    }

    public void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144788305")) {
            ipChange.ipc$dispatch("1144788305", new Object[]{this, mtopRequest, str, str2, Boolean.valueOf(z), map});
            return;
        }
        mtopRequest.setApiName(str);
        if (TextUtils.isEmpty(str2)) {
            mtopRequest.setVersion("1.0");
        } else {
            mtopRequest.setVersion(str2);
        }
        mtopRequest.setNeedEcode(z);
        mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070450859")) {
            ipChange.ipc$dispatch("-2070450859", new Object[]{this});
            return;
        }
        this.mMtopRequest = null;
        this.mMtopBusiness = null;
        this.mNetCallback = null;
        this.mNetError = null;
        this.mActivity = null;
    }

    public void commonCallback(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1848622275")) {
            ipChange.ipc$dispatch("-1848622275", new Object[]{this, mtopResponse});
            return;
        }
        String str = null;
        r0 = null;
        INetResponseImp success = null;
        if (mtopResponse == null) {
            INetError iNetError = this.mNetError;
            if (iNetError != null) {
                iNetError.onError("");
            }
        } else {
            if (mtopResponse.getRetCode() != null) {
                mtopResponse.isSessionInvalid();
            }
            try {
                str = new String(mtopResponse.getBytedata());
            } catch (Exception unused) {
            }
            success = new INetResponseImp().setRawData(mtopResponse.getBytedata()).setSource(str).setRetCode(mtopResponse.getRetCode()).setRetMessage(mtopResponse.getRetMsg()).setSuccess((isSuccessCode(mtopResponse.getResponseCode()) && mtopResponse.isApiSuccess()) ? false : false);
        }
        INetCallback iNetCallback = this.mNetCallback;
        INetError iNetError2 = this.mNetError;
        if (isSuccessCode(mtopResponse.getResponseCode()) && mtopResponse.isApiSuccess()) {
            if (iNetCallback != null) {
                iNetCallback.onFinish(success);
            }
        } else if (iNetError2 != null) {
            iNetError2.onError(mtopResponse.getRetMsg());
        }
        clear();
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848913419")) {
            ipChange.ipc$dispatch("1848913419", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
        } else {
            commonCallback(mtopResponse);
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623716748")) {
            ipChange.ipc$dispatch("623716748", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else {
            commonCallback(mtopResponse);
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340738844")) {
            ipChange.ipc$dispatch("340738844", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
        } else {
            commonCallback(mtopResponse);
        }
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest sync(INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "302837875") ? (INetRequest) ipChange.ipc$dispatch("302837875", new Object[]{this, iNetCallback}) : sync(null, iNetCallback, null);
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest sync(Activity activity, INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-805979131") ? (INetRequest) ipChange.ipc$dispatch("-805979131", new Object[]{this, activity, iNetCallback}) : sync(activity, iNetCallback, null);
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async(Activity activity, INetCallback iNetCallback) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-941339138") ? (INetRequest) ipChange.ipc$dispatch("-941339138", new Object[]{this, activity, iNetCallback}) : async(activity, iNetCallback, null);
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest sync(INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2100318794") ? (INetRequest) ipChange.ipc$dispatch("-2100318794", new Object[]{this, iNetCallback, iNetError}) : sync(null, iNetCallback, iNetError);
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async(INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1967837777") ? (INetRequest) ipChange.ipc$dispatch("-1967837777", new Object[]{this, iNetCallback, iNetError}) : async(null, iNetCallback, iNetError);
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest sync(Activity activity, INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111854648")) {
            return (INetRequest) ipChange.ipc$dispatch("-111854648", new Object[]{this, activity, iNetCallback, iNetError});
        }
        preprocess();
        this.mActivity = new WeakReference<>(activity);
        this.mNetCallback = iNetCallback;
        this.mNetError = iNetError;
        this.mMtopBusiness.syncRequest();
        return this;
    }

    @Override // com.youku.live.dsl.network.INetRequest
    public INetRequest async(final Activity activity, final INetCallback iNetCallback, final INetError iNetError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665168639")) {
            return (INetRequest) ipChange.ipc$dispatch("-1665168639", new Object[]{this, activity, iNetCallback, iNetError});
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.dsl.network.INetRequestMtopImp.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-652857719")) {
                    ipChange2.ipc$dispatch("-652857719", new Object[]{this});
                    return;
                }
                INetRequestMtopImp.this.preprocess();
                INetRequestMtopImp.this.mActivity = new WeakReference(activity);
                INetRequestMtopImp.this.mNetCallback = iNetCallback;
                INetRequestMtopImp.this.mNetError = iNetError;
                INetRequestMtopImp.this.mMtopBusiness.syncRequest();
            }
        });
        return this;
    }
}
