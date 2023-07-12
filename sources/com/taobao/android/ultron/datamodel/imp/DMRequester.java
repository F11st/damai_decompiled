package com.taobao.android.ultron.datamodel.imp;

import android.content.Context;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import com.taobao.android.ultron.datamodel.IRequestCallback;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import tb.co2;
import tb.f1;
import tb.is;
import tb.lx1;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMRequester implements IDMRequester {
    public static final String HEADER_FEATURE_KEY = "feature";
    public static final String HEADER_FEATURE_VAL = "{\"gzip\":\"true\"}";
    public static final String KEY_FEATURE_DATA_PARSE = "dataProcess";
    public static final String KEY_FEATURE_REQUEST_ERROR = "netRequest";
    public static final String KEY_FEATURE_VERSION = "1.0";
    public static final String KEY_IS_CACHE_DATA = "isCachaData";
    MtopRequest a;
    IDMContext b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    String g;
    String h;
    int i;
    boolean j;
    Map<String, String> k;
    IDMComponent l;
    Map<String, String> m;
    Class<?> n;
    String o;
    Context p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class Response implements IRemoteBaseListener, IRemoteCacheListener {
        C6661a mDMContext;
        f1 mOuterCallback;

        Response(f1 f1Var, C6661a c6661a) {
            this.mDMContext = c6661a;
            this.mOuterCallback = f1Var;
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
        public void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
            vt2.b("DMRequester", "onCached,request: " + DMRequester.this.a.toString());
            if (mtopCacheEvent.getMtopResponse() != null) {
                vt2.b("DMRequester", "onCached, response: " + mtopCacheEvent.getMtopResponse().getDataJsonObject());
            }
            co2.d("DMRequester-" + DMRequester.this.a.getApiName(), "onCached: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(true);
            MtopResponse mtopResponse = mtopCacheEvent.getMtopResponse();
            try {
                if (this.mOuterCallback.isDealDataOuter(10000, mtopResponse, obj)) {
                    return;
                }
            } catch (Throwable unused) {
            }
            if (DMRequester.this.e) {
                try {
                    this.mOuterCallback.onSuccess(10000, mtopResponse, obj, this.mDMContext, null);
                    return;
                } catch (Throwable th) {
                    vt2.b("DMRequester", "submit onSuccess callback error", th.getMessage());
                    return;
                }
            }
            ParseResponseHelper parseResponseHelper = new ParseResponseHelper(this.mDMContext);
            parseResponseHelper.p(mtopResponse);
            try {
                if (parseResponseHelper.i()) {
                    this.mOuterCallback.onSuccess(10000, mtopResponse, obj, this.mDMContext, parseResponseHelper.f());
                } else {
                    parseResponseHelper.d(DMRequester.KEY_IS_CACHE_DATA, "true");
                    this.mOuterCallback.onError(10000, mtopResponse, obj, true, parseResponseHelper.f());
                }
            } catch (Throwable th2) {
                vt2.b("DMRequester", "submit onSuccess callback error", th2.getMessage());
            }
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onError(int i, MtopResponse mtopResponse, Object obj) {
            vt2.b("DMRequester", "onError: errorCode:" + mtopResponse.getRetCode() + ",errorMsg:" + mtopResponse.getRetMsg() + ",request: " + DMRequester.this.a.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("DMRequester-");
            sb.append(DMRequester.this.a.getApiName());
            String sb2 = sb.toString();
            co2.a(sb2, "onError: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(false);
            try {
                f1 f1Var = this.mOuterCallback;
                if (f1Var != null && !f1Var.isDealDataOuter(i, mtopResponse, obj)) {
                    this.mOuterCallback.onError(i, mtopResponse, obj, false, null);
                }
            } catch (Exception e) {
                vt2.b("DMRequester", "onError 节点onError回调处理错误出错", e.getMessage());
            }
            UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_REQUEST_ERROR, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            Object obj2;
            vt2.b("DMRequester", "onSuccess, request: " + DMRequester.this.a.toString());
            if (mtopResponse != null) {
                vt2.b("DMRequester", "onSuccess, response: " + mtopResponse.getDataJsonObject());
            }
            co2.a("DMRequester-" + DMRequester.this.a.getApiName(), "DMRequester onSuccess: " + DMRequester.this.a.getApiName());
            co2.c(co2.KEY_ULTRON_PROFILE, "onSucess: " + DMRequester.this.a.getApiName());
            if (this.mDMContext.isCacheData()) {
                this.mDMContext.t();
                this.mDMContext.u(false);
            }
            try {
                try {
                    if (this.mOuterCallback.isDealDataOuter(i, mtopResponse, obj)) {
                        return;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            co2.c(co2.KEY_ULTRON_PROFILE, "isDealDataOuter");
            if (DMRequester.this.e) {
                try {
                    this.mOuterCallback.onSuccess(i, mtopResponse, obj, this.mDMContext, null);
                    return;
                } catch (Throwable th) {
                    vt2.b("DMRequester", "submit onSuccess callback error", th.getMessage());
                    return;
                }
            }
            ParseResponseHelper parseResponseHelper = new ParseResponseHelper(this.mDMContext);
            JSONObject jSONObject = (JSONObject) JSON.parseObject(mtopResponse.getBytedata(), JSONObject.class, new Feature[0]);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            parseResponseHelper.n(jSONObject2);
            if (parseResponseHelper.h(lx1.FEATURE_CONTAINER_CACHE)) {
                DMRequester dMRequester = DMRequester.this;
                parseResponseHelper.s(dMRequester.p, dMRequester.o, jSONObject2, true, true);
            }
            parseResponseHelper.o(jSONObject);
            co2.c(co2.KEY_ULTRON_PROFILE, "parse complete");
            try {
                if (parseResponseHelper.i()) {
                    this.mOuterCallback.onSuccess(i, mtopResponse, obj, this.mDMContext, parseResponseHelper.f());
                } else {
                    this.mOuterCallback.onError(i, mtopResponse, obj, true, parseResponseHelper.f());
                    Map<String, Object> f = parseResponseHelper.f();
                    if (f == null) {
                        return;
                    }
                    if (!(f.get("protocolVersion") instanceof String)) {
                        return;
                    }
                    try {
                        if (Float.parseFloat((String) obj2) > 2.1d) {
                            UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_DATA_PARSE, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, "parse response error", "error msg");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                vt2.b("DMRequester", "submit onSuccess callback error", th2.getMessage());
            }
            co2.c(co2.KEY_ULTRON_PROFILE, "callback complete");
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
        public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            vt2.b("DMRequester", "onSystemError: errorCode:" + mtopResponse.getRetCode() + ",errorMsg:" + mtopResponse.getRetMsg() + ",request: " + DMRequester.this.a.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("DMRequester-");
            sb.append(DMRequester.this.a.getApiName());
            String sb2 = sb.toString();
            co2.a(sb2, "onSystemError: " + DMRequester.this.a.getApiName());
            this.mDMContext.u(false);
            try {
                f1 f1Var = this.mOuterCallback;
                if (f1Var != null && !f1Var.isDealDataOuter(i, mtopResponse, obj)) {
                    this.mOuterCallback.onError(i, mtopResponse, obj, false, null);
                }
            } catch (Exception e) {
                vt2.b("DMRequester", "onSystemError 节点onError回调处理错误出错", e.getMessage());
            }
            UmbrellaTracker.commitFailureStability(DMRequester.KEY_FEATURE_REQUEST_ERROR, DMRequester.this.a.getApiName(), DMRequester.this.a.getVersion(), DMRequester.this.o, null, null, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.ultron.datamodel.imp.DMRequester$a */
    /* loaded from: classes11.dex */
    class C6659a extends f1 {
        private IRequestCallback a;

        public C6659a(DMRequester dMRequester, IRequestCallback iRequestCallback) {
            this.a = iRequestCallback;
        }

        @Override // com.taobao.android.ultron.datamodel.IRequestCallback
        public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ?> map) {
            IRequestCallback iRequestCallback = this.a;
            if (iRequestCallback != null) {
                iRequestCallback.onError(i, mtopResponse, obj, false, map);
            }
        }

        @Override // com.taobao.android.ultron.datamodel.IRequestCallback
        public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ?> map) {
            IRequestCallback iRequestCallback = this.a;
            if (iRequestCallback != null) {
                iRequestCallback.onSuccess(i, mtopResponse, obj, iDMContext, map);
            }
        }
    }

    public DMRequester(is isVar) {
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = true;
        this.i = -1;
        this.j = false;
        this.o = "default";
        if (isVar == null) {
            return;
        }
        this.f = isVar.v();
        if (isVar.m() != null) {
            this.b = isVar.m();
        } else {
            this.b = new C6661a(this.f);
        }
        this.k = isVar.o();
        this.g = isVar.n();
        this.h = isVar.s();
        this.d = isVar.u();
        this.e = isVar.z();
        this.j = isVar.A();
        this.c = isVar.y();
        this.i = isVar.j();
        this.l = isVar.r();
        this.m = isVar.p();
        this.n = isVar.q();
        this.o = isVar.k();
        MtopRequest mtopRequest = new MtopRequest();
        this.a = mtopRequest;
        mtopRequest.setApiName(isVar.i());
        this.a.setVersion(isVar.t());
        this.a.setNeedSession(isVar.x());
        this.a.setNeedEcode(isVar.w());
        this.p = isVar.l();
        this.b.setBizName(this.o);
        ((C6661a) this.b).x(isVar.l());
    }

    private boolean a(Object obj, f1 f1Var) {
        IDMContext iDMContext = this.b;
        if (iDMContext instanceof C6661a) {
            C6661a c6661a = (C6661a) iDMContext;
            if (this.m == null) {
                this.m = new HashMap();
            }
            if (this.d) {
                if (this.f) {
                    this.m.put("feature", "{\"gzip\":\"true\"}");
                }
                this.m.put("params", c6661a.g().a(c6661a, this.l));
                JSONObject jSONObject = new JSONObject();
                jSONObject.putAll(this.m);
                this.a.setData(jSONObject.toJSONString());
            } else if (this.e) {
                if (this.f) {
                    this.m.put("feature", "{\"gzip\":\"true\"}");
                }
                this.m.put("params", c6661a.g().g(c6661a));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putAll(this.m);
                this.a.setData(jSONObject2.toJSONString());
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putAll(this.m);
                this.a.setData(jSONObject3.toJSONString());
            }
            MtopBusiness build = MtopBusiness.build(this.a);
            if (this.j) {
                build.useWua();
            }
            if (this.c) {
                build.reqMethod(MethodEnum.POST);
            }
            String str = this.g;
            if (str != null) {
                build.setCustomDomain(str);
            }
            int i = this.i;
            if (-1 != i) {
                build.setBizId(i);
            }
            String str2 = this.h;
            if (str2 != null) {
                build.setUnitStrategy(str2);
            }
            Map<String, String> map = this.k;
            if (map != null) {
                build.mtopProp.setRequestHeaders(map);
            }
            if (obj != null) {
                build.reqContext(obj);
            }
            build.setErrorNotifyAfterCache(true);
            Response response = new Response(f1Var, c6661a);
            if (this.n == null) {
                build.addListener((MtopListener) response).startRequest();
            } else {
                build.addListener((MtopListener) response).startRequest(this.n);
            }
            vt2.b("DMRequester", "send request: " + this.a.toString());
            co2.e("DMRequester-" + this.a.getApiName(), "begin request: " + this.a.getApiName());
            return true;
        }
        return false;
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(f1 f1Var) {
        return a(null, f1Var);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(Object obj, f1 f1Var) {
        return a(obj, f1Var);
    }

    @Override // com.taobao.android.ultron.datamodel.IDMRequester
    public boolean execute(IRequestCallback iRequestCallback) {
        return a(null, new C6659a(this, iRequestCallback));
    }
}
