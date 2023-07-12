package com.android.alibaba.ip.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.utils.PreferencesUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class PreferencesProvider extends ContentProvider {
    public static String AUTHORITIES_KEY = "authorities_key";
    public static String AUTHORITIES_SPNAME = "authorities_spname";
    public static final int BOOLEAN_CONTENT_URI_CODE = 105;
    public static final int CLEAR_CONTENT_URI_CODE = 108;
    public static String COLUMNNAME = "SPCOLUMNNAME";
    public static final int DELETE_CONTENT_URI_CODE = 106;
    public static final int FLOAT_CONTENT_URI_CODE = 104;
    public static final int INTEGER_CONTENT_URI_CODE = 101;
    public static final int LONG_CONTENT_URI_CODE = 102;
    public static final int PUTS_CONTENT_URI_CODE = 107;
    public static final int STRING_CONTENT_URI_CODE = 100;
    private UriMatcher mUriMatcher;
    private String mStringPath = "string/*/*/";
    private String mIntegerPath = "integer/*/*/";
    private String mLongPath = "long/*/*/";
    private String mFloatPath = "float/*/*/";
    private String mBooleanPath = "boolean/*/*/";
    private String mDeletePath = "delete/*/*/";
    private String mPutsPath = "puts";
    private String mClearPath = "clear/*/";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class Model {
        private Object defValue;
        private String key;
        private String spName;

        private Model() {
        }

        public Object getDefValue() {
            return this.defValue;
        }

        public String getKey() {
            return this.key;
        }

        public String getSpName() {
            return this.spName;
        }

        public void setDefValue(Object obj) {
            this.defValue = obj;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setSpName(String str) {
            this.spName = str;
        }
    }

    private Cursor buildCursor(Context context, Model model, int i) {
        Object string;
        Object defValue = model.getDefValue();
        switch (i) {
            case 100:
                if (defValue == null) {
                    string = PreferencesUtils.getString(context, model.getSpName(), model.getKey());
                    break;
                } else {
                    string = PreferencesUtils.getString(context, model.getSpName(), model.getKey(), String.valueOf(defValue));
                    break;
                }
            case 101:
                if (defValue == null) {
                    string = Integer.valueOf(PreferencesUtils.getInt(context, model.getSpName(), model.getKey()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(defValue + "")) {
                        defValue = -1;
                    }
                    string = Integer.valueOf(PreferencesUtils.getInt(context, model.getSpName(), model.getKey(), Integer.parseInt(defValue + "")));
                    break;
                }
            case 102:
                if (defValue == null) {
                    string = Long.valueOf(PreferencesUtils.getLong(context, model.getSpName(), model.getKey()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(defValue + "")) {
                        defValue = -1;
                    }
                    string = Long.valueOf(PreferencesUtils.getLong(context, model.getSpName(), model.getKey(), Long.parseLong(defValue + "")));
                    break;
                }
            case 103:
            default:
                string = null;
                break;
            case 104:
                if (defValue == null) {
                    string = Float.valueOf(PreferencesUtils.getFloat(context, model.getSpName(), model.getKey()));
                    break;
                } else {
                    string = Float.valueOf(PreferencesUtils.getFloat(context, model.getSpName(), model.getKey(), Float.parseFloat(defValue + "")));
                    break;
                }
            case 105:
                if (defValue == null) {
                    string = PreferencesUtils.getBoolean(context, model.getSpName(), model.getKey()) + "";
                    break;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(PreferencesUtils.getBoolean(context, model.getSpName(), model.getKey(), Boolean.valueOf(defValue + "").booleanValue()));
                    sb.append("");
                    string = sb.toString();
                    break;
                }
        }
        if (string == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{COLUMNNAME});
        matrixCursor.addRow(new Object[]{string});
        return matrixCursor;
    }

    @RequiresApi(api = 9)
    private void clear(Context context, Model model) {
        PreferencesUtils.getEditor(context, model.getSpName()).clear().apply();
    }

    private Model getModel(Uri uri) {
        try {
            Model model = new Model();
            model.setSpName(uri.getPathSegments().get(1));
            if (uri.getPathSegments().size() > 2) {
                model.setKey(uri.getPathSegments().get(2));
            }
            if (uri.getPathSegments().size() > 3) {
                model.setDefValue(uri.getPathSegments().get(3));
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @RequiresApi(api = 9)
    public int delete(Uri uri, String str, String[] strArr) {
        Model model = getModel(uri);
        if (model == null) {
            return -1;
        }
        int match = this.mUriMatcher.match(uri);
        if (match != 106) {
            if (match != 108 || TextUtils.isEmpty(model.spName)) {
                return 0;
            }
            clear(getContext(), model);
            return 0;
        }
        delete(getContext(), model);
        return 0;
    }

    public abstract String getAuthorities();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @RequiresApi(api = 11)
    public Uri insert(Uri uri, ContentValues contentValues) {
        Model model = getModel(uri);
        if (model == null) {
            return null;
        }
        int match = this.mUriMatcher.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105 || match == 107) {
            insert(getContext(), contentValues, model);
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String authorities = getAuthorities();
        PreferencesUtils.putString(getContext(), AUTHORITIES_SPNAME, AUTHORITIES_KEY, authorities);
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.mUriMatcher = uriMatcher;
        uriMatcher.addURI(authorities, this.mStringPath, 100);
        UriMatcher uriMatcher2 = this.mUriMatcher;
        uriMatcher2.addURI(authorities, this.mStringPath + "*/", 100);
        this.mUriMatcher.addURI(authorities, this.mIntegerPath, 101);
        UriMatcher uriMatcher3 = this.mUriMatcher;
        uriMatcher3.addURI(authorities, this.mIntegerPath + "*/", 101);
        this.mUriMatcher.addURI(authorities, this.mLongPath, 102);
        UriMatcher uriMatcher4 = this.mUriMatcher;
        uriMatcher4.addURI(authorities, this.mLongPath + "*/", 102);
        this.mUriMatcher.addURI(authorities, this.mFloatPath, 104);
        UriMatcher uriMatcher5 = this.mUriMatcher;
        uriMatcher5.addURI(authorities, this.mFloatPath + "*/", 104);
        this.mUriMatcher.addURI(authorities, this.mBooleanPath, 105);
        UriMatcher uriMatcher6 = this.mUriMatcher;
        uriMatcher6.addURI(authorities, this.mBooleanPath + "*/", 105);
        this.mUriMatcher.addURI(authorities, this.mDeletePath, 106);
        this.mUriMatcher.addURI(authorities, this.mClearPath, 108);
        this.mUriMatcher.addURI(authorities, this.mPutsPath, 107);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Model model = getModel(uri);
        if (model == null) {
            return null;
        }
        return buildCursor(getContext(), model, this.mUriMatcher.match(uri));
    }

    @Override // android.content.ContentProvider
    @RequiresApi(api = 11)
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Model model = getModel(uri);
        if (model == null) {
            return -1;
        }
        int match = this.mUriMatcher.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            insert(getContext(), contentValues, model);
            return 0;
        }
        return 0;
    }

    @RequiresApi(api = 11)
    private void insert(Context context, ContentValues contentValues, Model model) {
        SharedPreferences.Editor editor = PreferencesUtils.getEditor(context, model.getSpName());
        for (String str : contentValues.keySet()) {
            Object obj = contentValues.get(str);
            if (obj instanceof Integer) {
                editor.putInt(str, Integer.parseInt(obj + ""));
            } else if (obj instanceof Long) {
                editor.putLong(str, Long.parseLong(obj + ""));
            } else if (obj instanceof Float) {
                editor.putFloat(str, Float.parseFloat(obj + ""));
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, Boolean.valueOf(obj + "").booleanValue());
            } else {
                StringBuilder sb = new StringBuilder();
                if (obj == null) {
                    obj = "";
                }
                sb.append(obj);
                sb.append("");
                editor.putString(str, sb.toString());
            }
        }
        editor.apply();
    }

    @RequiresApi(api = 9)
    private void delete(Context context, Model model) {
        SharedPreferences.Editor editor = PreferencesUtils.getEditor(context, model.getSpName());
        editor.remove(model.getKey());
        editor.apply();
    }
}
