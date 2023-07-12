package com.youku.alixplayer.model;

import androidx.annotation.Keep;
import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.NativeMap;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Period implements IPeriod<Source>, Destructable {
    public static final int FEATURE_MIXED_CODEC = 2;
    private NativeMap mHeaders;
    private int mIndexInPlaylist;
    private long mNativeId;
    private long mNativePlayerId;
    private List<Source> mSourceList;
    private int mType;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public Period() {
        this.mSourceList = new ArrayList();
        this.mHeaders = new NativeMap();
        this.mNativeId = init();
        setFeatureFlags(1L);
    }

    private Period(long j) {
        this.mSourceList = new ArrayList();
        this.mNativeId = j;
    }

    public Period(Source... sourceArr) {
        this();
        if (sourceArr == null || sourceArr.length <= 0) {
            return;
        }
        for (Source source : sourceArr) {
            addSource(source);
        }
    }

    private native void deinit();

    private native long init();

    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public native void addNativeSource(Source source);

    public void addSource(Source source) {
        this.mSourceList.add(source);
        addNativeSource(source);
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        NativeMap nativeMap = this.mHeaders;
        if (nativeMap != null) {
            nativeMap.destruct();
        }
        this.mHeaders = null;
        for (Source source : this.mSourceList) {
            source.destruct();
        }
        this.mSourceList.clear();
        deinit();
    }

    public void finalize() {
        destruct();
    }

    public String getAllHeaders() {
        String[] allKVs = this.mHeaders.getAllKVs();
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

    public native long getFeatureFlags();

    public String getHeader(String str) {
        return this.mHeaders.get(str);
    }

    @Override // com.youku.alixplayer.IPeriod
    public native long getIdentity();

    @Override // com.youku.alixplayer.IPeriod
    public List<Source> getSourceList() {
        return this.mSourceList;
    }

    @Override // com.youku.alixplayer.IPeriod
    public int getType() {
        return this.mType;
    }

    public void removeHeader(String str) {
        this.mHeaders.remove(str);
    }

    public native void removeNativeSource(int i);

    public native void setDrmKey(String str);

    public native void setFeatureFlags(long j);

    public void setHeader(NativeMap nativeMap) {
        this.mHeaders.clear();
        this.mHeaders.putAll(nativeMap);
    }

    public native void setMediaType(int i);

    public native void setMixedCodec(boolean z);

    public native void setStartTime(long j);

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
