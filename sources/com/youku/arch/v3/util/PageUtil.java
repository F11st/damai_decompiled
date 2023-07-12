package com.youku.arch.v3.util;

import android.util.SparseArray;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.C8883a;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002JN\u0010\u0014\u001aB\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J\u0016\u0010\u001d\u001a\u00020\u00162\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0011¨\u0006\""}, d2 = {"Lcom/youku/arch/v3/util/PageUtil;", "", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/GenericFactory;", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "Lcom/youku/arch/v3/core/Node;", "getDefaultModuleFactory", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "getDefaultComponentFactory", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "getDefaultItemFactory", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "", "", "getDefaultAdapterFactory", "module", "", "start", "end", "", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "getSubAdapters", "item", "getItemType", Constants.CONFIG, "getItemTypeByConfig", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PageUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final PageUtil INSTANCE = new PageUtil();

    private PageUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> getDefaultAdapterFactory(@NotNull IContext iContext) {
        int size;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-183575563")) {
            return (GenericFactory) ipChange.ipc$dispatch("-183575563", new Object[]{this, iContext});
        }
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        Object f = C8883a.j(Constants.CreatorConfig.CLASS_DEFAULT_ADAPTER_CREATOR).c(iContext).f();
        Objects.requireNonNull(f, "null cannot be cast to non-null type com.youku.arch.v3.ICreator<com.youku.arch.v3.adapter.VBaseAdapter<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>>?, kotlin.collections.Map<kotlin.String, kotlin.Any?>>");
        GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> genericFactory = new GenericFactory<>((ICreator) f);
        ConfigManager configManager = iContext.getConfigManager();
        ConfigManager.CreatorConfig creatorConfig = configManager == null ? null : configManager.getCreatorConfig(4);
        SparseArray<ICreator<?, ?>> creators = creatorConfig == null ? null : creatorConfig.getCreators();
        if (creators != null && creators.size() > 0 && (size = creators.size()) > 0) {
            while (true) {
                int i2 = i + 1;
                if (creators.keyAt(i) == 0) {
                    ICreator<?, ?> valueAt = creators.valueAt(i);
                    genericFactory.setDefaultCreator(valueAt instanceof ICreator ? valueAt : null);
                } else {
                    ICreator<?, ?> valueAt2 = creators.valueAt(i);
                    ICreator<?, ?> iCreator = valueAt2 instanceof ICreator ? valueAt2 : null;
                    if (iCreator != null) {
                        genericFactory.addExtendedCreator(creators.keyAt(i), iCreator);
                    }
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return genericFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GenericFactory<IComponent<ComponentValue>, Node> getDefaultComponentFactory(@NotNull IContext iContext) {
        int size;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-423695069")) {
            return (GenericFactory) ipChange.ipc$dispatch("-423695069", new Object[]{this, iContext});
        }
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        GenericFactory<IComponent<ComponentValue>, Node> genericFactory = new GenericFactory<>((ICreator) C8883a.j(Constants.CreatorConfig.CLASS_DEFAULT_COMPONENT_CREATOR).b().f());
        ConfigManager configManager = iContext.getConfigManager();
        ConfigManager.CreatorConfig creatorConfig = configManager == null ? null : configManager.getCreatorConfig(2);
        SparseArray<ICreator<?, ?>> creators = creatorConfig == null ? null : creatorConfig.getCreators();
        if (creators != null && creators.size() > 0 && (size = creators.size()) > 0) {
            while (true) {
                int i2 = i + 1;
                if (creators.keyAt(i) == 0) {
                    ICreator<?, ?> valueAt = creators.valueAt(i);
                    genericFactory.setDefaultCreator(valueAt instanceof ICreator ? valueAt : null);
                } else {
                    ICreator<?, ?> valueAt2 = creators.valueAt(i);
                    ICreator<?, ?> iCreator = valueAt2 instanceof ICreator ? valueAt2 : null;
                    if (iCreator != null) {
                        genericFactory.addExtendedCreator(creators.keyAt(i), iCreator);
                    }
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return genericFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GenericFactory<IItem<ItemValue>, Node> getDefaultItemFactory(@NotNull IContext iContext) {
        int size;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "500420509")) {
            return (GenericFactory) ipChange.ipc$dispatch("500420509", new Object[]{this, iContext});
        }
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        Object f = C8883a.j(Constants.CreatorConfig.CLASS_DEFAULT_ITEM_CREATOR).b().f();
        Objects.requireNonNull(f, "null cannot be cast to non-null type com.youku.arch.v3.ICreator<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.core.Node>");
        GenericFactory<IItem<ItemValue>, Node> genericFactory = new GenericFactory<>((ICreator) f);
        ConfigManager configManager = iContext.getConfigManager();
        ConfigManager.CreatorConfig creatorConfig = configManager == null ? null : configManager.getCreatorConfig(3);
        SparseArray<ICreator<?, ?>> creators = creatorConfig == null ? null : creatorConfig.getCreators();
        if (creators != null && creators.size() > 0 && (size = creators.size()) > 0) {
            while (true) {
                int i2 = i + 1;
                if (creators.keyAt(i) == 0) {
                    ICreator<?, ?> valueAt = creators.valueAt(i);
                    genericFactory.setDefaultCreator(valueAt instanceof ICreator ? valueAt : null);
                } else {
                    ICreator<?, ?> valueAt2 = creators.valueAt(i);
                    ICreator<?, ?> iCreator = valueAt2 instanceof ICreator ? valueAt2 : null;
                    if (iCreator != null) {
                        genericFactory.addExtendedCreator(creators.keyAt(i), iCreator);
                    }
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return genericFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GenericFactory<IModule<ModuleValue>, Node> getDefaultModuleFactory(@NotNull IContext iContext) {
        int size;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-134764298")) {
            return (GenericFactory) ipChange.ipc$dispatch("-134764298", new Object[]{this, iContext});
        }
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        Object f = C8883a.j(Constants.CreatorConfig.CLASS_DEFAULT_MODULE_CREATOR).b().f();
        Objects.requireNonNull(f, "null cannot be cast to non-null type com.youku.arch.v3.ICreator<com.youku.arch.v3.IModule<com.youku.arch.v3.core.ModuleValue>, com.youku.arch.v3.core.Node>");
        GenericFactory<IModule<ModuleValue>, Node> genericFactory = new GenericFactory<>((ICreator) f);
        ConfigManager configManager = iContext.getConfigManager();
        ConfigManager.CreatorConfig creatorConfig = configManager == null ? null : configManager.getCreatorConfig(1);
        SparseArray<ICreator<?, ?>> creators = creatorConfig == null ? null : creatorConfig.getCreators();
        if (creators != null && creators.size() > 0 && (size = creators.size()) > 0) {
            while (true) {
                int i2 = i + 1;
                if (creators.keyAt(i) == 0) {
                    ICreator<?, ?> valueAt = creators.valueAt(i);
                    genericFactory.setDefaultCreator(valueAt instanceof ICreator ? valueAt : null);
                } else {
                    ICreator<?, ?> valueAt2 = creators.valueAt(i);
                    ICreator<?, ?> iCreator = valueAt2 instanceof ICreator ? valueAt2 : null;
                    if (iCreator != null) {
                        genericFactory.addExtendedCreator(creators.keyAt(i), iCreator);
                    }
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return genericFactory;
    }

    public final int getItemType(@Nullable IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113453460")) {
            return ((Integer) ipChange.ipc$dispatch("-1113453460", new Object[]{this, iItem})).intValue();
        }
        if (iItem == null) {
            return 0;
        }
        return iItem.getType() > 32768 ? iItem.getType() >> 16 : iItem.getType();
    }

    public final int getItemTypeByConfig(@NotNull GenericRenderConfig genericRenderConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401530625")) {
            return ((Integer) ipChange.ipc$dispatch("1401530625", new Object[]{this, genericRenderConfig})).intValue();
        }
        b41.i(genericRenderConfig, Constants.CONFIG);
        String type = genericRenderConfig.getType();
        if (type == null) {
            return 0;
        }
        return Integer.parseInt(type) > 32768 ? Integer.parseInt(type) >> 16 : Integer.parseInt(type);
    }

    @NotNull
    public final List<DelegateAdapter.Adapter<?>> getSubAdapters(@NotNull IModule<?> iModule, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013315186")) {
            return (List) ipChange.ipc$dispatch("-1013315186", new Object[]{this, iModule, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(iModule, "module");
        ArrayList arrayList = new ArrayList();
        for (IComponent<ComponentValue> iComponent : iModule.getComponents().subList(i, i2)) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
            if (adapter != null) {
                arrayList.add(adapter);
            }
        }
        return arrayList;
    }
}
