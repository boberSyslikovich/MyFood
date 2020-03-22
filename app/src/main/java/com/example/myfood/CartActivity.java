package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {


    String[] addresses = {"stolova.ppk@gmail.com"};
    String subject = "Замовлення для Їдальні";
    String orderString = "";
    private TextView orderText;
    private ImageView imageQR;
    final String nullQuantity = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        orderText = findViewById(R.id.orderText);
        imageQR  = findViewById(R.id.imageQR);

        Intent intent = getIntent();

        ArrayList<String> nameList = (ArrayList<String>) intent.getSerializableExtra("name");
        ArrayList<String> quantityList = (ArrayList<String>) intent.getSerializableExtra("quantity");


        for (int i = 0; i<nameList.size();i++){
            if (quantityList.get(i).equals(nullQuantity)){
                continue;
            }
            String list = nameList.get(i);
            String list1 = quantityList.get(i);

            orderString = orderString  + list + "  " + list1 + "\n"  ;

        }

        orderText.setText(orderString);

        if(orderString!=null){
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try{
                BitMatrix bitMatrix = multiFormatWriter.encode(orderString, BarcodeFormat.QR_CODE, 1000, 1000);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageQR.setImageBitmap(bitmap);
            }catch (WriterException e){
                e.printStackTrace();
            }
        }


    }

    public void sendOrderClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderString);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
