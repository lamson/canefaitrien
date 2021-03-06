/**
 * Universe class to generate planets from a list of names with random
 * coordinates within the area of the map
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

import android.graphics.Point;

/**
 * @author AN PHAM

 * 
 * @version $Revision: 1.0 $
 */
public class Universe {

	// Universe constants
	/**
	 * Field SHUFFLE_AMT.
	 * (value is 1000)
	 */
	/**
	 * Field HEIGHT.
	 * (value is 1150)
	 */
	/**
	 * Field WIDTH.
	 * (value is 720)
	 */
	public static final int WIDTH = 720, HEIGHT = 1150, SHUFFLE_AMT = 1000;

	/**
	 * Field BORDERTWO.
	 * (value is 40)
	 */
	/**
	 * Field BORDER.
	 * (value is 20)
	 */
	public static final int BORDER = 20, BORDERTWO = 40; // Min distance from
															// edge of screen

	/**
	 * Field HMINBORDERTWO.
	 */
	/**
	 * Field WMINBORDERTWO.
	 */
	public static final int WMINBORDERTWO = WIDTH - BORDERTWO,
			HMINBORDERTWO = HEIGHT - BORDERTWO;

	/**
	 * Field MIN_DISTANCE.
	 * (value is 5)
	 */
	public static final int MIN_DISTANCE = 5; // Min distance planet must be
												// from another planet

	/**
	 * Field TOTAL_PLANETS.
	 * (value is 50)
	 */
	public static final int TOTAL_PLANETS = 50; // Total planets to create

	/**
	 * Field RAND.
	 */
	private static final Random RAND = new Random();

	// Array of planet names
	/**
	 * Field PLANET_NAMES.
	 */
	private static final String PLANET_NAMES[] = { "Acamar", "Adahn", "Aldea",
			"Andevian", "Antedi", "Balosnee", "Baratas", "Brax", "Bretel",
			"Calondia", "Campor", "Capelle", "Carzon", "Castor", "Cestus",
			"Cheron", "Courteney", "Daled", "Damast", "Davlos", "Deneb",
			"Deneva", "Devidia", "Draylon", "Drema", "Endor", "Esmee", "Exo",
			"Ferris", "Festen", "Fourmi", "Frolix", "Gemulon", "Guinifer",
			"Hades", "Hamlet", "Helena", "Hulst", "Iodine", "Iralius", "Janus",
			"Japori", "Jarada", "Jason", "Kaylon", "Khefka", "Kira", "Klaatu",
			"Klaestron", "Korma", "Kravat", "Krios", "Laertes", "Largo",
			"Lave", "Ligon", "Lowry", "Magrat", "Malcoria", "Melina", "Mentar",
			"Merik", "Mintaka", "Montor", "Mordan", "Myrthe", "Nelvana", "Nix",
			"Nyle", "Odet", "Og", "Omega", "Omphalos", "Orias", "Othello",
			"Parade", "Penthara", "Picard", "Pollux", "Quator", "Rakhar",
			"Ran", "Regulas", "Relva", "Rhymus", "Rochani", "Rubicum", "Rutia",
			"Sarpeidon", "Sefalla", "Seltrice", "Sigma", "Sol", "Somari",
			"Stakoron", "Styris", "Talani", "Tamus", "Tantalos", "Tanuga",
			"Tarchannen", "Terosa", "Thera", "Titan", "Torin", "Triacus",
			"Turkana", "Tyrus", "Umberlee", "Utopia", "Vadera", "Vagra",
			"Vandor", "Ventax", "Xenon", "Xerxes", "Yew", "Yojimbo", "Zalkon",
			"Zuul" };

	/**
	 * Shuffles planet names to create random planets
	 * 
	 * @param planets
	 *            planet array
	 */
	public static void shuffle(String[] planets) {
		int index1, index2;
		String temp;
		for (int i = 0; i < SHUFFLE_AMT; i++) {
			index1 = RAND.nextInt(PLANET_NAMES.length);
			index2 = RAND.nextInt(PLANET_NAMES.length);
			temp = planets[index1];
			planets[index1] = planets[index2];
			planets[index2] = temp;
		}
	}

	/**
	 * Generates all of the planets in the universe
	 * 
	
	 * @return array of planets */
	public static Planet[] generate() {
		final Planet[] planets = new Planet[TOTAL_PLANETS];
		int x, y;
		final TechLevel[] levels = TechLevel.values();
		final Situation[] situations = Situation.values();
		// shuffles the planet names
		shuffle(PLANET_NAMES);
		// creates planets with random coordinates
		for (int i = 0; i < TOTAL_PLANETS; i++) {
			x = RAND.nextInt(WMINBORDERTWO) + BORDER;
			y = RAND.nextInt(HMINBORDERTWO) + BORDER;
			planets[i] = new Planet(PLANET_NAMES[i], new Point(x, y),
					levels[RAND.nextInt(levels.length)],
					situations[RAND.nextInt(situations.length)]);
		}
		// moves planets that are too close to each other
		validate(planets);
		return planets;
	}

	/**
	 * Checks to make sure no planets are too close, and moves them if they are
	 * 
	 * @param planets
	 *            array of planets
	 */
	public static void validate(Planet[] planets) {
		boolean isChecking = true, movedPlanet;
		Planet current;

		while (isChecking) {
			movedPlanet = false;
			// goes through all planets
			for (int i = 0; i < planets.length; i++) {
				current = planets[i];
				// compare current planet distance to all other planets
				for (int j = i + 1; j < planets.length; j++) {
					// if too close, create new location
					if (current.distance(planets[j]) < MIN_DISTANCE
							+ current.getRadius() + planets[j].getRadius()) {
						current.setCoordinates(new Point(RAND
								.nextInt(WMINBORDERTWO) + BORDER, RAND
								.nextInt(HMINBORDERTWO) + BORDER));
						movedPlanet = true;
						break;
					}
				}
				// if a planet was moved, start over (I know it's not efficient)
				if (movedPlanet) {
					break;
				}
			}
			// if no planet was moved, then universe is valid!
			if (!movedPlanet) {
				isChecking = false;
			}
		}
	}

	/**
	 * Method toString.
	 * @param planets Planet[]
	 * @return String
	 */
	public static String toString(Planet[] planets) {
		final StringBuffer ret = new StringBuffer();
		for (int i = 0; i < planets.length; i++) {
			ret.append(planets[i].toString());
		}
		return ret.toString();
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}