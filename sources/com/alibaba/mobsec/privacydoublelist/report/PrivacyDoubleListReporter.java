package com.alibaba.mobsec.privacydoublelist.report;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.mobsec.privacydoublelist.d.C3432c;
import com.alibaba.mobsec.privacydoublelist.d.InterfaceC3430a;
import com.alibaba.mobsec.privacydoublelist.e.AbstractC3434b;
import com.alibaba.mobsec.privacydoublelist.e.C3433a;
import com.alibaba.mobsec.privacydoublelist.e.C3435c;
import com.alibaba.mobsec.privacydoublelist.e.C3436d;
import com.alibaba.mobsec.privacydoublelist.e.C3438e;
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
    public InterfaceC3430a a = new C3432c();

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

    public InterfaceC3430a getReporter() {
        return this.a;
    }

    public void report() {
        Map<String, C3436d> map;
        String str;
        String str2;
        Matcher matcher;
        String str3;
        String str4;
        if (PdlEnvUtils.b) {
            if (PdlEnvUtils.a) {
                Log.d("DL-REPORT", "Start report");
            }
            C3435c a = C3438e.b().a();
            Map<String, C3436d> map2 = a.a;
            ArrayList arrayList = new ArrayList(a.b.values());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            InterfaceC3430a interfaceC3430a = this.a;
            if (arrayList.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                map = map2;
                try {
                    jSONObject.put("v", 2);
                    jSONObject.put(ReportManager.k, "1.1.2");
                    JSONArray jSONArray = new JSONArray();
                    for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
                        jSONArray.put(((C3433a) it.next()).toString());
                    }
                    jSONObject.put("a", jSONArray);
                    jSONObject.put("t", currentTimeMillis);
                } catch (JSONException e) {
                    Log.e("DL-REPORT", "", e);
                }
                if (PdlEnvUtils.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("type=");
                    ((C3433a) arrayList.get(0)).b();
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
            ((C3432c) interfaceC3430a).a(str);
            InterfaceC3430a interfaceC3430a2 = this.a;
            if (map.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("v", 2);
                    jSONObject2.put(ReportManager.k, "1.1.2");
                    JSONObject jSONObject3 = new JSONObject();
                    for (String str5 : map.keySet()) {
                        if (str5.contains(jn1.BRACKET_START_STR)) {
                            matcher = AbstractC3434b.f.matcher(str5);
                        } else {
                            matcher = AbstractC3434b.g.matcher(str5);
                        }
                        if (matcher.find()) {
                            str4 = matcher.group(1);
                            str3 = matcher.group(2);
                        } else {
                            str3 = str5;
                            str4 = "";
                        }
                        Map<String, C3436d> map3 = map;
                        C3436d c3436d = map3.get(str5);
                        if (c3436d != null) {
                            String str6 = str4 + "|" + str3;
                            JSONArray jSONArray2 = new JSONArray();
                            for (C3436d.C3437a c3437a : c3436d.i.values()) {
                                jSONArray2.put(c3437a.toString());
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
            ((C3432c) interfaceC3430a2).a(str2);
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

    public void setReporter(InterfaceC3430a interfaceC3430a) {
        this.a = interfaceC3430a;
    }
}
