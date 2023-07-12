package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/event/ContainerEvent;", "", "", "PRE_CONTAINER", "Ljava/lang/String;", "ON_ACTIVITY_START", "ON_ACTIVITY_STOP", "ON_PAGE_ACTIVATE", "KEY_STATE", "ON_PAGE_CONFIGURATION_CHANGED", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ContainerEvent {
    @NotNull
    public static final ContainerEvent INSTANCE = new ContainerEvent();
    @NotNull
    public static final String KEY_STATE = "state";
    @NotNull
    public static final String ON_ACTIVITY_START = "EventBus://activity/notification/on_activity_start";
    @NotNull
    public static final String ON_ACTIVITY_STOP = "EventBus://activity/notification/on_activity_stop";
    @NotNull
    public static final String ON_PAGE_ACTIVATE = "pageActivate";
    @NotNull
    public static final String ON_PAGE_CONFIGURATION_CHANGED = "EventBus://activity/notification/on_configuration_changed";
    @NotNull
    private static final String PRE_CONTAINER = "EventBus://activity/";

    private ContainerEvent() {
    }
}
