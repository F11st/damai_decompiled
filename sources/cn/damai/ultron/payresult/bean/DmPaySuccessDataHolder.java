package cn.damai.ultron.payresult.bean;

import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmPaySuccessDataHolder {
    public static final int TYPE_RECOMMEND = 3;
    public static final int TYPE_RECOMMEND_TITLE = 2;
    public PayAdvertBean mAdvertBean;
    public String mOrderId;
    public DmPaySuccessBean mPayResponse;
    public String mProjectId;
    public JSONObject recommendMo;
    public int type;
}
