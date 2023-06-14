package server;

/**
 * This class generates word count.
 * 
 * @author hanis sorhana
 *
 */
public class Translation {

	
	/**
	 * This method generates word count.
	 * 
	 * @return word count
	 */
	public String getTranslate(String targetLanguage) {
		
		if (targetLanguage == "Bahasa Malaysia") {
			
			return "Terima Kasih";
		}
		else 
			
			return "error";
        
		
		
	}
	
}
