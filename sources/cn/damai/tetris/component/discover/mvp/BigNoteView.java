package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.BigNoteContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigNoteView extends AbsView<BigNoteContract.Presenter> implements BigNoteContract.View<BigNoteContract.Presenter>, OnItemClickListener<NoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BigNoteViewHolder mHolder;

    public BigNoteView(View view) {
        super(view);
        this.mHolder = new BigNoteViewHolder(view, this) { // from class: cn.damai.tetris.component.discover.mvp.BigNoteView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void c(boolean z, String str, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "446462075")) {
                    ipChange.ipc$dispatch("446462075", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().OnPraiseViewClick(z, str, i);
                }
            }

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void dnaOnClickReport(String str, String str2, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "716651133")) {
                    ipChange.ipc$dispatch("716651133", new Object[]{this, str, str2, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().dnaOnClickReport(str, str2, i);
                }
            }

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void k(View view2, NoteBean noteBean, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-926752440")) {
                    ipChange.ipc$dispatch("-926752440", new Object[]{this, view2, noteBean, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().exposeNote(view2, noteBean, i);
                }
            }

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void likeOnClickReport(boolean z, String str, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-844879119")) {
                    ipChange.ipc$dispatch("-844879119", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().likeOnClickReport(z, str, i);
                }
            }

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void s(NoteBean noteBean, ContentShareInfo contentShareInfo, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "697938068")) {
                    ipChange.ipc$dispatch("697938068", new Object[]{this, noteBean, contentShareInfo, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().shareClick(contentShareInfo, i);
                }
            }

            @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
            public void userOnClickReport(String str, String str2, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2061804945")) {
                    ipChange.ipc$dispatch("-2061804945", new Object[]{this, str, str2, Integer.valueOf(i)});
                } else {
                    BigNoteView.this.getPresenter().userOnClickReport(str, str2, i);
                }
            }
        };
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
        rm1.a(this, noteBean, i);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onEditClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225916732")) {
            ipChange.ipc$dispatch("225916732", new Object[]{this, noteBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.View
    public void setData(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125823273")) {
            ipChange.ipc$dispatch("1125823273", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else {
            this.mHolder.a(noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onItemClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195768467")) {
            ipChange.ipc$dispatch("195768467", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (this.mHolder.p == null || getPresenter() == null) {
        } else {
            BigNoteViewHolder bigNoteViewHolder = this.mHolder;
            getPresenter().itemClick(this, bigNoteViewHolder.p, bigNoteViewHolder.q);
        }
    }
}
