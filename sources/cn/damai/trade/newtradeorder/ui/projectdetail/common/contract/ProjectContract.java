package cn.damai.trade.newtradeorder.ui.projectdetail.common.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void retrieveOldProjectItemId(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void onRetrieveOldProjectIdError(String str, String str2);

        void onRetrieveOldProjectIdSuccess(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean projectSwitchIdResultBean);
    }
}
