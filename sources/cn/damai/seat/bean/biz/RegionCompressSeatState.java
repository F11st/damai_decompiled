package cn.damai.seat.bean.biz;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.support.combine.SeatStateChild;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.n92;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RegionCompressSeatState implements SeatStateChild, Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final char DOU_HAO = ',';
    private static final char KUO_HAO_LEFT = '(';
    private static final char KUO_HAO_RIGHT = ')';
    private String regionId;
    private byte[] sortSateArr;
    private int totalLength;

    public RegionCompressSeatState(String str, String str2) {
        this.regionId = str;
        try {
            this.sortSateArr = decompress(str2);
        } catch (Exception e) {
            e.printStackTrace();
            this.sortSateArr = null;
        }
        byte[] bArr = this.sortSateArr;
        this.totalLength = bArr == null ? 0 : bArr.length;
    }

    private byte[] decompress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226663241")) {
            return (byte[]) ipChange.ipc$dispatch("-1226663241", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        StringBuilder sb3 = null;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '(') {
                sb3 = new StringBuilder();
                int length = sb.length();
                if (length > 0) {
                    i += length;
                    byte[] bArr = new byte[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        bArr[i3] = Byte.parseByte(String.valueOf(sb.charAt(i3)));
                    }
                    arrayList.add(bArr);
                    sb = new StringBuilder();
                }
            } else if (charAt == ',') {
                sb2 = new StringBuilder();
            } else if (charAt == ')') {
                int parseInt = Integer.parseInt(sb3.toString());
                byte parseByte = Byte.parseByte(sb2.toString());
                i += parseInt;
                byte[] bArr2 = new byte[parseInt];
                for (int i4 = 0; i4 < parseInt; i4++) {
                    bArr2[i4] = parseByte;
                }
                arrayList.add(bArr2);
                sb2 = null;
                sb3 = null;
            } else if (sb2 != null) {
                sb2.append(charAt);
            } else if (sb3 != null) {
                sb3.append(charAt);
            } else {
                sb.append(charAt);
            }
        }
        if (sb.length() > 0) {
            int length2 = sb.length();
            i += length2;
            byte[] bArr3 = new byte[length2];
            for (int i5 = 0; i5 < length2; i5++) {
                bArr3[i5] = Byte.parseByte(String.valueOf(sb.charAt(i5)));
            }
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        int i6 = 0;
        for (byte[] bArr5 : arrayList) {
            for (byte b : bArr5) {
                bArr4[i6] = b;
                i6++;
            }
        }
        return bArr4;
    }

    @Override // cn.damai.seat.support.combine.SeatStateChild
    public int getLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1330997346") ? ((Integer) ipChange.ipc$dispatch("1330997346", new Object[]{this})).intValue() : getTotalLength();
    }

    public String getRegionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "3377626") ? (String) ipChange.ipc$dispatch("3377626", new Object[]{this}) : this.regionId;
    }

    public int getSeatStateByIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251016336")) {
            return ((Integer) ipChange.ipc$dispatch("251016336", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i >= 0 && i < this.totalLength) {
            return this.sortSateArr[i];
        }
        return n92.SEAT_STATUS_SALE_OUT.shortValue();
    }

    @Override // cn.damai.seat.support.combine.SeatStateChild
    public int getState(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1730887972") ? ((Integer) ipChange.ipc$dispatch("1730887972", new Object[]{this, seatNew})).intValue() : getSeatStateByIndex(seatNew.i);
    }

    public int getTotalLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1869436354") ? ((Integer) ipChange.ipc$dispatch("-1869436354", new Object[]{this})).intValue() : this.totalLength;
    }
}
