package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.android.utils.PhoneInfoUtils;
import com.ta.utdid2.android.utils.StringUtils;
import java.util.zip.Adler32;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class DeviceInfo {
    static final Object CREATE_DEVICE_METADATA_LOCK = new Object();
    private static Device mDevice;

    public static synchronized Device getDevice(Context context) {
        synchronized (DeviceInfo.class) {
            Device device = mDevice;
            if (device != null) {
                return device;
            }
            if (context != null) {
                Device initDeviceMetadata = initDeviceMetadata(context);
                mDevice = initDeviceMetadata;
                return initDeviceMetadata;
            }
            return null;
        }
    }

    static long getMetadataCheckSum(Device device) {
        if (device != null) {
            String format = String.format("%s%s%s%s%s", device.getUtdid(), device.getDeviceId(), Long.valueOf(device.getCreateTimestamp()), device.getImsi(), device.getImei());
            if (StringUtils.isEmpty(format)) {
                return 0L;
            }
            Adler32 adler32 = new Adler32();
            adler32.reset();
            adler32.update(format.getBytes());
            return adler32.getValue();
        }
        return 0L;
    }

    private static Device initDeviceMetadata(Context context) {
        if (context != null) {
            synchronized (CREATE_DEVICE_METADATA_LOCK) {
                String value = UTUtdid.instance(context).getValue();
                if (StringUtils.isEmpty(value)) {
                    return null;
                }
                if (value.endsWith(org.apache.commons.lang3.StringUtils.LF)) {
                    value = value.substring(0, value.length() - 1);
                }
                Device device = new Device();
                long currentTimeMillis = System.currentTimeMillis();
                String imei = PhoneInfoUtils.getImei(context);
                String imsi = PhoneInfoUtils.getImsi(context);
                device.setDeviceId(imei);
                device.setImei(imei);
                device.setCreateTimestamp(currentTimeMillis);
                device.setImsi(imsi);
                device.setUtdid(value);
                device.setCheckSum(getMetadataCheckSum(device));
                return device;
            }
        }
        return null;
    }
}
