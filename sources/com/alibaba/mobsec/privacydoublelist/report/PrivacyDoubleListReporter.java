package com.alibaba.mobsec.privacydoublelist.report;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.mobsec.privacydoublelist.d.a;
import com.alibaba.mobsec.privacydoublelist.d.c;
import com.alibaba.mobsec.privacydoublelist.e.b;
import com.alibaba.mobsec.privacydoublelist.e.d;
import com.alibaba.mobsec.privacydoublelist.e.e;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PrivacyDoubleListReporter {
    public static final String UT_KEY = "privacyInfo";
    public static PrivacyDoubleListReporter b;
    public int reportInitDelay = 300;
    public int reportDelay = 300;
    public a a = new c();

    public static synchronized PrivacyDoubleListReporter getInstance() {
        PrivacyDoubleListReporter privacyDoubleListReporter;
        synchronized (PrivacyDoubleListReporter.class) {
            if (b == null) {
                b = new PrivacyDoubleListReporter();
            }
            privacyDoubleListReporter = b;
        }
        return privacyDoubleListReporter;
    }

    public int getReportDelay() {
        return this.reportDelay;
    }

    public int getReportInitDelay() {
        return this.reportInitDelay;
    }

    public a getReporter() {
        return this.a;
    }

    public void report() {
        Map<String, d> map;
        String str;
        String str2;
        Matcher matcher;
        String str3;
        String str4;
        if (PdlEnvUtils.b) {
            if (PdlEnvUtils.a) {
                Log.d("DL-REPORT", "Start report");
            }
            com.alibaba.mobsec.privacydoublelist.e.c a = e.b().a();
            Map<String, d> map2 = a.a;
            ArrayList arrayList = new ArrayList(a.b.values());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            a aVar = this.a;
            if (arrayList.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                map = map2;
                try {
                    jSONObject.put("v", 2);
                    jSONObject.put(ReportManager.k, "1.1.2");
                    JSONArray jSONArray = new JSONArray();
                    for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
                        jSONArray.put(((com.alibaba.mobsec.privacydoublelist.e.a) it.next()).toString());
                    }
                    jSONObject.put("a", jSONArray);
                    jSONObject.put("t", currentTimeMillis);
                } catch (JSONException e) {
                    Log.e("DL-REPORT", "", e);
                }
                if (PdlEnvUtils.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("type=");
                    ((com.alibaba.mobsec.privacydoublelist.e.a) arrayList.get(0)).b();
                    sb.append("a");
                    sb.append("; cached records=");
                    sb.append(jSONObject.toString());
                    Log.d("DL-REPORT", sb.toString());
                }
                str = jSONObject.toString();
            } else {
                map = map2;
                if (PdlEnvUtils.a) {
                    Log.d("DL-REPORT", "track record is empty");
                }
                str = null;
            }
            ((c) aVar).a(str);
            a aVar2 = this.a;
            if (map.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("v", 2);
                    jSONObject2.put(ReportManager.k, "1.1.2");
                    JSONObject jSONObject3 = new JSONObject();
                    for (String str5 : map.keySet()) {
                        if (str5.contains(jn1.BRACKET_START_STR)) {
                            matcher = b.f.matcher(str5);
                        } else {
                            matcher = b.g.matcher(str5);
                        }
                        if (matcher.find()) {
                            str4 = matcher.group(1);
                            str3 = matcher.group(2);
                        } else {
                            str3 = str5;
                            str4 = "";
                        }
                        Map<String, d> map3 = map;
                        d dVar = map3.get(str5);
                        if (dVar != null) {
                            String str6 = str4 + "|" + str3;
                            JSONArray jSONArray2 = new JSONArray();
                            for (d.a aVar3 : dVar.i.values()) {
                                jSONArray2.put(aVar3.toString());
                            }
                            jSONObject3.put(str6, jSONArray2);
                        }
                        map = map3;
                    }
                    jSONObject2.put("d", jSONObject3);
                    jSONObject2.put("t", currentTimeMillis);
                } catch (JSONException e2) {
                    Log.e("DL-REPORT", "", e2);
                }
                if (PdlEnvUtils.a) {
                    Log.d("DL-REPORT", "type=d; cached records=" + jSONObject2.toString());
                }
                str2 = jSONObject2.toString();
            } else {
                if (PdlEnvUtils.a) {
                    Log.d("DL-REPORT", "track record is empty");
                }
                str2 = null;
            }
            ((c) aVar2).a(str2);
        }
    }

    public void setReportDelay(int i) {
        if (this.reportDelay != i) {
            PrivacyDoubleList.getInstance().cancelReportTimer();
            this.reportDelay = i;
            PrivacyDoubleList.getInstance().startReportTimer();
        }
    }

    public void setReportInitDelay(int i) {
        this.reportInitDelay = i;
    }

    public void setReporter(a aVar) {
        this.a = aVar;
    }
}
