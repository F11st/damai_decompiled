package cn.damai.tetris.component.girl.mvp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.girl.bean.ProjectViewModel;
import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cu0;
import tb.l62;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ColumnView extends AbsView<ColumnContract$Presenter> implements ColumnContract$View<ColumnContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private View mAllBtnLayout;
    private ImageView mBackImage;
    private View$OnClickListenerC1845b mItem1;
    private View$OnClickListenerC1845b mItem2;
    private View$OnClickListenerC1845b mItem3;
    private View$OnClickListenerC1845b mItem4;
    private View$OnClickListenerC1845b mItem5;
    private View$OnClickListenerC1845b mItem6;
    private List<View$OnClickListenerC1845b> mItemUIs;
    private View mRow2Layout;
    private TextView mSubTitleTv;
    private TextView mTitleTv;
    private int pic_height;
    private int pic_width;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.girl.mvp.ColumnView$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1844a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ StepBean a;
        final /* synthetic */ String b;

        View$OnClickListenerC1844a(StepBean stepBean, String str) {
            this.a = stepBean;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1793733380")) {
                ipChange.ipc$dispatch("1793733380", new Object[]{this, view});
            } else {
                ColumnView.this.getPresenter().allBtnClick(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.girl.mvp.ColumnView$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1845b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        View a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private ProjectViewModel f;
        private DMPosterView g;
        private int h;
        private int i;
        private String j;
        private String k;

        public View$OnClickListenerC1845b(View view) {
            this.a = view;
            this.g = (DMPosterView) view.findViewById(R$id.item_poster);
            this.b = (TextView) this.a.findViewById(R$id.item_title);
            this.c = (TextView) this.a.findViewById(R$id.tv_price_tag);
            this.d = (TextView) this.a.findViewById(R$id.item_price_tv);
            this.e = (TextView) this.a.findViewById(R$id.tv_qi);
        }

        public void a(ProjectViewModel projectViewModel, int i, int i2, String str, String str2, ColumnContract$Model columnContract$Model, JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1641359483")) {
                ipChange.ipc$dispatch("1641359483", new Object[]{this, projectViewModel, Integer.valueOf(i), Integer.valueOf(i2), str, str2, columnContract$Model, jSONObject});
                return;
            }
            this.f = projectViewModel;
            this.h = i;
            this.i = i2;
            this.j = str;
            this.k = str2;
            if (projectViewModel == null) {
                this.a.setOnClickListener(null);
                this.a.setTag(null);
                this.a.setVisibility(4);
            } else {
                this.a.setVisibility(0);
                this.a.setOnClickListener(this);
                this.b.setText(projectViewModel.title);
                if (!TextUtils.isEmpty(projectViewModel.priceTitle)) {
                    if (projectViewModel.priceTitle.contains("待定")) {
                        this.d.setText("价格待定");
                        this.d.setTextSize(1, 12.0f);
                        this.c.setVisibility(8);
                        this.e.setVisibility(8);
                    } else {
                        this.d.setText(projectViewModel.priceTitle);
                        this.d.setTextSize(1, 16.0f);
                        this.c.setVisibility(0);
                        this.e.setVisibility(0);
                    }
                } else {
                    this.d.setText("价格待定");
                    this.d.setTextSize(1, 12.0f);
                    this.c.setVisibility(8);
                    this.e.setVisibility(8);
                }
                this.g.setImageUrlForWebp(projectViewModel.picUrl, ColumnView.this.pic_width, ColumnView.this.pic_height);
                this.g.setCategoryTagName("");
                double d = projectViewModel.itemScore;
                if (d != -1.0d) {
                    this.g.setScoreStar(d, true);
                }
                if ("true".equals(columnContract$Model.getStyleValue(ProjectViewModel.RT_VISI)) && jSONObject != null && !TextUtils.isEmpty(columnContract$Model.getStyleValue(ProjectViewModel.RT_VALUE))) {
                    this.g.setCategoryTagName(jSONObject.getString(columnContract$Model.getStyleValue(ProjectViewModel.RT_VALUE)));
                }
            }
            cu0.a().b((ColumnPresenter) ColumnView.this.getPresenter(), this.a, this.h, this.i, str, projectViewModel.id, str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-217814651")) {
                ipChange.ipc$dispatch("-217814651", new Object[]{this, view});
            } else {
                ColumnView.this.getPresenter().projectItemClick(this.f, this.h, this.i, this.j, this.k);
            }
        }
    }

    public ColumnView(View view) {
        super(view);
        this.pic_width = 0;
        this.pic_height = 0;
        this.mItemUIs = new ArrayList();
        if (view == null) {
            return;
        }
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553299951")) {
            ipChange.ipc$dispatch("-1553299951", new Object[]{this});
            return;
        }
        this.mTitleTv = (TextView) getView().findViewById(R$id.tv_title);
        this.mSubTitleTv = (TextView) getView().findViewById(R$id.tv_subtitle);
        this.mBackImage = (ImageView) getView().findViewById(R$id.image_back);
        this.mAllBtnLayout = getView().findViewById(R$id.layout_all);
        this.mItem1 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_1_layout));
        this.mItem2 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_2_layout));
        this.mItem3 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_3_layout));
        this.mItem4 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_4_layout));
        this.mItem5 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_5_layout));
        this.mItem6 = new View$OnClickListenerC1845b(getView().findViewById(R$id.item_6_layout));
        this.mRow2Layout = getView().findViewById(R$id.layout_row2);
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$View
    public void initScreenSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900232087")) {
            ipChange.ipc$dispatch("-900232087", new Object[]{this});
            return;
        }
        Activity activity = ((ColumnPresenter) getPresenter()).getContext().getActivity();
        this.context = activity;
        this.pic_width = l62.a(activity, 103.0f);
        this.pic_height = l62.a(this.context, 138.0f);
    }

    @Override // cn.damai.tetris.component.girl.mvp.ColumnContract$View
    public void setData(StepBean stepBean, String str, ColumnContract$Model columnContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814076842")) {
            ipChange.ipc$dispatch("814076842", new Object[]{this, stepBean, str, columnContract$Model});
        } else if (stepBean != null && th2.b(stepBean.contentList) >= 3) {
            getView().setVisibility(0);
            C2497a.a().loadinto(columnContract$Model.getStyleValue("backPic"), this.mBackImage);
            this.mTitleTv.setText(columnContract$Model.getStyleValue("title"));
            this.mSubTitleTv.setText(columnContract$Model.getStyleValue("subTitle"));
            this.mItemUIs.clear();
            this.mItemUIs.add(this.mItem1);
            this.mItemUIs.add(this.mItem2);
            this.mItemUIs.add(this.mItem3);
            List<ProjectViewModel> list = stepBean.contentList;
            if (!TextUtils.isEmpty(columnContract$Model.getStyleValue("showAll")) && "true".equals(columnContract$Model.getStyleValue("showAll"))) {
                this.mAllBtnLayout.setVisibility(0);
                this.mAllBtnLayout.setOnClickListener(new View$OnClickListenerC1844a(stepBean, str));
            } else {
                this.mAllBtnLayout.setVisibility(8);
            }
            if (list.size() >= 6) {
                this.mRow2Layout.setVisibility(0);
                this.mItemUIs.add(this.mItem4);
                this.mItemUIs.add(this.mItem5);
                this.mItemUIs.add(this.mItem6);
            } else {
                this.mRow2Layout.setVisibility(8);
            }
            for (int i = 0; i < this.mItemUIs.size(); i++) {
                JSONObject jSONObject = null;
                try {
                    JSONArray jSONArray = columnContract$Model.getRawJson().getJSONArray("contentList");
                    if (jSONArray != null && jSONArray.size() > i) {
                        jSONObject = (JSONObject) jSONArray.get(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mItemUIs.get(i).a(list.get(i), stepBean.position, i, stepBean.groupId, columnContract$Model.getStyleValue("title"), columnContract$Model, jSONObject);
            }
        } else {
            getView().setVisibility(8);
        }
    }
}
