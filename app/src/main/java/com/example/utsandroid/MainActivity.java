package com.example.utsandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public abstract class MainActivity extends AppCompatActivity implements OnClickListener{

    private ImageView imageHolder;
    private final int requestCode=1;
    private static final int AMBIL_FOTO_BESAR = 1;
    private static final int AMBIL_FOTO_KECIL = 2;
    private static final int AMBIL_VIDEO = 3;
    private static final int TAMPILKAN_GALLERY = 4;

    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageHolder = (ImageView) findViewById(R.id.gallery_photo);
        Button PhotoGalleryButton = (Button) findViewById(R.id.button_capture);
        PhotoGalleryButton.setOnClickListener(v -> {
            Intent photoCaptureIntent = new
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(photoCaptureIntent,requestCode);
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }


}