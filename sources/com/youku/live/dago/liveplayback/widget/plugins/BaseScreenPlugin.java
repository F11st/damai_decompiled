package com.youku.live.dago.liveplayback.widget.plugins;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.BaseView;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseScreenPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private Runnable hideControlRunnable;
    private Activity mActivity;
    private List<WeexWidget> mDatas;
    protected Handler mHandler;
    private List<ViewGroup> mViewGroups;

    public BaseScreenPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.hideControlRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-193792225")) {
                    ipChange.ipc$dispatch("-193792225", new Object[]{this});
                } else {
                    BaseScreenPlugin.this.hide();
                }
            }
        };
        this.mActivity = alixPlayerContext.getActivity();
        this.mDatas = new ArrayList();
        this.mViewGroups = new ArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void notifyControllVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478310828")) {
            ipChange.ipc$dispatch("1478310828", new Object[]{this, Boolean.valueOf(z)});
        } else if ((this instanceof HorizontalFullscreenPlugin) && this.mActivity.getResources().getConfiguration().orientation == 2) {
            Event event = new Event(ApiConstants.EventType.ON_CONTROL_VISIBILITY_CHANGE);
            event.data = Boolean.valueOf(z);
            this.mPlayerContext.getEventBus().post(event);
        } else if ((this instanceof VerticalSmallscreenPlugin) && this.mActivity.getResources().getConfiguration().orientation == 1) {
            Event event2 = new Event(ApiConstants.EventType.ON_CONTROL_VISIBILITY_CHANGE);
            event2.data = Boolean.valueOf(z);
            this.mPlayerContext.getEventBus().post(event2);
        }
    }

    private void removeAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28281403")) {
            ipChange.ipc$dispatch("28281403", new Object[]{this});
            return;
        }
        for (ViewGroup viewGroup : this.mViewGroups) {
            viewGroup.removeAllViews();
        }
    }

    protected abstract void addView(List<WeexWidget> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public void addViewGroup(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001340008")) {
            ipChange.ipc$dispatch("-2001340008", new Object[]{this, viewGroup});
        } else {
            this.mViewGroups.add(viewGroup);
        }
    }

    public void bindData(List<Map<String, Object>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995739324")) {
            ipChange.ipc$dispatch("1995739324", new Object[]{this, list});
            return;
        }
        this.mDatas.clear();
        Collections.sort(list, new Comparator<Map<String, Object>>() { // from class: com.youku.live.dago.liveplayback.widget.plugins.BaseScreenPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.util.Comparator
            public int compare(Map<String, Object> map, Map<String, Object> map2) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-141725383") ? ((Integer) ipChange2.ipc$dispatch("-141725383", new Object[]{this, map, map2})).intValue() : ((Integer) map.get("p")).intValue() - ((Integer) map2.get("p")).intValue();
            }
        });
        for (Map<String, Object> map : list) {
            String str = (String) map.get(Constants.ACTION_PARAMS_AREA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) map.get(Constants.ACTION_PARAMS_LAYOUTPARAMS);
            if ("share".equals((String) map.get("key")) && Constants.AREA_HRT.equals(str)) {
                map.put(Constants.ACTION_PARAMS_AREA, Constants.AREA_HRT2);
            }
            if (Constants.AREA_VRB.equals(str)) {
                layoutParams.leftMargin = UIUtils.dip2px(9, this.mContext);
            } else if (Constants.AREA_VRT.equals(str)) {
                layoutParams.leftMargin = UIUtils.dip2px(9, this.mContext);
            }
            if (Constants.AREA_HRT.equals(str)) {
                layoutParams.leftMargin = UIUtils.dip2px(9, this.mContext);
            } else if (Constants.AREA_HMT.equals(str)) {
                layoutParams.rightMargin = UIUtils.dip2px(6, this.mContext);
            }
            if (Constants.AREA_HRB.equals(str)) {
                layoutParams.leftMargin = UIUtils.dip2px(9, this.mContext);
            } else if (Constants.AREA_HLB.equals(str) || Constants.AREA_HMB.equals(str)) {
                layoutParams.rightMargin = UIUtils.dip2px(6, this.mContext);
            }
            this.mDatas.add(new WeexWidget(map));
        }
        if (!getView().isInflated()) {
            getView().inflate();
        }
        removeAll();
        addView(this.mDatas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canShow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-904145777") ? ((Boolean) ipChange.ipc$dispatch("-904145777", new Object[]{this})).booleanValue() : this.mPlayerContext.getMode() != 1;
    }

    protected abstract BaseView getView();

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243117904")) {
            ipChange.ipc$dispatch("-1243117904", new Object[]{this});
            return;
        }
        getView().hide();
        notifyControllVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideControlDelay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283355094")) {
            ipChange.ipc$dispatch("-1283355094", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacks(this.hideControlRunnable);
        this.mHandler.postDelayed(this.hideControlRunnable, 6000L);
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88446187")) {
            ipChange.ipc$dispatch("-88446187", new Object[]{this});
            return;
        }
        getView().show();
        notifyControllVisibility(true);
        this.mHandler.removeCallbacks(this.hideControlRunnable);
        hideControlDelay();
    }
}
