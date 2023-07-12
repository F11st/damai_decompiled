package com.alibaba.pictures.bricks.component.empty;

import android.view.View;
import com.alibaba.pictures.bricks.component.empty.EmptyContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.AbsPresenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class EmptyPresent extends AbsPresenter<IItem<ItemValue>, EmptyContract.Model<IItem<ItemValue>>, EmptyContract.View> implements EmptyContract.Presenter<IItem<ItemValue>, EmptyContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public EmptyPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147587321")) {
            ipChange.ipc$dispatch("-147587321", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((EmptyContract.View) this.view).renderContent(((EmptyContract.Model) this.model).getContent());
    }
}
