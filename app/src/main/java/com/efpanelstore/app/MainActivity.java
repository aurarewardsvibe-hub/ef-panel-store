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
    String lang = "en";

    public void onCreate(Bundle b){ super.onCreate(b); showLogin(); }

    TextView title(String t){ TextView v=new TextView(this); v.setText(t); v.setTextSize(26); v.setTextColor(cyan); v.setGravity(17); v.setPadding(0,30,0,20); return v; }
    Button btn(String t){ Button b=new Button(this); b.setText(t); b.setTextSize(16); b.setTextColor(Color.WHITE); b.setBackgroundColor(cyan); return b; }
    TextView txt(String t){ TextView v=new TextView(this); v.setText(t); v.setTextSize(17); v.setPadding(20,15,20,15); return v; }
    EditText input(String h){ EditText e=new EditText(this); e.setHint(h); e.setPadding(20,10,20,10); return e; }
    void base(){ root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(25,25,25,25); root.setBackgroundColor(Color.rgb(245,255,255)); setContentView(root); }

    public void showLogin(){
        base(); root.addView(title("EF PANEL STORE"));
        EditText m=input("Mobile Number"), p=input("Password");
        root.addView(m); root.addView(p);
        Button login=btn("Login"); root.addView(login);
        Button reg=btn("Create Account"); root.addView(reg);
        login.setOnClickListener(v -> showLang());
        reg.setOnClickListener(v -> Toast.makeText(this,"Account created ✅",0).show());
    }

    public void showLang(){
        base(); root.addView(title("Select Language 🌐"));
        Button en=btn("English"), hi=btn("Hindi"), bn=btn("Bengali");
        root.addView(en); root.addView(hi); root.addView(bn);
        en.setOnClickListener(v->{lang="en";showHome();});
        hi.setOnClickListener(v->{lang="hi";showHome();});
        bn.setOnClickListener(v->{lang="bn";showHome();});
    }

    public void nav(){
        LinearLayout n=new LinearLayout(this); n.setGravity(17);
        String[] a={"🏠 Home","💰 Wallet","💙 Root","☎️ Support"};
        for(String s:a){ Button b=btn(s); n.addView(b); if(s.contains("Home"))b.setOnClickListener(v->showHome()); if(s.contains("Wallet"))b.setOnClickListener(v->showWallet()); if(s.contains("Root"))b.setOnClickListener(v->showRoot()); if(s.contains("Support"))b.setOnClickListener(v->showSupport());}
        root.addView(n);
    }

    public void showHome(){
        base(); root.addView(title("EF PAID PANEL"));
        root.addView(txt("Price: ₹299"));
        Button buy=btn("Buy Now"); root.addView(buy);
        Button dl=btn("Download 🔒"); root.addView(dl);
        buy.setOnClickListener(v->{ if(balance>=299){ balance-=299; dl.setText("Download ✅"); Toast.makeText(this,"Purchased ✅",0).show(); } else showWallet(); });
        nav();
    }

    public void showWallet(){
        base(); root.addView(title("Wallet"));
        root.addView(txt("Current Balance: ₹"+balance));
        root.addView(input("UTR Number"));
        root.addView(btn("Screenshot Upload"));
        root.addView(btn("Submit Payment Request"));
        nav();
    }

    public void showRoot(){
        base(); root.addView(title("Root Service"));
        String[] d={"Redmi ₹199","OnePlus ₹299","Motorola ₹249","Vivo ₹299","Nothing ₹349","Samsung ₹299","Realme ₹299","Oppo ₹399","Infinix ₹299","Tecno ₹249"};
        for(String x:d){ Button b=btn(x+" Buy"); root.addView(b); b.setOnClickListener(v->Toast.makeText(this,"Service request created ✅",0).show()); }
        nav();
    }

    public void showSupport(){
        base(); root.addView(title("Support"));
        root.addView(btn("Telegram"));
        root.addView(btn("Instagram"));
        root.addView(btn("WhatsApp"));
        nav();
    }
}
