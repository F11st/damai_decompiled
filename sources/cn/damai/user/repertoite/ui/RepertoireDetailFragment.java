package cn.damai.user.repertoite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.model.UserAttentionBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter;
import cn.damai.user.repertoite.bean.RepertoireDetailDataBean;
import cn.damai.user.repertoite.bean.comment.RepertoireDetailCommentBean;
import cn.damai.user.repertoite.contract.RepertoireDetailContract;
import cn.damai.user.repertoite.model.RepertoireDetailModel;
import cn.damai.user.repertoite.net.RepertoireDetaiRequest;
import cn.damai.user.repertoite.presenter.RepertoireDetailPresenter;
import cn.damai.user.repertoite.view.HorizontalRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.qd2;
import tb.t60;
import tb.u12;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RepertoireDetailFragment extends DamaiBaseMvpFragment<RepertoireDetailPresenter, RepertoireDetailModel> implements RepertoireDetailContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MYSELF = "myself";
    public static final String REPERTOIREID = "repertoireId";
    public static final String USERTYPE = "userType";
    private HorizontalImageScrollAdapter mAdapterImgs;
    private String mCityId;
    private FlowLayout mFlSales;
    private TextView mFocusComment;
    private TextView mFocusCommentTitle;
    private TextView mImgsTitle;
    private LayoutInflater mInflater;
    private View mOnsaleProjectTopLine;
    private TextView mOnsaleTitle;
    private TextView mProjectCity;
    private ImageView mProjectImage;
    private TextView mProjectName;
    private View mProjectOnsale;
    private ViewGroup mProjectOnsaleCity;
    private TextView mProjectPrice;
    private HorizontalRecyclerView mRlvImgs;
    private TextView mSummary;
    private TextView mSummaryTitle;
    private String mRepertoireId = "";
    private String mUserType = "";
    private boolean mMySelf = false;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.repertoite.ui.RepertoireDetailFragment$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2700a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        RepertoireDetailDataBean.ProjectCardInfoBean a;
        int b;

        public View$OnClickListenerC2700a(RepertoireDetailDataBean.ProjectCardInfoBean projectCardInfoBean, int i) {
            this.b = 0;
            this.a = projectCardInfoBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-512192565")) {
                ipChange.ipc$dispatch("-512192565", new Object[]{this, view});
                return;
            }
            C0529c.e().x(u12.h().m(RepertoireDetailFragment.this.mRepertoireId, RepertoireDetailFragment.this.mUserType, RepertoireDetailFragment.this.mMySelf, this.a.getProjectId(), this.b));
            Intent intent = new Intent();
            intent.putExtra(IssueConstants.ProjectID, Long.valueOf(this.a.getProjectId()));
            qd2.a(RepertoireDetailFragment.this.getContext(), this.a.schema, intent.getExtras());
        }
    }

    private void getRepertoireData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541684484")) {
            ipChange.ipc$dispatch("-541684484", new Object[]{this});
            return;
        }
        RepertoireDetaiRequest repertoireDetaiRequest = new RepertoireDetaiRequest();
        repertoireDetaiRequest.cityId = String.valueOf(this.mCityId);
        repertoireDetaiRequest.repertoireId = String.valueOf(this.mRepertoireId);
        repertoireDetaiRequest.request(new DMMtopRequestListener<RepertoireDetailDataBean>(RepertoireDetailDataBean.class) { // from class: cn.damai.user.repertoite.ui.RepertoireDetailFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1758086203")) {
                    ipChange2.ipc$dispatch("1758086203", new Object[]{this, str, str2});
                } else {
                    RepertoireDetailFragment.this.repertoireDetailFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RepertoireDetailDataBean repertoireDetailDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2004826719")) {
                    ipChange2.ipc$dispatch("-2004826719", new Object[]{this, repertoireDetailDataBean});
                } else {
                    RepertoireDetailFragment.this.repertoireDetailSuccess(repertoireDetailDataBean);
                }
            }
        });
    }

    private void updateRepertoireInfo(RepertoireDetailDataBean repertoireDetailDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215924232")) {
            ipChange.ipc$dispatch("1215924232", new Object[]{this, repertoireDetailDataBean});
        } else if (repertoireDetailDataBean.getRepertoireInfo() != null) {
            if (TextUtils.isEmpty(repertoireDetailDataBean.getRepertoireInfo().getFocusComment())) {
                this.mFocusCommentTitle.setVisibility(8);
                this.mFocusComment.setVisibility(8);
            } else {
                this.mFocusCommentTitle.setVisibility(0);
                this.mFocusComment.setVisibility(0);
                this.mFocusComment.setText(repertoireDetailDataBean.getRepertoireInfo().getFocusComment());
            }
            if (TextUtils.isEmpty(repertoireDetailDataBean.getRepertoireInfo().getSummary())) {
                this.mSummaryTitle.setVisibility(8);
                this.mSummary.setVisibility(8);
            } else {
                this.mSummaryTitle.setVisibility(0);
                this.mSummary.setVisibility(0);
                this.mSummary.setText(Html.fromHtml(repertoireDetailDataBean.getRepertoireInfo().getSummary()));
            }
            if (repertoireDetailDataBean.getRepertoireInfo().getStoryPicsInfo() != null && repertoireDetailDataBean.getRepertoireInfo().getStoryPicsInfo().getPicInfos().size() > 1) {
                this.mImgsTitle.setVisibility(0);
                this.mRlvImgs.setVisibility(0);
                HorizontalImageScrollAdapter horizontalImageScrollAdapter = this.mAdapterImgs;
                if (horizontalImageScrollAdapter == null) {
                    HorizontalImageScrollAdapter horizontalImageScrollAdapter2 = new HorizontalImageScrollAdapter(getContext(), this.mRepertoireId, this.mUserType, this.mMySelf, repertoireDetailDataBean.getRepertoireInfo().getStoryPicsInfo().getPicInfos());
                    this.mAdapterImgs = horizontalImageScrollAdapter2;
                    this.mRlvImgs.setAdapter(horizontalImageScrollAdapter2);
                    return;
                }
                horizontalImageScrollAdapter.j(repertoireDetailDataBean.getRepertoireInfo().getStoryPicsInfo().getPicInfos());
                this.mAdapterImgs.notifyDataSetChanged();
                return;
            }
            this.mImgsTitle.setVisibility(8);
            this.mRlvImgs.setVisibility(8);
        }
    }

    private void updateSaleProject(RepertoireDetailDataBean repertoireDetailDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918379255")) {
            ipChange.ipc$dispatch("-1918379255", new Object[]{this, repertoireDetailDataBean});
        } else if (repertoireDetailDataBean.getProjectCardInfo() != null && repertoireDetailDataBean.getProjectCardInfo().size() > 0) {
            this.mProjectOnsale.setVisibility(0);
            this.mOnsaleTitle.setVisibility(0);
            this.mProjectOnsaleCity.removeAllViews();
            if (repertoireDetailDataBean.getProjectCardInfo().size() > 1) {
                this.mOnsaleProjectTopLine.setVisibility(0);
            } else {
                this.mOnsaleProjectTopLine.setVisibility(8);
            }
            for (int i = 0; i < repertoireDetailDataBean.getProjectCardInfo().size(); i++) {
                RepertoireDetailDataBean.ProjectCardInfoBean projectCardInfoBean = repertoireDetailDataBean.getProjectCardInfo().get(i);
                if (i == 0) {
                    DMImageCreator k = C0504a.b().c(projectCardInfoBean.getProjectPic()).k(new DMRoundedCornersBitmapProcessor(t60.a(getContext(), 3.0f), 0));
                    int i2 = R$drawable.uikit_default_image_bg_gradient;
                    k.i(i2).c(i2).g(this.mProjectImage);
                    this.mProjectName.setText(projectCardInfoBean.getProjectName());
                    TextView textView = this.mProjectCity;
                    textView.setText(projectCardInfoBean.getCityName() + " / " + projectCardInfoBean.getShowTime() + " / " + projectCardInfoBean.getVenueName());
                    this.mProjectPrice.setText(projectCardInfoBean.getPriceRange());
                    this.mFlSales.removeAllViews();
                    this.mFlSales.setSingleLine(false);
                    if (!wh2.j(projectCardInfoBean.getRecReason())) {
                        LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R$layout.commonbusinesss_sales_item, (ViewGroup) null);
                        TextView textView2 = (TextView) linearLayout.findViewById(R$id.sale_item_label);
                        textView2.setText(projectCardInfoBean.getRecReason());
                        textView2.setBackgroundResource(R$drawable.commonbusiness_sales_bg);
                        textView2.setTextColor(ContextCompat.getColor(getContext(), R$color.white));
                        this.mFlSales.addView(linearLayout);
                    }
                    if (projectCardInfoBean.getTagList() != null && projectCardInfoBean.getTagList().size() > 0) {
                        for (int i3 = 0; i3 < projectCardInfoBean.getTagList().size(); i3++) {
                            View inflate = View.inflate(getContext(), R$layout.commonbusinesss_sales_item, null);
                            TextView textView3 = (TextView) inflate.findViewById(R$id.sale_item_label);
                            textView3.setText(projectCardInfoBean.getTagList().get(i3));
                            textView3.setBackgroundResource(R$drawable.commonbusiness_sales_bg_10);
                            textView3.setTextColor(ContextCompat.getColor(getContext(), R$color.main_color));
                            this.mFlSales.addView(inflate);
                        }
                    }
                    this.mProjectOnsale.setOnClickListener(new View$OnClickListenerC2700a(projectCardInfoBean, i));
                } else {
                    View inflate2 = LayoutInflater.from(getContext()).inflate(R$layout.repertoire_project_onsale_city, this.mProjectOnsaleCity, false);
                    ((TextView) inflate2.findViewById(R$id.tv_city)).setText(projectCardInfoBean.getCityName());
                    ((TextView) inflate2.findViewById(R$id.tv_time)).setText(projectCardInfoBean.getShowTime());
                    ((TextView) inflate2.findViewById(R$id.tv_address)).setText(projectCardInfoBean.getVenueName());
                    inflate2.setOnClickListener(new View$OnClickListenerC2700a(projectCardInfoBean, i));
                    this.mProjectOnsaleCity.addView(inflate2);
                }
            }
        } else {
            this.mProjectOnsaleCity.removeAllViews();
            this.mProjectOnsale.setVisibility(8);
            this.mOnsaleTitle.setVisibility(8);
            this.mOnsaleProjectTopLine.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1820702904") ? ((Integer) ipChange.ipc$dispatch("1820702904", new Object[]{this})).intValue() : R$layout.repertoire_detail_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146263504")) {
            ipChange.ipc$dispatch("2146263504", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-814447013")) {
            ipChange.ipc$dispatch("-814447013", new Object[]{this});
        } else {
            ((RepertoireDetailPresenter) this.mPresenter).setVM(this, (RepertoireDetailContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-99110046")) {
            ipChange.ipc$dispatch("-99110046", new Object[]{this});
            return;
        }
        this.mImgsTitle = (TextView) this.rootView.findViewById(R$id.tv_imgs_title);
        this.mRlvImgs = (HorizontalRecyclerView) this.rootView.findViewById(R$id.rlv_imgs);
        this.mFocusCommentTitle = (TextView) this.rootView.findViewById(R$id.tv_focus_comment_title);
        this.mFocusComment = (TextView) this.rootView.findViewById(R$id.tv_focus_comment);
        this.mSummaryTitle = (TextView) this.rootView.findViewById(R$id.tv_summary_title);
        this.mSummary = (TextView) this.rootView.findViewById(R$id.tv_summary);
        this.mOnsaleTitle = (TextView) this.rootView.findViewById(R$id.tv_onsale_title);
        this.mProjectOnsale = this.rootView.findViewById(R$id.il_project_onsale);
        this.mOnsaleProjectTopLine = this.rootView.findViewById(R$id.v_onsale_project_top_line);
        this.mProjectOnsaleCity = (ViewGroup) this.rootView.findViewById(R$id.ll_project_onsale_city);
        this.mProjectImage = (ImageView) this.mProjectOnsale.findViewById(R$id.iv_project_image);
        this.mProjectName = (TextView) this.mProjectOnsale.findViewById(R$id.tv_project_name);
        this.mProjectCity = (TextView) this.mProjectOnsale.findViewById(R$id.tv_project_city);
        this.mFlSales = (FlowLayout) this.mProjectOnsale.findViewById(R$id.fl_sales);
        this.mProjectPrice = (TextView) this.mProjectOnsale.findViewById(R$id.tv_project_sale_price);
        if (getArguments() != null) {
            this.mRepertoireId = getArguments().getString(REPERTOIREID);
            this.mUserType = getArguments().getString(USERTYPE);
            this.mMySelf = getArguments().getBoolean(MYSELF);
        }
        String c = z20.c();
        this.mCityId = c;
        if (wh2.j(c)) {
            this.mCityId = "852";
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRlvImgs.setLayoutManager(linearLayoutManager);
        HorizontalImageScrollAdapter horizontalImageScrollAdapter = new HorizontalImageScrollAdapter(getContext(), this.mRepertoireId, this.mUserType, this.mMySelf);
        this.mAdapterImgs = horizontalImageScrollAdapter;
        horizontalImageScrollAdapter.i(this.mRepertoireId);
        this.mRlvImgs.setAdapter(this.mAdapterImgs);
        getRepertoireData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1056278728")) {
            ipChange.ipc$dispatch("1056278728", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949254380")) {
            return (View) ipChange.ipc$dispatch("1949254380", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mInflater = layoutInflater;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void onPraiseViewOnClick(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541889650")) {
            ipChange.ipc$dispatch("-1541889650", new Object[]{this, commentsItemBean});
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void onSelfPublishCommentSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389936949")) {
            ipChange.ipc$dispatch("-389936949", new Object[]{this});
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void relationUpdateFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109543528")) {
            ipChange.ipc$dispatch("1109543528", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void relationUpdateSuccess(UserAttentionBean.DataBean dataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425515974")) {
            ipChange.ipc$dispatch("-1425515974", new Object[]{this, dataBean});
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void repertoireDetailFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343941253")) {
            ipChange.ipc$dispatch("343941253", new Object[]{this, str, str2});
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void repertoireDetailSuccess(RepertoireDetailDataBean repertoireDetailDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335445993")) {
            ipChange.ipc$dispatch("-1335445993", new Object[]{this, repertoireDetailDataBean});
        } else if (repertoireDetailDataBean != null) {
            updateRepertoireInfo(repertoireDetailDataBean);
            updateSaleProject(repertoireDetailDataBean);
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void returnCommentsList(RepertoireDetailCommentBean repertoireDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117928189")) {
            ipChange.ipc$dispatch("-1117928189", new Object[]{this, repertoireDetailCommentBean});
        }
    }

    @Override // cn.damai.user.repertoite.contract.RepertoireDetailContract.View
    public void returnCommentsListError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857584385")) {
            ipChange.ipc$dispatch("857584385", new Object[]{this, str, str2});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041569890")) {
            ipChange.ipc$dispatch("-2041569890", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-475703078")) {
            ipChange.ipc$dispatch("-475703078", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228254014")) {
            ipChange.ipc$dispatch("228254014", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522018503")) {
            ipChange.ipc$dispatch("-1522018503", new Object[]{this});
        }
    }
}
