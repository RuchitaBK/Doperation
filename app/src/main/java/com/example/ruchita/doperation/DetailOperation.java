package com.example.ruchita.doperation;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DetailOperation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private static final String TAG = "Send Details ";
    Toolbar toolbar;

    ArrayList<UserInformation>user;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    EditText sender_name,sender_mobile,sender_token,sender_code, sender_branch,receiver_name,
            receiver_mobile,receiver_city,commision_amount, receiver_amount,note_no;

    private AppCompatButton save_Button;
    RelativeLayout relativeLayout;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative_layout_id);
        relativeLayout.setOnClickListener(null);



        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
              initializeWidget();
        save_Button=(AppCompatButton) findViewById(R.id.btn_save);
        save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_details();
            }
        });

        getSupportActionBar().setTitle("RC Enterprise");
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_Drawer,R.string.close_Drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

public  void initializeWidget()
{
    sender_name=(EditText)findViewById(R.id.input_name_sender);
    receiver_name=(EditText)findViewById(R.id.input_name_receiver);
    //===============================================
    sender_mobile=(EditText)findViewById(R.id.input_mobile_sender);
    receiver_mobile=(EditText)findViewById(R.id.input_mobile_receiver);
    //================================================
    commision_amount=(EditText)findViewById(R.id.input_commission);
    receiver_amount=(EditText)findViewById(R.id.input_amount);
    //==========================================
    receiver_city=(EditText)findViewById(R.id.input_city);
    sender_token=(EditText)findViewById(R.id.input_token);
    sender_code=(EditText)findViewById(R.id.input_sender_code);
    sender_branch=(EditText)findViewById(R.id.input_sender_branch);
    note_no=(EditText)findViewById(R.id.input_note);

    //======================================================


}

public void check_details()
{

    Log.d(TAG, "Save");

    if (!validate()) {
        onSignupFailed();
        return;
    }
    else
    {
       // user=new ArrayList<UserInformation>();
        String receiver_name_ip =receiver_name.getText().toString();
        int receiver_commision_ip=Integer.parseInt(commision_amount.getText().toString());
        int receiver_amount_ip=Integer.parseInt(receiver_amount.getText().toString());
        String receiver_note_ip=note_no.getText().toString();
        String receiver_city_ip=receiver_city.getText().toString();
        String receive_mobile_ip=receiver_mobile.getText().toString();
        //------------------------------------------------------

        String sender_name_ip =sender_name.getText().toString();
        String sender_branch_ip=sender_branch.getText().toString();
        String sender_mobile_ip=sender_mobile.getText().toString();

        UserInformation obj=new UserInformation(receiver_name_ip,receive_mobile_ip,receiver_commision_ip,receiver_amount_ip,receiver_city_ip,receiver_note_ip,sender_branch_ip,sender_name_ip,sender_mobile_ip);

        Toast.makeText(getBaseContext(), "Data Saved successfully ", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(DetailOperation.this,Home_Branch.class);
        intent.putExtra("UserInformation",obj);
        startActivity(intent);

    }

}




    public boolean validate() {
        boolean valid = true;


        String receiver_name_ip =receiver_name.getText().toString();
        String receiver_commision_ip=commision_amount.getText().toString();
        String receiver_amount_ip=receiver_amount.getText().toString();
        String receiver_note_ip=note_no.getText().toString();
        String receiver_city_ip=receiver_city.getText().toString();
        String receive_mobile_ip=receiver_mobile.getText().toString();
        //------------------------------------------------------

        String sender_name_ip =sender_name.getText().toString();
        String sender_mobile_ip=sender_mobile.getText().toString();
        String sender_token_ip=sender_token.getText().toString();
        String sender_branch_ip=sender_branch.getText().toString();
        String sender_code_ip=sender_code.getText().toString();
        //====================================

// checking validation
        if (receiver_name_ip.isEmpty() || receiver_name_ip.length() < 3)
        {
            receiver_name.setError("at least 3 characters");
            valid = false;
        }
        else {
            receiver_name.setError(null);
        }

        if (sender_name_ip.isEmpty() || sender_name_ip.length() < 3)
        {
           sender_name.setError("at least 3 characters");
            valid = false;
        }
        else {
            sender_name.setError(null);
        }

        if (sender_mobile_ip.isEmpty() || sender_mobile_ip.length()!=10) {
            sender_mobile.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
           sender_mobile.setError(null);
        }

        if (receive_mobile_ip.isEmpty() || receive_mobile_ip.length()!=10) {
            receiver_mobile.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            receiver_mobile.setError(null);
        }
           if(receiver_city_ip.isEmpty())
           {
               receiver_city.setError("City cannot be Empty");
               valid = false;
           }
           else
           {
               receiver_city.setError(null);
           }


        //--------------comision ip and amount -----------------------
        if(receiver_commision_ip.isEmpty())
        {
            commision_amount.setError("Commision Cannot be 0 ");
            valid=false;
        }
        else
        {
            commision_amount.setError(null);
        }
        if(receiver_amount_ip.isEmpty())
        {
            receiver_amount.setError("Amount Cannot be empty");
            valid = false;
        }
        else
        {
            receiver_amount.setError(null);
        }
          if(receiver_note_ip.isEmpty())
          {
              note_no.setError("Enter Valid Note No ");
              valid = false;
          }
          else
          {
              note_no.setError(null);
          }
        //-------------------

        if (sender_branch_ip.isEmpty() || sender_branch_ip.length() < 3)
        {
            sender_branch.setError("at least 3 characters");
            valid = false;
        }
        else {
            sender_branch.setError(null);
        }

        if(sender_token_ip.isEmpty())
        {
            sender_token.setError("Token is empty");
            valid = false;
        }
        else
        {
            sender_token.setError(null);
        }

        if(sender_code_ip.isEmpty())
        {
            sender_code.setError("Branch Code is empty");
            valid = false;
        }
        else
        {
            sender_code.setError(null);
        }




        return valid;
    }



    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        save_Button.setEnabled(true);
    }






    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.about_us:
                Toast.makeText(this, "About us selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.setting_id:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.edit_id:
                Toast.makeText(this, "edit press selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            default:
                break;
        }

        return true;
    }

    @Override
    public boolean 	onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();

        switch (id)
        {
            case R.id.inbox:
                Toast.makeText(this, "inbox us selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.share:
                Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.started:
                Toast.makeText(this, "Star selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.send_Email:
                Toast.makeText(this, "Send Email Selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            default:
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }


}
