package com.example.my_banking

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.dynatrace.android.agent.Dynatrace
import com.dynatrace.android.agent.conf.DataCollectionLevel
import com.dynatrace.android.agent.conf.UserPrivacyOptions
import com.example.my_banking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var current: String = ""
    private var crashgabs : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        Dynatrace.applyUserPrivacyOptions(UserPrivacyOptions.builder()
            .withDataCollectionLevel(DataCollectionLevel.USER_BEHAVIOR)
            .withCrashReportingOptedIn(true)
            .withCrashReplayOptedIn(true)
            .build());

        binding.saveBill.setOnClickListener {
            Toast.makeText(this , "here we go again", Toast.LENGTH_SHORT).show()

                crashgabs = 2/0

        }

        binding.amount.doOnTextChanged { text, start, before, count ->
            if (text.toString() != current) {

                val cleanString: String = text?.replace("""[$,.]""".toRegex(), "") ?: ""

                val parsed = cleanString.toDouble()
                val formatted = NumberFormat.getCurrencyInstance().format((parsed / 100))

                current = formatted
                binding.amount.setText(formatted)
                binding.amount.setSelection(formatted.length)
            }
        }
    }

}