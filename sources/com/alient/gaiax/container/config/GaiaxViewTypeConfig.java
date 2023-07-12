package com.alient.gaiax.container.config;

import com.alient.gaiax.container.R;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.view.render.DefaultViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR(\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R(\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R(\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R(\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R(\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R0\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/alient/gaiax/container/config/GaiaxViewTypeConfig;", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "", "layoutHelper", "getLayoutHelper", "()Ljava/lang/String;", "setLayoutHelper", "(Ljava/lang/String;)V", "", "layoutResId", "getLayoutResId", "()Ljava/lang/Integer;", "setLayoutResId", "(Ljava/lang/Integer;)V", "layoutResIdOpt", "getLayoutResIdOpt", "setLayoutResIdOpt", "layoutResString", "getLayoutResString", "setLayoutResString", "layoutResStringOpt", "getLayoutResStringOpt", "setLayoutResStringOpt", "model", "getModel", "setModel", "view", "getView", "setView", "presenter", "getPresenter", "setPresenter", "Ljava/lang/Class;", "viewHolderClass", "getViewHolderClass", "()Ljava/lang/Class;", "setViewHolderClass", "(Ljava/lang/Class;)V", "renderPluginFactory", "getRenderPluginFactory", "setRenderPluginFactory", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GaiaxViewTypeConfig extends ViewTypeConfig {
    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getLayoutHelper() {
        return Constants.LayoutType.SINGLE;
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public Integer getLayoutResId() {
        return Integer.valueOf(R.layout.component_common_gaiax);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public Integer getLayoutResIdOpt() {
        return getLayoutResId();
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getLayoutResString() {
        return "component_common_gaiax";
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getLayoutResStringOpt() {
        return getLayoutResString();
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getModel() {
        return "com.alient.gaiax.container.render.GenericGaiaxModel";
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getPresenter() {
        return "com.alient.gaiax.container.render.GenericGaiaxPresenter";
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getRenderPluginFactory() {
        return "com.youku.arch.v3.view.render.RenderPluginFactory";
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public String getView() {
        return "com.alient.gaiax.container.render.GenericGaiaxView";
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    @Nullable
    public Class<?> getViewHolderClass() {
        return DefaultViewHolder.class;
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setLayoutHelper(@Nullable String str) {
        super.setLayoutHelper(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setLayoutResId(@Nullable Integer num) {
        super.setLayoutResId(num);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setLayoutResIdOpt(@Nullable Integer num) {
        super.setLayoutResIdOpt(num);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setLayoutResString(@Nullable String str) {
        super.setLayoutResString(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setLayoutResStringOpt(@Nullable String str) {
        super.setLayoutResStringOpt(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setModel(@Nullable String str) {
        super.setModel(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setPresenter(@Nullable String str) {
        super.setPresenter(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setRenderPluginFactory(@Nullable String str) {
        super.setRenderPluginFactory(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setView(@Nullable String str) {
        super.setView(str);
    }

    @Override // com.youku.arch.v3.adapter.ViewTypeConfig
    public void setViewHolderClass(@Nullable Class<?> cls) {
        super.setViewHolderClass(cls);
    }
}
