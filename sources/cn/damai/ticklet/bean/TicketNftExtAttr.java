package cn.damai.ticklet.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketNftExtAttr implements Serializable {
    private static final long serialVersionUID = 1;
    public String acSn;
    public String coverURL;
    public String issueLimitTime;
    public String issueTips;
    public String nftContentUrl;
    public String nftStatus;
    @JSONField(deserialize = false, serialize = false)
    public int position;
    public String subContentType;
    public String title;
    public String uniqueId;
    public String vid;
}
