package com.alibaba.pictures.bricks.component.instructions;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface PurchaseInstructionsContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @Nullable
        String getContent();

        @Nullable
        String getTitle();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void renderContent(@Nullable String str);

        void renderTitle(@Nullable String str);
    }
}
