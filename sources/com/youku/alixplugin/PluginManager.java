package com.youku.alixplugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.youku.alixplugin.base.IPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.layer.LMLayerDataSourceException;
import com.youku.kubus.NoProguard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private Context mContext;
    private Map<String, ViewPlaceholder> mFakeViews;
    private ILMLayerManager<ViewGroup> mLayerManager;
    private AlixPlayerContext mPlayerContext;
    private Map<String, PluginConfig> mPluginConfigs;
    private PluginFactory mPluginFactory;
    private Map<String, IPlugin> mPlugins;
    private ViewGroup parentContainer;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean urgent = true;

    public PluginManager(AlixPlayerContext alixPlayerContext, Map<String, PluginConfig> map, ILMLayerManager<ViewGroup> iLMLayerManager, ViewGroup viewGroup) {
        this.mPlayerContext = alixPlayerContext;
        this.mContext = alixPlayerContext.getContext();
        this.mPluginConfigs = map;
        this.mLayerManager = iLMLayerManager;
        PluginFactory pluginFactory = new PluginFactory();
        this.mPluginFactory = pluginFactory;
        pluginFactory.setDefaultCreator(alixPlayerContext.getDefaultCreator());
        this.mPlugins = new HashMap();
        this.mFakeViews = new HashMap();
        this.parentContainer = viewGroup;
    }

    private void setEventSubscribe(IPlugin iPlugin, int i) {
        if ((i & 16) > 0) {
            try {
                this.mPlayerContext.getEventBus().register(iPlugin);
            } catch (Exception unused) {
                return;
            }
        }
        if ((i & 32) > 0) {
            this.mPlayerContext.getEventBus().unregister(iPlugin);
        }
    }

    private void setVisibility(View view, int i) {
        if (view == null) {
            return;
        }
        int i2 = i & 15;
        if (i2 == 2) {
            view.setVisibility(0);
        }
        if (i2 == 8) {
            view.setVisibility(8);
        }
        if (i2 == 4) {
            view.setVisibility(4);
        }
    }

    public void addPlaceHolder(PluginConfig pluginConfig) {
        if (pluginConfig != null) {
            try {
                String layerId = pluginConfig.getLayerId();
                ViewPlaceholder viewPlaceholder = new ViewPlaceholder(this.mContext, 0);
                this.mLayerManager.getLayerById(layerId, this.mContext).getUIContainer().addView(viewPlaceholder);
                this.mFakeViews.put(pluginConfig.getName(), viewPlaceholder);
            } catch (LMLayerDataSourceException e) {
                Log.v(TAG, "addPlugin LMLayerDataSourceException " + e.getLocalizedMessage());
            }
        }
    }

    public void addPlugin(IPlugin iPlugin) {
        if (iPlugin != null) {
            this.mPlugins.put(iPlugin.getName(), iPlugin);
            if (iPlugin.isAttached()) {
                return;
            }
            try {
                addPlugin2Layer(iPlugin);
            } catch (LMLayerDataSourceException e) {
                Log.v(TAG, "addPlugin LMLayerDataSourceException " + e.getLocalizedMessage());
            }
        }
    }

    boolean addPlugin2Layer(IPlugin iPlugin) throws LMLayerDataSourceException {
        ViewGroup uIContainer = this.mLayerManager.getLayerById(iPlugin.getLayerId(), this.mContext).getUIContainer();
        if (iPlugin.getHolderView() != null) {
            View holderView = iPlugin.getHolderView();
            holderView.setContentDescription(iPlugin.getName() + "-View");
            uIContainer.addView(iPlugin.getHolderView());
            if (!iPlugin.isEnable()) {
                iPlugin.getHolderView().setVisibility(8);
            }
            return true;
        }
        ViewPlaceholder viewPlaceholder = this.mFakeViews.get(iPlugin.getName());
        if (viewPlaceholder != null && viewPlaceholder.getParent() != null) {
            uIContainer.addView(viewPlaceholder);
            return true;
        }
        Log.e(TAG, "addPlugin2Layer fail + " + iPlugin.getName());
        return false;
    }

    public void createPluginFromConfig(PluginConfig pluginConfig) {
        if (hasPlugin(pluginConfig.getName())) {
            return;
        }
        SystemClock.elapsedRealtime();
        IPlugin plugin = this.mPluginFactory.getPlugin(this.mPlayerContext, pluginConfig, this.parentContainer);
        if (plugin != null) {
            plugin.onCreate();
            if (pluginConfig.isEnable()) {
                plugin.onStart();
            }
            addPlugin(plugin);
        }
    }

    public void createRealPlugin() {
        if (getPluginConfigs() == null || getPluginConfigs().size() <= 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList(getPluginConfigs().entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, PluginConfig>>() { // from class: com.youku.alixplugin.PluginManager.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, PluginConfig> entry, Map.Entry<String, PluginConfig> entry2) {
                int majorLevel;
                int majorLevel2;
                if (entry.getValue().getMajorLevel() == entry2.getValue().getMajorLevel()) {
                    majorLevel = entry.getValue().getMinorLevel();
                    majorLevel2 = entry2.getValue().getMinorLevel();
                } else {
                    majorLevel = entry.getValue().getMajorLevel();
                    majorLevel2 = entry2.getValue().getMajorLevel();
                }
                return majorLevel - majorLevel2;
            }
        });
        final long currentTimeMillis = System.currentTimeMillis();
        Runnable runnable = new Runnable() { // from class: com.youku.alixplugin.PluginManager.2
            @Override // java.lang.Runnable
            public void run() {
                Log.v(PluginManager.TAG, String.format("cost %5d ms for switch to main thread-------------------", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                for (Map.Entry entry : arrayList) {
                    PluginConfig pluginConfig = (PluginConfig) entry.getValue();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String name = pluginConfig.getName();
                    if (pluginConfig.isLazyLoad()) {
                        PluginManager.this.addPlaceHolder(pluginConfig);
                    } else {
                        PluginManager.this.createPluginFromConfig(pluginConfig);
                    }
                    Log.v(PluginManager.TAG, String.format("cost %5d ms for create plugin [%s]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), name));
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else if (this.urgent) {
            this.mHandler.postAtFrontOfQueue(runnable);
        } else {
            this.mHandler.post(runnable);
        }
    }

    public void disablePlugin(String str, int i) {
        IPlugin iPlugin = this.mPlugins.get(str);
        if (iPlugin != null) {
            iPlugin.setEnable(false);
            iPlugin.onAvailabilityChanged(false, i);
            iPlugin.onStop();
            if (i > 0) {
                setVisibility(iPlugin.getHolderView(), i);
            }
        }
    }

    public void enablePlugin(String str, int i) {
        IPlugin iPlugin = this.mPlugins.get(str);
        if (iPlugin != null) {
            iPlugin.setEnable(true);
            iPlugin.onAvailabilityChanged(true, i);
            iPlugin.onStart();
            if (i > 0) {
                setVisibility(iPlugin.getHolderView(), i);
            }
        }
    }

    public ILMLayerManager<ViewGroup> getLayerManager() {
        return this.mLayerManager;
    }

    public IPlugin getPlugin(String str) {
        return this.mPlugins.get(str);
    }

    public Map<String, PluginConfig> getPluginConfigs() {
        return this.mPluginConfigs;
    }

    public PluginFactory getPluginFactory() {
        return this.mPluginFactory;
    }

    public Map<String, IPlugin> getPlugins() {
        return this.mPlugins;
    }

    public ViewPlaceholder getViewPlaceholder(String str) {
        return this.mFakeViews.get(str);
    }

    public boolean hasPlugin(String str) {
        return this.mPlugins.containsKey(str);
    }

    public void onDestory() {
        Map<String, IPlugin> map = this.mPlugins;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (IPlugin iPlugin : this.mPlugins.values()) {
            iPlugin.onDestroy();
        }
    }

    public void removePlugin(IPlugin iPlugin) {
        this.mPlugins.remove(iPlugin.getName());
    }

    boolean removePlugin2Layer(IPlugin iPlugin) throws LMLayerDataSourceException {
        this.mLayerManager.getLayerById(iPlugin.getLayerId(), this.mContext).getUIContainer().removeView(iPlugin.getHolderView());
        return true;
    }
}
