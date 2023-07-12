package com.alibaba.ability.builder;

import com.alibaba.ability.IAbility;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\"\u0010\u000b\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/alibaba/ability/builder/IAbilityBuilder;", "", "Lcom/alibaba/ability/IAbility;", "build", "", "getLifeCycle", "()I", "setLifeCycle", "(I)V", "getLifeCycle$annotations", "()V", "lifeCycle", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IAbilityBuilder {
    @Nullable
    IAbility build();

    int getLifeCycle();

    void setLifeCycle(int i);
}
