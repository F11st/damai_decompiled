package com.youku.gaiax.provider.module.net;

import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.EnvUrlProviderProxy;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class YYBaseMtopRequest implements IMTOPDataObject {
    public String API_NAME;
    public boolean NEED_ECODE;
    public boolean NEED_SESSION;
    public String VERSION;
    public EnvModeEnum evn;
    private Map<String, String> header;
    private Mtop mtopInstance;
    private Map<String, String> pictureParams;
    private IMTOPDataObject response;
    private boolean useCache;
    private JsonTypeEnum jsonType = JsonTypeEnum.ORIGINALJSON;
    private boolean useWua = true;
    private boolean isShowLoginUI = true;

    public MtopBusiness call() {
        this.API_NAME = getApiName();
        this.VERSION = getVersion();
        this.NEED_ECODE = getNeedEcode();
        this.NEED_SESSION = getNeedSession();
        this.evn = getEvn();
        this.pictureParams = getPictureParams();
        Mtop switchEnvMode = Mtop.instance(Mtop.Id.INNER, AppInfoProviderProxy.getApplication(), AppInfoProviderProxy.getTTID()).registerTtid(AppInfoProviderProxy.getTTID()).switchEnvMode(this.evn);
        this.mtopInstance = switchEnvMode;
        MtopBusiness build = MtopBusiness.build(switchEnvMode, this);
        setRequestData(build);
        build.showLoginUI(this.isShowLoginUI);
        build.setJsonType(this.jsonType);
        build.reqMethod(getHttpMethod());
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

    public abstract String getApiName();

    public EnvModeEnum getEvn() {
        if (EnvUrlProviderProxy.isDaily()) {
            return EnvModeEnum.TEST;
        }
        if (EnvUrlProviderProxy.isPre()) {
            return EnvModeEnum.PREPARE;
        }
        if (EnvUrlProviderProxy.isOnline()) {
            return EnvModeEnum.ONLINE;
        }
        return EnvModeEnum.ONLINE;
    }

    public MethodEnum getHttpMethod() {
        return MethodEnum.GET;
    }

    public abstract boolean getNeedEcode();

    public abstract boolean getNeedSession();

    public Map<String, String> getPictureParams() {
        return this.pictureParams;
    }

    public abstract String getVersion();

    public YYBaseMtopRequest setJsonType(JsonTypeEnum jsonTypeEnum) {
        this.jsonType = jsonTypeEnum;
        return this;
    }

    public void setRequestData(MtopBusiness mtopBusiness) {
        if (mtopBusiness == null) {
            return;
        }
        Map map = mtopBusiness.request.dataParams;
        if (this.pictureParams != null) {
            if (map == null) {
                map = new HashMap();
            }
            map.putAll(this.pictureParams);
        }
        mtopBusiness.request.setData(ReflectUtil.converMapToDataStr(map));
    }

    public YYBaseMtopRequest setRequestHeader(Map<String, String> map) {
        this.header = map;
        return this;
    }

    public YYBaseMtopRequest setResponse(IMTOPDataObject iMTOPDataObject) {
        this.response = iMTOPDataObject;
        return this;
    }

    public void setUseWua(Boolean bool) {
        this.useWua = bool.booleanValue();
    }

    public void showLoginUI(boolean z) {
        this.isShowLoginUI = z;
    }

    public YYBaseMtopRequest useCache() {
        this.useCache = true;
        return this;
    }

    public YYBaseMtopRequest useWua() {
        this.useWua = true;
        return this;
    }
}
