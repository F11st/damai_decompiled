package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftPropAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.YKLPropPageView;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PropShowView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View loadingView;
    private List<GiftPropBean> mData;
    private String mLastSelectedPid;
    private PropListener mListener;
    private GiftPropBean mSelectedPropInfoBean;
    private GiftBaseView propPageView;
    private TextView refreshBtn;
    private View refreshLayout;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface PropListener {
        void morePropBtnClick();

        void onChildPageChange(int i, List<GiftPropBean> list);

        void onItemChecked(GiftPropBean giftPropBean);

        void onItemClick(AdapterView<?> adapterView, View view, int i, long j, CommonAdapter<GiftPropBean> commonAdapter);

        void onRefresh();
    }

    public PropShowView(Context context) {
        this(context, null);
    }

    public void addItem(int i, GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1162632670")) {
            ipChange.ipc$dispatch("1162632670", new Object[]{this, Integer.valueOf(i), giftPropBean});
            return;
        }
        List<GiftPropBean> list = this.mData;
        if (list == null || i >= list.size()) {
            return;
        }
        if (i < 0) {
            this.mData.add(giftPropBean);
        } else {
            this.mData.add(i, giftPropBean);
        }
        setData(this.mData);
    }

    public void deleteItem(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419985767")) {
            ipChange.ipc$dispatch("1419985767", new Object[]{this, str});
            return;
        }
        List<GiftPropBean> list = this.mData;
        if (list != null) {
            Iterator<GiftPropBean> it = list.iterator();
            while (it.hasNext()) {
                GiftPropBean next = it.next();
                if (next != null && !TextUtils.isEmpty(next.id) && next.id.equals(str)) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "iterator.remove();");
                    it.remove();
                }
            }
            setData(this.mData);
        }
    }

    public GiftPropBean getSeletedProp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "360693574") ? (GiftPropBean) ipChange.ipc$dispatch("360693574", new Object[]{this}) : this.mSelectedPropInfoBean;
    }

    public void resetView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796413925")) {
            ipChange.ipc$dispatch("-1796413925", new Object[]{this});
            return;
        }
        this.loadingView.setVisibility(0);
        this.refreshLayout.setVisibility(8);
        this.propPageView.setVisibility(4);
    }

    public void setData(List<GiftPropBean> list) {
        PropListener propListener;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985400844")) {
            ipChange.ipc$dispatch("-985400844", new Object[]{this, list});
            return;
        }
        this.loadingView.setVisibility(8);
        if (list != null && list.size() != 0) {
            this.mData = list;
            if (!TextUtils.isEmpty(this.mLastSelectedPid)) {
                ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "has prop id = " + this.mLastSelectedPid);
                for (GiftPropBean giftPropBean : this.mData) {
                    if (giftPropBean != null && TextUtils.equals(this.mLastSelectedPid, giftPropBean.id)) {
                        giftPropBean.isChecked = true;
                        this.mSelectedPropInfoBean = giftPropBean;
                    }
                }
            }
            if (this.mSelectedPropInfoBean != null) {
                Iterator<GiftPropBean> it = this.mData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    GiftPropBean next = it.next();
                    if (next != null && TextUtils.equals(this.mSelectedPropInfoBean.id, next.id)) {
                        next.isChecked = true;
                        this.mSelectedPropInfoBean = next;
                        this.mLastSelectedPid = next.id;
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.mSelectedPropInfoBean = null;
                }
            }
            if (this.mSelectedPropInfoBean == null) {
                GiftPropBean giftPropBean2 = this.mData.get(0);
                this.mSelectedPropInfoBean = giftPropBean2;
                giftPropBean2.isChecked = true;
                if (giftPropBean2 != null) {
                    this.mLastSelectedPid = giftPropBean2.id;
                }
            }
            GiftPropBean giftPropBean3 = this.mSelectedPropInfoBean;
            if (giftPropBean3 != null && (propListener = this.mListener) != null) {
                propListener.onItemChecked(giftPropBean3);
            }
            this.propPageView.setData(this.mData);
            if (this.mListener != null && ((YKLPropPageView) this.propPageView).getFirstPageList() != null) {
                this.mListener.onChildPageChange(0, ((YKLPropPageView) this.propPageView).getFirstPageList());
            }
            this.propPageView.setVisibility(0);
            this.propPageView.setItemClickInterface(new GiftBaseView.OnItemClickInterface<GiftPropBean>() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.OnItemClickInterface
                public void onChildPageChangeListener(int i, List<GiftPropBean> list2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "241664259")) {
                        ipChange2.ipc$dispatch("241664259", new Object[]{this, Integer.valueOf(i), list2});
                    } else if (PropShowView.this.mListener != null) {
                        PropShowView.this.mListener.onChildPageChange(i, list2);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.OnItemClickInterface
                public void onItemClick(AdapterView<?> adapterView, View view, int i, int i2, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "272762455")) {
                        ipChange2.ipc$dispatch("272762455", new Object[]{this, adapterView, view, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), commonAdapter});
                        return;
                    }
                    GiftPropBean item = commonAdapter.getItem(i2);
                    if (item == null) {
                        return;
                    }
                    if (PropShowView.this.mSelectedPropInfoBean == null || !TextUtils.equals(PropShowView.this.mSelectedPropInfoBean.id, item.id)) {
                        if (item.isMoreBtn) {
                            if (PropShowView.this.mListener != null) {
                                PropShowView.this.mListener.morePropBtnClick();
                                return;
                            }
                            return;
                        }
                        PropShowView.this.mSelectedPropInfoBean = commonAdapter.getItem(i2);
                        HashMap<CommonAdapter<T>, NoScrollGridView> hashMap = PropShowView.this.propPageView.mCategoryAllAdapterGV;
                        for (GiftPropAdapter giftPropAdapter : hashMap.keySet()) {
                            giftPropAdapter.unSelected(hashMap.get(giftPropAdapter), PropShowView.this.mLastSelectedPid);
                        }
                        ((GiftPropAdapter) commonAdapter).selected(adapterView, i2);
                        if (PropShowView.this.getHandler() != null) {
                            PropShowView.this.getHandler().post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.2.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-605389303")) {
                                        ipChange3.ipc$dispatch("-605389303", new Object[]{this});
                                    } else {
                                        ToastUtil.showCenter(PropShowView.this.getContext(), PropShowView.this.mSelectedPropInfoBean.desc);
                                    }
                                }
                            });
                        }
                        if (PropShowView.this.mListener != null) {
                            PropShowView.this.mListener.onItemClick(adapterView, view, i2, j, commonAdapter);
                        }
                        PropShowView propShowView = PropShowView.this;
                        propShowView.mLastSelectedPid = propShowView.mSelectedPropInfoBean.id;
                    }
                }
            });
            return;
        }
        this.refreshLayout.setVisibility(0);
        this.propPageView.setVisibility(4);
    }

    public void setListener(PropListener propListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530606925")) {
            ipChange.ipc$dispatch("-1530606925", new Object[]{this, propListener});
        } else {
            this.mListener = propListener;
        }
    }

    public void setPageViewParams(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293891792")) {
            ipChange.ipc$dispatch("-1293891792", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.propPageView.setRowNum(i);
        }
    }

    public void setSelectedProp(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318876569")) {
            ipChange.ipc$dispatch("1318876569", new Object[]{this, str});
        } else {
            this.mLastSelectedPid = str;
        }
    }

    public void updateItem(GiftPropBean giftPropBean) {
        GiftBaseView giftBaseView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570590101")) {
            ipChange.ipc$dispatch("1570590101", new Object[]{this, giftPropBean});
        } else if (giftPropBean != null && (giftBaseView = this.propPageView) != null) {
            HashMap<CommonAdapter<T>, NoScrollGridView> hashMap = giftBaseView.mCategoryAllAdapterGV;
            for (GiftPropAdapter giftPropAdapter : hashMap.keySet()) {
                List<GiftPropBean> data = giftPropAdapter.getData();
                if (data != null) {
                    for (int i = 0; i < data.size(); i++) {
                        GiftPropBean giftPropBean2 = data.get(i);
                        if (giftPropBean2 != null && !TextUtils.isEmpty(giftPropBean2.id) && giftPropBean2.id.equals(giftPropBean.id)) {
                            giftPropBean2.replace(giftPropBean);
                            giftPropAdapter.updateCount(hashMap.get(giftPropAdapter), i);
                        }
                    }
                }
            }
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824039997")) {
            ipChange.ipc$dispatch("824039997", new Object[]{this, giftTheme});
        } else {
            this.refreshBtn.setBackground(ThemeUtils.getGradientDrawable(giftTheme.btnGiantStartColor, giftTheme.btnGiantEndColor, GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, DensityUtil.dip2px(getContext(), 1.0f) * 15));
        }
    }

    public PropShowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PropShowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectedPropInfoBean = null;
        this.mLastSelectedPid = null;
        this.mData = new ArrayList();
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_prop_show_layout, (ViewGroup) this, true);
        this.propPageView = (YKLPropPageView) findViewById(R.id.id_prop_pager);
        this.refreshLayout = findViewById(R.id.refresh_prop_layout);
        this.refreshBtn = (TextView) findViewById(R.id.refresh_prop_btn);
        this.loadingView = findViewById(R.id.loading_prop_layout);
        this.refreshBtn.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-36604679")) {
                    ipChange.ipc$dispatch("-36604679", new Object[]{this, view});
                    return;
                }
                if (PropShowView.this.mListener != null) {
                    PropShowView.this.mListener.onRefresh();
                }
                PropShowView.this.refreshLayout.setVisibility(8);
                PropShowView.this.loadingView.setVisibility(0);
            }
        });
    }
}
