package com.youku.live.dago.widgetlib.ailproom.manager;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChatResourceManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile ChatResourceManager sInstance;
    private Map<String, BaseInfoBean> mYellSourceMap = new HashMap();
    private List<BaseInfoBean> mYellSourceList = new ArrayList();
    private boolean isOrangeDowngradeGif = false;

    public static ChatResourceManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624712165")) {
            return (ChatResourceManager) ipChange.ipc$dispatch("-624712165", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ChatResourceManager.class) {
                if (sInstance == null) {
                    sInstance = new ChatResourceManager();
                }
            }
        }
        return sInstance;
    }

    public void addYellSource(String str, BaseInfoBean baseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739454016")) {
            ipChange.ipc$dispatch("-739454016", new Object[]{this, str, baseInfoBean});
            return;
        }
        this.mYellSourceList.add(baseInfoBean);
        this.mYellSourceMap.put(str, baseInfoBean);
    }

    public void clearYellSource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115362053")) {
            ipChange.ipc$dispatch("-115362053", new Object[]{this});
            return;
        }
        this.mYellSourceMap.clear();
        this.mYellSourceList.clear();
    }

    public BaseInfoBean getYellSource(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1848381155") ? (BaseInfoBean) ipChange.ipc$dispatch("-1848381155", new Object[]{this, str}) : this.mYellSourceMap.get(str);
    }

    public List<BaseInfoBean> getYellSourceList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1995413683") ? (List) ipChange.ipc$dispatch("1995413683", new Object[]{this}) : this.mYellSourceList;
    }

    public Map<String, BaseInfoBean> getYellSourceMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-515928783") ? (Map) ipChange.ipc$dispatch("-515928783", new Object[]{this}) : this.mYellSourceMap;
    }

    public boolean isOrangeDowngradeGif() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-223041480") ? ((Boolean) ipChange.ipc$dispatch("-223041480", new Object[]{this})).booleanValue() : this.isOrangeDowngradeGif;
    }

    public void setOrangeDowngradeGif(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142787932")) {
            ipChange.ipc$dispatch("-2142787932", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isOrangeDowngradeGif = z;
        }
    }

    public void setYellSourceMap(Map<String, BaseInfoBean> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468775293")) {
            ipChange.ipc$dispatch("468775293", new Object[]{this, map});
        } else {
            this.mYellSourceMap.putAll(map);
        }
    }
}
