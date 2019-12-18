package nyc.ignitelabs.civicduty

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
        const val EDIT_TEXT_REQUEST = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() called")

        findViewById<Button>(R.id.edit_button).setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            val inputView = findViewById<TextView>(R.id.address)
            intent.putExtra("userText", inputView.text.toString())
            startActivityForResult(intent, EDIT_TEXT_REQUEST)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == EDIT_TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val inputView = findViewById<TextView>(R.id.address)
                val ss:String = data!!.getStringExtra(EditActivity.EDITTED_TEXT)
                inputView.text = ss
//                inputView.text = data.getStringExtra()
            }
        }
    }
}
