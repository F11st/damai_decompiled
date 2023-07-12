package tb;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class l83 {
    @JSONField(name = "error_code")
    public int a;
    @JSONField(name = "id")
    public String b;
    @JSONField(name = "ruleId")
    public String c;
    @JSONField(name = "task_id")
    public int d;
    @JSONField(name = "url")
    public String e;
    @JSONField(name = TbAuthConstants.IP)
    public String f;
    @JSONField(name = "duration")
    public int g;
    @JSONField(name = "bandwidth")
    public long h;
    @JSONField(name = "detail")
    public b63[] i;
    @JSONField(name = TableField.PS_ID)
    public String j;
    @JSONField(name = "impairmentOrder")
    public int k;
    @JSONField(name = "vvId")
    public String l;
    @JSONField(name = "videoformat")
    public String m;
    @JSONField(name = "cmdConnectionTime")
    public long n;
    @JSONField(name = "triggerType")
    public String o;
    @JSONField(name = "networkType")
    public int p;

    public String toString() {
        return JSON.toJSONString(this);
    }
}
