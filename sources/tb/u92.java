package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import cn.damai.common.cache.common.KeyTransformer;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrDecrypt;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.real.image.decrypt.ImageDecrypt;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class u92 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static qe1<String, Bitmap> b = new qe1<>(new pc(), KeyTransformer.IDENTITY);
    private static u92 c;
    private RegionSeat3DVrDecrypt a;

    private u92() {
    }

    public static u92 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915298459")) {
            return (u92) ipChange.ipc$dispatch("915298459", new Object[0]);
        }
        if (c == null) {
            synchronized ("SeatVrDataDecryptHelper") {
                if (c == null) {
                    c = new u92();
                }
            }
        }
        return c;
    }

    public Bitmap a(byte[] bArr, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102821931")) {
            return (Bitmap) ipChange.ipc$dispatch("-1102821931", new Object[]{this, bArr, str, str2});
        }
        if (bArr != null && bArr.length != 0) {
            if (!d()) {
                try {
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            Bitmap bitmap = b.get(str2);
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            try {
                RegionSeat3DVrDecrypt regionSeat3DVrDecrypt = this.a;
                String b2 = ImageDecrypt.b(regionSeat3DVrDecrypt.safeKey, regionSeat3DVrDecrypt.timeStamp);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                if (!ImageDecrypt.c(b2.getBytes(), this.a.imgKeyHash)) {
                    r92.f("------------------ VR图片解密 key Hash校验失败，keyHash = " + this.a.imgKeyHash);
                    return null;
                }
                byte[] a = ImageDecrypt.a(bArr, b2);
                if (ImageDecrypt.c(a, str)) {
                    r92.f("------------------ VR图片解密 成功！");
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a, 0, bArr.length);
                    b.save(str2, decodeByteArray);
                    return decodeByteArray;
                }
                r92.f("------------------ VR图片解密 图片Hash校验失败，hash = " + str);
            } catch (Exception e2) {
                r92.f("------------------ VR图片解密 异常，msg = " + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void c(RegionSeat3DVrDecrypt regionSeat3DVrDecrypt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909407241")) {
            ipChange.ipc$dispatch("-909407241", new Object[]{this, regionSeat3DVrDecrypt});
            return;
        }
        b.clear();
        this.a = regionSeat3DVrDecrypt;
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816673198")) {
            return ((Boolean) ipChange.ipc$dispatch("1816673198", new Object[]{this})).booleanValue();
        }
        RegionSeat3DVrDecrypt regionSeat3DVrDecrypt = this.a;
        if (regionSeat3DVrDecrypt == null) {
            return false;
        }
        return regionSeat3DVrDecrypt.needDecrypt;
    }
}
