package com.youku.upsplayer.util;

import com.youku.upsplayer.IMultiVideoInfoCallBack;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GetMultiInfoThread {
    public static final String TAG = "GetMultiInfoThread";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    private IMultiVideoInfoCallBack callBack;
    private RequestData request;
    private INetworkTask task;

    public GetMultiInfoThread(RequestData requestData, INetworkTask iNetworkTask, IMultiVideoInfoCallBack iMultiVideoInfoCallBack) {
        this.request = requestData;
        this.task = iNetworkTask;
        this.callBack = iMultiVideoInfoCallBack;
    }

    public List<SimpleVideoInfo> processData(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i;
        Logger.d("GetMultiInfoThread", "processData");
        List<SimpleVideoInfo> list = null;
        if (getInfoResult != null && getInfoResult.connectStat != null) {
            Logger.d("GetMultiInfoThread", "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
            if (getInfoResult.connectStat.connect_success) {
                try {
                    list = ParseResult.parseMultiJSon(getInfoResult.data);
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
        UpsTimeTraceBean upsTimeTraceBean;
        UpsTimeTraceBean upsTimeTraceBean2;
        UpsTimeTraceBean upsTimeTraceBean3;
        UpsTimeTraceBean upsTimeTraceBean4;
        Logger.d("GetMultiInfoThread", "run start");
        PlayStageTracker.upsRequest();
        RequestData requestData = this.request;
        if (requestData != null && (upsTimeTraceBean4 = requestData.upsTimeTraceBean) != null) {
            upsTimeTraceBean4.traceTimeStartRequest();
        }
        GetInfoResult data = this.task.getData(this.request);
        RequestData requestData2 = this.request;
        if (requestData2 != null && (upsTimeTraceBean3 = requestData2.upsTimeTraceBean) != null) {
            upsTimeTraceBean3.traceTimeStartParseResult();
        }
        List<SimpleVideoInfo> processData = processData(data);
        RequestData requestData3 = this.request;
        if (requestData3 != null && (upsTimeTraceBean2 = requestData3.upsTimeTraceBean) != null) {
            upsTimeTraceBean2.traceTimeEndParse();
        }
        RequestData requestData4 = this.request;
        if (requestData4 != null && requestData4.upsTimeTraceBean != null) {
            Logger.d("GetMultiInfoThread", this.request.vid + " total ups parse cost:" + this.request.upsTimeTraceBean.timeEndParse + "; compress:" + this.request.compress);
        }
        if (this.callBack != null) {
            Logger.d("GetMultiInfoThread", "call back result");
            RequestData requestData5 = this.request;
            if (requestData5 != null && (upsTimeTraceBean = requestData5.upsTimeTraceBean) != null) {
                ConnectStat connectStat = data.connectStat;
                connectStat.mUpsTimeTraceBean = upsTimeTraceBean;
                connectStat.rawUpsData = data.data;
            }
            this.callBack.onGetVideoInfoResult(processData, data.connectStat);
        }
        Logger.d("GetMultiInfoThread", "run finish");
    }
}
