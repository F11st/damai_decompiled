package com.alibaba.ability.utils;

import com.taobao.orange.OrangeConfig;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class OrangeUtils {
    @NotNull
    public static final OrangeUtils INSTANCE = new OrangeUtils();
    private static final Lazy a;

    static {
        Lazy b;
        b = b.b(new Function0<Boolean>() { // from class: com.alibaba.ability.utils.OrangeUtils$sHasOrange$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                try {
                    OrangeConfig.getInstance();
                    return true;
                } catch (NoClassDefFoundError unused) {
                    return false;
                }
            }
        });
        a = b;
    }

    private OrangeUtils() {
    }

    private static final boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        if (a()) {
            return b41.d("true", OrangeConfig.getInstance().getConfig("megability", "userMegaScheduler", "true"));
        }
        return false;
    }
}
