package com.youku.alixplugin.view;

import android.view.View;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.kubus.NoProguard;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public interface BaseView<P extends BasePresenter> {
    View getView();

    void hide();

    void inflate();

    boolean isInflated();

    void setPresenter(P p);

    void show();
}
