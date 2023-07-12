package cn.damai.commonbusiness.wannasee.listener;

import android.view.View;
import in.srain.cube.views.ptr.PtrFrameLayout;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PtrChildHandler {
    boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2);

    void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack);
}
