package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/event/ComponentEvent;", "", "", "PRE_COMPONENT", "Ljava/lang/String;", "ON_COMPONENT_ROUTE_EVENT", "ON_COMPONENT_CHANGE_CONTENT", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ComponentEvent {
    @NotNull
    public static final ComponentEvent INSTANCE = new ComponentEvent();
    @NotNull
    public static final String ON_COMPONENT_CHANGE_CONTENT = "EventBus://component/notification/change_content";
    @NotNull
    public static final String ON_COMPONENT_ROUTE_EVENT = "EventBus://component/request/route_event";
    @NotNull
    private static final String PRE_COMPONENT = "EventBus://component/";

    private ComponentEvent() {
    }
}
