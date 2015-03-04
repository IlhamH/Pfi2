package se.mah.k3lara.skaneAPI.view;
// Thread för sökning av resa
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
		
		
		String searchURL = Constants.getURL(minGUI.textFieldDestination.getText(),minGUI.textFieldPosition.getText(),1); //Malmö C = 80000,  Lund C, 81216 Malmö Gatorg 80100, Hässleholm C 93070, texten hämtas och "översätts" till "kod" 
		System.out.println(searchURL); // visar vilken URL det är, för tillfället fel, malmö C blir inte 8000
		System.out.println(" Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); //tolka information av alla möjliga resor från xml -- printa ut: Star- och slutstation, avgångstid,min kvar till avgånsttid och förseningstid
	
     	for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			
			
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			
			minGUI.textArea_1.append( "Från " + journey.getStartStation() + " till " + journey.getEndStation() + " avgår " + time +" , om "+journey.getTimeToDeparture()+ " min. Resan är  "+journey.getDepTimeDeviation()+" min försenad");

		//	minGUI.textArea_1.append(time + journey.getStartStation() + "" + journey.getEndStation());

		} 
		}
		
		
	}


