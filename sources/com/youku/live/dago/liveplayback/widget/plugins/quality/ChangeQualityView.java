package com.youku.live.dago.liveplayback.widget.plugins.quality;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.PluginAnimationUtils;
import com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityContract;
import com.youku.live.dago.liveplayback.widget.plugins.quality.QualityAdapterNew;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChangeQualityView extends LazyInflatedView implements ChangeQualityContract.View, QualityAdapterNew.OnRecyclerViewItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public QualityAdapterNew mAdapter;
    private RelativeLayout mChangeQualityLayout;
    private ChangeQualityContract.Presenter mPresenter;
    private RecyclerView mRecycleView;

    public ChangeQualityView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i, ViewPlaceholder viewPlaceholder) {
        super(alixPlayerContext, iLMLayerManager, str, i, viewPlaceholder);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465889938")) {
            ipChange.ipc$dispatch("465889938", new Object[]{this});
        } else if (this.isInflated) {
            this.mInflatedView.post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1245843325")) {
                        ipChange2.ipc$dispatch("1245843325", new Object[]{this});
                        return;
                    }
                    boolean z = ((LazyInflatedView) ChangeQualityView.this).mInflatedView.getVisibility() == 0;
                    ChangeQualityView.super.hide();
                    if (z) {
                        PluginAnimationUtils.pluginRightHide(((LazyInflatedView) ChangeQualityView.this).mInflatedView, null);
                    }
                }
            });
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.QualityAdapterNew.OnRecyclerViewItemClickListener
    public void onAutoQualityInfoClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925026247")) {
            ipChange.ipc$dispatch("1925026247", new Object[]{this, view});
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.QualityAdapterNew.OnRecyclerViewItemClickListener
    public void onCloseAreaClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507699341")) {
            ipChange.ipc$dispatch("-507699341", new Object[]{this});
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866900732")) {
            ipChange.ipc$dispatch("-1866900732", new Object[]{this, view});
            return;
        }
        this.mChangeQualityLayout = (RelativeLayout) view.findViewById(R.id.change_quality_layout);
        this.mRecycleView = (RecyclerView) view.findViewById(R.id.recyclerview);
        this.mChangeQualityLayout.setClickable(false);
        this.mAdapter = new QualityAdapterNew(this.mContext);
        this.mRecycleView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mRecycleView.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(this);
        this.mRecycleView.setNestedScrollingEnabled(false);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1929299742")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-1929299742", new Object[]{this, view2, motionEvent})).booleanValue();
                }
                ChangeQualityView.this.hide();
                return true;
            }
        });
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.QualityAdapterNew.OnRecyclerViewItemClickListener
    public void onItemClick(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652287633")) {
            ipChange.ipc$dispatch("1652287633", new Object[]{this, view, Integer.valueOf(i)});
        } else {
            this.mPresenter.changeQuality(i);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.quality.QualityAdapterNew.OnRecyclerViewItemClickListener
    public void onQualityInfoClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197505736")) {
            ipChange.ipc$dispatch("-1197505736", new Object[]{this, view});
        } else {
            this.mPresenter.showQualityInfo(view);
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620561655")) {
            ipChange.ipc$dispatch("1620561655", new Object[]{this});
            return;
        }
        boolean isShow = isShow();
        super.show();
        if (isShow) {
            return;
        }
        PluginAnimationUtils.pluginRightShow(this.mInflatedView, null);
    }

    @Override // com.youku.alixplugin.view.BaseView
    public void setPresenter(ChangeQualityContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038803093")) {
            ipChange.ipc$dispatch("-2038803093", new Object[]{this, presenter});
        } else {
            this.mPresenter = presenter;
        }
    }
}
