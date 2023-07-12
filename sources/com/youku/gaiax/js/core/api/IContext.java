package com.youku.gaiax.js.core.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/js/core/api/IContext;", "", "Ltb/wt2;", "initContext", "", "script", "evaluateJS", "destroyContext", "module", "initModule", "initBootstrap", "startBootstrap", "initPendingJob", "destroyPendingJob", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IContext {
    void destroyContext();

    void destroyPendingJob();

    void evaluateJS(@NotNull String str);

    void initBootstrap();

    void initContext();

    void initModule(@NotNull String str);

    void initPendingJob();

    void startBootstrap();
}
