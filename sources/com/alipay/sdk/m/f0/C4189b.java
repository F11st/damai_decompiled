package com.alipay.sdk.m.f0;

import com.alipay.sdk.m.z.C4368a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.f0.b */
/* loaded from: classes12.dex */
public class C4189b {
    public static C4190c a(DataReportResult dataReportResult) {
        C4190c c4190c = new C4190c();
        if (dataReportResult == null) {
            return null;
        }
        c4190c.a = dataReportResult.success;
        c4190c.b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            c4190c.c = map.get("apdid");
            c4190c.d = map.get("apdidToken");
            c4190c.g = map.get("dynamicKey");
            c4190c.h = map.get("timeInterval");
            c4190c.i = map.get("webrtcUrl");
            c4190c.j = "";
            String str = map.get("drmSwitch");
            if (C4368a.b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    c4190c.e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    c4190c.f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                c4190c.k = map.get("apse_degrade");
            }
        }
        return c4190c;
    }

    public static DataReportRequest a(C4191d c4191d) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (c4191d == null) {
            return null;
        }
        dataReportRequest.os = c4191d.a;
        dataReportRequest.rpcVersion = c4191d.j;
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", c4191d.b);
        dataReportRequest.bizData.put("apdidToken", c4191d.c);
        dataReportRequest.bizData.put("umidToken", c4191d.d);
        dataReportRequest.bizData.put("dynamicKey", c4191d.e);
        dataReportRequest.deviceData = c4191d.f;
        return dataReportRequest;
    }
}
