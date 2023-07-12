package com.youku.alixplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayerservice.R;
import com.youku.alixplugin.base.IPluginCreator;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.layer.LMLayerInfo;
import com.youku.alixplugin.layer.LMViewGroupLayerManager;
import com.youku.kubus.EventBus;
import com.youku.kubus.EventBusBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AlixPlayerContext implements IPlayerContext {
    public static final String LAYER_BEYOND = "layer_beyond";
    public static final String LAYER_UNDER = "layer_under";
    private static final int TAG_LAYER_MANAGER = R.string.view_group_tag;
    private Activity mActivity;
    private Callable<String> mCallable;
    private Context mContext;
    private Map<String, IPluginCreator> mCreators;
    private IPluginCreator mDefaultCreator;
    private EventBus mEventBus;
    private boolean mIsDlnaMode;
    private boolean mIsLandScreen;
    private boolean mIsLandVideo;
    private boolean mLoggable;
    private int mMode;
    private PlayerConfig mPlayerConfig;
    private IPlayerContainer mPlayerContainer;
    private Map<ViewGroup, PluginManager> mPluginManagers = new HashMap();
    private Map<ViewGroup, ILMLayerManager<ViewGroup>> mLayerManagers = new HashMap();
    private List<ActivityLifeCycleListener> mActivityLifeCycleListeners = new CopyOnWriteArrayList();
    private List<OnDataSourceListener> mOnDataSourceListeners = new CopyOnWriteArrayList();
    private List<OnNotifyListener> mOnNotifyListeners = new CopyOnWriteArrayList();
    private Map<String, Object> mDataSource = new HashMap();

    @Deprecated
    public AlixPlayerContext(Context context, boolean z, PlayerConfig playerConfig) {
        this.mLoggable = true;
        this.mContext = context;
        this.mLoggable = z;
        this.mPlayerConfig = playerConfig;
        initEventBus();
    }

    private void initEventBus() {
        this.mEventBus = new EventBusBuilder().loggable(this.mLoggable).logNoSubscriberMessages(this.mLoggable).sendNoSubscriberEvent(this.mLoggable).sendSubscriberExceptionEvent(this.mLoggable).build();
    }

    private void initFramework(Map<String, PluginConfig> map, ViewGroup viewGroup) {
        ILMLayerManager<ViewGroup> initLayers = initLayers(viewGroup);
        this.mLayerManagers.put(viewGroup, initLayers);
        initPluginManager(map, initLayers, viewGroup);
        viewGroup.setTag(R.string.view_group_tag, initLayers);
    }

    private ViewGroup initLMContainerView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private ILMLayerManager<ViewGroup> initLayers(ViewGroup viewGroup) {
        LMViewGroupLayerManager lMViewGroupLayerManager = new LMViewGroupLayerManager(this.mContext, initLayserInfos(), viewGroup);
        try {
            lMViewGroupLayerManager.loadLayersByConfig();
            return lMViewGroupLayerManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<LMLayerInfo> initLayserInfos() {
        ArrayList arrayList = new ArrayList();
        LMLayerInfo lMLayerInfo = new LMLayerInfo();
        lMLayerInfo.setPluginId(LAYER_UNDER);
        lMLayerInfo.setViewClass("com.youku.alixplugin.DefaultViewWrapper");
        lMLayerInfo.setPriority(60);
        HashMap hashMap = new HashMap();
        hashMap.put("enable", "true");
        lMLayerInfo.setParams(hashMap);
        arrayList.add(lMLayerInfo);
        LMLayerInfo lMLayerInfo2 = new LMLayerInfo();
        lMLayerInfo2.setPluginId(LAYER_BEYOND);
        lMLayerInfo2.setViewClass("com.youku.alixplugin.DefaultViewWrapper");
        lMLayerInfo2.setPriority(40);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("enable", "true");
        lMLayerInfo2.setParams(hashMap2);
        arrayList.add(lMLayerInfo2);
        return arrayList;
    }

    private PluginManager initPluginManager(Map<String, PluginConfig> map, ILMLayerManager<ViewGroup> iLMLayerManager, ViewGroup viewGroup) {
        PluginManager pluginManager = new PluginManager(this, map, iLMLayerManager, viewGroup);
        this.mPluginManagers.put(viewGroup, pluginManager);
        installCustomCreator(pluginManager);
        initPlugins(pluginManager);
        return pluginManager;
    }

    private void initPlugins(PluginManager pluginManager) {
        if (pluginManager != null) {
            pluginManager.createRealPlugin();
        }
    }

    private void installCustomCreator(PluginManager pluginManager) {
        Map<String, IPluginCreator> map = this.mCreators;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, IPluginCreator> entry : this.mCreators.entrySet()) {
            pluginManager.getPluginFactory().addPluginCreator(entry.getKey(), entry.getValue());
        }
    }

    private void loadPluginsSync(Map<String, PluginConfig> map, ViewGroup viewGroup) {
        if (viewGroup.getChildCount() <= 0) {
            initFramework(map, viewGroup);
            return;
        }
        throw new IllegalStateException("viewGroup has children, loadPlugins Failed");
    }

    private void removeDataSourceListener(OnDataSourceListener onDataSourceListener) {
        this.mOnDataSourceListeners.remove(onDataSourceListener);
    }

    public void addActivityLifeCycleListener(ActivityLifeCycleListener activityLifeCycleListener) {
        this.mActivityLifeCycleListeners.add(activityLifeCycleListener);
    }

    public void addDataSourceListener(OnDataSourceListener onDataSourceListener) {
        this.mOnDataSourceListeners.add(onDataSourceListener);
    }

    public void addNotifyListener(OnNotifyListener onNotifyListener) {
        this.mOnNotifyListeners.add(onNotifyListener);
    }

    public void destory() {
        for (PluginManager pluginManager : this.mPluginManagers.values()) {
            pluginManager.onDestory();
        }
    }

    public Map<String, IPluginCreator> gePluginCreators() {
        return this.mCreators;
    }

    public Object get(String str) {
        return this.mDataSource.get(str);
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public Callable<String> getCallable() {
        return this.mCallable;
    }

    public Context getContext() {
        return this.mContext;
    }

    public IPluginCreator getDefaultCreator() {
        return this.mDefaultCreator;
    }

    public EventBus getEventBus() {
        return this.mEventBus;
    }

    public int getMode() {
        return this.mMode;
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerConfig;
    }

    public IPlayerContainer getPlayerContainer() {
        return this.mPlayerContainer;
    }

    public ViewGroup getPlayerContainerView(ViewGroup viewGroup) {
        ILMLayerManager<ViewGroup> iLMLayerManager = this.mLayerManagers.get(viewGroup);
        if (iLMLayerManager != null) {
            return iLMLayerManager.getRootUIContainer();
        }
        return null;
    }

    public PluginManager getPluginManager(ViewGroup viewGroup) {
        return this.mPluginManagers.get(viewGroup);
    }

    public boolean isDlnaMode() {
        return this.mIsDlnaMode;
    }

    public boolean isLandScreen() {
        return this.mIsLandScreen;
    }

    public boolean isLandVideo() {
        return this.mIsLandVideo;
    }

    public void loadLazyPlugins(ViewGroup viewGroup) {
        PluginManager pluginManager = getPluginManager(viewGroup);
        for (PluginConfig pluginConfig : pluginManager.getPluginConfigs().values()) {
            if (pluginConfig.isLazyLoad()) {
                pluginConfig.setEnable(true);
                pluginManager.createPluginFromConfig(pluginConfig);
            }
        }
    }

    public void loadPlugins(Map<String, PluginConfig> map, ViewGroup viewGroup) {
        loadPluginsSync(map, viewGroup);
    }

    public void onActivityDestroy() {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onDestroy();
        }
    }

    public void onActivityPause() {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onPause();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onActivityResult(i, i2, intent);
        }
    }

    public void onActivityResume() {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onResume();
        }
    }

    public void onActivityStart() {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onStart();
        }
    }

    public void onActivityStop() {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onStop();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onConfigurationChanged(configuration);
        }
    }

    public void onNotify(Intent intent, Object obj) {
        for (OnNotifyListener onNotifyListener : this.mOnNotifyListeners) {
            onNotifyListener.onNotify(intent, obj);
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        for (ActivityLifeCycleListener activityLifeCycleListener : this.mActivityLifeCycleListeners) {
            activityLifeCycleListener.onPictureInPictureModeChanged(z, configuration);
        }
    }

    public void put(String str, Object obj) {
        Object obj2 = this.mDataSource.get(str);
        this.mDataSource.put(str, obj);
        if (obj != obj2) {
            for (OnDataSourceListener onDataSourceListener : this.mOnDataSourceListeners) {
                onDataSourceListener.onChanged(str, obj2, obj);
            }
        }
    }

    public void registerSubscriber(Object obj) {
        EventBus eventBus = this.mEventBus;
        if (eventBus == null || eventBus.isRegistered(obj)) {
            return;
        }
        this.mEventBus.register(obj);
    }

    public void removeActivityLifeCycleListener(ActivityLifeCycleListener activityLifeCycleListener) {
        this.mActivityLifeCycleListeners.remove(activityLifeCycleListener);
    }

    public void removeNotifyListener(OnNotifyListener onNotifyListener) {
        this.mOnNotifyListeners.remove(onNotifyListener);
    }

    public void setCallable(Callable callable) {
        this.mCallable = callable;
    }

    public void setDefaultCreator(IPluginCreator iPluginCreator) {
        this.mDefaultCreator = iPluginCreator;
    }

    public void setDlnaMode(boolean z) {
        this.mIsDlnaMode = z;
    }

    public void setLandScreen(boolean z) {
        this.mIsLandScreen = z;
    }

    public void setLandVideo(boolean z) {
        this.mIsLandVideo = z;
    }

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setPlayerContainer(IPlayerContainer iPlayerContainer) {
        this.mPlayerContainer = iPlayerContainer;
    }

    public void setPluginCreators(Map<String, IPluginCreator> map) {
        this.mCreators = map;
    }

    public void unregisterSubscriber(Object obj) {
        EventBus eventBus = this.mEventBus;
        if (eventBus == null || !eventBus.isRegistered(obj)) {
            return;
        }
        this.mEventBus.removeAllStickyEvents();
        this.mEventBus.unregister(obj);
    }

    public AlixPlayerContext(Activity activity, boolean z, PlayerConfig playerConfig) {
        this.mLoggable = true;
        this.mContext = activity.getApplicationContext();
        this.mActivity = activity;
        this.mLoggable = z;
        this.mPlayerConfig = playerConfig;
        initEventBus();
    }
}
