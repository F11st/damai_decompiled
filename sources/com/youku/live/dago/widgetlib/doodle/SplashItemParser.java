package com.youku.live.dago.widgetlib.doodle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SplashItemParser<ItemRawType, CanvasSizeRawType> {
    @Nullable
    List<SplashScheduler.SplashItem> parse(ItemRawType itemrawtype);

    @Nullable
    List<SplashScheduler.SplashItem> parse(@NonNull ItemRawType itemrawtype, List<SplashScheduler.SplashItem> list);

    @Nullable
    int[] parseCanvasSize(@NonNull CanvasSizeRawType canvassizerawtype);

    @Nullable
    int[] parseCanvasSize(@NonNull CanvasSizeRawType canvassizerawtype, int[] iArr);
}
