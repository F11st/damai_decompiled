package com.youku.alixplayer.opensdk.ups.request.service;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.YKNetwork;
import com.youku.network.YKResponse;
import com.youku.network.config.YKErrorConstants;
import com.youku.network.config.YKNetworkConfig;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SwitchConfigUtil;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class NewHttpTask implements INetworkTask {
    private static final String STRENGY_NAME = "ups_per_flow_switch";
    private static final String TAG = "NewHttpTask";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private static final String YK_USER_AGENT = "yk-user-agent";
    private static long flowLimitTime;
    private long apiLockInterval;
    private Context mContext;
    private int[] mTimeOut;
    private String recvData = null;
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;

    public NewHttpTask(Context context, int[] iArr) {
        this.apiLockInterval = 0L;
        this.mTimeOut = null;
        this.mTimeOut = iArr;
        this.mContext = context;
        try {
            long longValue = Long.valueOf(ConfigFetcher.getInstance().getConfig("youku_player_config", SwitchConfigUtil.API_LOCK_INTERVAL_KEY, "0")).longValue();
            if (longValue > 0) {
                this.apiLockInterval = longValue * 1000;
            }
        } catch (Exception e) {
            String str = TAG;
            Logger.d(str, "get config exception:" + e);
        }
    }

    private boolean connectAPI(RequestData requestData) {
        boolean z = false;
        if (TextUtils.isEmpty(requestData.url)) {
            return false;
        }
        this.recvData = null;
        ConnectStat connectStat = this.connectStat;
        connectStat.url = requestData.url;
        connectStat.connect_success = false;
        connectStat.mTopUpsRequest = requestData.mTopUpsRequest;
        try {
        } catch (Exception e) {
            e = e;
            z = true;
        }
        if (System.currentTimeMillis() - flowLimitTime < this.apiLockInterval) {
            ConnectStat connectStat2 = this.connectStat;
            connectStat2.response_code = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
            connectStat2.connect_success = false;
            return false;
        }
        Logger.d("-----> connectAPI url :" + requestData.url);
        YKNetwork.Builder builder = new YKNetwork.Builder();
        builder.url(requestData.url);
        builder.connectTimeout(requestData.connect_timeout);
        builder.readTimeout(requestData.read_timeout);
        builder.header(IRequestConst.USER_AGENT, requestData.agent);
        builder.autoRedirect(true);
        builder.method("GET");
        if (!TextUtils.isEmpty(requestData.host)) {
            builder.host(requestData.host);
        }
        if (!TextUtils.isEmpty(requestData.ip)) {
            builder.ip(requestData.ip);
        }
        if (!TextUtils.isEmpty(requestData.cookie)) {
            Logger.d("-----> cookie :" + requestData.cookie);
            builder.header(IRequestConst.COOKIE, requestData.cookie);
        }
        if (requestData.mTopUpsRequest != null) {
            builder.strategyName(STRENGY_NAME);
            builder.apiName(requestData.mTopUpsRequest.API_NAME);
            builder.version(requestData.mTopUpsRequest.VERSION);
            builder.needEcode(requestData.mTopUpsRequest.NEED_ECODE);
            builder.mTopConnectTimeout(requestData.connect_timeout);
            builder.mtopReadTimeout(requestData.read_timeout);
            builder.mtopHeader(YK_USER_AGENT, requestData.agent);
            HashMap hashMap = new HashMap();
            hashMap.put(MTopUpsRequest.STEAL_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.stealParamsMap));
            hashMap.put(MTopUpsRequest.BIZ_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.bizParamsMap));
            hashMap.put(MTopUpsRequest.AD_PARAMS, JSON.toJSONString(requestData.mTopUpsRequest.adParamsMap));
            builder.data(convertMapToDataStr(hashMap));
        }
        if (requestData.upsType == 3) {
            builder.callType(YKNetworkConfig.CallType.MTOP);
        } else {
            builder.callType(YKNetworkConfig.getAccessableCallType(requestData.url));
        }
        String str = TAG;
        Logger.d(str, "data.upsType=" + requestData.upsType);
        YKNetwork build = builder.build();
        long currentTimeMillis = System.currentTimeMillis();
        YKResponse syncCall = build.syncCall();
        this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean isCallSuccess = syncCall.isCallSuccess();
        Logger.d(str, "apiSuccess=" + isCallSuccess);
        this.connectStat.response_code = syncCall.getResponseCode();
        int ykErrorCode = syncCall.getYkErrorCode();
        if (isCallSuccess) {
            ConnectStat connectStat3 = this.connectStat;
            int i = connectStat3.response_code;
            if (i == 200) {
                connectStat3.connect_success = true;
                try {
                    byte[] bytedata = syncCall.getBytedata();
                    if (bytedata != null) {
                        String str2 = new String(bytedata);
                        this.recvData = str2;
                        if (str2.contains(UPS_WEB_ANTI)) {
                            ConnectStat connectStat4 = this.connectStat;
                            connectStat4.response_code = ErrorConstants.ERROR_UPS_WEB_ANTI;
                            connectStat4.connect_success = false;
                        }
                        if (this.recvData.contains(UPS_WEB_FLOW_LIMIT)) {
                            flowLimitTime = System.currentTimeMillis();
                            ConnectStat connectStat5 = this.connectStat;
                            connectStat5.response_code = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                            connectStat5.connect_success = false;
                        }
                    }
                    this.connectStat.read_time = System.currentTimeMillis() - currentTimeMillis2;
                    Logger.d(str, "httpConn read time=" + this.connectStat.read_time);
                    this.connectStat.header = syncCall.getConnHeadFields();
                } catch (Exception e2) {
                    e = e2;
                    this.connectStat.errMsg = e.toString();
                    e.printStackTrace();
                    Logger.e(TAG, e.getMessage());
                    return z;
                }
                return z;
            }
            connectStat3.response_code = YKErrorConstants.converRespondCode(i, ykErrorCode);
            Logger.e(str, "http fail " + this.connectStat.response_code);
        } else {
            ConnectStat connectStat6 = this.connectStat;
            connectStat6.response_code = YKErrorConstants.converRespondCode(connectStat6.response_code, ykErrorCode);
            Logger.e(str, "api call fail " + this.connectStat.response_code);
        }
        z = true;
        this.connectStat.header = syncCall.getConnHeadFields();
        return z;
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
            String str = TAG;
            Logger.d(str, "connectAPI " + i + " timeout=" + requestData.connect_timeout);
            if (!connectAPI(requestData)) {
                break;
            }
            i++;
        }
        return new GetInfoResult(this.recvData, this.header, this.connectStat);
    }
}
