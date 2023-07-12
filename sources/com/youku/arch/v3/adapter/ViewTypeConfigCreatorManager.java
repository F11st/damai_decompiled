package com.youku.arch.v3.adapter;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.youku.arch.v3.core.TypeRange;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/adapter/ViewTypeConfigCreatorManager;", "", "Lcom/youku/arch/v3/core/TypeRange;", "typeRange", "Lcom/youku/arch/v3/adapter/ViewTypeConfigCreator;", "viewTypeConfigCreator", "Ltb/wt2;", "register", MiPushClient.COMMAND_UNREGISTER, "", "type", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "create", "", "viewTypeConfigCreators", "Ljava/util/Map;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ViewTypeConfigCreatorManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Map<TypeRange, ViewTypeConfigCreator> viewTypeConfigCreators = new LinkedHashMap();

    @Nullable
    public final ViewTypeConfig create(int i) {
        ViewTypeConfig viewTypeConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012350140")) {
            return (ViewTypeConfig) ipChange.ipc$dispatch("1012350140", new Object[]{this, Integer.valueOf(i)});
        }
        Iterator<T> it = this.viewTypeConfigCreators.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TypeRange typeRange = (TypeRange) it.next();
            if (i <= typeRange.getTypeEnd() && typeRange.getTypeStart() <= i) {
                ViewTypeConfigCreator viewTypeConfigCreator = this.viewTypeConfigCreators.get(typeRange);
                viewTypeConfig = viewTypeConfigCreator != null ? viewTypeConfigCreator.create(i) : null;
                if (viewTypeConfig != null) {
                    break;
                }
            }
        }
        return viewTypeConfig;
    }

    public final void register(@NotNull TypeRange typeRange, @NotNull ViewTypeConfigCreator viewTypeConfigCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925542387")) {
            ipChange.ipc$dispatch("1925542387", new Object[]{this, typeRange, viewTypeConfigCreator});
            return;
        }
        b41.i(typeRange, "typeRange");
        b41.i(viewTypeConfigCreator, "viewTypeConfigCreator");
        this.viewTypeConfigCreators.put(typeRange, viewTypeConfigCreator);
    }

    public final void unregister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312878984")) {
            ipChange.ipc$dispatch("312878984", new Object[]{this});
        } else {
            this.viewTypeConfigCreators.clear();
        }
    }
}
