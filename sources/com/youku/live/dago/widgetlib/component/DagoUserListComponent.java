package com.youku.live.dago.widgetlib.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cn.damai.category.category.ui.StarFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListBean;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoUserListComponent extends ProxyWXComponent<View> implements UserListView.IClickCallback {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoUserListComponent";
    private String mLiveId;
    private FrameLayout mRootView;
    private String mSize;
    private UserListView mUserListView;

    public DagoUserListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private FrameLayout createRootView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563318603")) {
            return (FrameLayout) ipChange.ipc$dispatch("-1563318603", new Object[]{this, view});
        }
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        this.mRootView = frameLayout;
        frameLayout.addView(view, -1, -1);
        return this.mRootView;
    }

    private void releaseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193519757")) {
            ipChange.ipc$dispatch("193519757", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mRootView = null;
        }
        if (this.mUserListView != null) {
            this.mUserListView = null;
        }
    }

    @JSMethod(uiThread = true)
    public void bubbleUserList(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "270730953")) {
            ipChange.ipc$dispatch("270730953", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "bubbleUserList: " + map);
        UserListView userListView = this.mUserListView;
        if (userListView != null) {
            userListView.bubbleUserList(map);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653793505")) {
            ipChange.ipc$dispatch("-653793505", new Object[]{this});
            return;
        }
        super.destroy();
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mRootView = null;
        }
        UserListView userListView = this.mUserListView;
        if (userListView != null) {
            userListView.setOnItemClickListener(null);
            this.mUserListView.clear();
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                widgetEngineInstance.recycleView(UserListView.class.getName(), this.mUserListView);
            }
            this.mUserListView = null;
        }
        releaseView();
    }

    @WXComponentProp(name = "liveId")
    public void getLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995935718")) {
            ipChange.ipc$dispatch("1995935718", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "getLiveId: " + str);
        this.mLiveId = str;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310648853")) {
            return (View) ipChange.ipc$dispatch("-1310648853", new Object[]{this, context});
        }
        this.mSize = (String) getBasicComponentData().getAttrs().get("size");
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView: " + this.mSize);
        releaseView();
        this.mUserListView = null;
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            Object pollRecycleView = widgetEngineInstance.pollRecycleView(UserListView.class.getName());
            if (pollRecycleView instanceof UserListView) {
                this.mUserListView = (UserListView) pollRecycleView;
            }
        }
        if (this.mUserListView == null) {
            this.mUserListView = new UserListView(context);
        }
        this.mUserListView.setMode(this.mSize);
        this.mUserListView.setOnItemClickListener(this);
        return createRootView(this.mUserListView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829513311")) {
            ipChange.ipc$dispatch("-1829513311", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        this.mLiveId = getLiveId(getBasicComponentData().getAttrs());
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized: " + this.mLiveId);
        if (TextUtils.isEmpty(this.mLiveId)) {
            return;
        }
        this.mUserListView.reqUserList(this.mLiveId);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.IClickCallback
    public void onItemClick(UserListBean userListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140179086")) {
            ipChange.ipc$dispatch("-1140179086", new Object[]{this, userListBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onItemClick: " + userListBean);
        HashMap hashMap = new HashMap();
        if (userListBean != null && !TextUtils.isEmpty(userListBean.u)) {
            hashMap.put("userId", userListBean.u);
        }
        fireEvent(StarFragment.KEY_FOLLOW, hashMap);
    }

    @JSMethod(uiThread = true)
    public void setUserCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-733835820")) {
            ipChange.ipc$dispatch("-733835820", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setUserCount: " + i);
        UserListView userListView = this.mUserListView;
        if (userListView != null) {
            userListView.setUserCount(i);
        }
    }

    @WXComponentProp(name = "size")
    public void updateAttributes(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712492699")) {
            ipChange.ipc$dispatch("712492699", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateAttributes: " + str);
        this.mSize = str;
        UserListView userListView = this.mUserListView;
        if (userListView != null) {
            userListView.updateAttributes(str);
        }
    }

    private String getLiveId(WXAttr wXAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364492337")) {
            return (String) ipChange.ipc$dispatch("-1364492337", new Object[]{this, wXAttr});
        }
        String str = wXAttr.containsKey("liveId") ? (String) wXAttr.get("liveId") : "";
        if (TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(getInstance().getBundleUrl());
                str = parse.getQueryParameter("id");
                if (TextUtils.isEmpty(str)) {
                    str = parse.getQueryParameter("liveId");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            try {
                Uri data = ((Activity) getContext()).getIntent().getData();
                if (data != null) {
                    str = TextUtils.isEmpty(data.getQueryParameter("id")) ? data.getQueryParameter("liveId") : data.getQueryParameter("id");
                }
            } catch (Exception unused) {
                ((ILog) Dsl.getService(ILog.class)).e("YKLUserListComponent", "no liveId");
            }
        }
        return str;
    }
}
