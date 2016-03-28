package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var02MainActivity extends Activity {

		private EditText editText1 = null;
		private EditText editText2 = null;
		private EditText editText3 = null;
		private EditText editText4 = null;
		private Button set = null;
		private ButtonListener listener = new ButtonListener();
		private int serviceStatus = Constants.SERVICE_STOPPED;
		class ButtonListener implements View.OnClickListener {

			@Override
			public void onClick(View v) {
				
				switch (v.getId()) {
				
				case R.id.button1:
					
					Intent intent = new Intent(getApplicationContext(), PracticalTestVar02SecondaryActivity.class);
					String val1 = editText1.getText().toString();
					String val2 = editText2.getText().toString();
					String val3 = editText3.getText().toString();
					String val4 = editText4.getText().toString();
					intent.putExtra("val1", val1);
					intent.putExtra("val2", val2);
					intent.putExtra("val3", val3);
					intent.putExtra("val4", val4);
					startActivityForResult(intent, 2016);
					break;
				
				}
				
				
			}
			
		}
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_main);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		set = (Button)findViewById(R.id.button1);
		set.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_main, menu);
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
	    savedInstanceState.putString("editText1", editText1.getText().toString());
	    savedInstanceState.putString("editText2", editText2.getText().toString());
	    savedInstanceState.putString("editText3", editText3.getText().toString());
	    savedInstanceState.putString("editText4", editText4.getText().toString());
	  }
	 
	  @Override
	  protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    super.onRestoreInstanceState(savedInstanceState);
	    if (savedInstanceState.containsKey("editText1")) {
			editText1.setText(savedInstanceState.getString("editText1"));
		} else {
			editText1.setText(String.valueOf(0));
		}
	    if (savedInstanceState.containsKey("editText2")) {
			editText2.setText(savedInstanceState.getString("editText2"));
		} else {
			editText2.setText(String.valueOf(0));
		}
	    if (savedInstanceState.containsKey("editText3")) {
			editText3.setText(savedInstanceState.getString("editText3"));
		} else {
			editText3.setText(String.valueOf(0));
		}
	    if (savedInstanceState.containsKey("editText4")) {
			editText4.setText(savedInstanceState.getString("editText4"));
		} else {
			editText4.setText(String.valueOf(0));
		}
	  }
		@Override
		protected void onDestroy() {
			Intent intent = new Intent(this, MyService.class);
			stopService(intent);
			super.onDestroy();
		}
}
