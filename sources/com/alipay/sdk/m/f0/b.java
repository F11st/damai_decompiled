package com.alipay.sdk.m.f0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static c a(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.a = dataReportResult.success;
        cVar.b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.c = map.get("apdid");
            cVar.d = map.get("apdidToken");
            cVar.g = map.get("dynamicKey");
            cVar.h = map.get("timeInterval");
            cVar.i = map.get("webrtcUrl");
            cVar.j = "";
            String str = map.get("drmSwitch");
            if (com.alipay.sdk.m.z.a.b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.k = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.b);
        dataReportRequest.bizData.put("apdidToken", dVar.c);
        dataReportRequest.bizData.put("umidToken", dVar.d);
        dataReportRequest.bizData.put("dynamicKey", dVar.e);
        dataReportRequest.deviceData = dVar.f;
        return dataReportRequest;
    }
}
