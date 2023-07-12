package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/youku/arch/v3/event/ActivityEvent;", "", "", "PRE_ACTIVITY", "Ljava/lang/String;", "ON_ACTIVITY_START", "ON_ACTIVITY_STOP", "ON_ACTIVITY_PAUSE", "ON_ACTIVITY_RESUME", "ON_ACTIVITY_CREATE", "ON_ACTIVITY_DESTROY", "ON_ACTIVITY_BACK_PRESS", "ON_ACTIVITY_KEY_DOWN", "ON_ACTIVITY_MULTI_WINDOW_MODE_CHANGED", "ON_ACTIVITY_NEW_INTENT", "ON_ACTIVITY_CONFIGURATION", "KEY_SAVED_INSTANCE_STATE", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ActivityEvent {
    @NotNull
    public static final ActivityEvent INSTANCE = new ActivityEvent();
    @NotNull
    public static final String KEY_SAVED_INSTANCE_STATE = "key_saved_instance_state";
    @NotNull
    public static final String ON_ACTIVITY_BACK_PRESS = "EventBus://activity/notification/on_activity_back_press";
    @NotNull
    public static final String ON_ACTIVITY_CONFIGURATION = "EventBus://activity/notification/on_activity_configuration";
    @NotNull
    public static final String ON_ACTIVITY_CREATE = "EventBus://activity/notification/on_activity_create";
    @NotNull
    public static final String ON_ACTIVITY_DESTROY = "EventBus://activity/notification/on_activity_destroy";
    @NotNull
    public static final String ON_ACTIVITY_KEY_DOWN = "EventBus://activity/notification/on_activity_key_down";
    @NotNull
    public static final String ON_ACTIVITY_MULTI_WINDOW_MODE_CHANGED = "EventBus://activity/notification/on_activity_multi_window_mode_changed";
    @NotNull
    public static final String ON_ACTIVITY_NEW_INTENT = "EventBus://activity/notification/on_activity_new_intent";
    @NotNull
    public static final String ON_ACTIVITY_PAUSE = "EventBus://activity/notification/on_activity_pause";
    @NotNull
    public static final String ON_ACTIVITY_RESUME = "EventBus://activity/notification/on_activity_resume";
    @NotNull
    public static final String ON_ACTIVITY_START = "EventBus://activity/notification/on_activity_start";
    @NotNull
    public static final String ON_ACTIVITY_STOP = "EventBus://activity/notification/on_activity_stop";
    @NotNull
    private static final String PRE_ACTIVITY = "EventBus://activity/";

    private ActivityEvent() {
    }
}
