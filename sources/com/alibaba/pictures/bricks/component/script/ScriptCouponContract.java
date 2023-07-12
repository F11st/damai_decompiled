package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.bean.SearchScriptCouponBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptCouponContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @Nullable
        SearchScriptCouponBean getData();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindData(@Nullable SearchScriptCouponBean searchScriptCouponBean);
    }
}
