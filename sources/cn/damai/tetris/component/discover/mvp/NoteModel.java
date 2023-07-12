package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.NoteContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NoteModel extends AbsModel implements NoteContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private NoteBean bean;

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.Model
    public NoteBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1740605476") ? (NoteBean) ipChange.ipc$dispatch("1740605476", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424972380")) {
            ipChange.ipc$dispatch("-1424972380", new Object[]{this, baseNode});
            return;
        }
        NoteBean noteBean = (NoteBean) m61.d(baseNode.getItem(), NoteBean.class);
        this.bean = noteBean;
        noteBean.pos = baseNode.getOffset();
    }
}
