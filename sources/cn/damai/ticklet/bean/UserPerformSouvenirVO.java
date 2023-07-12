package cn.damai.ticklet.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class UserPerformSouvenirVO implements Serializable {
    private static final long serialVersionUID = 1;
    public String performId;
    public String productSystemId;
    public String tenantId;
    public int ticketQuantity;
    public UserProjectBean userProjectVO;
    public List<UserTicketTable> userTicketVOList;
}
