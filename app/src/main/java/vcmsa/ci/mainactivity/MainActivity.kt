package vcmsa.ci.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vcmsa.ci.mainactivity.ui.theme.MainActivityTheme

private fun String.isEmpty(function: Any) {


}

class MainActivity : ComponentActivity() {
    companion object {
        var songTitles = ArrayList<String>()
        var artistNames = ArrayList<String>()
        var ratings = ArrayList<Int>()
        var comments = ArrayList<String>()

}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val viewButton = findViewById<Button>(R.id.btnView)
        val exitButton = findViewById<Button>(R.id.btnExit)

        val titleInput = findViewById<EditText>(R.id.txtTitle)
        val artistInput = findViewById<EditText>(R.id.txtArtist)
        val ratingInput = findViewById<EditText>(R.id.txtRating)
        val commentInput = findViewById<EditText>(R.id.txtComment)

        addButton.setOnClickListener{
            try {
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString()
                val comment = commentInput.text.toString()

                if (title.isEmpty())
                    artist.isEmpty()
                comment.isEmpty() {
                    Toast.makeText (this , "Please fill all the fields")
                    Toast.LENGTH_SHORT

                    (return@isEmpty).setOnClickListener

                }
                if( rating <1 || rating >5) {
                    Toast.makeText(this , "Rating must be between 1 and 5")
                    Toast.LENGTH_SHORT
                    return@setOnClickListener
                }
                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(ratings)
                comments.add(comments)
                Toast.makeText("Song added to playlist")

                //Clear Input

                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
        }catch (e: Exception) {Toast.makeText(this, "Error: ${e.message}")}
            Toast.LENGTH_SHORT

    }
        viewButton.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.javaClass))

            exitButton.setOnClickListener {
                finishAffinity()
            }
        }

        class DetailActivity : ComponentActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                setContentView(R.layout.activity_detail)

                val  songListView = findViewById<TextView>(R.id.txtSongs)
                val avgRatingView = findViewById<TextView>(R.id.txtAverage)
                val showBtn = findViewById<Button>(R.id.btnShow)
                val averageBtn = findViewById<Button>(R.id.btnAverage)
                val backBtn = findViewById<Button>(btnBack)

                showBtn.setOnClickListener {
                    val builder = StringBuilder()
                    for(i in MainActivity.songTitles.indices) {
                        builder.append("Title : ${MainActivity.songTitles[i]}\n")
                        builder.append("Artist : ${MainActivity.artistNames[i]}\n")
                        builder.append("Rating : ${MainActivity.ratings[i]}\n")
                        builder.append("Comments : ${MainActivity.comments[i]}\n\n")

                    }
                    songListView.text = builder.toString()
                }
                averageBtn.setOnClickListener {
                    if(MainActivity.ratings.isNotEmpty()) {
                        val average = MainActivity.ratings.sum(.toDouble() / MainActivity.ratings.size
                        avgRatingView.text = "No songs added"
                    }
                }
                backBtn.setOnClickListener{
                    finish()
                }


            }
        }
    }
}