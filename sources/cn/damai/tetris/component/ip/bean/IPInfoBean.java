package cn.damai.tetris.component.ip.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class IPInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> awardsList;
    private String category;
    private Content content;
    public boolean focus;
    private String guidelines;
    private boolean haveseen;
    private String id;
    private String ipName;
    private List<IpTags> ipTags;
    private long ipvuv;
    public String ipvuvDescription;
    private String itemScore;
    public boolean like;
    private Rank rank;
    private String scoreDesc;
    private List<String> verticalPicList;

    public List<String> getAwardsList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "816029989") ? (List) ipChange.ipc$dispatch("816029989", new Object[]{this}) : this.awardsList;
    }

    public String getCategory() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1442574264") ? (String) ipChange.ipc$dispatch("-1442574264", new Object[]{this}) : this.category;
    }

    public Content getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "774863671") ? (Content) ipChange.ipc$dispatch("774863671", new Object[]{this}) : this.content;
    }

    public boolean getFocus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1032034720") ? ((Boolean) ipChange.ipc$dispatch("1032034720", new Object[]{this})).booleanValue() : this.focus;
    }

    public String getGuidelines() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167569779") ? (String) ipChange.ipc$dispatch("-1167569779", new Object[]{this}) : this.guidelines;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1923889957") ? (String) ipChange.ipc$dispatch("1923889957", new Object[]{this}) : this.id;
    }

    public String getIpName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1505068380") ? (String) ipChange.ipc$dispatch("1505068380", new Object[]{this}) : this.ipName;
    }

    public List<IpTags> getIpTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1603212305") ? (List) ipChange.ipc$dispatch("1603212305", new Object[]{this}) : this.ipTags;
    }

    public long getIpvuv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-897921960") ? ((Long) ipChange.ipc$dispatch("-897921960", new Object[]{this})).longValue() : this.ipvuv;
    }

    public String getItemScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-689264917") ? (String) ipChange.ipc$dispatch("-689264917", new Object[]{this}) : this.itemScore;
    }

    public float getItemScoreFloat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688450249")) {
            return ((Float) ipChange.ipc$dispatch("1688450249", new Object[]{this})).floatValue();
        }
        if (TextUtils.isEmpty(this.itemScore)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(this.itemScore);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public Rank getRank() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1543146283") ? (Rank) ipChange.ipc$dispatch("1543146283", new Object[]{this}) : this.rank;
    }

    public String getScoreDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "187321839") ? (String) ipChange.ipc$dispatch("187321839", new Object[]{this}) : this.scoreDesc;
    }

    public List<String> getVerticalPicList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1463291515") ? (List) ipChange.ipc$dispatch("-1463291515", new Object[]{this}) : this.verticalPicList;
    }

    public void setAwardsList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550344775")) {
            ipChange.ipc$dispatch("550344775", new Object[]{this, list});
        } else {
            this.awardsList = list;
        }
    }

    public void setCategory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652457066")) {
            ipChange.ipc$dispatch("-1652457066", new Object[]{this, str});
        } else {
            this.category = str;
        }
    }

    public void setContent(Content content) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049327717")) {
            ipChange.ipc$dispatch("1049327717", new Object[]{this, content});
        } else {
            this.content = content;
        }
    }

    public void setFocus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817623764")) {
            ipChange.ipc$dispatch("-817623764", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.focus = z;
        }
    }

    public void setGuidelines(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350159089")) {
            ipChange.ipc$dispatch("350159089", new Object[]{this, str});
        } else {
            this.guidelines = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647601319")) {
            ipChange.ipc$dispatch("-1647601319", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setIpName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982612478")) {
            ipChange.ipc$dispatch("-1982612478", new Object[]{this, str});
        } else {
            this.ipName = str;
        }
    }

    public void setIpTags(List<IpTags> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227236133")) {
            ipChange.ipc$dispatch("-1227236133", new Object[]{this, list});
        } else {
            this.ipTags = list;
        }
    }

    public void setIpvuv(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516753580")) {
            ipChange.ipc$dispatch("-516753580", new Object[]{this, Long.valueOf(j)});
        } else {
            this.ipvuv = j;
        }
    }

    public void setItemScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857580821")) {
            ipChange.ipc$dispatch("-1857580821", new Object[]{this, str});
        } else {
            this.itemScore = str;
        }
    }

    public void setRank(Rank rank) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125542877")) {
            ipChange.ipc$dispatch("125542877", new Object[]{this, rank});
        } else {
            this.rank = rank;
        }
    }

    public void setScoreDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453195161")) {
            ipChange.ipc$dispatch("-453195161", new Object[]{this, str});
        } else {
            this.scoreDesc = str;
        }
    }

    public void setVerticalPicList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919486335")) {
            ipChange.ipc$dispatch("919486335", new Object[]{this, list});
        } else {
            this.verticalPicList = list;
        }
    }
}
