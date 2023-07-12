package tb;

import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.ability.middleware.IAbilityInvoker;
import com.alibaba.ability.middleware.IAbilityMiddleware;
import com.taobao.analysis.v3.FalcoSpanLayer;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.AbstractEditComponent;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class qf1 implements IAbilityInvoker {
    @NotNull
    public static final a Companion = new a(null);
    private final IAbilityMiddleware a;
    private final IAbilityInvoker b;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        @JvmStatic
        @NotNull
        public final IAbilityInvoker a(@NotNull List<? extends IAbilityMiddleware> list, @NotNull IAbilityInvoker iAbilityInvoker) {
            List<IAbilityMiddleware> o0;
            b41.i(list, "middlewares");
            b41.i(iAbilityInvoker, "final");
            o0 = CollectionsKt___CollectionsKt.o0(list);
            for (IAbilityMiddleware iAbilityMiddleware : o0) {
                iAbilityInvoker = new qf1(iAbilityMiddleware, iAbilityInvoker);
            }
            return iAbilityInvoker;
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public qf1(@NotNull IAbilityMiddleware iAbilityMiddleware, @NotNull IAbilityInvoker iAbilityInvoker) {
        b41.i(iAbilityMiddleware, "middleware");
        b41.i(iAbilityInvoker, AbstractEditComponent.ReturnTypes.NEXT);
        this.a = iAbilityMiddleware;
        this.b = iAbilityInvoker;
    }

    @Override // com.alibaba.ability.middleware.IAbilityInvoker
    @Nullable
    public jg0 invoke(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
        b41.i(str, FalcoSpanLayer.ABILITY);
        b41.i(str2, "api");
        b41.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(map, "params");
        b41.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
        return this.a.invoke(str, str2, iAbilityContext, map, iOnCallbackListener, this.b);
    }
}
