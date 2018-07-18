package schoolofnet.com.clientesschoolofnet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Client extends RealmObject{
    @PrimaryKey
    @Required
    private String id = UUID.randomUUID().toString();
    @Required
    private String name;
    @Required
    private String email;
    private String cpf;


    public void save(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.copyToRealm(this);

        realm.commitTransaction();
        realm.close();
    }

    public void delete(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Client refClient = realm.where(Client.class).equalTo("id",this.getId()).findFirst();
        refClient.deleteFromRealm();

        realm.commitTransaction();
        realm.close();
    }

    public void update(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Client refClient = realm.where(Client.class).equalTo("id",this.getId()).findFirst();
        refClient.setName(this.getName());
        refClient.setEmail(this.getEmail());
        refClient.setCpf(this.getCpf());
        realm.commitTransaction();
        realm.close();
    }
    public static Client findByID(String id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Client c = realm.where(Client.class).equalTo("id",id).findFirst();

        Client novoCliente = new Client(c.getId(), c.getName(), c.getEmail(), c.getCpf());

        realm.commitTransaction();
        realm.close();
        return novoCliente;
    }

    public static List<Client> findAll(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<Client> clients = realm.where(Client.class).findAll();
        List<Client> clientList = new ArrayList<>();

        for (int i = 0; i < clients.size();i++){
                Client c = new Client(clients.get(i).getId(),clients.get(i).getName(),clients.get(i).getEmail(),clients.get(i).getCpf());
                clientList.add(c);
        }

        realm.commitTransaction();
        realm.close();

        return clientList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Client(){

    }

    public Client(String name, String email, String cpf){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Client(String id, String name, String email, String cpf){
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
