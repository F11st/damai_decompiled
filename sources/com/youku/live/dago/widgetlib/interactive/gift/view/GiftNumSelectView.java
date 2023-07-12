package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftNumTemplateAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftNumSelectView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int MAX_COUNT;
    private Animation hideAnim;
    private boolean isLocked;
    private GiftNumTemplateAdapter mAdapter;
    private FrameLayout mBlankView;
    private Context mContext;
    private List<GiftNumBean> mGiftNumData;
    private OnGiftNumClickListener mListener;
    private LinearLayout mNumListLayout;
    private RecyclerView mNumListView;
    private Animation showAnim;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnGiftNumClickListener {
        void onNumPannelclose();

        void onSelectedNum(int i);

        void onShowCustomNumKeyboard();
    }

    public GiftNumSelectView(Context context) {
        this(context, null);
    }

    private void initAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739454030")) {
            ipChange.ipc$dispatch("-739454030", new Object[]{this});
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.dago_pgc_scale_anim_in);
        this.showAnim = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1571487340")) {
                    ipChange2.ipc$dispatch("1571487340", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "523213192")) {
                    ipChange2.ipc$dispatch("523213192", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1161012933")) {
                    ipChange2.ipc$dispatch("1161012933", new Object[]{this, animation});
                } else {
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "show NUM LIST = onAnimationStart");
                }
            }
        });
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, R.anim.dago_pgc_scale_anim_out);
        this.hideAnim = loadAnimation2;
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2030087251")) {
                    ipChange2.ipc$dispatch("-2030087251", new Object[]{this, animation});
                    return;
                }
                GiftNumSelectView.this.mNumListLayout.setVisibility(8);
                GiftNumSelectView.this.setVisibility(8);
                GiftNumSelectView.this.isLocked = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1407405913")) {
                    ipChange2.ipc$dispatch("-1407405913", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1791471558")) {
                    ipChange2.ipc$dispatch("1791471558", new Object[]{this, animation});
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790900415")) {
            ipChange.ipc$dispatch("790900415", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "show NUM LIST = " + z);
        if (z) {
            this.mNumListLayout.startAnimation(this.showAnim);
            this.mNumListLayout.setVisibility(0);
        } else if (this.isLocked) {
        } else {
            this.isLocked = true;
            this.mNumListLayout.startAnimation(this.hideAnim);
        }
    }

    public boolean isLock() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2083727230") ? ((Boolean) ipChange.ipc$dispatch("-2083727230", new Object[]{this})).booleanValue() : this.isLocked;
    }

    public void setChildLayoutParams(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477746411")) {
            ipChange.ipc$dispatch("1477746411", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mNumListLayout.getLayoutParams();
        layoutParams.bottomMargin = UIUtil.dip2px(z ? 45 : 75);
        this.mNumListLayout.setLayoutParams(layoutParams);
    }

    public void setData(List<GiftNumBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102496476")) {
            ipChange.ipc$dispatch("102496476", new Object[]{this, list});
        } else if (list != null) {
            this.mGiftNumData.clear();
            for (GiftNumBean giftNumBean : list) {
                this.mGiftNumData.add(0, giftNumBean);
            }
            this.mGiftNumData.add(0, new GiftNumBean("其他数额", 1, 1));
            List<GiftNumBean> list2 = this.mGiftNumData;
            if (list2 != null) {
                int size = list2.size();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mNumListLayout.getLayoutParams();
                if (size <= 10) {
                    layoutParams.height = DensityUtil.dip2px(this.mContext, (size * 30) + 5);
                } else {
                    layoutParams.height = DensityUtil.dip2px(this.mContext, 305.0f);
                }
                this.mAdapter.setData(this.mGiftNumData);
            }
        }
    }

    public void setOnGiftConfigClickListener(OnGiftNumClickListener onGiftNumClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1694620026")) {
            ipChange.ipc$dispatch("-1694620026", new Object[]{this, onGiftNumClickListener});
        } else {
            this.mListener = onGiftNumClickListener;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710486560")) {
            ipChange.ipc$dispatch("-710486560", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            showSelectView(true);
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "mGiftNumSelectView.getVisibility() == GONE");
        this.mListener.onNumPannelclose();
    }

    public GiftNumSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftNumSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MAX_COUNT = 10;
        this.mGiftNumData = new ArrayList();
        this.isLocked = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ykl_gift_num_select_layout, (ViewGroup) this, true);
        this.mNumListView = (RecyclerView) findViewById(R.id.num_list);
        this.mNumListView.setLayoutManager(new LinearLayoutManager(context));
        this.mNumListLayout = (LinearLayout) findViewById(R.id.num_list_layout);
        this.mBlankView = (FrameLayout) findViewById(R.id.blank_view);
        GiftNumTemplateAdapter giftNumTemplateAdapter = new GiftNumTemplateAdapter(context);
        this.mAdapter = giftNumTemplateAdapter;
        giftNumTemplateAdapter.setOnItemClickListener(new GiftNumTemplateAdapter.OnItemClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftNumTemplateAdapter.OnItemClickListener
            public void onItemClick(int i2, GiftNumBean giftNumBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2093016610")) {
                    ipChange.ipc$dispatch("2093016610", new Object[]{this, Integer.valueOf(i2), giftNumBean});
                } else if (GiftNumSelectView.this.mListener == null || giftNumBean == null) {
                } else {
                    if (giftNumBean.type == 1) {
                        GiftNumSelectView.this.mNumListLayout.setVisibility(8);
                        GiftNumSelectView.this.setVisibility(8);
                        GiftNumSelectView.this.mListener.onShowCustomNumKeyboard();
                        return;
                    }
                    GiftNumSelectView.this.mListener.onSelectedNum(giftNumBean.num);
                    GiftNumSelectView.this.showSelectView(false);
                }
            }
        });
        this.mBlankView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "604259090")) {
                    ipChange.ipc$dispatch("604259090", new Object[]{this, view});
                } else {
                    GiftNumSelectView.this.showSelectView(false);
                }
            }
        });
        this.mNumListView.setAdapter(this.mAdapter);
        initAnim();
    }
}
