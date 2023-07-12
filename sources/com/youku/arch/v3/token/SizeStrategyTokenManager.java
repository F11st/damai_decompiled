package com.youku.arch.v3.token;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "Lcom/youku/arch/v3/token/StrategyTokenManager;", "Lcom/youku/arch/v3/token/SizeTokenValue;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SizeStrategyTokenManager extends StrategyTokenManager<SizeTokenValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<SizeStrategyTokenManager> instance$delegate;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/token/SizeStrategyTokenManager$Companion;", "", "Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "instance", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final SizeStrategyTokenManager getInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1565395325") ? (SizeStrategyTokenManager) ipChange.ipc$dispatch("-1565395325", new Object[]{this}) : (SizeStrategyTokenManager) SizeStrategyTokenManager.instance$delegate.getValue();
        }
    }

    static {
        Lazy<SizeStrategyTokenManager> a;
        a = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SizeStrategyTokenManager>() { // from class: com.youku.arch.v3.token.SizeStrategyTokenManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SizeStrategyTokenManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1903835039") ? (SizeStrategyTokenManager) ipChange.ipc$dispatch("-1903835039", new Object[]{this}) : new SizeStrategyTokenManager();
            }
        });
        instance$delegate = a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.arch.v3.token.StrategyTokenManager
    @NotNull
    public SizeTokenValue parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        HashMap<String, Object> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241097245")) {
            return (SizeTokenValue) ipChange.ipc$dispatch("1241097245", new Object[]{this, context, strategyTokenJavaBean});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(strategyTokenJavaBean, "raw");
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        Object obj = (hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null) ? null : hashMap.get("value");
        SizeTokenValue sizeTokenValue = obj instanceof SizeTokenValue ? (SizeTokenValue) obj : null;
        SizeTokenValue sizeTokenValue2 = sizeTokenValue != null ? sizeTokenValue : null;
        return sizeTokenValue2 == null ? new SizeTokenValue() : sizeTokenValue2;
    }
}
