package com.youku.style;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IStyleContainer<STYLE extends Map> {
    @Nullable
    IStyleManager<STYLE> getStyleManager();
}
