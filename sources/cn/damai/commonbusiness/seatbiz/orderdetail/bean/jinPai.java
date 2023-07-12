package cn.damai.commonbusiness.seatbiz.orderdetail.bean;

import cn.damai.commonbusiness.seatbiz.seat.wolf.oldtradeorder.model.jinPaiEntity;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class jinPai implements Serializable {
    public long cityId;
    public String groupName;
    public boolean isJinPai;
    public String nowTime;
    public long performId;
    public String performName;
    public List<jinPaiEntity> priceList;
    public String serialNumber;
    public String startTime;
    public boolean status;
}
