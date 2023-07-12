package com.youku.live.messagechannel.connection.Connector;

import android.text.TextUtils;
import android.util.Base64;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AccsH5DataMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    public String compressType;
    public byte[] data;
    public String dataId;
    public String err;
    public String ip;
    public String protocol;
    public String serviceId;
    public String source;
    public String target;
    public String type;

    private static byte[] decompressForGzip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750983181")) {
            return (byte[]) ipChange.ipc$dispatch("1750983181", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str.getBytes(), 0);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 256);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AccsH5DataMessage parseJsonToDataMessages(String str) {
        byte[] decompressForGzip;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108293710")) {
            return (AccsH5DataMessage) ipChange.ipc$dispatch("-1108293710", new Object[]{str});
        }
        AccsH5DataMessage accsH5DataMessage = new AccsH5DataMessage();
        JSONObject parseObject = JSON.parseObject(str);
        accsH5DataMessage.protocol = parseObject.getString("protocol");
        accsH5DataMessage.type = parseObject.getString("type");
        accsH5DataMessage.compressType = parseObject.getString("compressType");
        accsH5DataMessage.err = parseObject.getString("err");
        accsH5DataMessage.serviceId = parseObject.getString("serviceId");
        accsH5DataMessage.dataId = parseObject.getString(Constants.KEY_DATA_ID);
        accsH5DataMessage.source = parseObject.getString("source");
        accsH5DataMessage.target = parseObject.getString("target");
        accsH5DataMessage.ip = parseObject.getString(TbAuthConstants.IP);
        String string = parseObject.getString("data");
        if (TextUtils.isEmpty(accsH5DataMessage.protocol) || TextUtils.isEmpty(accsH5DataMessage.type) || TextUtils.isEmpty(accsH5DataMessage.compressType) || TextUtils.isEmpty(accsH5DataMessage.serviceId) || TextUtils.isEmpty(accsH5DataMessage.dataId) || TextUtils.isEmpty(string) || !"ACCS_H5".equals(accsH5DataMessage.protocol)) {
            return null;
        }
        if ("COMMON".equals(accsH5DataMessage.compressType)) {
            accsH5DataMessage.data = Base64.decode(string.getBytes(), 0);
        }
        if ("GZIP".equals(accsH5DataMessage.compressType) && (decompressForGzip = decompressForGzip(string)) != null) {
            accsH5DataMessage.data = decompressForGzip;
        }
        if (accsH5DataMessage.data == null) {
            return null;
        }
        return accsH5DataMessage;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525986904")) {
            return (String) ipChange.ipc$dispatch("-525986904", new Object[]{this});
        }
        return "AccsH5DataMessage{protocol='" + this.protocol + "', type='" + this.type + "', compressType='" + this.compressType + "', err='" + this.err + "', serviceId='" + this.serviceId + "', dataId='" + this.dataId + "', data=" + Arrays.toString(this.data) + ", source='" + this.source + "', target='" + this.target + "', ip='" + this.ip + "'}";
    }
}
