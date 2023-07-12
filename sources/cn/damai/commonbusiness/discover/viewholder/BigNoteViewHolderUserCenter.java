package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.wannasee.bean.TimeLineStyle;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.uikit.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ao2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BigNoteViewHolderUserCenter extends BigNoteViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private ao2 B;
    private BigNoteBindListener C;

    public BigNoteViewHolderUserCenter(Context context, ViewGroup viewGroup, BigNoteBindListener bigNoteBindListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_discover_feed_big_note_shell, viewGroup, false), bigNoteBindListener);
        this.C = bigNoteBindListener;
        this.u = true;
        this.t = 3;
        this.B = new ao2(this.itemView);
        p(0);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void c(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333252916")) {
            ipChange.ipc$dispatch("333252916", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        } else {
            this.C.OnPraiseViewClickReport(z, str, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void dnaOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775358474")) {
            ipChange.ipc$dispatch("-775358474", new Object[]{this, str, str2, Integer.valueOf(i)});
        } else {
            this.C.dnaOnClickReport(str, str2, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder, cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: h */
    public void a(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994578337")) {
            ipChange.ipc$dispatch("-994578337", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (noteBean == null) {
        } else {
            this.B.setTimeStyle(new TimeLineStyle(i == 0, noteBean.publishTime));
            super.a(noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void i(GridBean gridBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122226500")) {
            ipChange.ipc$dispatch("1122226500", new Object[]{this, gridBean, Integer.valueOf(i)});
        } else if (v()) {
            ToastUtil.a().j(mu0.a(), "该视频还在处理中哦~");
        } else {
            super.i(gridBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public List<BottomActionDialog.Action> j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-82766694")) {
            return (List) ipChange.ipc$dispatch("-82766694", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        NoteBean noteBean = this.p;
        if (noteBean != null) {
            if (noteBean.mySelf) {
                if (!noteBean.prohibitEditing) {
                    arrayList.add(new BottomActionDialog.Action(BottomActionDialog.EDIT, -1, R$string.iconfont_bianji24));
                }
            } else {
                arrayList.add(new BottomActionDialog.Action(BottomActionDialog.REPORT, -1, R$string.iconfont_jubao));
            }
        }
        return arrayList;
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void k(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106045615")) {
            ipChange.ipc$dispatch("2106045615", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        } else {
            this.C.hookExposeItem(view, noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void l(NoteBean noteBean, BottomActionDialog.Action action, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442116581")) {
            ipChange.ipc$dispatch("442116581", new Object[]{this, noteBean, action, Integer.valueOf(i)});
        } else {
            this.C.onMoreActionClick(noteBean, action, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void likeOnClickReport(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602536554")) {
            ipChange.ipc$dispatch("602536554", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        } else {
            this.C.likeOnClickReport(z, str, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-356369168")) {
            ipChange.ipc$dispatch("-356369168", new Object[]{this, view});
        } else if (v()) {
            ToastUtil.a().j(mu0.a(), "该视频还在处理中哦~");
        } else {
            super.onClick(view);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void s(NoteBean noteBean, ContentShareInfo contentShareInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473750003")) {
            ipChange.ipc$dispatch("-473750003", new Object[]{this, noteBean, contentShareInfo, Integer.valueOf(i)});
        } else {
            this.C.shareClick(noteBean, contentShareInfo, i);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder
    public void userOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069462506")) {
            ipChange.ipc$dispatch("-1069462506", new Object[]{this, str, str2, Integer.valueOf(i)});
        } else {
            this.C.userOnClickReport(str, str2, i);
        }
    }

    public boolean v() {
        VideoInfo videoInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301040522")) {
            return ((Boolean) ipChange.ipc$dispatch("1301040522", new Object[]{this})).booleanValue();
        }
        NoteBean noteBean = this.p;
        return (noteBean == null || (videoInfo = noteBean.videoInfo) == null || !videoInfo.isVideoUnderReviewStatus()) ? false : true;
    }
}
