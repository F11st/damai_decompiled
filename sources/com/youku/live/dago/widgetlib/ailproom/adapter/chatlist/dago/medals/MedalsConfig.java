package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.theadpool.PriorityRunnable;
import com.youku.live.dago.widgetlib.util.FastJsonTools;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.threadpool.IThreadPool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MedalsConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "MedalsConfig";
    private Map<Long, Medal> mAllMasterMap;
    private List<Medal> mAllMedals;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Holder {
        static final MedalsConfig instance = new MedalsConfig();

        private Holder() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Medal implements Serializable {
        public String bzid;
        public int cl;
        public int height;
        public long medalId;
        public int type;
        public String url;
        public int width;
    }

    public static MedalsConfig getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1506465595") ? (MedalsConfig) ipChange.ipc$dispatch("1506465595", new Object[0]) : Holder.instance;
    }

    public void clearMedals() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "767779243")) {
            ipChange.ipc$dispatch("767779243", new Object[]{this});
            return;
        }
        this.mAllMedals.clear();
        this.mAllMasterMap.clear();
    }

    public int[] getAllMedalSize(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337185753")) {
            return (int[]) ipChange.ipc$dispatch("-337185753", new Object[]{this, Long.valueOf(j)});
        }
        Medal medal = this.mAllMasterMap.get(Long.valueOf(j));
        return medal != null ? new int[]{medal.width, medal.height} : new int[]{0, 0};
    }

    public int getAllMedalType(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395621111")) {
            return ((Integer) ipChange.ipc$dispatch("-1395621111", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        Medal medal = this.mAllMasterMap.get(Long.valueOf(j));
        if (medal != null) {
            return medal.type;
        }
        return 1;
    }

    public String getAllMedalUrl(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065973393")) {
            return (String) ipChange.ipc$dispatch("-1065973393", new Object[]{this, Long.valueOf(j)});
        }
        Medal medal = this.mAllMasterMap.get(Long.valueOf(j));
        if (medal != null) {
            return medal.url + "";
        }
        return "";
    }

    public String getMedalLevel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528781299")) {
            return (String) ipChange.ipc$dispatch("-1528781299", new Object[]{this, Long.valueOf(j)});
        }
        Medal medal = this.mAllMasterMap.get(Long.valueOf(j));
        return medal != null ? medal.bzid : "";
    }

    public void updateAllMedals() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107161792")) {
            ipChange.ipc$dispatch("2107161792", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "updateAllMedals: " + this.mAllMasterMap.size());
        if (this.mAllMasterMap.isEmpty()) {
            ((IThreadPool) Dsl.getService(IThreadPool.class)).excute(new PriorityRunnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.MedalsConfig.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-771965636")) {
                        ipChange2.ipc$dispatch("-771965636", new Object[]{this});
                        return;
                    }
                    String allMedalJsonDataFromSd = LFFilePathUtils.getAllMedalJsonDataFromSd();
                    try {
                        if (TextUtils.isEmpty(allMedalJsonDataFromSd)) {
                            return;
                        }
                        MedalsConfig.getInstance().updateAllMedals(new JSONArray(allMedalJsonDataFromSd));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private MedalsConfig() {
        this.mAllMedals = Collections.synchronizedList(new ArrayList());
        this.mAllMasterMap = new ConcurrentHashMap();
    }

    public synchronized void updateAllMedals(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919069530")) {
            ipChange.ipc$dispatch("1919069530", new Object[]{this, jSONArray});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateAllMedals jsonArray: " + jSONArray);
        if (jSONArray == null) {
            return;
        }
        List deserializeList = FastJsonTools.deserializeList(jSONArray.toString(), Medal.class);
        if (deserializeList != null) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "updateAllMedals medals: " + deserializeList.size());
        }
        this.mAllMedals.clear();
        this.mAllMasterMap.clear();
        this.mAllMedals.addAll(deserializeList);
        for (Medal medal : this.mAllMedals) {
            this.mAllMasterMap.put(Long.valueOf(medal.medalId), medal);
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "updateAllMedals mAllMasterMap: " + this.mAllMasterMap.size());
    }
}
