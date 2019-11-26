package ohm.softa.a06.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter<Joke> {
	private final Gson gson;

	public JokeAdapter(){
		gson = new Gson();
	}


	@Override
	public void write(JsonWriter jsonWriter, Joke joke) throws IOException {

	}

	@Override
	public Joke read(JsonReader jsonReader) throws IOException {
		Joke result = null;

		jsonReader.beginObject();

		while (jsonReader.hasNext()){

			if(jsonReader.nextName() == "type"){
				if(jsonReader.nextString() != "success"){
					throw new IOException("type was not success");
				}
			}

			if(jsonReader.nextName() == "value"){
				result = gson.fromJson(jsonReader, Joke.class);
			}
		}

		jsonReader.endObject();

		return result;

	}
}
