package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends Activity {
	
		String answerStr;

	  private ButtonClickListener buttonClickListener = new ButtonClickListener();
	  
	  private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	    	
			TextView riddle;
			EditText answerToCheck;
			Button check;
			Button answer;
	    
			riddle = (TextView)PracticalTest01Var02PlayActivity.this.findViewById(R.id.riddleFixed);
			answerToCheck= (EditText)PracticalTest01Var02PlayActivity.this.findViewById(R.id.answertocheck);
	 
	    	switch(view.getId()) {
	    		case R.id.check:
	    			int result = answerStr.compareTo(answerToCheck.getText().toString());
	    			if(result == 0) {
	    				Context context = getApplicationContext();
	    				CharSequence text = "The answer is corect!";
	    				int duration = Toast.LENGTH_SHORT;

	    				Toast toast = Toast.makeText(context, text, duration);
	    				toast.show();
	    			} else {
	    				Context context = getApplicationContext();
	    				CharSequence text = "The answer is false!";
	    				int duration = Toast.LENGTH_SHORT;

	    				Toast toast = Toast.makeText(context, text, duration);
	    				toast.show();
	    			}
	    		break;
	    	case R.id.back:
	    			finish();
	    		break;
	      }
	    }

	  } 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_play);
		TextView riddle = (TextView)PracticalTest01Var02PlayActivity.this.findViewById(R.id.riddleFixed);;
		EditText answerToCheck = (EditText)PracticalTest01Var02PlayActivity.this.findViewById(R.id.answertocheck);
		String riddleMain ="";
		
	    Intent intent = getIntent();
	    if (intent != null) {
	    	answerStr = intent.getStringExtra("riddleAnswer");
	      riddleMain = intent.getStringExtra("riddle");
	    }
	    
	    riddle.setText(riddleMain);
		
	    Button check = (Button)findViewById(R.id.check);
	    check.setOnClickListener(buttonClickListener);
	    Button back = (Button)findViewById(R.id.back);
	    back.setOnClickListener(buttonClickListener);  
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_play, menu);
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
}
