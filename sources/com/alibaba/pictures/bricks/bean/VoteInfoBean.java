package com.alibaba.pictures.bricks.bean;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.pictures.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import tb.hm1;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VoteInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public List<VoteBean> activityOptions;
    public String activityTag;
    public String backColor;
    public String circleBackground;
    public String feedBackground;
    public boolean hasVote;
    public String id;
    public String joinTotal;
    public String name;
    public int posInFeedList;
    public String total;

    public void computeItemProgressIntIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124128629")) {
            ipChange.ipc$dispatch("124128629", new Object[]{this});
        } else if (!n91.b(this.activityOptions)) {
            int size = this.activityOptions.size();
            for (int i = 0; i < size; i++) {
                VoteBean voteBean = this.activityOptions.get(i);
                voteBean.posInVoteList = i;
                if (this.hasVote) {
                    long f = hm1.f(this.total, 0L);
                    if (f <= 0) {
                        voteBean.progressInt = 0;
                    } else {
                        voteBean.progressInt = (int) ((hm1.e(voteBean.total, 0) / ((float) f)) * 100.0f);
                    }
                }
            }
        }
    }

    public String getPeopleCountText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978424981")) {
            return (String) ipChange.ipc$dispatch("1978424981", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            float d = hm1.d(this.total, 0.0f);
            double doubleValue = new BigDecimal(d / 10000.0f).setScale(1, 4).doubleValue();
            if (d >= 10000.0f) {
                return "" + doubleValue + "万";
            }
            return this.total;
        }
        return this.joinTotal;
    }

    public Drawable getVoteBgDrawable() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919481843")) {
            return (Drawable) ipChange.ipc$dispatch("919481843", new Object[]{this});
        }
        try {
            if (!TextUtils.isEmpty(this.feedBackground) && !TextUtils.isEmpty(this.backColor)) {
                try {
                    i = Color.parseColor(this.backColor);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = -16777216;
                }
                return new ColorDrawable(i);
            } else if (Build.VERSION.SDK_INT >= 21) {
                return AppInfoProviderProxy.getApplication().getDrawable(R$drawable.bricks_bg_vote_none_img_shape);
            } else {
                return AppInfoProviderProxy.getApplication().getResources().getDrawable(R$drawable.bricks_bg_vote_none_img_shape);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ColorDrawable(-16777216);
        }
    }

    public String getVotedItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138838254")) {
            return (String) ipChange.ipc$dispatch("-138838254", new Object[]{this});
        }
        if (n91.b(this.activityOptions)) {
            return null;
        }
        for (VoteBean voteBean : this.activityOptions) {
            if (voteBean.hasVote) {
                return voteBean.id;
            }
        }
        return null;
    }
}
