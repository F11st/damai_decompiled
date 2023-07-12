package cn.damai.message.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.message.bean.MessageItem;
import cn.damai.message.bean.MessageList;
import cn.damai.message.contract.FollowCommentContract;
import cn.damai.message.presenter.FollowCommentPresenter;
import cn.damai.message.ui.adapter.MessageFollowAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cs;
import tb.te1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageFollowFragment extends DamaiBaseMvpFragment<FollowCommentPresenter, FollowCommentContract.Model> implements FollowCommentContract.View, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView headerTitle;
    private View headerView;
    private IRecyclerView irc;
    private Activity mActivity;
    private TextView mEmptyTips;
    private MessageFollowAdapter mFollowAdapter;
    private TextView mTryAgainBtn;
    private String messageId = "0";
    private boolean hasMore = true;

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692338116")) {
            ipChange.ipc$dispatch("-692338116", new Object[]{this});
            return;
        }
        startProgressDialog();
        HashMap hashMap = new HashMap();
        hashMap.put("groupId", "5");
        hashMap.put("messageId", this.messageId);
        hashMap.put("size", "10");
        hashMap.put("loginKey", z20.q());
        ((FollowCommentPresenter) this.mPresenter).getMessageItemList(hashMap);
    }

    private void initEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468872338")) {
            ipChange.ipc$dispatch("468872338", new Object[]{this});
            return;
        }
        this.mEmptyTips = (TextView) this.rootView.findViewById(R$id.tv_null_tip);
        TextView textView = (TextView) this.rootView.findViewById(R$id.tv_try_again);
        this.mTryAgainBtn = textView;
        textView.setOnClickListener(this);
    }

    private void initRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674634444")) {
            ipChange.ipc$dispatch("1674634444", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mFollowAdapter = new MessageFollowAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(linearLayoutManager);
        this.irc.setRefreshEnabled(false);
        this.irc.setLoadMoreEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnLoadMoreListener(this);
        this.irc.getLoadMoreFooterView().setVisibility(8);
        this.irc.setAdapter(this.mFollowAdapter);
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.message_follow_comment_title, (ViewGroup) null);
        this.headerView = inflate;
        this.headerTitle = (TextView) inflate.findViewById(R$id.message_follow_comment_title);
        this.headerView.setVisibility(8);
        this.irc.addHeaderView(this.headerView);
    }

    public static MessageFollowFragment newInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2001304773") ? (MessageFollowFragment) ipChange.ipc$dispatch("2001304773", new Object[0]) : new MessageFollowFragment();
    }

    @Override // cn.damai.message.contract.FollowCommentContract.View
    public void followCommentNotify(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572643385")) {
            ipChange.ipc$dispatch("-1572643385", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || !str.equals("5")) {
        } else {
            this.messageId = "0";
            initData();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2122552935") ? ((Integer) ipChange.ipc$dispatch("-2122552935", new Object[]{this})).intValue() : R$layout.message_follow_comment_list;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819154353")) {
            ipChange.ipc$dispatch("-1819154353", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811651004")) {
            ipChange.ipc$dispatch("811651004", new Object[]{this});
        } else {
            ((FollowCommentPresenter) this.mPresenter).setVM(this, (FollowCommentContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681305247")) {
            ipChange.ipc$dispatch("-1681305247", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        initRecycleView();
        initEmptyView();
        initData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861139193")) {
            ipChange.ipc$dispatch("-1861139193", new Object[]{this, view});
        } else if (view.getId() == R$id.tv_try_again) {
            initData();
        }
    }

    public void onItemClick(MessageItem messageItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010634782")) {
            ipChange.ipc$dispatch("1010634782", new Object[]{this, messageItem, Integer.valueOf(i)});
        } else if (messageItem == null) {
        } else {
            String havanaId = messageItem.getHavanaId();
            if (TextUtils.isEmpty(havanaId)) {
                return;
            }
            c.e().x(te1.m().k(z20.E(), String.valueOf(havanaId), i));
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, havanaId);
            DMNav.from(getActivity()).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515712214")) {
            ipChange.ipc$dispatch("515712214", new Object[]{this, view});
        } else if (this.hasMore) {
            initData();
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975265354")) {
            ipChange.ipc$dispatch("1975265354", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100580911")) {
            ipChange.ipc$dispatch("-1100580911", new Object[]{this});
        }
    }

    @Override // cn.damai.message.contract.FollowCommentContract.View
    public void returnMessageItemListFailures(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929672119")) {
            ipChange.ipc$dispatch("1929672119", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.a().e(getActivity(), str2);
        }
        this.irc.setVisibility(8);
        this.mEmptyTips.setVisibility(0);
        this.mTryAgainBtn.setVisibility(0);
        this.mEmptyTips.setText(getActivity().getResources().getText(R$string.message_network_error_tips));
    }

    @Override // cn.damai.message.contract.FollowCommentContract.View
    public void returnMessageItemListSuccess(MessageList messageList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849241565")) {
            ipChange.ipc$dispatch("849241565", new Object[]{this, messageList});
            return;
        }
        stopProgressDialog();
        List<MessageItem> messageList2 = messageList.getMessageList();
        if (this.messageId.equals("0")) {
            this.mFollowAdapter.b();
            if (messageList2 != null && messageList2.size() != 0) {
                this.irc.setVisibility(0);
                this.mFollowAdapter.setData(messageList2);
            } else {
                this.irc.setVisibility(8);
                this.mEmptyTips.setVisibility(0);
                this.mTryAgainBtn.setVisibility(8);
                this.mEmptyTips.setText(getActivity().getResources().getText(R$string.message_follow_empty_tips));
            }
        } else if (messageList2 != null && messageList2.size() != 0) {
            this.hasMore = true;
            this.mFollowAdapter.a(messageList2);
        } else {
            this.hasMore = false;
        }
        if (messageList2 == null || messageList2.size() <= 0) {
            return;
        }
        this.messageId = messageList2.get(messageList2.size() - 1).getMessageId();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415471873")) {
            ipChange.ipc$dispatch("-415471873", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452957189")) {
            ipChange.ipc$dispatch("-452957189", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389171359")) {
            ipChange.ipc$dispatch("389171359", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566822106")) {
            ipChange.ipc$dispatch("566822106", new Object[]{this});
        }
    }

    public void updateTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196487966")) {
            ipChange.ipc$dispatch("196487966", new Object[]{this, Integer.valueOf(i)});
        } else if (this.headerTitle != null) {
            if (i > 0) {
                this.headerView.setVisibility(0);
                this.headerTitle.setVisibility(0);
                TextView textView = this.headerTitle;
                textView.setText("你有" + i + "个新增关注");
                return;
            }
            this.headerView.setVisibility(8);
            this.headerTitle.setVisibility(8);
        }
    }
}
