package com.youku.live.dago.widgetlib.component;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectParams;
import com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeEffectViewUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLikeViewComponent extends ProxyWXComponent<View> implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoLikeViewComponent";
    private static boolean isActivated;
    private boolean isClearScreen;
    private String mBubbleUrl;
    private DagoLikeView mDagoLikeView;
    int[] mEndPos;
    private boolean mFullScreenDig;
    private Handler mHandler;
    private DagoLikeEffectParams.DagoLikeEffectParamsBuilder mParamsBuilder;
    private ViewGroup mParetView;
    private FrameLayout mRootView;

    public DagoLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        this.isClearScreen = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.component.DagoLikeViewComponent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-670866573")) {
                    ipChange.ipc$dispatch("-670866573", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                boolean unused = DagoLikeViewComponent.isActivated = false;
                IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(DagoLikeViewComponent.this);
                if (widgetEngineInstance != null) {
                    widgetEngineInstance.asyncPutData(LiveRoomConstants.EVENT_LIKE_ACTVIATED, Boolean.valueOf(DagoLikeViewComponent.isActivated));
                }
            }
        };
        this.mFullScreenDig = false;
        this.mEndPos = new int[]{0, 0};
        this.mBubbleUrl = "https://gw.alicdn.com/tfs/TB1tmlSH4D1gK0jSZFKXXcJrVXa-180-180.png";
        this.mParamsBuilder = new DagoLikeEffectParams.DagoLikeEffectParamsBuilder();
    }

    private void addDagoLikeEffectView(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269736505")) {
            ipChange.ipc$dispatch("-269736505", new Object[]{this, iArr});
        } else if (!this.mFullScreenDig || this.isClearScreen) {
        } else {
            DagoLikeEffectViewUtils.addDagoLikeEffectView(this.mParetView, this.mParamsBuilder.setResources(DagoLikeEffectViewUtils.getRandomDrawable()).setBubbleUrl(this.mBubbleUrl).setStartPos(iArr).setEndPos(this.mEndPos).build()).play();
        }
    }

    private FrameLayout createRootView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325573374")) {
            return (FrameLayout) ipChange.ipc$dispatch("-325573374", new Object[]{this, view});
        }
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        this.mRootView = frameLayout;
        frameLayout.addView(view, -1, -1);
        return this.mRootView;
    }

    private void releaseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550813536")) {
            ipChange.ipc$dispatch("-1550813536", new Object[]{this});
            return;
        }
        isActivated = false;
        this.mHandler.removeCallbacksAndMessages(null);
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
        if (AndroidInstantRuntime.support(ipChange, "446398130")) {
            ipChange.ipc$dispatch("446398130", new Object[]{this});
            return;
        }
        super.destroy();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        releaseView();
        DagoLikeEffectViewUtils.release();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(LiveRoomConstants.EVENT_SRCEEN_TOUCH, this);
            widgetEngineInstance.removeDataHandler(LiveRoomConstants.DATA_ROOM_IS_CLEAR_SCREEN, this);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670011464")) {
            return (View) ipChange.ipc$dispatch("-1670011464", new Object[]{this, context});
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
        if (AndroidInstantRuntime.support(ipChange, "-1427661245")) {
            ipChange.ipc$dispatch("-1427661245", new Object[]{this, str, obj, obj2});
        } else if (LiveRoomConstants.EVENT_SRCEEN_TOUCH.equals(str)) {
            if (obj instanceof Map) {
                Map<String, Object> map = (Map) obj;
                int intValue = ((Integer) map.get("click")).intValue();
                int[] iArr = {((Integer) map.get(Constants.Name.X)).intValue(), ((Integer) map.get(Constants.Name.Y)).intValue()};
                if (intValue == 1 && isActivated) {
                    this.mHandler.removeCallbacksAndMessages(null);
                    this.mHandler.sendEmptyMessageDelayed(0, 1000L);
                }
                if (intValue == 2) {
                    isActivated = true;
                    IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
                    if (widgetEngineInstance != null) {
                        widgetEngineInstance.asyncPutData(LiveRoomConstants.EVENT_LIKE_ACTVIATED, Boolean.valueOf(isActivated));
                    }
                }
                if (isActivated) {
                    addDagoLikeEffectView(iArr);
                    getInstance().fireGlobalEventCallback("fullScreenDigEvent", map);
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "fullScreenDigEvent");
                }
            }
        } else if (LiveRoomConstants.DATA_ROOM_IS_CLEAR_SCREEN.equals(str) && (obj instanceof Boolean)) {
            this.isClearScreen = ((Boolean) obj).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441663890")) {
            ipChange.ipc$dispatch("-441663890", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandlers(new String[]{LiveRoomConstants.EVENT_SRCEEN_TOUCH, LiveRoomConstants.DATA_ROOM_IS_CLEAR_SCREEN}, this);
        }
    }

    @WXComponentProp(name = "bubbleUrl")
    public void setBubbleUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069337529")) {
            ipChange.ipc$dispatch("-2069337529", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setBubbleUrl: " + str);
        this.mBubbleUrl = str;
    }

    @WXComponentProp(name = "xy")
    public void setEndPos(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865872993")) {
            ipChange.ipc$dispatch("-1865872993", new Object[]{this, iArr});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setEndPos: " + iArr[0] + AVFSCacheConstants.COMMA_SEP + iArr[1]);
        this.mEndPos = iArr;
    }

    @WXComponentProp(name = "flow")
    public void setFlow(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854920759")) {
            ipChange.ipc$dispatch("-854920759", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFlow: " + map);
        int intValue = map.containsKey(AdUtConstants.XAD_UT_ARG_COUNT) ? ((Integer) map.get(AdUtConstants.XAD_UT_ARG_COUNT)).intValue() : 0;
        String str = map.containsKey("avatar") ? (String) map.get("avatar") : null;
        DagoLikeView dagoLikeView = this.mDagoLikeView;
        if (dagoLikeView != null) {
            dagoLikeView.setFlow(intValue);
        }
        DagoLikeView dagoLikeView2 = this.mDagoLikeView;
        if (dagoLikeView2 != null) {
            dagoLikeView2.setAvatar(str);
        }
    }

    @WXComponentProp(name = "fullScreenDig")
    public void setFullScreenDig(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129665947")) {
            ipChange.ipc$dispatch("1129665947", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFullScreenDig: " + z);
        this.mFullScreenDig = z;
        this.mParetView = (ViewGroup) UIUtil.getRootView((Activity) getContext());
    }

    @WXComponentProp(name = "src")
    public void setLikeViewSrc(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907665869")) {
            ipChange.ipc$dispatch("1907665869", new Object[]{this, map});
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

    public DagoLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.isClearScreen = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.component.DagoLikeViewComponent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-670866573")) {
                    ipChange.ipc$dispatch("-670866573", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                boolean unused = DagoLikeViewComponent.isActivated = false;
                IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(DagoLikeViewComponent.this);
                if (widgetEngineInstance != null) {
                    widgetEngineInstance.asyncPutData(LiveRoomConstants.EVENT_LIKE_ACTVIATED, Boolean.valueOf(DagoLikeViewComponent.isActivated));
                }
            }
        };
        this.mFullScreenDig = false;
        this.mEndPos = new int[]{0, 0};
        this.mBubbleUrl = "https://gw.alicdn.com/tfs/TB1tmlSH4D1gK0jSZFKXXcJrVXa-180-180.png";
        this.mParamsBuilder = new DagoLikeEffectParams.DagoLikeEffectParamsBuilder();
    }

    public DagoLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isClearScreen = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.component.DagoLikeViewComponent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-670866573")) {
                    ipChange.ipc$dispatch("-670866573", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                boolean unused = DagoLikeViewComponent.isActivated = false;
                IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(DagoLikeViewComponent.this);
                if (widgetEngineInstance != null) {
                    widgetEngineInstance.asyncPutData(LiveRoomConstants.EVENT_LIKE_ACTVIATED, Boolean.valueOf(DagoLikeViewComponent.isActivated));
                }
            }
        };
        this.mFullScreenDig = false;
        this.mEndPos = new int[]{0, 0};
        this.mBubbleUrl = "https://gw.alicdn.com/tfs/TB1tmlSH4D1gK0jSZFKXXcJrVXa-180-180.png";
        this.mParamsBuilder = new DagoLikeEffectParams.DagoLikeEffectParamsBuilder();
    }

    public DagoLikeViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.isClearScreen = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.component.DagoLikeViewComponent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-670866573")) {
                    ipChange.ipc$dispatch("-670866573", new Object[]{this, message});
                    return;
                }
                super.handleMessage(message);
                boolean unused = DagoLikeViewComponent.isActivated = false;
                IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(DagoLikeViewComponent.this);
                if (widgetEngineInstance != null) {
                    widgetEngineInstance.asyncPutData(LiveRoomConstants.EVENT_LIKE_ACTVIATED, Boolean.valueOf(DagoLikeViewComponent.isActivated));
                }
            }
        };
        this.mFullScreenDig = false;
        this.mEndPos = new int[]{0, 0};
        this.mBubbleUrl = "https://gw.alicdn.com/tfs/TB1tmlSH4D1gK0jSZFKXXcJrVXa-180-180.png";
        this.mParamsBuilder = new DagoLikeEffectParams.DagoLikeEffectParamsBuilder();
    }
}
