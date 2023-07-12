package com.youku.gaiax.impl.utils;

import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import java.util.List;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0005\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/impl/utils/GaiaXUtils;", "", "", "isAppPublishVersion$delegate", "Lkotlin/Lazy;", "isAppPublishVersion", "()Z", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXUtils {
    @NotNull
    public static final GaiaXUtils INSTANCE = new GaiaXUtils();
    @NotNull
    private static final Lazy isAppPublishVersion$delegate;

    static {
        Lazy b;
        b = C8177b.b(new Function0<Boolean>() { // from class: com.youku.gaiax.impl.utils.GaiaXUtils$isAppPublishVersion$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                String appVersionName;
                List t0;
                IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                t0 = StringsKt__StringsKt.t0((app2 == null || (appVersionName = app2.getAppVersionName()) == null) ? "" : appVersionName, new String[]{"."}, false, 0, 6, null);
                return Boolean.valueOf(t0.size() == 3);
            }
        });
        isAppPublishVersion$delegate = b;
    }

    private GaiaXUtils() {
    }

    public final boolean isAppPublishVersion() {
        return ((Boolean) isAppPublishVersion$delegate.getValue()).booleanValue();
    }
}
