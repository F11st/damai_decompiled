package cn.damai.message.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.comment.ui.CommentDetailActivity;
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
import cn.damai.message.ui.adapter.MessageCommentAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.List;
import tb.g41;
import tb.te1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageCommentFragment extends DamaiBaseMvpFragment<FollowCommentPresenter, FollowCommentContract.Model> implements FollowCommentContract.View, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean hasMore;
    private TextView headerTitle;
    private View headerView;
    private IRecyclerView irc;
    private Activity mActivity;
    private MessageCommentAdapter mCommentAdapter;
    private TextView mEmptyTips;
    private TextView mTryAgainBtn;
    private String messageId = "0";

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596759662")) {
            ipChange.ipc$dispatch("-1596759662", new Object[]{this});
            return;
        }
        startProgressDialog();
        HashMap hashMap = new HashMap();
        hashMap.put("groupId", "6");
        hashMap.put("messageId", this.messageId);
        hashMap.put("size", "10");
        hashMap.put("loginKey", z20.q());
        ((FollowCommentPresenter) this.mPresenter).getMessageItemList(hashMap);
    }

    private void initEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309923076")) {
            ipChange.ipc$dispatch("-309923076", new Object[]{this});
            return;
        }
        this.mEmptyTips = (TextView) this.rootView.findViewById(R$id.tv_null_tip);
        TextView textView = (TextView) this.rootView.findViewById(R$id.tv_try_again);
        this.mTryAgainBtn = textView;
        textView.setOnClickListener(this);
    }

    private void initRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576551094")) {
            ipChange.ipc$dispatch("576551094", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mCommentAdapter = new MessageCommentAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(linearLayoutManager);
        this.irc.setRefreshEnabled(false);
        this.irc.setLoadMoreEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnLoadMoreListener(this);
        this.irc.getLoadMoreFooterView().setVisibility(8);
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.message_follow_comment_title, (ViewGroup) null);
        this.headerView = inflate;
        this.headerTitle = (TextView) inflate.findViewById(R$id.message_follow_comment_title);
        this.headerView.setVisibility(8);
        this.irc.addHeaderView(this.headerView);
        this.irc.setAdapter(this.mCommentAdapter);
    }

    public static MessageCommentFragment newInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1434106869") ? (MessageCommentFragment) ipChange.ipc$dispatch("-1434106869", new Object[0]) : new MessageCommentFragment();
    }

    @Override // cn.damai.message.contract.FollowCommentContract.View
    public void followCommentNotify(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64633295")) {
            ipChange.ipc$dispatch("-64633295", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || !str.equals("6")) {
        } else {
            this.messageId = "0";
            initData();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-818697469") ? ((Integer) ipChange.ipc$dispatch("-818697469", new Object[]{this})).intValue() : R$layout.message_follow_comment_list;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065217189")) {
            ipChange.ipc$dispatch("1065217189", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32855590")) {
            ipChange.ipc$dispatch("32855590", new Object[]{this});
        } else {
            ((FollowCommentPresenter) this.mPresenter).setVM(this, (FollowCommentContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709240503")) {
            ipChange.ipc$dispatch("1709240503", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1923351843")) {
            ipChange.ipc$dispatch("-1923351843", new Object[]{this, view});
        } else if (view.getId() == R$id.tv_try_again) {
            initData();
        }
    }

    public void onItemClick(MessageItem messageItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292927992")) {
            ipChange.ipc$dispatch("-1292927992", new Object[]{this, messageItem, Integer.valueOf(i)});
        } else if (messageItem == null) {
        } else {
            String actionValue = messageItem.getActionValue();
            if (TextUtils.isEmpty(actionValue)) {
                return;
            }
            if (actionValue.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                String[] split = actionValue.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                String str = split[0];
                String str2 = split[1];
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                c.e().x(te1.m().i(z20.E(), str, str2, i));
                startCommentDetailActivity(str);
            } else if (TextUtils.isEmpty(actionValue)) {
            } else {
                c.e().x(te1.m().i(z20.E(), actionValue, "", i));
                startCommentDetailActivity(actionValue);
            }
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730439360")) {
            ipChange.ipc$dispatch("-1730439360", new Object[]{this, view});
        } else if (this.hasMore) {
            initData();
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608135264")) {
            ipChange.ipc$dispatch("-1608135264", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783790631")) {
            ipChange.ipc$dispatch("1783790631", new Object[]{this});
        }
    }

    @Override // cn.damai.message.contract.FollowCommentContract.View
    public void returnMessageItemListFailures(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781564639")) {
            ipChange.ipc$dispatch("-1781564639", new Object[]{this, str, str2});
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
        if (AndroidInstantRuntime.support(ipChange, "-1067467321")) {
            ipChange.ipc$dispatch("-1067467321", new Object[]{this, messageList});
            return;
        }
        stopProgressDialog();
        List<MessageItem> messageList2 = messageList.getMessageList();
        if (this.messageId.equals("0")) {
            this.mCommentAdapter.b();
            if (messageList2 != null && messageList2.size() != 0) {
                this.irc.setVisibility(0);
                this.mCommentAdapter.setData(messageList2);
            } else {
                this.irc.setVisibility(8);
                this.mEmptyTips.setVisibility(0);
                this.mTryAgainBtn.setVisibility(8);
                this.mEmptyTips.setText(getActivity().getResources().getText(R$string.message_comment_empty_tips));
            }
        } else if (messageList2 != null && messageList2.size() != 0) {
            this.hasMore = true;
            this.mCommentAdapter.a(messageList2);
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
        if (AndroidInstantRuntime.support(ipChange, "-1194267287")) {
            ipChange.ipc$dispatch("-1194267287", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363930085")) {
            ipChange.ipc$dispatch("1363930085", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1856980215")) {
            ipChange.ipc$dispatch("-1856980215", new Object[]{this, str});
        }
    }

    public void startCommentDetailActivity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200661415")) {
            ipChange.ipc$dispatch("-1200661415", new Object[]{this, str});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), CommentDetailActivity.class);
        intent.putExtra(g41.ISSUE_PARAM_COMMENT_ID, str);
        startActivity(intent);
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725606972")) {
            ipChange.ipc$dispatch("-725606972", new Object[]{this});
        }
    }

    public void updateTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214107788")) {
            ipChange.ipc$dispatch("-1214107788", new Object[]{this, Integer.valueOf(i)});
        } else if (this.headerTitle != null) {
            if (i > 0) {
                this.headerView.setVisibility(0);
                this.headerTitle.setVisibility(0);
                TextView textView = this.headerTitle;
                textView.setText("你有" + i + "个新消息");
                return;
            }
            this.headerView.setVisibility(8);
            this.headerTitle.setVisibility(8);
        }
    }
}
