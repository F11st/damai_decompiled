package com.taobao.uikit.feature.features;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.taobao.uikit.base.R;
import com.taobao.uikit.feature.callback.ImageSaveCallback;
import com.taobao.uikit.feature.callback.TouchEventCallback;
import com.taobao.uikit.feature.view.TBackFragment;
import com.taobao.weex.ui.component.WXComponent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageSaveFeature extends AbsFeature<ImageView> implements ImageSaveCallback, TouchEventCallback {
    public static final int IMAGE_SAVE_REQUEST_CODE = 1502;
    private Context mContext;
    private Dialog mDialog;
    private SaveFileTask mSaveFileTask;
    private PointF mStartPoint = new PointF();
    private Bitmap mSaveBmp = null;
    private boolean mActive = false;
    private HashMap<String, ImageSaveFeatureCallback> mChoices = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ImageSaveFeatureCallback {
        void doMethod(ImageView imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class SaveFileTask extends AsyncTask<Object, Void, Integer> {
        private static final int FAIL_FULL = 2;
        private static final int FAIL_GET = 1;
        private static final int SUCCESS_SAVE = 0;
        private Uri mUri;

        private SaveFileTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... objArr) {
            ParcelFileDescriptor parcelFileDescriptor;
            int i = 0;
            this.mUri = (Uri) objArr[0];
            Bitmap bitmap = (Bitmap) objArr[1];
            if (bitmap != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        parcelFileDescriptor = ImageSaveFeature.this.mContext.getContentResolver().openFileDescriptor(this.mUri, WXComponent.PROP_FS_WRAP_CONTENT);
                        try {
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                                try {
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    parcelFileDescriptor.close();
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    i = 2;
                                    if (fileOutputStream != null) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    }
                                    if (parcelFileDescriptor != null) {
                                        parcelFileDescriptor.close();
                                    }
                                    return Integer.valueOf(i);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.flush();
                                            fileOutputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (parcelFileDescriptor != null) {
                                        parcelFileDescriptor.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        parcelFileDescriptor = null;
                    } catch (Throwable th3) {
                        th = th3;
                        parcelFileDescriptor = null;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } else {
                i = 1;
            }
            return Integer.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            int intValue = num.intValue();
            if (intValue == 0) {
                Toast.makeText(ImageSaveFeature.this.mContext.getApplicationContext(), ImageSaveFeature.this.getStringResource(R.string.uik_save_image_success), 0).show();
                if (ImageSaveFeature.this.checkSavePlan()) {
                    ImageSaveFeature.this.notifyNewMedia(this.mUri);
                }
            } else if (intValue == 1) {
                Toast.makeText(ImageSaveFeature.this.mContext.getApplicationContext(), ImageSaveFeature.this.getStringResource(R.string.uik_save_image_fail_get), 0).show();
            } else if (intValue != 2) {
            } else {
                Toast.makeText(ImageSaveFeature.this.mContext.getApplicationContext(), ImageSaveFeature.this.getStringResource(R.string.uik_save_image_fail_full), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSavePlan() {
        return Build.VERSION.SDK_INT < 19 || this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
        this.mDialog = null;
    }

    private Bitmap getBitmap(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (!(drawable == null && (drawable = imageView.getBackground()) == null) && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStringResource(int i) {
        return this.mContext.getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNewMedia(Uri uri) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        this.mContext.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageView(ImageView imageView) {
        Bitmap bitmap = getBitmap(imageView);
        this.mSaveBmp = bitmap;
        if (bitmap == null) {
            Toast.makeText(this.mContext.getApplicationContext(), getStringResource(R.string.uik_save_image_fail_get), 0).show();
        } else if (checkSavePlan()) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
                Toast.makeText(this.mContext.getApplicationContext(), getStringResource(R.string.uik_save_image_fail), 0).show();
                return;
            }
            saveImageFile(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/" + imageView.toString().hashCode() + ".png")), this.mSaveBmp);
        } else {
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.TITLE", imageView.toString().hashCode() + ".png");
            Context context = this.mContext;
            while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context != null && (context instanceof Activity)) {
                FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                TBackFragment tBackFragment = (TBackFragment) fragmentManager.findFragmentByTag("TBackFragment");
                if (tBackFragment == null) {
                    tBackFragment = new TBackFragment();
                    fragmentManager.beginTransaction().add(tBackFragment, "TBackFragment").commit();
                    fragmentManager.executePendingTransactions();
                }
                tBackFragment.setImageSaveFeature(this);
                tBackFragment.startActivityForResult(intent, 1502);
                return;
            }
            Toast.makeText(this.mContext.getApplicationContext(), getStringResource(R.string.uik_save_image_fail), 0).show();
        }
    }

    @SuppressLint({"InflateParams"})
    private void showDialog() {
        if (this.mChoices.size() <= 0) {
            return;
        }
        this.mDialog = new Dialog(this.mContext, R.style.uik_imagesavedialog);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.uik_image_save_dialog, (ViewGroup) null);
        Iterator<String> it = this.mChoices.keySet().iterator();
        while (it.hasNext()) {
            TextView textView = (TextView) layoutInflater.inflate(R.layout.uik_image_save_choice, (ViewGroup) linearLayout, false);
            String next = it.next();
            textView.setText(next);
            final ImageSaveFeatureCallback imageSaveFeatureCallback = this.mChoices.get(next);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.taobao.uikit.feature.features.ImageSaveFeature.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    imageSaveFeatureCallback.doMethod(ImageSaveFeature.this.getHost());
                    ImageSaveFeature.this.dismissDialog();
                }
            });
            linearLayout.addView(textView);
            if (it.hasNext()) {
                linearLayout.addView(layoutInflater.inflate(R.layout.uik_choice_divider, (ViewGroup) linearLayout, false));
            }
        }
        this.mDialog.setContentView(linearLayout);
        this.mDialog.show();
    }

    public void addDialogChoice(String str, ImageSaveFeatureCallback imageSaveFeatureCallback) {
        this.mChoices.put(str, imageSaveFeatureCallback);
    }

    @Override // com.taobao.uikit.feature.callback.TouchEventCallback
    public void afterDispatchTouchEvent(MotionEvent motionEvent) {
    }

    @Override // com.taobao.uikit.feature.callback.TouchEventCallback
    public void afterOnTouchEvent(MotionEvent motionEvent) {
    }

    @Override // com.taobao.uikit.feature.callback.ImageSaveCallback
    public void afterPerformLongClick() {
    }

    @Override // com.taobao.uikit.feature.callback.TouchEventCallback
    public void beforeDispatchTouchEvent(MotionEvent motionEvent) {
    }

    @Override // com.taobao.uikit.feature.callback.TouchEventCallback
    public void beforeOnTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mStartPoint.set(motionEvent.getX(), motionEvent.getY());
            this.mActive = true;
        } else if (action != 2) {
            if (action != 5) {
                return;
            }
            this.mActive = false;
            dismissDialog();
        } else {
            float x = motionEvent.getX() - this.mStartPoint.x;
            float y = motionEvent.getY() - this.mStartPoint.y;
            if (Math.abs(x) > 10.0f || Math.abs(y) > 10.0f) {
                this.mActive = false;
                dismissDialog();
            }
        }
    }

    @Override // com.taobao.uikit.feature.callback.ImageSaveCallback
    public void beforePerformLongClick() {
        if (this.mActive) {
            showDialog();
        }
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void constructor(Context context, AttributeSet attributeSet, int i) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1502 && i2 == -1) {
            saveImageFile(intent.getData(), this.mSaveBmp);
        }
    }

    public void saveImageFile(Uri uri, Bitmap bitmap) {
        SaveFileTask saveFileTask = this.mSaveFileTask;
        if (saveFileTask == null || AsyncTask.Status.RUNNING != saveFileTask.getStatus()) {
            SaveFileTask saveFileTask2 = new SaveFileTask();
            this.mSaveFileTask = saveFileTask2;
            saveFileTask2.execute(uri, bitmap);
        }
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void setHost(ImageView imageView) {
        super.setHost((ImageSaveFeature) imageView);
        Context context = imageView.getContext();
        this.mContext = context;
        if (context != null) {
            this.mChoices.put(context.getResources().getString(R.string.uik_save_image), new ImageSaveFeatureCallback() { // from class: com.taobao.uikit.feature.features.ImageSaveFeature.1
                @Override // com.taobao.uikit.feature.features.ImageSaveFeature.ImageSaveFeatureCallback
                public void doMethod(ImageView imageView2) {
                    ImageSaveFeature.this.saveImageView(imageView2);
                }
            });
        }
    }
}
