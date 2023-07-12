package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Caverphone1 extends AbstractCaverphone {
    private static final String SIX_1 = "111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return SIX_1;
        }
        String replaceAll = str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll(AbstractC5658c.a, "k").replaceAll("q", "k").replaceAll(Constants.Name.X, "k").replaceAll("v", "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll("ph", "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", "T").replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", UTConstant.Args.UT_SUCCESS_F).replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll(WXComponent.PROP_FS_WRAP_CONTENT, "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("h", "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll(UploadQueueMgr.MSGTYPE_REALTIME, "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll(NotifyType.LIGHTS, "2").replaceAll("j", Constants.Name.Y).replaceAll("y3", "Y3").replaceAll(Constants.Name.Y, "2").replaceAll("2", "").replaceAll("3", "");
        return (replaceAll + SIX_1).substring(0, 6);
    }
}
