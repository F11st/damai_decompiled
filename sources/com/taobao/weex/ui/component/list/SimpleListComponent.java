package com.taobao.weex.ui.component.list;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SimpleListComponent extends BasicListComponent<SimpleRecyclerView> {
    public SimpleListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public SimpleRecyclerView generateListView(Context context, int i) {
        SimpleRecyclerView simpleRecyclerView = new SimpleRecyclerView(context);
        simpleRecyclerView.initView(context, 1, i);
        return simpleRecyclerView;
    }
}
