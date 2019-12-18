package nyc.ignitelabs.civicduty

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.text.Editable
import android.widget.EditText





class EditActivity : AppCompatActivity() {
    companion object {
        const val EDITTED_TEXT = "nyc.ignitelabs.civicduty.edittedtext"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val editText = findViewById<EditText>(R.id.address_edit)
        val ss:String = intent.getStringExtra("userText")
        editText.text = Editable.Factory.getInstance().newEditable(ss)

        findViewById<Button>(R.id.save_button).setOnClickListener {
            val data = Intent()
            data.putExtra(EDITTED_TEXT, editText.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
