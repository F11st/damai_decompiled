package tb;

import android.text.TextUtils;
import android.util.Xml;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.RegionSeatNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class p23 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    List<SeatNew> b;

    public p23(boolean z) {
        this.a = z ? 12 : 0;
    }

    private List<SeatNew> a(InputStream inputStream, int i, String str) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417281175")) {
            return (List) ipChange.ipc$dispatch("417281175", new Object[]{this, inputStream, Integer.valueOf(i), str});
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        ArrayList arrayList = null;
        SeatNew seatNew = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType == 0) {
                arrayList = new ArrayList();
            } else if (eventType != 2) {
                if (eventType == 3 && newPullParser.getName().equals("s")) {
                    arrayList.add(seatNew);
                    seatNew = null;
                }
            } else if (newPullParser.getName().equals("s")) {
                seatNew = new SeatNew();
                seatNew.sid = Long.valueOf(newPullParser.getAttributeValue(0)).longValue();
                seatNew.x = (Integer.valueOf(newPullParser.getAttributeValue(1)).intValue() / i) + this.a;
                seatNew.y = (Integer.valueOf(newPullParser.getAttributeValue(2)).intValue() / i) + this.a;
                seatNew.priceLevel = Long.valueOf(newPullParser.getAttributeValue(6)).longValue();
                long longValue = Long.valueOf(newPullParser.getAttributeValue(7)).longValue();
                seatNew.packageCombinedId = longValue;
                seatNew.isPackaged = longValue != 0;
                seatNew.packagedPriceIndexId = Long.valueOf(newPullParser.getAttributeValue(8)).longValue();
                seatNew.sn = newPullParser.getAttributeValue(3);
                seatNew.rn = newPullParser.getAttributeValue(5);
                seatNew.fn = newPullParser.getAttributeValue(4);
                seatNew.state = 8;
                seatNew.kanTaiId = str;
                String attributeValue = newPullParser.getAttributeValue(null, "angle");
                if (!TextUtils.isEmpty(attributeValue)) {
                    seatNew.angle = b(attributeValue, 0.0f);
                } else {
                    seatNew.angle = 0.0f;
                }
                String attributeValue2 = newPullParser.getAttributeValue(null, "i");
                if (!TextUtils.isEmpty(attributeValue2)) {
                    seatNew.i = c(attributeValue2, -1);
                } else {
                    seatNew.i = -1;
                }
            }
        }
        return arrayList;
    }

    private float b(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639115118")) {
            return ((Float) ipChange.ipc$dispatch("1639115118", new Object[]{this, str, Float.valueOf(f)})).floatValue();
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f;
        }
    }

    private int c(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662263367")) {
            return ((Integer) ipChange.ipc$dispatch("662263367", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public RegionSeatNew d(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678246271")) {
            return (RegionSeatNew) ipChange.ipc$dispatch("678246271", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        RegionSeatNew regionSeatNew = new RegionSeatNew();
        try {
            List<SeatNew> a = a(new ByteArrayInputStream(str.getBytes("UTF-8")), i, str2);
            this.b = a;
            regionSeatNew.seatNewList = a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regionSeatNew;
    }
}
