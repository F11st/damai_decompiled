package com.ta.audid.device;

import com.ta.audid.utils.ByteUtils;
import com.ta.utdid2.android.utils.Base64;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AppUtdidDecoder {
    public static UtdidObj decode(String str) {
        UtdidObj utdidObj = new UtdidObj();
        if (str != null && str.length() == 24) {
            try {
                byte[] decode = Base64.decode(str, 2);
                if (decode.length == 18) {
                    byte[] bArr = new byte[4];
                    System.arraycopy(decode, 0, bArr, 0, 4);
                    byte b = decode[8];
                    try {
                        utdidObj.setValid(true);
                        utdidObj.setTimestamp(ByteUtils.getLongByByte4(bArr));
                        utdidObj.setVersion(b);
                        return utdidObj;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                utdidObj.setValid(false);
                return utdidObj;
            }
        } else {
            utdidObj.setValid(false);
        }
        return utdidObj;
    }
}
