package me.micka.calorie_watch;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Search_Food extends Activity implements OnClickListener{

	ListView listContent;
	EditText Search;
	
	private SQLiteAdapter mySQLiteAdapter;
	
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_search);
      
      listContent = (ListView)findViewById(R.id.lFoodlist);
      Search = (EditText)findViewById(R.id.eFsearch);      
    
          
       
      /*
       *  Create/Open a SQLite database
       *  and fill with dummy content
       *  and close it*/
       
      SQLiteAdapter mySQLiteAdapter = new SQLiteAdapter(this);
      mySQLiteAdapter.openToWrite();
      mySQLiteAdapter.deleteAll();

      mySQLiteAdapter.insert("Brownies ", "243");
      mySQLiteAdapter.insert("Cupcake ", "177");
      mySQLiteAdapter.insert("Hot Cake", "145");
      mySQLiteAdapter.insert("Waffle", "121");
      mySQLiteAdapter.insert("Ice Cream Cone", "173");
      mySQLiteAdapter.insert("Hotdog", "183");
      mySQLiteAdapter.insert("Longganisa", "170");
      mySQLiteAdapter.insert("Scrambled Egg", "100");
      mySQLiteAdapter.insert("Tapsilog", "364");
      mySQLiteAdapter.insert("Adobong Baboy (1 bowl)", "339");
      mySQLiteAdapter.insert("Chicken Afritada (1 bowl)", "323");
      mySQLiteAdapter.insert("Paksiw na Pata (1 bowl)", "342");
      mySQLiteAdapter.insert("Pinakbet (1 bowl)", "110");
      mySQLiteAdapter.insert("Sisig (1 bowl)", "293");
      mySQLiteAdapter.insert("Palabok (1 serving)", "305");
      mySQLiteAdapter.insert("Fruit Salad", "218");
      mySQLiteAdapter.insert("Halo-Halo (1 cup)", "80");
      mySQLiteAdapter.insert("A4pple", "80");
      mySQLiteAdapter.insert("Banana", "105");
      mySQLiteAdapter.insert("Mango", "107");
      mySQLiteAdapter.insert("Orange", "62");
      mySQLiteAdapter.insert("Strawberry", "8");
      mySQLiteAdapter.insert("Bacon", "175");
      mySQLiteAdapter.insert("Tilapia", "150");
      mySQLiteAdapter.insert("Cashews (28g)", "156");
      mySQLiteAdapter.insert("Ampalaya", "16");
      mySQLiteAdapter.insert("Carrot", "25");
      mySQLiteAdapter.insert("Okra", "18");
      mySQLiteAdapter.insert("Corn", "132");
      mySQLiteAdapter.insert("Mushroom", "15");
      mySQLiteAdapter.insert("Sweet Potato", "103");
      
    
      mySQLiteAdapter.close();

      /*
       *  Open the same SQLite database
       *  and read all it's content.
       */
      mySQLiteAdapter = new SQLiteAdapter(this);
      mySQLiteAdapter.openToRead();

      Cursor cursor = mySQLiteAdapter.queueAll();
      
      startManagingCursor(cursor);
       
      String[] from = new String[]{SQLiteAdapter.KEY_FOODNAME,SQLiteAdapter.KEY_CALORIES};
      int[] to = new int[]{R.id.tv1, R.id.tv2};
      
      SimpleCursorAdapter cursorAdapter =
      new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);

      listContent.setAdapter(cursorAdapter);
      mySQLiteAdapter.close();
      
     
      
  }

public void onClick(View arg0) {
	// TODO Auto-generated method stub
	
    
 
}

public SQLiteAdapter getMySQLiteAdapter() {
	return mySQLiteAdapter;
}

public void setMySQLiteAdapter(SQLiteAdapter mySQLiteAdapter) {
	this.mySQLiteAdapter = mySQLiteAdapter;
}

	
}
