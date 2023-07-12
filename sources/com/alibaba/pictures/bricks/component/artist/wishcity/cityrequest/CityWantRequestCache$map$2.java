package com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CityWantRequestCache$map$2 extends Lambda implements Function0<Map<String, Long>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final CityWantRequestCache$map$2 INSTANCE = new CityWantRequestCache$map$2();

    CityWantRequestCache$map$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<String, Long> invoke() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1130873956") ? (Map) ipChange.ipc$dispatch("-1130873956", new Object[]{this}) : new LinkedHashMap();
    }
}
