package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import anet.channel.a;
import anet.channel.appmonitor.DefaultAppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.cache.CachePrediction;
import com.taobao.accs.common.Constants;
import com.taobao.android.ab.api.ABGlobal;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.json.JSONArray;
import tb.a60;
import tb.ab2;
import tb.h0;
import tb.hk2;
import tb.hu0;
import tb.jg1;
import tb.nn1;
import tb.o01;
import tb.qj1;
import tb.rj1;
import tb.s50;
import tb.t50;
import tb.t9;
import tb.x6;
import tb.xa2;
import tb.ze;
import tb.zh2;

/* loaded from: classes.dex */
public class TaobaoNetworkAdapter implements Serializable {
    private static final String TAG = "awcn.TaobaoNetworkAdapter";
    public static AtomicBoolean isInited = new AtomicBoolean();

    public static void init(Context context, HashMap<String, Object> hashMap) {
        String str;
        String str2;
        boolean z;
        if (isInited.compareAndSet(false, true)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            t9.s0(defaultSharedPreferences.getBoolean(t9.IPV6_RATE_OPTIMIZE_EANBLE, true));
            if (hashMap != null && "com.taobao.taobao".equals(hashMap.get("process"))) {
                t9.V(true);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("liveng-bfrtc.alibabausercontent.com");
                jSONArray.put("livecb-bfrtc.alibabausercontent.com");
                jSONArray.put("liveca-bfrtc.alibabausercontent.com");
                t9.j0(jSONArray.toString());
                if (t9.E()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
                    arrayList.add(MtopUnitStrategy.TRADE_ONLINE_DOMAIN);
                    arrayList.add("heic.alicdn.com");
                    arrayList.add("gw.alicdn.com");
                    arrayList.add("img.alicdn.com");
                    arrayList.add("g.alicdn.com");
                    arrayList.add("tbm-auth.alicdn.com");
                    arrayList.add("daren-auth.alicdn.com");
                    arrayList.add("bizsec-auth.alicdn.com");
                    HttpDispatcher.f().a(arrayList);
                }
                if (t9.p()) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
                    jSONArray2.put(MtopUnitStrategy.TRADE_ONLINE_DOMAIN);
                    jSONArray2.put("gw.alicdn.com");
                    jSONArray2.put("heic.alicdn.com");
                    jSONArray2.put("ossgw.alicdn.com");
                    jSONArray2.put("dorangesource.alicdn.com");
                    t9.Z(jSONArray2.toString());
                }
            }
            if (hashMap == null || !((rj1.m() && Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get("process"))) || (rj1.I() && ("com.taobao.taobao:widget".equals(hashMap.get("process")) || "com.taobao.taobao:widgetProvider".equals(hashMap.get("process")))))) {
                str = "dorangesource.alicdn.com";
                str2 = "ossgw.alicdn.com";
            } else {
                str2 = "ossgw.alicdn.com";
                str = "dorangesource.alicdn.com";
                ALog.e(TAG, "localInstanceEnable", null, new Object[0]);
                rj1.g0(false);
            }
            if (hashMap != null && Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get("process")) && isABGlobalFeatureOpened(context, "channelCookieOpt").booleanValue()) {
                ALog.e(TAG, "ChannelNoCookieEnable", null, new Object[0]);
                rj1.S(true);
            }
            ALog.h(new hk2());
            rj1.f0(new nn1());
            x6.d(new DefaultAppMonitor());
            qj1.b(new a60());
            anet.channel.fulltrace.a.g(new s50());
            anet.channel.fulltrace.a.h(new t50());
            ThreadPoolExecutorFactory.g(new Runnable() { // from class: anet.channel.TaobaoNetworkAdapter.1

                /* renamed from: anet.channel.TaobaoNetworkAdapter$1$a */
                /* loaded from: classes.dex */
                class a implements CachePrediction {
                    a(AnonymousClass1 anonymousClass1) {
                    }

                    @Override // anetwork.channel.cache.CachePrediction
                    public boolean handleCache(String str, Map<String, String> map) {
                        return "weex".equals(map.get(HttpHeaderConstant.F_REFER));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h0 h0Var = new h0();
                        h0Var.b();
                        ze.a(h0Var, new a(this), 1);
                    } catch (Exception unused) {
                    }
                }
            }, ThreadPoolExecutorFactory.b.b);
            if (hashMap != null) {
                try {
                    if ("com.taobao.taobao".equals(hashMap.get("process")) && ((Boolean) hashMap.get(com.taobao.android.launcher.common.Constants.PARAMETER_IS_DEBUGGABLE)).booleanValue()) {
                        anet.channel.util.c.i("com.taobao.android.request.analysis.RequestRecorder", UCCore.LEGACY_EVENT_INIT, new Class[]{Context.class}, context);
                    }
                } catch (Exception e) {
                    ALog.d(TAG, "RequestRecorder error.", null, e, new Object[0]);
                }
            }
            if (hashMap != null) {
                try {
                    if (!hashMap.containsKey(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NEXT_LAUNCH) || defaultSharedPreferences.getBoolean(t9.NEXT_LAUNCH_FORBID, false)) {
                        z = false;
                    } else {
                        hu0.a(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NEXT_LAUNCH, "true");
                        z = true;
                    }
                    t9.B0(z);
                } catch (Exception unused) {
                }
            }
            t9.g0(defaultSharedPreferences.getBoolean(t9.HTTP3_ENABLE, true));
            t9.f0(defaultSharedPreferences.getString(t9.HTTP3_BLACK_LIST_KEY, null));
            boolean z2 = defaultSharedPreferences.getBoolean(t9.DETECT_CENTER_ENABLE, true);
            t9.b0(z2);
            t9.p0(defaultSharedPreferences.getBoolean(t9.IPV6_DETECT_KEY, true));
            Boolean isABGlobalFeatureOpened = isABGlobalFeatureOpened(context, t9.TICKET_STORE_KEY);
            if (isABGlobalFeatureOpened != null) {
                t9.C0(isABGlobalFeatureOpened.booleanValue());
            }
            if (hashMap != null) {
                try {
                    boolean containsKey = hashMap.containsKey(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NG_LAUNCH);
                    if ("com.taobao.taobao".equals((String) hashMap.get("process"))) {
                        boolean z3 = true;
                        if (defaultSharedPreferences.getBoolean(rj1.SERVICE_OPTIMIZE, true)) {
                            rj1.P(true);
                            ALog.e(TAG, "bindservice optimize enabled.", null, new Object[0]);
                        }
                        Boolean isABGlobalFeatureOpened2 = isABGlobalFeatureOpened(context, "network_multi_path");
                        if (isABGlobalFeatureOpened2 != null) {
                            rj1.Z(isABGlobalFeatureOpened2.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened3 = isABGlobalFeatureOpened(context, "network_session_async");
                        if (isABGlobalFeatureOpened3 != null) {
                            rj1.U(isABGlobalFeatureOpened3.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened4 = isABGlobalFeatureOpened(context, "network_mtu_optimize");
                        if (isABGlobalFeatureOpened4 != null) {
                            t9.v0(isABGlobalFeatureOpened4.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened5 = isABGlobalFeatureOpened(context, "network_0rtt_optimize");
                        if (isABGlobalFeatureOpened5 != null) {
                            t9.S(isABGlobalFeatureOpened5.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened6 = isABGlobalFeatureOpened(context, "network_check_session_available");
                        if (isABGlobalFeatureOpened6 != null) {
                            t9.W(isABGlobalFeatureOpened6.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened7 = isABGlobalFeatureOpened(context, "network_http_detect");
                        if (isABGlobalFeatureOpened7 != null) {
                            t9.h0(isABGlobalFeatureOpened7.booleanValue());
                        }
                        String str3 = (String) hashMap.get("onlineAppKey");
                        ConnProtocol valueOf = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_ACS);
                        if (z2) {
                            z3 = false;
                        }
                        registerPresetSession(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN, str3, valueOf, z3, containsKey);
                        ConnProtocol valueOf2 = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_CDN);
                        registerPresetSession("gw.alicdn.com", str3, valueOf2, false, containsKey);
                        registerPresetSession(str, str3, valueOf2, false, containsKey);
                        registerPresetSession(str2, str3, valueOf2, false, containsKey);
                        if (z2) {
                            c.l(new a.C0009a().c(str3).e(ENV.ONLINE).a());
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static Boolean isABGlobalFeatureOpened(Context context, String str) {
        try {
            boolean isFeatureOpened = ABGlobal.isFeatureOpened(context, str);
            ALog.e(TAG, "[isABGlobalFeatureOpened]", null, "featureName", str, "status", Boolean.valueOf(isFeatureOpened));
            return Boolean.valueOf(isFeatureOpened);
        } catch (Throwable unused) {
            ALog.e(TAG, "ABGlobal get error", null, new Object[0]);
            return null;
        }
    }

    private static void registerPresetSession(String str, String str2, ConnProtocol connProtocol, boolean z, boolean z2) {
        anet.channel.strategy.d.b().c(str, connProtocol);
        if (z) {
            if (!z2) {
                c.l(new a.C0009a().c(str2).e(ENV.ONLINE).a()).C(xa2.a(str, z, false, null, null, null));
                return;
            }
            c.l(new a.C0009a().c(str2).e(ENV.ONLINE).a()).j(o01.g(zh2.e("https", jg1.SCHEME_SLASH, str)), ab2.a, 0L);
        }
    }
}
