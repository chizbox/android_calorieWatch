package me.micka.calorie_watch;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;




public class Menu extends Activity {

	Button exit, settings, progress, reports, search, log;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       
       		
    		   
        settings = (Button) findViewById(R.id.bSettings);
        progress=(Button) findViewById(R.id.bProgress);
        reports=(Button) findViewById(R.id.bReport);
        search=(Button) findViewById(R.id.bSearch);
        log=(Button) findViewById(R.id.bDailylog);
       
        
        
        search.setOnClickListener(new View.OnClickListener() {
			
        	

     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     			    
     				Intent intent = new Intent(Menu.this, Search_Food.class);
                                 startActivity(intent);   
                                
     			}
     		});
 
    }
}
    

