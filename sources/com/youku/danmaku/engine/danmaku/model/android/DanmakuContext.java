package com.youku.danmaku.engine.danmaku.model.android;

import android.graphics.Typeface;
import com.youku.danmaku.engine.controller.DanmakuFilters;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.AlphaValue;
import com.youku.danmaku.engine.danmaku.model.GlobalFlagValues;
import com.youku.danmaku.engine.danmaku.model.ThemeModel;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.plugin.DanmakuPluginManager;
import com.youku.danmaku.plugin.IDanmakuDataPlugin;
import com.youku.danmaku.plugin.IDanmakuDrawPlugin;
import com.youku.danmaku.plugin.IDanmakuLayoutPlugin;
import com.youku.danmaku.plugin.IDanmakuMonitorPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import com.youku.danmaku.plugin.IDanmakuTypePlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuContext {
    private BaseCacheStuffer mCacheStuffer;
    private List<WeakReference<ConfigChangedCallback>> mCallbackList;
    private DanmakuPluginManager mDanmakuPluginManager;
    private boolean mIsMaxLinesLimited;
    private boolean mIsPreventOverlappingEnabled;
    public int mOrientation;
    private Typeface mFont = null;
    private int transparency = AlphaValue.MAX;
    public float scaleTextSize = 1.0f;
    public Map<Long, ThemeModel> mThemeModelMap = new HashMap();
    private boolean FTDanmakuVisibility = true;
    private boolean FBDanmakuVisibility = true;
    private boolean L2RDanmakuVisibility = true;
    private boolean R2LDanmakuVisibility = true;
    private boolean SecialDanmakuVisibility = true;
    private CopyOnWriteArrayList<Integer> mFilterTypes = new CopyOnWriteArrayList<>();
    public int maximumNumsInScreen = -1;
    public float scrollSpeedFactor = 1.0f;
    public int refreshRateMS = 15;
    public BorderType shadowType = BorderType.SHADOW;
    public int shadowRadius = 3;
    private List<Integer> mColorValueWhiteList = new ArrayList();
    private List<Integer> mUserIdBlackList = new ArrayList();
    private List<String> mUserHashBlackList = new ArrayList();
    private boolean mBlockGuestDanmaku = false;
    private boolean mDuplicateMergingEnable = false;
    private final AbsDisplayer mDisplayer = new AndroidDisplayer();
    public final GlobalFlagValues mGlobalFlagValues = new GlobalFlagValues();
    public final DanmakuFilters mDanmakuFilters = new DanmakuFilters();
    public final DanmakuFactory mDanmakuFactory = DanmakuFactory.create(this);
    public CachingPolicy cachingPolicy = CachingPolicy.POLICY_DEFAULT;
    private float mPlaySpeed = 1.0f;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ConfigChangedCallback {
        boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        BANNED_WORDS_DANMAKU,
        VERTICAL_SPECIAL_DANMAKU;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    public static DanmakuContext create() {
        return new DanmakuContext();
    }

    private void notifyScrollSpeed(float f) {
        this.mDanmakuFactory.updateDurationFactor(f / this.mPlaySpeed);
        notifyConfigureChanged(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(f));
    }

    private void setDanmakuVisible(boolean z, int i) {
        if (z) {
            this.mFilterTypes.remove(Integer.valueOf(i));
        } else if (this.mFilterTypes.contains(Integer.valueOf(i))) {
        } else {
            this.mFilterTypes.add(Integer.valueOf(i));
        }
    }

    public DanmakuContext addUserHashBlackList(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.mUserHashBlackList, strArr);
            setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        }
        return this;
    }

    public DanmakuContext addUserIdBlackList(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.mUserIdBlackList, numArr);
            setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        }
        return this;
    }

    public DanmakuContext blockGuestDanmaku(boolean z) {
        if (this.mBlockGuestDanmaku != z) {
            this.mBlockGuestDanmaku = z;
            if (z) {
                setFilterData(DanmakuFilters.TAG_GUEST_FILTER, Boolean.valueOf(z));
            } else {
                this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_GUEST_FILTER);
            }
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.BLOCK_GUEST_DANMAKU, Boolean.valueOf(z));
        }
        return this;
    }

    public IDanmakuDataPlugin getDanmakuDataPlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuDataPlugin();
        }
        return null;
    }

    public IDanmakuDrawPlugin getDanmakuDrawPlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuDrawPlugin();
        }
        return null;
    }

    public IDanmakuLayoutPlugin getDanmakuLayoutPlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuLayoutPlugin();
        }
        return null;
    }

    public IDanmakuMonitorPlugin getDanmakuMonitorPlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuMonitorPlugin();
        }
        return null;
    }

    public IDanmakuSettingPlugin getDanmakuSettingPlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuSettingPlugin();
        }
        return null;
    }

    public IDanmakuTypePlugin getDanmakuTypePlugin() {
        DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
        if (danmakuPluginManager != null) {
            return danmakuPluginManager.getDanmakuTypePlugin();
        }
        return null;
    }

    public AbsDisplayer getDisplayer() {
        return this.mDisplayer;
    }

    public boolean getFBDanmakuVisibility() {
        return this.FBDanmakuVisibility;
    }

    public boolean getFTDanmakuVisibility() {
        return this.FTDanmakuVisibility;
    }

    public boolean getL2RDanmakuVisibility() {
        return this.L2RDanmakuVisibility;
    }

    public float getPlaySpeed() {
        return this.mPlaySpeed;
    }

    public boolean getR2LDanmakuVisibility() {
        return this.R2LDanmakuVisibility;
    }

    public boolean getSecialDanmakuVisibility() {
        return this.SecialDanmakuVisibility;
    }

    public ThemeModel getThemebyId(Long l) {
        Map<Long, ThemeModel> map = this.mThemeModelMap;
        if (map == null || !map.containsKey(l)) {
            return null;
        }
        return this.mThemeModelMap.get(l);
    }

    public int getTransparency() {
        return this.transparency;
    }

    public List<String> getUserHashBlackList() {
        return this.mUserHashBlackList;
    }

    public List<Integer> getUserIdBlackList() {
        return this.mUserIdBlackList;
    }

    public boolean isDuplicateMergingEnabled() {
        return this.mDuplicateMergingEnable;
    }

    public boolean isMaxLinesLimited() {
        return this.mIsMaxLinesLimited;
    }

    public boolean isPreventOverlappingEnabled() {
        return this.mIsPreventOverlappingEnabled;
    }

    public void notifyConfigureChanged(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        ConfigChangedCallback configChangedCallback;
        List<WeakReference<ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            for (WeakReference<ConfigChangedCallback> weakReference : list) {
                if (weakReference != null && (configChangedCallback = weakReference.get()) != null) {
                    configChangedCallback.onDanmakuConfigChanged(this, danmakuConfigTag, objArr);
                }
            }
        }
    }

    public DanmakuContext onSizeChange(float f) {
        this.scaleTextSize = f;
        this.mDisplayer.clearTextHeightCache();
        this.mGlobalFlagValues.updateMeasureFlag();
        notifyConfigureChanged(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(f));
        return this;
    }

    public DanmakuContext preventOverlapping(Map<Integer, Boolean> map) {
        this.mIsPreventOverlappingEnabled = map != null;
        if (map == null) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_OVERLAPPING_FILTER, false);
        } else {
            setFilterData(DanmakuFilters.TAG_OVERLAPPING_FILTER, map, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public void pushData(Long l, ThemeModel themeModel) {
        Map<Long, ThemeModel> map = this.mThemeModelMap;
        if (map == null || map.containsKey(l)) {
            return;
        }
        this.mThemeModelMap.put(l, themeModel);
    }

    public void registerConfigChangedCallback(ConfigChangedCallback configChangedCallback) {
        if (configChangedCallback == null || this.mCallbackList == null) {
            this.mCallbackList = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<ConfigChangedCallback> weakReference : this.mCallbackList) {
            if (configChangedCallback.equals(weakReference.get())) {
                return;
            }
        }
        this.mCallbackList.add(new WeakReference<>(configChangedCallback));
    }

    public void release() {
        this.mDanmakuFilters.release();
        this.mDanmakuFactory.resetDurationsData();
        releaseThmemModel();
    }

    public void releaseThmemModel() {
        Map<Long, ThemeModel> map = this.mThemeModelMap;
        if (map != null) {
            map.clear();
        }
    }

    public DanmakuContext removeUserHashBlackList(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                this.mUserHashBlackList.remove(str);
            }
            setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        }
        return this;
    }

    public DanmakuContext removeUserIdBlackList(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            for (Integer num : numArr) {
                this.mUserIdBlackList.remove(num);
            }
            setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        }
        return this;
    }

    public DanmakuContext setCacheStuffer(BaseCacheStuffer baseCacheStuffer, BaseCacheStuffer.Proxy proxy) {
        this.mCacheStuffer = baseCacheStuffer;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.setProxy(proxy);
            this.mDisplayer.setCacheStuffer(this.mCacheStuffer);
        }
        return this;
    }

    public DanmakuContext setCachingPolicy(CachingPolicy cachingPolicy) {
        this.cachingPolicy = cachingPolicy;
        return this;
    }

    public DanmakuContext setColorValueWhiteList(Integer... numArr) {
        this.mColorValueWhiteList.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.mColorValueWhiteList, numArr);
            setFilterData(DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER, this.mColorValueWhiteList);
        } else {
            setFilterData(DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER, null);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.mColorValueWhiteList);
        return this;
    }

    public DanmakuContext setDanmakuBold(boolean z) {
        this.mDisplayer.setFakeBoldText(z);
        notifyConfigureChanged(DanmakuConfigTag.DANMAKU_BOLD, Boolean.valueOf(z));
        return this;
    }

    public void setDanmakuPluginManager(DanmakuPluginManager danmakuPluginManager) {
        this.mDanmakuPluginManager = danmakuPluginManager;
        this.mDisplayer.setDanmakuPlugin(danmakuPluginManager);
    }

    public DanmakuContext setDanmakuStyle(int i, float... fArr) {
        this.mDisplayer.setDanmakuStyle(i, fArr);
        notifyConfigureChanged(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    public DanmakuContext setDanmakuTransparency(float f) {
        int i = (int) (AlphaValue.MAX * f);
        if (i != this.transparency) {
            this.transparency = i;
            this.mDisplayer.setTransparency(i);
            notifyConfigureChanged(DanmakuConfigTag.TRANSPARENCY, Float.valueOf(f));
        }
        return this;
    }

    public DanmakuContext setDuplicateMergingEnabled(boolean z) {
        if (this.mDuplicateMergingEnable != z) {
            this.mDuplicateMergingEnable = z;
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    public DanmakuContext setFBDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 4);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.FBDanmakuVisibility != z) {
            this.FBDanmakuVisibility = z;
            notifyConfigureChanged(DanmakuConfigTag.FB_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    public DanmakuContext setFTDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 5);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.FTDanmakuVisibility != z) {
            this.FTDanmakuVisibility = z;
            notifyConfigureChanged(DanmakuConfigTag.FT_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    public <T> void setFilterData(String str, T t) {
        setFilterData(str, t, true);
    }

    public DanmakuContext setIconTypeface(Typeface typeface) {
        AbsDisplayer absDisplayer;
        if (typeface != null && (absDisplayer = this.mDisplayer) != null) {
            absDisplayer.setIconPaintTypeFace(typeface);
        }
        return this;
    }

    public DanmakuContext setL2RDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 6);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.L2RDanmakuVisibility != z) {
            this.L2RDanmakuVisibility = z;
            notifyConfigureChanged(DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    public DanmakuContext setMaximumLines(Map<Integer, Integer> map) {
        this.mIsMaxLinesLimited = map != null;
        if (map == null) {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, false);
        } else {
            setFilterData(DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, map, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.MAXIMUN_LINES, map);
        return this;
    }

    public DanmakuContext setMaximumVisibleSizeInScreen(int i) {
        this.maximumNumsInScreen = i;
        return this;
    }

    @Deprecated
    public DanmakuContext setOverlapping(Map<Integer, Boolean> map) {
        return preventOverlapping(map);
    }

    public DanmakuContext setR2LDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 1);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.R2LDanmakuVisibility != z) {
            this.R2LDanmakuVisibility = z;
            notifyConfigureChanged(DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, Boolean.valueOf(z));
        }
        return this;
    }

    public DanmakuContext setScaleTextSize(float f) {
        if (this.scaleTextSize != f) {
            this.scaleTextSize = f;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setScaleTextSizeFactor(f);
            this.mGlobalFlagValues.updateMeasureFlag();
            DanmakuPluginManager danmakuPluginManager = this.mDanmakuPluginManager;
            if (danmakuPluginManager != null && danmakuPluginManager.getDanmakuSettingPlugin() != null) {
                IDanmakuSettingPlugin danmakuSettingPlugin = this.mDanmakuPluginManager.getDanmakuSettingPlugin();
                if (!danmakuSettingPlugin.isNewCompose() && !danmakuSettingPlugin.isNewTypesetting()) {
                    this.mGlobalFlagValues.updateVisibleFlag();
                }
            } else {
                this.mGlobalFlagValues.updateVisibleFlag();
            }
            notifyConfigureChanged(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(f));
        }
        return this;
    }

    public DanmakuContext setScrollSpeedFactor(float f) {
        this.scrollSpeedFactor = f;
        notifyScrollSpeed(f);
        return this;
    }

    public void setScrollSpeedFor(float f) {
        if (f == 0.0f) {
            f = 1.0f;
        }
        if (f == this.mPlaySpeed) {
            return;
        }
        this.mPlaySpeed = f;
        notifyScrollSpeed(this.scrollSpeedFactor);
    }

    public DanmakuContext setSpecialDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 7);
        setFilterData(DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.SecialDanmakuVisibility != z) {
            this.SecialDanmakuVisibility = z;
            notifyConfigureChanged(DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    public DanmakuContext setTypeface(Typeface typeface) {
        if (this.mFont != typeface) {
            this.mFont = typeface;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setTypeFace(typeface);
            notifyConfigureChanged(DanmakuConfigTag.TYPEFACE, new Object[0]);
        }
        return this;
    }

    public DanmakuContext setUserHashBlackList(String... strArr) {
        this.mUserHashBlackList.clear();
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.mUserHashBlackList, strArr);
            setFilterData(DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
        } else {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_USER_HASH_FILTER);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        return this;
    }

    public DanmakuContext setUserIdBlackList(Integer... numArr) {
        this.mUserIdBlackList.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.mUserIdBlackList, numArr);
            setFilterData(DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
        } else {
            this.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_USER_ID_FILTER);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        return this;
    }

    public void unregisterAllConfigChangedCallbacks() {
        List<WeakReference<ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            list.clear();
            this.mCallbackList = null;
        }
    }

    public void unregisterConfigChangedCallback(ConfigChangedCallback configChangedCallback) {
        List<WeakReference<ConfigChangedCallback>> list;
        if (configChangedCallback == null || (list = this.mCallbackList) == null) {
            return;
        }
        for (WeakReference<ConfigChangedCallback> weakReference : list) {
            if (configChangedCallback.equals(weakReference.get())) {
                this.mCallbackList.remove(configChangedCallback);
                return;
            }
        }
    }

    private <T> void setFilterData(String str, T t, boolean z) {
        DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter = this.mDanmakuFilters.get(str, z);
        if (iDanmakuFilter != null) {
            iDanmakuFilter.setData(t);
        }
    }
}
