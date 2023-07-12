package cn.damai.ticklet.zxing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.zxing.WriterException;
import java.util.HashMap;
import java.util.Hashtable;
import tb.cb1;
import tb.df0;
import tb.fa;
import tb.in2;
import tb.me0;
import tb.nc;
import tb.un2;
import tb.xh2;
import tb.xn2;
import tb.z20;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DecodeQRImage extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    ImageView imageView;
    UserTicketTable ticket;
    String viewType;
    private int QR_WIDTH = 300;
    private int QR_HEIGHT = 300;
    private int loadSize = 30;
    Boolean isStatic = Boolean.FALSE;

    public DecodeQRImage(Context context, UserTicketTable userTicketTable, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
        this.ticket = userTicketTable;
    }

    private void alarm(String str, String str2, UserTicketTable userTicketTable, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952069276")) {
            ipChange.ipc$dispatch("-1952069276", new Object[]{this, str, str2, userTicketTable, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TicketDetailExtFragment.PERFORM_ID, userTicketTable.getPerformId());
        hashMap.put("voucherUniqueKey", userTicketTable.voucherUniqueKey);
        hashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, userTicketTable.productSystemId);
        hashMap.put("voucher", userTicketTable.verifyCode);
        hashMap.put("pubKey", userTicketTable.getPubKey());
        hashMap.put("codeUrl", str3);
        hashMap.put("usercode", z20.i());
        zr.INSTANCE.a().a("mtop.damai.wireless.ticklet2.perform.detail.get").c(str).d(str2).e(hashMap).g("票详情页面二维码显示").j(un2.TICKLET_DETAIL_PAGE).f(false).b();
    }

    private void alarmVoucher(String str, String str2, UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318384092")) {
            ipChange.ipc$dispatch("1318384092", new Object[]{this, str, str2, userTicketTable});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TicketDetailExtFragment.PERFORM_ID, userTicketTable.getPerformId());
        hashMap.put("voucherUniqueKey", userTicketTable.voucherUniqueKey);
        hashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, userTicketTable.productSystemId);
        hashMap.put("voucherType", userTicketTable.voucherType);
        hashMap.put("voucher", userTicketTable.verifyCode);
        hashMap.put("pubKey", userTicketTable.getPubKey());
        hashMap.put("usercode", z20.i());
        zr.INSTANCE.a().a("mtop.damai.wireless.ticklet2.perform.detail.get").c(str).d(str2).e(hashMap).g("票详情页面二维码显示").j(un2.TICKLET_DETAIL_PAGE).f(false).b();
    }

    private Bitmap getQrcodeImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456702011")) {
            return (Bitmap) ipChange.ipc$dispatch("456702011", new Object[]{this, str});
        }
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(me0.CHARACTER_SET, "utf-8");
            nc encode = new C2132a().encode(str, fa.QR_CODE, this.QR_WIDTH, this.QR_HEIGHT, hashtable);
            int c = encode.c();
            int b = encode.b();
            int[] iArr = new int[c * b];
            for (int i = 0; i < b; i++) {
                for (int i2 = 0; i2 < c; i2++) {
                    if (encode.a(i2, i)) {
                        iArr[(i * c) + i2] = -16777216;
                    } else {
                        iArr[(i * c) + i2] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, c, 0, 0, c, b);
            return createBitmap;
        } catch (WriterException e) {
            String message = e.getMessage();
            if (!TextUtils.isEmpty(this.viewType) && in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.viewType)) {
                renderfloatDynamicCodeErrorXFlushMonitor("动态二维码绘制失败  " + message, this.ticket.getPerformId() + " url= " + str, this.ticket.voucherUniqueKey);
                StringBuilder sb = new StringBuilder();
                sb.append("动态二维码绘制失败  ");
                sb.append(message);
                alarm("", sb.toString(), this.ticket, str);
            } else {
                renderDetailDynamicCodeErrorXFlushMonitor("动态二维码绘制失败  " + message, this.ticket.getPerformId() + " url= " + str, this.ticket.voucherUniqueKey);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("动态二维码绘制失败  ");
                sb2.append(message);
                alarm("", sb2.toString(), this.ticket, str);
            }
            e.printStackTrace();
            return null;
        }
    }

    private String getQrcodeUrl(Context context, UserTicketTable userTicketTable, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804055080")) {
            return (String) ipChange.ipc$dispatch("-1804055080", new Object[]{this, context, userTicketTable, str, str2});
        }
        if (userTicketTable.isStaticQrcode()) {
            return str;
        }
        if (userTicketTable.isDynamicQrcode()) {
            return xh2.b(context, str, str2, userTicketTable.getPerformId());
        }
        return null;
    }

    private void renderDetailDynamicCodeErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71701331")) {
            ipChange.ipc$dispatch("71701331", new Object[]{this, str, str2, str3});
            return;
        }
        xn2.c(xn2.f("动态电子票二维码渲染失败", "", "", str, " performId:" + str2 + " , voucherUniqueKey:" + str3), xn2.TICKLET_PERFORM_DETAIL_RENDER_DYNAMIC_ERROR_CODE, "动态电子票二维码渲染失败");
    }

    private void renderfloatDynamicCodeErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1375780188")) {
            ipChange.ipc$dispatch("1375780188", new Object[]{this, str, str2, str3});
            return;
        }
        xn2.c(xn2.f("动态电子票二维码渲染失败", "", "", str, " performId:" + str2 + " , voucherUniqueKey:" + str3), xn2.TICKLET_FLOAT_RENDER_DYNAMIC_ERROR_CODE, "动态电子票二维码渲染失败");
    }

    public void createQRImage(String str, Bitmap bitmap, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964438332")) {
            ipChange.ipc$dispatch("964438332", new Object[]{this, str, bitmap, imageView});
        } else if (str != null) {
            try {
                if (!"".equals(str) && str.length() >= 1) {
                    this.loadSize = this.QR_WIDTH / 10;
                    Matrix matrix = new Matrix();
                    matrix.setScale((this.loadSize * 2.0f) / bitmap.getWidth(), (this.loadSize * 2.0f) / bitmap.getHeight());
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                    Hashtable hashtable = new Hashtable();
                    hashtable.put(me0.CHARACTER_SET, "utf-8");
                    hashtable.put(me0.ERROR_CORRECTION, df0.H);
                    nc encode = new C2132a().encode(str, fa.QR_CODE, this.QR_WIDTH, this.QR_HEIGHT, hashtable);
                    int c = encode.c();
                    int b = encode.b();
                    int i = c / 2;
                    int i2 = b / 2;
                    int[] iArr = new int[c * b];
                    for (int i3 = 0; i3 < b; i3++) {
                        for (int i4 = 0; i4 < c; i4++) {
                            int i5 = this.loadSize;
                            if (i4 > i - i5 && i4 < i + i5 && i3 > i2 - i5 && i3 < i2 + i5) {
                                iArr[(i3 * c) + i4] = createBitmap.getPixel((i4 - i) + i5, (i3 - i2) + i5);
                            } else if (encode.a(i4, i3)) {
                                iArr[(i3 * c) + i4] = -16777216;
                            } else {
                                iArr[(i3 * c) + i4] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_4444);
                    createBitmap2.setPixels(iArr, 0, c, 0, 0, c, b);
                    imageView.setImageBitmap(createBitmap2);
                }
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184178251")) {
            ipChange.ipc$dispatch("-184178251", new Object[]{this});
            return;
        }
        super.run();
        Context context = this.context;
        UserTicketTable userTicketTable = this.ticket;
        String qrcodeUrl = getQrcodeUrl(context, userTicketTable, userTicketTable.getVerifyCode(), this.ticket.getPubKey());
        if (xh2.c(qrcodeUrl)) {
            if (!TextUtils.isEmpty(this.viewType) && in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.viewType)) {
                renderfloatDynamicCodeErrorXFlushMonitor("voucherCode为null", this.ticket.getPerformId() + "  voucher= " + this.ticket.getVerifyCode() + "  SecKey= " + this.ticket.getPubKey(), this.ticket.voucherUniqueKey);
                alarmVoucher("", "voucherCode为null", this.ticket);
                return;
            }
            renderDetailDynamicCodeErrorXFlushMonitor("voucherCode为null", this.ticket.getPerformId() + "  voucher= " + this.ticket.getVerifyCode() + "  SecKey= " + this.ticket.getPubKey(), this.ticket.voucherUniqueKey);
            alarmVoucher("", "voucherCode为null", this.ticket);
            return;
        }
        final Bitmap qrcodeImage = getQrcodeImage(qrcodeUrl);
        Context context2 = this.context;
        if (context2 == null || ((Activity) context2).isFinishing() || qrcodeImage == null) {
            return;
        }
        ((Activity) this.context).runOnUiThread(new Runnable() { // from class: cn.damai.ticklet.zxing.DecodeQRImage.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "739627016")) {
                    ipChange2.ipc$dispatch("739627016", new Object[]{this});
                    return;
                }
                cb1.b("TimeDown", "imageView draw");
                ImageView imageView = DecodeQRImage.this.imageView;
                if (imageView != null) {
                    imageView.setImageBitmap(qrcodeImage);
                }
            }
        });
    }

    public void setStaticZxing(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603773833")) {
            ipChange.ipc$dispatch("-1603773833", new Object[]{this, bool});
        } else {
            this.isStatic = bool;
        }
    }

    public DecodeQRImage(Context context, UserTicketTable userTicketTable, ImageView imageView, String str) {
        this.context = context;
        this.imageView = imageView;
        this.ticket = userTicketTable;
        this.viewType = str;
    }
}
