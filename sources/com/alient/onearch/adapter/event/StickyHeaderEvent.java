package com.alient.onearch.adapter.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/event/StickyHeaderEvent;", "", "", "PRE_STICKY_HEADER", "Ljava/lang/String;", "ON_STICKY", "ON_UN_STICKY", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class StickyHeaderEvent {
    @NotNull
    public static final StickyHeaderEvent INSTANCE = new StickyHeaderEvent();
    @NotNull
    public static final String ON_STICKY = "EventBus://business/notification/on_sticky";
    @NotNull
    public static final String ON_UN_STICKY = "EventBus://business/notification/on_un_sticky";
    @NotNull
    private static final String PRE_STICKY_HEADER = "EventBus://business/";

    private StickyHeaderEvent() {
    }
}
