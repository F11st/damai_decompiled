package com.taobao.android.dinamicx;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.eventchain.DXEventChainEventHandler;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.view.DXNativeLinearLayout;
import com.taobao.android.dinamicx.view.DXNativeTextView;
import com.taobao.android.dinamicx.widget.DXAdaptiveLinearLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXCheckBoxWidgetNode;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXListLayout;
import com.taobao.android.dinamicx.widget.DXOverlayWidgetNode;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXScrollableLayout;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.taobao.android.dinamicx.widget.DXSectionLayout;
import com.taobao.android.dinamicx.widget.DXSliderLayout;
import com.taobao.android.dinamicx.widget.DXStackCardLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXSwitchWidgetNode;
import com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXViewPager;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import com.taobao.android.dinamicx.widget.a;
import com.taobao.android.dinamicx.widget.b;
import com.taobao.android.dinamicx.widget.c;
import com.taobao.android.dinamicx.widget.d;
import com.taobao.android.dinamicx.widget.e;
import com.taobao.android.dinamicx.widget.h;
import com.taobao.android.dinamicx.widget.i;
import com.taobao.android.dinamicx.widget.j;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;
import com.taobao.android.dinamicx.widget.viewpager.tab.DXTabItemWidgetNode;
import tb.av;
import tb.aw;
import tb.ax;
import tb.bv;
import tb.bw;
import tb.bx;
import tb.c00;
import tb.cv;
import tb.cw;
import tb.cx;
import tb.cz;
import tb.dv;
import tb.dw;
import tb.dx;
import tb.ev;
import tb.ew;
import tb.ex;
import tb.fv;
import tb.fw;
import tb.fx;
import tb.gw;
import tb.gx;
import tb.gz;
import tb.hw;
import tb.hx;
import tb.hz;
import tb.iw;
import tb.ix;
import tb.jt;
import tb.jw;
import tb.jx;
import tb.jy;
import tb.kw;
import tb.kx;
import tb.kz;
import tb.l10;
import tb.lw;
import tb.lx;
import tb.ly;
import tb.m10;
import tb.mw;
import tb.mx;
import tb.mz;
import tb.nw;
import tb.nx;
import tb.ow;
import tb.ox;
import tb.pw;
import tb.px;
import tb.qt;
import tb.qw;
import tb.qx;
import tb.r10;
import tb.rv;
import tb.rw;
import tb.rx;
import tb.ry;
import tb.sv;
import tb.sw;
import tb.tv;
import tb.tw;
import tb.tx;
import tb.u10;
import tb.uu;
import tb.uv;
import tb.uw;
import tb.ux;
import tb.vu;
import tb.vv;
import tb.vw;
import tb.vx;
import tb.w00;
import tb.wt;
import tb.wu;
import tb.wv;
import tb.ww;
import tb.wx;
import tb.x00;
import tb.xu;
import tb.xv;
import tb.xw;
import tb.xx;
import tb.yt;
import tb.yu;
import tb.yv;
import tb.yw;
import tb.yx;
import tb.zu;
import tb.zv;
import tb.zw;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class DXGlobalCenter {
    static DXLongSparseArray<IDXDataParser> a = new DXLongSparseArray<>();
    static DXLongSparseArray<IDXEventHandler> b = new DXLongSparseArray<>();
    static DXLongSparseArray<IDXBuilderWidgetNode> c = new DXLongSparseArray<>();
    static IDXDownloader d;
    static IDXWebImageInterface e;
    static IDXRichTextImageInterface f;
    static IDXAbTestInterface g;
    static IDXHardwareInterface h;
    static IDXWebImageInterface i;
    static IDXConfigInterface j;
    static IDXWebImageUrlInterface k;

    static {
        new Thread(null, new Runnable() { // from class: com.taobao.android.dinamicx.DXGlobalCenter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new DXWidgetNode();
                    new com.taobao.android.dinamicx.widget.d();
                    new DXLinearLayoutWidgetNode();
                    new DXSwitchWidgetNode();
                    new DXTextViewWidgetNode();
                    new com.taobao.android.dinamicx.widget.b();
                    new DXListLayout();
                    new DXImageWidgetNode();
                    new com.taobao.android.dinamicx.widget.a();
                    new DXNativeTextView(DinamicXEngine.i());
                    new DXNativeFrameLayout(DinamicXEngine.i());
                    new DXNativeLinearLayout(DinamicXEngine.i());
                    new DXScrollerLayout();
                    new DXSliderLayout();
                } catch (Throwable th) {
                    try {
                        e eVar = new e(r10.DB_NAME);
                        e.a aVar = new e.a("Engine", "Engine_InitEnv", e.DXERROR_ENGINE_CREATE_VIEW_IN_GLOBAL_CENTER);
                        aVar.e = ry.a(th);
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }, "DXGlobalCenter").start();
        try {
            a.put(uu.DXDMVIEWFLIPPER_DATA, new cz());
            a.put(c00.DX_PARSER_PARENTSUBDATA, new c00());
            a.put(17177078638764L, new yt());
            a.put(5326177973899923051L, new l10());
            a.put(4390557269728183382L, new kz());
            a.put(mz.DX_PARSER_LISTDATA, new mz());
            a.put(jy.DX_PARSER_EVENTCHAINDATA, new jy());
            a.put(ly.DX_PARSER_EVENTCHAINEVENTDATA, new ly());
            a.put(x00.DX_PARSER_ROOTDATA, new x00());
            a.put(-8601334994478314885L, new gw());
            a.put(-7155988592997126393L, new fw());
            a.put(m10.DX_PARSER_SUBDATAINDEX, new m10());
            a.put(qx.DX_PARSER_TEMPLATEDATA, new qx());
            a.put(vu.DX_PARSER_ABILITYHUB, new vu());
            a.put(xv.DX_PARSER_DXEVENTPROP, new xv());
            a.put(10152737943856105L, new mx());
            a.put(2104823241333621454L, new lx());
            a.put(-2766900241128002095L, new nx());
            a.put(8985048662794750L, new kx());
            a.put(38192572096L, new wx());
            a.put(522748242L, new sw());
            a.put(17466137112765L, new zv());
            a.put(516230118L, new yu());
            a.put(803695L, new dx());
            a.put(523960308L, new bx());
            a.put(10224770040602390L, new xx());
            a.put(DXTemplateWidgetNode.DXTEMPLATE_IF, new lw());
            a.put(33857357437L, new yv());
            a.put(2311459087270464967L, new bv());
            a.put(6743940140328071192L, new cv());
            a.put(2043810233379508043L, new ew());
            a.put(-1423751599996947415L, new bw());
            a.put(-3695355688016560275L, new av());
            a.put(3521945216952772436L, new mw());
            a.put(7193167627824317654L, new nw());
            a.put(18043027130931L, new qw());
            a.put(5581002430686265197L, new fx());
            a.put(rv.DX_PARSER_DX_ENV, new rv());
            a.put(xu.DX_PARSER_ADD, new xu());
            a.put(ox.DX_PARSER_SUB, new ox());
            a.put(ax.DX_PARSER_MUL, new ax());
            a.put(uv.DX_PARSER_DIV, new uv());
            a.put(zw.DX_PARSER_MOD, new zw());
            a.put(jw.DX_PARSER_GREATER, new jw());
            a.put(kw.DX_PARSER_GREATEREQUAL, new kw());
            a.put(tw.DX_PARSER_LESS, new tw());
            a.put(uw.DX_PARSER_LESSEQUAL, new uw());
            a.put(cx.DX_PARSER_NOTEQUAL, new cx());
            a.put(tx.DX_PARSER_TODOUBLE, new tx());
            a.put(ux.DX_PARSER_TOLONG, new ux());
            a.put(vx.DX_PARSER_TOSTR, new vx());
            a.put(dv.DX_PARSER_CEIL, new dv());
            a.put(cw.DX_PARSER_FLOOR, new cw());
            a.put(jx.DX_PARSER_ROUND, new jx());
            a.put(ex.DX_DATA_PARSER_ORANGE, new ex());
            a.put(wu.DX_PARSER_ABS, new wu());
            a.put(vw.DX_PARSER_LINEAR_GRADIENT, new vw());
            a.put(rx.DX_PARSER_TOBINDINGXUNIT, new rx());
            a.put(ww.DX_PARSER_MAX, new ww());
            a.put(yw.DX_PARSER_MIN, new yw());
            a.put(ow.DX_PARSER_ISDARKMODE, new ow());
            a.put(ev.DX_PARSER_COLORMAP, new ev());
            a.put(tv.DX_PARSER_DATAPARSERNOTFOUND, new tv());
            a.put(aw.DX_PARSER_EVENTHANDLERNOTFOUND, new aw());
            a.put(sv.DX_PARSER_DXVERSION_GREATERTHANOREQUALTO, new sv());
            a.put(ix.DX_PARSER_RECYCLERDATAINDEX, new ix());
            a.put(hw.DX_PARSER_GETRECYCLERSTATEDATASOURCE, new hw());
            a.put(zu.DX_PARSER_ARRAY_CONCAT, new zu());
            a.put(hx.DX_DATA_PARSER_RECYCLER_CURRENT_POSITION, new hx());
            a.put(gx.DX_PARSER_QUERYRECYCLERCELLINDEXBYUSERID, new gx());
            a.put(px.DX_PARSER_SUB_ARRAY, new px());
            a.put(dw.DX_PARSER_SIZEBYFACTOR, new dw());
            a.put(pw.DX_PARSER_ISELDER, new pw());
            a.put(fv.DX_PARSER_CONTAINSSTR, new fv());
            a.put(vv.DX_PARSER_DXAB, new vv());
            a.put(rw.DX_PARSER_KV, new rw());
            a.put(xw.DX_PARSER_MERGEOBJ, new xw());
            a.put(iw.DX_PARSER_GETTEMPLATEINFO, new iw());
            a.put(wv.DX_PARSER_DXDEVICELEVEL, new wv());
            a.put(-7801350391660369312L, new yx());
            a.put(gz.DX_PARSER_GETWIDGETPROPERTYVALUE, new gz());
            c.put(29525406863L, new DXWidgetNode.c());
            c.put(7821310614898040L, new DXSwitchWidgetNode.a());
            c.put(-7675176749284896753L, new DXCheckBoxWidgetNode.a());
            c.put(4596163952226405054L, new j.b());
            c.put(-2672364288628517304L, new DXTextViewWidgetNode.a());
            c.put(-3496644918488563383L, new b.C0296b());
            c.put(7700670404894374791L, new DXImageWidgetNode.b());
            c.put(8840950490744612256L, new DXImageWidgetNode.b());
            c.put(com.taobao.android.dinamicx.widget.a.DX_WIDGET_ANIMATEDVIEW, new a.C0295a());
            c.put(6637736565700605658L, new c.a());
            c.put(hz.DXGRIDITEM_GRIDITEM, new hz.a());
            c.put(DXTabHeaderLayoutWidgetNode.DXTABHEADERLAYOUT_TABHEADERLAYOUT, new DXTabHeaderLayoutWidgetNode.c());
            c.put(DXTabItemWidgetNode.DXTABITEM_TABITEM, new DXTabItemWidgetNode.a());
            c.put(DXTextInputViewWidgetNode.DXTEXTINPUTVIEW_TEXTINPUTVIEW, new DXTextInputViewWidgetNode.c());
            c.put(qt.DXCALENDARVIEW_CALENDARVIEW, new qt.e());
            c.put(DXSectionLayout.DXSECTIONLAYOUT_SECTIONLAYOUT, new DXSectionLayout());
            c.put(8095935013984139892L, new d.a());
            c.put(5971992526290704869L, new DXLinearLayoutWidgetNode.a());
            c.put(2372426597927978788L, new DXListLayout.a());
            c.put(-7401881896881775333L, new DXAdaptiveLinearLayoutWidgetNode.a());
            c.put(DXScrollerLayout.DX_SCROLLER_LAYOUT, new DXScrollerLayout.a());
            c.put(DXRecyclerLayout.DXRECYCLERLAYOUT_RECYCLERLAYOUT, new DXRecyclerLayout.d());
            c.put(DXStackCardLayoutWidgetNode.DXSTACKCARDLAYOUT_STACKCARDLAYOUT, new DXStackCardLayoutWidgetNode.b());
            c.put(DXViewPager.DXVIEWPAGER_VIEWPAGER, new DXViewPager.b());
            c.put(DXOverlayWidgetNode.DXOVERLAY_OVERLAY, new DXOverlayWidgetNode.c());
            c.put(DXTemplateWidgetNode.DXTEMPLATE_TEMPLATE, new DXTemplateWidgetNode.a());
            c.put(DXSliderLayout.DX_SLIDER_LAYOUT, new DXSliderLayout.a());
            c.put(com.taobao.android.dinamicx.widget.h.DX_PAGE_INDICATOR, new h.a());
            c.put(com.taobao.android.dinamicx.widget.i.DX_SCROLLER_INDICATOR, new i.a());
            c.put(com.taobao.android.dinamicx.widget.e.DX_GRID_LAYOUT, new e.a());
            c.put(DXScrollableLayout.DXSCROLLABLELAYOUT_SCROLLABLELAYOUT, new DXScrollableLayout.a());
            c.put(w00.DXRICHTEXT_RICHTEXT, new w00());
            c.put(u10.DXTEXTSPAN_TEXTSPAN, new u10());
            c.put(DXImageSpanWidgetNode.DXIMAGESPAN_IMAGESPAN, new DXImageSpanWidgetNode());
            b.put(jt.DX_EVENT_BINDINGX, new jt());
            b.put(DXEventChainEventHandler.DX_EVENT_EVENTCHAIN, new DXEventChainEventHandler());
        } catch (Throwable th) {
            try {
                e eVar = new e(r10.DB_NAME);
                e.a aVar = new e.a("Engine", "Engine_InitEnv", 30010);
                aVar.e = ry.a(th);
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public static IDXAbTestInterface a() {
        return g;
    }

    @Nullable
    public static IDXConfigInterface b() {
        return j;
    }

    public static IDXHardwareInterface c() {
        return h;
    }

    public static IDXRichTextImageInterface d(DXRuntimeContext dXRuntimeContext) {
        return f;
    }

    public static IDXWebImageInterface e() {
        return e;
    }

    public static IDXWebImageInterface f(DXRuntimeContext dXRuntimeContext) {
        if (wt.N0(dXRuntimeContext)) {
            return i;
        }
        return e;
    }

    public static IDXWebImageUrlInterface g() {
        return k;
    }
}
