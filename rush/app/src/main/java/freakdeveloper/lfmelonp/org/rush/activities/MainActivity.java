package freakdeveloper.lfmelonp.org.rush.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import co.uk.rushorm.core.RushSearch;
import freakdeveloper.lfmelonp.org.rush.R;
import freakdeveloper.lfmelonp.org.rush.models.Author;
import freakdeveloper.lfmelonp.org.rush.models.Book;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void insertElements(View v){
        for (int i = 0; i < 15; i++){
            List<Author> collaboratorsAuthors = new ArrayList<>();
            for (int j = 0 ; j < 4; j++){
                collaboratorsAuthors.add(new Author("Collaborator nº"+i+"-"+j, "SurCollaborator nº"+i+"-"+j,new Date()));
            }
            Book insertion = new Book("Libro nº"+i, "Edition" + i
                    ,new Author("Pedro "+i,"Almaraz"+i,new Date()),collaboratorsAuthors);
            Log.d("RUSH_ORM_DEBUGGER","INSERTION Nº"+i+"/"+ insertion.toString());
            insertion.save();
        }
    }

    public void massiveQuery(View v){
        List<Book> objects = new RushSearch().find(Book.class);
        for (int i = 0; i < objects.size(); i++){
            Log.d("RUSH_ORM_DEBUGGER","MASSIVE QUERY ELEMENT Nº"+i+"/"+ objects.get(i).toString());
        }
    }


    public void idQuery(View v){
        Book table = new RushSearch().whereId("1").findSingle(Book.class);
        Log.d("RUSH_ORM_DEBUGGER", "ID QUERY: " +table.toString());
    }

    public void idDelete(View v){
        Book table = new RushSearch().whereId("4").findSingle(Book.class);
        Log.d("RUSH_ORM_DEBUGGER", "ID DELETE BEFORE: " +table.toString());
        table.delete();
        table = new RushSearch().whereId("4").findSingle(Book.class);
        Log.d("RUSH_ORM_DEBUGGER", "ID DELETE AFTER: " +table.toString());
    }


    public void massiveDelete(View v){
        List<Book> objects = new RushSearch().find(Book.class);
        Log.d("RUSH_ORM_DEBUGGER","MASSIVE DELETE ELEMENT SIZE BEFORE: "+ objects.size());
        for (int i = 0; i < objects.size(); i++){
            Log.d("RUSH_ORM_DEBUGGER","MASSIVE DELETE ELEMENT Nº"+i+"/"+ objects.get(i).toString());
            objects.get(i).delete();
        }
        objects = new RushSearch().find(Book.class);
        Log.d("RUSH_ORM_DEBUGGER","MASSIVE DELETE ELEMENT SIZE AFTER: "+ objects.size());
    }

}
