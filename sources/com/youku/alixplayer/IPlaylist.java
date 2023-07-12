package com.youku.alixplayer;

import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.util.Destructable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IPlaylist<T extends IPeriod> extends Destructable {
    void addPeriod(T t);

    List<T> getPeriodList();

    void replacePeriod(T t, int i);
}
