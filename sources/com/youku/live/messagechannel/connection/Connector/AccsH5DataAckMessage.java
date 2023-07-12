package com.youku.live.messagechannel.connection.Connector;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AccsH5DataAckMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = "data")
    public String data;
    @JSONField(name = Constants.KEY_DATA_ID)
    public String dataId;
    @JSONField(name = "extHeader")
    public Map extHeader;
    @JSONField(name = TbAuthConstants.IP)
    public String ip;
    @JSONField(name = "protocol")
    public String protocol;
    @JSONField(name = "serviceId")
    public String serviceId;
    @JSONField(name = "source")
    public String source;
    @JSONField(name = "target")
    public String target;
    @JSONField(name = "type")
    public String type;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684638137")) {
            return (String) ipChange.ipc$dispatch("684638137", new Object[]{this});
        }
        return "AccsH5DataAckMessage{protocol='" + this.protocol + "', type='" + this.type + "', extHeader=" + this.extHeader + ", serviceId='" + this.serviceId + "', dataId='" + this.dataId + "', data='" + this.data + "', source='" + this.source + "', target='" + this.target + "', ip='" + this.ip + "'}";
    }
}
