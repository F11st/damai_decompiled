package cn.damai.tetris.v2.componentplugin;

import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.structure.section.ISection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface SectionSensitive {
    void sectionBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder);

    void sectionChanged(ISection iSection, boolean z);

    void sectionListChanged(List<ISection> list, boolean z);

    void sectionListClear();
}
