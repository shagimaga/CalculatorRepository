package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button0?.setOnClickListener { appendSymbolIntoExpression(binding.button0?.text.toString(),true)
        }
        binding.button1?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button1?.text.toString(),
                true
            )
        }
        binding.button2?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button2?.text.toString(),
                true
            )
        }
        binding.button3?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button3?.text.toString(),
                true
            )
        }
        binding.button4?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button4?.text.toString(),
                true
            )
        }
        binding.button5?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button5?.text.toString(),
                true
            )
        }
        binding.button6?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button6?.text.toString(),
                true
            )
        }
        binding.button7?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button7?.text.toString(),
                true
            )
        }
        binding.button8?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button8?.text.toString(),
                true
            )
        }
        binding.button9?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.button9?.text.toString(),
                true
            )
        }
        binding.buttonDot?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.buttonDot?.text.toString(),
                true
            )
        }


        binding.buttonPlus?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.buttonPlus?.text.toString(),
                false
            )
        }
        binding.buttonMinus?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.buttonMinus?.text.toString(),
                false
            )
        }
        binding.buttonMultiply?.setOnClickListener { appendSymbolIntoExpression("*", false) }
        binding.buttonDivide?.setOnClickListener { appendSymbolIntoExpression("/", false) }
        binding.buttonPercent?.setOnClickListener {
            appendSymbolIntoExpression(
                binding.buttonPercent?.text.toString(),
                false
            )
        }
        binding.buttonSign?.setOnClickListener { appendSymbolIntoExpression("-", false) }

        binding.backspace?.setOnClickListener{ backspace()}
        binding.buttonAC?.setOnClickListener { clear() }
        binding.buttonEqual?.setOnClickListener { calculate() }

    }

    private fun backspace() {
        if (binding.expression?.text.toString().isNotEmpty()) {
            binding.expression?.text = binding.expression?.text.toString()
                .substring(0, binding.expression?.text.toString().length - 1)
        }
    }

    private fun clear() {
        binding.result?.text = ""
        binding.expression?.text = ""
    }

    private fun appendSymbolIntoExpression(symbol: String, clear: Boolean) {
        if (clear) {
            binding.result?.text = ""
            binding.expression?.text = binding.expression?.text.toString() + symbol
        } else {
            binding.expression?.append(binding.result?.text)
            binding.expression?.append(symbol)
            binding.result?.text = ""
        }
    }

    private fun calculate() {

        try {

            val expression = ExpressionBuilder(binding.expression?.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                binding.result?.text = longResult.toString()
            } else {
                binding.result?.text = result.toString()
            }

        } catch (e: Exception) {
            binding.result?.text = "Error"

            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

}