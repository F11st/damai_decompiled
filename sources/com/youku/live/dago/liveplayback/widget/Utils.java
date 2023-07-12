package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.config.ConfigUtil;
import com.youku.alixplayer.opensdk.config.IConfigCenterFactory;
import com.youku.alixplayer.opensdk.drm.DrmConfig;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.android.liveservice.bean.Quality;
import com.youku.arch.beast.apas.ApasConfigure;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.livesdk.constants.CcodeConstants;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Utils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DATA_COME_IN_PLAYCONTROLLER_UNIQUEKEY = "intent.data.come.in.room.playcontroller.uniquekey";
    public static final String PLAYER_WIDGET_SP = "player_widget_dagoliveplayback";
    private static boolean mHasInitLogger = false;
    private static PlayerConfig sPlayerConfig = null;
    private static String s_DBGUID = "";

    public static String ToMD5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857217631")) {
            return (String) ipChange.ipc$dispatch("1857217631", new Object[]{str});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return toHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean containPlayStream(YoukuVideoInfo youkuVideoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930054281")) {
            return ((Boolean) ipChange.ipc$dispatch("-1930054281", new Object[]{youkuVideoInfo, Integer.valueOf(i)})).booleanValue();
        }
        if (youkuVideoInfo != null && youkuVideoInfo.getLivePlayControl() != null && youkuVideoInfo.getLivePlayControl().qualities != null) {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.quality == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float dp2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "961657268") ? ((Float) ipChange.ipc$dispatch("961657268", new Object[]{context, Float.valueOf(f)})).floatValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String formatNum(java.lang.String r7, java.lang.Boolean r8) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.liveplayback.widget.Utils.$ipChange
            java.lang.String r1 = "452642504"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r7
            r2[r4] = r8
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L1a:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            if (r8 != 0) goto L23
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
        L23:
            java.math.BigDecimal r1 = new java.math.BigDecimal
            java.lang.String r2 = "1000"
            r1.<init>(r2)
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.String r5 = "10000"
            r2.<init>(r5)
            java.math.BigDecimal r5 = new java.math.BigDecimal
            java.lang.String r6 = "100000000"
            r5.<init>(r6)
            java.math.BigDecimal r6 = new java.math.BigDecimal
            r6.<init>(r7)
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L54
            int r8 = r6.compareTo(r1)
            if (r8 == 0) goto L51
            int r8 = r6.compareTo(r1)
            if (r8 != r4) goto L50
            goto L51
        L50:
            return r7
        L51:
            java.lang.String r7 = "999+"
            return r7
        L54:
            int r7 = r6.compareTo(r2)
            r8 = -1
            java.lang.String r1 = ""
            if (r7 != r8) goto L65
            java.lang.String r7 = r6.toString()
            r0.append(r7)
            goto L8f
        L65:
            int r7 = r6.compareTo(r2)
            if (r7 != 0) goto L71
            int r7 = r6.compareTo(r2)
            if (r7 == r4) goto L77
        L71:
            int r7 = r6.compareTo(r5)
            if (r7 != r8) goto L82
        L77:
            java.math.BigDecimal r7 = r6.divide(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String r2 = "万"
            goto L9c
        L82:
            int r7 = r6.compareTo(r5)
            if (r7 == 0) goto L92
            int r7 = r6.compareTo(r5)
            if (r7 != r4) goto L8f
            goto L92
        L8f:
            r7 = r1
            r2 = r7
            goto L9c
        L92:
            java.math.BigDecimal r7 = r6.divide(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r2 = "亿"
        L9c:
            boolean r1 = r1.equals(r7)
            java.lang.String r5 = "0"
            if (r1 != 0) goto Lda
            java.lang.String r1 = "."
            int r1 = r7.indexOf(r1)
            if (r1 != r8) goto Lb8
            r0.append(r7)
            java.lang.String r7 = ".0"
            r0.append(r7)
            r0.append(r2)
            goto Lda
        Lb8:
            int r1 = r1 + r4
            int r8 = r1 + 1
            java.lang.String r1 = r7.substring(r1, r8)
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto Ld0
            java.lang.String r7 = r7.substring(r3, r8)
            r0.append(r7)
            r0.append(r2)
            goto Lda
        Ld0:
            java.lang.String r7 = r7.substring(r3, r8)
            r0.append(r7)
            r0.append(r2)
        Lda:
            int r7 = r0.length()
            if (r7 != 0) goto Le1
            return r5
        Le1:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.Utils.formatNum(java.lang.String, java.lang.Boolean):java.lang.String");
    }

    public static String getAppkey(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1654510594") ? (String) ipChange.ipc$dispatch("-1654510594", new Object[]{context}) : (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) ? "23570660" : "24687976";
    }

    public static String getApsConfig(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-240453310") ? (String) ipChange.ipc$dispatch("-240453310", new Object[]{str, str2, str3}) : ConfigFetcher.getInstance().getConfig(str, str2, str3);
    }

    public static ClientType getClientType(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326233753")) {
            return (ClientType) ipChange.ipc$dispatch("326233753", new Object[]{context});
        }
        String str = context.getApplicationInfo().packageName;
        if (AXPParamsProvider.ClientType.YOUKU.equals(str)) {
            return ClientType.YOUKU;
        }
        if (AXPParamsProvider.ClientType.LAIFENG.equals(str)) {
            return ClientType.LAIFENG;
        }
        if (AXPParamsProvider.ClientType.YOUKU_HWBAIPAI.equals(str)) {
            return ClientType.YOUKU_HWBAIPAI;
        }
        if ("cn.damai".equals(str)) {
            return ClientType.DAMAI;
        }
        return ClientType.OTHER;
    }

    public static PlayerConfig getDefaultPlayerConfig(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605749963")) {
            return (PlayerConfig) ipChange.ipc$dispatch("-1605749963", new Object[]{context});
        }
        if (sPlayerConfig == null) {
            PlayerConfig dynamicProperties = new PlayerConfig().setPlayerViewType(1).setAppKey(getAppkey(context)).setLiveCCode(getLiveCCode(context)).setCCode(getVodCCode(context)).setUseHardwareDecode(false).setDynamicProperties(new Callable<String>() { // from class: com.youku.live.dago.liveplayback.widget.Utils.1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
                    if (r7.equals(com.youku.vpm.constants.TableField.IS_VIP) == false) goto L8;
                 */
                @Override // com.youku.alixplayer.opensdk.utils.Callable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.String call(java.lang.String r7) {
                    /*
                        r6 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.liveplayback.widget.Utils.AnonymousClass1.$ipChange
                        java.lang.String r1 = "366581303"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        r3 = 2
                        r4 = 1
                        r5 = 0
                        if (r2 == 0) goto L1a
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r2[r5] = r6
                        r2[r4] = r7
                        java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
                        java.lang.String r7 = (java.lang.String) r7
                        return r7
                    L1a:
                        r7.hashCode()
                        r0 = -1
                        int r1 = r7.hashCode()
                        switch(r1) {
                            case -1354757532: goto L46;
                            case -892073626: goto L3b;
                            case 100481683: goto L32;
                            case 2064555103: goto L27;
                            default: goto L25;
                        }
                    L25:
                        r3 = -1
                        goto L50
                    L27:
                        java.lang.String r1 = "isLogin"
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L30
                        goto L25
                    L30:
                        r3 = 3
                        goto L50
                    L32:
                        java.lang.String r1 = "isVip"
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L50
                        goto L25
                    L3b:
                        java.lang.String r1 = "stoken"
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L44
                        goto L25
                    L44:
                        r3 = 1
                        goto L50
                    L46:
                        java.lang.String r1 = "cookie"
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L4f
                        goto L25
                    L4f:
                        r3 = 0
                    L50:
                        java.lang.String r7 = "false"
                        java.lang.String r0 = ""
                        switch(r3) {
                            case 0: goto L59;
                            case 1: goto L59;
                            case 2: goto L58;
                            case 3: goto L58;
                            default: goto L57;
                        }
                    L57:
                        r7 = 0
                    L58:
                        return r7
                    L59:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.Utils.AnonymousClass1.call(java.lang.String):java.lang.String");
                }
            });
            sPlayerConfig = dynamicProperties;
            dynamicProperties.setDrmConfig(new DrmConfig(getAppkey(context), ""));
        }
        if (isYoukuOrHuaweiBaipai(context)) {
            ConfigUtil.setConfigCenterFactory(new IConfigCenterFactory() { // from class: com.youku.live.dago.liveplayback.widget.Utils.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.opensdk.config.IConfigCenterFactory
                public IConfigCenter getConfigCenter() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "238836774") ? (IConfigCenter) ipChange2.ipc$dispatch("238836774", new Object[]{this}) : new ApasConfigure();
                }
            });
        }
        return sPlayerConfig;
    }

    public static String getDiffTimeMillis(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823239402")) {
            return (String) ipChange.ipc$dispatch("1823239402", new Object[]{str});
        }
        double d = 0.0d;
        try {
            d = Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(d / 1000.0d);
    }

    public static String getDlnaCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "664667273") ? (String) ipChange.ipc$dispatch("664667273", new Object[]{context}) : (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) ? CcodeConstants.YOUKU_APP_OTT_CCODE : "live01060201";
    }

    public static String getFormatMinuteTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961082296")) {
            return (String) ipChange.ipc$dispatch("-1961082296", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 / 60;
        long j4 = j2 - (60 * j3);
        if (j3 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j3);
        stringBuffer.append(":");
        if (j4 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j4);
        return stringBuffer.toString();
    }

    public static String getFormathourTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119532904")) {
            return (String) ipChange.ipc$dispatch("-119532904", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 / 3600;
        long j4 = (j2 / 60) - (j3 * 60);
        long j5 = (j2 - (3600 * j3)) - (60 * j4);
        if (j3 > 0) {
            if (j3 < 10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(j3);
            stringBuffer.append(":");
        }
        if (j4 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j4);
        stringBuffer.append(":");
        if (j5 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j5);
        return stringBuffer.toString();
    }

    public static String getGUID(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400026157")) {
            return (String) ipChange.ipc$dispatch("-1400026157", new Object[]{context});
        }
        if (!s_DBGUID.equals("")) {
            return s_DBGUID;
        }
        String ToMD5 = ToMD5(String.format("%s&%s&&", getLocalMacAddress(context), getIMEI(context)));
        s_DBGUID = ToMD5;
        return ToMD5;
    }

    public static String getIMEI(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497850892")) {
            return (String) ipChange.ipc$dispatch("-1497850892", new Object[]{context});
        }
        try {
            return ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0 ? "" : TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLiveCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-843370758") ? (String) ipChange.ipc$dispatch("-843370758", new Object[]{context}) : (context == null || (clientType = getClientType(context)) == ClientType.YOUKU) ? CcodeConstants.YOUKU_APP_CCODE : clientType == ClientType.LAIFENG ? "live01010101laifeng" : clientType == ClientType.YOUKU_HWBAIPAI ? "live01060101" : CcodeConstants.YOUKU_APP_CCODE;
    }

    public static Quality getLiveControlQuality(YoukuVideoInfo youkuVideoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750156052")) {
            return (Quality) ipChange.ipc$dispatch("750156052", new Object[]{youkuVideoInfo, Integer.valueOf(i)});
        }
        if (youkuVideoInfo.getLivePlayControl() != null) {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.quality == i) {
                    return quality;
                }
            }
            return null;
        }
        return null;
    }

    public static final String getLocalMacAddress(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "187810734") ? (String) ipChange.ipc$dispatch("187810734", new Object[]{context}) : (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
    }

    public static String getPlaySid(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248487068")) {
            return (String) ipChange.ipc$dispatch("-1248487068", new Object[]{context});
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String guid = getGUID(context);
        return ToMD5(valueOf + ((long) (((Math.random() * 9.0d) + 1.0d) * 100000.0d)) + guid);
    }

    public static String getVodCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1593268567") ? (String) ipChange.ipc$dispatch("1593268567", new Object[]{context}) : (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) ? "01010101" : "0101011E";
    }

    public static void hideTopTips(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756424056")) {
            ipChange.ipc$dispatch("1756424056", new Object[]{alixPlayerContext});
        } else {
            alixPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_TOP_TIP_HIDE));
        }
    }

    public static void initRemoteLogger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912687914")) {
            ipChange.ipc$dispatch("1912687914", new Object[0]);
        } else if (mHasInitLogger) {
        } else {
            mHasInitLogger = true;
            RemoteLogger.setRemoteAdapter(new RemoteLogger.IRemoteAdapter() { // from class: com.youku.live.dago.liveplayback.widget.Utils.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
                public void log(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-70041765")) {
                        ipChange2.ipc$dispatch("-70041765", new Object[]{this, str, str2});
                    } else {
                        ((IRemoteLog) Dsl.getService(IRemoteLog.class)).e(str, str2);
                    }
                }
            });
        }
    }

    public static boolean isYoukuOrHuaweiBaipai(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-62657143") ? ((Boolean) ipChange.ipc$dispatch("-62657143", new Object[]{context})).booleanValue() : getClientType(context) == ClientType.YOUKU || getClientType(context) == ClientType.YOUKU_HWBAIPAI;
    }

    public static float px2sp(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1054983931") ? ((Float) ipChange.ipc$dispatch("1054983931", new Object[]{context, Float.valueOf(f)})).floatValue() : (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static <T> T reinterpretCast(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872350325")) {
            return (T) ipChange.ipc$dispatch("872350325", new Object[]{obj});
        }
        if (obj != 0) {
            return obj;
        }
        return null;
    }

    public static void setPlayerConfig(PlayerConfig playerConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530470506")) {
            ipChange.ipc$dispatch("1530470506", new Object[]{playerConfig});
        } else {
            sPlayerConfig = playerConfig;
        }
    }

    public static void showCustomTopTips(AlixPlayerContext alixPlayerContext, TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265210029")) {
            ipChange.ipc$dispatch("1265210029", new Object[]{alixPlayerContext, topTipInfo});
        } else if (topTipInfo == null) {
        } else {
            Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
            HashMap hashMap = new HashMap();
            hashMap.put("object", topTipInfo);
            event.data = hashMap;
            alixPlayerContext.getEventBus().post(event);
        }
    }

    public static void showTopTips(AlixPlayerContext alixPlayerContext, String str, CharSequence charSequence, int i, int i2, int i3, boolean z, View.OnClickListener onClickListener, TopTipInfo.DismissCallback dismissCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924893633")) {
            ipChange.ipc$dispatch("-924893633", new Object[]{alixPlayerContext, str, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener, dismissCallback});
            return;
        }
        TopTipInfo topTipInfo = new TopTipInfo();
        topTipInfo.tipName = str;
        topTipInfo.style = 5;
        topTipInfo.rightIconRes = i2;
        topTipInfo.time = i3;
        topTipInfo.text = charSequence;
        topTipInfo.tipSeq = i;
        topTipInfo.needFullScreen = z;
        topTipInfo.onClickListener = onClickListener;
        topTipInfo.dismissCallback = dismissCallback;
        Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
        HashMap hashMap = new HashMap();
        hashMap.put("object", topTipInfo);
        event.data = hashMap;
        alixPlayerContext.getEventBus().post(event);
    }

    public static void showVipTopTips(AlixPlayerContext alixPlayerContext, String str, CharSequence charSequence, int i, int i2, int i3, boolean z, View.OnClickListener onClickListener, TopTipInfo.DismissCallback dismissCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325652408")) {
            ipChange.ipc$dispatch("1325652408", new Object[]{alixPlayerContext, str, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener, dismissCallback});
            return;
        }
        TopTipInfo topTipInfo = new TopTipInfo();
        topTipInfo.tipName = str;
        topTipInfo.rightIconRes = i2;
        topTipInfo.time = i3;
        topTipInfo.style = 4;
        topTipInfo.text = charSequence;
        topTipInfo.tipSeq = i;
        topTipInfo.needFullScreen = z;
        topTipInfo.onClickListener = onClickListener;
        topTipInfo.dismissCallback = dismissCallback;
        Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
        HashMap hashMap = new HashMap();
        hashMap.put("object", topTipInfo);
        event.data = hashMap;
        alixPlayerContext.getEventBus().post(event);
    }

    private static String toHexString(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656835088")) {
            return (String) ipChange.ipc$dispatch("1656835088", new Object[]{bArr});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (Integer.valueOf(i2).intValue() < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static String getApsConfig(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1630951162") ? (String) ipChange.ipc$dispatch("1630951162", new Object[]{context, str, str2, str3}) : ConfigFetcher.getInstance().getConfig(str, str2, str3);
    }
}
