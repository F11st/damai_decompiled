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
public class OkHttpTask implements INetworkTask {
    private static final String STRENGY_NAME = "ups_per_flow_switch";
    private static final String TAG = "OkHttpTask";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private static final String YK_USER_AGENT = "yk-user-agent";
    private static long flowLimitTime;
    private long apiLockInterval;
    private Context mContext;
    private UpsProxyInfo mProxyInfo;
    private int[] mTimeOut;
    private String recvData = null;
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;
    private boolean mtopUnit = true;

    public OkHttpTask(Context context, int[] iArr, UpsProxyInfo upsProxyInfo) {
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean connectAPI(com.youku.upsplayer.data.RequestData r14) {
        /*
            Method dump skipped, instructions count: 889
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.playinfo.request.task.OkHttpTask.connectAPI(com.youku.upsplayer.data.RequestData):boolean");
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
