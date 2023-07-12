package cn.damai.ticklet.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketAcceptTransferData implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean allSuccess = false;
    public ArrayList<String> failDonationOrderIdList;
    public String failMsg;
    public int failedNum;
    public String secondFailMsg;
    public String sid;
    public ArrayList<String> successDonationOrderIdList;
}
