package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Config {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ResourceEntity.Resource> mConfigItemList;
    private String mNamespace;

    public Config(String str, List<ResourceEntity.Resource> list) {
        this.mNamespace = str;
        this.mConfigItemList = list;
    }

    public String findKeyFromUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1683830927")) {
            return (String) ipChange.ipc$dispatch("-1683830927", new Object[]{this, str});
        }
        List<ResourceEntity.Resource> list = this.mConfigItemList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (ResourceEntity.Resource resource : this.mConfigItemList) {
            if (resource.uri.toString().equals(str)) {
                return resource.key;
            }
        }
        return null;
    }

    public List<ResourceEntity.Resource> getConfigItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "67957931") ? (List) ipChange.ipc$dispatch("67957931", new Object[]{this}) : this.mConfigItemList;
    }

    public String getNamespace() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "913285121") ? (String) ipChange.ipc$dispatch("913285121", new Object[]{this}) : this.mNamespace;
    }

    public ResourceEntity.Resource getResourceWithKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198228150")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("1198228150", new Object[]{this, str});
        }
        List<ResourceEntity.Resource> list = this.mConfigItemList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (ResourceEntity.Resource resource : this.mConfigItemList) {
            if (resource.key.equals(str)) {
                return resource;
            }
        }
        return null;
    }

    public void setConfigItems(List<ResourceEntity.Resource> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047037721")) {
            ipChange.ipc$dispatch("1047037721", new Object[]{this, list});
        } else {
            this.mConfigItemList = list;
        }
    }

    public void setNamespace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576830101")) {
            ipChange.ipc$dispatch("576830101", new Object[]{this, str});
        } else {
            this.mNamespace = str;
        }
    }
}
