package schoolofnet.com.clientesschoolofnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditClientActivity extends AppCompatActivity {

    private EditText nomeEdit, emailEdit, cpfEdit;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        nomeEdit = findViewById(R.id.nameFieldTXT);
        emailEdit = findViewById(R.id.emailFieldTXT);
        cpfEdit = findViewById(R.id.cpfFieldTXT);
        String id = getIntent().getStringExtra("id");
        client = Client.findByID(id);
        nomeEdit.setText(client.getName());
        emailEdit.setText(client.getEmail());
        cpfEdit.setText(client.getCpf());
        Button saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomeEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String cpf = cpfEdit.getText().toString();
                client.setName(name);
                client.setEmail(email);
                client.setCpf(cpf);
                client.update();
                Toast.makeText(getApplicationContext(),"Cliente atualizado!",Toast.LENGTH_LONG).show();
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });


        Button deleteBtn = findViewById(R.id.deleteBtn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.delete();
                Toast.makeText(getApplicationContext(),"Cliente deletado!",Toast.LENGTH_LONG).show();
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        Button cancelBtn = findViewById(R.id.cancelBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }
}
