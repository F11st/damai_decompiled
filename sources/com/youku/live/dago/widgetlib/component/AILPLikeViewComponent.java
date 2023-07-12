package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailpbaselib.framework.AILPAdapterFactory;
import com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectViewUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPLikeViewComponent extends ProxyWXComponent<View> implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "AILPLikeViewComponent";
    private DagoLikeView mDagoLikeView;
    private FrameLayout mRootView;

    public AILPLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    private FrameLayout createRootView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66537413")) {
            return (FrameLayout) ipChange.ipc$dispatch("-66537413", new Object[]{this, view});
        }
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        this.mRootView = frameLayout;
        frameLayout.addView(view, -1, -1);
        return this.mRootView;
    }

    private AILPLikeViewProtocol getAdapter(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1710300541") ? (AILPLikeViewProtocol) ipChange.ipc$dispatch("-1710300541", new Object[]{this, context}) : (AILPLikeViewProtocol) AILPAdapterFactory.getInstance().createInterface(AILPLikeViewComponent.class, context);
    }

    private void releaseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252534201")) {
            ipChange.ipc$dispatch("-252534201", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mRootView = null;
        }
        DagoLikeView dagoLikeView = this.mDagoLikeView;
        if (dagoLikeView != null) {
            dagoLikeView.destroy();
            this.mDagoLikeView = null;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313106471")) {
            ipChange.ipc$dispatch("-1313106471", new Object[]{this});
            return;
        }
        super.destroy();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        releaseView();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(LiveRoomConstants.EVENT_SRCEEN_TOUCH, this);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1903692687")) {
            return (View) ipChange.ipc$dispatch("-1903692687", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView");
        releaseView();
        DagoLikeView dagoLikeView = new DagoLikeView(context);
        this.mDagoLikeView = dagoLikeView;
        return createRootView(dagoLikeView);
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882988822")) {
            ipChange.ipc$dispatch("-882988822", new Object[]{this, str, obj, obj2});
        } else if (LiveRoomConstants.EVENT_SRCEEN_TOUCH.equals(str) && (obj instanceof Map)) {
            Map<String, Object> map = (Map) obj;
            if (((Integer) map.get("click")).intValue() == 1) {
                getInstance().fireGlobalEventCallback("fullScreenDigEvent", map);
                ((ILog) Dsl.getService(ILog.class)).i(TAG, "fullScreenDigEvent");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587044825")) {
            ipChange.ipc$dispatch("-587044825", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandlers(new String[]{LiveRoomConstants.EVENT_SRCEEN_TOUCH}, this);
        }
    }

    @WXComponentProp(name = "flow")
    public void setFlow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345317888")) {
            ipChange.ipc$dispatch("-345317888", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFlow: " + i);
        DagoLikeView dagoLikeView = this.mDagoLikeView;
        if (dagoLikeView != null) {
            dagoLikeView.setFlow(i);
        }
    }

    @WXComponentProp(name = "src")
    public void setlikeViewSrc(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584815660")) {
            ipChange.ipc$dispatch("-584815660", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setlikeViewSrc: " + map);
        int intValue = map.containsKey("width") ? ((Integer) map.get("width")).intValue() : 50;
        String str = map.containsKey("url") ? (String) map.get("url") : "";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DagoLikeEffectViewUtils.setLikeViewSrc(str, intValue);
        DagoLikeView dagoLikeView = this.mDagoLikeView;
        if (dagoLikeView != null) {
            dagoLikeView.setLikeViewSrc(str, intValue);
        }
    }

    public AILPLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public AILPLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public AILPLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
    }
}
