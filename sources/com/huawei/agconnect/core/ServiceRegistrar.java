package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ServiceRegistrar {
    List<Service> getServices(Context context);

    void initialize(Context context);
}
