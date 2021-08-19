package com.iameben.zuristage3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.util.Linkify
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.iameben.zuristage3.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // the following lines of codes gets text from an editText and
        // passes that input text to a textView
        binding.okBtn.setOnClickListener {
            val msg = binding.inputTiE?.text.toString()
            binding.displayTV.text = msg

        }

        // disables the button if editText is empty
        binding?.okBtn?.isEnabled = false
        binding.inputTiE.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // enables the button after a text is inputted
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               binding?.okBtn?.isEnabled = p0.toString().trim{ it <= ' '}.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })


    }

    fun zuri(view: View) {
        val uri = Uri.parse("https://internship.zuri.team")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
