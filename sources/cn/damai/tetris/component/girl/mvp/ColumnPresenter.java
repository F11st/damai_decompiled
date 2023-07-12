package cn.damai.tetris.component.girl.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.categorygirl.ui.GirlShowAllActivity;
import cn.damai.tetris.component.girl.bean.ProjectViewModel;
import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import tb.ja;
import tb.qd2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ColumnPresenter extends BasePresenter<ColumnContract$Model, ColumnView, BaseSection> implements ColumnContract$Presenter<ColumnContract$Model, ColumnView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ColumnPresenter(ColumnView columnView, String str, ja jaVar) {
        super(columnView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$Presenter
    public void allBtnClick(StepBean stepBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425802088")) {
            ipChange.ipc$dispatch("1425802088", new Object[]{this, stepBean, str});
        } else if (stepBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("groupId", stepBean.groupId);
            bundle.putString(GirlShowAllActivity.KEY_GROUPNAME, getModel().getStyleValue("title"));
            bundle.putString("cityId", str);
            NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page("categorygirl"));
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", stepBean.groupId);
            if (!TextUtils.isEmpty(getModel().getStyleValue("title"))) {
                hashMap.put(PushConstants.SUB_TAGS_STATUS_NAME, getModel().getStyleValue("title"));
            }
            TrackType trackType = TrackType.click;
            String str2 = getModel().getTrackInfo().trackB;
            userTrack(trackType, null, str2, getModel().getTrackInfo().trackC + stepBean.position, "all", hashMap, true);
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803838294")) {
            ipChange.ipc$dispatch("803838294", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$Presenter
    public void projectItemClick(ProjectViewModel projectViewModel, int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266085572")) {
            ipChange.ipc$dispatch("-1266085572", new Object[]{this, projectViewModel, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        } else if (projectViewModel == null) {
        } else {
            qd2.b(getContext().getActivity(), projectViewModel.schema, projectViewModel.id, projectViewModel.title, projectViewModel.picUrl);
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", str);
            if (!TextUtils.isEmpty(projectViewModel.id)) {
                hashMap.put("item_id", projectViewModel.id);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(PushConstants.SUB_TAGS_STATUS_NAME, str2);
            }
            userTrack(TrackType.click, null, getModel().getTrackInfo().trackB, getModel().getTrackInfo().trackC + i, "item_" + i2, hashMap, true);
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ColumnContract$Model columnContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358702371")) {
            ipChange.ipc$dispatch("-1358702371", new Object[]{this, columnContract$Model});
            return;
        }
        getView().initScreenSize();
        getView().setData(columnContract$Model.getStepBean(), columnContract$Model.getCityId(), columnContract$Model);
    }
}
