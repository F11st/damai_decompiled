package cn.damai.tetris.component.girl.bean;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectViewModel implements Serializable {
    public static final String RT_VALUE = "rightTopTagValue";
    public static final String RT_VISI = "rightTopTagVisibility";
    private static final long serialVersionUID = -7315598902296157149L;
    public String id;
    public String index;
    public double itemScore = -1.0d;
    public int itemStar = -1;
    public String picUrl;
    public String priceTitle;
    public JSONObject rawObj;
    public String schema;
    public String subTitle;
    public String title;
}
