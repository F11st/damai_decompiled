package com.youku.playerservice.axp.playinfo.request.task;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.INetworkTask;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SwitchConfigUtil;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MTopTask implements INetworkTask {
    private static final String STRENGY_NAME = "ups_per_flow_switch";
    private static final String TAG = "MTopTask";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private static final String YK_USER_AGENT = "yk-user-agent";
    private static long flowLimitTime;
    private long apiLockInterval;
    private String detectInfo;
    private Context mContext;
    private UpsProxyInfo mProxyInfo;
    private int[] mTimeOut;
    private String recvData = null;
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;
    private boolean mtopUnit = true;

    public MTopTask(Context context, int[] iArr, UpsProxyInfo upsProxyInfo) {
        this.apiLockInterval = 0L;
        this.mTimeOut = null;
        this.mTimeOut = iArr;
        this.mContext = context;
        this.mProxyInfo = upsProxyInfo;
        try {
            long longValue = Long.valueOf(ConfigFetcher.getInstance().getConfig("youku_player_config", SwitchConfigUtil.API_LOCK_INTERVAL_KEY, "0")).longValue();
            if (longValue > 0) {
                this.apiLockInterval = longValue * 1000;
            }
        } catch (Exception e) {
            if (Logger.DEBUG) {
                String str = TAG;
                Logger.d(str, "get config exception:" + e);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:14|(1:16)(1:138)|17|(1:19)|20|(6:22|(1:24)|25|(1:27)|28|(3:30|(1:(1:33)(1:34))(1:36)|35))|37|38|(1:40)(14:128|(1:130)(2:132|(1:137)(1:136))|131|42|43|44|(1:46)(1:126)|47|48|(2:50|(9:52|53|54|(2:56|(1:58))(2:67|(4:69|(1:71)|72|(1:74)))|59|(1:61)|62|(1:64)|66)(1:77))(6:79|(2:85|(2:89|(6:93|(1:95)(1:123)|96|97|(1:99)(4:101|(2:103|(1:119)(2:107|(2:113|(1:118)(1:117))))|120|(1:122))|100)))|124|97|(0)(0)|100)|78|62|(0)|66)|41|42|43|44|(0)(0)|47|48|(0)(0)|78|62|(0)|66) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0240, code lost:
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x045a A[Catch: Exception -> 0x04b9, TRY_ENTER, TryCatch #2 {Exception -> 0x04b9, blocks: (B:9:0x0041, B:11:0x0050, B:13:0x0057, B:17:0x009e, B:19:0x00a9, B:20:0x00c6, B:22:0x00ca, B:24:0x0107, B:25:0x0109, B:27:0x014f, B:28:0x0152, B:30:0x015d, B:35:0x0172, B:37:0x0179, B:40:0x0184, B:41:0x01ab, B:52:0x020b, B:59:0x0241, B:61:0x028c, B:63:0x0294, B:83:0x030c, B:84:0x0342, B:86:0x0382, B:88:0x038a, B:90:0x0392, B:92:0x03a3, B:94:0x03bb, B:96:0x03cd, B:98:0x03d3, B:100:0x03f3, B:102:0x0416, B:107:0x045a, B:108:0x045d, B:109:0x0460, B:126:0x0485, B:127:0x048d, B:128:0x0491, B:130:0x0495, B:42:0x01af, B:44:0x01b3, B:45:0x01ba, B:46:0x01be, B:48:0x01c6, B:50:0x01ce, B:51:0x01f0), top: B:145:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0460 A[Catch: Exception -> 0x04b9, TryCatch #2 {Exception -> 0x04b9, blocks: (B:9:0x0041, B:11:0x0050, B:13:0x0057, B:17:0x009e, B:19:0x00a9, B:20:0x00c6, B:22:0x00ca, B:24:0x0107, B:25:0x0109, B:27:0x014f, B:28:0x0152, B:30:0x015d, B:35:0x0172, B:37:0x0179, B:40:0x0184, B:41:0x01ab, B:52:0x020b, B:59:0x0241, B:61:0x028c, B:63:0x0294, B:83:0x030c, B:84:0x0342, B:86:0x0382, B:88:0x038a, B:90:0x0392, B:92:0x03a3, B:94:0x03bb, B:96:0x03cd, B:98:0x03d3, B:100:0x03f3, B:102:0x0416, B:107:0x045a, B:108:0x045d, B:109:0x0460, B:126:0x0485, B:127:0x048d, B:128:0x0491, B:130:0x0495, B:42:0x01af, B:44:0x01b3, B:45:0x01ba, B:46:0x01be, B:48:0x01c6, B:50:0x01ce, B:51:0x01f0), top: B:145:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04ad A[Catch: Exception -> 0x0309, TRY_LEAVE, TryCatch #1 {Exception -> 0x0309, blocks: (B:64:0x0296, B:66:0x029c, B:68:0x02a6, B:77:0x02e0, B:79:0x02ed, B:132:0x049d, B:134:0x04ad, B:69:0x02ad, B:71:0x02b3, B:73:0x02c2, B:74:0x02ca, B:76:0x02d4), top: B:143:0x0296 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022a A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:53:0x0224, B:55:0x022a, B:56:0x0239), top: B:141:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0239 A[Catch: Exception -> 0x0240, TRY_LEAVE, TryCatch #0 {Exception -> 0x0240, blocks: (B:53:0x0224, B:55:0x022a, B:56:0x0239), top: B:141:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x028c A[Catch: Exception -> 0x04b9, TryCatch #2 {Exception -> 0x04b9, blocks: (B:9:0x0041, B:11:0x0050, B:13:0x0057, B:17:0x009e, B:19:0x00a9, B:20:0x00c6, B:22:0x00ca, B:24:0x0107, B:25:0x0109, B:27:0x014f, B:28:0x0152, B:30:0x015d, B:35:0x0172, B:37:0x0179, B:40:0x0184, B:41:0x01ab, B:52:0x020b, B:59:0x0241, B:61:0x028c, B:63:0x0294, B:83:0x030c, B:84:0x0342, B:86:0x0382, B:88:0x038a, B:90:0x0392, B:92:0x03a3, B:94:0x03bb, B:96:0x03cd, B:98:0x03d3, B:100:0x03f3, B:102:0x0416, B:107:0x045a, B:108:0x045d, B:109:0x0460, B:126:0x0485, B:127:0x048d, B:128:0x0491, B:130:0x0495, B:42:0x01af, B:44:0x01b3, B:45:0x01ba, B:46:0x01be, B:48:0x01c6, B:50:0x01ce, B:51:0x01f0), top: B:145:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0342 A[Catch: Exception -> 0x04b9, TryCatch #2 {Exception -> 0x04b9, blocks: (B:9:0x0041, B:11:0x0050, B:13:0x0057, B:17:0x009e, B:19:0x00a9, B:20:0x00c6, B:22:0x00ca, B:24:0x0107, B:25:0x0109, B:27:0x014f, B:28:0x0152, B:30:0x015d, B:35:0x0172, B:37:0x0179, B:40:0x0184, B:41:0x01ab, B:52:0x020b, B:59:0x0241, B:61:0x028c, B:63:0x0294, B:83:0x030c, B:84:0x0342, B:86:0x0382, B:88:0x038a, B:90:0x0392, B:92:0x03a3, B:94:0x03bb, B:96:0x03cd, B:98:0x03d3, B:100:0x03f3, B:102:0x0416, B:107:0x045a, B:108:0x045d, B:109:0x0460, B:126:0x0485, B:127:0x048d, B:128:0x0491, B:130:0x0495, B:42:0x01af, B:44:0x01b3, B:45:0x01ba, B:46:0x01be, B:48:0x01c6, B:50:0x01ce, B:51:0x01f0), top: B:145:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean connectAPI(com.youku.upsplayer.data.RequestData r18) {
        /*
            Method dump skipped, instructions count: 1239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.playinfo.request.task.MTopTask.connectAPI(com.youku.upsplayer.data.RequestData):boolean");
    }

    private String convertMapToDataStr(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(jn1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(value));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[converMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(value);
                        sb2.append(" to dataStr error.");
                        Logger.e("mtopsdk.ups ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        if (requestData == null) {
            return null;
        }
        Logger.d(TAG, "getData");
        if (this.mTimeOut == null) {
            this.mTimeOut = new int[]{5000, 15000};
        }
        if (requestData.upsType == 1) {
            requestData.upsType = 3;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mTimeOut;
            if (i >= iArr.length) {
                break;
            }
            int i2 = iArr[i];
            requestData.connect_timeout = i2;
            requestData.read_timeout = i2;
            if (Logger.DEBUG) {
                String str = TAG;
                Logger.d(str, "connectAPI " + i + " timeout=" + requestData.connect_timeout);
            }
            if (!connectAPI(requestData)) {
                break;
            }
            i++;
        }
        TLogUtil.playLog("NewHttpTask getData done");
        return new GetInfoResult(this.recvData, this.header, this.connectStat);
    }
}
