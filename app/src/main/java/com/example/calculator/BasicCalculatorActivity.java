package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Character.isDigit;


public class BasicCalculatorActivity extends Activity {
	private String current_value = "0";
	private TextView result_basic;
	private int max_length = 15;
	final private String error_message = "ERROR";


	private void resetResult() {
		current_value = "0";
		result_basic.setText(current_value);
	}


	private void setResult(String result) {
		current_value = result;
		result_basic.setText(current_value);
	}


	private void pushToResult(String result) {
		if (current_value.equals("0") || current_value.equals(error_message))
			current_value = "";
		if (current_value.length() >= max_length)
			return;
		current_value += result;
		result_basic.setText(current_value);
	}


	private char checkLastCharacterInResult() {
		return current_value.charAt(current_value.length() - 1);
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_calculator);

		result_basic = (TextView) findViewById(R.id.result_basic);
		resetResult();

		Button clear_button_basic = (Button) findViewById(R.id.clear_button_basic);
		clear_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (current_value.length() > 0) {
					setResult(current_value.substring(0, current_value.length() - 1));
					if (current_value.isEmpty())
						resetResult();
				}
				//TODO: handle double click
			}
		});


		Button all_clear_button_basic = (Button) findViewById(R.id.all_clear_button_basic);
		all_clear_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				resetResult();
			}
		});

		Button button0_basic = (Button) findViewById(R.id.button0_basic);
		button0_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("0");
			}
		});

		Button button1_basic = (Button) findViewById(R.id.button1_basic);
		button1_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("1");
			}
		});

		Button button2_basic = (Button) findViewById(R.id.button2_basic);
		button2_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("2");
			}
		});

		Button button3_basic = (Button) findViewById(R.id.button3_basic);
		button3_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("3");
			}
		});

		Button button4_basic = (Button) findViewById(R.id.button4_basic);
		button4_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("4");
			}
		});

		Button button5_basic = (Button) findViewById(R.id.button5_basic);
		button5_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("5");
			}
		});

		Button button6_basic = (Button) findViewById(R.id.button6_basic);
		button6_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("6");
			}
		});

		Button button7_basic = (Button) findViewById(R.id.button7_basic);
		button7_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("7");
			}
		});

		Button button8_basic = (Button) findViewById(R.id.button8_basic);
		button8_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("8");
			}
		});

		Button button9_basic = (Button) findViewById(R.id.button9_basic);
		button9_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("9");
			}
		});

		Button dot_button_basic = (Button) findViewById(R.id.dot_button_basic);
		dot_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("0"))
						pushToResult("0.");
					else	pushToResult(".");
				}
			}
			//TODO: check how many dots in a single number
		});

		Button divide_button_basic = (Button) findViewById(R.id.divide_button_basic);
		divide_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("0"))
						pushToResult("0/");
					pushToResult("/");
				}
			}
		});

		Button multiply_button_basic = (Button) findViewById(R.id.multiply_button_basic);
		multiply_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("0"))
						pushToResult("0*");
					pushToResult("*");
				}
			}
		});

		Button add_button_basic = (Button) findViewById(R.id.add_button_basic);
		add_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("0"))
						pushToResult("0*");
					pushToResult("*");
				}
			}
		});

		Button subtract_button_basic = (Button) findViewById(R.id.subtract_button_basic);
		subtract_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("-"))
						pushToResult("0-");
					pushToResult("-");
				}
			}
		});




	}
}