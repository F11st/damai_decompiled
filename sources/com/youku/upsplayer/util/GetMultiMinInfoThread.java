package com.youku.upsplayer.util;

import com.alibaba.fastjson.JSON;
import com.youku.upsplayer.IMultiMinVideoInfoCallBack;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.MinVideoInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.PlayVideoInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GetMultiMinInfoThread {
    public static final String TAG = "GetMultiInfoThread";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private IMultiMinVideoInfoCallBack callBack;
    private RequestData request;
    private INetworkTask task;

    public GetMultiMinInfoThread(RequestData requestData, INetworkTask iNetworkTask, IMultiMinVideoInfoCallBack iMultiMinVideoInfoCallBack) {
        this.request = requestData;
        this.task = iNetworkTask;
        this.callBack = iMultiMinVideoInfoCallBack;
    }

    public List<MinVideoInfo> processData(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i;
        Logger.d("GetMultiInfoThread", "processData");
        List<MinVideoInfo> list = null;
        if (getInfoResult != null && getInfoResult.connectStat != null) {
            Logger.d("GetMultiInfoThread", "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
            if (getInfoResult.connectStat.connect_success) {
                try {
                    PlayVideoInfo.minsetSessionId = JSON.parseObject(getInfoResult.data).getString("sessionId");
                    list = ParseResult.parseMulFirstSliceJSon(getInfoResult.data);
                } catch (Exception e) {
                    Logger.e("GetMultiInfoThread", e.toString());
                    String str = getInfoResult.data;
                    if (str != null) {
                        if (str.contains(UPS_WEB_ANTI)) {
                            connectStat = getInfoResult.connectStat;
                            connectStat.connect_success = false;
                            i = ErrorConstants.ERROR_UPS_WEB_ANTI;
                        } else if (getInfoResult.data.contains(UPS_WEB_FLOW_LIMIT)) {
                            connectStat = getInfoResult.connectStat;
                            connectStat.connect_success = false;
                            i = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                        }
                        connectStat.response_code = i;
                    }
                }
                if (list != null) {
                    Logger.d("GetMultiInfoThread", "video url info " + list.toString());
                }
            }
        }
        return list;
    }

    public void run() {
        Logger.d("GetMultiInfoThread", "run start");
        GetInfoResult data = this.task.getData(this.request);
        Logger.d("GetMultiInfoThread", "result " + data.data);
        List<MinVideoInfo> processData = processData(data);
        if (this.callBack != null) {
            Logger.d("GetMultiInfoThread", "call back result");
            RequestData requestData = this.request;
            if (requestData != null && requestData.upsTimeTraceBean != null) {
                data.connectStat.rawUpsData = data.data;
            }
            this.callBack.onGetVideoInfoResult(processData, data.connectStat);
        }
        Logger.d("GetMultiInfoThread", "run finish");
    }
}
