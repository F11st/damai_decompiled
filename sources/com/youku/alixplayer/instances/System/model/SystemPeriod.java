package com.youku.alixplayer.instances.System.model;

import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.util.Destructable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemPeriod implements IPeriod<SystemSource>, Destructable {
    public static final int FEATURE_MIXED_CODEC = 2;
    private Map<String, String> mHeaders;
    private int mIndexInPlaylist;
    private long mNativeId;
    private long mNativePlayerId;
    private List<SystemSource> mSourceList;
    private int mType;

    public SystemPeriod() {
        this.mSourceList = new ArrayList();
        this.mHeaders = new HashMap();
        this.mNativeId = init();
        setFeatureFlags(1L);
    }

    private SystemPeriod(long j) {
        this.mSourceList = new ArrayList();
        this.mNativeId = j;
    }

    public SystemPeriod(SystemSource... systemSourceArr) {
        this();
        if (systemSourceArr == null || systemSourceArr.length <= 0) {
            return;
        }
        for (SystemSource systemSource : systemSourceArr) {
            addSource(systemSource);
        }
    }

    private void deinit() {
    }

    private String[] getAllKVs() {
        int i = 0;
        String[] strArr = new String[0];
        Map<String, String> map = this.mHeaders;
        if (map != null && !map.isEmpty()) {
            strArr = new String[this.mHeaders.size() * 2];
            for (String str : this.mHeaders.keySet()) {
                strArr[i] = str;
                int i2 = i + 1;
                strArr[i2] = this.mHeaders.get(str);
                i = i2 + 1;
            }
        }
        return strArr;
    }

    private long init() {
        return 0L;
    }

    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void addNativeSource(SystemSource systemSource) {
    }

    public void addSource(SystemSource systemSource) {
        this.mSourceList.add(systemSource);
        addNativeSource(systemSource);
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        Map<String, String> map = this.mHeaders;
        if (map != null) {
            map.clear();
        }
        this.mHeaders = null;
        for (SystemSource systemSource : this.mSourceList) {
            systemSource.destruct();
        }
        this.mSourceList.clear();
        deinit();
    }

    public void finalize() {
        destruct();
    }

    public String getAllHeaders() {
        String[] allKVs = getAllKVs();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : allKVs) {
            i++;
            int i2 = i % 2;
            sb.append(str);
            sb.append(i2 == 0 ? "; " : ":");
        }
        return sb.toString();
    }

    public long getFeatureFlags() {
        return 0L;
    }

    public String getHeader(String str) {
        return this.mHeaders.get(str);
    }

    @Override // com.youku.alixplayer.IPeriod
    public long getIdentity() {
        return 0L;
    }

    @Override // com.youku.alixplayer.IPeriod
    public List<SystemSource> getSourceList() {
        return this.mSourceList;
    }

    @Override // com.youku.alixplayer.IPeriod
    public int getType() {
        return this.mType;
    }

    public void removeHeader(String str) {
        this.mHeaders.remove(str);
    }

    public void removeNativeSource(int i) {
    }

    public void setDrmKey(String str) {
    }

    public void setFeatureFlags(long j) {
    }

    public void setHeader(Map<String, String> map) {
        this.mHeaders.clear();
        this.mHeaders.putAll(map);
    }

    public void setMediaType(int i) {
    }

    public void setMixedCodec(boolean z) {
    }

    public void setStartTime(long j) {
    }

    public void setType(int i) {
        this.mType = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateIndex(int i) {
        this.mIndexInPlaylist = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePlayerId(long j) {
        this.mNativePlayerId = j;
    }
}
