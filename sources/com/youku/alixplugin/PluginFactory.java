package com.youku.alixplugin;

import android.view.ViewGroup;
import com.youku.alixplugin.base.IPlugin;
import com.youku.alixplugin.base.IPluginCreator;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.live.dago.liveplayback.widget.AlixPluginCreator;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PluginFactory {
    private static final String TAG = "PluginFactory";
    private static HashMap<String, Class> sCacheClass = new HashMap<>(64);
    private static final String sDefaultCreatorClazz = "com.youku.live.dago.liveplayback.widget.AlixPluginCreator";
    private HashMap<String, IPluginCreator> mCreators = new HashMap<>();
    private IPluginCreator mDefaultCreator;

    private IPluginCreator createDefaultCreator() {
        try {
            return (IPluginCreator) AlixPluginCreator.class.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void addPluginCreator(String str, IPluginCreator iPluginCreator) {
        this.mCreators.put(str, iPluginCreator);
    }

    public IPluginCreator getDefaultCreator() {
        return this.mDefaultCreator;
    }

    public IPlugin getPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        IPlugin create;
        String name = pluginConfig.getName();
        HashMap<String, IPluginCreator> hashMap = this.mCreators;
        if (hashMap != null && hashMap.containsKey(name)) {
            create = this.mCreators.get(name).create(alixPlayerContext, pluginConfig, viewGroup);
        } else {
            if (this.mDefaultCreator == null) {
                this.mDefaultCreator = createDefaultCreator();
            }
            IPluginCreator iPluginCreator = this.mDefaultCreator;
            create = iPluginCreator != null ? iPluginCreator.create(alixPlayerContext, pluginConfig, viewGroup) : null;
        }
        if (create != null && !sCacheClass.containsKey(name)) {
            sCacheClass.put(name, create.getClass());
        }
        return create;
    }

    public HashMap<String, IPluginCreator> getPluginCreator() {
        return this.mCreators;
    }

    public void removePluginCreator(String str, IPluginCreator iPluginCreator) {
        this.mCreators.remove(str);
    }

    public void setDefaultCreator(IPluginCreator iPluginCreator) {
        this.mDefaultCreator = iPluginCreator;
    }
}
