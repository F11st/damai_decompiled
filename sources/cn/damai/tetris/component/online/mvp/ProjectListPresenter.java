package cn.damai.tetris.component.online.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import cn.damai.tetris.component.online.mvp.ProjectListContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ja;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectListPresenter extends BasePresenter<ProjectListModel, ProjectListView, BaseSection> implements ProjectListContract.Presenter<ProjectListModel, ProjectListView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ProjectListPresenter(ProjectListView projectListView, String str, ja jaVar) {
        super(projectListView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.online.mvp.ProjectListContract.Presenter
    public void expose(View view, ProjectInfoBean projectInfoBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557280708")) {
            ipChange.ipc$dispatch("557280708", new Object[]{this, view, projectInfoBean, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str);
        hashMap.put("item_id", String.valueOf(projectInfoBean.itemId));
        userTrackExpose(view, "item_" + i, hashMap, false);
    }

    @Override // cn.damai.tetris.component.online.mvp.ProjectListContract.Presenter
    public void itemClick(ProjectListContract.View view, ProjectInfoBean projectInfoBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657299635")) {
            ipChange.ipc$dispatch("-1657299635", new Object[]{this, view, projectInfoBean, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str);
        hashMap.put("item_id", String.valueOf(projectInfoBean.itemId));
        if (!TextUtils.isEmpty(projectInfoBean.jumpUrl)) {
            NavProxy.from(this.mContext.getActivity()).toUri(projectInfoBean.jumpUrl);
        }
        userTrackClick("item_" + i, hashMap, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436833250")) {
            ipChange.ipc$dispatch("436833250", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ProjectListModel projectListModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581344003")) {
            ipChange.ipc$dispatch("581344003", new Object[]{this, projectListModel});
        } else {
            getView().setData(projectListModel.getBean(), 0);
        }
    }
}
