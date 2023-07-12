package com.youku.playerservice.axp.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CacheRecorder {
    private List<String> mTaskKeyList = Collections.synchronizedList(new ArrayList());
    private List<String> mPoolIdList = Collections.synchronizedList(new ArrayList());

    public int addPoolId(String str) {
        if (this.mPoolIdList.contains(str)) {
            return -1;
        }
        this.mPoolIdList.add(str);
        return 1;
    }

    public int addTaskKey(String str) {
        if (this.mTaskKeyList.contains(str)) {
            return -1;
        }
        this.mTaskKeyList.add(str);
        return 1;
    }

    public List<String> getPoolIdList() {
        return this.mPoolIdList;
    }

    public List<String> getTaskKeyList() {
        return this.mTaskKeyList;
    }

    public int removePoolId(String str) {
        if (this.mPoolIdList.contains(str)) {
            this.mPoolIdList.remove(str);
            return 1;
        }
        return -1;
    }

    public int removeTaskKey(String str) {
        if (this.mTaskKeyList.contains(str)) {
            this.mTaskKeyList.remove(str);
            return 1;
        }
        return -1;
    }
}
