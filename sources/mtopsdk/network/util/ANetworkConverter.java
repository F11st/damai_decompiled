package mtopsdk.network.util;

import android.text.TextUtils;
import anetwork.channel.Header;
import anetwork.channel.Request;
import anetwork.channel.statist.StatisticData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.network.domain.NetworkStats;
import mtopsdk.network.domain.ParcelableRequestBodyImpl;
import mtopsdk.network.impl.ParcelableRequestBodyEntry;
import mtopsdk.network.util.Constants;
import tb.c22;
import tb.sb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ANetworkConverter {
    public static NetworkStats convertNetworkStats(StatisticData statisticData) {
        if (statisticData == null) {
            return null;
        }
        NetworkStats networkStats = new NetworkStats();
        networkStats.resultCode = statisticData.resultCode;
        networkStats.isRequestSuccess = statisticData.isRequestSuccess;
        networkStats.host = statisticData.host;
        networkStats.ip_port = statisticData.ip_port;
        networkStats.connectionType = statisticData.connectionType;
        networkStats.isSSL = statisticData.isSSL;
        networkStats.oneWayTime_ANet = statisticData.oneWayTime_ANet;
        networkStats.processTime = statisticData.processTime;
        networkStats.firstDataTime = statisticData.firstDataTime;
        networkStats.sendWaitTime = statisticData.sendBeforeTime;
        networkStats.recDataTime = statisticData.recDataTime;
        networkStats.sendSize = statisticData.sendSize;
        networkStats.recvSize = statisticData.totalSize;
        networkStats.serverRT = statisticData.serverRT;
        networkStats.dataSpeed = statisticData.dataSpeed;
        networkStats.retryTimes = statisticData.retryTime;
        return networkStats;
    }

    public static Request convertRequest(mtopsdk.network.domain.Request request) {
        c22 c22Var = new c22(request.url);
        c22Var.setSeqNo(request.seqNo);
        c22Var.setRetryTime(request.retryTimes);
        c22Var.setConnectTimeout(request.connectTimeoutMills);
        c22Var.setReadTimeout(request.readTimeoutMills);
        if (!TextUtils.isEmpty(request.bizIdStr)) {
            c22Var.setBizId(request.bizIdStr);
        } else {
            c22Var.setBizId(request.bizId);
        }
        c22Var.setMethod(request.method);
        c22Var.setHeaders(createRequestHeaders(request.headers));
        c22Var.setExtProperty("APPKEY", request.appKey);
        c22Var.setExtProperty("AuthCode", request.authCode);
        if (!TextUtils.isEmpty(request.fullTraceId)) {
            c22Var.setExtProperty("f-traceId", request.fullTraceId);
        }
        int i = request.env;
        if (i == 0) {
            c22Var.setExtProperty("ENVIRONMENT", "online");
        } else if (i == 1) {
            c22Var.setExtProperty("ENVIRONMENT", "pre");
        } else if (i == 2) {
            c22Var.setExtProperty("ENVIRONMENT", "test");
        }
        if ("POST".equalsIgnoreCase(request.method)) {
            ParcelableRequestBodyImpl parcelableRequestBodyImpl = (ParcelableRequestBodyImpl) request.body;
            c22Var.setBodyEntry(new ParcelableRequestBodyEntry(parcelableRequestBodyImpl));
            c22Var.addHeader("Content-Type", parcelableRequestBodyImpl.contentType());
            long contentLength = parcelableRequestBodyImpl.contentLength();
            if (contentLength > 0) {
                c22Var.addHeader(Constants.Protocol.CONTENT_LENGTH, String.valueOf(contentLength));
            }
        }
        return c22Var;
    }

    public static List<Header> createRequestHeaders(Map<String, String> map) {
        if (map == null || map.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && StringUtils.isNotBlank(entry.getKey())) {
                arrayList.add(new sb(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }
}
