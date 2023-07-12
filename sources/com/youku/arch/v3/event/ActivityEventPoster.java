package com.youku.arch.v3.event;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.page.ActivityInterceptor;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0017H\u0016R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/youku/arch/v3/event/ActivityEventPoster;", "Lcom/youku/arch/v3/page/ActivityInterceptor;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/wt2;", "onCreate", "onStart", "onResume", MessageID.onPause, MessageID.onStop, "onBackPressed", "onDestroy", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onNewIntent", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/kubus/EventBus;", "<init>", "(Lcom/youku/kubus/EventBus;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ActivityEventPoster implements ActivityInterceptor {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final EventBus eventBus;

    public ActivityEventPoster(@NotNull EventBus eventBus) {
        b41.i(eventBus, "eventBus");
        this.eventBus = eventBus;
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "728675013")) {
            ipChange.ipc$dispatch("728675013", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430904005")) {
            ipChange.ipc$dispatch("-1430904005", new Object[]{this});
        } else {
            this.eventBus.post(new Event(ActivityEvent.ON_ACTIVITY_BACK_PRESS));
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778731494")) {
            ipChange.ipc$dispatch("-1778731494", new Object[]{this, configuration});
            return;
        }
        Event event = new Event(ActivityEvent.ON_ACTIVITY_CONFIGURATION);
        HashMap hashMap = new HashMap(2);
        hashMap.put("newConfig", configuration);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031332260")) {
            ipChange.ipc$dispatch("-2031332260", new Object[]{this, bundle});
            return;
        }
        Event event = new Event(ActivityEvent.ON_ACTIVITY_CREATE);
        HashMap hashMap = new HashMap(2);
        hashMap.put(ActivityEvent.KEY_SAVED_INSTANCE_STATE, bundle);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307106660")) {
            ipChange.ipc$dispatch("-307106660", new Object[]{this});
        } else {
            this.eventBus.post(new Event(ActivityEvent.ON_ACTIVITY_DESTROY));
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732533592")) {
            ipChange.ipc$dispatch("-732533592", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onMultiWindowModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454638936")) {
            ipChange.ipc$dispatch("-1454638936", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Event event = new Event(ActivityEvent.ON_ACTIVITY_MULTI_WINDOW_MODE_CHANGED);
        HashMap hashMap = new HashMap(1);
        hashMap.put("isInMultiWindowMode", Boolean.valueOf(z));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onNewIntent(@Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72985207")) {
            ipChange.ipc$dispatch("72985207", new Object[]{this, intent});
            return;
        }
        Event event = new Event(ActivityEvent.ON_ACTIVITY_NEW_INTENT);
        HashMap hashMap = new HashMap(2);
        hashMap.put(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927653554")) {
            ipChange.ipc$dispatch("-927653554", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Event event = new Event(ViewPagerEvent.ON_PAGER_SCROLL_STATE_CHANGED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("state", Integer.valueOf(i));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662049261")) {
            ipChange.ipc$dispatch("1662049261", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        Event event = new Event(ViewPagerEvent.ON_PAGER_SCROLLED);
        HashMap hashMap = new HashMap(4);
        hashMap.put("position", Integer.valueOf(i));
        hashMap.put("positionOffset", Float.valueOf(f));
        hashMap.put("positionOffsetPixels", Integer.valueOf(i2));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700339687")) {
            ipChange.ipc$dispatch("-700339687", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Event event = new Event(ViewPagerEvent.ON_PAGER_SELECTED);
        HashMap hashMap = new HashMap(2);
        hashMap.put("position", Integer.valueOf(i));
        event.data = hashMap;
        this.eventBus.post(event);
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895796896")) {
            ipChange.ipc$dispatch("-895796896", new Object[]{this});
        } else {
            this.eventBus.post(new Event(ActivityEvent.ON_ACTIVITY_PAUSE));
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352113497")) {
            ipChange.ipc$dispatch("-352113497", new Object[]{this});
        } else {
            this.eventBus.post(new Event(ActivityEvent.ON_ACTIVITY_RESUME));
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852692108")) {
            ipChange.ipc$dispatch("-852692108", new Object[]{this});
        } else {
            this.eventBus.post(new Event("EventBus://activity/notification/on_activity_start"));
        }
    }

    @Override // com.youku.arch.v3.page.ActivityInterceptor
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924953202")) {
            ipChange.ipc$dispatch("1924953202", new Object[]{this});
        } else {
            this.eventBus.post(new Event("EventBus://activity/notification/on_activity_stop"));
        }
    }
}
