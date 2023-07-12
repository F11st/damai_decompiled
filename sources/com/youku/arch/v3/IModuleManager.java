package com.youku.arch.v3;

import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0002H&J\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J(\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J \u0010\u0017\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001e\u0010\u0017\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0002H&J\b\u0010\u001a\u001a\u00020\u0005H&R\u0016\u0010\u001d\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/youku/arch/v3/IModuleManager;", "", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Ltb/wt2;", "createModules", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "modules", "preAsyncLoadMVP", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "createModule", "", "index", "module", "addModule", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "", "notifyUiUpdate", "replaceModule", "removeModule", "updateModules", "getModules", "clearModules", "getChildCount", "()I", "childCount", "Lcom/youku/arch/v3/GenericFactory;", "getModuleFactory", "()Lcom/youku/arch/v3/GenericFactory;", "moduleFactory", "getCurrentModules", "()Ljava/util/List;", "currentModules", "isChildStateDirty", "()Z", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IModuleManager {
    void addModule(int i, @NotNull IModule<ModuleValue> iModule);

    void addModule(int i, @NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addModule(int i, @NotNull IModule<ModuleValue> iModule, boolean z);

    void clearModules();

    @Nullable
    IModule<ModuleValue> createModule(@NotNull Config<Node> config) throws Exception;

    void createModules(@NotNull List<Node> list);

    int getChildCount();

    @NotNull
    List<IModule<ModuleValue>> getCurrentModules();

    @NotNull
    GenericFactory<IModule<ModuleValue>, Node> getModuleFactory();

    @NotNull
    List<IModule<ModuleValue>> getModules();

    boolean isChildStateDirty();

    void preAsyncLoadMVP(@NotNull List<IModule<ModuleValue>> list);

    void removeModule(@NotNull IModule<ModuleValue> iModule);

    void removeModule(@NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeModule(@NotNull IModule<ModuleValue> iModule, boolean z);

    void replaceModule(int i, @NotNull IModule<ModuleValue> iModule);

    void replaceModule(int i, @NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void updateModules(@NotNull List<Node> list);
}
