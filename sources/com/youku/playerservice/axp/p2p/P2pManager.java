package com.youku.playerservice.axp.p2p;

import android.content.Context;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.player.PlayerManager;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.service.acc.AcceleraterManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class P2pManager {
    private static P2pManager instance;
    private AcceleraterManager acceleraterManager;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class Result {
        public String errorCode;
        public String finalUrl;

        public Result() {
        }
    }

    private P2pManager(Context context) {
        if (PlayerManager.getInstance().useSystemPlayer() || FeatureManager.getInstance().hasPCDN()) {
            return;
        }
        AcceleraterManager acceleraterManager = AcceleraterManager.getInstance(context);
        this.acceleraterManager = acceleraterManager;
        acceleraterManager.bindService();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean enable4GP2P(com.youku.playerservice.axp.p2p.PcdnType r4) {
        /*
            r3 = this;
            com.youku.playerservice.axp.p2p.PcdnType r0 = com.youku.playerservice.axp.p2p.PcdnType.VOD
            java.lang.String r1 = "app_initialize"
            java.lang.String r2 = "0"
            if (r4 != r0) goto L13
            com.youku.media.arch.instruments.ConfigFetcher r4 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()
            java.lang.String r0 = "p2p_vod_enable_4G"
        Le:
            java.lang.String r2 = r4.getConfig(r1, r0, r2)
            goto L1e
        L13:
            com.youku.playerservice.axp.p2p.PcdnType r0 = com.youku.playerservice.axp.p2p.PcdnType.LIVE
            if (r4 != r0) goto L1e
            com.youku.media.arch.instruments.ConfigFetcher r4 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()
            java.lang.String r0 = "p2p_live_enable_4G"
            goto Le
        L1e:
            java.lang.String r4 = "1"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L28
            r4 = 1
            return r4
        L28:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.p2p.P2pManager.enable4GP2P(com.youku.playerservice.axp.p2p.PcdnType):boolean");
    }

    public static synchronized P2pManager getInstance(Context context) {
        P2pManager p2pManager;
        synchronized (P2pManager.class) {
            if (instance == null) {
                instance = new P2pManager(context);
            }
            p2pManager = instance;
        }
        return p2pManager;
    }

    private String[] getM3u8Url(PcdnType pcdnType, String str) {
        String[] strArr = {null, str};
        try {
            String[] split = str.split(SocketClient.NETASCII_EOL);
            if (split != null && split.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : split) {
                    if (str2.contains("#EXT-X-STREAM-INF")) {
                        arrayList.add(str2);
                    } else if (str2.contains("http://") || str2.contains("https://")) {
                        arrayList2.add(str2);
                    }
                }
                if (arrayList2.isEmpty()) {
                    strArr[0] = "null";
                    return strArr;
                }
                strArr[0] = "10000";
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String[] url = getUrl(pcdnType, (String) it.next());
                    if (!"10000".equals(url[0])) {
                        strArr[0] = url[0];
                    }
                    arrayList3.add(url[1]);
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("#EXTM3U\n");
                for (int i = 0; i < arrayList.size(); i++) {
                    stringBuffer.append((String) arrayList.get(i));
                    stringBuffer.append(StringUtils.LF);
                    stringBuffer.append((String) arrayList3.get(i));
                    stringBuffer.append(StringUtils.LF);
                }
                stringBuffer.append("#EXT-X-ENDLIST\n");
                strArr[1] = stringBuffer.toString();
            }
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return strArr;
        }
    }

    private String[] getUrl(PcdnType pcdnType, String str) {
        String[] strArr = {"000"};
        String[] strArr2 = {"10000", str};
        AcceleraterManager acceleraterManager = this.acceleraterManager;
        if (acceleraterManager == null) {
            return strArr2;
        }
        String pcdnAddress = acceleraterManager.getPcdnAddress(pcdnType.getValue(), str, strArr);
        if (pcdnAddress == null || pcdnAddress.equals(str)) {
            strArr2[0] = "14" + strArr[0];
        } else {
            strArr2[1] = pcdnAddress + "&iscdn=p2p";
            strArr2[0] = "10000";
        }
        return strArr2;
    }

    public boolean canUseP2PWithNetStatus(Context context, PcdnType pcdnType) {
        boolean isFreeFlow = FreeFlowUtil.isFreeFlow(context, FreeFlowUtil.FREEFLOWCALLER_P2P);
        if (NetworkUtil.isConnectedWifi(context)) {
            return true;
        }
        return !isFreeFlow && enable4GP2P(pcdnType);
    }

    public Result getPcdnUrl(Context context, PcdnType pcdnType, String str) {
        return getPcdnUrl(context, pcdnType, str, null);
    }

    public Result getPcdnUrl(Context context, PcdnType pcdnType, String str, String str2) {
        String str3;
        String str4;
        int canPlayWithPcdn;
        Result result = new Result();
        result.finalUrl = str;
        result.errorCode = "-1";
        if (pcdnType == PcdnType.LIVE && "2".equals(ApsUtil.enableDownloader("live"))) {
            result.errorCode = "10000";
            return result;
        }
        if (pcdnType == PcdnType.VOD) {
            if ("feed".equals(str2)) {
                if ("2".equals(ApsUtil.enableDownloader("feed"))) {
                    result.errorCode = "10000";
                    return result;
                }
            } else if ("2".equals(ApsUtil.enableDownloader(CacheManager.BIZ_TYPE_VOD))) {
                result.errorCode = "10000";
                return result;
            }
        }
        AcceleraterManager acceleraterManager = this.acceleraterManager;
        if (acceleraterManager == null) {
            result.errorCode = "10000";
            return result;
        }
        if (acceleraterManager != null && (canPlayWithPcdn = acceleraterManager.canPlayWithPcdn()) < 0) {
            str4 = "" + (11000 - canPlayWithPcdn);
        } else if (canUseP2PWithNetStatus(context, pcdnType)) {
            if (str.contains("#EXT-X-STREAM-INF")) {
                String[] m3u8Url = getM3u8Url(pcdnType, str);
                result.errorCode = m3u8Url[0];
                str3 = m3u8Url[1];
            } else {
                String[] url = getUrl(pcdnType, str);
                result.errorCode = url[0];
                str3 = url[1];
            }
            result.finalUrl = str3;
            return result;
        } else {
            str4 = ABLogRecorderKeys.EventIdEnterAct;
        }
        result.errorCode = str4;
        return result;
    }
}
