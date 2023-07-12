package com.youku.arch.beast.messenger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.ut.device.UTDevice;
import com.youku.arch.analysis.net.SmartEvaluator;
import com.youku.arch.beast.BeastZygote;
import com.youku.arch.beast.EventType;
import com.youku.arch.beast.apas.Apas;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.beast.hostschedule.HostScheduler;
import com.youku.arch.beast.messenger.Messenger;
import com.youku.arch.beast.messenger.data.Content;
import com.youku.arch.beast.messenger.data.Data;
import com.youku.phone.keycenter.YkKeyCenterConstant;
import com.youku.usercenter.passport.api.Passport;
import com.youku.util.Logger;
import com.youku.vip.info.VipUserService;
import com.youku.vip.info.entity.VipUserInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MessengerImpl implements Messenger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CMD_FAIL = -1;
    public static final int CMD_SUCCESS = 1;
    private static final String DEBUG_APPKEY = YkKeyCenterConstant.getAppkeyDaily();
    private static final String RELEASE_APPKEY = YkKeyCenterConstant.getAppkeyRelease();
    private Context mContext;
    private Messenger.Message mMessage = new Messenger.Message();

    public MessengerImpl(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private String createExtInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960946080")) {
            return (String) ipChange.ipc$dispatch("960946080", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        if ("1".equals(OrangeConfig.getInstance().getConfig("aps_config", "aps_heartbeat_update_enable", "0")) && !Apas.getInstance().isLocalMode()) {
            Map<String, String> requestExtraInfo = Apas.getInstance().getRequestExtraInfo();
            if (requestExtraInfo != null) {
                hashMap.putAll(requestExtraInfo);
            }
            String currentVersion = Apas.getInstance().getCurrentVersion();
            if (currentVersion == null) {
                currentVersion = "";
            }
            hashMap.put("apsCurrentVersion", currentVersion);
            hashMap.put("apsInitialRequest", Apas.getInstance().hasSentInitialRequest() ? "0" : "1");
        }
        if ("1".equals(ApasServiceManager.getInstance().getConfig("HostSchedule", "main_switch", "0"))) {
            String version = HostScheduler.getInstance().getVersion();
            if (TextUtils.isEmpty(version)) {
                version = "";
            }
            hashMap.put("domainVersion", version);
        }
        return hashMap.isEmpty() ? "" : JSON.toJSONString(hashMap);
    }

    private void gatherBasicInfo(Messenger.Message message) {
        Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532652356")) {
            ipChange.ipc$dispatch("-1532652356", new Object[]{this, message});
        } else if (message == null || (data = message.data) == null) {
        } else {
            Content content = data.content;
            content.appkey = RELEASE_APPKEY;
            content.deviceid = UTDevice.getUtdid(this.mContext);
            message.data.content.client_ts = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            message.data.content.userid = Passport.getUserInfo() == null ? "" : Passport.getUserInfo().mUid;
            Content content2 = message.data.content;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(Passport.isLogin() ? 1 : -1);
            content2.islogin = sb.toString();
            VipUserInfo userInfo = VipUserService.getInstance().getUserInfo();
            Content content3 = message.data.content;
            content3.isvip = "";
            content3.viptype = "";
            content3.userNick = "";
            if (userInfo != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(userInfo.isVip() ? 1 : -1);
                content3.isvip = sb2.toString();
                message.data.content.viptype = VipUserService.getInstance().getUserInfo().memberId != null ? VipUserService.getInstance().getUserInfo().memberId : "";
                message.data.content.userNick = VipUserService.getInstance().getUserInfo().uName != null ? VipUserService.getInstance().getUserInfo().uName : "";
            }
            message.data.content.ccode = YkKeyCenterConstant.getUpsCCodePlay();
            message.data.content.version = getVersionName(this.mContext);
            message.data.content.ext = createExtInfo();
            Content content4 = message.data.content;
            content4.chipset = Build.BOARD;
            content4.deviceType = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            content4.osVer = Build.VERSION.getRELEASE();
            int netType = getNetType(this.mContext);
            Content content5 = message.data.content;
            content5.network = "" + netType;
            if (netType == 1000) {
                message.data.content.accessValue = "Wi-Fi";
            } else if (netType == 4000) {
                message.data.content.accessValue = getMobileNetworkClassByType(this.mContext);
            } else {
                message.data.content.accessValue = NetworkUtil.NETWORK_CLASS_UNKNOWN;
            }
            message.data.content.ip = Apas.getInstance().getClientIp();
            Content content6 = this.mMessage.data.content;
            content6.actionId = "";
            content6.actionShow = "";
            content6.actionNum = "";
            content6.networkQuality = SmartEvaluator.getInstance().getNetQuality().toString();
            Content content7 = this.mMessage.data.content;
            content7.deviceNetScore = "" + SmartEvaluator.getInstance().getDeviceNetQualityScore(this.mContext);
        }
    }

    private void gatherSigInfo(Messenger.Message message) {
        Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579673671")) {
            ipChange.ipc$dispatch("-1579673671", new Object[]{this, message});
        } else if (message == null || (data = message.data) == null) {
        } else {
            if (!data.content.eventInfos.isEmpty()) {
                HashMap<String, String> hashMap = message.data.content.eventInfos.get(0);
                String str = hashMap.get("vid");
                Content content = message.data.content;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                content.actionId = str;
                String str2 = hashMap.get("showid");
                Content content2 = message.data.content;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                content2.actionShow = str2;
                String str3 = hashMap.get("hbid");
                message.data.content.actionNum = TextUtils.isEmpty(str3) ? "" : str3;
            }
            message.data.content.sig = getSign("userid=" + this.mMessage.data.content.userid + "&deviceid=" + this.mMessage.data.content.deviceid + "&actionId=" + this.mMessage.data.content.actionId + "&actionShow=" + this.mMessage.data.content.actionShow + "&viptype=" + this.mMessage.data.content.viptype + "&actionNum=" + this.mMessage.data.content.actionNum, message.data.content.appkey);
        }
    }

    private static String getMobileNetworkClassByType(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642503240")) {
            return (String) ipChange.ipc$dispatch("-642503240", new Object[]{context});
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                int networkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager);
                if (networkType != 20) {
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                        default:
                            return "4G";
                    }
                }
                return "5G";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "4G";
    }

    private static int getNetType(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751181413")) {
            return ((Integer) ipChange.ipc$dispatch("751181413", new Object[]{context})).intValue();
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1000;
            }
            return type == 0 ? 4000 : 9999;
        }
        return 9999;
    }

    private String getSign(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005644052")) {
            return (String) ipChange.ipc$dispatch("-1005644052", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str);
        hashMap.put("ATLAS", "a");
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 7;
        try {
            return SecurityGuardManager.getInstance(this.mContext).getSecureSignatureComp().signRequest(securityGuardParamContext, "");
        } catch (SecException unused) {
            return "";
        }
    }

    public static String getVersionName(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927628514")) {
            return (String) ipChange.ipc$dispatch("1927628514", new Object[]{context});
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.youku.arch.beast.messenger.Messenger
    public Messenger.Message gatherInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089730190")) {
            return (Messenger.Message) ipChange.ipc$dispatch("-1089730190", new Object[]{this});
        }
        this.mMessage.data = new Data();
        gatherBasicInfo(this.mMessage);
        EventInfo pluginInfo = MessageInfoProvider.getInstance().getPluginInfo(BeastZygote.Type.VOD);
        if (pluginInfo != null) {
            Logger.d("beastLib", "gatherInfo:vod");
            this.mMessage.data.content.eventInfos.add(pluginInfo.content);
        }
        EventInfo pluginInfo2 = MessageInfoProvider.getInstance().getPluginInfo(BeastZygote.Type.LIVE);
        if (pluginInfo2 != null) {
            Logger.d("beastLib", "gatherInfo:live");
            this.mMessage.data.content.eventInfos.add(pluginInfo2.content);
        }
        gatherSigInfo(this.mMessage);
        return this.mMessage;
    }

    @Override // com.youku.arch.beast.messenger.Messenger
    public void sendForEvent(EventType eventType) {
        Messenger.Message gatherInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521880046")) {
            ipChange.ipc$dispatch("1521880046", new Object[]{this, eventType});
        } else if (eventType == EventType.NONE || (gatherInfo = gatherInfo()) == null || gatherInfo.data == null) {
        } else {
            Deliver.delive(gatherInfo);
        }
    }
}
