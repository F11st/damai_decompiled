package com.alibaba.android.ultron.trade.presenter;

import android.app.Activity;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import tb.km2;
import tb.op2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IPresenter {
    Activity getContext();

    IDMContext getDataContext();

    BaseDataManager getDataManager();

    String getModuleName();

    km2 getThemeManager();

    op2 getTradeEventHandler();

    C3259b getViewManager();

    void respondToLinkage(IDMComponent iDMComponent);
}
