package cn.damai.tetris.v2.structure.container;

import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.structure.module.IModule;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IModuleManager {
    void addModule(int i, IModule iModule);

    void addModule(int i, IModule iModule, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addModule(int i, IModule iModule, boolean z);

    void clearModuleList();

    IModule createModule(Node node);

    void createModuleList(List<Node> list);

    List<IModule> getModuleList();

    void removeModule(IModule iModule);

    void removeModule(IModule iModule, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeModule(IModule iModule, boolean z);

    void replaceModule(int i, IModule iModule);
}
