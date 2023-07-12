package tb;

import cn.damai.seatdecoder.common.bean.BaseDecodeResult;
import cn.damai.seatdecoder.seat_vr.bean.Seat3DVrDataDecodeReulst;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfo;
import cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrData;
import cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class r82 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static Map<String, List<StaticSeat3DVrInfo>> a(Seat3DVrPB$Seat3DVrData seat3DVrPB$Seat3DVrData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949515099")) {
            return (Map) ipChange.ipc$dispatch("1949515099", new Object[]{seat3DVrPB$Seat3DVrData});
        }
        HashMap hashMap = null;
        if (seat3DVrPB$Seat3DVrData == null) {
            return null;
        }
        List<Seat3DVrPB$FloorSeat3DVrInfo> floorSeatListList = seat3DVrPB$Seat3DVrData.getFloorSeatListList();
        if (floorSeatListList != null && !floorSeatListList.isEmpty()) {
            hashMap = new HashMap();
            for (Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo : floorSeatListList) {
                long floorId = seat3DVrPB$FloorSeat3DVrInfo.getFloorId();
                List<Seat3DVrPB$Seat3DVrInfo> seatListList = seat3DVrPB$FloorSeat3DVrInfo.getSeatListList();
                if (seatListList != null && !seatListList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo : seatListList) {
                        StaticSeat3DVrInfo staticSeat3DVrInfo = new StaticSeat3DVrInfo();
                        staticSeat3DVrInfo.setSid(Long.valueOf(seat3DVrPB$Seat3DVrInfo.getSid()));
                        staticSeat3DVrInfo.setFloorId(Long.valueOf(seat3DVrPB$Seat3DVrInfo.getFloorId()));
                        staticSeat3DVrInfo.setFov(seat3DVrPB$Seat3DVrInfo.getFov());
                        staticSeat3DVrInfo.setVertical(seat3DVrPB$Seat3DVrInfo.getVertical());
                        staticSeat3DVrInfo.setHorizontal(seat3DVrPB$Seat3DVrInfo.getHorizontal());
                        staticSeat3DVrInfo.setImg(seat3DVrPB$Seat3DVrInfo.getImg());
                        staticSeat3DVrInfo.setThumb(seat3DVrPB$Seat3DVrInfo.getThumb());
                        staticSeat3DVrInfo.setImgHash(seat3DVrPB$Seat3DVrInfo.getImgHash());
                        arrayList.add(staticSeat3DVrInfo);
                    }
                    hashMap.put(String.valueOf(floorId), arrayList);
                }
            }
        }
        return hashMap;
    }

    public static Seat3DVrDataDecodeReulst b(String str) {
        byte[] a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670992471")) {
            return (Seat3DVrDataDecodeReulst) ipChange.ipc$dispatch("-1670992471", new Object[]{str});
        }
        Seat3DVrDataDecodeReulst seat3DVrDataDecodeReulst = new Seat3DVrDataDecodeReulst();
        File file = new File(str);
        if (file.exists()) {
            try {
                if (zs0.c(file)) {
                    a = zs0.b(str);
                    if (a == null) {
                        seat3DVrDataDecodeReulst.setResultCode(BaseDecodeResult.DECODE_DECOMPRESS_ERROR);
                        seat3DVrDataDecodeReulst.setMessage("座位VR静态数据解压缩失败");
                        return seat3DVrDataDecodeReulst;
                    }
                } else {
                    a = vi0.a(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (a == null) {
                return seat3DVrDataDecodeReulst;
            }
            Seat3DVrPB$Seat3DVrData c = c(a);
            if (c == null) {
                seat3DVrDataDecodeReulst.setResultCode(BaseDecodeResult.DECODE_SERIALIZE_ERROR);
                seat3DVrDataDecodeReulst.setMessage("座位VR静态数据反序列化异常");
            } else {
                seat3DVrDataDecodeReulst.setResultCode(1);
                seat3DVrDataDecodeReulst.setResult(a(c));
            }
            return seat3DVrDataDecodeReulst;
        }
        return seat3DVrDataDecodeReulst;
    }

    private static Seat3DVrPB$Seat3DVrData c(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083914846")) {
            return (Seat3DVrPB$Seat3DVrData) ipChange.ipc$dispatch("-2083914846", new Object[]{bArr});
        }
        if (bArr == null) {
            return null;
        }
        try {
            return Seat3DVrPB$Seat3DVrData.P(bArr);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }
}
