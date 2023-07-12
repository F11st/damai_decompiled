package com.youku.alixplugin.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.kubus.NoProguard;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public abstract class AbsPlugin implements IPlugin {
    protected boolean mAttachToParent;
    protected Context mContext;
    protected boolean mEnable;
    protected View mHolderView;
    protected ViewGroup mLayerContainer;
    protected String mLayerId;
    protected int mMajorLevel;
    protected int mMinorLevel;
    protected String mName;
    protected AlixPlayerContext mPlayerContext;

    public AbsPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        this.mPlayerContext = alixPlayerContext;
        this.mName = pluginConfig.getName();
        this.mLayerId = pluginConfig.getLayerId();
        this.mEnable = pluginConfig.isEnable();
        this.mMinorLevel = pluginConfig.getMinorLevel();
        this.mMajorLevel = pluginConfig.getMajorLevel();
        this.mContext = alixPlayerContext.getContext();
        this.mLayerContainer = viewGroup;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public View getHolderView() {
        return this.mHolderView;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public String getLayerId() {
        return this.mLayerId;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public int getMajorLevel() {
        return this.mMajorLevel;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public int getMinorLevel() {
        return this.mMinorLevel;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public String getName() {
        return this.mName;
    }

    public AlixPlayerContext getPlayerContext() {
        return this.mPlayerContext;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isActive() {
        return (this.mPlayerContext == null || this.mContext == null) ? false : true;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isAttached() {
        View view;
        return this.mAttachToParent || !((view = this.mHolderView) == null || view.getParent() == null);
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onAvailabilityChanged(boolean z, int i) {
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onCreate() {
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onDestroy() {
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onStart() {
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void onStop() {
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void release() {
        onDestroy();
    }

    @Override // com.youku.alixplugin.base.IPlugin
    public void setEnable(boolean z) {
        this.mEnable = z;
    }
}
