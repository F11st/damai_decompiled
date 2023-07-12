package cn.damai.commonbusiness.photoselect.imageselected.model;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.vo0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageModel {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface DataCallback {
        void onSuccess(ArrayList<vo0> arrayList);
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1032235778") ? (String) ipChange.ipc$dispatch("-1032235778", new Object[]{str}) : (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() - 1) ? "" : str.substring(lastIndexOf + 1);
    }

    private static vo0 getFolder(String str, List<vo0> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721608094")) {
            return (vo0) ipChange.ipc$dispatch("-1721608094", new Object[]{str, list});
        }
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                vo0 vo0Var = list.get(i);
                if (str.equals(vo0Var.c())) {
                    return vo0Var;
                }
            }
        }
        vo0 vo0Var2 = new vo0(str);
        list.add(vo0Var2);
        return vo0Var2;
    }

    public static String getFolderName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076562905")) {
            return (String) ipChange.ipc$dispatch("-2076562905", new Object[]{str});
        }
        if (wh2.i(str)) {
            String[] split = str.split(File.separator);
            return split.length >= 2 ? split[split.length - 2] : "";
        }
        return "";
    }

    public static void loadImageForSDCard(final Context context, final DataCallback dataCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303227020")) {
            ipChange.ipc$dispatch("-1303227020", new Object[]{context, dataCallback});
        } else {
            new Thread(new Runnable() { // from class: cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1522452902")) {
                        ipChange2.ipc$dispatch("1522452902", new Object[]{this});
                        return;
                    }
                    Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "_display_name", "date_added", "_id"}, null, null, "date_added");
                    ArrayList arrayList = new ArrayList();
                    if (query != null) {
                        while (query.moveToNext()) {
                            Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id")));
                            String string = query.getString(query.getColumnIndex("_data"));
                            String string2 = query.getString(query.getColumnIndex("_display_name"));
                            long j = query.getLong(query.getColumnIndex("date_added"));
                            if (!".downloading".equals(ImageModel.getExtensionName(string))) {
                                Image image = new Image(string, j, string2);
                                image.uri = withAppendedId;
                                arrayList.add(image);
                            }
                        }
                        query.close();
                    }
                    Collections.reverse(arrayList);
                    dataCallback.onSuccess(ImageModel.splitFolder(context, arrayList));
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<vo0> splitFolder(Context context, ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067732654")) {
            return (ArrayList) ipChange.ipc$dispatch("-2067732654", new Object[]{context, arrayList});
        }
        ArrayList<vo0> arrayList2 = new ArrayList<>();
        arrayList2.add(new vo0(context != null ? context.getResources().getString(R$string.damai_all_image) : "所有照片", arrayList));
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String folderName = getFolderName(arrayList.get(i).getPath());
                if (wh2.i(folderName)) {
                    getFolder(folderName, arrayList2).a(arrayList.get(i));
                }
            }
        }
        return arrayList2;
    }
}
