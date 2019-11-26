package ohm.softa.a06.model;

import com.google.gson.Gson;

public class Test {
	public static void main(String[] args) {
		Gson gson = new Gson();

		Joke j = new Joke();

		String json = gson.toJson(j);

		System.out.println(json);
	}
}
