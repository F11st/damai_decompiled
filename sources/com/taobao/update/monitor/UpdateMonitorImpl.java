package com.taobao.update.monitor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.framework.UpdateRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.iu2;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateMonitorImpl implements UpdateMonitor {
    private final String PERF_KEY = "update_unique_monit";
    private Map<String, Set<iu2>> updateAlarmDatas = new HashMap();
    private a updateStatMonitor = new a();

    private void clear() {
        UpdateRuntime.getContext().getSharedPreferences("update_point", 0).edit().clear().commit();
    }

    private void commitToDisk() {
        if (this.updateAlarmDatas.containsKey("ddefficiency")) {
            SharedPreferences sharedPreferences = UpdateRuntime.getContext().getSharedPreferences("update_point", 0);
            String string = sharedPreferences.getString("dd_update", "");
            if (TextUtils.isEmpty(string)) {
                sharedPreferences.edit().putString("dd_update", JSON.toJSONString(this.updateAlarmDatas.get("ddefficiency"))).commit();
                return;
            }
            List<iu2> parseArray = JSON.parseArray(string, iu2.class);
            if (parseArray != null && parseArray.size() > 0) {
                for (iu2 iu2Var : parseArray) {
                    if (!this.updateAlarmDatas.get("ddefficiency").contains(iu2Var)) {
                        this.updateAlarmDatas.get("ddefficiency").add(iu2Var);
                    }
                }
            }
            sharedPreferences.edit().putString("dd_update", JSON.toJSONString(this.updateAlarmDatas.get("ddefficiency"))).commit();
        }
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
        iu2 iu2Var = new iu2();
        iu2Var.success = z;
        if (str2 == null) {
            str2 = "";
        }
        iu2Var.arg = str2;
        if (str3 == null) {
            str3 = "0";
        }
        iu2Var.errorCode = str3;
        if (str4 == null) {
            str4 = "";
        }
        iu2Var.errorMsg = str4;
        if (str5 == null) {
            str5 = "";
        }
        iu2Var.toVersion = str5;
        iu2Var.fromVersion = "";
        if (str6 == null) {
            str6 = "";
        }
        iu2Var.url = str6;
        iu2Var.elapsed_time = j2;
        iu2Var.disk_size = pu2.getFreeSizeRange(j);
        add(str, iu2Var);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public synchronized void commit(String str) {
        clear();
        Set<iu2> set = this.updateAlarmDatas.get(str);
        if (set != null && !set.isEmpty()) {
            for (iu2 iu2Var : set) {
                this.updateStatMonitor.b(str, iu2Var);
            }
            this.updateAlarmDatas.remove(str);
        }
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitCount(String str, String str2, String str3, double d) {
        AppMonitor.Counter.commit(str, str2, str3, d);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitFail(String str, String str2, String str3, String str4) {
        AppMonitor.Alarm.commitFail(str, str2, str3, str4);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void commitSuccess(String str, String str2, String str3) {
        AppMonitor.Alarm.commitSuccess(str, str2, str3);
    }

    @Override // com.taobao.update.adapter.UpdateMonitor
    public void add(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        iu2 iu2Var = new iu2();
        iu2Var.success = z;
        if (str2 == null) {
            str2 = "";
        }
        iu2Var.arg = str2;
        if (str3 == null) {
            str3 = "";
        }
        iu2Var.errorCode = str3;
        if (str4 == null) {
            str4 = "";
        }
        iu2Var.errorMsg = str4;
        if (str6 == null) {
            str6 = "";
        }
        iu2Var.toVersion = str6;
        if (str5 == null) {
            str5 = "";
        }
        iu2Var.fromVersion = str5;
        if (str7 == null) {
            str7 = "";
        }
        iu2Var.url = str7;
        add(str, iu2Var);
    }

    private synchronized void add(String str, iu2 iu2Var) {
        if (!this.updateAlarmDatas.containsKey(str)) {
            this.updateAlarmDatas.put(str, new HashSet());
        }
        this.updateAlarmDatas.get(str).add(iu2Var);
        commitToDisk();
    }
}
