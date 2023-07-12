package com.youku.live.messagechannel.utils;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;
import okhttp3.C8737c;
import okhttp3.C8823o;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HttpUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CACHE_SIZE_BYTES = 2097152;
    public static String HTTP_ACCS_H5_TOKEN = "mtop.youku.live.chatroom.h5.accsToken";
    public static String HTTP_GET_CHANNEL_INFO = "mtop.youku.live.chatroom.channel.info.get";
    public static String HTTP_HEARTBEAT = "mtop.youku.live.chatroom.heartbeat";
    public static String HTTP_MASS_SUBSCRIBE = "mtop.youku.live.chatroom.mass.subscribe";
    public static String HTTP_MASS_SUPPLY_SUBSCRIBE = "mtop.youku.live.chatroom.mass.supplySubscribe";
    public static String HTTP_MASS_UNSUBSCRIBE = "mtop.youku.live.chatroom.mass.unSubscribe";
    public static String HTTP_OFFLINE = "mtop.youku.live.chatroom.offline";
    private static Mtop mtopInstance;
    private static OkHttpClient pullCDNMsgClient;

    public static void accsH5Token(Context context, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516469369")) {
            ipChange.ipc$dispatch("516469369", new Object[]{context, mtopFinishListener});
        } else {
            doRequest(HTTP_ACCS_H5_TOKEN, "1.0", new HashMap(8), true, mtopFinishListener);
        }
    }

    private static void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159516117")) {
            ipChange.ipc$dispatch("159516117", new Object[]{mtopRequest, str, str2, Boolean.valueOf(z), map});
            return;
        }
        mtopRequest.setApiName(str);
        mtopRequest.setVersion(str2);
        mtopRequest.setNeedEcode(z);
        mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
    }

    private static Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1378504102") ? (Map) ipChange.ipc$dispatch("-1378504102", new Object[]{str, map}) : new HashMap();
    }

    private static void doRequest(String str, String str2, Map<String, String> map, boolean z, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145303792")) {
            ipChange.ipc$dispatch("-2145303792", new Object[]{str, str2, map, Boolean.valueOf(z), mtopFinishListener});
        } else if (mtopInstance != null) {
            MtopRequest mtopRequest = new MtopRequest();
            buildMtopRequest(mtopRequest, str, str2, false, map);
            mtopInstance.build(mtopRequest, (String) null).reqMethod(z ? MethodEnum.GET : MethodEnum.POST).addListener(mtopFinishListener).asyncRequest();
        }
    }

    public static void getChannelInfo(Context context, String str, String str2, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134988574")) {
            ipChange.ipc$dispatch("-134988574", new Object[]{context, str, str2, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        doRequest(HTTP_GET_CHANNEL_INFO, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void heartbeat(Context context, String str, String str2, String str3, String str4, String str5, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805085307")) {
            ipChange.ipc$dispatch("-805085307", new Object[]{context, str, str2, str3, str4, str5, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        hashMap.put("isFirst", str3);
        hashMap.put("hbToken", str4);
        hashMap.put("onlineTime", str5);
        doRequest(HTTP_HEARTBEAT, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void initMtop(Mtop mtop) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977438043")) {
            ipChange.ipc$dispatch("-1977438043", new Object[]{mtop});
        } else {
            mtopInstance = mtop;
        }
    }

    public static void massSubscribe(Context context, String str, String str2, String str3, String str4, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541041003")) {
            ipChange.ipc$dispatch("-541041003", new Object[]{context, str, str2, str3, str4, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        hashMap.put("topic", str3);
        hashMap.put("requestId", str4);
        doRequest(HTTP_MASS_SUBSCRIBE, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void massSupplySubscribe(Context context, String str, String str2, String str3, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1218133010")) {
            ipChange.ipc$dispatch("-1218133010", new Object[]{context, str, str2, str3, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        hashMap.put("topic", str3);
        doRequest(HTTP_MASS_SUPPLY_SUBSCRIBE, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void massUnsubscribe(Context context, String str, String str2, String str3, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923658760")) {
            ipChange.ipc$dispatch("-1923658760", new Object[]{context, str, str2, str3, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        hashMap.put("topic", str3);
        doRequest(HTTP_MASS_UNSUBSCRIBE, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void offline(Context context, String str, String str2, String str3, String str4, MtopCallback.MtopFinishListener mtopFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885160248")) {
            ipChange.ipc$dispatch("-885160248", new Object[]{context, str, str2, str3, str4, mtopFinishListener});
            return;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, str2);
        hashMap.put("hbToken", str3);
        hashMap.put("onlineTime", str4);
        doRequest(HTTP_OFFLINE, "2.0", hashMap, true, mtopFinishListener);
    }

    public static void pullCDNMsg(Context context, String str, Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028560207")) {
            ipChange.ipc$dispatch("-2028560207", new Object[]{context, str, callback});
            return;
        }
        if (pullCDNMsgClient == null) {
            OkHttpClient.C8734b c = new OkHttpClient().newBuilder().c(new C8737c(new File(context.getCacheDir(), "httpCacheDir"), PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            pullCDNMsgClient = c.d(3000L, timeUnit).k(3000L, timeUnit).b();
        }
        pullCDNMsgClient.newCall(new C8823o.C8824a().k(str).b()).enqueue(callback);
    }
}
