package com.example.android_count;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intentcamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentcamera);
                b1.setText("Camera");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intentvideo = new Intent(Intent.ACTION_VIEW);
                intentvideo.setData(Uri.parse("https://www.youtube.com/watch?v=zrU34eIWRGw&ab_channel=DarkSniper"));
                startActivity(intentvideo);
                b2.setText("BFG 10K");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intentimg = new Intent(Intent.ACTION_VIEW);
                intentimg.setData(Uri.parse("https://image.api.playstation.com/vulcan/ap/rnd/202010/0114/ERNPc4gFqeRDG1tYQIfOKQtM.png"));
                startActivity(intentimg);
                b3.setText("Image in Searcher");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intentdoc = new Intent(Intent.ACTION_VIEW);
                intentdoc.setData(Uri.parse("https://developer.android.com/guide/topics/media/camera"));
                startActivity(intentdoc);
                b4.setText("Read Documentation");
            }
        });

        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        b5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent Imagenes = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Imagenes.setAction(Intent.ACTION_VIEW);
                startActivity(Imagenes);
                b5.setText("Galery");
            }
        });
        Intent ima = new Intent(this , Image.class);
        b6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                startActivity(ima);
                b6.setText("Watch Something");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent llamada  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 9842393470"));
                startActivity(llamada);
                b7.setText("Call");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                makePhoneCall();
                b8.setText("Make a Call");
            }
        });

    }
    private void makePhoneCall(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //Toast.makeText(this, "No Permitido", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
        else
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: 9842393470")));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this, "Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}