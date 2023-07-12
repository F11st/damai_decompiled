package com.youku.live.livesdk.wkit.widget.slide;

import android.content.Context;
import android.view.View;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseSlideWidget extends BaseWidget implements IDataHandler, IActivityConfigurationOrientationChangedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseSlideLayout frameLayout;
    private WXSDKInstance mLiveWeexInstance;
    private boolean supportLeftRightMotion = true;
    private boolean mContentIsShown = true;

    private void fireGlobalEvent(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822245474")) {
            ipChange.ipc$dispatch("1822245474", new Object[]{this, str, map});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mLiveWeexInstance;
        if (wXSDKInstance == null) {
            LiveWeexWidget findLiveWeexWidget = findLiveWeexWidget("live-weex", "LiveWeex");
            if (findLiveWeexWidget != null) {
                View realView = findLiveWeexWidget.getRealView();
                if (realView instanceof WeexWidgetView) {
                    wXSDKInstance = ((WeexWidgetView) realView).getWXSDKInstance();
                }
            }
            if (wXSDKInstance != null) {
                this.mLiveWeexInstance = wXSDKInstance;
            }
        }
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onContentHidden() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775517930")) {
            ipChange.ipc$dispatch("-1775517930", new Object[]{this});
            return;
        }
        this.mContentIsShown = false;
        refreshContentRelativeButton();
        BaseSlideLayout baseSlideLayout = this.frameLayout;
        if (baseSlideLayout != null) {
            baseSlideLayout.onClearScreenChanged(true);
        }
        getEngineInstance().putData(LiveRoomConstants.DATA_ROOM_IS_CLEAR_SCREEN, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onContentShown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6538791")) {
            ipChange.ipc$dispatch("-6538791", new Object[]{this});
            return;
        }
        this.mContentIsShown = true;
        refreshContentRelativeButton();
        BaseSlideLayout baseSlideLayout = this.frameLayout;
        if (baseSlideLayout != null) {
            baseSlideLayout.onClearScreenChanged(false);
        }
        getEngineInstance().putData(LiveRoomConstants.DATA_ROOM_IS_CLEAR_SCREEN, Boolean.FALSE);
    }

    private void onLandscape() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215839522")) {
            ipChange.ipc$dispatch("-1215839522", new Object[]{this});
            return;
        }
        BaseSlideLayout baseSlideLayout = this.frameLayout;
        if (baseSlideLayout != null) {
            baseSlideLayout.setLrEnabled(this.supportLeftRightMotion);
            baseSlideLayout.setScreenMode(true);
            baseSlideLayout.showContentView();
        }
    }

    private void onPortrait() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703873910")) {
            ipChange.ipc$dispatch("1703873910", new Object[]{this});
            return;
        }
        BaseSlideLayout baseSlideLayout = this.frameLayout;
        if (baseSlideLayout != null) {
            baseSlideLayout.setLrEnabled(this.supportLeftRightMotion);
            baseSlideLayout.setScreenMode(false);
            baseSlideLayout.showContentView();
        }
    }

    private void refreshContentRelativeButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771918388")) {
            ipChange.ipc$dispatch("771918388", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809193024")) {
            ipChange.ipc$dispatch("1809193024", new Object[]{this});
        } else {
            super.destroy();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        View hostView;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-942391306")) {
            ipChange.ipc$dispatch("-942391306", new Object[]{this});
        } else if (this.frameLayout != null) {
            List<IWidget> children = getChildren();
            if (children != null && children.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (IWidget iWidget : children) {
                    if (iWidget != null && (hostView = iWidget.getHostView()) != null) {
                        if (!z) {
                            this.frameLayout.initFirst(hostView);
                            z = true;
                        }
                        arrayList.add(iWidget.getHostView());
                    }
                }
                this.frameLayout.initContainers(arrayList);
            }
            this.frameLayout.setStatusListener(new BaseSlideLayout.StatusListener() { // from class: com.youku.live.livesdk.wkit.widget.slide.BaseSlideWidget.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.StatusListener
                public void onHideContent() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1774963285")) {
                        ipChange2.ipc$dispatch("1774963285", new Object[]{this});
                    } else {
                        BaseSlideWidget.this.onContentHidden();
                    }
                }

                @Override // com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.StatusListener
                public void onShowContent() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-58254768")) {
                        ipChange2.ipc$dispatch("-58254768", new Object[]{this});
                    } else {
                        BaseSlideWidget.this.onContentShown();
                    }
                }

                @Override // com.youku.live.livesdk.wkit.widget.slide.BaseSlideLayout.StatusListener
                public void onTouchClick(int i, int i2, int i3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1179014958")) {
                        ipChange2.ipc$dispatch("1179014958", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(AdUtConstants.XAD_UT_ARG_COUNT, 1);
                    hashMap.put(Constants.Name.X, Integer.valueOf(i));
                    hashMap.put(Constants.Name.Y, Integer.valueOf(i2));
                    hashMap.put("click", Integer.valueOf(i3));
                    BaseSlideWidget.this.getEngineInstance().asyncPutData(LiveRoomConstants.EVENT_SRCEEN_TOUCH, hashMap);
                    MyLog.i("jiangzTouch", "onTouchClick()-> click: " + i3);
                }
            });
        }
    }

    public LiveWeexWidget findLiveWeexWidget(String str, String str2) {
        List<IWidget> findWidgetsByName;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40511857")) {
            return (LiveWeexWidget) ipChange.ipc$dispatch("-40511857", new Object[]{this, str, str2});
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IWidget findWidgetById = engineInstance.findWidgetById(str);
            LiveWeexWidget liveWeexWidget = findWidgetById instanceof LiveWeexWidget ? (LiveWeexWidget) findWidgetById : null;
            if (liveWeexWidget != null || (findWidgetsByName = engineInstance.findWidgetsByName(str2)) == null) {
                return liveWeexWidget;
            }
            for (IWidget iWidget : findWidgetsByName) {
                if (iWidget instanceof LiveWeexWidget) {
                    return (LiveWeexWidget) iWidget;
                }
            }
            return liveWeexWidget;
        }
        return null;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160515927")) {
            return (View) ipChange.ipc$dispatch("160515927", new Object[]{this, context});
        }
        this.frameLayout = new BaseSlideLayout(context);
        getEngineInstance().addDataHandler(LiveRoomConstants.EVENT_LIKE_ACTVIATED, this);
        return this.frameLayout;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943477841")) {
            ipChange.ipc$dispatch("-1943477841", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        IProps props = iWidgetData.getProps();
        if (props != null && props.containsKey("ltr")) {
            this.supportLeftRightMotion = props.getString("ltr", "1").equals("1");
        }
        BaseSlideLayout baseSlideLayout = this.frameLayout;
        if (baseSlideLayout != null) {
            baseSlideLayout.setLrEnabled(this.supportLeftRightMotion);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener
    public void onActivityConfigurationOrientationChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746752139")) {
            ipChange.ipc$dispatch("-1746752139", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 2) {
            onPortrait();
        } else {
            onLandscape();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823621423")) {
            ipChange.ipc$dispatch("-1823621423", new Object[]{this, str, obj, obj2});
        } else if (LiveRoomConstants.EVENT_LIKE_ACTVIATED.equals(str) && (obj instanceof Boolean)) {
            this.frameLayout.setIntercept(((Boolean) obj).booleanValue());
        }
    }
}
