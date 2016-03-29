package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var03MainActivity extends Activity {
	
	  private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	  
	  private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	  private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      EditText riddle = (EditText)PracticalTest01Var03MainActivity.this.findViewById(R.id.riddle);
	      EditText goodAnswer = (EditText)PracticalTest01Var03MainActivity.this.findViewById(R.id.goodanswer);
	      switch(view.getId()) {
	        case R.id.play:
	        	
	        		if("".equals(goodAnswer.getText().toString()) || "".equals(riddle.getText().toString())) {
	        			return;
	        			
	        		}
	        		Intent intent = new Intent("ro.pub.cs.systems.eim.intent.action.PracticalTest01Var02PlayActivity");
	        		intent.putExtra("riddleAnswer",
	        				String.valueOf(goodAnswer.getText().toString()
	        						));
	        		intent.putExtra("riddle",
	        				String.valueOf(riddle.getText().toString()
	  	            ));
	        		startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	        	
	          break;
	        // ...
	      }
	    }
	 }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        
        EditText riddle = (EditText)findViewById(R.id.riddle);
        EditText goodAnswer = (EditText)findViewById(R.id.goodanswer);
        
	    Button play = (Button)findViewById(R.id.play);
	    play.setOnClickListener(buttonClickListener);
	    
	    if(savedInstanceState == null) {
	    	riddle.setText("Riddle");
	        goodAnswer.setText("Answer");
	    }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	super.onSaveInstanceState(savedInstanceState);
    	EditText riddle = (EditText)findViewById(R.id.riddle);
        EditText goodAnswer = (EditText)findViewById(R.id.goodanswer);
        
    	savedInstanceState.putString("riddleBackUp",riddle.getText().toString());
    	savedInstanceState.putString("goodAnswerBackUp",goodAnswer.getText().toString());
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	
    	super.onSaveInstanceState(savedInstanceState);
    	EditText riddle = (EditText)findViewById(R.id.riddle);
        EditText goodAnswer = (EditText)findViewById(R.id.goodanswer);
    	
    	if(savedInstanceState.containsKey("riddleBackUp")){
    		riddle.setText(savedInstanceState.getString("riddleBackUp"));
    	} else {
    		riddle.setText("Riddle");
    	}
    	
    	if(savedInstanceState.containsKey("goodAnswerBackUp")){
    		riddle.setText(savedInstanceState.getString("goodAnswerBackUp"));
    	} else {
	        goodAnswer.setText("Answer");
    	}
    }

}
