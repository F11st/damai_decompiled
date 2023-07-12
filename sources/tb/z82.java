package tb;

import cn.damai.seatdecoder.common.bean.BaseDecodeResult;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigChair;
import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigRegion;
import cn.damai.seatdecoder.seat.bean.SeatDataDecodeResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class z82 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static SeatDataDecodeResult a(String str) {
        byte[] a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667285299")) {
            return (SeatDataDecodeResult) ipChange.ipc$dispatch("1667285299", new Object[]{str});
        }
        SeatDataDecodeResult seatDataDecodeResult = new SeatDataDecodeResult();
        File file = new File(str);
        if (file.exists()) {
            try {
                if (zs0.c(file)) {
                    a = zs0.b(str);
                    if (a == null) {
                        seatDataDecodeResult.setResultCode(BaseDecodeResult.DECODE_DECOMPRESS_ERROR);
                        seatDataDecodeResult.setMessage("座位静态数据解压缩失败");
                        return seatDataDecodeResult;
                    }
                } else {
                    a = vi0.a(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (a == null) {
                return seatDataDecodeResult;
            }
            List<StaticStandSeat> b = b(a);
            if (b == null) {
                seatDataDecodeResult.setResultCode(BaseDecodeResult.DECODE_SERIALIZE_ERROR);
                seatDataDecodeResult.setMessage(v92.SEAT_STATIC_DATA_SERIALIZE_ERROR_MSG);
            } else {
                seatDataDecodeResult.setResultCode(1);
                seatDataDecodeResult.setResult(b);
            }
            return seatDataDecodeResult;
        }
        return seatDataDecodeResult;
    }

    private static List<StaticStandSeat> b(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240602454")) {
            return (List) ipChange.ipc$dispatch("240602454", new Object[]{bArr});
        }
        if (bArr != null && bArr.length != 0) {
            hy1.b().c();
            try {
                LinkedHashMap<String, OrigRegion> a = hy1.b().a(new ByteArrayInputStream(bArr));
                if (a != null && a.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, OrigRegion> entry : a.entrySet()) {
                        StaticStandSeat staticStandSeat = new StaticStandSeat();
                        staticStandSeat.setStand(Long.valueOf(Long.parseLong(entry.getKey())));
                        List<OrigChair> chairs = entry.getValue().chairs();
                        if (chairs != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i = 0; i < chairs.size(); i++) {
                                OrigChair origChair = chairs.get(i);
                                StaticSeat staticSeat = new StaticSeat();
                                staticSeat.setSid(origChair.getSid());
                                staticSeat.setX(origChair.getX());
                                staticSeat.setY(origChair.getY());
                                staticSeat.setFn(origChair.getFloorId());
                                staticSeat.setRhint(origChair.getRowId());
                                staticSeat.setChint(origChair.getChairId());
                                staticSeat.setPlid(origChair.getPriceId());
                                staticSeat.setGroupId(origChair.getGroupId());
                                staticSeat.setGroupPriceId(origChair.getGroupPriceId());
                                staticSeat.setAngle(origChair.getAngle() / 100.0d);
                                staticSeat.setI(origChair.getSecondIndex());
                                arrayList2.add(staticSeat);
                            }
                            staticStandSeat.setSeats(arrayList2);
                            arrayList.add(staticStandSeat);
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
