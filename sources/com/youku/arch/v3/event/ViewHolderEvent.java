package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/event/ViewHolderEvent;", "", "", "ON_VIEW_CREATE", "Ljava/lang/String;", "ON_VIEW_ATTACHED_TO_WINDOW", "ON_VIEW_DETACHED_FROM_WINDOW", "ON_VIEW_SELECTED", "ON_RECYCLED", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ViewHolderEvent {
    @NotNull
    public static final ViewHolderEvent INSTANCE = new ViewHolderEvent();
    @NotNull
    public static final String ON_RECYCLED = "onRecycled";
    @NotNull
    public static final String ON_VIEW_ATTACHED_TO_WINDOW = "onViewAttachedToWindow";
    @NotNull
    public static final String ON_VIEW_CREATE = "onViewCreate";
    @NotNull
    public static final String ON_VIEW_DETACHED_FROM_WINDOW = "onViewDetachedFromWindow";
    @NotNull
    public static final String ON_VIEW_SELECTED = "onViewSelected";

    private ViewHolderEvent() {
    }
}
