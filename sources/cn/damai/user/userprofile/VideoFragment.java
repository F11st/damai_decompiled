package cn.damai.user.userprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.user.userprofile.bean.VideoData;
import cn.damai.user.userprofile.bean.VideoItem;
import cn.damai.user.userprofile.bean.VideoRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class VideoFragment extends BaseFragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ARG_USERID = "ARG_USERID";
    public static final String ARG_USERTYPE = "ARG_USERTYPE";
    VideoAdapter adapter;
    View emptyFoot;
    TextView emptyTv;
    View emptyView;
    boolean hasNext = true;
    public int type;
    IRecyclerView videoRecyclerview;
    public VideoRequest videoRequest;

    public static VideoFragment newInstance(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108406586")) {
            return (VideoFragment) ipChange.ipc$dispatch("-2108406586", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        }
        VideoFragment videoFragment = new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_USERID, j);
        bundle.putInt(ARG_USERTYPE, i);
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    private void requestVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783536930")) {
            ipChange.ipc$dispatch("1783536930", new Object[]{this});
        } else {
            this.videoRequest.request(new DMMtopRequestListener<VideoData>(VideoData.class) { // from class: cn.damai.user.userprofile.VideoFragment.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    VideoRequest videoRequest;
                    int i;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "788762034")) {
                        ipChange2.ipc$dispatch("788762034", new Object[]{this, str, str2});
                        return;
                    }
                    VideoFragment.this.stopProgressDialog();
                    VideoFragment videoFragment = VideoFragment.this;
                    if (videoFragment.videoRequest.pageNumber == 0) {
                        videoFragment.setEmptyView();
                    }
                    VideoFragment videoFragment2 = VideoFragment.this;
                    if (!videoFragment2.hasNext || (i = (videoRequest = videoFragment2.videoRequest).pageNumber) <= 0) {
                        return;
                    }
                    videoRequest.pageNumber = i - 1;
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(VideoData videoData) {
                    List<VideoItem> list;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-913165862")) {
                        ipChange2.ipc$dispatch("-913165862", new Object[]{this, videoData});
                        return;
                    }
                    VideoFragment.this.stopProgressDialog();
                    if (videoData != null && (list = videoData.videoVOList) != null && list.size() != 0) {
                        VideoFragment videoFragment = VideoFragment.this;
                        videoFragment.hasNext = videoData.hasNext;
                        videoFragment.updateVideoList(videoData.videoVOList);
                        return;
                    }
                    VideoFragment videoFragment2 = VideoFragment.this;
                    if (videoFragment2.videoRequest.pageNumber == 0) {
                        videoFragment2.setEmptyView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938210942")) {
            ipChange.ipc$dispatch("938210942", new Object[]{this});
            return;
        }
        this.emptyView.setVisibility(0);
        ((ImageView) this.emptyView.findViewById(R$id.user_empty_img)).setImageResource(R$drawable.common_error_ticket_empty);
        this.emptyTv.setText("这里什么都没有呢(-.-)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoList(List<VideoItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887007107")) {
            ipChange.ipc$dispatch("-1887007107", new Object[]{this, list});
        } else {
            this.adapter.c(list);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545119137") ? ((Integer) ipChange.ipc$dispatch("1545119137", new Object[]{this})).intValue() : R$layout.fragment_usertab;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330543164")) {
            ipChange.ipc$dispatch("-330543164", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148902823")) {
            ipChange.ipc$dispatch("-148902823", new Object[]{this});
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094446593")) {
            ipChange.ipc$dispatch("-1094446593", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-317883997") ? (View) ipChange.ipc$dispatch("-317883997", new Object[]{this, layoutInflater, viewGroup, bundle}) : layoutInflater.inflate(R$layout.fragment_usertab, viewGroup, false);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418878686")) {
            ipChange.ipc$dispatch("418878686", new Object[]{this, view});
        } else if (!this.hasNext) {
            this.emptyView.setVisibility(0);
            this.videoRecyclerview.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.videoRecyclerview.getLoadMoreFooterView().setVisibility(8);
        } else {
            this.emptyView.setVisibility(8);
            this.videoRecyclerview.getLoadMoreFooterView().setVisibility(0);
            this.videoRecyclerview.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.videoRequest.pageNumber++;
            requestVideo();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974302374")) {
            ipChange.ipc$dispatch("-974302374", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        IRecyclerView iRecyclerView = (IRecyclerView) view.findViewById(R$id.listview);
        this.videoRecyclerview = iRecyclerView;
        iRecyclerView.setHasFixedSize(true);
        this.videoRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        this.emptyView = view.findViewById(R$id.user_empty_view);
        this.emptyTv = (TextView) view.findViewById(R$id.user_empty_tv);
        VideoAdapter videoAdapter = new VideoAdapter(this);
        this.adapter = videoAdapter;
        this.videoRecyclerview.setAdapter(videoAdapter);
        this.videoRecyclerview.setLoadMoreEnabled(true);
        this.emptyFoot = LayoutInflater.from(getContext()).inflate(R$layout.feeds_footer_empty, (ViewGroup) null);
        this.emptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(getActivity(), 110.0f)));
        VideoRequest videoRequest = new VideoRequest();
        this.videoRequest = videoRequest;
        videoRequest.artistId = getArguments().getLong(ARG_USERID, 0L);
        this.type = getArguments().getInt(ARG_USERTYPE, 0);
        this.videoRequest.pageNumber = 0;
        requestVideo();
    }
}
