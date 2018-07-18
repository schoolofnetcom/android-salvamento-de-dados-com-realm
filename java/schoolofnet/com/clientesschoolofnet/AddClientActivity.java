package schoolofnet.com.clientesschoolofnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);


        final EditText nameField = findViewById(R.id.nameFieldTXT);
        final EditText emailField = findViewById(R.id.emailFieldTXT);
        final EditText cpfField = findViewById(R.id.cpfFieldTXT);


        Button saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nameField.getText().toString();
                String email = emailField.getText().toString();
                String cpf = cpfField.getText().toString();

                // Salvar no banco

                Client client = new Client(nome,email,cpf);
                client.save();

                // Fim do salvamento

                Toast.makeText(getApplicationContext(),"Cliente salvo com sucesso",Toast.LENGTH_LONG).show();
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
