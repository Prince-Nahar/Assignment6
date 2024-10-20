package edu.temple.desserrtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    /**
     * Companion objects are used in Kotlin
     * as containers of public static fields
     */
    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the title for the activity.
        // This is done to ensure that the activity label
        // displayed in the Android launcher is different
        supportActionBar?.title = getString(R.string.app_name)

        val selectItemTextView = findViewById<TextView>(R.id.displayMessage)
        selectItemTextView.text = getString(R.string.select_item)

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val clickEvent = {item: Item ->
            // Item object can be placed directly inside Intent because
            // the Item class implements the Parcelable interface
            val launchIntent = Intent(this, DisplayActivity::class.java)
                .putExtra(ITEM_KEY, item)

            startActivity(launchIntent)
        }

        recyclerView.adapter = ImageAdapter(items, clickEvent)
    }

    /**
     * Generate test info for app
     */
    fun generateTestData(): Array<Item> {
        val descriptions = resources.getStringArray(R.array.cheesecake_descriptions)

        return arrayOf(Item(R.drawable.ccf_original, descriptions[0]),
            Item(R.drawable.ccf_freshstrawberry, descriptions[1]),
            Item(R.drawable.ccf_chocolatecaramelicious, descriptions[2]),
            Item(R.drawable.ccf_pineappleupsidedown, descriptions[3]),
            Item(R.drawable.ccf_celebration, descriptions[4]),
            Item(R.drawable.ccf_caramelapple, descriptions[5]),
            Item(R.drawable.ccf_verycherryghirardellichocolate, descriptions[6]),
            Item(R.drawable.ccf_lowlicious, descriptions[7]),
            Item(R.drawable.ccf_cinnaboncinnamoncwirl, descriptions[8]),
            Item(R.drawable.ccf_godiva, descriptions[9]),
            Item(R.drawable.ccf_coconutcreampie, descriptions[10]),
            Item(R.drawable.ccf_saltedcaramel, descriptions[11]))
    }
}