package com.taobao.android.dinamicx.template.db;

import com.taobao.android.dinamicx.template.db.DXDataBaseEntry;

/* compiled from: Taobao */
@DXDataBaseEntry.Table("template_info")
/* loaded from: classes11.dex */
class DXFileDataBaseEntry extends DXDataBaseEntry {
    static final C6392a o = new C6392a(DXFileDataBaseEntry.class);
    @DXDataBaseEntry.Column(indexed = true, notNull = true, primaryKey = true, value = "biz_type")
    public String a;
    @DXDataBaseEntry.Column(indexed = true, notNull = true, primaryKey = true, value = "name")
    public String b;
    @DXDataBaseEntry.Column(notNull = true, primaryKey = true, value = "version")
    public long c;
    @DXDataBaseEntry.Column(notNull = true, value = Columns.MAIN_PATH)
    public String d;
    @DXDataBaseEntry.Column(Columns.STYLE_FILES)
    public String e;
    @DXDataBaseEntry.Column("url")
    public String f;
    @DXDataBaseEntry.Column(Columns.EXTRA_1)
    public String g;
    @DXDataBaseEntry.Column(Columns.EXTRA_2)
    public String h;
    @DXDataBaseEntry.Column(Columns.EXTRA_3)
    public String i;
    @DXDataBaseEntry.Column(Columns.EXTRA_4)
    public String j;
    @DXDataBaseEntry.Column(Columns.EXTRA_5)
    public String k;
    @DXDataBaseEntry.Column(Columns.EXTRA_6)
    public String l;
    @DXDataBaseEntry.Column(Columns.EXTRA_7)
    public String m;
    @DXDataBaseEntry.Column(Columns.EXTRA_8)
    public String n;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    interface Columns extends DXDataBaseEntry.Columns {
        public static final String BIZ_TYPE = "biz_type";
        public static final String EXTRA_1 = "extra_1";
        public static final String EXTRA_2 = "extra_2";
        public static final String EXTRA_3 = "extra_3";
        public static final String EXTRA_4 = "extra_4";
        public static final String EXTRA_5 = "extra_5";
        public static final String EXTRA_6 = "extra_6";
        public static final String EXTRA_7 = "extra_7";
        public static final String EXTRA_8 = "extra_8";
        public static final String MAIN_PATH = "main_path";
        public static final String NAME = "name";
        public static final String STYLE_FILES = "style_files";
        public static final String URL = "url";
        public static final String VERSION = "version";
    }

    DXFileDataBaseEntry() {
    }

    public String toString() {
        return "DXFileDataBaseEntry{bizType='" + this.a + "', name='" + this.b + "', version=" + this.c + ", mainPath='" + this.d + "', styleFiles='" + this.e + "', url='" + this.f + "', extra1='" + this.g + "', extra2='" + this.h + "', extra3='" + this.i + "', extra4='" + this.j + "', extra5='" + this.k + "', extra6='" + this.l + "', extra7='" + this.m + "', extra8='" + this.n + "'}";
    }
}
