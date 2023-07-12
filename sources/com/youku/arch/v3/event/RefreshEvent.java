package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/youku/arch/v3/event/RefreshEvent;", "", "", "PRE_REFRESH", "Ljava/lang/String;", "ON_HEADER_MOVING", "ON_HEADER_RELEASED", "ON_HEADER_FINISH", "ON_HEADER_START_ANIMATOR", "ON_FOOTER_MOVING", "ON_FOOTER_RELEASED", "ON_FOOTER_FINISH", "ON_FOOTER_START_ANIMATOR", "ON_LOAD_MORE", "ON_REFRESH", "ON_REFRESH_STATE_CHANGED", "ON_API_RESPONSE", "PULL_DOWN_REFRESH_FINISH", "PULL_DOWN_REFRESH", "START_REFRESH_LOAD", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RefreshEvent {
    @NotNull
    public static final RefreshEvent INSTANCE = new RefreshEvent();
    @NotNull
    public static final String ON_API_RESPONSE = "EventBus://refresh/notification/on_api_response";
    @NotNull
    public static final String ON_FOOTER_FINISH = "EventBus://refresh/notification/on_footer_finish";
    @NotNull
    public static final String ON_FOOTER_MOVING = "EventBus://refresh/notification/on_footer_moving";
    @NotNull
    public static final String ON_FOOTER_RELEASED = "EventBus://refresh/notification/on_footer_released";
    @NotNull
    public static final String ON_FOOTER_START_ANIMATOR = "EventBus://refresh/notification/on_footer_start_animator";
    @NotNull
    public static final String ON_HEADER_FINISH = "EventBus://refresh/notification/on_header_finish";
    @NotNull
    public static final String ON_HEADER_MOVING = "EventBus://refresh/notification/on_header_moving";
    @NotNull
    public static final String ON_HEADER_RELEASED = "EventBus://refresh/notification/on_header_released";
    @NotNull
    public static final String ON_HEADER_START_ANIMATOR = "EventBus://refresh/notification/on_header_start_animator";
    @NotNull
    public static final String ON_LOAD_MORE = "EventBus://refresh/notification/on_load_more";
    @NotNull
    public static final String ON_REFRESH = "EventBus://refresh/notification/on_refresh";
    @NotNull
    public static final String ON_REFRESH_STATE_CHANGED = "EventBus://refresh/notification/on_refresh_state_changed";
    @NotNull
    private static final String PRE_REFRESH = "EventBus://refresh/";
    @NotNull
    public static final String PULL_DOWN_REFRESH = "pull_down_refresh";
    @NotNull
    public static final String PULL_DOWN_REFRESH_FINISH = "pull_down_refresh_finish";
    @NotNull
    public static final String START_REFRESH_LOAD = "start_refresh_load";

    private RefreshEvent() {
    }
}
