package me.micka.calorie_watch;


import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class Welcome extends Activity {

	Button register;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
       
        register = (Button) findViewById(R.id.bReg);
        register.setOnClickListener(new View.OnClickListener() {
			
        	
			public void onClick(View v) {
				// TODO Auto-generated method stub

			    
				Intent intent = new Intent(Welcome.this, Register.class);
                            startActivity(intent);   
                           
 
			}
		});
    }


   
    }
    

