package cn.damai.tetris.v2.structure.container;

import androidx.annotation.Nullable;
import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.componentplugin.SectionSensitive;
import cn.damai.tetris.v2.structure.layer.ILayer;
import com.alibaba.android.vlayout.DelegateAdapter;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IContainer extends Addressable, SectionSensitive, IModuleManager {
    void addSectionList(List<Node> list, boolean z, boolean z2);

    void addSubAdapters(List<DelegateAdapter.Adapter> list);

    List<DelegateAdapter.Adapter> getChildAdapters();

    @Nullable
    ContainerArg getContainerArg();

    <T> T getContainerValue(String str, ValueTarget<T> valueTarget);

    DelegateAdapter getContentAdapter();

    List<ILayer> getLayerList();

    ContainerProperty getProperty();

    void init(Node node);

    void removeContainerValue(String str);

    <T> void saveContainerValue(String str, Class<T> cls, T t);

    void setContainerArg(ContainerArg containerArg);

    void setContentAdapter(DelegateAdapter delegateAdapter);

    void updateContentAdapter();
}
