package com.alibaba.pictures.bricks.component.script;

import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ScriptInfoContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        ScriptInfoHeaderBean getScriptInfo();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        @NotNull
        ViewGroup getHeader();
    }
}
