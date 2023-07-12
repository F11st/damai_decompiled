package cn.damai.discover.content.bean;

import cn.damai.discover.content.net.ContentCard;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CardExtra implements Serializable {
    public String title;
    public String type;

    public CardExtra() {
    }

    public CardExtra(ContentCard contentCard) {
        this.type = contentCard.type;
        this.title = contentCard.title;
    }
}
