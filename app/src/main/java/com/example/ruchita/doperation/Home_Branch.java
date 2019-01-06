package com.example.ruchita.doperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home_Branch extends AppCompatActivity {

    private TextView branch_textview,date_textview,content_textview,content_textviewdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__branch);
        content_textview=(TextView)findViewById(R.id.content_textview);
        branch_textview=(TextView)findViewById(R.id.branch_textview);
        date_textview=(TextView)findViewById(R.id.date_textview);
       // content_textviewdata=(TextView)findViewById(R.id.content_textview2);

        Intent user_intent=getIntent();
        UserInformation user_info=(UserInformation)user_intent.getSerializableExtra("UserInformation");

        String brachtextview="";
            brachtextview=user_info.getSender_branch();
            branch_textview.setText(brachtextview);


            String dateview="";
            dateview="5-01-2019";
            date_textview.setText(dateview);


      String  content_text=
                         "Name       :"+user_info.getReceiver_name()+"\n"
                        +"Mobile     :"+user_info.getReceiver_phone()+"\n"
                        +"Commission:"+user_info.getcommision_amount()+"\n"
                        +"Amount     :"+user_info.getAmount()+"\n"
                        +"Note NO    :"+user_info.getNote_no()+"\n"
                        +"City       :"+user_info.getReceiver_city()+"\n"
                        +"SenderName :"+user_info.getSender_name()+"\n"
                        +"Mobile No  :"+user_info.getSender_phone();


        content_textview.setText(content_text);














    }



}
