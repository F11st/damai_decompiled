package com.alient.resource.token;

import android.content.Context;
import android.content.res.Resources;
import com.alient.resource.util.ResUtil;
import com.youku.arch.v3.data.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.m80;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/alient/resource/token/RatioStrategyTokenManager;", "Lcom/alient/resource/token/StrategyTokenManager;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alient/resource/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "(Landroid/content/Context;Lcom/alient/resource/token/StrategyTokenJavaBean;)Ljava/lang/Float;", "<init>", "()V", "Companion", "oneresource_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes10.dex */
public final class RatioStrategyTokenManager extends StrategyTokenManager<Float> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NOT_SUPPORT = -1;
    @NotNull
    private static final Lazy instance$delegate;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/alient/resource/token/RatioStrategyTokenManager$Companion;", "", "Lcom/alient/resource/token/RatioStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/resource/token/RatioStrategyTokenManager;", "instance", "", "NOT_SUPPORT", "I", "<init>", "()V", "oneresource_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RatioStrategyTokenManager getInstance() {
            Lazy lazy = RatioStrategyTokenManager.instance$delegate;
            Companion companion = RatioStrategyTokenManager.Companion;
            return (RatioStrategyTokenManager) lazy.getValue();
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    static {
        Lazy a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<RatioStrategyTokenManager>() { // from class: com.alient.resource.token.RatioStrategyTokenManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RatioStrategyTokenManager invoke() {
                return new RatioStrategyTokenManager();
            }
        });
        instance$delegate = a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alient.resource.token.StrategyTokenManager
    @NotNull
    public Float parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        float f;
        HashMap<String, Object> hashMap;
        boolean K;
        boolean K2;
        int i;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(strategyTokenJavaBean, "raw");
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        if (hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null || hashMap.get("value") == null) {
            f = 0.0f;
        } else {
            String obj = toString();
            K = StringsKt__StringsKt.K(obj, "$", false, 2, null);
            if (K) {
                Resources resources = context.getResources();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring = obj.substring(1);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                i = resources.getDimensionPixelOffset(ResUtil.getIdentifier(context, substring, Constants.DIMEN));
            } else {
                K2 = StringsKt__StringsKt.K(obj, m80.DINAMIC_PREFIX_AT, false, 2, null);
                if (K2) {
                    i = -1;
                } else {
                    f = Float.parseFloat(obj);
                }
            }
            f = i;
        }
        return Float.valueOf(f);
    }
}
