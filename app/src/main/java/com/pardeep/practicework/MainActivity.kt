package com.pardeep.practicework

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var Toast_button: Button? = null
        var Call_me: Button? = null
        var Email_me: Button? = null
        var Sms_me: Button? = null
        var alert: Button? = null
        var alert2: Button? = null
        var alert3: Button? = null

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Toast_button = findViewById(R.id.toast_button)
        Call_me = findViewById(R.id.implicit_button1)
        Email_me = findViewById(R.id.implicit_button2)
        Sms_me = findViewById(R.id.implicit_button3)
        alert = findViewById(R.id.alert_dialog)
        alert2 = findViewById(R.id.alert_dialog2)
        alert3 = findViewById(R.id.alert_dialog3)

        Toast_button?.setOnClickListener {
            Toast.makeText(this, "Button is pressed", Toast.LENGTH_SHORT).show()
        }
        Call_me?.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL).apply {
                setData(Uri.parse("tel:+918968531504"))
            }
            startActivity(intent)
        }

        // Email implicit button
        Email_me?.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO).apply {
                setData(Uri.parse("mailto:"))
                putExtra(Intent.EXTRA_EMAIL, arrayOf("maheyp666@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Team_work")
                putExtra(Intent.EXTRA_TEXT, "well done")
            }
            startActivity(intent)
        }

        //sms implicit button
        Sms_me?.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND).apply {
                setData(Uri.parse("smsto:8968531504"))
                putExtra(Intent.EXTRA_TEXT, "hello world!")
            }
            startActivity(intent)
        }

        //alert dialog
        alert?.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity).apply {
                setTitle("hello")
                setMessage("welcome back")
                setPositiveButton("confirm") { Dialog, which ->
                    Toast.makeText(this@MainActivity, "button is pressed", Toast.LENGTH_SHORT)
                        .show()
                }
                setNegativeButton("back") { Dialog, which ->
                    Toast.makeText(this@MainActivity, "back button is pressef", Toast.LENGTH_SHORT)
                        .show()
                }
                setNeutralButton("feedback") { Dialog, which ->
                    Toast.makeText(
                        this@MainActivity,
                        "feedback button is pressed",
                        Toast.LENGTH_SHORT
                    ).show()
                }.show()
            }
        }

        // alert 2 button
        alert2?.setOnClickListener {
            var alert2 = AlertDialog.Builder(this@MainActivity).apply {
                setPositiveButton("confirm") { Dialog, which ->
                    Toast.makeText(
                        this@MainActivity,
                        "confirm button is pressed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                setNegativeButton("back") { Dialog, which ->
                    Toast.makeText(this@MainActivity, "back button is pressed", Toast.LENGTH_SHORT)
                        .show()

                }
                setItems(arrayOf("first item", "second item", "third item")) { Dialog, which ->


                }.show()
            }.show()
        }

        alert3?.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity).apply {
                setTitle("Multi-choice")
                setPositiveButton("confirm") { Dialog, which ->
                    Toast.makeText(this@MainActivity, "button is pressed", Toast.LENGTH_SHORT)
                        .show()
                }
                setNegativeButton("Back") { Dialog, which ->
                    Toast.makeText(this@MainActivity, "button is pressed", Toast.LENGTH_SHORT)
                        .show()
                }
                setMultiChoiceItems(
                    arrayOf("first item", "second item", "third item"),
                    null
                ) { Dialog, which, ischecked ->
                }.show()
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}