package cn.damai.tetris.componentplugin;

import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.component.drama.viewholder.FilterViewHolder;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;
import tb.xr;

/* compiled from: Taobao */
@Deprecated
/* renamed from: cn.damai.tetris.componentplugin.a */
/* loaded from: classes16.dex */
public class C1985a {
    public static final int TYPE_BIND_ITEM_DATA = 2050;
    public static final int TYPE_CALENDAR_CLICK = 2051;
    public static final int TYPE_MAIN_CLICK = 2048;
    public static final int TYPE_TAG_CLICK = 2049;
    public FilterMainBean a;
    public FilterTagBean b;
    public FilterViewHolder c;
    public int d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.componentplugin.a$a */
    /* loaded from: classes7.dex */
    public static class C1986a implements FilterViewHolder.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private ja a;

        public C1986a(ja jaVar) {
            this.a = jaVar;
        }

        private void a(int i, C1985a c1985a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1130292901")) {
                ipChange.ipc$dispatch("-1130292901", new Object[]{this, Integer.valueOf(i), c1985a});
                return;
            }
            ja jaVar = this.a;
            if (jaVar != null) {
                xr.c(jaVar.a(), new Message(i, c1985a));
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onCalendarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2117668542")) {
                ipChange.ipc$dispatch("2117668542", new Object[]{this});
            } else {
                a(2051, new C1985a());
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onMainTabClick(FilterMainBean filterMainBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-631415069")) {
                ipChange.ipc$dispatch("-631415069", new Object[]{this, filterMainBean, Integer.valueOf(i)});
            } else {
                a(2048, new C1985a(filterMainBean, i));
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemClickListener
        public void onTagClick(FilterTagBean filterTagBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "315994984")) {
                ipChange.ipc$dispatch("315994984", new Object[]{this, filterTagBean, Integer.valueOf(i)});
            } else {
                a(C1985a.TYPE_TAG_CLICK, new C1985a(filterTagBean, i));
            }
        }
    }

    public C1985a() {
    }

    public C1985a(FilterViewHolder filterViewHolder) {
        this.c = filterViewHolder;
    }

    public C1985a(FilterMainBean filterMainBean, int i) {
        this.a = filterMainBean;
        this.d = i;
    }

    public C1985a(FilterTagBean filterTagBean, int i) {
        this.b = filterTagBean;
        this.d = i;
    }
}
