package cn.damai.tetris.component.rank.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankItemBean extends MarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_HIGHSCORE = 3;
    public static final int TYPE_REPRO = 99;
    private static final long serialVersionUID = 8848712683037434511L;
    @JvmField
    @Nullable
    public String categoryName;
    @JvmField
    @Nullable
    public String cityName;
    @Nullable
    private String distance;
    @JvmField
    @Nullable
    public String extraInfo;
    @JvmField
    public int followStatus;
    @Nullable
    private String hasVideo;
    @JvmField
    @Nullable
    public String headPic;
    @JvmField
    public long id;
    @JvmField
    public int index;
    @JvmField
    public int ipvuv;
    @JvmField
    public double itemScore;
    @JvmField
    public int itemStar;
    @JvmField
    @Nullable
    public String name;
    @JvmField
    public int order;
    @JvmField
    @Nullable
    public String price;
    @JvmField
    @Nullable
    public String rankId;
    @JvmField
    @Nullable
    public String rankName;
    @Nullable
    private String reason;
    @JvmField
    @Nullable
    public RecommendHint recommendHint;
    @JvmField
    @Nullable
    public String schema;
    @JvmField
    @Nullable
    public String showTime;
    @JvmField
    @Nullable
    public String subHead;
    @Nullable
    private String titleLabel;
    @JvmField
    @Nullable
    public String[] tourCities;
    @JvmField
    @Nullable
    public String trend;
    @JvmField
    public int type;
    @JvmField
    @Nullable
    public String venueName;
    private int wantSeeCount;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    @Nullable
    public final String getDistance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1431171470") ? (String) ipChange.ipc$dispatch("1431171470", new Object[]{this}) : this.distance;
    }

    @Nullable
    public final String getHasVideo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1434585498") ? (String) ipChange.ipc$dispatch("1434585498", new Object[]{this}) : this.hasVideo;
    }

    @Nullable
    public final String getReason() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1649309149") ? (String) ipChange.ipc$dispatch("1649309149", new Object[]{this}) : this.reason;
    }

    @Nullable
    public final String getTitleLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "668312597") ? (String) ipChange.ipc$dispatch("668312597", new Object[]{this}) : this.titleLabel;
    }

    public final int getWantSeeCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-701137362") ? ((Integer) ipChange.ipc$dispatch("-701137362", new Object[]{this})).intValue() : this.wantSeeCount;
    }

    public final boolean hasVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465580624")) {
            return ((Boolean) ipChange.ipc$dispatch("-1465580624", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.hasVideo)) {
            return false;
        }
        return b41.d(this.hasVideo, "true");
    }

    public final void setDistance(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534314768")) {
            ipChange.ipc$dispatch("1534314768", new Object[]{this, str});
        } else {
            this.distance = str;
        }
    }

    public final void setHasVideo(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640149636")) {
            ipChange.ipc$dispatch("1640149636", new Object[]{this, str});
        } else {
            this.hasVideo = str;
        }
    }

    public final void setReason(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806115935")) {
            ipChange.ipc$dispatch("-1806115935", new Object[]{this, str});
        } else {
            this.reason = str;
        }
    }

    public final void setTitleLabel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427937897")) {
            ipChange.ipc$dispatch("1427937897", new Object[]{this, str});
        } else {
            this.titleLabel = str;
        }
    }

    public final void setWantSeeCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804119756")) {
            ipChange.ipc$dispatch("-1804119756", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.wantSeeCount = i;
        }
    }
}
