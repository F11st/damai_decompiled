package cn.damai.search.component.feed;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.onearch.view.AbsView;
import cn.damai.search.component.feed.ContentContract;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.mu0;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ContentView extends AbsView<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>, ContentContract.Presenter<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>>> implements ContentContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final NoteViewHolder mNoteViewHolder;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.component.feed.ContentView$a */
    /* loaded from: classes6.dex */
    public class C1572a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1572a() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-604660130")) {
                ipChange.ipc$dispatch("-604660130", new Object[]{this, noteBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-634808395")) {
                ipChange.ipc$dispatch("-634808395", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            PRESENTER presenter = ContentView.this.presenter;
            if (presenter != 0) {
                ((ContentContract.Presenter) presenter).gotoContentActivity(noteBean, i);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            rm1.a(this, noteBean, i);
        }
    }

    public ContentView(View view) {
        super(view);
        ViewGroup viewGroup = (ViewGroup) view;
        NoteViewHolder noteViewHolder = new NoteViewHolder(mu0.a(), viewGroup, new C1572a()) { // from class: cn.damai.search.component.feed.ContentView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.discover.viewholder.NoteViewHolder
            public void k(View view2, NoteBean noteBean, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-289067554")) {
                    ipChange.ipc$dispatch("-289067554", new Object[]{this, view2, noteBean, Integer.valueOf(i)});
                    return;
                }
                PRESENTER presenter = ContentView.this.presenter;
                if (presenter != 0) {
                    ((ContentContract.Presenter) presenter).exposeContentCard(view2, noteBean, i);
                }
            }
        };
        this.mNoteViewHolder = noteViewHolder;
        viewGroup.addView(noteViewHolder.itemView);
    }

    @Override // cn.damai.search.component.feed.ContentContract.View
    public void render(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985446066")) {
            ipChange.ipc$dispatch("1985446066", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (noteBean == null) {
        } else {
            this.mNoteViewHolder.a(noteBean, i);
        }
    }
}
