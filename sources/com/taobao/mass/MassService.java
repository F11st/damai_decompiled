package com.taobao.mass;

import androidx.annotation.Keep;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class MassService implements IMassService {
    private static final String TAG = "MassService";
    private static volatile MassService instance;
    private HashMap<String, Set<String>> topicMap = new HashMap<>();

    private MassService() {
    }

    @Keep
    public static MassService getInstance() {
        if (instance == null) {
            synchronized (MassClient.class) {
                if (instance == null) {
                    instance = new MassService();
                }
            }
        }
        return instance;
    }

    @Override // com.taobao.mass.IMassService
    public List<String> getTopicsByService(String str) {
        Set<String> set = this.topicMap.get(str);
        return set == null ? Collections.emptyList() : new ArrayList(set);
    }

    @Override // com.taobao.mass.IMassService
    public void registerTopic(String str, String str2) {
        ALog.i(TAG, "registerTopic", "topic", str2);
        Set<String> set = this.topicMap.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.topicMap.put(str, set);
        }
        if (set.contains(str2)) {
            return;
        }
        set.add(str2);
    }

    @Override // com.taobao.mass.IMassService
    public void unregisterTopic(String str, String str2) {
        ALog.i(TAG, "unregisterTopic", "topic", str2);
        Set<String> set = this.topicMap.get(str);
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str2)) {
                    ALog.i(TAG, "unregisterTopic remove success", "topic", str2);
                    it.remove();
                }
            }
        }
    }
}
