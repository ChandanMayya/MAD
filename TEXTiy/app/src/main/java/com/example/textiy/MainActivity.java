package com.example.textiy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity<text, myClip> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Gets a handle to the clipboard service.
    ClipboardManager clipboard1 = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData myClipp;
    String text = "hello world";
    myClip = ClipData.newPlainText("text",text);
    Clipboard1.setPrimaryClip(myClip);

}
  