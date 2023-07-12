package com.youku.alixplayer.instances.System.model;

import com.youku.alixplayer.IPlaylist;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemPlayList implements IPlaylist<SystemPeriod> {
    private int mBoundCmpIndex;
    private long mNativeId;
    private long mNativePlayerId;
    private List<SystemPeriod> mPeriodList;
    private Map<String, Object> mTags;

    public SystemPlayList() {
        this.mPeriodList = new ArrayList();
        this.mTags = new ConcurrentHashMap();
        this.mNativeId = init();
    }

    private SystemPlayList(long j) {
        this.mPeriodList = new ArrayList();
        this.mTags = new ConcurrentHashMap();
        this.mNativeId = j;
    }

    private void deinit() {
    }

    private long init() {
        return 0L;
    }

    private void updatePlayerIdForPeriod(long j) {
        if (this.mPeriodList.size() > 0) {
            for (SystemPeriod systemPeriod : this.mPeriodList) {
                systemPeriod.updatePlayerId(j);
            }
        }
    }

    public void addNativePeriod(SystemPeriod systemPeriod) {
    }

    @Override // com.youku.alixplayer.IPlaylist
    public void addPeriod(SystemPeriod systemPeriod) {
        systemPeriod.updateIndex(this.mPeriodList.size());
        systemPeriod.updatePlayerId(this.mNativePlayerId);
        this.mPeriodList.add(systemPeriod);
        addNativePeriod(systemPeriod);
    }

    public void changeNativePeriod(SystemPeriod systemPeriod, int i) {
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        for (SystemPeriod systemPeriod : this.mPeriodList) {
            systemPeriod.destruct();
        }
        this.mPeriodList.clear();
        deinit();
    }

    public void finalize() {
        destruct();
    }

    public SystemPeriod[] getNativePeriods() {
        return null;
    }

    @Override // com.youku.alixplayer.IPlaylist
    public List<SystemPeriod> getPeriodList() {
        return this.mPeriodList;
    }

    public Object getTag(String str) {
        return this.mTags.get(str);
    }

    public void insertNativePeriod(SystemPeriod systemPeriod, int i) {
    }

    @Override // com.youku.alixplayer.IPlaylist
    public void replacePeriod(SystemPeriod systemPeriod, int i) {
        if (i < 0 || i >= this.mPeriodList.size()) {
            return;
        }
        systemPeriod.updateIndex(i);
        systemPeriod.updatePlayerId(this.mNativePlayerId);
        this.mPeriodList.set(i, systemPeriod);
        changeNativePeriod(systemPeriod, i);
    }

    public void replacePeriodForSystem(SystemPeriod systemPeriod, int i) {
        if (i < 0 || i >= this.mPeriodList.size()) {
            return;
        }
        systemPeriod.updateIndex(i);
        systemPeriod.updatePlayerId(this.mNativePlayerId);
        this.mPeriodList.set(i, systemPeriod);
    }

    public void setTag(String str, Object obj) {
        this.mTags.put(str, obj);
    }

    public String toString() {
        List<SystemPeriod> list = this.mPeriodList;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            SystemPeriod systemPeriod = list.get(i);
            sb.append("period index=" + i);
            sb.append(" type=" + systemPeriod.getType());
            sb.append(StringUtils.LF);
            sb.append("header:");
            sb.append(systemPeriod.getAllHeaders());
            sb.append(StringUtils.LF);
            List<SystemSource> sourceList = systemPeriod.getSourceList();
            for (int i2 = 0; i2 < sourceList.size(); i2++) {
                sb.append("source index=" + i2);
                sb.append(" ");
                sb.append(sourceList.get(i2));
                sb.append(StringUtils.LF);
            }
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }
}
