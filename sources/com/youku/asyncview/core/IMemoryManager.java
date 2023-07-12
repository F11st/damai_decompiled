package com.youku.asyncview.core;

import android.view.View;
import com.youku.asyncview.IViewCreator;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IMemoryManager extends Serializable {
    void gcAllAsyncViews();

    void gcAsyncViews(int i);

    void recyclerAllAsyncViews();

    void recyclerAsyncView(int i, View view);

    void recyclerAsyncView(int i, List<View> list);

    void recyclerGroupAsyncViews(String str);

    void setDefaultViewCreator(IViewCreator iViewCreator);
}
