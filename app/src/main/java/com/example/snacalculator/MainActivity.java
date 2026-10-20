package com.example.snacalculator;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvExpression, tvResult;

    Button btnNumber0, btnNumber1, btnNumber2, btnNumber3,
            btnNumber4, btnNumber5, btnNumber6, btnNumber7,
            btnNumber8, btnNumber9, btnDiv, btnMul, btnAdd,
            btnSub, btnDelete, btnMod, btnEqual, btnClear,
            btnDot, btnChangeSign, btnOpenBracket, btnCloseBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        btnNumber0 = findViewById(R.id.btnNumber0);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);
        btnNumber8 = findViewById(R.id.btnNumber8);
        btnNumber9 = findViewById(R.id.btnNumber9);

        btnMod = findViewById(R.id.btnMod);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);

        btnEqual = findViewById(R.id.btnEqual);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnChangeSign = findViewById(R.id.btnChangeSign);
        btnOpenBracket = findViewById(R.id.btnOpenBracket);
        btnCloseBracket = findViewById(R.id.btnCloseBracket);

        // Number buttons
        btnNumber0.setOnClickListener(v -> tvExpression.append("0"));
        btnNumber1.setOnClickListener(v -> tvExpression.append("1"));
        btnNumber2.setOnClickListener(v -> tvExpression.append("2"));
        btnNumber3.setOnClickListener(v -> tvExpression.append("3"));
        btnNumber4.setOnClickListener(v -> tvExpression.append("4"));
        btnNumber5.setOnClickListener(v -> tvExpression.append("5"));
        btnNumber6.setOnClickListener(v -> tvExpression.append("6"));
        btnNumber7.setOnClickListener(v -> tvExpression.append("7"));
        btnNumber8.setOnClickListener(v -> tvExpression.append("8"));
        btnNumber9.setOnClickListener(v -> tvExpression.append("9"));

        // Brackets
        btnOpenBracket.setOnClickListener(v -> tvExpression.append("("));
        btnCloseBracket.setOnClickListener(v -> tvExpression.append(")"));

        // Division button
        btnDiv.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                tvExpression.setText("0÷");
                return;
            }

            char lastChar = expression.charAt(expression.length() - 1);

            if (lastChar == '+' || lastChar == '-' ||
                    lastChar == '×' || lastChar == '÷' ||
                    lastChar == '%') {

                expression = expression.substring(0, expression.length() - 1);
                tvExpression.setText(expression + "÷");
                return;
            }

            tvExpression.append("÷");
        });

        // Multiplication button
        btnMul.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                tvExpression.setText("0×");
                return;
            }

            char lastChar = expression.charAt(expression.length() - 1);

            if (lastChar == '+' || lastChar == '-' ||
                    lastChar == '×' || lastChar == '÷' ||
                    lastChar == '%') {

                expression = expression.substring(0, expression.length() - 1);
                tvExpression.setText(expression + "×");
                return;
            }

            tvExpression.append("×");
        });

        // Addition button
        btnAdd.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                tvExpression.setText("0+");
                return;
            }

            char lastChar = expression.charAt(expression.length() - 1);

            if (lastChar == '+' || lastChar == '-' ||
                    lastChar == '×' || lastChar == '÷' ||
                    lastChar == '%') {

                expression = expression.substring(0, expression.length() - 1);
                tvExpression.setText(expression + "+");
                return;
            }

            tvExpression.append("+");
        });

        // Subtraction button
        btnSub.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                tvExpression.setText("0-");
                return;
            }

            char lastChar = expression.charAt(expression.length() - 1);

            if (lastChar == '+' || lastChar == '-' ||
                    lastChar == '×' || lastChar == '÷' ||
                    lastChar == '%') {

                expression = expression.substring(0, expression.length() - 1);
                tvExpression.setText(expression + "-");
                return;
            }

            tvExpression.append("-");
        });

        // Delete last character
        btnDelete.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (!expression.isEmpty()) {
                expression = expression.substring(0, expression.length() - 1);
                tvExpression.setText(expression);
            }
        });

        // Clear display
        btnClear.setOnClickListener(v -> {
            tvExpression.setText("");
            tvResult.setText("0");
        });

        // Decimal point button
        btnDot.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            int lastOperator = Math.max(
                    Math.max(
                            Math.max(expression.lastIndexOf("+"),
                                    expression.lastIndexOf("-")),
                            Math.max(expression.lastIndexOf("×"),
                                    expression.lastIndexOf("÷"))
                    ),
                    expression.lastIndexOf("%")
            );

            String currentNumber = expression.substring(lastOperator + 1);

            if (currentNumber.contains(".")) {
                return;
            }

            if (currentNumber.isEmpty()) {
                tvExpression.append("0.");
            } else {
                tvExpression.append(".");
            }
        });

        // Modulus (remainder) button
        btnMod.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                return;
            }

            char lastChar = expression.charAt(expression.length() - 1);

            if (lastChar == '+' || lastChar == '-' ||
                    lastChar == '×' || lastChar == '÷' ||
                    lastChar == '%' || lastChar == '.') {
                return;
            }

            tvExpression.append("%");
        });

        // Change sign button
        btnChangeSign.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();

            if (expression.isEmpty()) {
                return;
            }

            int lastOperator = -1;
            int bracketCount = 0;

            // Find the last operator outside parentheses
            for (int i = expression.length() - 1; i >= 0; i--) {
                char c = expression.charAt(i);

                if (c == ')') {
                    bracketCount++;
                } else if (c == '(') {
                    bracketCount--;
                } else if (bracketCount == 0 &&
                        (c == '+' || c == '-' ||
                                c == '×' || c == '÷' || c == '%')) {

                    // Ignore minus sign used for a negative number
                    if (c == '-' &&
                            (i == 0 ||
                                    expression.charAt(i - 1) == '(' ||
                                    expression.charAt(i - 1) == '+' ||
                                    expression.charAt(i - 1) == '-' ||
                                    expression.charAt(i - 1) == '×' ||
                                    expression.charAt(i - 1) == '÷' ||
                                    expression.charAt(i - 1) == '%')) {
                        continue;
                    }

                    lastOperator = i;
                    break;
                }
            }

            int operandStart = lastOperator + 1;

            String before = expression.substring(0, operandStart);
            String operand = expression.substring(operandStart);

            if (operand.isEmpty()) {
                return;
            }

            // Toggle the sign of the last operand
            if (operand.startsWith("(-") && operand.endsWith(")")) {
                operand = operand.substring(2, operand.length() - 1);
            } else if (operand.startsWith("-")) {
                operand = operand.substring(1);
            } else {
                operand = "(-" + operand + ")";
            }

            tvExpression.setText(before + operand);
        });

        // Equal button
        btnEqual.setOnClickListener(v -> {
            String currentExpression = tvExpression.getText().toString();

            if (currentExpression.isEmpty()) {
                return;
            }

            try {
                String expressionToCalculate = currentExpression
                        .replace("×", "*")
                        .replace("÷", "/")
                        .replace("−", "-");

                ExpressionParser parser =
                        new ExpressionParser(expressionToCalculate);

                double result = parser.parse();

                if (!Double.isFinite(result)) {
                    tvResult.setText("Error");
                    return;
                }

                String formattedResult =
                        java.math.BigDecimal.valueOf(result)
                                .setScale(10, java.math.RoundingMode.HALF_UP)
                                .stripTrailingZeros()
                                .toPlainString();

                tvResult.setText(formattedResult);

            } catch (ArithmeticException e) {
                tvResult.setText(e.getMessage());

            } catch (IllegalArgumentException e) {
                tvResult.setText("Invalid expression");
            }
        });

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    // Expression parser
    private static class ExpressionParser {

        private final String input;
        private int position = 0;

        ExpressionParser(String input) {
            this.input = input;
        }

        double parse() {
            double result = parseExpression();

            skipSpaces();

            if (position < input.length()) {
                throw new IllegalArgumentException("Invalid expression");
            }

            return result;
        }

        // Addition and subtraction
        private double parseExpression() {
            double result = parseTerm();

            while (true) {
                skipSpaces();

                if (match('+')) {
                    result += parseTerm();
                } else if (match('-')) {
                    result -= parseTerm();
                } else {
                    return result;
                }
            }
        }

        // Multiplication, division, and modulus
        private double parseTerm() {
            double result = parseFactor();

            while (true) {
                skipSpaces();

                if (match('*')) {
                    result *= parseFactor();

                } else if (match('/')) {
                    double divisor = parseFactor();

                    if (divisor == 0) {
                        throw new ArithmeticException(
                                "Cannot divide by 0"
                        );
                    }

                    result /= divisor;

                } else if (match('%')) {
                    double divisor = parseFactor();

                    if (divisor == 0) {
                        throw new ArithmeticException(
                                "Cannot calculate modulus by 0"
                        );
                    }

                    result %= divisor;

                } else {
                    return result;
                }
            }
        }

        // Numbers, signs, and parentheses
        private double parseFactor() {
            skipSpaces();

            if (match('+')) {
                return parseFactor();
            }

            if (match('-')) {
                return -parseFactor();
            }

            if (match('(')) {
                double result = parseExpression();

                if (!match(')')) {
                    throw new IllegalArgumentException(
                            "Missing closing bracket"
                    );
                }

                return result;
            }

            return parseNumber();
        }

        // Read a whole or decimal number
        private double parseNumber() {
            skipSpaces();

            int start = position;
            boolean hasDigit = false;
            boolean hasDot = false;

            while (position < input.length()) {
                char c = input.charAt(position);

                if (Character.isDigit(c)) {
                    hasDigit = true;
                    position++;
                } else if (c == '.' && !hasDot) {
                    hasDot = true;
                    position++;
                } else {
                    break;
                }
            }

            if (!hasDigit) {
                throw new IllegalArgumentException("Invalid number");
            }

            return Double.parseDouble(input.substring(start, position));
        }

        // Check and consume a character
        private boolean match(char expected) {
            if (position < input.length()
                    && input.charAt(position) == expected) {
                position++;
                return true;
            }

            return false;
        }

        // Skip spaces
        private void skipSpaces() {
            while (position < input.length()
                    && Character.isWhitespace(input.charAt(position))) {
                position++;
            }
        }
    }
}