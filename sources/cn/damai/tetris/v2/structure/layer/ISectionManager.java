package cn.damai.tetris.v2.structure.layer;

import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.structure.section.ISection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ISectionManager {
    void addSection(int i, ISection iSection);

    void addSection(int i, ISection iSection, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addSection(int i, ISection iSection, boolean z);

    void addSectionListEnd(List<Node> list, boolean z);

    void addSectionListHead(List<Node> list, boolean z);

    void clearSectionList();

    ISection createSection(Node node);

    void createSectionList(List<Node> list, boolean z);

    List<ISection> getSectionList();

    void removeSection(ISection iSection);

    void removeSection(ISection iSection, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeSection(ISection iSection, boolean z);

    void updateChildIndex();

    void updateSectionList(List<Node> list, boolean z);
}
