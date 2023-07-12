package com.taobao.orange.sync;

import android.text.TextUtils;
import anet.channel.request.C0193a;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import tb.he;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkInterceptor implements Interceptor {
    private static final String ORANGE_LOCAL_ENV = "a-orange-env";
    static final String ORANGE_REQ_HEADER = "a-orange-q";
    private static final String ORANGE_REQ_HEADER_DIFF = "a-orange-dq";
    static final String ORANGE_RES_HEADER = "a-orange-p";
    private static final String ORANGE_RES_HEADER_DIFF = "a-orange-dp";
    static final String TAG = "NetworkInterceptor";

    private C0193a.C0195b addLocalEnvToBuilder(C0193a.C0195b c0195b) {
        if (GlobalOrange.indexEnvCheck) {
            if (OConstant.ENV.ONLINE == GlobalOrange.env) {
                c0195b.I(ORANGE_LOCAL_ENV, "prod");
            } else if (OConstant.ENV.PREPARE == GlobalOrange.env) {
                c0195b.I(ORANGE_LOCAL_ENV, "pre");
            } else if (OConstant.ENV.TEST == GlobalOrange.env) {
                c0195b.I(ORANGE_LOCAL_ENV, "daily");
            }
        }
        return c0195b;
    }

    static String getOrangeFromKey(Map<String, List<String>> map, String str) {
        List<String> list;
        Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                list = null;
                break;
            }
            Map.Entry<String, List<String>> next = it.next();
            if (str.equalsIgnoreCase(next.getKey())) {
                list = next.getValue();
                break;
            }
        }
        if (list != null && !list.isEmpty()) {
            for (String str2 : list) {
                if (str2 != null && str2.startsWith("resourceId")) {
                    if (OLog.isPrintLog(1)) {
                        OLog.d(TAG, "getOrangeFromKey", "value", str2);
                    }
                    try {
                        return URLDecoder.decode(str2, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        OLog.w(TAG, "getOrangeFromKey", e, new Object[0]);
                        return null;
                    }
                }
            }
            OLog.w(TAG, "getOrangeFromKey fail", "parseValue no resourceId");
            return null;
        }
        OLog.w(TAG, "getOrangeFromKey fail", "not exist a-orange-p");
        return null;
    }

    @Override // anetwork.channel.interceptor.Interceptor
    public Future intercept(final Interceptor.Chain chain) {
        boolean z;
        C0193a.C0195b u;
        C0193a request = chain.request();
        Callback callback = chain.callback();
        boolean z2 = false;
        if (GlobalOrange.indexUpdMode != OConstant.UPDMODE.O_EVENT && !TextUtils.isEmpty(request.h()) && !GlobalOrange.probeHosts.isEmpty()) {
            for (String str : GlobalOrange.probeHosts) {
                if (request.h().contains(str)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (GlobalOrange.processIsolated && GlobalOrange.isChannelProcess && OConstant.SUB_PROCESS_INDEX_QUERY_HOSTS[GlobalOrange.env.getEnvMode()].equals(request.h())) {
            z = true;
            z2 = true;
        }
        if (z) {
            if (GlobalOrange.indexDiff > 0) {
                if (z2) {
                    u = chain.request().u().K(true);
                } else {
                    u = chain.request().u();
                }
                C0193a.C0195b addLocalEnvToBuilder = addLocalEnvToBuilder(u);
                int i = GlobalOrange.indexDiff;
                if (i == 1) {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader);
                    }
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeaderDiff)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER_DIFF, GlobalOrange.reqOrangeHeaderDiff);
                    }
                    request = addLocalEnvToBuilder.J();
                } else if (i != 2) {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader);
                    }
                    request = addLocalEnvToBuilder.J();
                } else {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeaderDiff)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER_DIFF, GlobalOrange.reqOrangeHeaderDiff);
                    }
                    request = addLocalEnvToBuilder.J();
                }
            } else if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                C0193a.C0195b addLocalEnvToBuilder2 = addLocalEnvToBuilder(chain.request().u());
                if (z2) {
                    request = addLocalEnvToBuilder2.K(true).I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader).J();
                } else {
                    request = addLocalEnvToBuilder2.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader).J();
                }
            }
            callback = new Callback() { // from class: com.taobao.orange.sync.NetworkInterceptor.1
                @Override // anetwork.channel.interceptor.Callback
                public void onDataReceiveSize(int i2, int i3, he heVar) {
                    chain.callback().onDataReceiveSize(i2, i3, heVar);
                }

                @Override // anetwork.channel.interceptor.Callback
                public void onFinish(DefaultFinishEvent defaultFinishEvent) {
                    chain.callback().onFinish(defaultFinishEvent);
                }

                @Override // anetwork.channel.interceptor.Callback
                public void onResponseCode(int i2, final Map<String, List<String>> map) {
                    if (map != null) {
                        if (GlobalOrange.indexDiff > 0) {
                            if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER_DIFF)) {
                                OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.sync.NetworkInterceptor.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            AndroidUtil.setThreadPriority();
                                            String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER_DIFF);
                                            GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER_DIFF;
                                            IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                        } catch (Throwable th) {
                                            OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                        }
                                    }
                                });
                            } else if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER)) {
                                OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.sync.NetworkInterceptor.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            AndroidUtil.setThreadPriority();
                                            String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER);
                                            GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER;
                                            IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                        } catch (Throwable th) {
                                            OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                        }
                                    }
                                });
                            }
                        } else if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER)) {
                            OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.sync.NetworkInterceptor.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        AndroidUtil.setThreadPriority();
                                        String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER);
                                        GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER;
                                        IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                    } catch (Throwable th) {
                                        OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                    }
                                }
                            });
                        }
                    }
                    chain.callback().onResponseCode(i2, map);
                }
            };
        }
        return chain.proceed(request, callback);
    }
}
