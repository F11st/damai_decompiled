package cn.damai.common.net.mtop.netfit;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
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
public abstract class DMBaseMtopRequest implements IMTOPDataObject {
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
    private boolean takePrivateParams = true;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum HttpMethod {
        GET,
        POST
    }

    public MtopBusiness build() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482016915")) {
            return (MtopBusiness) ipChange.ipc$dispatch("1482016915", new Object[]{this});
        }
        this.API_NAME = getApiName();
        this.VERSION = getVersion();
        this.NEED_ECODE = getNeedEcode();
        this.NEED_SESSION = getNeedSession();
        Mtop registerTtid = Mtop.instance(Mtop.Id.INNER, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
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
        return build;
    }

    public MtopBusiness call() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "916306743")) {
            return (MtopBusiness) ipChange.ipc$dispatch("916306743", new Object[]{this});
        }
        this.API_NAME = getApiName();
        this.VERSION = getVersion();
        this.NEED_ECODE = getNeedEcode();
        this.NEED_SESSION = getNeedSession();
        Mtop registerTtid = Mtop.instance(Mtop.Id.INNER, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
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
        if (AndroidInstantRuntime.support(ipChange, "1969769463")) {
            return (Map) ipChange.ipc$dispatch("1969769463", new Object[]{this});
        }
        if (!this.takePrivateParams) {
            return n6.e();
        }
        return n6.b();
    }

    public HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1942348282") ? (HttpMethod) ipChange.ipc$dispatch("-1942348282", new Object[]{this}) : HttpMethod.GET;
    }

    public abstract boolean getNeedEcode();

    public abstract boolean getNeedSession();

    public abstract String getVersion();

    public boolean isTakePrivateParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2084587301") ? ((Boolean) ipChange.ipc$dispatch("-2084587301", new Object[]{this})).booleanValue() : this.takePrivateParams;
    }

    public MtopBusiness request(IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-699879106")) {
            return (MtopBusiness) ipChange.ipc$dispatch("-699879106", new Object[]{this, iRemoteBaseListener});
        }
        this.listener = iRemoteBaseListener;
        if (iRemoteBaseListener instanceof DMMtopRequestListener) {
            ((DMMtopRequestListener) iRemoteBaseListener).setShowLoginUI(this.isShowLoginUI);
        } else if (iRemoteBaseListener instanceof DMMtopResultRequestListener) {
            ((DMMtopResultRequestListener) iRemoteBaseListener).setShowLoginUI(this.isShowLoginUI);
        }
        return call();
    }

    public DMBaseMtopRequest setJsonType(JsonTypeEnum jsonTypeEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550951319")) {
            return (DMBaseMtopRequest) ipChange.ipc$dispatch("-1550951319", new Object[]{this, jsonTypeEnum});
        }
        this.jsonType = jsonTypeEnum;
        return this;
    }

    public void setLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310905896")) {
            ipChange.ipc$dispatch("-310905896", new Object[]{this});
            return;
        }
        double[] dMCoordinates = Util.getDMCoordinates(getApiName());
        if (dMCoordinates != null) {
            this.mtopInstance.setCoordinates(String.valueOf(dMCoordinates[0]), String.valueOf(dMCoordinates[1]));
        } else {
            this.mtopInstance.setCoordinates("", "");
        }
    }

    public void setRequestData(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583247266")) {
            ipChange.ipc$dispatch("583247266", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness == null) {
        } else {
            Map<String, String> map = mtopBusiness.request.dataParams;
            Map<String, String> c = w20.b().c(getApiName(), map);
            c.putAll(map);
            mtopBusiness.request.setData(ReflectUtil.converMapToDataStr(c));
        }
    }

    public DMBaseMtopRequest setRequestHeader(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509625641")) {
            return (DMBaseMtopRequest) ipChange.ipc$dispatch("-509625641", new Object[]{this, map});
        }
        this.header = map;
        return this;
    }

    public DMBaseMtopRequest setResponse(IMTOPDataObject iMTOPDataObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930815695")) {
            return (DMBaseMtopRequest) ipChange.ipc$dispatch("1930815695", new Object[]{this, iMTOPDataObject});
        }
        this.response = iMTOPDataObject;
        return this;
    }

    public void setTakePrivateParams(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413828391")) {
            ipChange.ipc$dispatch("-413828391", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.takePrivateParams = z;
        }
    }

    public void showLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23426747")) {
            ipChange.ipc$dispatch("-23426747", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowLoginUI = z;
        }
    }

    public DMBaseMtopRequest useCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121453869")) {
            return (DMBaseMtopRequest) ipChange.ipc$dispatch("-1121453869", new Object[]{this});
        }
        this.useCache = true;
        return this;
    }

    public DMBaseMtopRequest useWua() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856029426")) {
            return (DMBaseMtopRequest) ipChange.ipc$dispatch("856029426", new Object[]{this});
        }
        this.useWua = true;
        return this;
    }

    public MtopBusiness request(DMMtopCacheListener dMMtopCacheListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180662953")) {
            return (MtopBusiness) ipChange.ipc$dispatch("180662953", new Object[]{this, dMMtopCacheListener});
        }
        this.dmMtopCacheListener = dMMtopCacheListener;
        return call();
    }
}
