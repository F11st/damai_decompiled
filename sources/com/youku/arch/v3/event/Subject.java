package com.youku.arch.v3.event;

import com.alibaba.motu.crashreporter.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/event/Subject;", "", "", "ACTIVITY", "Ljava/lang/String;", "FRAGMENT", Constants.PAGE, "MODULE", "COMPONENT", "ITEM", "REFRESH", "VIEWPAGER", "BUSINESS", "FUNCTION", "EXCEPTION", "LOADER", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Subject {
    @NotNull
    public static final String ACTIVITY = "activity";
    @NotNull
    public static final String BUSINESS = "business";
    @NotNull
    public static final String COMPONENT = "component";
    @NotNull
    public static final String EXCEPTION = "exception";
    @NotNull
    public static final String FRAGMENT = "fragment";
    @NotNull
    public static final String FUNCTION = "function";
    @NotNull
    public static final Subject INSTANCE = new Subject();
    @NotNull
    public static final String ITEM = "item";
    @NotNull
    public static final String LOADER = "exception";
    @NotNull
    public static final String MODULE = "module";
    @NotNull
    public static final String PAGE = "page";
    @NotNull
    public static final String REFRESH = "refresh";
    @NotNull
    public static final String VIEWPAGER = "viewpager";

    private Subject() {
    }
}
