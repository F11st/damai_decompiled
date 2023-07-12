package com.youku.alixplayer.model;

import androidx.annotation.Keep;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Playlist implements IPlaylist<Period> {
    private int mBoundCmpIndex;
    private long mNativeId;
    private long mNativePlayerId;
    private List<Period> mPeriodList;
    private Map<String, Object> mTags;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public Playlist() {
        this.mPeriodList = new ArrayList();
        this.mTags = new ConcurrentHashMap();
        this.mNativeId = init();
    }

    private Playlist(long j) {
        this.mPeriodList = new ArrayList();
        this.mTags = new ConcurrentHashMap();
        this.mNativeId = j;
    }

    private native void deinit();

    private native long init();

    private void updatePlayerIdForPeriod(long j) {
        if (this.mPeriodList.size() > 0) {
            for (Period period : this.mPeriodList) {
                period.updatePlayerId(j);
            }
        }
    }

    public native void addNativePeriod(Period period);

    @Override // com.youku.alixplayer.IPlaylist
    public void addPeriod(Period period) {
        period.updateIndex(this.mPeriodList.size());
        period.updatePlayerId(this.mNativePlayerId);
        this.mPeriodList.add(period);
        addNativePeriod(period);
    }

    public native void changeNativePeriod(Period period, int i);

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        for (Period period : this.mPeriodList) {
            period.destruct();
        }
        this.mPeriodList.clear();
        deinit();
    }

    public void finalize() {
        destruct();
    }

    public native Period[] getNativePeriods();

    @Override // com.youku.alixplayer.IPlaylist
    public List<Period> getPeriodList() {
        return this.mPeriodList;
    }

    public Object getTag(String str) {
        return this.mTags.get(str);
    }

    public native void insertNativePeriod(Period period, int i);

    @Override // com.youku.alixplayer.IPlaylist
    public void replacePeriod(Period period, int i) {
        if (i < 0 || i >= this.mPeriodList.size()) {
            return;
        }
        period.updateIndex(i);
        period.updatePlayerId(this.mNativePlayerId);
        this.mPeriodList.set(i, period);
        changeNativePeriod(period, i);
    }

    public void setTag(String str, Object obj) {
        this.mTags.put(str, obj);
    }

    public String toString() {
        List<Period> list = this.mPeriodList;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Period period = list.get(i);
            sb.append("period index=" + i);
            sb.append(" type=" + period.getType());
            sb.append(StringUtils.LF);
            sb.append("header:");
            sb.append(period.getAllHeaders());
            sb.append(StringUtils.LF);
            List<Source> sourceList = period.getSourceList();
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
