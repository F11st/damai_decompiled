package com.youku.arch.v3.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/event/ArchExceptionEvent;", "", "", "PRE_EXCEPTION", "Ljava/lang/String;", "MODULE_CHILDREN_EMPTY", "COMPONENT_CHILDREN_EMPTY", "ITEM_DATA_EMPTY", "COMPONENT_NOT_SUPPORT", "COMPONENT_RENDER_FAILED", "COROUTINE_RUN_FAILED", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ArchExceptionEvent {
    @NotNull
    public static final String COMPONENT_CHILDREN_EMPTY = "EventBus://exception//ComponentChildrenEmpty";
    @NotNull
    public static final String COMPONENT_NOT_SUPPORT = "EventBus://exception//ComponentNotSupport";
    @NotNull
    public static final String COMPONENT_RENDER_FAILED = "EventBus://exception//ComponentRenderFailed";
    @NotNull
    public static final String COROUTINE_RUN_FAILED = "EventBus://exception//CoroutineRunFailed";
    @NotNull
    public static final ArchExceptionEvent INSTANCE = new ArchExceptionEvent();
    @NotNull
    public static final String ITEM_DATA_EMPTY = "EventBus://exception//ItemDataEmpty";
    @NotNull
    public static final String MODULE_CHILDREN_EMPTY = "EventBus://exception//ModuleChildrenEmpty";
    @NotNull
    private static final String PRE_EXCEPTION = "EventBus://exception/";

    private ArchExceptionEvent() {
    }
}
