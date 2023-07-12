package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.ActorAlbumContract;
import cn.damai.tetris.component.common.bean.ActorBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ActorAlbumModel extends AbsModel implements ActorAlbumContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ActorBean> actorList;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    static class ResultBean implements Serializable {
        public List<ActorBean> result;

        ResultBean() {
        }
    }

    @Override // cn.damai.tetris.component.common.ActorAlbumContract.Model
    public List<ActorBean> getActors() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-23568898") ? (List) ipChange.ipc$dispatch("-23568898", new Object[]{this}) : this.actorList;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833707966")) {
            ipChange.ipc$dispatch("-1833707966", new Object[]{this, baseNode});
            return;
        }
        try {
            ResultBean resultBean = (ResultBean) JSON.parseObject(baseNode.getItem().toJSONString(), ResultBean.class);
            if (resultBean != null) {
                this.actorList = resultBean.result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
