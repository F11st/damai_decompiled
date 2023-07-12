package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/youku/arch/v3/event/FragmentEvent;", "", "", "PRE_FRAGMENT", "Ljava/lang/String;", "ON_FRAGMENT_USER_VISIBLE_HINT", "ON_FRAGMENT_ATTACH", "ON_FRAGMENT_DETACH", "ON_FRAGMENT_CREATE_VIEW", "ON_FRAGMENT_DESTROY_VIEW", "ON_FRAGMENT_VIEW_CREATED", "ON_FRAGMENT_ACTIVITY_CREATED", "ON_FRAGMENT_HIDDEN_CHANGED", "ON_FRAGMENT_INFLATE", "ON_FRAGMENT_START", "ON_FRAGMENT_STOP", "ON_FRAGMENT_PAUSE", "ON_FRAGMENT_RESUME", "ON_FRAGMENT_CREATE", "ON_FRAGMENT_DESTROY", "ON_FRAGMENT_SAVE_INSTANCE_STATE", "ON_FRAGMENT_MULTI_WINDOW_MODE_CHANGED", "ON_FRAGMENT_CONFIGURATION_CHANGED", "ON_FRAGMENT_VIEW_STATE_RESTORED", "ON_FRAGMENT_LOW_MEMORY", "ON_FRAGMENT_CONTENT_VIEW_INFLATE", "ON_FRAGMENT_RECYCLERVIEW_SCROLL", "ON_FRAGMENT_RECYCLERVIEW_SCROLL_DOWN", "ON_PAGE_SELECTED", "KEY_FRAGMENT_VISIBLE_STATE", FragmentEvent.ON_GALLERY_PALETTE_CHANGED, "ON_FRAGMENT_RECYCLERVIEW_SCROLL_IDLE", "ON_FRAGMENT_RECYCLERVIEW_SCROLL_DRAGGING", "ON_PARENT_STYLE_CHANGED", "ON_RESPONSE_INTERCEPTOR", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FragmentEvent {
    @NotNull
    public static final FragmentEvent INSTANCE = new FragmentEvent();
    @NotNull
    public static final String KEY_FRAGMENT_VISIBLE_STATE = "key_fragment_visible_state";
    @NotNull
    public static final String ON_FRAGMENT_ACTIVITY_CREATED = "EventBus://fragment/notification/on_fragment_activity_created";
    @NotNull
    public static final String ON_FRAGMENT_ATTACH = "EventBus://fragment/notification/on_fragment_attach";
    @NotNull
    public static final String ON_FRAGMENT_CONFIGURATION_CHANGED = "EventBus://fragment/notification/on_fragment_configuration_changed";
    @NotNull
    public static final String ON_FRAGMENT_CONTENT_VIEW_INFLATE = "EventBus://fragment/notification/on_fragment_content_view_inflate";
    @NotNull
    public static final String ON_FRAGMENT_CREATE = "EventBus://fragment/notification/on_fragment_create";
    @NotNull
    public static final String ON_FRAGMENT_CREATE_VIEW = "EventBus://fragment/notification/on_fragment_create_view";
    @NotNull
    public static final String ON_FRAGMENT_DESTROY = "EventBus://fragment/notification/on_fragment_destroy";
    @NotNull
    public static final String ON_FRAGMENT_DESTROY_VIEW = "EventBus://fragment/notification/on_fragment_destroy_view";
    @NotNull
    public static final String ON_FRAGMENT_DETACH = "EventBus://fragment/notification/on_fragment_detach";
    @NotNull
    public static final String ON_FRAGMENT_HIDDEN_CHANGED = "EventBus://fragment/notification/on_fragment_hidden_changed";
    @NotNull
    public static final String ON_FRAGMENT_INFLATE = "EventBus://fragment/notification/on_fragment_inflate";
    @NotNull
    public static final String ON_FRAGMENT_LOW_MEMORY = "EventBus://fragment/notification/on_fragment_low_memory";
    @NotNull
    public static final String ON_FRAGMENT_MULTI_WINDOW_MODE_CHANGED = "EventBus://fragment/notification/on_fragment_multi_window_mode_changed";
    @NotNull
    public static final String ON_FRAGMENT_PAUSE = "EventBus://fragment/notification/on_fragment_pause";
    @NotNull
    public static final String ON_FRAGMENT_RECYCLERVIEW_SCROLL = "EventBus://fragment/notification/on_fragment_recyclerview_scroll";
    @NotNull
    public static final String ON_FRAGMENT_RECYCLERVIEW_SCROLL_DOWN = "EventBus://fragment/notification/on_fragment_recyclerview_scroll_down";
    @NotNull
    public static final String ON_FRAGMENT_RECYCLERVIEW_SCROLL_DRAGGING = "EventBus://fragment/notification/on_fragment_recyclerview_scroll_dragging";
    @NotNull
    public static final String ON_FRAGMENT_RECYCLERVIEW_SCROLL_IDLE = "EventBus://fragment/notification/on_fragment_recyclerview_scroll_idle";
    @NotNull
    public static final String ON_FRAGMENT_RESUME = "EventBus://fragment/notification/on_fragment_resume";
    @NotNull
    public static final String ON_FRAGMENT_SAVE_INSTANCE_STATE = "EventBus://fragment/notification/on_fragment_save_instance_state";
    @NotNull
    public static final String ON_FRAGMENT_START = "EventBus://fragment/notification/on_fragment_start";
    @NotNull
    public static final String ON_FRAGMENT_STOP = "EventBus://fragment/notification/on_fragment_stop";
    @NotNull
    public static final String ON_FRAGMENT_USER_VISIBLE_HINT = "EventBus://fragment/notification/on_fragment_user_visible_hint";
    @NotNull
    public static final String ON_FRAGMENT_VIEW_CREATED = "EventBus://fragment/notification/on_fragment_view_created";
    @NotNull
    public static final String ON_FRAGMENT_VIEW_STATE_RESTORED = "EventBus://fragment/notification/on_fragment_view_state_restored";
    @NotNull
    public static final String ON_GALLERY_PALETTE_CHANGED = "ON_GALLERY_PALETTE_CHANGED";
    @NotNull
    public static final String ON_PAGE_SELECTED = "EventBus://fragment/notification/on_page_selected";
    @NotNull
    public static final String ON_PARENT_STYLE_CHANGED = "EventBus://fragment/notification/on_parent_style_changed";
    @NotNull
    public static final String ON_RESPONSE_INTERCEPTOR = "EventBus://fragment/notification/on_response_interceptor";
    @NotNull
    private static final String PRE_FRAGMENT = "EventBus://fragment/";

    private FragmentEvent() {
    }
}
