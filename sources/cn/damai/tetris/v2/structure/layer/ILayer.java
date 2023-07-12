package cn.damai.tetris.v2.structure.layer;

import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.module.IModule;
import com.alibaba.android.vlayout.DelegateAdapter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ILayer extends Addressable, ISectionManager {
    DelegateAdapter.Adapter getAdapter();

    int getChildCount();

    IContainer getContainer();

    String getLayerId();

    IModule getModule();

    LayerProperty getProperty();

    void setModule(IModule iModule);
}
