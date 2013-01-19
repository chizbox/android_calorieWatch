package me.micka.calorie_watch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Activity {
	
	String response;
	EditText tx, Eweight, Eheight, Eage;
	TextView counter;
	Spinner spin;
	String gender;
	
	
   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        //---the button is wired to an event handler---
        Button btn1 = (Button)findViewById(R.id.bSubmit);
        btn1.setOnClickListener(btnListener);
        counter = (TextView) findViewById(R.id.textView6);
        
        //Creating a spinner and adding two items to it.
        spin = (Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new SpinnerListener());
    }
    
    //---create an anonymous class to act as a button click listener---
    public OnClickListener btnListener = new OnClickListener()
    {
     
    	
     
		public void onClick(View v)
		
	      
        {
        	EditText etName = (EditText) findViewById(R.id.etName);
        	EditText etAge = (EditText) findViewById(R.id.etAge);
        	EditText etHeight = (EditText) findViewById(R.id.etHeight);
        	EditText etWeight = (EditText) findViewById(R.id.etWeight);
        	
			String Name = etName.getText().toString();
			String Age = etName.getText().toString();
			String Weight = etName.getText().toString();
			String Height = etName.getText().toString();
			
			
			
			
        	 if(etName.getText().toString().trim().length()  > 0 && 
        	   (etAge.getText().toString().trim().length()  > 0 && 
               (etHeight.getText().toString().trim().length()  > 0 && 
               (etWeight.getText().toString().trim().length()  > 0)))){
    			 
        	 Toast.makeText(getApplicationContext(), "SUCCESS!",
						Toast.LENGTH_SHORT).show();
        	 
        	  
         	Intent intent = new Intent(Register.this, Menu.class);
             startActivity(intent);  }
             
        	 else 
       			 Toast.makeText(getApplicationContext(), "Incomplete Input",
    						Toast.LENGTH_SHORT).show();
    		 
         
            
        	int weight = 0, height = 0, age = 0, answer = 0;
        	String test1, test2, test3;
        	test1 = getString(R.id.tvWeight);
        	test2 = getString(R.id.tvAge);
        	test3 = getString(R.id.tvHeight);
        	
        	try {
				if (test1 != "" && test2 != "" && test3 != "") {
					Eweight = (EditText) findViewById(R.id.tvWeight);
					weight = Integer.parseInt(Eweight.getText().toString().trim());
					Eage = (EditText) findViewById(R.id.tvAge);
					age = Integer.parseInt(Eage.getText().toString().trim());
					Eheight = (EditText) findViewById(R.id.tvHeight);
					height = Integer.parseInt(Eheight.getText().toString().trim());
					
					if(gender.contains("Male"))
						answer = (int) Math.round(1.2 * (66 + (13.7 * weight) + (5 * height) - (6.8 * age)));
					
					if(gender.contains("Female"))
						answer = (int) Math.round(1.2*(655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)));
					
					response = answer + " kcal/day";
					counter.setText(response);
		
				}
			} catch (Exception e) {
				System.out.println(e);
			}

        }
        
       
        
        	
    };
    
    
    //spinner listener for values male and female
    public class SpinnerListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            gender = parent.getItemAtPosition(pos).toString();
        }



		public void onItemSelected1(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}


    }
    
}