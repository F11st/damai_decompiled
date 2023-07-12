package com.youku.gaiax;

import com.taobao.weex.common.Constants;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/youku/gaiax/IGaiaXApi;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Ltb/wt2;", "reloadView", "bindView", "unbindView", "visibleView", "invisibleView", "visiblePage", "invisiblePage", "Lcom/youku/gaiax/IExperiment;", "experiment", "Lcom/youku/gaiax/IStable;", Constants.Name.STABLE, "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IGaiaXApi {
    void bindView(@NotNull GaiaX.Params params);

    @Nullable
    IExperiment experiment();

    void invisiblePage(@NotNull GaiaX.Params params);

    void invisibleView(@NotNull GaiaX.Params params);

    void reloadView(@NotNull GaiaX.Params params);

    @Nullable
    IStable stable();

    void unbindView(@NotNull GaiaX.Params params);

    void visiblePage(@NotNull GaiaX.Params params);

    void visibleView(@NotNull GaiaX.Params params);
}
