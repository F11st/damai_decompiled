package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLAnchorInfoComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BIZ_TYPE_LAIFENG = 3;
    public static final int BIZ_TYPE_PGC = 6;
    private static final String TAG = "YKLAnchorInfoComponent";
    private DagoAnchorInfoView mAnchorInfoView;

    public YKLAnchorInfoComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private void putData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413264313")) {
            ipChange.ipc$dispatch("-413264313", new Object[]{this, str, obj});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.putData(str, obj);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577590624")) {
            ipChange.ipc$dispatch("1577590624", new Object[]{this});
            return;
        }
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.reset();
            ViewParent parent = this.mAnchorInfoView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mAnchorInfoView);
            }
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                widgetEngineInstance.recycleView(DagoAnchorInfoView.class.getName(), this.mAnchorInfoView);
            }
            this.mAnchorInfoView = null;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914879178")) {
            return (View) ipChange.ipc$dispatch("1914879178", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView: ");
        FrameLayout frameLayout = new FrameLayout(context);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            Object pollRecycleView = widgetEngineInstance.pollRecycleView(DagoAnchorInfoView.class.getName());
            if (pollRecycleView instanceof DagoAnchorInfoView) {
                this.mAnchorInfoView = (DagoAnchorInfoView) pollRecycleView;
            }
        }
        if (this.mAnchorInfoView == null) {
            this.mAnchorInfoView = new DagoAnchorInfoView(context);
        }
        frameLayout.addView(this.mAnchorInfoView);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636185472")) {
            ipChange.ipc$dispatch("636185472", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        getBasicComponentData().getAttrs();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized: ");
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setBizType(6);
            this.mAnchorInfoView.setSupportAnim(true);
            this.mAnchorInfoView.setAnchorCallback(new DagoAnchorInfoView.AnchorCallback() { // from class: com.youku.live.dago.widgetlib.component.YKLAnchorInfoComponent.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                public void onAttentionClick() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1207265644")) {
                        ipChange2.ipc$dispatch("-1207265644", new Object[]{this});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i(YKLAnchorInfoComponent.TAG, "onAttentionClick clickfollowbtn: ");
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("action", "clickFollowBtn");
                    YKLAnchorInfoComponent.this.fireEvent("clickanchor", hashMap);
                }

                @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                public void onAvatarClick() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1293254557")) {
                        ipChange2.ipc$dispatch("1293254557", new Object[]{this});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i(YKLAnchorInfoComponent.TAG, "onAvatarClick clickanchorinfo: ");
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("action", "clickAnchorInfo");
                    YKLAnchorInfoComponent.this.fireEvent("clickanchor", hashMap);
                }
            });
        }
    }

    @WXComponentProp(name = "anchorAvatar")
    public void setAnchorAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995840012")) {
            ipChange.ipc$dispatch("-995840012", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "anchorAvatar: " + str);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.updateAnchorAvatar(str);
        }
    }

    @WXComponentProp(name = "anchorFansCount")
    public void setAnchorDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967771844")) {
            ipChange.ipc$dispatch("-967771844", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "anchorFansCount: " + str);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.updateAnchorDesc(str);
        }
    }

    @WXComponentProp(name = "anchorName")
    public void setAnchorName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343200642")) {
            ipChange.ipc$dispatch("1343200642", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "anchorName: " + str);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.updateAnchorName(str);
        }
    }

    @WXComponentProp(name = "btnBg")
    public void setBtnBg(List<String> list) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1043687426")) {
            ipChange.ipc$dispatch("1043687426", new Object[]{this, list});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "btnBg: " + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "btnBg: " + list.size());
        if (TextUtils.isEmpty(list.get(0))) {
            i = 0;
        } else {
            i = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + list.get(0));
        }
        if (list.size() > 1 && !TextUtils.isEmpty(list.get(1))) {
            i2 = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + list.get(1));
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        int i3 = i == 0 ? i2 : i;
        int i4 = i2 == 0 ? i3 : i2;
        int dip2px = DensityUtil.dip2px(getContext(), 15.0f);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "btnBg: " + dip2px);
        GradientDrawable gradientDrawable = ThemeUtils.getGradientDrawable(i3, i4, GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, (float) dip2px);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "btnBg: " + gradientDrawable);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setBtnBackground(gradientDrawable);
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setBtnBackground: ");
    }

    @WXComponentProp(name = "iconUrl")
    public void setIconUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870127622")) {
            ipChange.ipc$dispatch("1870127622", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "iconUrl: " + str);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setSubtitleIcon(str);
        }
    }

    @WXComponentProp(name = "anchorIsFollow")
    public void setIsFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463717257")) {
            ipChange.ipc$dispatch("-463717257", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "anchorIsFollow: " + z);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.updateAnchorAttentionState(z);
        }
    }

    @WXComponentProp(name = "showFollowBtn")
    public void showFollowBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768004184")) {
            ipChange.ipc$dispatch("-768004184", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "showFollowBtn: " + z);
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setAttentionVisibility(z, false);
            putData("DATA_KEY_LAIFENG_ATTENTION_STATE", Boolean.valueOf(z));
        }
    }
}
