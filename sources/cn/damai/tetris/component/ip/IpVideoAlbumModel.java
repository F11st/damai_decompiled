package cn.damai.tetris.component.ip;

import cn.damai.tetris.component.ip.IpVideoAlbumContract;
import cn.damai.tetris.component.ip.bean.VideoAlbumBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoAlbumModel extends AbsModel implements IpVideoAlbumContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    VideoAlbumBean videoAlbum;

    @Override // cn.damai.tetris.component.ip.IpVideoAlbumContract.Model
    public VideoAlbumBean getVideoInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "595326024") ? (VideoAlbumBean) ipChange.ipc$dispatch("595326024", new Object[]{this}) : this.videoAlbum;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696164729")) {
            ipChange.ipc$dispatch("-696164729", new Object[]{this, baseNode});
            return;
        }
        try {
            this.videoAlbum = (VideoAlbumBean) JSON.parseObject(baseNode.getItem().toJSONString(), VideoAlbumBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
