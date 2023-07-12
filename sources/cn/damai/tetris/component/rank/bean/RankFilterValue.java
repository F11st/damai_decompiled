package cn.damai.tetris.component.rank.bean;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RankFilterValue implements Serializable {
    public int mainTabIndex;
    public String mainTabName;
    public int subTabIndex;
    public String weiDuTabName;

    public RankFilterValue(@Nullable CategoryTabBean categoryTabBean, @Nullable TypeTabBean typeTabBean) {
        if (categoryTabBean == null) {
            this.mainTabIndex = -1;
            this.mainTabName = "";
        } else {
            this.mainTabIndex = categoryTabBean.pos;
            this.mainTabName = categoryTabBean.name;
        }
        if (typeTabBean == null) {
            this.subTabIndex = -1;
            this.weiDuTabName = "";
            return;
        }
        this.subTabIndex = typeTabBean.pos;
        this.weiDuTabName = typeTabBean.name;
    }
}
