package cn.damai.tetris.component.brand;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.tetris.component.brand.BrandQuickReportContract;
import cn.damai.tetris.component.brand.bean.BrandQuickReportContentBean;
import cn.damai.tetris.component.ip.bean.ContentInfo;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.gc;
import tb.ja;
import tb.jn1;
import tb.pb;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandQuickReportPresenter extends BasePresenter<BrandQuickReportContract.Model, BrandQuickReportContract.View, BaseSection> implements BrandQuickReportContract.Presenter<BrandQuickReportContract.Model, BrandQuickReportContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String idList;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BrandQuickReportContract.Model a;

        a(BrandQuickReportContract.Model model) {
            this.a = model;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "324316660")) {
                ipChange.ipc$dispatch("324316660", new Object[]{this, view});
                return;
            }
            NavProxy.from(((BasePresenter) BrandQuickReportPresenter.this).mContext.getActivity()).toUri(this.a.getSchema());
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            if (BrandQuickReportPresenter.this.mTrackInfo != null) {
                BrandQuickReportPresenter brandQuickReportPresenter = BrandQuickReportPresenter.this;
                brandQuickReportPresenter.userTrack(TrackType.click, view, brandQuickReportPresenter.mTrackInfo.trackB, BrandQuickReportPresenter.this.mTrackInfo.trackC, "all", hashMap, true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentInfo a;
        final /* synthetic */ int b;

        b(ContentInfo contentInfo, int i) {
            this.a = contentInfo;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1859360267")) {
                ipChange.ipc$dispatch("-1859360267", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a.schema)) {
            } else {
                NavProxy.from(((BasePresenter) BrandQuickReportPresenter.this).mContext.getActivity()).toUri(this.a.schema);
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", z20.E());
                hashMap.put(pb.CNT_CONTENT_ID, this.a.id);
                if (BrandQuickReportPresenter.this.mTrackInfo != null) {
                    BrandQuickReportPresenter brandQuickReportPresenter = BrandQuickReportPresenter.this;
                    TrackType trackType = TrackType.click;
                    String str = brandQuickReportPresenter.mTrackInfo.trackB;
                    String str2 = BrandQuickReportPresenter.this.mTrackInfo.trackC;
                    brandQuickReportPresenter.userTrack(trackType, view, str, str2, "content_" + this.b, hashMap, true);
                }
            }
        }
    }

    public BrandQuickReportPresenter(BrandQuickReportView brandQuickReportView, String str, ja jaVar) {
        super(brandQuickReportView, str, jaVar);
    }

    private void imgShow(DMPosterView dMPosterView, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034312762")) {
            ipChange.ipc$dispatch("1034312762", new Object[]{this, dMPosterView, str, str2});
            return;
        }
        dMPosterView.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        dMPosterView.setImageUrl(str);
        dMPosterView.getImageView().setGifRoundCornerSupport(true);
        dMPosterView.getImageView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        if ("2".equals(str2)) {
            dMPosterView.setVideoIconVisibility(0);
        } else {
            dMPosterView.setVideoIconVisibility(8);
        }
    }

    private void ipvuvShow(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1274518553")) {
            ipChange.ipc$dispatch("-1274518553", new Object[]{this, textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            gc.a(textView, str + "人阅读");
        } else {
            gc.a(textView, "");
        }
    }

    private void item(ArrayList<BrandQuickReportContentBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472147961")) {
            ipChange.ipc$dispatch("-472147961", new Object[]{this, arrayList});
            return;
        }
        if (this.mContext.getActivity() != null && !this.mContext.getActivity().isFinishing() && this.mContext.getActivity().getResources() != null) {
            if (arrayList.size() == 1) {
                getView().getSpecialItem().setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.brand_card_quickreport_item_allradus_bg));
                getView().getNormalItemOne().setVisibility(8);
                getView().getNormalItemTwo().setVisibility(8);
                getView().getBlackHolder().setVisibility(8);
                this.idList = jn1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + jn1.ARRAY_END_STR;
            } else {
                getView().getSpecialItem().setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.brand_card_quickreport_item_bg));
                getView().getBlackHolder().setVisibility(0);
                getView().getNormalItemOne().setVisibility(0);
                if (arrayList.size() == 2) {
                    getView().getNormalItemTwo().setVisibility(8);
                    this.idList = jn1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + "," + arrayList.get(1).contentInfo.id + jn1.ARRAY_END_STR;
                } else if (arrayList.size() > 2) {
                    getView().getNormalItemTwo().setVisibility(0);
                    this.idList = jn1.ARRAY_START_STR + arrayList.get(0).contentInfo.id + "," + arrayList.get(1).contentInfo.id + "," + arrayList.get(2).contentInfo.id + jn1.ARRAY_END_STR;
                }
            }
        }
        if (arrayList.get(0) != null) {
            BrandQuickReportContentBean brandQuickReportContentBean = arrayList.get(0);
            imgShow(getView().getSpecialImg(), brandQuickReportContentBean.coverImage, brandQuickReportContentBean.contentTag);
            getView().getSpecialImg().setVideoIconSize(24.0f, 40.0f, 22.0f);
            ipvuvShow(getView().getSpecialIpvuv(), brandQuickReportContentBean.ipvuv);
            if (brandQuickReportContentBean.contentInfo != null) {
                gc.a(getView().getSpecialTitle(), brandQuickReportContentBean.contentInfo.title);
                onClickJump(getView().getSpecialItem(), brandQuickReportContentBean.contentInfo, 0);
            }
        }
        if (arrayList.size() > 1 && arrayList.get(1) != null) {
            BrandQuickReportContentBean brandQuickReportContentBean2 = arrayList.get(1);
            imgShow(getView().getNormalItemOneImg(), brandQuickReportContentBean2.coverImage, brandQuickReportContentBean2.contentTag);
            getView().getNormalItemOneImg().setVideoIconSize(14, 31, 21);
            ipvuvShow(getView().getNormalItemOneIpvuv(), brandQuickReportContentBean2.ipvuv);
            if (brandQuickReportContentBean2.contentInfo != null) {
                gc.a(getView().getNormalItemOneTitle(), brandQuickReportContentBean2.contentInfo.title);
                onClickJump(getView().getNormalItemOne(), brandQuickReportContentBean2.contentInfo, 1);
            }
        }
        if (arrayList.size() <= 2 || arrayList.get(2) == null) {
            return;
        }
        BrandQuickReportContentBean brandQuickReportContentBean3 = arrayList.get(2);
        imgShow(getView().getNormalItemTwoImg(), brandQuickReportContentBean3.coverImage, brandQuickReportContentBean3.contentTag);
        getView().getNormalItemTwoImg().setVideoIconSize(14, 31, 21);
        ipvuvShow(getView().getNormalItemTwoIpvuv(), brandQuickReportContentBean3.ipvuv);
        if (brandQuickReportContentBean3.contentInfo != null) {
            gc.a(getView().getNormalItemTwoTitle(), brandQuickReportContentBean3.contentInfo.title);
            onClickJump(getView().getNormalItemTwo(), brandQuickReportContentBean3.contentInfo, 2);
        }
    }

    private void onClickJump(RelativeLayout relativeLayout, ContentInfo contentInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290607960")) {
            ipChange.ipc$dispatch("-290607960", new Object[]{this, relativeLayout, contentInfo, Integer.valueOf(i)});
        } else {
            relativeLayout.setOnClickListener(new b(contentInfo, i));
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558103373")) {
            ipChange.ipc$dispatch("-558103373", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353412080")) {
            return ((Boolean) ipChange.ipc$dispatch("-1353412080", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BrandQuickReportContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562335025")) {
            ipChange.ipc$dispatch("-562335025", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        gc.a(getView().getBrandNew(), model.getBrandNew());
        if (!TextUtils.isEmpty(model.getLatestPublishTimeStr())) {
            getView().getUpdateTimePoint().setVisibility(0);
            TextView updateTime = getView().getUpdateTime();
            updateTime.setText(model.getLatestPublishTimeStr() + "更新");
        } else {
            getView().getUpdateTime().setText("");
            getView().getUpdateTimePoint().setVisibility(8);
        }
        if (!TextUtils.isEmpty(model.getTotal())) {
            try {
                if (Integer.parseInt(model.getTotal()) > 3 && !TextUtils.isEmpty(model.getSchema())) {
                    getView().getLlMore().setVisibility(0);
                    getView().getLlMore().setOnClickListener(new a(model));
                } else {
                    getView().getLlMore().setVisibility(8);
                }
            } catch (Exception unused) {
                getView().getLlMore().setVisibility(8);
            }
        }
        if (model.getContents() != null && model.getContents().size() > 0) {
            item(model.getContents());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode_m", z20.E());
        hashMap.put(pb.CNT_CONTENT_ID, this.idList);
        userTrackExpose(getView().getBrandLayout(), "content", hashMap, false);
    }
}
