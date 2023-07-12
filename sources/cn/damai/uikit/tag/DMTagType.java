package cn.damai.uikit.tag;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum DMTagType {
    TAG_TYPE_BUSINESS("运营标签"),
    TAG_TYPE_RANK("榜单标签"),
    TAG_TYPE_SERVICES("服务标签"),
    TAG_TYPE_PREFERENTIAL("优惠标签"),
    TAG_TYPE_ONEONE("双十一"),
    TAG_TYPE_MEMBER("会员标签"),
    TAG_TYPE_NEWPROMOTION_2PART("新营销标签 2份数据"),
    TAG_TYPE_NEWPROMOTION_VIP("新营销标签VIP 2份数据"),
    TAG_TYPE_NEWPROMOTION("新营销标签"),
    TAG_TYPE_NEWPROMOTION_FF866E("新营销标签VIP样式"),
    TAG_TYPE_NEWPROMOTION_EARLYBIRD("早鸟"),
    TAG_TYPE_NEWPROMOTION_VIP_PRIVILEGE("优先购样式"),
    TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT("周三半价"),
    TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT_HOME("周三半价小卡");
    
    public String labelName;

    DMTagType(String str) {
        this.labelName = str;
    }
}
