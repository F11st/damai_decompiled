package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListView;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoExChatListView;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.OnCellClickListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.TrueLoveGroupInteractor;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.test.DagoChatListTest;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoChatListComponent extends ProxyWXComponent<View> implements OnCellClickListener, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoChatListComponent";
    private IDagoChatListView mChatListView;
    private DagoChatListTest mDagoChatListTest;
    private FrameLayout mRootView;

    public DagoChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    private FrameLayout createRootView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343817096")) {
            return (FrameLayout) ipChange.ipc$dispatch("343817096", new Object[]{this, view});
        }
        this.perfMonitor.point("initComponentHostView", "initComponentHostView.point.5");
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        this.mRootView = frameLayout;
        frameLayout.addView(view, -1, -1);
        this.perfMonitor.point("initComponentHostView", "initComponentHostView.point.6");
        return this.mRootView;
    }

    private void parseWXAttr(WXAttr wXAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831548554")) {
            ipChange.ipc$dispatch("-1831548554", new Object[]{this, wXAttr});
            return;
        }
        String str = wXAttr.containsKey("limit") ? (String) wXAttr.get("limit") : null;
        String str2 = wXAttr.containsKey("newMsgTipTextColor") ? (String) wXAttr.get("newMsgTipTextColor") : null;
        String str3 = wXAttr.containsKey("newMsgTipBgColor") ? (String) wXAttr.get("newMsgTipBgColor") : null;
        String str4 = wXAttr.containsKey("newMsgTipBorderColor") ? (String) wXAttr.get("newMsgTipBorderColor") : null;
        String str5 = wXAttr.containsKey("topMaskHeightScale") ? (String) wXAttr.get("topMaskHeightScale") : null;
        String str6 = wXAttr.containsKey("topMaskStartAlpha") ? (String) wXAttr.get("topMaskStartAlpha") : null;
        int i = 14;
        if (wXAttr.containsKey("fontSize") && wXAttr.get("fontSize") != null) {
            i = Integer.parseInt(String.valueOf(wXAttr.get("fontSize")));
        }
        IDagoChatListView iDagoChatListView = this.mChatListView;
        if (iDagoChatListView != null) {
            iDagoChatListView.setLimitSize(str);
            this.mChatListView.setFontSize(i);
            this.mChatListView.setNewMsgTipStyle(str2, str3, str4, str5, str6);
        }
    }

    private void releaseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612223322")) {
            ipChange.ipc$dispatch("1612223322", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mRootView = null;
        }
        IDagoChatListView iDagoChatListView = this.mChatListView;
        if (iDagoChatListView != null) {
            iDagoChatListView.clear();
            IDagoChatListView iDagoChatListView2 = this.mChatListView;
            if (iDagoChatListView2 instanceof View) {
                ViewParent parent = ((View) iDagoChatListView2).getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView((View) this.mChatListView);
                }
                IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
                if (widgetEngineInstance != null) {
                    IDagoChatListView iDagoChatListView3 = this.mChatListView;
                    if (iDagoChatListView3 instanceof DagoExChatListView) {
                        widgetEngineInstance.recycleView(DagoExChatListView.class.getName(), this.mChatListView);
                    } else if (iDagoChatListView3 instanceof DagoChatListView) {
                        widgetEngineInstance.recycleView(DagoChatListView.class.getName(), this.mChatListView);
                    }
                }
            }
            this.mChatListView = null;
        }
        DagoChatListTest dagoChatListTest = this.mDagoChatListTest;
        if (dagoChatListTest != null) {
            dagoChatListTest.removeTestView();
            this.mDagoChatListTest.release();
        }
    }

    @JSMethod(uiThread = false)
    public void add(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934539264")) {
            ipChange.ipc$dispatch("1934539264", new Object[]{this, map});
            return;
        }
        try {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "add: " + map.get(WXBasicComponentType.CELL));
            DagoCell dagoCell = new DagoCell(map);
            IDagoChatListView iDagoChatListView = this.mChatListView;
            if (iDagoChatListView != null) {
                iDagoChatListView.add(dagoCell);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JSMethod(uiThread = false)
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1272904327")) {
            ipChange.ipc$dispatch("-1272904327", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.TAG_CLEAR_STRING);
        IDagoChatListView iDagoChatListView = this.mChatListView;
        if (iDagoChatListView != null) {
            iDagoChatListView.clear();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244460948")) {
            ipChange.ipc$dispatch("-1244460948", new Object[]{this});
            return;
        }
        super.destroy();
        releaseView();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(TrueLoveGroupInteractor.TRUE_LOVE_MEDAL_API, this);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1631516354")) {
            return (View) ipChange.ipc$dispatch("-1631516354", new Object[]{this, context});
        }
        perfMonitorPoint("initComponentHostView", "initComponentHostView.point.0");
        releaseView();
        perfMonitorPoint("initComponentHostView", "initComponentHostView.point.1");
        boolean containsKey = getBasicComponentData().getAttrs().containsKey("isDemotion");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        perfMonitorPoint("initComponentHostView", "initComponentHostView.point.2");
        if (widgetEngineInstance != null) {
            if (!containsKey) {
                Object pollRecycleView = widgetEngineInstance.pollRecycleView(DagoExChatListView.class.getName());
                if (pollRecycleView instanceof DagoExChatListView) {
                    DagoExChatListView dagoExChatListView = (DagoExChatListView) pollRecycleView;
                    this.mChatListView = dagoExChatListView;
                    dagoExChatListView.setOnCellClickListener(this);
                }
            } else {
                Object pollRecycleView2 = widgetEngineInstance.pollRecycleView(DagoChatListView.class.getName());
                if (pollRecycleView2 instanceof DagoChatListView) {
                    DagoChatListView dagoChatListView = (DagoChatListView) pollRecycleView2;
                    this.mChatListView = dagoChatListView;
                    dagoChatListView.setOnCellClickListener(this);
                }
            }
        }
        perfMonitorPoint("initComponentHostView", "initComponentHostView.point.3");
        if (this.mChatListView == null) {
            if (!containsKey) {
                this.mChatListView = new DagoExChatListView(context, this);
            } else {
                this.mChatListView = new DagoChatListView(context, this);
            }
        }
        perfMonitorPoint("initComponentHostView", "initComponentHostView.point.4");
        return createRootView((View) this.mChatListView);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.OnCellClickListener
    public void onClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777457753")) {
            ipChange.ipc$dispatch("-777457753", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onClick: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", str);
        fireEvent("buttonclick", hashMap);
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IDagoChatListView iDagoChatListView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376107267")) {
            ipChange.ipc$dispatch("-1376107267", new Object[]{this, str, obj, obj2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onDataChanged: " + str + ": " + obj);
        if (TrueLoveGroupInteractor.TRUE_LOVE_MEDAL_API.equals(str) && (obj instanceof String) && (iDagoChatListView = this.mChatListView) != null) {
            iDagoChatListView.setGroupName((String) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912184308")) {
            ipChange.ipc$dispatch("912184308", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized");
        parseWXAttr(getBasicComponentData().getAttrs());
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler(TrueLoveGroupInteractor.TRUE_LOVE_MEDAL_API, this);
        }
    }

    @WXComponentProp(name = "newMsgTipTextColor")
    public void setNewMsgTipTextColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345444786")) {
            ipChange.ipc$dispatch("1345444786", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setNewMsgTipTextColor: " + str);
        IDagoChatListView iDagoChatListView = this.mChatListView;
        if (iDagoChatListView != null) {
            iDagoChatListView.setNewMsgTipStyle(str, null, null, null, null);
        }
    }

    @JSMethod(uiThread = false)
    public void updateLast(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849715296")) {
            ipChange.ipc$dispatch("-1849715296", new Object[]{this, map});
            return;
        }
        try {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateLast: " + map.get(WXBasicComponentType.CELL));
            DagoCell dagoCell = new DagoCell(map);
            IDagoChatListView iDagoChatListView = this.mChatListView;
            if (iDagoChatListView != null) {
                iDagoChatListView.updateLast(dagoCell);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DagoChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public DagoChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }
}
