package com.efpanelstore.app;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    LinearLayout root;
    int cyan = Color.rgb(0,188,212);
    int balance = 300;
    boolean panelBought = false;

    public void onCreate(Bundle b){ super.onCreate(b); showLogin(); }

    void base(){
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(30,30,30,30);
        root.setBackgroundColor(Color.rgb(245,255,255));
        setContentView(root);
    }

    TextView title(String s){
        TextView v = new TextView(this);
        v.setText(s); v.setTextSize(25); v.setTextColor(cyan);
        v.setGravity(17); v.setPadding(0,20,0,20);
        return v;
    }

    Button btn(String s){
        Button b = new Button(this);
        b.setText(s); b.setTextSize(15); b.setTextColor(Color.WHITE);
        b.setBackgroundColor(cyan);
        return b;
    }

    EditText input(String s){
        EditText e = new EditText(this);
        e.setHint(s);
        return e;
    }

    TextView text(String s){
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(17); t.setPadding(10,15,10,15);
        return t;
    }

    void nav(){
        LinearLayout n = new LinearLayout(this);
        n.setGravity(17);
        String[] items = {"🏠 Home","💰 Wallet","💙 Root","☎️ Support"};
        for(String x: items){
            Button b = btn(x);
            n.addView(b);
            if(x.contains("Home")) b.setOnClickListener(v -> showHome());
            if(x.contains("Wallet")) b.setOnClickListener(v -> showWallet());
            if(x.contains("Root")) b.setOnClickListener(v -> showRoot());
            if(x.contains("Support")) b.setOnClickListener(v -> showSupport());
        }
        root.addView(n);
    }

    public void showLogin(){
        base();
        root.addView(title("EF PANEL STORE"));
        EditText m = input("Mobile Number");
        EditText p = input("Password");
        root.addView(m); root.addView(p);
        Button login = btn("Login");
        root.addView(login);
        login.setOnClickListener(v -> showLanguage());
    }

    public void showLanguage(){
        base();
        root.addView(title("Select Language 🌐"));
        Button en = btn("English");
        Button hi = btn("Hindi");
        Button bn = btn("Bengali");
        root.addView(en); root.addView(hi); root.addView(bn);
        en.setOnClickListener(v -> showHome());
        hi.setOnClickListener(v -> showHome());
        bn.setOnClickListener(v -> showHome());
    }

    public void showHome(){
        base();
        root.addView(title("EF PAID PANEL"));
        root.addView(text("Price: ₹299"));
        Button buy = btn("Buy Now");
        Button download = btn(panelBought ? "Download ✅" : "Download 🔒");
        root.addView(buy);
        root.addView(download);
        buy.setOnClickListener(v -> {
            if(balance >= 299){
                balance -= 299;
                panelBought = true;
                Toast.makeText(this,"Purchase successful ✅",0).show();
                showHome();
            } else {
                showWallet();
            }
        });
        nav();
    }

    public void showWallet(){
        base();
        root.addView(title("Wallet"));
        root.addView(text("Balance: ₹" + balance));
        root.addView(text("QR + UPI payment option"));
        root.addView(input("UTR Number"));
        root.addView(btn("Screenshot Upload"));
        root.addView(btn("Submit Payment Request"));
        nav();
    }

    public void showRoot(){
        base();
        root.addView(title("Root Service"));
        String[] list = {"Redmi ₹199","OnePlus ₹299","Motorola ₹249","Vivo ₹299","Nothing ₹349","Samsung ₹299","Realme ₹299","Oppo ₹399","Infinix ₹299","Tecno ₹249"};
        for(String item:list){
            Button b = btn(item + " Buy");
            root.addView(b);
            b.setOnClickListener(v -> Toast.makeText(this,"Service request created ✅",0).show());
        }
        nav();
    }

    public void showSupport(){
        base();
        root.addView(title("Support"));
        root.addView(btn("Telegram"));
        root.addView(btn("Instagram"));
        root.addView(btn("WhatsApp"));
        nav();
    }
}
