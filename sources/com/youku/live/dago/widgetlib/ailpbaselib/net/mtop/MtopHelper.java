package com.youku.live.dago.widgetlib.ailpbaselib.net.mtop;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MtopHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String API_VERSION_1_0 = "1.0";
    private static final int CONNECT_TIME_OUT = 10000;
    public static final int MAX_REQUESTS_PER_HOST = 15000;
    public static final String MTOP = "mtop.youku.platform";
    private static final int READ_TIME_OUT = 40000;
    private static final int RETRY_TIMES = 2000;
    private static final int SOCKET_TIME_OUT = 10000;
    public static final String TAG = "MtopHelper";
    private static final int WRITE_TIME_OUT = 40000;
    private static volatile MtopHelper instance;

    private MtopHelper() {
    }

    private void buildMtopBussiness(MtopBusiness mtopBusiness, final String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89890754")) {
            ipChange.ipc$dispatch("-89890754", new Object[]{this, mtopBusiness, str, map, Boolean.valueOf(z), iRemoteBaseListener});
            return;
        }
        mtopBusiness.reqMethod(z ? MethodEnum.GET : MethodEnum.POST);
        mtopBusiness.headers(buildRequestHeader(str, map));
        if (iRemoteBaseListener != null) {
            mtopBusiness.registerListener((IRemoteListener) iRemoteBaseListener);
        } else {
            mtopBusiness.registerListener((IRemoteListener) new IRemoteBaseListener() { // from class: com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1262153271")) {
                        ipChange2.ipc$dispatch("-1262153271", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    } else {
                        MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2031629710")) {
                        ipChange2.ipc$dispatch("2031629710", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                    } else {
                        MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1739988902")) {
                        ipChange2.ipc$dispatch("-1739988902", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    } else {
                        MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                    }
                }
            });
        }
    }

    private Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311948442") ? (Map) ipChange.ipc$dispatch("-311948442", new Object[]{this, str, map}) : new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackToOkHttpRequest(String str, MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710822678")) {
            ipChange.ipc$dispatch("710822678", new Object[]{this, str, mtopResponse});
        } else {
            fetchCommonError(mtopResponse);
        }
    }

    private void fetchCommonError(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964002214")) {
            ipChange.ipc$dispatch("-1964002214", new Object[]{this, mtopResponse});
        } else {
            Log.e("fornia", "passport  sendTokenValidBroadCast55555");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getEnv() {
        /*
            r5 = this;
            java.lang.String r0 = ""
            com.android.alibaba.ip.runtime.IpChange r1 = com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.$ipChange
            java.lang.String r2 = "1954932639"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            if (r3 == 0) goto L19
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r3 = 0
            r0[r3] = r5
            java.lang.Object r0 = r1.ipc$dispatch(r2, r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L19:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r3.<init>()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            android.app.Application r4 = com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils.getApp()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r3.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = "/fornia"
            r3.append(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r4 = "env.txt"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r3 != 0) goto L45
            return r0
        L45:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L6c
            r3.close()     // Catch: java.io.IOException -> L57
            goto L6b
        L57:
            r1 = move-exception
            r1.printStackTrace()
            goto L6b
        L5c:
            r1 = move-exception
            goto L63
        L5e:
            r0 = move-exception
            goto L6e
        L60:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L63:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L57
        L6b:
            return r0
        L6c:
            r0 = move-exception
            r1 = r3
        L6e:
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r1 = move-exception
            r1.printStackTrace()
        L78:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.getEnv():java.lang.String");
    }

    public static MtopHelper getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521860541")) {
            return (MtopHelper) ipChange.ipc$dispatch("1521860541", new Object[0]);
        }
        if (instance == null) {
            synchronized (MtopHelper.class) {
                if (instance == null) {
                    instance = new MtopHelper();
                }
            }
        }
        return instance;
    }

    public static final Class getSuperClassGenricType(Class cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "67574465") ? (Class) ipChange.ipc$dispatch("67574465", new Object[]{cls}) : getSuperClassGenricType(cls, 0);
    }

    private boolean isSuccessCode(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1552431621") ? ((Boolean) ipChange.ipc$dispatch("-1552431621", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i >= 200 && i < 300;
    }

    public void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401304863")) {
            ipChange.ipc$dispatch("-1401304863", new Object[]{this, mtopRequest, str, str2, Boolean.valueOf(z), map});
        } else if (TextUtils.isEmpty(str)) {
            ((ILog) Dsl.getService(ILog.class)).e(TAG, "mtop url api is empty!!!");
        } else {
            mtopRequest.setApiName(str);
            if (TextUtils.isEmpty(str2)) {
                mtopRequest.setVersion(API_VERSION_1_0);
            } else {
                mtopRequest.setVersion(str2);
            }
            mtopRequest.setNeedEcode(z);
            if (map == null) {
                map = new HashMap<>();
            }
            mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
        }
    }

    public <T> String doRequest(final String str, String str2, Map<String, String> map, boolean z, final GeneralCallback<T> generalCallback) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-142000024") ? (String) ipChange.ipc$dispatch("-142000024", new Object[]{this, str, str2, map, Boolean.valueOf(z), generalCallback}) : doRequest(str, map, z, new IRemoteBaseListener() { // from class: com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-654076408")) {
                    ipChange2.ipc$dispatch("-654076408", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                } else if (mtopResponse == null) {
                } else {
                    mtopResponse.getDataJsonObject();
                    ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                    GeneralCallback generalCallback2 = generalCallback;
                    if (generalCallback2 != null) {
                        generalCallback2.onFailure("onError:" + mtopResponse.getRetMsg());
                    }
                }
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1064602321")) {
                    ipChange2.ipc$dispatch("-1064602321", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                if (mtopResponse == null) {
                    return;
                }
                mtopResponse.getDataJsonObject();
                if (generalCallback != null) {
                    if (mtopResponse.getDataJsonObject() == null) {
                        generalCallback.onSuccess(null);
                        return;
                    }
                    try {
                        generalCallback.onSuccess(JSON.parseObject(mtopResponse.getDataJsonObject().toString(), MtopHelper.getSuperClassGenricType(generalCallback.getClass())));
                    } catch (Exception e) {
                        e.printStackTrace();
                        generalCallback.onFailure("onError:onSuccess json解析错误");
                    }
                }
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-784467623")) {
                    ipChange2.ipc$dispatch("-784467623", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                if (mtopResponse == null) {
                    return;
                }
                mtopResponse.getDataJsonObject();
                GeneralCallback generalCallback2 = generalCallback;
                if (generalCallback2 != null) {
                    generalCallback2.onFailure("onSystemError:" + mtopResponse.getRetMsg());
                }
            }
        }, str2, false);
    }

    private static final Class getSuperClassGenricType(Class cls, int i) throws IndexOutOfBoundsException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314398236")) {
            return (Class) ipChange.ipc$dispatch("314398236", new Object[]{cls, Integer.valueOf(i)});
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            return (i >= actualTypeArguments.length || i < 0 || !(actualTypeArguments[i] instanceof Class)) ? Object.class : (Class) actualTypeArguments[i];
        }
        return Object.class;
    }

    public String doRequest(String str, String str2, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1645441339") ? (String) ipChange.ipc$dispatch("1645441339", new Object[]{this, str, str2, map, Boolean.valueOf(z), iRemoteBaseListener}) : doRequest(str, map, z, iRemoteBaseListener, str2, false);
    }

    public String doRequest(String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener, String str2, boolean z2) {
        MtopBusiness build;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220925403")) {
            return (String) ipChange.ipc$dispatch("-220925403", new Object[]{this, str, map, Boolean.valueOf(z), iRemoteBaseListener, str2, Boolean.valueOf(z2)});
        }
        MtopRequest mtopRequest = new MtopRequest();
        buildMtopRequest(mtopRequest, str, str2, z2, map);
        if (SdkChannel.isDamai(AppContextUtils.getApp())) {
            build = MtopBusiness.build(Mtop.instance(((INetClient) Dsl.getService(INetClient.class)).getMtopId(), AppContextUtils.getApp()), mtopRequest);
        } else {
            build = MtopBusiness.build(Mtop.instance(Mtop.Id.INNER, AppContextUtils.getApp()), mtopRequest);
        }
        buildMtopBussiness(build, str, map, z, iRemoteBaseListener);
        build.startRequest();
        return null;
    }
}
