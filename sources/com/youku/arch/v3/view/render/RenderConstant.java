package com.youku.arch.v3.view.render;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/view/render/RenderConstant;", "Ljava/io/Serializable;", "", "GLOBAL", "Ljava/lang/String;", "", "NOT_TRY", "I", "NOT_SUPPORT", "IN_USE", "STATE_INIT_INSTANCE", "STATE_CREATE_VIEW", "STATE_SET_DATA", "STATE_LOAD_SUCCESS", "STATE_LOAD_FAILED", "STATE_IN_CACHE", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RenderConstant implements Serializable {
    @NotNull
    public static final String GLOBAL = "global";
    @NotNull
    public static final RenderConstant INSTANCE = new RenderConstant();
    public static final int IN_USE = 1;
    public static final int NOT_SUPPORT = 0;
    public static final int NOT_TRY = -1;
    public static final int STATE_CREATE_VIEW = 2;
    public static final int STATE_INIT_INSTANCE = 1;
    public static final int STATE_IN_CACHE = 6;
    public static final int STATE_LOAD_FAILED = 5;
    public static final int STATE_LOAD_SUCCESS = 4;
    public static final int STATE_SET_DATA = 3;

    private RenderConstant() {
    }
}
