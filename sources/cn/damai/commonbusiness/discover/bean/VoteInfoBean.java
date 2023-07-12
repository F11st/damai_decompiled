package cn.damai.commonbusiness.discover.bean;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import tb.cb2;
import tb.jm1;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
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
        if (AndroidInstantRuntime.support(ipChange, "1761477044")) {
            ipChange.ipc$dispatch("1761477044", new Object[]{this});
        } else if (!cb2.d(this.activityOptions)) {
            int size = this.activityOptions.size();
            for (int i = 0; i < size; i++) {
                VoteBean voteBean = this.activityOptions.get(i);
                voteBean.posInVoteList = i;
                if (this.hasVote) {
                    long k = jm1.k(this.total, 0L);
                    if (k <= 0) {
                        voteBean.progressInt = 0;
                    } else {
                        voteBean.progressInt = (int) ((jm1.j(voteBean.total, 0) / ((float) k)) * 100.0f);
                    }
                }
            }
        }
    }

    public String getPeopleCountText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120038356")) {
            return (String) ipChange.ipc$dispatch("120038356", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            float i = jm1.i(this.total, 0.0f);
            double doubleValue = new BigDecimal(i / 10000.0f).setScale(1, 4).doubleValue();
            if (i >= 10000.0f) {
                return "" + doubleValue + "万";
            }
            return this.total;
        }
        return this.joinTotal;
    }

    public Drawable getVoteBgDrawable() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800596174")) {
            return (Drawable) ipChange.ipc$dispatch("-1800596174", new Object[]{this});
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
                return mu0.a().getDrawable(R$drawable.bg_vote_none_img_shape);
            } else {
                return mu0.a().getResources().getDrawable(R$drawable.bg_vote_none_img_shape);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ColorDrawable(-16777216);
        }
    }

    public String getVotedItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164212339")) {
            return (String) ipChange.ipc$dispatch("164212339", new Object[]{this});
        }
        if (cb2.d(this.activityOptions)) {
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
