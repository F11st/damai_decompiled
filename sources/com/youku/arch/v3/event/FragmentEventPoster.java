package com.youku.arch.v3.event;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alipay.sdk.m.x.d;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.FragmentInterceptor;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010f\u001a\u00020e¢\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0017J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0017J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0016J\"\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J-\u00102\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0014\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010:\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u0001062\b\u00109\u001a\u0004\u0018\u0001082\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010=\u001a\u00020\u00022\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010>\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000106H\u0016J\"\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020'H\u0016J\u0012\u0010D\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010H\u001a\u00020\u00022\b\u0010E\u001a\u0004\u0018\u0001042\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J8\u0010Q\u001a\u00020\u00022\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\n2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J \u0010R\u001a\u00020\u00022\u0006\u0010J\u001a\u00020I2\u0006\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J \u0010S\u001a\u00020\u00022\u0006\u0010J\u001a\u00020I2\u0006\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J\u0018\u0010U\u001a\u00020\u00022\u0006\u0010J\u001a\u00020I2\u0006\u0010T\u001a\u00020\nH\u0016J8\u0010Y\u001a\u00020\u00022\u0006\u0010W\u001a\u00020V2\u0006\u0010K\u001a\u00020\n2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020'2\u0006\u0010X\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J \u0010Z\u001a\u00020\u00022\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J \u0010[\u001a\u00020\u00022\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020'2\u0006\u0010P\u001a\u00020'H\u0016J\u0018\u0010\\\u001a\u00020\u00022\u0006\u0010W\u001a\u00020V2\u0006\u0010T\u001a\u00020\nH\u0016J\u0010\u0010_\u001a\u00020\u00022\u0006\u0010^\u001a\u00020]H\u0016J\u0010\u0010`\u001a\u00020\u00022\u0006\u0010^\u001a\u00020]H\u0016J \u0010d\u001a\u00020\u00022\u0006\u0010^\u001a\u00020]2\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020aH\u0017R\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006j"}, d2 = {"Lcom/youku/arch/v3/event/FragmentEventPoster;", "Lcom/youku/arch/v3/page/FragmentInterceptor;", "Ltb/wt2;", "onFragmentPause", "onLowMemory", "onDestroyView", "onFragmentResume", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onFragmentStart", "onFragmentStop", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "onViewStateRestored", "onFragmentDestroy", "onFragmentDetach", "Lcom/youku/arch/v3/io/IResponse;", "response", "onApiResponse", "isSelected", "onPageSelected", "args", "setArguments", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "", "", "permissions", "", WXModule.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "onInflate", "Landroidx/fragment/app/Fragment;", "childFragment", "onAttachFragment", "onFragmentAttach", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "onFragmentCreate", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "Lcom/scwang/smartrefresh/layout/api/RefreshHeader;", "header", Constants.Name.ISDRAGGING, "", "percent", "offset", StyleConstant.HEADER_HEIGHT, "maxDragHeight", "onHeaderMoving", "onHeaderReleased", "onHeaderStartAnimator", "success", "onHeaderFinish", "Lcom/scwang/smartrefresh/layout/api/RefreshFooter;", WXBasicComponentType.FOOTER, StyleConstant.FOOTER_HEIGHT, "onFooterMoving", "onFooterReleased", "onFooterStartAnimator", "onFooterFinish", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "refreshLayout", "onLoadMore", d.p, "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/kubus/EventBus;", "<init>", "(Lcom/youku/kubus/EventBus;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FragmentEventPoster implements FragmentInterceptor {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final EventBus eventBus;

    public FragmentEventPoster(@NotNull EventBus eventBus) {
        b41.i(eventBus, "eventBus");
        this.eventBus = eventBus;
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736364214")) {
            ipChange.ipc$dispatch("736364214", new Object[]{this, bundle});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_ACTIVITY_CREATED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325070940")) {
            ipChange.ipc$dispatch("-325070940", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onApiResponse(@Nullable IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747174659")) {
            ipChange.ipc$dispatch("-747174659", new Object[]{this, iResponse});
            return;
        }
        Event event = new Event(RefreshEvent.ON_API_RESPONSE);
        HashMap hashMap = new HashMap(2);
        hashMap.put("response", iResponse);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onAttachFragment(@Nullable Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1519793418")) {
            ipChange.ipc$dispatch("-1519793418", new Object[]{this, fragment});
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410088933")) {
            ipChange.ipc$dispatch("-1410088933", new Object[]{this, configuration});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_CONFIGURATION_CHANGED);
        HashMap hashMap = new HashMap(2);
        hashMap.put(PipUtils.DAGO_PIP_MODE_CONFIGURATION, configuration);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136089299")) {
            return (Animation) ipChange.ipc$dispatch("1136089299", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        return null;
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112622661")) {
            ipChange.ipc$dispatch("112622661", new Object[]{this, layoutInflater, viewGroup, bundle});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_CREATE_VIEW);
        HashMap hashMap = new HashMap(8);
        hashMap.put("inflater", layoutInflater);
        hashMap.put("container", viewGroup);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963546696")) {
            ipChange.ipc$dispatch("-1963546696", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_DESTROY_VIEW));
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterFinish(@NotNull RefreshFooter refreshFooter, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431844213")) {
            ipChange.ipc$dispatch("-431844213", new Object[]{this, refreshFooter, Boolean.valueOf(z)});
            return;
        }
        b41.i(refreshFooter, WXBasicComponentType.FOOTER);
        Event event = new Event(RefreshEvent.ON_FOOTER_FINISH);
        HashMap hashMap = new HashMap(4);
        hashMap.put(WXBasicComponentType.FOOTER, refreshFooter);
        hashMap.put("success", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterMoving(@NotNull RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258612759")) {
            ipChange.ipc$dispatch("-258612759", new Object[]{this, refreshFooter, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        b41.i(refreshFooter, WXBasicComponentType.FOOTER);
        Event event = new Event(RefreshEvent.ON_FOOTER_MOVING);
        HashMap hashMap = new HashMap(16);
        hashMap.put(WXBasicComponentType.FOOTER, refreshFooter);
        hashMap.put(Constants.Name.ISDRAGGING, Boolean.valueOf(z));
        hashMap.put("percent", Float.valueOf(f));
        hashMap.put("offset", Integer.valueOf(i));
        hashMap.put(StyleConstant.FOOTER_HEIGHT, Integer.valueOf(i2));
        hashMap.put("maxDragHeight", Integer.valueOf(i3));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterReleased(@NotNull RefreshFooter refreshFooter, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557413087")) {
            ipChange.ipc$dispatch("1557413087", new Object[]{this, refreshFooter, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(refreshFooter, WXBasicComponentType.FOOTER);
        Event event = new Event(RefreshEvent.ON_FOOTER_RELEASED);
        HashMap hashMap = new HashMap(8);
        hashMap.put(WXBasicComponentType.FOOTER, refreshFooter);
        hashMap.put(StyleConstant.FOOTER_HEIGHT, Integer.valueOf(i));
        hashMap.put("maxDragHeight", Integer.valueOf(i2));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onFooterStartAnimator(@NotNull RefreshFooter refreshFooter, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524828531")) {
            ipChange.ipc$dispatch("-524828531", new Object[]{this, refreshFooter, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(refreshFooter, WXBasicComponentType.FOOTER);
        Event event = new Event(RefreshEvent.ON_FOOTER_START_ANIMATOR);
        HashMap hashMap = new HashMap(8);
        hashMap.put(WXBasicComponentType.FOOTER, refreshFooter);
        hashMap.put(StyleConstant.FOOTER_HEIGHT, Integer.valueOf(i));
        hashMap.put("maxDragHeight", Integer.valueOf(i2));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentAttach(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264155274")) {
            ipChange.ipc$dispatch("264155274", new Object[]{this, context});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_ATTACH);
        HashMap hashMap = new HashMap(2);
        hashMap.put(WPKFactory.INIT_KEY_CONTEXT, context);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484408691")) {
            ipChange.ipc$dispatch("-484408691", new Object[]{this, bundle});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_CREATE);
        HashMap hashMap = new HashMap(2);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onFragmentDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954397965")) {
            ipChange.ipc$dispatch("954397965", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_DESTROY));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052934384")) {
            ipChange.ipc$dispatch("1052934384", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_DETACH));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291132911")) {
            ipChange.ipc$dispatch("-291132911", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_PAUSE));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212600854")) {
            ipChange.ipc$dispatch("1212600854", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_RESUME));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onFragmentStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-248028123")) {
            ipChange.ipc$dispatch("-248028123", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_START));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onFragmentStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103582815")) {
            ipChange.ipc$dispatch("-1103582815", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_STOP));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    @Nullable
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691969094")) {
            return (LayoutInflater) ipChange.ipc$dispatch("-691969094", new Object[]{this, bundle});
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderFinish(@NotNull RefreshHeader refreshHeader, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340940689")) {
            ipChange.ipc$dispatch("-1340940689", new Object[]{this, refreshHeader, Boolean.valueOf(z)});
            return;
        }
        b41.i(refreshHeader, "header");
        Event event = new Event(RefreshEvent.ON_HEADER_FINISH);
        HashMap hashMap = new HashMap(2);
        hashMap.put("header", refreshHeader);
        hashMap.put("success", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderMoving(@NotNull RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671862733")) {
            ipChange.ipc$dispatch("1671862733", new Object[]{this, refreshHeader, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        b41.i(refreshHeader, "header");
        Event event = new Event(RefreshEvent.ON_HEADER_MOVING);
        HashMap hashMap = new HashMap(16);
        hashMap.put("header", refreshHeader);
        hashMap.put(Constants.Name.ISDRAGGING, Boolean.valueOf(z));
        hashMap.put("percent", Float.valueOf(f));
        hashMap.put("offset", Integer.valueOf(i));
        hashMap.put(StyleConstant.HEADER_HEIGHT, Integer.valueOf(i2));
        hashMap.put("maxDragHeight", Integer.valueOf(i3));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderReleased(@NotNull RefreshHeader refreshHeader, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135403525")) {
            ipChange.ipc$dispatch("-2135403525", new Object[]{this, refreshHeader, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(refreshHeader, "header");
        Event event = new Event(RefreshEvent.ON_HEADER_RELEASED);
        HashMap hashMap = new HashMap(8);
        hashMap.put("header", refreshHeader);
        hashMap.put(StyleConstant.HEADER_HEIGHT, Integer.valueOf(i));
        hashMap.put("maxDragHeight", Integer.valueOf(i2));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
    public void onHeaderStartAnimator(@NotNull RefreshHeader refreshHeader, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23834317")) {
            ipChange.ipc$dispatch("23834317", new Object[]{this, refreshHeader, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.i(refreshHeader, "header");
        Event event = new Event(RefreshEvent.ON_HEADER_START_ANIMATOR);
        HashMap hashMap = new HashMap(8);
        hashMap.put("header", refreshHeader);
        hashMap.put(StyleConstant.HEADER_HEIGHT, Integer.valueOf(i));
        hashMap.put("maxDragHeight", Integer.valueOf(i2));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130238727")) {
            ipChange.ipc$dispatch("2130238727", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_HIDDEN_CHANGED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("hidden", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onInflate(@Nullable Context context, @Nullable AttributeSet attributeSet, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562045022")) {
            ipChange.ipc$dispatch("1562045022", new Object[]{this, context, attributeSet, bundle});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_INFLATE);
        HashMap hashMap = new HashMap(8);
        hashMap.put(WPKFactory.INIT_KEY_CONTEXT, context);
        hashMap.put(TemplateDom.KEY_ATTRS, attributeSet);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NotNull RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98416973")) {
            ipChange.ipc$dispatch("98416973", new Object[]{this, refreshLayout});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        Event event = new Event(RefreshEvent.ON_LOAD_MORE);
        HashMap hashMap = new HashMap(2);
        hashMap.put("refreshLayout", refreshLayout);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409550142")) {
            ipChange.ipc$dispatch("-1409550142", new Object[]{this});
        } else {
            this.eventBus.post(new Event(FragmentEvent.ON_FRAGMENT_LOW_MEMORY));
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onMultiWindowModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707085993")) {
            ipChange.ipc$dispatch("707085993", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_MULTI_WINDOW_MODE_CHANGED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("isInMultiWindowMode", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onPageSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524864299")) {
            ipChange.ipc$dispatch("1524864299", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Event event = new Event(FragmentEvent.ON_PAGE_SELECTED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("isSelected", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onPictureInPictureModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384332109")) {
            ipChange.ipc$dispatch("-1384332109", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
    public void onRefresh(@NotNull RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978368175")) {
            ipChange.ipc$dispatch("-978368175", new Object[]{this, refreshLayout});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        Event event = new Event(RefreshEvent.ON_REFRESH);
        HashMap hashMap = new HashMap(2);
        hashMap.put("refreshLayout", refreshLayout);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987672405")) {
            ipChange.ipc$dispatch("-1987672405", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        b41.i(strArr, "permissions");
        b41.i(iArr, WXModule.GRANT_RESULTS);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728024996")) {
            ipChange.ipc$dispatch("-728024996", new Object[]{this, bundle});
            return;
        }
        b41.i(bundle, "outState");
        Event event = new Event(FragmentEvent.ON_FRAGMENT_SAVE_INSTANCE_STATE);
        HashMap hashMap = new HashMap(2);
        hashMap.put("bundle", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull RefreshLayout refreshLayout, @NotNull RefreshState refreshState, @NotNull RefreshState refreshState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921817523")) {
            ipChange.ipc$dispatch("-1921817523", new Object[]{this, refreshLayout, refreshState, refreshState2});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        b41.i(refreshState, "oldState");
        b41.i(refreshState2, "newState");
        Event event = new Event(RefreshEvent.ON_REFRESH_STATE_CHANGED);
        HashMap hashMap = new HashMap(4);
        hashMap.put("refreshLayout", refreshLayout);
        hashMap.put("oldState", refreshState);
        hashMap.put("newState", refreshState2);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287132214")) {
            ipChange.ipc$dispatch("287132214", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        Event event = new Event(FragmentEvent.ON_FRAGMENT_VIEW_CREATED);
        HashMap hashMap = new HashMap(4);
        hashMap.put("view", view);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void onViewStateRestored(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072377793")) {
            ipChange.ipc$dispatch("-2072377793", new Object[]{this, bundle});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_VIEW_STATE_RESTORED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("savedInstanceState", bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void setArguments(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140979510")) {
            ipChange.ipc$dispatch("1140979510", new Object[]{this, bundle});
        }
    }

    @Override // com.youku.arch.v3.page.FragmentInterceptor
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764981486")) {
            ipChange.ipc$dispatch("764981486", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Event event = new Event(FragmentEvent.ON_FRAGMENT_USER_VISIBLE_HINT);
        HashMap hashMap = new HashMap();
        hashMap.put("isVisibleToUser", Boolean.valueOf(z));
        event.data = hashMap;
        event.message = String.valueOf(z);
        this.eventBus.post(event);
    }
}
