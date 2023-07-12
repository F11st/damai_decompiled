package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.NoteContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NoteView extends AbsView<NoteContract.Presenter> implements NoteContract.View<NoteContract.Presenter>, OnItemClickListener<NoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final NoteViewHolder mHolder;

    public NoteView(View view) {
        super(view);
        this.mHolder = new NoteViewHolder(view, this);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
        rm1.a(this, noteBean, i);
    }

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.View
    public void setData(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264620947")) {
            ipChange.ipc$dispatch("1264620947", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else {
            this.mHolder.a(noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onEditClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506342234")) {
            ipChange.ipc$dispatch("-506342234", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (this.mHolder.v == null || getPresenter() == null) {
        } else {
            NoteViewHolder noteViewHolder = this.mHolder;
            getPresenter().editClick(this, noteViewHolder.v, noteViewHolder.w);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onItemClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536490499")) {
            ipChange.ipc$dispatch("-536490499", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (this.mHolder.v == null || getPresenter() == null) {
        } else {
            NoteViewHolder noteViewHolder = this.mHolder;
            getPresenter().itemClick(this, noteViewHolder.v, noteViewHolder.w);
        }
    }
}
