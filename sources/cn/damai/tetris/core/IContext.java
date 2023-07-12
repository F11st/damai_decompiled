package cn.damai.tetris.core;

import android.app.Activity;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IContext {
    Activity getActivity();

    IContainer getContainer();

    DinamicXEngine getDXEngine();

    String getPageName();

    void setActivity(Activity activity);

    void setPageName(String str);
}
