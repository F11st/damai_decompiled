package com.youku.arch.v3.creator;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.TypeRange;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "", "Lcom/youku/arch/v3/core/TypeRange;", "typeRange", "Lcom/youku/arch/v3/creator/ComponentCreator;", "componentCreator", "Ltb/wt2;", "register", MiPushClient.COMMAND_UNREGISTER, "", "type", "", "isSupport", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", Constants.CONFIG, "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "create", "", "componentCreators", "Ljava/util/Map;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ComponentCreatorManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Map<TypeRange, ComponentCreator> componentCreators = new LinkedHashMap();

    @Nullable
    public final IComponent<ComponentValue> create(@NotNull Config<Node> config) {
        IComponent<ComponentValue> iComponent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "523862999")) {
            return (IComponent) ipChange.ipc$dispatch("523862999", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        Iterator<T> it = this.componentCreators.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TypeRange typeRange = (TypeRange) it.next();
            int typeStart = typeRange.getTypeStart();
            int typeEnd = typeRange.getTypeEnd();
            int type = config.getType();
            if (typeStart <= type && type <= typeEnd) {
                ComponentCreator componentCreator = this.componentCreators.get(typeRange);
                iComponent = componentCreator != null ? componentCreator.create(config) : null;
                if (iComponent != null) {
                    break;
                }
            }
        }
        return iComponent;
    }

    public final boolean isSupport(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133410349")) {
            return ((Boolean) ipChange.ipc$dispatch("133410349", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        for (TypeRange typeRange : this.componentCreators.keySet()) {
            if (i >= typeRange.getTypeStart() && i <= typeRange.getTypeEnd()) {
                return true;
            }
        }
        return false;
    }

    public final void register(@NotNull TypeRange typeRange, @NotNull ComponentCreator componentCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457735385")) {
            ipChange.ipc$dispatch("-1457735385", new Object[]{this, typeRange, componentCreator});
            return;
        }
        b41.i(typeRange, "typeRange");
        b41.i(componentCreator, "componentCreator");
        this.componentCreators.put(typeRange, componentCreator);
    }

    public final void unregister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686464273")) {
            ipChange.ipc$dispatch("-1686464273", new Object[]{this});
        } else {
            this.componentCreators.clear();
        }
    }
}
