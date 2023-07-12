package cn.damai.commonbusiness.tab;

import android.graphics.Bitmap;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TabItem implements Serializable {
    public static int ICON_TYPE_BITMAP = 2;
    public static int ICON_TYPE_RES = 1;
    public static final String TYPE_FIND = "2";
    public static final String TYPE_HOME = "1";
    public static final String TYPE_HUIYUAN = "3";
    public static final String TYPE_MEMBER = "4";
    public static final String TYPE_MINE = "5";
    public Bitmap normalBitmap;
    public int normalIconId;
    public int popPosition = -1;
    public String popText;
    public Bitmap reSelectedBitmap;
    public Bitmap selectedBitmap;
    public int selectedIconId;
    public String tab;
    public int tabImageType;
    public String tabText;
    public String tabTextNormalColor;
    public String tabTextSelectColor;
    public ITabView tabView;
    public String type;
}
