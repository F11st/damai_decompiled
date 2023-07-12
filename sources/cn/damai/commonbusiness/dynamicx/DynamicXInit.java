package cn.damai.commonbusiness.dynamicx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.dynamicx.customwidget.imageview.DMDXWebImageInterface;
import cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout.DXDMScrollLayoutWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DXDMPicConvertViewWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.a;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.f;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.weex.common.Constants;
import java.io.Serializable;
import tb.ar;
import tb.br;
import tb.cb1;
import tb.cu;
import tb.dr;
import tb.du;
import tb.dy;
import tb.eu;
import tb.fu;
import tb.gu;
import tb.gv;
import tb.hu;
import tb.hv;
import tb.iu;
import tb.iv;
import tb.ju;
import tb.jv;
import tb.ku;
import tb.kv;
import tb.lv;
import tb.mu;
import tb.mu0;
import tb.mv;
import tb.nu;
import tb.nv;
import tb.ou;
import tb.ov;
import tb.pu;
import tb.pv;
import tb.qu;
import tb.qv;
import tb.ru;
import tb.sx;
import tb.t60;
import tb.tq;
import tb.tu;
import tb.uu;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DynamicXInit {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ImgStateRecord implements Serializable {
        public boolean isShouldUseDefault;

        public ImgStateRecord(boolean z) {
            this.isShouldUseDefault = z;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMDXWebImageInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.dynamicx.DynamicXInit$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0033a implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C0033a(a aVar, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "275876484")) {
                    ipChange.ipc$dispatch("275876484", new Object[]{this, eVar});
                    return;
                }
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    this.a.setImageDrawable(drawable);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class b implements DMImageCreator.DMImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DXDMImageViewWidgetNode.c a;
            final /* synthetic */ ImageView b;

            b(a aVar, DXDMImageViewWidgetNode.c cVar, ImageView imageView) {
                this.a = cVar;
                this.b = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1105066289")) {
                    ipChange.ipc$dispatch("1105066289", new Object[]{this, dVar});
                } else if (this.a.k()) {
                    dr.b(this.b, this.a.b, new ImgStateRecord(true));
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class c implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImgStateRecord a;
            final /* synthetic */ ImageView b;

            c(a aVar, ImgStateRecord imgStateRecord, ImageView imageView) {
                this.a = imgStateRecord;
                this.b = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-940277242")) {
                    ipChange.ipc$dispatch("-940277242", new Object[]{this, eVar});
                    return;
                }
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    this.a.isShouldUseDefault = false;
                    dr.a = true;
                    this.b.setImageDrawable(drawable);
                }
            }
        }

        a() {
        }

        @Override // com.taobao.android.dinamicx.widget.IDXWebImageInterface
        public ImageView buildView(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2076446273")) {
                return (ImageView) ipChange.ipc$dispatch("-2076446273", new Object[]{this, context});
            }
            RoundImageView roundImageView = new RoundImageView(context);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(0);
            return roundImageView;
        }

        @Override // com.taobao.android.dinamicx.widget.IDXWebImageInterface
        public void setImage(ImageView imageView, String str, DXImageWidgetNode.c cVar) {
            DMImageCreator c2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1957313351")) {
                ipChange.ipc$dispatch("-1957313351", new Object[]{this, imageView, str, cVar});
                return;
            }
            if (!wh2.j(str) && str.contains("?optParams=")) {
                int[] f = DynamicXInit.f(str);
                c2 = cn.damai.common.image.a.b().f(DynamicXInit.g(str), f[0], f[1]);
            } else {
                c2 = cn.damai.common.image.a.b().c(str);
            }
            if (cVar.m()) {
                imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            }
            if (cVar.l()) {
                ((RoundImageView) imageView).setBorderRadius(t60.e(imageView.getContext(), cVar.a[0]));
            }
            c2.n(new C0033a(this, imageView));
            c2.f();
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.imageview.DMDXWebImageInterface
        public void setImageWithPlaceHolder(ImageView imageView, String str, DXDMImageViewWidgetNode.c cVar) {
            DMImageCreator c2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-670335442")) {
                ipChange.ipc$dispatch("-670335442", new Object[]{this, imageView, str, cVar});
                return;
            }
            if (!wh2.j(str) && str.contains("?optParams=")) {
                int[] f = DynamicXInit.f(str);
                c2 = cn.damai.common.image.a.b().f(DynamicXInit.g(str), f[0], f[1]);
            } else {
                c2 = cn.damai.common.image.a.b().c(str);
            }
            ImgStateRecord imgStateRecord = new ImgStateRecord(true);
            if (cVar.k()) {
                dr.b(imageView, cVar.b, imgStateRecord);
            }
            if (cVar.j()) {
                int[] iArr = cVar.a;
                if (cVar.i()) {
                    ((RoundImageView) imageView).setType(0);
                } else {
                    ((RoundImageView) imageView).setBorderRadius(t60.e(imageView.getContext(), iArr[0]));
                }
            }
            c2.n(new c(this, imgStateRecord, imageView)).e(new b(this, cVar, imageView));
            c2.f();
        }
    }

    public static IDXAppMonitor c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2009300106") ? (IDXAppMonitor) ipChange.ipc$dispatch("-2009300106", new Object[0]) : new ar();
    }

    public static DXLongSparseArray<IDXEventHandler> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655361033")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("655361033", new Object[0]);
        }
        DXLongSparseArray<IDXEventHandler> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(cu.DX_EVENT_DMAUTOJUMP, new cu());
        return dXLongSparseArray;
    }

    private static IDXWebImageInterface e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1080750527") ? (IDXWebImageInterface) ipChange.ipc$dispatch("1080750527", new Object[0]) : new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] f(String str) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244724723")) {
            return (int[]) ipChange.ipc$dispatch("-244724723", new Object[]{str});
        }
        String replace = str.substring(str.indexOf("?optParams=")).replace("?optParams=", "");
        int i3 = -1;
        if (replace.contains(Constants.Name.X)) {
            String[] split = replace.split(Constants.Name.X);
            if (tq.a(split) == 2 && !wh2.j(split[0]) && !wh2.j(split[1])) {
                try {
                    i2 = Integer.parseInt(split[0]);
                    try {
                        i = Integer.parseInt(split[1]);
                        i3 = i2;
                    } catch (Exception e) {
                        e = e;
                        cb1.a(e.getMessage());
                        i3 = i2;
                        i = -1;
                        return new int[]{i3, i};
                    }
                } catch (Exception e2) {
                    e = e2;
                    i2 = -1;
                }
                return new int[]{i3, i};
            }
        }
        i = -1;
        return new int[]{i3, i};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-111892535") ? (String) ipChange.ipc$dispatch("-111892535", new Object[]{str}) : str.substring(0, str.indexOf("?optParams="));
    }

    public static DXLongSparseArray<IDXDataParser> h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641378678")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("641378678", new Object[0]);
        }
        DXLongSparseArray<IDXDataParser> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(pv.DX_PARSER_DMTRANSFERARRAY, new pv());
        dXLongSparseArray.put(lv.DX_PARSER_DMOSTYPE, new lv());
        dXLongSparseArray.put(qv.DX_PARSER_DMTRANSFERSTRING, new qv());
        dXLongSparseArray.put(sx.DX_PARSER_TOCOMPUTEPX, new sx());
        dXLongSparseArray.put(gv.DX_PARSER_DMADAPTIVEHEIGHT, new gv());
        dXLongSparseArray.put(iv.DX_PARSER_DMISH5, new iv());
        dXLongSparseArray.put(ov.DX_PARSER_DMTOWEBP, new ov());
        dXLongSparseArray.put(jv.DX_PARSER_DXDATAPARSERDMMERGE, new jv());
        dXLongSparseArray.put(mv.DX_PARSER_DMRANDOMEQUAL, new mv());
        dXLongSparseArray.put(kv.DX_PARSER_DMNUMBERFORMAT, new kv());
        dXLongSparseArray.put(hv.DX_PARSER_DMINDEX, new hv());
        dXLongSparseArray.put(nv.DX_PARSER_DMSUBARRAY, new nv());
        return dXLongSparseArray;
    }

    public static IDXRemoteDebugLog i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1474117847") ? (IDXRemoteDebugLog) ipChange.ipc$dispatch("1474117847", new Object[0]) : new br();
    }

    private static DXLongSparseArray<IDXBuilderWidgetNode> j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906630299")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("906630299", new Object[0]);
        }
        DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(gu.DX_DMFRAMELAYOUT, new gu.a());
        dXLongSparseArray.put(tu.DX_DMTEXTVIEW, new tu.a());
        dXLongSparseArray.put(iu.DX_DMHOMECARDTAGVIEW, new iu.a());
        dXLongSparseArray.put(du.DX_DMCOLORFRAMELAYOUT, new du.a());
        dXLongSparseArray.put(DXDMScrollLayoutWidgetNode.DX_DMSCROLLLAYOUT, new DXDMScrollLayoutWidgetNode.a());
        dXLongSparseArray.put(mu.DX_DMICONFONTVIEW, new mu.a());
        dXLongSparseArray.put(hu.DXDMGRADUALCOLORTEXTVIEW_DMGRADUALCOLORTEXTVIEW, new hu.a());
        dXLongSparseArray.put(ru.DX_DMTAPFRAMELAYOUT, new ru.a());
        dXLongSparseArray.put(DXDMImageViewWidgetNode.DX_DMIMAGEVIEW, new DXDMImageViewWidgetNode.b());
        dXLongSparseArray.put(fu.DX_DMDASHVIEW, new fu.a());
        dXLongSparseArray.put(ju.DXDMHOMEGRABTICKETNOTICEVIEW_DMHOMEGRABTICKETNOTICEVIEW, new ju.a());
        dXLongSparseArray.put(cn.damai.commonbusiness.dynamicx.customwidget.temp.a.DX_DMCOUNTDOWNVIEW, new a.C0034a());
        dXLongSparseArray.put(qu.DX_DMSELLTEXTVIEW, new qu.a());
        dXLongSparseArray.put(ku.DXDMHOMEMARKETADVIEW_DMHOMEMARKETADVIEW, new ku());
        dXLongSparseArray.put(pu.DXDMSCALEANIMATIONVIEW_DMSCALEANIMATIONVIEW, new pu());
        dXLongSparseArray.put(ou.DXDMPROJECTSTATUSTAGVIEW_DMPROJECTSTATUSTAGVIEW, new ou());
        dXLongSparseArray.put(eu.DXDMCOMMENTSCOREVIEW_DMCOMMENTSCOREVIEW, new eu());
        dXLongSparseArray.put(nu.DXDMLIVEANIMVIEW_DMLIVEANIMVIEW, new nu());
        dXLongSparseArray.put(dy.DXDMIMAGEANIMVIEW_DMIMAGEANIMVIEW, new dy());
        dXLongSparseArray.put(uu.DXDMVIEWFLIPPER_DMVIEWFLIPPER, new uu());
        dXLongSparseArray.put(DXDMPicConvertViewWidgetNode.DXDMPICCONVERTVIEW_DMPICCONVERTVIEW, new DXDMPicConvertViewWidgetNode());
        return dXLongSparseArray;
    }

    public static void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173634525")) {
            ipChange.ipc$dispatch("-173634525", new Object[0]);
            return;
        }
        f.b bVar = new f.b();
        bVar.B(e());
        bVar.z(j());
        bVar.x(h());
        bVar.y(d());
        bVar.w(AppConfig.v());
        bVar.v(c());
        bVar.A(i());
        DinamicXEngine.w(mu0.a(), bVar.u());
    }
}
