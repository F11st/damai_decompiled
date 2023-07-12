package cn.damai.commonbusiness.discover.viewholder;

import android.view.View;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.view.BottomActionDialog;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public interface BigNoteBindListener extends OnItemClickListener<NoteBean> {
    void OnPraiseViewClickReport(boolean z, String str, int i);

    void dnaOnClickReport(String str, String str2, int i);

    void hookExposeItem(View view, NoteBean noteBean, int i);

    void likeOnClickReport(boolean z, String str, int i);

    void onMoreActionClick(NoteBean noteBean, BottomActionDialog.Action action, int i);

    void shareClick(NoteBean noteBean, ContentShareInfo contentShareInfo, int i);

    void userOnClickReport(String str, String str2, int i);
}
