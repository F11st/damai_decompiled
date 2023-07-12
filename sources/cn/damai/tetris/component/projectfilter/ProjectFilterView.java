package cn.damai.tetris.component.projectfilter;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.projectfilter.ProjectFilterContract;
import cn.damai.tetris.core.AbsView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectFilterView extends AbsView<ProjectFilterPresenter> implements ProjectFilterContract.View<ProjectFilterPresenter> {
    public final ViewGroup mRoot;

    public ProjectFilterView(View view) {
        super(view);
        this.mRoot = (ViewGroup) view.findViewById(R$id.id_tetris_project_filter_container);
    }
}
