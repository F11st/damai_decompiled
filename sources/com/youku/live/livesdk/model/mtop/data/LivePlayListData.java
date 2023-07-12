package com.youku.live.livesdk.model.mtop.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LivePlayListData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<LivePlayShowData> playList;
    public int type;

    public int currentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943653037")) {
            return ((Integer) ipChange.ipc$dispatch("-1943653037", new Object[]{this})).intValue();
        }
        List<LivePlayShowData> list = this.playList;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.playList.size(); i++) {
                if (this.playList.get(i).isPlay()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public LivePlayShowData currentPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748276474")) {
            return (LivePlayShowData) ipChange.ipc$dispatch("1748276474", new Object[]{this});
        }
        int currentIndex = currentIndex();
        if (currentIndex < 0 || currentIndex >= this.playList.size()) {
            return null;
        }
        return this.playList.get(currentIndex);
    }

    public int lessShowCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563904661")) {
            return ((Integer) ipChange.ipc$dispatch("-563904661", new Object[]{this})).intValue();
        }
        int currentIndex = currentIndex();
        if (currentIndex < 0) {
            return -1;
        }
        return (this.playList.size() - currentIndex) - 1;
    }
}
