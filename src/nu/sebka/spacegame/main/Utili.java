package nu.sebka.spacegame.main;

import java.util.Random;

public class Utili {
	
	public static Random random = new Random();
	
	public static int chooseInt(int...ints){
		return ints[random.nextInt(ints.length)];
	}
	
	public static String chooseString(String...strings){
		return strings[random.nextInt(strings.length)];
	}
}
