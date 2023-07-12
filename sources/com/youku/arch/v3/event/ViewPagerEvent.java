package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/event/ViewPagerEvent;", "", "", "PRE_VIEWPAGER", "Ljava/lang/String;", "ON_PAGER_SCROLLED", "ON_PAGER_SELECTED", "ON_PAGER_SCROLL_STATE_CHANGED", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ViewPagerEvent {
    @NotNull
    public static final ViewPagerEvent INSTANCE = new ViewPagerEvent();
    @NotNull
    public static final String ON_PAGER_SCROLLED = "EventBus://viewpager/notification/on_page_scrolled";
    @NotNull
    public static final String ON_PAGER_SCROLL_STATE_CHANGED = "EventBus://viewpager/notification/on_page_scroll_state_changed";
    @NotNull
    public static final String ON_PAGER_SELECTED = "EventBus://viewpager/notification/on_page_selected";
    @NotNull
    private static final String PRE_VIEWPAGER = "EventBus://viewpager/";

    private ViewPagerEvent() {
    }
}
