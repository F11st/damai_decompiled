package com.alient.onearch.adapter.component.footer;

import android.util.SparseArray;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "", "", "pageName", "", "componentId", "Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegate;", "componentFooterDelegate", "Ltb/wt2;", "register", MiPushClient.COMMAND_UNREGISTER, "Landroid/util/SparseArray;", "getComponentFooterDelegates", "", "delegatesMap", "Ljava/util/Map;", "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentFooterDelegateManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<ComponentFooterDelegateManager> instance$delegate;
    @NotNull
    private final Map<String, SparseArray<ComponentFooterDelegate>> delegatesMap = new HashMap();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager$Companion;", "", "Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "instance", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final ComponentFooterDelegateManager getInstance() {
            return (ComponentFooterDelegateManager) ComponentFooterDelegateManager.instance$delegate.getValue();
        }
    }

    static {
        Lazy<ComponentFooterDelegateManager> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ComponentFooterDelegateManager>() { // from class: com.alient.onearch.adapter.component.footer.ComponentFooterDelegateManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ComponentFooterDelegateManager invoke() {
                return new ComponentFooterDelegateManager();
            }
        });
        instance$delegate = a;
    }

    @Nullable
    public final SparseArray<ComponentFooterDelegate> getComponentFooterDelegates(@NotNull String str) {
        b41.i(str, "pageName");
        return this.delegatesMap.get(str);
    }

    public final void register(@NotNull String str, int i, @NotNull ComponentFooterDelegate componentFooterDelegate) {
        b41.i(str, "pageName");
        b41.i(componentFooterDelegate, "componentFooterDelegate");
        if (this.delegatesMap.containsKey(str)) {
            SparseArray<ComponentFooterDelegate> sparseArray = this.delegatesMap.get(str);
            if (sparseArray == null) {
                return;
            }
            sparseArray.put(i, componentFooterDelegate);
            return;
        }
        SparseArray<ComponentFooterDelegate> sparseArray2 = new SparseArray<>();
        sparseArray2.put(i, componentFooterDelegate);
        this.delegatesMap.put(str, sparseArray2);
    }

    public final void unregister(@NotNull String str) {
        b41.i(str, "pageName");
        this.delegatesMap.remove(str);
    }
}
