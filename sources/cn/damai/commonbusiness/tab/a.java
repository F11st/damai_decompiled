package cn.damai.commonbusiness.tab;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.DamaiConstants;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.commonbusiness.tab.download.ImageDownLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.tab.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040a implements Comparator<BottomSheetBean.Result> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        C0040a(List list) {
            this.a = list;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BottomSheetBean.Result result, BottomSheetBean.Result result2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-767855882") ? ((Integer) ipChange.ipc$dispatch("-767855882", new Object[]{this, result, result2})).intValue() : this.a.indexOf(result.type) - this.a.indexOf(result2.type);
        }
    }

    private static void a(List<TabItem> list, List<BottomSheetBean.Result> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830494745")) {
            ipChange.ipc$dispatch("-830494745", new Object[]{list, list2});
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).type);
        }
        Collections.sort(list2, new C0040a(arrayList));
    }

    @Nullable
    public static String b(@Nullable BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306242536")) {
            return (String) ipChange.ipc$dispatch("-306242536", new Object[]{bottomSheetBean});
        }
        if (bottomSheetBean == null || cb2.d(bottomSheetBean.content)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (BottomSheetBean.Result result : bottomSheetBean.content) {
            if (result != null) {
                hashMap.put(result.type, result);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (TabItem tabItem : e()) {
            if (((BottomSheetBean.Result) hashMap.get(tabItem.type)) == null) {
                sb.append("[缺失 ");
                sb.append(tabItem.tabText);
                sb.append(" ");
                sb.append(tabItem.type);
                sb.append(jn1.ARRAY_END_STR);
            }
        }
        return sb.toString();
    }

    private static boolean c(TabItem tabItem, BottomSheetBean.Result result, ImageDownLoader imageDownLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126825826")) {
            return ((Boolean) ipChange.ipc$dispatch("2126825826", new Object[]{tabItem, result, imageDownLoader})).booleanValue();
        }
        Bitmap h = imageDownLoader.h(f(result.defaultPic));
        Bitmap h2 = imageDownLoader.h(f(result.checkedPic));
        Bitmap h3 = imageDownLoader.h(f(result.reCheckedPic));
        if (h2 == null || h == null) {
            return false;
        }
        if (TextUtils.equals(tabItem.type, "1") && h3 == null) {
            return false;
        }
        tabItem.tabText = result.text;
        tabItem.tabImageType = TabItem.ICON_TYPE_BITMAP;
        tabItem.normalBitmap = h;
        tabItem.selectedBitmap = h2;
        tabItem.reSelectedBitmap = h3;
        tabItem.tabTextNormalColor = result.defaultTextColor;
        tabItem.tabTextSelectColor = result.checkedTextColor;
        return true;
    }

    public static boolean d(@Nullable BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597419865")) {
            return ((Boolean) ipChange.ipc$dispatch("-1597419865", new Object[]{bottomSheetBean})).booleanValue();
        }
        if (bottomSheetBean == null || cb2.d(bottomSheetBean.content)) {
            return false;
        }
        List<TabItem> e = e();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < e.size(); i++) {
            arrayList.add(e.get(i).type);
        }
        List<BottomSheetBean.Result> list = bottomSheetBean.content;
        Iterator<BottomSheetBean.Result> it = list.iterator();
        HashSet hashSet = new HashSet();
        while (it.hasNext()) {
            String str = it.next().type;
            if (!arrayList.contains(str)) {
                it.remove();
            } else if (hashSet.contains(str)) {
                it.remove();
            } else {
                hashSet.add(str);
            }
        }
        if (e.size() != list.size()) {
            list.clear();
        }
        return list.size() > 0;
    }

    public static List<TabItem> e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428706451")) {
            return (List) ipChange.ipc$dispatch("-428706451", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        TabItem tabItem = new TabItem();
        tabItem.tab = DamaiConstants.TAB_HOME;
        tabItem.tabText = "精选";
        tabItem.tabImageType = TabItem.ICON_TYPE_RES;
        tabItem.normalIconId = R$drawable.default_tab_home_normal;
        tabItem.selectedIconId = R$drawable.default_tab_home_selected;
        tabItem.tabTextSelectColor = "#FF2869";
        tabItem.tabTextNormalColor = "#9C9CA5";
        tabItem.type = "1";
        arrayList.add(tabItem);
        TabItem tabItem2 = new TabItem();
        tabItem2.tab = DamaiConstants.TAB_FIND;
        tabItem2.tabText = "现场";
        tabItem2.tabImageType = TabItem.ICON_TYPE_RES;
        tabItem2.normalIconId = R$drawable.default_tab_find_normal;
        tabItem2.selectedIconId = R$drawable.default_tab_find_selected;
        tabItem2.tabTextSelectColor = "#FF2869";
        tabItem2.tabTextNormalColor = "#9C9CA5";
        tabItem2.type = "2";
        arrayList.add(tabItem2);
        TabItem tabItem3 = new TabItem();
        tabItem3.tab = DamaiConstants.TAB_HUIYUAN;
        tabItem3.tabText = "会员";
        tabItem3.tabImageType = TabItem.ICON_TYPE_RES;
        tabItem3.normalIconId = R$drawable.default_tab_member_normal;
        tabItem3.selectedIconId = R$drawable.default_tab_member_selected;
        tabItem3.tabTextSelectColor = "#FF2869";
        tabItem3.tabTextNormalColor = "#9C9CA5";
        tabItem3.type = "3";
        arrayList.add(tabItem3);
        TabItem tabItem4 = new TabItem();
        tabItem4.tab = DamaiConstants.TAB_MEMBER;
        tabItem4.tabText = "票夹";
        tabItem4.tabImageType = TabItem.ICON_TYPE_RES;
        tabItem4.normalIconId = R$drawable.default_tab_ticklet_normal;
        tabItem4.selectedIconId = R$drawable.default_tab_ticklet_selected;
        tabItem4.tabTextSelectColor = "#FF2869";
        tabItem4.tabTextNormalColor = "#9C9CA5";
        tabItem4.type = "4";
        arrayList.add(tabItem4);
        TabItem tabItem5 = new TabItem();
        tabItem5.tab = DamaiConstants.TAB_MINE;
        tabItem5.tabText = "我的";
        tabItem5.tabImageType = TabItem.ICON_TYPE_RES;
        tabItem5.normalIconId = R$drawable.default_tab_mine_normal;
        tabItem5.selectedIconId = R$drawable.default_tab_mine_selected;
        tabItem5.tabTextSelectColor = "#FF2869";
        tabItem5.tabTextNormalColor = "#9C9CA5";
        tabItem5.type = "5";
        arrayList.add(tabItem5);
        return arrayList;
    }

    private static String f(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1521979902") ? (String) ipChange.ipc$dispatch("1521979902", new Object[]{str}) : TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean g(@Nullable BottomSheetBean bottomSheetBean) {
        List<BottomSheetBean.Result> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961237486")) {
            return ((Boolean) ipChange.ipc$dispatch("961237486", new Object[]{bottomSheetBean})).booleanValue();
        }
        if (bottomSheetBean == null || (list = bottomSheetBean.content) == null) {
            return false;
        }
        List<TabItem> e = e();
        if (list.size() != e.size()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(e.size());
        ArrayList arrayList2 = new ArrayList(e.size());
        for (TabItem tabItem : e) {
            arrayList.add(tabItem.type);
        }
        for (BottomSheetBean.Result result : list) {
            arrayList2.add(TextUtils.isEmpty(result.type) ? "" : result.type);
        }
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.equals((CharSequence) arrayList.get(i), (CharSequence) arrayList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static List<TabItem> h(@NonNull BottomSheetBean bottomSheetBean, @NonNull ImageDownLoader imageDownLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871799251")) {
            return (List) ipChange.ipc$dispatch("-871799251", new Object[]{bottomSheetBean, imageDownLoader});
        }
        try {
            List<BottomSheetBean.Result> list = bottomSheetBean.content;
            List<TabItem> e = e();
            ArrayList arrayList = new ArrayList();
            a(e, list);
            int size = e.size();
            for (int i = 0; i < size; i++) {
                TabItem tabItem = e.get(i);
                if (!c(tabItem, list.get(i), imageDownLoader)) {
                    break;
                }
                arrayList.add(tabItem);
            }
            if (arrayList.size() == e.size()) {
                return arrayList;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
