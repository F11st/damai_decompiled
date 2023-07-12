package cn.damai.tetris.v2.structure.module;

import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.alibaba.android.vlayout.DelegateAdapter;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IModule extends Addressable, ILayerManager {
    void addSectionList(List<Node> list, boolean z, boolean z2);

    List<DelegateAdapter.Adapter> getAdapterList();

    IContainer getContainer();
}
