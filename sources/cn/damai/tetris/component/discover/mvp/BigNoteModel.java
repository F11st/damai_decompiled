package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.BigNoteContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigNoteModel extends AbsModel implements BigNoteContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private NoteBean bean;

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Model
    public NoteBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-64987186") ? (NoteBean) ipChange.ipc$dispatch("-64987186", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368084678")) {
            ipChange.ipc$dispatch("-1368084678", new Object[]{this, baseNode});
            return;
        }
        NoteBean noteBean = (NoteBean) m61.d(baseNode.getItem(), NoteBean.class);
        this.bean = noteBean;
        noteBean.pos = baseNode.getOffset();
    }
}
