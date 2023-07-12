package com.youku.arch.v3.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NodeConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String NOT_FOUND = "NOT_FOUND_TOKEN_" + UUID.randomUUID();

    public static String getComponentConfig(IComponent<ComponentValue> iComponent, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094880058")) {
            return (String) ipChange.ipc$dispatch("-1094880058", new Object[]{iComponent, str, str2});
        }
        if (iComponent != null && !TextUtils.isEmpty(str)) {
            JSONObject config = iComponent.getProperty().getConfig();
            if (config != null && config.containsKey(str)) {
                return config.getString(str);
            }
            JSONObject dataConfig = getDataConfig(iComponent.getProperty().getData());
            if (dataConfig != null && dataConfig.containsKey(str)) {
                return dataConfig.getString(str);
            }
        }
        return str2;
    }

    public static String getConfig(IItem<ItemValue> iItem, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621556971")) {
            return (String) ipChange.ipc$dispatch("1621556971", new Object[]{iItem, str, str2});
        }
        String str3 = NOT_FOUND;
        String itemConfig = getItemConfig(iItem, str, str3);
        if (str3.equals(itemConfig) && iItem != null) {
            itemConfig = getComponentConfig(iItem.getComponent(), str, str3);
            if (str3.equals(itemConfig)) {
                iItem.getComponent();
                itemConfig = getModuleConfig(iItem.getComponent().getModule(), str, str3);
                if (str3.equals(itemConfig)) {
                    iItem.getComponent().getModule();
                    itemConfig = getPageConfig(iItem.getComponent().getModule().getContainer(), str, str3);
                }
            }
        }
        return !str3.equals(itemConfig) ? itemConfig : str2;
    }

    private static JSONObject getDataConfig(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096864791")) {
            return (JSONObject) ipChange.ipc$dispatch("-1096864791", new Object[]{jSONObject});
        }
        if (jSONObject != null) {
            return jSONObject.getJSONObject(Constants.CONFIG);
        }
        return null;
    }

    public static String getItemConfig(IItem<ItemValue> iItem, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256634712")) {
            return (String) ipChange.ipc$dispatch("256634712", new Object[]{iItem, str, str2});
        }
        if (iItem != null && !TextUtils.isEmpty(str)) {
            JSONObject config = iItem.getProperty().getConfig();
            if (config != null && config.containsKey(str)) {
                return config.getString(str);
            }
            JSONObject dataConfig = getDataConfig(iItem.getProperty().getData());
            if (dataConfig != null && dataConfig.containsKey(str)) {
                return dataConfig.getString(str);
            }
        }
        return str2;
    }

    public static String getModuleConfig(IModule<ModuleValue> iModule, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798110392")) {
            return (String) ipChange.ipc$dispatch("798110392", new Object[]{iModule, str, str2});
        }
        if (iModule != null && !TextUtils.isEmpty(str)) {
            JSONObject config = iModule.getProperty().getConfig();
            if (config != null && config.containsKey(str)) {
                return config.getString(str);
            }
            JSONObject dataConfig = getDataConfig(iModule.getProperty().getData());
            if (dataConfig != null && dataConfig.containsKey(str)) {
                return dataConfig.getString(str);
            }
        }
        return str2;
    }

    public static String getPageConfig(IContainer<ModelValue> iContainer, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869065440")) {
            return (String) ipChange.ipc$dispatch("869065440", new Object[]{iContainer, str, str2});
        }
        if (iContainer != null && !TextUtils.isEmpty(str)) {
            JSONObject config = iContainer.getProperty().getConfig();
            if (config != null && config.containsKey(str)) {
                return config.getString(str);
            }
            JSONObject dataConfig = getDataConfig(iContainer.getProperty().getData());
            if (dataConfig != null && dataConfig.containsKey(str)) {
                return dataConfig.getString(str);
            }
        }
        return str2;
    }

    public static String getConfig(IItem<ItemValue> iItem, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "415438517") ? (String) ipChange.ipc$dispatch("415438517", new Object[]{iItem, str}) : getConfig(iItem, str, "");
    }

    public static String getConfig(IComponent<ComponentValue> iComponent, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863145517")) {
            return (String) ipChange.ipc$dispatch("863145517", new Object[]{iComponent, str, str2});
        }
        String str3 = NOT_FOUND;
        String componentConfig = getComponentConfig(iComponent, str, str3);
        if (str3.equals(componentConfig) && iComponent != null) {
            componentConfig = getModuleConfig(iComponent.getModule(), str, str3);
            if (str3.equals(componentConfig)) {
                iComponent.getModule();
                componentConfig = getPageConfig(iComponent.getModule().getContainer(), str, str3);
            }
        }
        return !str3.equals(componentConfig) ? componentConfig : str2;
    }

    public static String getConfig(IComponent<ComponentValue> iComponent, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1768510071") ? (String) ipChange.ipc$dispatch("1768510071", new Object[]{iComponent, str}) : getConfig(iComponent, str, "");
    }

    public static String getConfig(IModule<ModuleValue> iModule, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244550076")) {
            return (String) ipChange.ipc$dispatch("-244550076", new Object[]{iModule, str, str2});
        }
        String str3 = NOT_FOUND;
        String moduleConfig = getModuleConfig(iModule, str, str3);
        if (str3.equals(moduleConfig) && iModule != null) {
            moduleConfig = getPageConfig(iModule.getContainer(), str, str3);
        }
        return !str3.equals(moduleConfig) ? moduleConfig : str2;
    }

    public static String getConfig(IModule<ModuleValue> iModule, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1416684110") ? (String) ipChange.ipc$dispatch("1416684110", new Object[]{iModule, str}) : getConfig(iModule, str, "");
    }
}
