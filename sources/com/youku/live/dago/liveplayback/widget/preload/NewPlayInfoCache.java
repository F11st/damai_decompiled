package com.youku.live.dago.liveplayback.widget.preload;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NewPlayInfoCache {
    private static transient /* synthetic */ IpChange $ipChange;
    private static NewPlayInfoCache sInstance;
    private ConcurrentHashMap<String, NewPlayInfoModel> cache;

    private ConcurrentHashMap<String, NewPlayInfoModel> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568670393")) {
            return (ConcurrentHashMap) ipChange.ipc$dispatch("1568670393", new Object[]{this});
        }
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    this.cache = new ConcurrentHashMap<>();
                }
            }
        }
        return this.cache;
    }

    public static NewPlayInfoCache getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816263387")) {
            return (NewPlayInfoCache) ipChange.ipc$dispatch("1816263387", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (NewPlayInfoCache.class) {
                if (sInstance == null) {
                    sInstance = new NewPlayInfoCache();
                }
            }
        }
        return sInstance;
    }

    public NewPlayInfoModel get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965658111")) {
            return (NewPlayInfoModel) ipChange.ipc$dispatch("965658111", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str) || !getCache().containsKey(str)) {
            return null;
        }
        return getCache().get(str);
    }

    public NewPlayInfoCache put(String str, NewPlayInfoModel newPlayInfoModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765692893")) {
            return (NewPlayInfoCache) ipChange.ipc$dispatch("-1765692893", new Object[]{this, str, newPlayInfoModel});
        }
        if (!TextUtils.isEmpty(str) && newPlayInfoModel != null) {
            getCache().clear();
            getCache().put(str, newPlayInfoModel);
        }
        return this;
    }

    public NewPlayInfoModel remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640289881")) {
            return (NewPlayInfoModel) ipChange.ipc$dispatch("640289881", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str) || !getCache().containsKey(str)) {
            return null;
        }
        return getCache().remove(str);
    }
}
