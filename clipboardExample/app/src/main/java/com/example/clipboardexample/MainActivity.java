package com.example.clipboardexample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText ctxt;
    private EditText ptxt;
    private Button btncpy;
    private Button btnpst;
    private Button btnCLr;
    private ClipboardManager clipboardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctxt =(EditText)findViewById(R.id.txtCopy);
        ptxt = (EditText)findViewById(R.id.txtShow);
        btncpy = (Button)findViewById(R.id.btnCopy);
        btnpst = (Button)findViewById(R.id.btnShow);
        btnCLr= (Button)findViewById(R.id.btnClr);
        clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        btncpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtcopy = ctxt.getText().toString();
                clipData = ClipData.newPlainText("text",txtcopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Data Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        btnpst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData pData = clipboardManager.getPrimaryClip();
                ClipData.Item item = pData.getItemAt(0);
                String txtpaste = item.getText().toString();
                ptxt.setText(txtpaste);
                Toast.makeText(getApplicationContext(),"Data Pasted from Clipboard",Toast.LENGTH_SHORT).show();
            }
        });
        btnCLr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctxt.setText("");
                ptxt.setText("");
            }
        });
    }

}