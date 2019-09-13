package com.example.caloriecounter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import java.util.List;

public class Status extends AppCompatActivity {

    EditText edStatus;
    Button btSave, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        btSave = findViewById(R.id.btSave);
        edStatus = findViewById(R.id.edStatus);
        btCancel = findViewById(R.id.btCancel);

        Backendless.Persistence.of(Note.class).find(new AsyncCallback<List<Note>>() {

            @Override
            public void handleResponse(List<Note> response) {
                Toast.makeText(Status.this, response.toString(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(Status.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String edStatusValue = edStatus.getText().toString().trim();
                Note note = new Note();
                note.setStatus(edStatusValue);
                Backendless.Persistence.save(note, new AsyncCallback<Note>() {
                    @Override
                    public void handleResponse(Note response) {
                        Toast.makeText(Status.this, "Save", Toast.LENGTH_SHORT).show();
                        Status.this.finish();
                    }
                    @Override
                    public void handleFault(BackendlessFault fault) {
                    }
                });
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Status.this.finish();
            }
        });
    }
}
