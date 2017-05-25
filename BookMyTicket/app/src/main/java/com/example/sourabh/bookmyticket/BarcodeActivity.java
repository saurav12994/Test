package com.example.sourabh.bookmyticket;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;

public class BarcodeActivity extends AppCompatActivity {
    ImageView imageView;

    TextView editText;
    String EditTextValue ;
    Thread thread ;
    Toolbar toolbar;
    ProgressDialog pr1;
    public final static int QRcodeWidth = 1000 ;
    Bitmap bitmap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        imageView = (ImageView)findViewById(R.id.imageView);
        editText = (TextView) findViewById(R.id.editText);

        toolbar=(Toolbar)findViewById(R.id.toolbar16);
        toolbar.setTitle("                       Tickets ");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        pr1 = new ProgressDialog(this);
        final ArrayList<String> ar4=getIntent().getExtras().getStringArrayList("list");
        editText.append(ar4.get(0));
        int retval = ar4.size();
        final String arrys = Integer.toString(retval);
        for (int i=1;i<retval;i++)
        {
            editText.append(","+ar4.get(i));
        }

Toast.makeText(BarcodeActivity.this,arrys,Toast.LENGTH_LONG).show();
                EditTextValue = editText.getText().toString();

                try {pr1.setMessage("Generating");
                    pr1.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            pr1.dismiss();
                        }
                    }, 10000);
                    bitmap = TextToImageEncode(EditTextValue);

                    imageView.setImageBitmap(bitmap);


                } catch (WriterException e) {
                    e.printStackTrace();
                }


    }


    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.QRCodeBlackColor):getResources().getColor(R.color.QRCodeWhiteColor);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 1000, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
