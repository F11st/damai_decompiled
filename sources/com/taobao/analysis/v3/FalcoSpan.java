package com.taobao.analysis.v3;

import androidx.annotation.NonNull;
import com.taobao.opentracing.api.Span;
import tb.ph2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface FalcoSpan extends Span {
    public static final ph2 ERROR_CODE = new ph2("errorCode");

    FalcoStage customStage(@NonNull String str);

    void debugLog(String str);

    void finish(long j, String str);

    void finish(String str);

    String getLayer();

    String getModule();

    String getScene();

    void releaseLog(String str);
}
