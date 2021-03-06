package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Character.isDigit;


public class BasicCalculatorActivity extends Activity {
	private String current_value = "0";
	private TextView result_basic;
	final private int max_length = 20;
	private final MathContext m = new MathContext(max_length / 2);
	final private String error_message = "Error";
	private BigDecimal memory_result = new BigDecimal(0.0, m);
	private String last_action = null;
	private boolean should_reset_result = false;
	private boolean was_clear_clicked = false;


	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("current_value", current_value);
		savedInstanceState.putDouble("memory_result",(memory_result.doubleValue()));
		savedInstanceState.putString("last_action", last_action);
		savedInstanceState.putBoolean("should_reset_result", should_reset_result);
		savedInstanceState.putBoolean("was_clear_clicked", was_clear_clicked);

	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		current_value = savedInstanceState.getString("current_value");
		result_basic.setText(current_value);
		memory_result = BigDecimal.valueOf(savedInstanceState.getDouble("memory_result"));
		last_action = savedInstanceState.getString("last_action");
		should_reset_result = savedInstanceState.getBoolean("should_reset_result");
		was_clear_clicked = savedInstanceState.getBoolean("was_clear_clicked");
	}


	private void countLastExpression() {
		should_reset_result = true;
		try {
			BigDecimal current_decimal = new BigDecimal(current_value, m);
			if (last_action == null) {
				memory_result = current_decimal;
				return;
			}
			if (last_action.equals("+"))
				memory_result = memory_result.add(current_decimal, m);
			else if (last_action.equals("-"))
				memory_result = memory_result.subtract(current_decimal, m);
			else if (last_action.equals("*")) {
				memory_result = memory_result.multiply(current_decimal, m);
			} else if (last_action.equals("/")) {
				memory_result = memory_result.divide(current_decimal, m);
			}
			setResult(memory_result.stripTrailingZeros().toEngineeringString());
		} catch (Exception e) {
			clearAll();
			setResult(error_message);
			should_reset_result = true;
		}
	}

	private void clearAll() {
		resetResult();
		memory_result.equals(0.0);
		last_action = null;
		should_reset_result = false;
	}


	private void resetResult() {
		current_value = "0";
		result_basic.setText(current_value);
	}


	private void setResult(String result) {
		current_value = result;
		result_basic.setText(current_value);
	}


	private void pushToResult(String result) {
		if (should_reset_result) {
			resetResult();
			should_reset_result = false;
		}
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
				if (current_value.equals(error_message))
					resetResult();
				if (current_value.length() > 0) {
					setResult(current_value.substring(0, current_value.length() - 1));
					if (current_value.isEmpty())
						resetResult();
				}
				if (was_clear_clicked) {
					resetResult();
				}
				was_clear_clicked = true;
				should_reset_result = false;
			}
		});


		final Button all_clear_button_basic = (Button) findViewById(R.id.all_clear_button_basic);
		all_clear_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				clearAll();
				was_clear_clicked = false;
			}
		});

		Button button0_basic = (Button) findViewById(R.id.button0_basic);
		button0_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("0");
				was_clear_clicked = false;
			}
		});

		Button button1_basic = (Button) findViewById(R.id.button1_basic);
		button1_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("1");
				was_clear_clicked = false;
			}
		});

		Button button2_basic = (Button) findViewById(R.id.button2_basic);
		button2_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("2");
				was_clear_clicked = false;
			}
		});

		Button button3_basic = (Button) findViewById(R.id.button3_basic);
		button3_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("3");
				was_clear_clicked = false;
			}
		});

		Button button4_basic = (Button) findViewById(R.id.button4_basic);
		button4_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("4");
				was_clear_clicked = false;
			}
		});

		Button button5_basic = (Button) findViewById(R.id.button5_basic);
		button5_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("5");
				was_clear_clicked = false;
			}
		});

		Button button6_basic = (Button) findViewById(R.id.button6_basic);
		button6_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("6");
				was_clear_clicked = false;
			}
		});

		Button button7_basic = (Button) findViewById(R.id.button7_basic);
		button7_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("7");
				was_clear_clicked = false;
			}
		});

		Button button8_basic = (Button) findViewById(R.id.button8_basic);
		button8_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("8");
				was_clear_clicked = false;
			}
		});

		Button button9_basic = (Button) findViewById(R.id.button9_basic);
		button9_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pushToResult("9");
				was_clear_clicked = false;
			}
		});

		Button dot_button_basic = (Button) findViewById(R.id.dot_button_basic);
		dot_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					if (current_value.equals("0") || should_reset_result)
						pushToResult("0.");
					else if (!current_value.contains("."))
						pushToResult(".");
				}
				was_clear_clicked = false;
			}
		});

		final Button divide_button_basic = (Button) findViewById(R.id.divide_button_basic);
		divide_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					countLastExpression();
					last_action = "/";
				}
				was_clear_clicked = false;
			}
		});

		final Button multiply_button_basic = (Button) findViewById(R.id.multiply_button_basic);
		multiply_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					countLastExpression();
					last_action = "*";
				}
				was_clear_clicked = false;
			}
		});

		final Button add_button_basic = (Button) findViewById(R.id.add_button_basic);
		add_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					countLastExpression();
					last_action = "+";
				}
				was_clear_clicked = false;
			}
		});

		final Button subtract_button_basic = (Button) findViewById(R.id.subtract_button_basic);
		subtract_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					countLastExpression();
					last_action = "-";
				}
				was_clear_clicked = false;
			}
		});

		Button equality_button_basic = (Button) findViewById(R.id.equality_button_basic);
		equality_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDigit(checkLastCharacterInResult())) {
					countLastExpression();
					last_action = null;
				}
				was_clear_clicked = false;
			}
		});

		Button negative_button_basic = (Button) findViewById(R.id.negative_button_basic);
		negative_button_basic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (current_value.compareTo("0") != 0) {
					if (current_value.charAt(0) == '-') {
						current_value = current_value.substring(1);
					} else if (isDigit(current_value.charAt(0)))
						current_value = "-" + current_value;
					setResult(current_value);
					was_clear_clicked = false;
				}
			}
		});



	}
}