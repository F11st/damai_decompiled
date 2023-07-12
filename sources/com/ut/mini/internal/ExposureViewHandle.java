package com.ut.mini.internal;

import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ExposureViewHandle {
    Map<String, String> getExposureViewProperties(String str, View view);

    ExposureViewTag getExposureViewTag(String str, View view);

    boolean isExposureView(String str, View view);
}
