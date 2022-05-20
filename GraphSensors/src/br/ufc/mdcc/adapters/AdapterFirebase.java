package br.ufc.mdcc.adapters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.ufc.mdcc.DataModel.EventSensor;


public class AdapterFirebase {
	
	
	public void inicializarFirebase() throws InterruptedException, ExecutionException {
		
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("/media/jamires/57DB0E68615B5875/Programas/firebase/serviceAccountKey.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://monitoraapp-348719-default-rtdb.firebaseio.com")
			  .setDatabaseAuthVariableOverride(null)
			  .build();
			
			// idToken comes from the client app (shown above)

			FirebaseApp.initializeApp(options);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			
	
	}

	public ArrayList<EventSensor> getListEvents(String nameCollection) throws InterruptedException, ExecutionException {
		ArrayList<EventSensor> eventSensor=new ArrayList<EventSensor>();
		EventSensor event = new EventSensor() ;
		Firestore db=FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> query = db.collection(nameCollection).get();
		
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			event=document.toObject(EventSensor.class);
			eventSensor.add(event);
		}
		return eventSensor;
		/*ApiFuture<DocumentSnapshot> future=doc.get();
		for(DocumentSnapshot data: future.get()) {
		DocumentSnapshot data=future.get();
		EventSensor event=null;
		if(data.exists()) {
			System.out.println("oi");
			return event=data.toObject(EventSensor.class);
		}else {
			System.out.println("nulo");
			return null;
		}*/
	
	
	}
	public EventSensor getEvent(String nameCollection, String key) throws InterruptedException, ExecutionException {
		EventSensor event = new EventSensor() ;
		Firestore db=FirestoreClient.getFirestore();
		DocumentReference  doc= db.collection(nameCollection).document(key);
		ApiFuture<DocumentSnapshot> future=doc.get();
		DocumentSnapshot data=future.get();
		if(data.exists()) {
			return event=data.toObject(EventSensor.class);
		}else {
			return null;
		
	}
	}
}
		


	




