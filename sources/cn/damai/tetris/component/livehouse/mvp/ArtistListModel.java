package cn.damai.tetris.component.livehouse.mvp;

import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import cn.damai.tetris.component.livehouse.bean.ArtistList;
import cn.damai.tetris.component.livehouse.mvp.ArtistListContract;
import cn.damai.tetris.component.online.bean.OnlineTitleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistListModel extends AbsModel implements ArtistListContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArtistList mBean;

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.Model
    public ArtistList getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1011208") ? (ArtistList) ipChange.ipc$dispatch("1011208", new Object[]{this}) : this.mBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806603934")) {
            ipChange.ipc$dispatch("806603934", new Object[]{this, baseNode});
            return;
        }
        try {
            ArtistList artistList = (ArtistList) m61.d(baseNode.getItem(), ArtistList.class);
            this.mBean = artistList;
            if (artistList != null) {
                List<ArtistItemBean> list = artistList.result;
                if (!cb2.d(list)) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).artistVo.pos = i;
                    }
                }
                this.mBean.mTitleBean = OnlineTitleBean.fromTetrisStyle(baseNode.getStyle());
            }
        } catch (Exception unused) {
        }
    }
}
