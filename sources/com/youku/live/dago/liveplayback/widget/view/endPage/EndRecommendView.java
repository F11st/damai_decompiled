package com.youku.live.dago.liveplayback.widget.view.endPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.model.EndPageRecommendModel;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class EndRecommendView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "EndRecommendView";
    private Context mContext;
    private ImageView mCoverIv;
    private EndPageRecommendModel mModle;
    private TextView mNickTv;

    public EndRecommendView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967184777")) {
            ipChange.ipc$dispatch("1967184777", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7935layout.dago_end_item_view_recommend, (ViewGroup) this, true);
        this.mCoverIv = (ImageView) findViewById(R.id.end_recommend_cover);
        this.mNickTv = (TextView) findViewById(R.id.end_recommend_nick);
        this.mContext = context;
    }

    public void setData(EndPageRecommendModel endPageRecommendModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686947492")) {
            ipChange.ipc$dispatch("686947492", new Object[]{this, endPageRecommendModel});
        } else if (endPageRecommendModel != null) {
            this.mModle = endPageRecommendModel;
            ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().round(UIUtils.dip2px(7, this.mContext)).loadUrl(endPageRecommendModel.coverUrl).into(this.mCoverIv);
            this.mNickTv.setText(endPageRecommendModel.nickName);
        }
    }

    public EndRecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EndRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
