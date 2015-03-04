package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class threadStationSearch extends Thread {

	private Parser Par;
	private GUI minGUI;

	public threadStationSearch(Parser p, GUI g) {
		this.Par = p;
		this.minGUI = g;
	}

	public void run() {
		// som i testClass... Station
		ArrayList<Station> S = new ArrayList<Station>();
		S.addAll(Parser.getStationsFromURL(minGUI.textField.getText()));
		System.out.println(Parser.getStationsFromURL(minGUI.textField.getText()));
		for (Station St : S) {
			minGUI.textArea.append(St.getStationName() + "   StationnNummer: "
					+ St.getStationNbr() + "    latitud: " + St.getLatitude()
					+ "   longitude: " + St.getLongitude() + "\n");
		}
	}

}
