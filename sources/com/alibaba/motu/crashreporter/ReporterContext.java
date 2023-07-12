package com.alibaba.motu.crashreporter;

import android.content.Context;
import com.alibaba.motu.crashreporter.Propertys;
import com.alibaba.motu.tbrest.utils.DeviceUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReporterContext {
    Context mContext;
    Propertys mPropertys = new Propertys();

    public ReporterContext(Context context) {
        this.mContext = context;
    }

    public String getProperty(String str) {
        return this.mPropertys.getString(str, "");
    }

    public String getPropertyAndSet(String str) {
        if (StringUtils.isBlank(this.mPropertys.getValue(str)) && (Constants.UTDID.equals(str) || "IMEI".equals(str) || "IMSI".equals(str) || Constants.DEVICE_ID.equals(str))) {
            String utdid = DeviceUtils.getUtdid(this.mContext);
            String imei = DeviceUtils.getImei(this.mContext);
            String imsi = DeviceUtils.getImsi(this.mContext);
            this.mPropertys.add(new Propertys.Property(Constants.UTDID, utdid, true));
            this.mPropertys.add(new Propertys.Property("IMEI", imei, true));
            this.mPropertys.add(new Propertys.Property("IMSI", imsi, true));
            this.mPropertys.add(new Propertys.Property(Constants.DEVICE_ID, imei, true));
        }
        return this.mPropertys.getValue(str);
    }

    public void setProperty(Propertys.Property property) {
        this.mPropertys.add(property);
    }

    public String getProperty(String str, String str2) {
        return this.mPropertys.getString(str, str2);
    }
}
