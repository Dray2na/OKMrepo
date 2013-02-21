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

		public boolean addKeyword(String e) {
			return keywords.add(e);
		}

		public void clearKeywords() {
			keywords.clear();
		}

		public boolean contains(Object o) {			
			for (int i = 0; i < keywords.size(); i++) {
				if (keywords.get(i).equals(o)) {
					return true;
				}
			}
			
			return false;
		}
		
	}

	ArrayList<Content> contents = new ArrayList<Content>();
}
