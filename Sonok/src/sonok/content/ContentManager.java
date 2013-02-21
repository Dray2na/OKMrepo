package sonok.content;

import java.util.ArrayList;

public class ContentManager {
	class Content {
		Page_Base page;
		ArrayList<String> keywords = new ArrayList<String>();
		
		public Content(Page_Base p, ArrayList<String> kw) {
			page = p;
			
			if (kw != null) {
				keywords = kw;
			}
		}
		
		public Content(Page_Base p) {
			page = p;
		}
	}

	ArrayList<Content> contents = new ArrayList<Content>();
}
