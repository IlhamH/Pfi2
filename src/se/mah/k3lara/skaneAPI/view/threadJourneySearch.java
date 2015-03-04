package se.mah.k3lara.skaneAPI.view;
// Thread f�r s�kning av resa
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class threadJourneySearch extends Thread{

	private Parser Par;
	private GUI minGUI;
	
	public threadJourneySearch(Parser p, GUI g){
		this.Par = p;
		this.minGUI = g;
	}
	
	public void run(){
		
		
		String searchURL = Constants.getURL(minGUI.textFieldDestination.getText(),minGUI.textFieldPosition.getText(),1); //Malm� C = 80000,  Lund C, 81216 Malm� Gatorg 80100, H�ssleholm C 93070, texten h�mtas och "�vers�tts" till "kod" 
		System.out.println(searchURL); // visar vilken URL det �r, f�r tillf�llet fel, malm� C blir inte 8000
		System.out.println(" Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); //tolka information av alla m�jliga resor fr�n xml -- printa ut: Star- och slutstation, avg�ngstid,min kvar till avg�nsttid och f�rseningstid
	
     	for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			
			
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			
			minGUI.textArea_1.append( "Fr�n " + journey.getStartStation() + " till " + journey.getEndStation() + " avg�r " + time +" , om "+journey.getTimeToDeparture()+ " min. Resan �r  "+journey.getDepTimeDeviation()+" min f�rsenad");

		//	minGUI.textArea_1.append(time + journey.getStartStation() + "" + journey.getEndStation());

		} 
		}
		
		
	}


