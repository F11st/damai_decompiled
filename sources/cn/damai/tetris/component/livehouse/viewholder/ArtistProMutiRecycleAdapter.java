package cn.damai.tetris.component.livehouse.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.livehouse.bean.ArtistContentBean;
import cn.damai.tetris.component.livehouse.mvp.ArtistListContract;
import cn.damai.tetris.component.online.viewholder.OnLinePosterView;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistProMutiRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ArtistContentBean> b;
    private List c;
    private String d = "";
    private ArtistListContract.Presenter e;
    private String f;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ArtistContentViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnLinePosterView a;
        private TextView b;

        ArtistContentViewHolder(ArtistProMutiRecycleAdapter artistProMutiRecycleAdapter, View view) {
            super(view);
            this.a = (OnLinePosterView) view.findViewById(R$id.aritst_content_poster);
            this.b = (TextView) view.findViewById(R$id.aritst_content_title);
        }

        public void a(ArtistContentBean artistContentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-930069388")) {
                ipChange.ipc$dispatch("-930069388", new Object[]{this, artistContentBean});
                return;
            }
            this.a.setImageUrlForWebp(artistContentBean.projectPic);
            if (!TextUtils.isEmpty(artistContentBean.videoUrl)) {
                this.a.setVideoIconVisible(true);
            } else {
                this.a.setVideoIconVisible(false);
            }
            this.a.setLineTime(artistContentBean.videoTime);
            this.b.setText(artistContentBean.title);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class ArtistMoreViewHolder extends RecyclerView.ViewHolder {
        ArtistMoreViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ArtistProViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnLinePosterView a;
        private TextView b;
        private DMDigitTextView c;

        ArtistProViewHolder(ArtistProMutiRecycleAdapter artistProMutiRecycleAdapter, View view) {
            super(view);
            this.a = (OnLinePosterView) view.findViewById(R$id.artist_item_poster);
            this.b = (TextView) view.findViewById(R$id.artist_item_title);
            this.c = (DMDigitTextView) view.findViewById(R$id.artist_item_price_tv);
        }

        public void a(ArtistContentBean artistContentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-518051672")) {
                ipChange.ipc$dispatch("-518051672", new Object[]{this, artistContentBean});
                return;
            }
            this.a.setImageUrlForWebp(artistContentBean.projectPic);
            this.a.setCityName(artistContentBean.cityName);
            this.b.setText(artistContentBean.title);
            this.c.setText(artistContentBean.priceLow);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.livehouse.viewholder.ArtistProMutiRecycleAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1923a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArtistContentBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1923a(ArtistContentBean artistContentBean, int i) {
            this.a = artistContentBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1432348156")) {
                ipChange.ipc$dispatch("1432348156", new Object[]{this, view});
                return;
            }
            int parseInt = Integer.parseInt(this.a.type);
            if (parseInt == -1) {
                ArtistProMutiRecycleAdapter artistProMutiRecycleAdapter = ArtistProMutiRecycleAdapter.this;
                artistProMutiRecycleAdapter.e(artistProMutiRecycleAdapter.d, this.b, null);
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, ArtistProMutiRecycleAdapter.this.d);
                bundle.putString("usertype", "2");
                DMNav.from(ArtistProMutiRecycleAdapter.this.a).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            } else if (parseInt == 1) {
                ArtistProMutiRecycleAdapter artistProMutiRecycleAdapter2 = ArtistProMutiRecycleAdapter.this;
                artistProMutiRecycleAdapter2.e(artistProMutiRecycleAdapter2.d, this.b, this.a.id);
                Bundle bundle2 = new Bundle();
                bundle2.putString(IssueConstants.ProjectID, this.a.id);
                DMNav.from(ArtistProMutiRecycleAdapter.this.a).withExtras(bundle2).toUri(NavUri.b(cs.b));
            } else if (parseInt != 2) {
            } else {
                ArtistProMutiRecycleAdapter artistProMutiRecycleAdapter3 = ArtistProMutiRecycleAdapter.this;
                artistProMutiRecycleAdapter3.e(artistProMutiRecycleAdapter3.d, this.b, null);
                Bundle bundle3 = new Bundle();
                bundle3.putString("contentId", this.a.id);
                DMNav.from(ArtistProMutiRecycleAdapter.this.a).withExtras(bundle3).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            }
        }
    }

    public ArtistProMutiRecycleAdapter(Context context, ArtistListContract.Presenter presenter, String str) {
        this.a = context;
        this.e = presenter;
        this.f = str;
    }

    private void d(View view, int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752228680")) {
            ipChange.ipc$dispatch("-752228680", new Object[]{this, view, Integer.valueOf(i), str, str2});
            return;
        }
        ArtistListContract.Presenter presenter = this.e;
        if (presenter != null) {
            presenter.userTrackExpose(view, i, str, this.f, this.d, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-979296133")) {
            ipChange.ipc$dispatch("-979296133", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        ArtistListContract.Presenter presenter = this.e;
        if (presenter != null) {
            presenter.userTrackClick(str, i, this.f, str2);
        }
    }

    public void f(List<ArtistContentBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187247255")) {
            ipChange.ipc$dispatch("-1187247255", new Object[]{this, list, str});
            return;
        }
        this.d = str;
        this.c = new ArrayList();
        this.b = list;
        ArtistContentBean artistContentBean = new ArtistContentBean();
        artistContentBean.type = "-1";
        this.b.add(artistContentBean);
        this.c.addAll(this.b);
        notifyDataSetChanged();
    }

    public void g(List<ArtistContentBean> list, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413014475")) {
            ipChange.ipc$dispatch("1413014475", new Object[]{this, list, Integer.valueOf(i), str});
            return;
        }
        this.d = str;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        if (list != null) {
            arrayList.addAll(list);
            if (i != 0) {
                ArtistContentBean artistContentBean = new ArtistContentBean();
                artistContentBean.type = "-1";
                this.c.add(artistContentBean);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148788651")) {
            return ((Integer) ipChange.ipc$dispatch("1148788651", new Object[]{this})).intValue();
        }
        List list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616399570")) {
            return ((Integer) ipChange.ipc$dispatch("1616399570", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        ArtistContentBean artistContentBean = (ArtistContentBean) this.c.get(i);
        if (Integer.parseInt(artistContentBean.type) == 1) {
            return 1;
        }
        return Integer.parseInt(artistContentBean.type) == 2 ? 2 : 3;
    }

    public void h(ArtistListContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362935996")) {
            ipChange.ipc$dispatch("1362935996", new Object[]{this, presenter});
        } else {
            this.e = presenter;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107493266")) {
            ipChange.ipc$dispatch("-1107493266", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        int itemViewType = getItemViewType(i);
        ArtistContentBean artistContentBean = (ArtistContentBean) this.c.get(i);
        if (artistContentBean == null) {
            return;
        }
        if (itemViewType == 1) {
            ((ArtistProViewHolder) viewHolder).a(artistContentBean);
        } else if (itemViewType == 2) {
            ((ArtistContentViewHolder) viewHolder).a(artistContentBean);
        }
        d(viewHolder.itemView, i, artistContentBean.id, artistContentBean.type);
        viewHolder.itemView.setOnClickListener(new View$OnClickListenerC1923a(artistContentBean, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297844920")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1297844920", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 1) {
            return new ArtistProViewHolder(this, LayoutInflater.from(this.a).inflate(R$layout.aritst_pro_item_layout, viewGroup, false));
        }
        if (i == 2) {
            return new ArtistContentViewHolder(this, LayoutInflater.from(this.a).inflate(R$layout.aritst_content_item_layout, viewGroup, false));
        }
        return new ArtistMoreViewHolder(LayoutInflater.from(this.a).inflate(R$layout.aritst_info_more_layout, viewGroup, false));
    }
}
