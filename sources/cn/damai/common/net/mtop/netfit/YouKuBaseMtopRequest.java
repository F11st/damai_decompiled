package cn.damai.common.net.mtop.netfit;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.Map;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;
import tb.mu0;
import tb.n6;
import tb.w20;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class YouKuBaseMtopRequest implements IMTOPDataObject {
    private static transient /* synthetic */ IpChange $ipChange;
    public String API_NAME;
    public boolean NEED_ECODE;
    public boolean NEED_SESSION;
    public String VERSION;
    private DMMtopCacheListener dmMtopCacheListener;
    private Map<String, String> header;
    private IRemoteBaseListener listener;
    private Mtop mtopInstance;
    private IMTOPDataObject response;
    private boolean useCache;
    private boolean useWua;
    private JsonTypeEnum jsonType = JsonTypeEnum.ORIGINALJSON;
    private boolean isShowLoginUI = true;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum HttpMethod {
        GET,
        POST
    }

    public MtopBusiness call() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304037727")) {
            return (MtopBusiness) ipChange.ipc$dispatch("-304037727", new Object[]{this});
        }
        this.API_NAME = getApiName();
        this.VERSION = getVersion();
        this.NEED_ECODE = getNeedEcode();
        this.NEED_SESSION = getNeedSession();
        Mtop registerTtid = Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
        this.mtopInstance = registerTtid;
        MtopBusiness build = MtopBusiness.build(registerTtid, this);
        Map<String, String> c = w20.b().c(getApiName(), null);
        for (String str : c.keySet()) {
            build.addHttpQueryParameter(str, c.get(str));
        }
        setRequestData(build);
        build.showLoginUI(this.isShowLoginUI);
        if (z20.t()) {
            Map<String, String> headerMap = getHeaderMap();
            headerMap.put("EagleEye-UserData", "scm_project=" + z20.s());
            build.headers(headerMap);
        } else {
            build.headers(getHeaderMap());
        }
        DMMtopCacheListener dMMtopCacheListener = this.dmMtopCacheListener;
        if (dMMtopCacheListener != null) {
            build.registerListener((IRemoteListener) dMMtopCacheListener);
        } else {
            build.registerListener((IRemoteListener) this.listener);
        }
        setLocation();
        build.setJsonType(this.jsonType);
        if (HttpMethod.GET.equals(getHttpMethod())) {
            build.reqMethod(MethodEnum.GET);
        } else if (HttpMethod.POST.equals(getHttpMethod())) {
            build.reqMethod(MethodEnum.POST);
        }
        if (this.useWua) {
            build.useWua();
        }
        if (this.useCache) {
            build.useCache();
        }
        Map<String, String> map = this.header;
        if (map != null) {
            build.headers(map);
        }
        IMTOPDataObject iMTOPDataObject = this.response;
        if (iMTOPDataObject == null) {
            build.startRequest(null);
        } else {
            build.startRequest(iMTOPDataObject.getClass());
        }
        return build;
    }

    public abstract String getApiName();

    public Map<String, String> getHeaderMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1488619443") ? (Map) ipChange.ipc$dispatch("-1488619443", new Object[]{this}) : n6.b();
    }

    public HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-93039494") ? (HttpMethod) ipChange.ipc$dispatch("-93039494", new Object[]{this}) : HttpMethod.GET;
    }

    public abstract boolean getNeedEcode();

    public abstract boolean getNeedSession();

    public abstract String getVersion();

    public MtopBusiness request(IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608598312")) {
            return (MtopBusiness) ipChange.ipc$dispatch("1608598312", new Object[]{this, iRemoteBaseListener});
        }
        this.listener = iRemoteBaseListener;
        if (iRemoteBaseListener instanceof DMMtopRequestListener) {
            ((DMMtopRequestListener) iRemoteBaseListener).setShowLoginUI(this.isShowLoginUI);
        } else if (iRemoteBaseListener instanceof DMMtopResultRequestListener) {
            ((DMMtopResultRequestListener) iRemoteBaseListener).setShowLoginUI(this.isShowLoginUI);
        }
        return call();
    }

    public YouKuBaseMtopRequest setJsonType(JsonTypeEnum jsonTypeEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344131991")) {
            return (YouKuBaseMtopRequest) ipChange.ipc$dispatch("-1344131991", new Object[]{this, jsonTypeEnum});
        }
        this.jsonType = jsonTypeEnum;
        return this;
    }

    public void setLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670144958")) {
            ipChange.ipc$dispatch("-670144958", new Object[]{this});
            return;
        }
        double[] dMCoordinates = Util.getDMCoordinates(getApiName());
        if (dMCoordinates != null) {
            this.mtopInstance.setCoordinates(String.valueOf(dMCoordinates[0]), String.valueOf(dMCoordinates[1]));
        }
    }

    public void setRequestData(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76940808")) {
            ipChange.ipc$dispatch("-76940808", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness == null) {
        } else {
            Map<String, String> map = mtopBusiness.request.dataParams;
            Map<String, String> c = w20.b().c(getApiName(), map);
            c.putAll(map);
            mtopBusiness.request.setData(ReflectUtil.converMapToDataStr(c));
        }
    }

    public YouKuBaseMtopRequest setRequestHeader(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603387973")) {
            return (YouKuBaseMtopRequest) ipChange.ipc$dispatch("-1603387973", new Object[]{this, map});
        }
        this.header = map;
        return this;
    }

    public YouKuBaseMtopRequest setResponse(IMTOPDataObject iMTOPDataObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "567626199")) {
            return (YouKuBaseMtopRequest) ipChange.ipc$dispatch("567626199", new Object[]{this, iMTOPDataObject});
        }
        this.response = iMTOPDataObject;
        return this;
    }

    public void showLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725064219")) {
            ipChange.ipc$dispatch("1725064219", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowLoginUI = z;
        }
    }

    public YouKuBaseMtopRequest useCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136494419")) {
            return (YouKuBaseMtopRequest) ipChange.ipc$dispatch("136494419", new Object[]{this});
        }
        this.useCache = true;
        return this;
    }

    public YouKuBaseMtopRequest useWua() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708393132")) {
            return (YouKuBaseMtopRequest) ipChange.ipc$dispatch("-708393132", new Object[]{this});
        }
        this.useWua = true;
        return this;
    }

    public MtopBusiness request(DMMtopCacheListener dMMtopCacheListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870630381")) {
            return (MtopBusiness) ipChange.ipc$dispatch("-1870630381", new Object[]{this, dMMtopCacheListener});
        }
        this.dmMtopCacheListener = dMMtopCacheListener;
        return call();
    }
}
